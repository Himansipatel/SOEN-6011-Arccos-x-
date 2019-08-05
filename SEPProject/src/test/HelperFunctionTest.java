package test;

import static org.junit.Assert.assertEquals;

import javacode.HelperFunction;

import org.junit.Test;

/**
 * This class performs test on helper function.
 * 
 * @author <a href="himansipatel1994@gmail.com">Himansi Patel</a>
 * @version 0.0.1
 */
public class HelperFunctionTest {

  private HelperFunction helperObj = new HelperFunction();

  /**
   * This test method checks the value of PI.
   */
  @Test
  public void testPI() {
    double calculatedPI = helperObj.calculatePI();
    double calculatedRoundedPI = (double) Math.round(calculatedPI * 100d) / 100d;
    double mathRoundedPI = (double) Math.round(Math.PI * 100d) / 100d;
    assertEquals(calculatedRoundedPI, mathRoundedPI, 0.00000005);
  }

  /**
   * This test method checks the value of Factorial.
   */
  @Test
  public void testFactorial() {
    double calculatedFactorial = helperObj.calculateFactorial(6);
    double mathFactorial = 720;
    assertEquals(calculatedFactorial, mathFactorial, 0.00000005);
  }

  /**
   * This test method checks the Power.
   */
  @Test
  public void testPower() {
    double calculatedPower = helperObj.calculatePower(3.5, 4);
    double mathPower = Math.pow(3.5, 4);
    assertEquals(calculatedPower, mathPower, 0.00000005);
  }

}
