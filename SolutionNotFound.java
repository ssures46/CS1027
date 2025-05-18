/**
 * File Name: SolutionNotFound.java
 * @author Siva Suresh
 * Purpose: The purpose of this program is to demonstrate my knowledge of using exceptions and inheritance to create this class.
 * Date: Thursday, October 26, 2023
 */
public class SolutionNotFound extends Exception {
	/**
	 * Creates an object of SolutionNotFound
	 * @param message
	 */
	public SolutionNotFound(String message) {
		super(message);
	}
}
