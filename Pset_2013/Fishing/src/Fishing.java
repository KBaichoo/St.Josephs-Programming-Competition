import java.io.File;
import java.util.Scanner;


public class Fishing {
	
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(new File("input.txt"));
		String inputs = input.nextLine();
		double weight = Double.parseDouble(inputs.split(" ")[0]);
		double num = Double.parseDouble(inputs.split(" ")[1]);
		System.out.println("Total weight of the catch = " + weight * num +" Total Weight Delivered = "+ weight* num /2);
	}
}
