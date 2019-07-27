package javacode;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class calculates the value of arccos for the given number.
 * 
 * @author Himansi Patel
 */
public class ArccosFunction {

  /**
   * This method calculate the value of PI.
   * 
   * @return value of pi
   */
  public double calculatePI() {
    double pi = 0.0;
    for (int k = 0; k < 9999; k++) {
      double numerator = power(-1, k);
      double denominator = (2 * k) + 1;
      double value = numerator / denominator;
      pi = pi + value;
    }
    pi = 4 * pi;
    return pi;
  }

  /**
   * This method calculate arccosine of given number. If argument is from domain [-1,1], then return
   * the arc cosine of an angle in range of [0,pi] of a value([-1,1]) and return the value in range
   * of [0,pi]. If argument is from outside domain, then the result is NaN.
   * 
   * @param num the value whose arc cosine is to be returned.
   * @return the arccosine of the given number.
   */
  public double arccos(double num) {
    double partialResult = 0;
    if (num < -1 || num > 1) {
      return Double.NaN;
    } else {
      if (num == -1) {
        return 3.14159265;
      } else if (num == 1) {
        return 0;
      } else {
        for (int steps = 0; steps < 89; steps++) {
          // to calculate (2n)!
          double factNum = calculateFactorial(2 * steps);
          if (Double.isInfinite(factNum)) {
            break;
          }
          // to calculate 2^2n
          double powerDenom = power(2, (2 * steps));
          // calculate n!
          double factDenom = calculateFactorial(steps);
          // to calculate (c)^2 = (n!)^2
          double powerOfFactDenom = power(factDenom, 2);
          double numDenomA = (factNum / (powerDenom * powerOfFactDenom));
          // to calculate z^(2n+1)
          int exponent = (2 * steps) + 1;
          double powerNum = power(num, exponent);
          double numDenomB = powerNum / exponent;
          double numDenomAmulB = (numDenomA * numDenomB);
          partialResult = partialResult + numDenomAmulB;
        }
        double pivalue = calculatePI();
        double result = ((pivalue / 2) - partialResult);
        return result;
      }
    }
  }

  /**
   * This method calculate factorial of given number.
   * 
   * @param number number for calculate factorial
   * @return factorial value of given number
   */
  private double calculateFactorial(int number) {
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
  private double power(double base, int exponent) {
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

  /**
   * The main calling method of class.
   * 
   * @param args - the argument
   */
  public static void main(String[] args) {

    ArccosFunction arccosObj = new ArccosFunction();
    Scanner sc = new Scanner(System.in);
    boolean check = false;
    double inputNumber = 0;

    do {
      try {
        System.out.println("Enter a number to calculate Arccos(x):-");
        inputNumber = sc.nextDouble();
        check = false;
      } catch (InputMismatchException e) {
        check = true;
        System.out.println("Sorry,It is expecting any number !! ..");
      }
      sc.nextLine();
    } while (check);

    double result = arccosObj.arccos(inputNumber);
    System.out.println("Arccos(" + inputNumber + "):-" + result);
    sc.close();


  }

}
