package ch.admin.bar.siard2.cmd;

import java.io.File;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpProgressMonitor;

import ch.admin.bar.siard2.api.primary.FileDownloadModel;

public class SFTPConnection{

	private String host;
	private String user;
	private String password;
	private int port;

	private JSch jsch;
	private Session session;
	private Channel channel;
	private ChannelSftp channelSftp;

	public SFTPConnection(String host, String user, String password, int port) {
		super();
		this.host = host;
		this.user = user;
		this.password = password;
		this.port = port;
	}

	public void download(FileDownloadModel fileDownloadModel){
		long startTime = 0;
		long estimatedTime = 0;
		startTime = System.currentTimeMillis();

		try {
			// TODO 최창근 추가 - 입력값이 잘못 되었을때 예외 메시지 출력해주기
			initSFTPConnection(fileDownloadModel);
		}catch(Exception e) {
			System.out.println("SFTP 접근정보가 잘못되었습니다.");
			// e.printStackTrace();
		}

		try {
			channelSftp.stat(fileDownloadModel.getSourceFile()); // => No such file
		}catch(Exception e) {
			try {
				disConnection();
			}catch(Exception ee) {

			}
			return;
		}

		try {

			String sourceFilePath = fileDownloadModel.getSourceFile().substring(0, fileDownloadModel.getSourceFile().lastIndexOf("/") + 1);
			File sourceFileObj = new File(fileDownloadModel.getSourceFile());
			File targetFileObj = new File(fileDownloadModel.getTargetFile() + File.separator + sourceFilePath);

			if(!targetFileObj.exists()) {
				targetFileObj.mkdirs();
			}

			channelSftp.cd(sourceFilePath);
			channelSftp.get(fileDownloadModel.getSourceFile(), targetFileObj + File.separator + sourceFileObj.getName(), new MyProgressMonitor(), ChannelSftp.OVERWRITE);

			System.out.println("sourceFileObj File downloaded successfully - " + fileDownloadModel.getSourceFile());
			System.out.println("targetFileObj File downloaded successfully - " + targetFileObj.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				disConnection();
			}catch(Exception e) {

			}
		}

		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("execute time(ms) : " + estimatedTime);
	}

	private void initSFTPConnection(FileDownloadModel fileDownloadModel) throws Exception{
		System.out.println("connecting... " + host);

		jsch = new JSch();
		session = jsch.getSession(user, host, port);
		session.setConfig("StrictHostKeyChecking", "no");
		session.setPassword(password);
		session.connect();
		channel = session.openChannel("sftp");
		channel.connect();
		channelSftp = (ChannelSftp) channel;
	}

	private void disConnection() throws Exception{
		if (session.isConnected()) {
			System.out.println("disconnecting... " + session.getHost());
			channelSftp.disconnect();
			channel.disconnect();
			session.disconnect();
		}
	}

	class MyProgressMonitor implements SftpProgressMonitor {
        long count = 0; //The total number of bytes currently received
        long max = 0; //final file size
        long percent = -1; //progress
		/**
		          * When each time a data block is transferred, the count method is called, and the parameter of the count method is the data block size of this time.
		*/
		@Override
		public boolean count(long count) {
		   this.count += count;
		   if (percent >= this.count * 100 / max) {
		       return true;
		   }
		   percent = this.count * 100 / max;
		   System.out.println("Completed " + this.count + "(" + percent + "%) out of " + max + ".");
		   return true;
		}
		/**
		          * When the transfer ends, call the end method
		*/
		@Override
		public void end() {
		   System.out.println("Transferring done.");
		}
		/**
		          * When the file starts to transfer, call the init method
		*/
		@Override
		public void init(int op, String src, String dest, long max) {
		   if (op == SftpProgressMonitor.GET) {
		       System.out.println("Download file begin.");
		   }

		   this.max = max;
		   this.count = 0;
		   this.percent = -1;
		}
	}

}
