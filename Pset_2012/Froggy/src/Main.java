import java.util.*;
import java.io.File;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner(new File("/sdcard/AppProjects/Froggy/input.txt"));
	
		int numRuns = Integer.parseInt(input.nextLine());
		for(int runs=0;runs<numRuns;runs++){
			
			String[] inputs = input.nextLine().split(" ");
			int numRows = Integer.parseInt(inputs[0]);
			int numCols = Integer.parseInt(inputs[1]);
			int startRow = Integer.parseInt(inputs[2]);
			int startCol = Integer.parseInt(inputs[3]);
			
			
			String[][] map = new String[numRows][];
			for(int r=0;r<numRows;r++){
				map[r] = input.nextLine().split(" ");
				/*for(int c=0;c<numCols;c++){
				 System.out.print(map[r][c] + " ");
				}
				System.out.println();*/
			}
			
			markStones(map, startRow, startCol);
			
			for(int r=0;r<numRows;r++){
				for(int c=0;c<numCols;c++){
				 System.out.print(map[r][c] + " ");
				 }
				 System.out.println();
			}
			System.out.println();
		}
	}

	public static void markStones(String[][] map, int row, int col){
		if (row < 0 || row >= map.length || col<0 || col >= map[row].length)
			return;
		
		if(map[row][col].equals("0")){
			map[row][col] = "X";
			markStones(map, row-1, col);
			markStones(map, row+1, col);
			markStones(map, row, col-1);
			markStones(map, row, col+1);
		}		
	}
		
	
}
