/**
 * This class inherits all the properties from Sudoku class and implements additional method to check that the digits in either in the left or right diagonal are valid. 
 * @author Siva Suresh
 * File Name: UniqueDiagonalSudoku.java
 * @
 * Date: Thursday October 5, 2023
 */
public class UniqueDiagonalSudoku extends Sudoku
{

	public UniqueDiagonalSudoku(int [][]numbers) {
		super(numbers);
	}

	
	/**
	 * This method compares if two arrays are the same by comparing their size and checking if they both contain the same digits at the same position.
	 * @param n1 represents an one dimensional array of int's.
	 * @param n2 represent an one dimensional array of int's.
	 * @return true to indicate that two arrays are the same and false to indicate that they are not the same.
	 */
	private int[] arrayOfNumbers()
	{
		int current= 1;
		int[]numbers= new int[getSize()];
		for(int i= 0; i<numbers.length; i++)
		{
			numbers[i]= current;
			current++;
		}
		return numbers;
	}
	/**
	 * This checks if the two arrays are equal by means they share the same size and same elements at the same position.
	 * @param n1 represents an one dimensional array of int's.
	 * @param n2 represents an one dimensional array of int's.
	 * @return true to indicate that the two arrays are equal and false to indicate that they are not equal.
	 */
	private boolean compareTwoArrays(int []n1, int []n2)
	{
		boolean check= false; //A variable called check of type boolean is equal to false.
		for (int i= 0; i<n2.length; i++)
		{
			if (n1[i]== n2[i])
			{
				check= true;
			}
			else
			{
				check= false;
				return check;
			}
			
		}
		return check;
	}
	/**
	 * This methods orders and returns the array of int's in ascending order.
	 * @param temp represent a one dimensional array of int's which is to be sorted in ascending order.
	 * @return the ascending order of an array.
	 */
	private int[] sortArrayInAscendingOrder(int[]temp)
	{
		int z; //Creates an new variable called z of type int.
		int []numbers= temp; // An array of int's called numbers is initialized to the one dimensional array temp.
		for (int i= 0; i<numbers.length; i++)
		{
			if (i== numbers.length - 1) // If this condition is true, the program goes inside this condition and immediately terminates the for loop.
			{
				break;
			}
			for (int j= i + 1; j<numbers.length; j++)
			{
				if (numbers[j]<numbers[i])
				{	
					z= numbers[i];
					numbers[i]= numbers[j];
					numbers[j]= z;
				}
			}
		}
		return numbers;
	}
	/** 
	 * This method checks if all the digits in the left diagonal of the sudoku are valid by checking if they are between 1 (inclusive) to size (inclusive) without repeating.
	 * @return true to indicate that all the digits in the left diagonal of sudoku are valid and false to indicate that digits are not valid.
	 */
	private boolean checkingLeftDiagonalOfSudoku()
	{
		boolean check= false;
		int [] numbers= arrayOfNumbers();
		
		int row= 0;
		int column= 0;
		int [] digitsInLeftDiagonalOfSudoku= new int[getSize()];
		int counter= 0;
		for(int i= 0; i<getGrid().length; i++)
		{
			/**
			 * Populates the digitsInLeftDiagonalOfSudoku with digits in the left diagonal of the sudoku.
			 */
			digitsInLeftDiagonalOfSudoku[counter]= getGrid()[row + i][column + i];
			/**
			 * counter variable is incremented by one.
			 */
			counter++;
		}
		int[]digitsInLeftDiagonalOfSudokuInAscendingOrder= sortArrayInAscendingOrder(digitsInLeftDiagonalOfSudoku);
		
		if (compareTwoArrays(digitsInLeftDiagonalOfSudokuInAscendingOrder, numbers)== true)
		{
			check= true;
		} 
		else
		{
			check= false;
			return check;
		}
		return check;
	}
	
	/**
	 * This method checks if all the digits in the right diagonal of the sudoku are valid by checking if they are between 1 (inclusive) and size(inclusive) without repeating.
	 * @return true to indicate that the digits in the right diagonal of the sudoku are valid and false to indicate that the digits are not valid.
	 * 
	 */
	private boolean checkingRightDiagonalOfSudoku()
	{
		boolean check= false; //Creates an variables called check of type boolean and initialize to false.
		/**
		 * This line holds all the digits in the left diagonal of the sudoku.
		 */
		int []digitsInRightDiagonalOfSudoku= new int[getSize()]; 
		int [] numbers= arrayOfNumbers(); //An array called number of int's is equal to the value that arrayOfNumbers() return.
		int row= getSize() - 1; //row is initialized to the row of the grid or sudoku.
		int col= 0; //A variable called col is initialized to 0.
		int counter= 0; //A variable called counter is initialized to 0.
		for (int i= 0; i<=row; i++)
		{
			/**
			 * Populates the digitsInRightDiagonalOfSudoku with the digits in the right diagonal of the sudoku.
			 */
			digitsInRightDiagonalOfSudoku[counter]= getGrid()[row - i][col+i];
			/**
			 * increments the counter variable by one.
			 */
			counter++; 
		}
		/**
		 *  An one dimensional digitInRightDiagonalOfSudokuInAscendingOrder is initialized to the an array of int's containing the digits in the right diagonal.
		 */
		int[] digitsInRightDiagonalOfSudokuInAscendingOrder= sortArrayInAscendingOrder(digitsInRightDiagonalOfSudoku);//Creates an array of ints called temp1 is equal to the value that sortArray(temp) returns.
		if (compareTwoArrays(digitsInRightDiagonalOfSudokuInAscendingOrder, numbers)== true) 
		{
			check= true;
		}
		else
		{
			check= false;
			return check;
		}
		return check;
	}

	
	
		
	
	@Override
	/**
	 * This method checks if the isValidSolution from the parent class is true and right or left diagonal of the sudoku contain valid digits.
	 * @return true to indicate that isValidSolution() is true and left or right diagonal contain valid digits.
	 */
	public boolean isValidSolution()
	{
		/**
		 * This line checks if isValidSolution() is equal to true. 
		 * 
		 */
		if (super.isValidSolution()== true)
		{
			if (checkingLeftDiagonalOfSudoku()== true || checkingRightDiagonalOfSudoku()== true)
			{
				return  true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
		
	}

}

	
