package ch.admin.bar.siard2.cmd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import ch.enterag.utils.StopWatch;
import ch.enterag.utils.logging.IndentLogger;

public class SftpFileDownload
{
	private static IndentLogger log = IndentLogger
	    .getIndentLogger(SftpFileDownload.class.getName());

	private Session session = null;
	private Channel channel = null;
	private ChannelSftp channelSftp = null;
	private long getFileSize = 0;
	private long getDownloadTime = 0;
	private static long fileSize = 0;
	StopWatch sw = StopWatch.getInstance();

	public SftpFileDownload(String host, String userName, String password,
	    int port)
	{
		JSch jsch = new JSch();
		
		try
		{
			session = jsch.getSession(userName, host, port);
			session.setPassword(password);

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();

			channel = session.openChannel("sftp");
			channel.connect();
		}
		catch (JSchException e)
		{
			Exception loge = new Exception("SFTP 접속 실패했습니다. (" + host + ")");
			log.exception(loge);
			e.printStackTrace();
		}

		channelSftp = (ChannelSftp) channel;
	}

	public boolean upload(String dir, String filePath)
	{
		boolean result = true;
		FileInputStream in = null;
		try
		{
			File file = new File(filePath);
			String fileName = file.getName();
			// fileName = URLEncoder.encode(fileName,"EUC-KR");

			in = new FileInputStream(file);
			channelSftp.cd(dir);
			channelSftp.put(in, fileName);

		}
		catch (Exception e)
		{
			log.exception(e);
			e.printStackTrace();
			result = false;
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				log.exception(e);
				e.printStackTrace();
			}
		}

		return result;
	}

	public void download(String dir, String downloadFileName, String path)
	{
		InputStream in = null;
		FileOutputStream out = null;
		byte[] buffer = new byte[1024];
		try
		{
			channelSftp.cd(dir);
			in = channelSftp.get(downloadFileName);
		}
		catch (SftpException e)
		{
			System.err.println("SFTP ERROR 디렉토리나 파일을 찾을수 없습니다.(" + dir + ", "
			    + downloadFileName + ")");
			e.printStackTrace();
		}

		try
		{
			String dir_check = path.substring(0, path.lastIndexOf("\\"));

			File file_dir = new File(dir_check);

			if (file_dir.exists() == false)
			{
				file_dir.mkdirs();
			}

			out = new FileOutputStream(new File(path));
			int i;

			/* S: 현재 파일 전송속도 출력 */
			sw.start();
			/* E: 현재 파일 전송속도 출력 */

			while ((i = in.read(buffer)) != -1)
			{
				out.write(buffer, 0, i);
			}

			/* S: 현재 파일 전송속도 출력 */
			File file = new File(path);

			SftpFileDownload.fileSize = file.length(); // 파일크기
			getFileSize = SftpFileDownload.fileSize;

			System.out.println("  Current File Size "
			    + fileSizeToStr(SftpFileDownload.fileSize) + " ("
			    + sw.formatRate(SftpFileDownload.fileSize, sw.stop())
			    + " kB/s)");
			/* E: 현재 파일 전송속도 출력 */

			getDownloadTime = sw.stop();
		}
		catch (IOException e)
		{
			System.err.println("SFTP ERROR 파일을 저장할수 없습니다.(" + path + ")");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				out.close();
				in.close();
			}
			catch (IOException e)
			{
				log.exception(e);
				e.printStackTrace();
			}
		}
	}

	public void disconnection()
	{
		channelSftp.quit();
	}

	public long getFileSize()
	{
		return getFileSize;
	}

	public long getDownloadTime()
	{
		return getDownloadTime;
	}

	/* S: 파일크기 문자열 변환 */
	public String fileSizeToStr(long fileSize)
	{
		String fileSizeStr = "";
		int MB = 1024 * 1024; // 1Mb
		int KB = 1024; // 1Kb

		if (fileSize >= MB)
		{
			fileSizeStr = (fileSize / MB) + "Mb";
		}
		else if (fileSize >= KB)
		{
			fileSizeStr = (fileSize / KB) + "Kb";
		}
		else
		{
			fileSizeStr = fileSize + "Byte";
		}

		return fileSizeStr;
	}
	/* E: 파일크기 문자열 변환 */
}
