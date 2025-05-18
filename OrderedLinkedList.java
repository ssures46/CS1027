/**
 * File Name: OrderedLinkedListClass.java
 * @author Siva Suresh
 * Purpose: The purpose of this program is to demonstrate my knowledge of using classes, object and ordering nodes in the Node linked list in descending order.
 * @param <T> represents a specific type of the data items that can be stored in OrderedLinkedList.
 */

public class OrderedLinkedList<T extends Comparable<T>>
{
	/**
	 * First node in the Node linked list.
	 */
	private Node<T> head;	
	/**
	 * represents the number of nodes in the Node linked list.
	 */
	private Integer size;
	
	/**
	 * This method creates and initializes the object of the OrderedLinkedList Class with no parameters.
	 */
	public OrderedLinkedList() 
	{
		/**
		 * The first node in the Node linked list is set to null and creates an empty node.
		 */
		head= null;
		/** 
		 * The number of nodes in the Node linked list is set 0.
		 */
		size= 0;
	}
	/**
	 * This method checks if two nodes contain the same value or not.
	 * @param n represents a specific node of type Node<T>.
	 * @param e represents a specific node of type Node<T>.
	 * @return true if the two nodes store the same data or false otherwise.
	 */
	private boolean compareTwoNodes(Node<T> n, Node<T> e)
	{
		return n.getData()==e.getData();
	}
	/**
	 * This method creates and stores a new node in the Node linked list in descending order.
	 * @param value represents a specific value for the new node to store.
	 */
	public void insert(T value)
	{
		Node<T> newNode= new Node<T>(value, null);
		Node<T> current= head;
		if (head== null)
		{
			head= newNode;
			size++;
		}
		else
		{

			while(true)
			{

				if (current== head && (newNode.getData().compareTo(current.getData())>0 || compareTwoNodes(newNode, current)== true))
				{

					newNode.setNext(current);
					head= newNode;
					size++;
					break;
				
				}
				if (current.getNext()== null)
				{
					current.setNext(newNode);
					size++;
					break;
				}
				if ((current.getData().compareTo(newNode.getData())>0 && newNode.getData().compareTo(current.getNext().getData())>0) || (compareTwoNodes(newNode, current)== true && compareTwoNodes(newNode, current.getNext())== true))
				{
					newNode.setNext(current.getNext());
					current.setNext(newNode);
					size++;
					break;
				}
				current= current.getNext();
			}
		}
		
	}	
//	}
	/**
	 * This method returns the i-th element in the OrderedLinkedList.
	 * @param i represents the specific index.
	 * @return the i-th element in the OrderedLinkedListClass.
	 */
	public T get(Integer i) 
	{

		Node<T> current= head;
		int j= 0;
		if (i<0 || i>=size)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			while (current!= null)
			{
				if (j==i)
				{
					break;
				}
				else
				{
					j++;
					current= current.getNext();
				}
			}
		}
		return current.getData();
	}
	/**
	 * This returns the number of nodes in the Node linked list.
	 * @return the number of nodes in the Node linked list.
	 */
	public int getSize()
	{
		return size;
	}
}
