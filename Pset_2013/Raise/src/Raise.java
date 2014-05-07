import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;


public class Raise {
	public static void main(String[] args) throws Exception{
		NumberFormat formatter = new DecimalFormat("#0.00");    
		Scanner input = new Scanner(new File("input.txt"));
		
		int numRuns = input.nextInt();
		for (int r=0;r<numRuns;r++){
			double pay = input.nextDouble();
			if (pay+1>pay*1.05)
				System.out.println("$1.00 $" + formatter.format(pay+1));
			else
				System.out.println("5% $" + formatter.format(pay*1.05));
		}
		

	}
}
