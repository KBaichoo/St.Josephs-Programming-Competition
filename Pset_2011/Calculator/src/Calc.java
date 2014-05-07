import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calc{
	
	public static void main(String[] args) throws FileNotFoundException{	
		Scanner input = new Scanner(new File("dummy.txt"));
		
		int n1 = Integer.parseInt(input.next());
		int n2 = Integer.parseInt(input.next());
		
		
		String output = "n1 = " + n1 + ",n2 = " + n2 + ",n1*n2=" + (n1 * n2) + ",n1+n2=" + (n1+n2) + ",n1-n2=" + (n1-n2) + ", the average of n1 and n2=" + avg(n1,n2);
		System.out.println(output);
		
	}
	
	public static double avg(int n1,int n2){
		double res = (n1+n2)/2.0;
		res += .05;
		res *= 10;
		res = (int) res;
		return res /= 10;
		
	}
	
}