package javacode;

/**
 * This class contains the helper function for arccos.
 * 
 * @author <a href="himansipatel1994@gmail.com">Himansi Patel</a>
 * @version 0.0.1
 */
public class HelperFunction {
  
  /**
   * This method calculate the value of PI.
   * 
   * @return value of pi
   */
  public double calculatePI() {
    double pi = 0.0;
    for (int k = 0; k < 9999; k++) {
      double numerator = calculatePower(-1, k);
      double denominator = (2 * k) + 1;
      double value = numerator / denominator;
      pi = pi + value;
    }
    pi = 4 * pi;
    return pi;
  }

  /**
   * This method calculate factorial of given number.
   * 
   * @param number number for calculate factorial
   * @return factorial value of given number
   */
  public double calculateFactorial(int number) {
    double fact = 1.0;
    if (number == 0) {
      fact = 1;
    } else {
      for (int j = 1; j <= number; j++) {
        fact = fact * j;
      }
    }
    return fact;
  }

  /**
   * This method calculate the power.
   * 
   * @param base - the base
   * @param exponent - the exponent
   * @return the power value(base^exponent)
   */
  public double calculatePower(double base, int exponent) {
    double power = 1.0;
    if (exponent == 0) {
      power = 1;
    } else {
      for (int i = 1; i <= exponent; i++) {
        power = base * power;
      }
    }
    return power;
  }
}
