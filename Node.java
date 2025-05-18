/**
 * File Name: Node.java
 * @author Siva Suresh
 * Purpose: The purpose of this program is to demonstrate my knowledge of using classes, objects and singly linked lists to make a class called Node.java.
 * Date: Thursday, October 26, 2023
 * @param <T> represents the generic type of the Node
 */
public class Node<T> {
	/**
	 * Data to be added for the object of the Node class
	 */
	private T data;
	/**
	 *  Is the pointer to the current node of the object of this class.
	 */
	private  Node<T> next;
	/**
	 * This constructor method creates and initializes the object of the Node class.
	 * @param data represents a specific data item to be sent as the first argument when creating the object of this class.
	 * @param next represents the specific node to be sent in as the second argument when creating the object of this class.
	 */
	public Node(T data, Node<T> next) 
	{
		this.data= data;
		this.next= next;
		
	}
	/**
	 * This method returns the data that is stored in a specific node in the Node linked list.
	 * @return the data stored in a specific node in the Node linked list.
	 */
	public T getData()
	{
		return this.data;
	}
	/** 
	 * This method returns the node that the current node of the object of this class points to.
	 * @return the node that the current node points to.
	 */
	public Node<T> getNext()
	{
		return this.next;
	}
	/** 
	 * This method changes the node that the current node of the object of this class points to.
	 * @param node represents a specific node for the current node of the object of this class to point to.
	 */
	public void setNext(Node<T> node)
	{
		this.next= node;
	}
}
