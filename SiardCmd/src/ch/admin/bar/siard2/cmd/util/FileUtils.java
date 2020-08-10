package ch.admin.bar.siard2.cmd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileUtils {

	public void copy(String sourceFile, String targetFilePath) {
		File sourceFileObj = new File(sourceFile);
		File targetFilePathObj = new File(targetFilePath);

		if(!sourceFileObj.exists()) {
			return;
		}

		if(!targetFilePathObj.exists()) {
			targetFilePathObj.mkdirs();
		}

		FileInputStream fis = null;
		FileOutputStream fos = null;

		FileChannel fcin = null;
		FileChannel fcout = null;

		try {
			fis = new FileInputStream(sourceFileObj);
			fos = new FileOutputStream(targetFilePath + File.separator + sourceFileObj.getName());

			fcin = fis.getChannel();
			fcout = fos.getChannel();

			long size = fcin.size();
			fcout.transferFrom(fcin, 0, size);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {if(fcout != null) fcout.close();} catch (IOException ioe) {}
			try {if(fcin != null) fcin.close();} catch (IOException ioe) {}
			try {if(fos != null) fos.close();} catch (IOException ioe) {}
			try {if(fis != null) fis.close();} catch (IOException ioe) {}
		}
	}

}