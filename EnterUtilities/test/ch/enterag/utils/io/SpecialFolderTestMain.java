package ch.enterag.utils.io;

import java.io.File;

public class SpecialFolderTestMain
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    File file = SpecialFolder.getMainJar();
    System.out.println(file.getAbsolutePath());
  }

}
