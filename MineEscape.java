/**
 * File Name: MineEscape.java
 * The purpose of this program is to demonstrate my understanding of using stacks with arrays and if else statements to determine the best path for the person to walk out the mine.  
 * @author Siva Suresh
 * Date: Thursday, November 15, 2023
 */
public class MineEscape {
	/**
	 * map variable represent
	 */
	private Map map;
	/**
	 * This line declares a global variable called numGold of type int to keep track of the number of gold that the person has collected while walking out the mine.
	 */
	private int numGold;
	/**
	 * This line declares the numKeys global array, which stores elements of type int. Index 0 stores the number red keys that the person has collected while walking out of the mine. Index 1 stores the number of green keys that the person has collected while walking out the mine. Index 2 stores the number of blue keys that the person has collected while walking out the mine.
	 */
	private int[] numKeys;
	/**
	 * This method creates an object of the MineEscape class.
	 * @param filename represents a particular file that is going to be sent in while creating an object of this class.
	 */
	public MineEscape(String filename) {
		try
		{
			map= new Map(filename);
			numGold= 0;
			numKeys= new int[3];
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This method finds and returns the next cell for the person to walk on to from the current cell he/she is standing.
	 * @param cell represents the current cell that the person is on.
	 * @return the next cell for the person to walk on from the current cell where she/he is standing.
	 */
	private MapCell findNextCell(MapCell cell)
	{
		
		MapCell curr= cell;
		MapCell next= null;
//		MapCell neighbour= null;
		boolean run= true;
		for(int i= 0; i<4; i++)
		{
			if (curr.getNeighbour(i)!= null && curr.getNeighbour(i).isExit()== true)
			{
				return curr.getNeighbour(i);
			}	
		}
		for (int i= 0; i<4; i++)
		{
			if ((curr.getNeighbour(i)!= null) && (curr.getNeighbour(i).isKeyCell()== true || curr.getNeighbour(i).isGoldCell()== true) && curr.getNeighbour(i).isMarked()== false)
			{
				return curr.getNeighbour(i);	
			}
		}
		for (int i= 0; i<4; i++)
		{
			if (curr.getNeighbour(i)!= null && curr.getNeighbour(i).isFloor()== true && curr.getNeighbour(i).isMarked()== false)
			{
				return curr.getNeighbour(i);
			}
		}
		for (int i= 0; i<4; i++)
		{
			if (curr.getNeighbour(i)!= null && curr.getNeighbour(i).isLockCell()== true && curr.getNeighbour(i).isMarked()== false)
			{
				
				if (curr.getNeighbour(i).isBlue()== true && numKeys[2]>0 && curr.getNeighbour(i).isMarked()== false)
				{
					
					return curr.getNeighbour(i);
				}
				else if (curr.getNeighbour(i).isRed()== true && numKeys[0]>0 && curr.getNeighbour(i).isMarked()== false) 
				{
					
					return curr.getNeighbour(i);
				}
				else if (curr.getNeighbour(i).isGreen()== true && numKeys[1]>0 && curr.getNeighbour(i).isMarked()== false)
				{
					
					return curr.getNeighbour(i);
				}
				
			}
		}
		return null;
		
	}
		

	/**
	 * This method finds and returns the path for the person to walk out of the mine.
	 * @return the path for the person for the person to walk out of the mine.
	 */
	public String findEscapePath ()
	{
		String path= "Path: ";
		ArrayStack<MapCell> s= new ArrayStack<MapCell>();
		MapCell curr;
		MapCell next;
		boolean running= true;
		s.push(map.getStart());
		map.getStart().markInStack();
		path= path + map.getStart().getID() + " ";
		while (s.isEmpty()==false && running== true)
		{
			curr= s.peek();
			if (curr.isExit()== true)
			{
				running= false;
				break;
				
			}
			if (curr.isKeyCell()== true)
			{
				if (curr.isBlue()== true)
				{
					numKeys[2]++;
				}
				else if (curr.isGreen()== true)
				{
					numKeys[1]++;
				}
				else if (curr.isRed()== true)
				{
					numKeys[0]++;
				}
				curr.changeToFloor();
				
			}
			if (curr.isGoldCell()== true)
			{
				numGold++;
				curr.changeToFloor();
			}
			
			if ((curr.getNeighbour(0)!= null && curr.getNeighbour(0).isLava()== true) ||(curr.getNeighbour(1)!= null && curr.getNeighbour(1).isLava()== true) || (curr.getNeighbour(2)!= null && curr.getNeighbour(2).isLava()== true) || (curr.getNeighbour(3)!= null && curr.getNeighbour(3).isLava()== true))
			{
				
				numGold= 0;
					
					
			}
			
			next= findNextCell(curr);
			if (next== null)
			{
				curr= s.pop();
				curr.markOutStack();
			}
			else
			{
				path= path + next + " ";
				s.push(next);
				next.markInStack();
				if (next.isLockCell()== true)
				{
					
					if (next.isRed()== true && numKeys[0]>0)
					{
						next.changeToFloor();
						numKeys[0]--;
					}
					else if (next.isBlue()== true && numKeys[2]>0)
					{
						numKeys[2]-- ;
						next.changeToFloor();
					}
					else if (next.isGreen()== true && numKeys[1]>0)
					{
						numKeys[1]--;
						next.changeToFloor();
					}
					
				}
			}
		}
		if (running== false)
		{
			path= path + numGold + "G";
			return path;
		}
		else
		{
			return "No solution found";
		}
	}
	public static void main(String[] args) 
	{ 
////		MineEscape n1= new MineEscape("/Users/sivasuresh/Desktop/westernuniversity/firstyearcourses /fall2023/Compsci 1027A/Assignments/Assignment3/mine0.txt");
////		MapCell c1= new MapCell(n1.map.getStart().getID(), CellComponent.CellType.START);
//
////		System.out.println();
////		System.out.println(n1.findNextCell(c1));
//		MineEscape n1= new MineEscape("mine1.txt");
//		System.out.println(n1.findEscapePath());
		if (args.length != 1) 
		{
			System.out.print("Map file not given in the arguments."); 
		} 
		else 
		{
			MineEscape search = new MineEscape(args[0]); 
			String result = search.findEscapePath(); 
			System.out.println(result);
		} 
		
	}
		
}
