package ch.admin.bar.siard2.cmd.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

import javax.xml.bind.DatatypeConverter;

public class HashProcess
{
	public String fileLocation = null;
	public BufferedWriter writer = null;

	public void doHashFolders(String rootFolder) throws Exception
	{
        File rootDirectory = new File(rootFolder);
        if (!rootDirectory.exists() || !rootDirectory.isDirectory()) {
            return;
        }

        fileLocation = rootFolder.replaceAll("\\\\", "/");
        if (fileLocation.endsWith("/") == false)
            fileLocation = fileLocation + "/";

		File siardText = new File(fileLocation + "SIARD-HASH.txt");
		writer = new BufferedWriter(new FileWriter(siardText, false));

		try {
			Files.walk(rootDirectory.toPath())
			 	.sorted(Comparator.naturalOrder())
				 	.map(Path::toFile)
					 	.forEach((file) -> {
					 		if (file.isFile() && !"SIARD-HASH.txt".equals(file.getName())) {
								try {
									String filePaths = file.getPath();
									filePaths = filePaths.replaceAll("\\\\", "/");
									filePaths = filePaths.replaceAll(fileLocation, "/");
									
									writer.append(filePaths);
									writer.append("\t");
									writer.append(DatatypeConverter.printHexBinary(HashAction.SHA512.checkSum(file)));
									writer.newLine();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					 		}
					 	});
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		writer.close();
	}
}
