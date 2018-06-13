package hw5;
/**
 * 
 * @author Jacob
 * 1.	Write a Java program that exposes Java’s rule for operand evaluation order when one of the operands is a method call? 
 * [20 pts] And put your conclusion as Java comment in the program. [10 pts] [OC-1-h] 
 *
 */

public class operand {
	static int test (int x) {
		x = x + 5;
		return x*4;
		
	}
	public static void main(String[] args) {
		int a = 6, b = 10,sum1,sum2;
		
		sum1 = (a/2) + test(a); // should equal 3 + 44
		sum2= test(b) + (b/2); // should equal 60 + 5
		
		System.out.println("sum 1= "+sum1+" sum 2= "+sum2);
		
	}
	/**
	 *  In java operands are evaluated from left to right as long as it does not violate precedence  and associativity.
	 *  The function does not make changes to the value of the parameter passed it only makes a new copy of the variable.
	 * 
	 */
	

}
