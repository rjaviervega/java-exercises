import java.util.*;

/*
* Java: String Manipulation Samples
* =================================
* 
* These class implements a list of string manipulation functions good
* for learning JAVA purposes, and to practice basic math. 
* 
* - R. Javier Vega
*
*/

public class MathExercises 
{
	public static void main (String args[])
	{
		System.out.println("Math Exercises in Java");		
		System.out.println("======================");
		System.out.println("");
		
		// Matrix Sample
		//
		System.out.println("Matrix:");

		int n = 6;
		int[][] matrix = new int[n][n];
		
		// Fill Matrix with Integers
		for (int i=0; i<n; i++) 
			for (int j=0; j<n; j++) 
				matrix[i][j] = i*n+j+1; 
		//
		printMatrix(matrix, n);
		System.out.println("");
		
		System.out.println("Rotated 90 Right:");
		printMatrix(rotateMatrixToRight(matrix, n), n);
		
		System.out.println("");
		System.out.println("Rotated 90 Left:");
		printMatrix(rotateMatrixToLeft(matrix, n), n);		
		System.out.println("");
		//
		
		
		// Sum of Numbers
		//
		System.out.println("Given Array of numbers, check if sum of any two add to X");
		System.out.println("========================================================");
		
		int[] nums = new int[10];
		for (int i=0; i<10; i++) nums[i] = i;
		
		printNumArrayThatSumToValue(nums, 5);
		System.out.println("");
		
		
		System.out.println("Numbers from 1 to 50 divisible by 3, 5 and 3 and 5");
		System.out.println("===================================================");
		numsDivBy3And5();
		System.out.println("");
		System.out.println("");
		
		System.out.println("Print Minimum Change of Bills in USD");
		System.out.println("====================================");
		System.out.println("Bill Change for $286.84 USD");
		moneyChange(286.84);
		System.out.println("");
		System.out.println("Bill Change for $4729.21 USD");
		moneyChange(4729.21);
			
			
		
	}
	
	
	
	//
	// Print NxN Matrix
	//	
	public static void printMatrix(int[][] matrix, int n) 
	{
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (j>0) System.out.print("|");
				System.out.printf("%02d",matrix[i][j]); 
			}
			System.out.println("");
		}		
	}	
	
	
	
	//
	// Rotate NxN Matrix 90 degrees to Right
	//	
	public static int[][] rotateMatrixToRight(int[][] matrix, int n)
	{
		int[][] rotated = new int[n][n];
		
		for (int i=0; i<n; i++) 
			for (int j=0; j<n; j++) 
				rotated[j][n-1-i] = matrix[i][j];
		
		return rotated;
	}
	
	
	//
	// Rotate NxN Matrix 90 degrees to Left
	//
	public static int[][] rotateMatrixToLeft(int[][] matrix, int n)
	{
		int[][] rotated90Left = new int[n][n];
	
		for (int i=0; i<n; i++) 
			for (int j=0; j<n; j++) 
					rotated90Left[n-1-j][i] = matrix[i][j];

		return rotated90Left;
	}
	

	
	//
	// For a given array of numbers, check if any two number
	// sums to *sum* and print the combination.
	// This algorithm uses a HashMap to hash the sum differences
	// and print the pairs. This algorithm uses O(N) because of the hash.
	// A solution that iterates over every number would be O(n^2).
	//
	public static void printNumArrayThatSumToValue(int[] nums, int sum)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		System.out.print("Numbers: ");
		for (int i=0; i<nums.length; i++) System.out.print(""+i+", ");
		System.out.println("");
		
		System.out.println("Pairs that sum to: "+sum);
		
		for (int i=0; i<nums.length; i++) {
			// Compute difference for every number and hash it
			int diff = sum - i;
			if (diff>0)
				map.put(diff, diff);
		}
		
		// For every number check if there is an equivalent value
		for (int i=0; i<nums.length; i++) {
			if (map.get(sum-i)!=null) {
				System.out.println("Sum: "+i+" + " + map.get(sum-i));
			}
		}
	}
	
	
	//
	// Iterate over a list of numbers and print
	// numbers divisible by 3, 5 and by both.
	//
	public static void numsDivBy3And5()
	{
		System.out.print("Div by 3: ");		
		for (int i=1; i<30; i++) {
			if (i%3==0) System.out.print(i +", ");			
		}			
		System.out.println("");
		
		System.out.print("Div by 5: ");
		for (int i=1; i<30; i++) {
			if (i%5==0) System.out.print(i +", ");			
		}
		System.out.println("");
		
		System.out.print("Div by 3 & 5: ");			
		for (int i=1; i<30; i++) {
			if (i%3==0 && i%5==0) System.out.print(i +", ");			
		}
	}
	
	
	//
	// Given a dollar amount, break it down to 
	// smaller number of bills & coins. 
	// (1, 5, 10, 50, 100 USD Bills)
	// (1, 5, 10, 25 Cents Coins)
	//
	public static void moneyChange(double bills)
	{
		int hu, fif, tw, tend, fi, one;
		double quarters, dimes, nickels, pennies;
		
		hu   	   = (int) bills / 100;
		fif  	   = (int) (bills%100)/50;
		tw   	   = (int) ((bills%100)%50)/20;
		tend 	   = (int) (((bills%100)%50)%20)/10;
		fi   	   = (int) ((((bills%100)%50)%20)%10)/5;
		one  	   = (int) (((((bills%100)%50)%20)%10)%5)/1;
		quarters   = Math.floor((bills - (hu*100+fif*50+tw*20+tend*10+fi*5+one))/0.25);
		dimes      = Math.floor((double) ((bills%100%50%20%10%5%1%0.25)/0.10));		
		nickels    = Math.floor((double) ((bills%100%50%20%10%5%1%0.25%0.10)/0.05));		
		pennies    = Math.round((double) ((bills%100%50%20%10%5%1%0.25%0.10%0.05)/0.01));
		
		System.out.println("Hundreds:"+hu+", Fifties:"+fif+", Twenties:"+ tw + ", Tens:" + tend + ", Fives:"+ fi + ", Ones: "+one);
		System.out.println("Quarters:"+quarters+", Dimes:"+dimes+", Nickels:"+ nickels + ", Pennies:" + pennies);
		
	}
	
	

	
}
