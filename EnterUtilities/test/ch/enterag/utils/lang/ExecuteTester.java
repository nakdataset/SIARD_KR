package ch.enterag.utils.lang;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExecuteTester
{

  @Test
  public void testJavaVersion()
  {
    assertTrue("Runtime version is not less than 12!",Execute.isJavaVersionLessThan("12"));
    assertFalse("Runtime version is less than 9!",Execute.isJavaVersionLessThan("9"));
    assertFalse("Runtime version is less than 1.8!",Execute.isJavaVersionLessThan("1.8"));
  }

}
