/**
 * The purpose of this program is to demonstrate my knowledge of using stacks with arrays, if and else statements and methods to create an ArrayStack class.
 * File Name: ArrayStack
 * Date: Thursday, November 16, 2023
 * @author Siva Suresh
 * @param <T> specifies the type of data items that the stack is going to store.
 */
public class ArrayStack<T> implements StackADT<T>{
	/**
	 * declares an global array called array which stores data items of a type T.
	 */
	private T[] array;
	/**
	 * represents a particular index in the array where the user can add an element.
	 */
	private int top;
	 
	/** 
	 * This method creates an object of the ArrayStack class.
	 */
	public ArrayStack() {
		/**
		 * This line initializes the global array called array to allocate 10 spaces for the elements of type T.
		 */
		array= (T[]) new Object[10];
		/**
		 * This line initializes the top variable to -1.
		 */
		top= -1;
	}
	/**
	 * @param element is a particular data item of type T that is to be pushed or added onto the top of the stack or array.
	 * This method pushes or adds the a particular element of type T onto the top of the stack or array.
	 */
	public void push(T element)
	{
		
		if ((double)size()/getCapacity()>=0.75)
		{
			expandCapacity();
		}
		top++;
		array[top]= element;
	}
	/**
	 * This method removes and returns the item at the top of the stack or array. If the stack is empty this method throws an Stack Exception saying that the "Stack is empty" so it cannot pop.
	 * @return the data item removed at the top of the stack.
	 */
	public T pop() throws StackException
	{
		
		if (isEmpty()== true)
		{
			throw new StackException("Stack is empty");
		}
		else if ((double)size()/getCapacity()<=0.25 && getCapacity()>=20)
		{
			shrinkCapacity();
		}
		T result= array[top];
		array[top]= null;
		top--;
		return result;
		
	}
	/** 
	 * This method returns the data item at the top of the stack without removing. 
	 * @return the data item at the top of the stack.
	 */
	public T peek() throws StackException
	{
		if (isEmpty()== true)
		{
			throw new StackException("Stack is empty");
		}
		else
		{
			return array[top];
		}
	}
	/**
	 * This method determines whether the stack is empty or not.
	 * @return true to indicate that the stack is empty and false to indicate that the stack is not empty.
	 * 
	 */
	public boolean isEmpty()
	{
		if (size()== 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/** 
	 * This method returns the number of elements that is currently in the stack.
	 */
	public int size()
	{
		return top + 1;
	}
	/** 
	 * This method clears all the data items from the stack.
	 */
	public void clear()
	{
		array= (T[])new Object[10];
		top = -1;
	}
	/**
	 * This method returns the maximum number of elements that the array or stack can store up to.
	 * @return the number of elements that the array or stack can store up to.
	 */
	public int getCapacity()
	{
		return array.length;
	}
	/**
	 * This method returns the data item that is the currently at the top of the stack.
	 * @return the data item at the top of the stack.
	 */
	public int getTop()
	{
		return top;
	}
	/**
	 * Returns a String representation of the data items in the stack or array.
	 * @return a String representation of the data items in the stack or array.
	 */
	public String toString()
	{
		String output= "Stack: ";
		if (isEmpty()== true)
		{
			output= "Empty stack.";
			return output;
		}
		else
		{
			for (int i= top; i>-1; i--)
			{
				if (i== 0)
				{
					output=output + array[i] + ".";
				}
				else
				{
					output= output + array[i] + ", ";
				}
			}
		}
		return output;
	}
	/** 
	 * This method expands or allocates space for ten more elements if the number of elements in the array occupies 75% or more of the array's capacity or space.
	 */
	private void expandCapacity()
	{

		T [] newArray= (T[])(new Object[array.length + 10]);
		for (int i= 0; i<array.length; i++)
		{
			newArray[i]= array[i];
		}
		array= newArray;
		
	}
	/**
	 * This method removes 10 spaces for the elements in the array or stack when the number of elements occupies 25% of the array's capacity and when the capacity of the array is greater than or equal to 20.
	 */
	private void shrinkCapacity()
	{
		T[]newArray= (T[])new Object[getCapacity() - 10];
		for (int i= 0; i<newArray.length; i++)
		{
			newArray[i]= array[i];
		}
		array= newArray;
	}
	public static void main(String[]args) throws StackException
	{

//		num.push(12);
//		num.push(13);
//		num.push(14);
//		num.clear();
//		for (int i= 0; i<num.size(); i++)
//		{
//			System.out.println(num.array[i]);
//		}
		
	}
}
