package learn.ds.matrix;


/**
 * 
 * You are sick and tired of using your remote control to input the names of your favorite shows into
 * your fancy Smart TV. You decide to build a robot to do it for vou. The robot will translate the show
 * name into a sequence of commands to navigate the onscreen keyboard. The keyboard consists of
 * the characters a-z (lowercase) laid out alphabetically in rows of N characters.
 * 
 * Write a program that takes two inputs: an input word, W, and the number of characters per row, N,
 * and returns a string representing the sequence of commands required for the robot to enter W.
 * 
 * Assume that the cursor starts on letter "a." Each movement should be horizontal (L/R) followed by vertical (U/D).
 * 
 * The remote control commands are as follows: (U)p, (D)own, (L)eft, (R)ight, and Enter (!)
 * 
 * Example Input:
 * can
 * 
 * Expected Outout:
 * RR!LL!RRRDD!
 * 
 */
public class KeyboardProgrammer {

    public static String keyboardCommands(String word, int rowLength){
  
        int[][] grid = createGrid(rowLength);

        StringBuilder sb = new StringBuilder();

        int index = 0, row = 0, col = 0;

        while(index < word.length()){
            int current = grid[row][col];
            int target = word.charAt(index) - 'a';
            
            if(current == target){
                sb.append("!");
                index++;
            }else{
                int targetRow = target / rowLength;
                int targetCol = target % rowLength;

                while(col >= 0  && col < grid[0].length && col != targetCol ){
                    if(col < targetCol){
                        sb.append("R");
                        col++;
                    }else{
                        sb.append("L");
                        col--;
                    }
                }

                while(row >= 0  && row < grid.length && row != targetRow ){
                    if(row < targetRow){
                        sb.append("D");
                        row++;
                    }else{
                        sb.append("U");
                        row--;
                    }
                }
                
            }
        }
        return sb.toString();
    }

    public static int[][] createGrid(int cols){
        
        int rows = 26 / cols;
        int[][] grid = new int[rows + 1][cols];
        
        int index  = 0;
        for(int row = 0 ; row <= rows ; row++){
            for(int col = 0 ; col < cols ; col++ ){
                if(index > 25){
                    grid[row][col] = -1;
                }else{
                    grid[row][col] = index;
                }
                index++;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        System.out.println(keyboardCommands("can", 5));

    }
}
