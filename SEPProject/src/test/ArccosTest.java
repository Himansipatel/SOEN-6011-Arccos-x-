package test;

import static org.junit.Assert.assertEquals;

import javacode.ArccosFunction;

import org.junit.Test;

/**
 * This is test class that performs testing on ArccosFunction.
 * 
 * @author <a href="himansipatel1994@gmail.com">Himansi Patel</a>
 * @version 0.0.1
 */
public class ArccosTest {

  private ArccosFunction arccosTestObj = new ArccosFunction();

  /**
   * This test function checks result for value outside domain range.
   */
  @Test
  public void testArccos1() {
    double calculatedArccos = arccosTestObj.arccos(3);
    double mathArccos = Math.acos(3);
    assertEquals(calculatedArccos, mathArccos, 0.00000005);
  }

  /**
   * This test function checks result for value outside domain range.
   */
  @Test
  public void testArccos2() {
    double calculatedArccos = arccosTestObj.arccos(-1.5);
    double mathArccos = Math.acos(-1.5);
    assertEquals(calculatedArccos, mathArccos, 0.00000005);
  }

  /**
   * This test function checks result for domain range value[-1,1].
   */
  @Test
  public void testArccos3() {
    double calculatedArccos = arccosTestObj.arccos(-0.9);
    double mathArccos = Math.acos(-0.9);
    double calculatedRoundedArccos = (double) Math.round(calculatedArccos * 100d) / 100d;
    double mathRoundedArccos = (double) Math.round(mathArccos * 100d) / 100d;
    assertEquals(calculatedRoundedArccos, mathRoundedArccos, 0.00000005);
  }

  /**
   * This test function checks result for domain range value[-1,1]. 
   * Special case for 1 
   */
  @Test
  public void testArccos4() {
    double calculatedArccos = arccosTestObj.arccos(-1);
    double mathArccos = Math.acos(-1);
    double calculatedRoundedArccos = (double) Math.round(calculatedArccos * 100d) / 100d;
    double mathRoundedArccos = (double) Math.round(mathArccos * 100d) / 100d;
    assertEquals(calculatedRoundedArccos, mathRoundedArccos, 0.00000005);
  }

  /**
   * This test function checks result for domain range value[-1,1].
   * special case for -1
   */
  @Test
  public void testArccos5() {
    double calculatedArccos = arccosTestObj.arccos(1);
    double mathArccos = Math.acos(1);
    double calculatedRoundedArccos = (double) Math.round(calculatedArccos * 100d) / 100d;
    double mathRoundedArccos = (double) Math.round(mathArccos * 100d) / 100d;
    assertEquals(calculatedRoundedArccos, mathRoundedArccos, 0.00000005);
  }

}
