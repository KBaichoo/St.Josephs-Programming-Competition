import java.util.*;
import java.io.File;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		
	//this section is obligatory st josephs college bullshit
		//gets the input file
		Scanner input = new Scanner(new File("/sdcard/AppProjects/FeedingFrenzy/input.txt"));
		
		//for loop to run multiple times
		int numRuns = Integer.parseInt(input.nextLine());
		for(int run = 0; run < numRuns; run++){
			
			//gets num players (mostly here to move the scanner along)
			int numPlayers = Integer.parseInt(input.nextLine());
			
			//reads the tree in string form
			String treeString = input.nextLine();
			
		//this section converts the given string into a 2d array representing a binary tree
		//such that the string 
		//"1 2 3 4 5 6 7 8 9"
		//becomes
		//[
		//	[1]
		//	[2,3]
		//	[4,5,6,7]
		//	[8,9]
		//]
		
			
			//converts the space delimmited string into an array
			String[] codedTree = treeString.split(" ");
			
			//gets the number of levels in the tree
			int numLevels = (int)Math.ceil(Math.log10(numPlayers+1)/Math.log10(2));
			
			//instantiates the empty tree with numLevels levels and no columns
			int[][] treeArray = new int[numLevels][];
			
			//loops through the levels of the tree
			for(int l=0;l<numLevels;l++){
				//instantiates the array that holds the columns with the apropriate number of elements
				treeArray[l] = new int[(int)Math.pow(2,l)];
				
				//for each entry in the level
				for(int n=0;n<Math.pow(2,l);n++){
					//calculates the index of the original (string) array that corresponds to the current row+col combination
					int index = (int)(Math.pow(2,l)+n-1);
					
					//if the calculated index goes  out of bounds (in the case of an unbalanced tree), resize the array of columns to the correct size and break
					if(index < codedTree.length)
						treeArray[l][n] = Integer.parseInt(codedTree[index]);
					else{
						int[] temp = new int[codedTree.length-(int)Math.pow(2,l)+1];
						for (int i=0;i<temp.length;i++)
							temp[i] = treeArray[l][i];
						treeArray[l]=temp;
						break;
					}
						
				}
			}
			//prints out the tree (for debugging)
			/*
			for(int[] level: treeArray){
				for(int e:level)
					System.out.print(e + " ");
				System.out.println();
			}
			*/
			
			//calls the recursive encoding method (see below)
			System.out.println(encodeTree(treeArray));
		}
	
	}
	
	//starts the encosing recursion with the top most entry
	public static String encodeTree(int[][] tree){
		return encodeTree(tree, 0, 0);
	}
	
	public static String encodeTree(int[][] tree, int row, int col){
		//*base case* if this is the last level or if there are no branches add this number to the string
		if (row == tree.length-1 || 2*col+1 >= tree[row+1].length && 2*col >= tree[row+1].length)
			return "" + tree[row][col];
			//else if there is olny one branch, add this and the branch to the string
		else
			if(2*col+1 >= tree[row+1].length)
				return encodeTree(tree, row+1, 2*col) + " " + tree[row][col] ;
				//else (if there are more branches) add this and repeat the process with the two branches
			else
				return  encodeTree(tree, row+1, 2*col+1) + " " + encodeTree(tree, row+1, 2*col) + " " + tree[row][col] ;
	}
} 
