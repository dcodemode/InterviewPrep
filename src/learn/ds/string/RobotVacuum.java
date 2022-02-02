package learn.ds.string;


/*
    Given a string representing the sequence of moves a robot vacuum makes, return whether or not it will return to its original position. 
    The string will only contain L, R, U, and D characters, representing left, right, up, and down respectively.

    Ex: Given the following strings...

    "LR", return true
    "URURD", return false
    "RUULLDRD", return true
 */
public class RobotVacuum {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param directions
     * @return
     */
	public static  boolean robotAt(String directions){
		int x = 0, y = 0;
        int L = -1, R = 1, U = 1, D = -1; 
		
		for(char dir : directions.toCharArray()){
			if(dir == 'L'){
			   x += L;
            }else if(dir == 'R'){
				x += R;
            }else if(dir == 'U'){
				y += U;
            }else {
				y += D;
            }
		}

		if(x == 0 && y == 0){
			return true;
		}
        return false;
	}
    
    public static void main(String[] args) {
        System.out.println(robotAt("RUULLDRD"));
    }
}
