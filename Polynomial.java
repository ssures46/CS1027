/**
 * File Name: Polynomial.java
 * @author Siva Suresh
 * Purpose: The purpose of this program is to demonstrate my knowledge of using linked lists, classes and objects to create an Polynomial class.
 * Date: Thursday, October 26, 2023
 */
public class Polynomial{
	/**
	 * polynomial is an OrderedLinkedList which is going to data types of Monomials.
	 */
	private OrderedLinkedList<Monomial> polynomial;
	/**
	 * This constructor initializes the new object of the Polynomial class.
	 */
	public Polynomial() {
		/**
		 * Creates an empty OrderedLinkedList called polynomial.
		 */
		polynomial= new OrderedLinkedList<Monomial> ();
	}
	
	/**
	 * This method adds coefficient and degree to the new object of the Monomial class. Then that Monomial object is added to the OrderedLinkedList, which is polynomial sorted in descending order of its degree.
	 * @param degree represents a specific degree for the object of the Polynomial class.
	 * @param coefficient represents a specific coefficient for the object of the Polynomial class.
	 */

	public void add(Integer coefficient, Integer degree)
	{
		Monomial n1= new Monomial(coefficient, degree);
		polynomial.insert(n1);
		
	}
	/** 
	 * This method finds the derivative of an object of a Polynomial class and returns that result as the new object of the Polynomial class.
	 * @return the derivative as the new object of the Polynomial class.
	 */
	public Polynomial derivative()
	{
		Polynomial p2= new Polynomial();
		for (int i= 0; i<polynomial.getSize(); i++)
		{	
			if (polynomial.get(i).getDegree()== 0)
			{
				return p2;
			}
			else
			{
				p2.add(polynomial.get(i).getCoefficient() * polynomial.get(i).getDegree(), polynomial.get(i).getDegree() - 1);
			}
		}
		return p2;
	}
	/**
	 * This method subs in a particular z value into the derivative of the polynomial function and returns that result.
	 * @param z a particular double value to be inputed into the derivative of the polynomial function.
	 * @return the result of inputing a particular z value into the derivative of the polynomial function.
	 */
	public double eval(double z)
	{
		double res= 0;
		for (int i= 0; i<polynomial.getSize(); i++)
		{
			res+= polynomial.get(i).getCoefficient() * Math.pow(z, polynomial.get(i).getDegree());
		}
		return res;	
	}
	/** 
	 * This method returns the String representation of the Polynomial object.
	 * @return the String representation of the Polynomial object.
	 */
	public String toString()
	{
		String result= "";
		for (int i= 0; i<polynomial.getSize(); i++)
		{

				if (i==0)
				{
					result+= polynomial.get(i).getCoefficient() + "*x^" + polynomial.get(i).getDegree();
				}
				else
				{
					if (polynomial.get(i).getCoefficient()>=0)
					{
						result+= " + " + polynomial.get(i).getCoefficient() + "*x^" + polynomial.get(i).getDegree();
					}
					if (polynomial.get(i).getCoefficient()<0)
					{
						Integer coefficient= Math.abs(polynomial.get(i).getCoefficient());
						result+= " - " + coefficient + "*x^" + polynomial.get(i).getDegree();
					}
				}
		}
		return result;
	}
	/**
	 * This method approximates root of the polynomial function and returns that result.
	 * @param x0 is the initial value.
	 * @param e tolerance of the solution. When the absolute difference between current and previous is less than or equal to e then this method will conclude whether the solution was found or not.
	 * @param T number of iterations if number of iterations exceeds T, then the method was not successful that it could not determine the approximate root of the polynomial. 
	 * @return the approximate root of the polynomial function.
	 * @throws SolutionNotFound
	 */
	public double solve(double x0, double e, Integer T) throws SolutionNotFound
	{
		double current= 0;
		double previous= x0;
		int count= 0;
		if (derivative().eval(previous)!= 0)
		{
			current= previous - (eval(previous)/derivative().eval(previous));
		}
		else
		{
			throw new SolutionNotFound("divide by zero error");
				
		}
		while(count!= T && Math.abs(current- previous)>e)
		{
			previous= current;
			if (derivative().eval(previous)!= 0)
			{
				current= previous - (eval(previous)/derivative().eval(previous));
			}
			else
			{

				throw new SolutionNotFound("divide by zero error");
			}
			count++;
		}

		if (count== T)
		{

			throw new SolutionNotFound("maximum iteration exceeded");
		}
		else
		{
			return current;
		}
	}
	

}
