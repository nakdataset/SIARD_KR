package ch.admin.bar.siard2.cmd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SiardFileLocalSave
{
	public void filecopy(File org, File target)
	{
		// File temp = new File(target.getAbsolutePath() + File.separator +
		// org.getName());
		// File temp = target;

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try
		{
			String path = target.getAbsolutePath();
			System.out.println("path=" + path);
			String dir_check = path.substring(0, path.lastIndexOf("\\"));
			System.out.println("dir_check=" + dir_check);

			File file_dir = new File(dir_check);

			if (file_dir.exists() == false)
			{
				file_dir.mkdirs();
			}

			fis = new FileInputStream(org);
			fos = new FileOutputStream(target);

			byte[] b = new byte[4096];
			int cnt = 0;
			while ((cnt = fis.read(b)) != -1)
			{
				fos.write(b, 0, cnt);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
				fos.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
