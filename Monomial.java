/**
 * The purpose of this program is to demonstrate my knowledge of using classes, objects, getter and setter methods to create Monomial class.
 * @author Siva Suresh
 * File Name: Siva Suresh
 * Date: Thursday, October 26, 2023
 */
public class Monomial implements Comparable<Monomial>{
	/**
	 * represents a specific coefficient for the object of an Monomial class.
	 */
	private Integer coefficient;
	/**
	 * represents a specific degree for the object of the Monomial class.
	 */
	private Integer degree;
	/**
	 * This method creates the object of the Monomial class.
	 * @param coefficient represents a specific coefficient of the object of the Monomial class.
	 * @param degree represents a specific degree of the object of the Monomial class. 
	 */
	public Monomial(Integer coefficient, Integer degree) {
		this.coefficient= coefficient;
		this.degree= degree;
	}
	/**
	 * This method returns the coefficient for the object of an Monomial class.
	 * @return the coefficient for the object of an Monomial class.
	 */
	public Integer getCoefficient()
	{
		return coefficient;
	}
	/** 
	 * This method returns the degree for the object of an Monomial class.
	 * @return degree for the object of an Monomial class.
	 */
	public Integer getDegree()
	{
		return degree;
	}
	/**
	 * This method compares the degree of the current object of the Monomial class to the degree of an another object of a Monomial class.
	 * @param m is a particular object of Monomial class.
	 * @return 0 to indicate that the degree of the current object is equal to the degree of the other object of the Monomial class. Returns negative to indicate that the degree of the current object is lesser than the degree of the other object of the Monomial class. Returns positive to indicate that the current object of the Monomial class is greater than the degree of the other object of the Monomial class.  
	 */
	public int compareTo(Monomial m)
	{
		return this.degree - m.degree;
	}
}
