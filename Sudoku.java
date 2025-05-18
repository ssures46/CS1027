/**
 * This class is a template used for creating objects of the Sudoku class. Each object of this class has its own specific size and grid, used for storing digits.
 * @author Siva Suresh
 * File Name: Sudoku.java
 * Date: Tuesday October 3, 2023
 */
public class Sudoku {
	/**
	 * size of the sudoku, which represents the number of rows and columns.
	 */
	private int size;
	/**
	 * An two dimensional array of int's holding all the digits in the sudoku or grid.
	 */
	private int[][]grid;
	
	/**
	 * Creates an object of the Sudoku class.
	 * @param numbers represents an two dimensional array of int's or grid. 
	 */
	public Sudoku(int [][] numbers) {
		/**
		 * An one dimensional array grid is initialized to an one dimensional array called numbers.
		 */
		grid= numbers;
		/**
		 * size is initialized to grid.length.
		 */
		size= grid.length;
	}
	/**
	* @return This method returns the instance variable size, which is the size of the grid.
	 */
	public int getSize()
	{
		return size;
		
	}
	/**
	 * @return the instance variable grid that is containing all the digits.
	 */
	public int[][] getGrid()
	{
		return grid;
	}
	/**
	 * This finds and returns a digit at a particular row and column.
	 * @param row represents a specific row in the sudoku.
	 * @param col represents a specific column in the sudoku.
	 * @return -1 if the row and col are out of range or otherwise returns the digits in the grid present at index row and index col.
	 */
	public int getDigitAt(int row, int col)
	{
		if (row<0 || col<0||row>=grid.length||col>=grid[0].length)
		{
			return -1;
		}
		else
		{
			return grid[row][col];
		}
	}
	/**
	 * This method checks if a digit at a particular column and row is valid by checking if they are between 1 (inclusive) and size (inclusive).
	 * @param row represents a specific row in the sudoku of this class.
	 * @param col represents a specific column in the sudoku of this class.
	 * @return true to indicate that the digit is valid at a particular row and column or otherwise returns false.
	 */
	private boolean checkNumberRange(int row, int col)
	{
		boolean check= false;
		if (getGrid()[row][col]>=1 && getGrid()[row][col]<=grid.length)
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
	 * This method checks if all the digits at a particular row is valid by checking if all the digits are from 1 to size (inclusive) without repeating.
	 * @param row represents a specific row in the sudoku.
	 * @return true to indicate digits at a particular row are valid and false to indicate that digits at a particular row are invalid.
	 */
	public boolean isValidRow(int row)
	{
		boolean check= false;
		
		if (row>=0 && row<size)
		{
			for(int i= 0; i<grid[row].length; i++)
			{
				for (int j= 0; j<grid[row].length; j++)
				{
					if (i== j)
					{
						continue;
					}
					else if (checkNumberRange(row, i)== true && checkNumberRange(row, j)==true)
					{
						/**
						 * If a digit in the sudoku is not equal to other digits in the same particular row.
						 */
						if (grid[row][i]!= grid[row][j])
						{
							check= true;
						}
						else
						{
							return false;
						}
					}
					else
					{
						check= false;
						return check;
					}
				}
	
			}
		}
		else
		{
			return false;
		}
		return check;
	}
	
	
	/**
	 * This method checks if digits at a particular column are valid by checking if the digits are between 1 (inclusive) and size (inclusive) without repeating.
	 * @param col represents a specific column in the sudoku.
	 * @return true to indicate that the digits at a particular column are valid and false to indicate that the digits are not valid. 
	 */
	public boolean isValidCol(int col)
	{
		boolean check= true;
		if (col<0 || col>=grid[0].length)
		{
			return false;
		}
		for (int i= 0; i<grid.length; i++)
		{
			for (int j= 0; j<grid.length; j++)
			{
				if (j== i)
				{
					continue;
				}
				else if (checkNumberRange(i, col)== true && checkNumberRange(j, col)== true)
				{
					if (grid[i][col]!= grid[j][col])
					{
						check= true;
					}
					else
					{
						check= false;
						return check;
					}
				}
				else
				{
					check= false;
					return check;
				}
			}
		}
		return check;
	}
	

	/**
	 * This method sorts an one dimensional array of int's in ascending order.
	 * @param numbers represents an one dimensional array, which stored values of int's.
	 * @return an one dimensional array of int's in ascending order.
	 */
	private int[] sortArrayInAscendingOrder(int[] temp)
	{
		int z;
		int[] numbers= temp;
		for (int i= 0; i<numbers.length; i++)
		{
			if (i== numbers.length - 1)
			{
				break;
			}
			for (int j= i + 1; j<numbers.length; j++)
			{
				/*
				 * If an integer in numbers is lesser than other 
				 */
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
     * This method checks if two arrays are equal by means if they share the same size and elements at the same position.
     * @param numbers represents an one dimensional array of int's.
     * @param numbers2 represents an one dimensional array of int's.
     * @return true to indicate that the two arrays are same and false to indicate they are not the same.
     */
	private boolean compareTwoArrays(int [] numbers, int []numbers2)
	{

		boolean check= false;
		if (numbers.length== numbers2.length)
		{
			for (int i= 0; i<numbers.length; i++)
			{
	
				if (numbers[i]== numbers2[i])
				{
					check= true;
				}
				else
				{
					check= false;
					return check;
				}
			}
		
		}
		return check;
	}
	
	
	/**
	 * For 9 by 9 sudoku, this method starts at a particular row and column this method checks and returns if a particular 3 by 3 box is valid by checking if all the digits are between 1 (inclusive) and size (inclusive) without repeating.
	 * @param row represents the top left row of a 3 by 3 box.
	 * @param col represents the top left column of a 3 by 3 box. 
	 * @return true to indicate that the 3 by 3 box is valid and false to indicate that the 3 by 3 box is invalid . 
	 */
	public boolean isValidBox(int row, int col)
	{
		boolean check= false; //Creates an variable called check of type boolean and initialize it to false.
		//
		if (row<0 || row>=7 || col<0|| col>=7)
		{
			return false;
		}
		else
		{
			/**
			 * Creates a new array of int's called numbersIn3By3Box, which stores the digits in the 3 by 3 box.
			 */
			int [] numbersIn3By3Box= new int [9]; 
			/**
			 * A variable counter is initialized to 0.
			 */
			int counter= 0; 
			int [] numbers= new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9}; //Creates an array called number which stores 9 integers.
			for (int i= row; i<row + 3; i++)
			{
				for (int j= col; j<col + 3; j++)
				{
					/**
					 * Populates numbersIn3By3Box array with the digits in 3 by 3 box starting .
					 */
					numbersIn3By3Box[counter]= grid[i][j];
					/**
					 * Increments the counter variable by one.
					 */
					counter++;
				}
			}
			/** A new array of int's called numbersIn3By3BoxInAscendingOrder is equal to the sorted array of numbersIn3By3Box in ascending order.
			 * 
			 */
			int []numbersIn3By3BoxInAscendingOrder= sortArrayInAscendingOrder(numbersIn3By3Box);
			/**
			 * This if statement checks if numbersIn3By3BoxInAscendingOrder and numbers are the same.
			 */
			if (compareTwoArrays(numbersIn3By3BoxInAscendingOrder, numbers)== true)
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
	 * This method checks if all the digits are valid in every column and row but not in a 3 by 3 box except for a 9 by 9 sized sudoku. 
	 * @return true for 9 by 9 sudoku if each row, column and 3 by 3 box contains digits from 1 (inclusive) to 9 (inclusive) without repeating or otherwise false. If the sudoku is not 9 by 9, this method would return true to indicate that all digits in every row and column are valid. 
	 */
	public boolean isValidSolution()
	{
		boolean check= false;
		if (size== 9)
		{
			for (int i= 0; i<size; i++)
			{

				if (i%3== 0)
				{
					if (isValidRow(i)==true && isValidCol(i)== true && isValidBox(i, i)== true)
					{
						check= true;
					}
					else
					{
						check= false;
						return check;
					}
				}
				else
				{
					if (isValidRow(i)==true && isValidCol(i)== true)
					{
						check= true;
					}
					else
					{
						check= false;
						return check;
					}
				}
			}
		}
		else
		{
			for(int i= 0; i<size; i++)
			{
				if (isValidRow(i)==true && isValidCol(i)== true)
				{
					check= true;
				}
				
				else
				{
					check= false;
					return check;
				}
			}
		}
		return check;
	}
	
	
	/**
	 * This method checks if the two objects of the Sudoku class are the same by checking if they both share the same grid size and same digits at the same position in the grid.
	 * @param other represents another object of this Sudoku class.
	 * @return true to indicate that the two objects of this class are equal and false to indicate that they are not equal.
	 */
	public boolean equals(Sudoku other)
	{
		boolean check= false;
		if (size== other.size)
		{
			for (int i= 0; i<grid.length; i++)
			{
				for (int j= 0; j<grid[0].length; j++)
				{
					if (grid[i][j]== other.grid[i][j])
					{
						check= true;
					}
					else
					{
						check= false;
						return check;
					}
				}
			}
		}
		else
		{
			return false;
		}	
		return check;
	}
	
	
	/**
	 * @return the representation of all the digits present in the Sudoku or grid for an particular object of this class.
	 */
	public String toString()
	{
		StringBuilder output= new StringBuilder();
		for (int i= 0; i<grid.length; i++)
		{
			for (int j= 0; j<grid[0].length; j++)
			{
				output.append(grid[i][j] + " ");
			}
			output.append("\n");
		}
		return output.toString();
	}	
		
}
	



