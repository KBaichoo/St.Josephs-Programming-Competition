import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SB{
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner( new File("sb.txt"));
		
		int numTrips = input.nextInt();
		int nStud;
		double avgCost;
		double sumTrans;
		double[] pays;
		for(int i = 0; i < numTrips; i++){
			nStud = Integer.parseInt(input.next());
			pays = new double[nStud];		

			for(int j = 0; j < nStud; j++)
				pays[j] = input.nextDouble();	

			//get avg
			avgCost = avg(pays);
			//sum differences
			sumTrans = 0;
			for(double c: pays)
				if(c < avgCost) 
					sumTrans += (avgCost - c);
			
			//format
			System.out.print("$" + sumTrans);
			if(("" + sumTrans).indexOf(".") != ("" + sumTrans).length() - 3)
				System.out.print("0");
			System.out.println();
		}
	
			
	}
	
	public static double avg(double[] ns){
		double sum = 0;
		for(int i = 0; i < ns.length;i++){
			sum += ns[i];
		}	
		sum /= ns.length;
		return format(sum);
	}
	
	public static double format(double sum){
		sum += .005;
		sum *=100;
		sum = (int) sum;
		sum /= 100;
		return sum;
	}
	
	
	
}