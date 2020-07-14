package ch.enterag.utils.configuration;

import java.util.*;
import org.junit.*;

public class ManifestAttributesTester
{
  private ManifestAttributes _mf;
  
  @Before
  public void SetUp()
  {
    _mf = ManifestAttributes.getInstance();
  }
  @Test
  public void testGetBuiltDate()
  {
    Calendar cal = _mf.getBuiltDate();
    System.out.println(cal.getTime().toString());
  }

}
