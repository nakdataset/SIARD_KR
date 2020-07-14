package ch.enterag.utils.io;

import static org.junit.Assert.*;

import java.io.*;
import org.junit.*;
import ch.enterag.utils.lang.*;

public class SpecialFolderTester {

  @Test
  public void testFindInPath() 
  {
    String sFile = "edit";
    if (Execute.isOsLinux())
      sFile = "nano";
    else if (Execute.isOsWindows())
      sFile = "Notepad.exe";
    else
    	  sFile = "chown";
    File file = SpecialFolder.findInPath(sFile);
    if (file != null)
      System.out.println(file.getAbsolutePath());
    else
      fail(sFile + " not found!");
    
  }

}
