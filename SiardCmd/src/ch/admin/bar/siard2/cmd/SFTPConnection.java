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

	// 원본 파일 사이즈
	public long sourceFileSize;
	public long executeTime;

	public SFTPConnection(String host, String user, String password, int port) {
		super();
		this.host = host;
		this.user = user;
		this.password = password;
		this.port = port;
	}

	public void download(FileDownloadModel fileDownloadModel){

		try {
			// TODO 최창근 추가 - 입력값이 잘못 되었을때 예외 메시지 출력해주기
			initSFTPConnection(fileDownloadModel);
		}catch(Exception e) {
			System.out.println("SFTP access information is incorrect.");
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

			// 시작시간
    	long startTime = System.currentTimeMillis();
    	System.out.println("File download - " + fileDownloadModel.getSourceFile());

			channelSftp.cd(sourceFilePath);
			channelSftp.get(fileDownloadModel.getSourceFile(), targetFileObj + File.separator + sourceFileObj.getName(), new MyProgressMonitor(), ChannelSftp.OVERWRITE);
			sourceFileSize = channelSftp.lstat(fileDownloadModel.getSourceFile()).getSize();

			// 종료시간
    	long endTime = System.currentTimeMillis();
    	// 수행시간 = 종료시간 - 시작시간
    	executeTime = endTime - startTime;

			System.out.println("File downloaded successfully - " + fileDownloadModel.getSourceFile());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				disConnection();
			}catch(Exception e) {

			}
		}

	}

	private void initSFTPConnection(FileDownloadModel fileDownloadModel) throws Exception{
		System.out.println();
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
			System.out.println();
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
			System.out.println("Download file end.");
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
