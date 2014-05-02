import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Practice{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner temp = new Scanner( new File("dummy.txt") ); 
		String testString = "";
		
		if(temp.hasNext())
			testString = temp.nextLine();
		temp.close();
		
		System.out.println(testString);
		
		String prev = "";
		String curr = "";
		while(!isCleared(testString)){
			for(int i = 1; i < testString.length(); i++){
				prev = testString.substring(i-1,i);
				curr = testString.substring(i,i+1);
				if(prev.equalsIgnoreCase(curr)){
					if(curr.equalsIgnoreCase("a"))
						testString = testString.substring(0,i - 1) + "B" + testString.substring(i+1);  
					if(curr.equalsIgnoreCase("b"))
						testString = testString.substring(0,i - 1) + "A" + testString.substring(i+1);  
				}
		
			}
		}
		
		System.out.print(testString);
	}
	
	public static boolean isCleared(String test){
		for(int i = 1; i < test.length(); i++){
			if(test.substring(i - 1, i).equalsIgnoreCase(test.substring(i,i+1))){
				return false;
			}
	
		}
		return true;
	}
	
	

}