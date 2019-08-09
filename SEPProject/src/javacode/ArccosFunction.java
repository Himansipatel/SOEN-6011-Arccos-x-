package javacode;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class calculates the value of arccos.
 * 
 * @author <a href="himansipatel1994@gmail.com">Himansi Patel</a>
 * @version 0.0.1
 */
public class ArccosFunction {

  /**
   * This method calculate arccosine of given number. If argument is from domain [-1,1], then return
   * the arc cosine of an angle in range of [0,pi] of a value([-1,1]) and return the value in range
   * of [0,pi]. If argument is from outside domain, then the result is NaN.
   * 
   * @param num the value whose arc cosine is to be returned.
   * @return the arccosine of the given number.
   */
  public double arccos(double num) {
    HelperFunction helperObj = new HelperFunction();
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
          double factNum = helperObj.calculateFactorial(2 * steps);
          if (Double.isInfinite(factNum)) {
            break;
          }
          // to calculate 2^2n
          double powerDenom = helperObj.calculatePower(2, (2 * steps));
          // calculate n!
          double factDenom = helperObj.calculateFactorial(steps);
          // to calculate (c)^2 = (n!)^2
          double powerOfFactDenom = helperObj.calculatePower(factDenom, 2);
          double numDenomA = (factNum / (powerDenom * powerOfFactDenom));
          // to calculate z^(2n+1)
          int exponent = (2 * steps) + 1;
          double powerNum = helperObj.calculatePower(num, exponent);
          double numDenomB = powerNum / exponent;
          double numDenomAmulB = (numDenomA * numDenomB);
          partialResult = partialResult + numDenomAmulB;
        }
        double pivalue = helperObj.calculatePI();
        double result = ((pivalue / 2) - partialResult);
        return result;
      }
    }
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
        System.err.println("Sorry,input is expecting any real number !! ..");
      }
      sc.nextLine();
    } while (check);

    double result = arccosObj.arccos(inputNumber);
    System.out.println("Arccos(" + inputNumber + ") = " + result + " rad");
    sc.close();

  }

}
