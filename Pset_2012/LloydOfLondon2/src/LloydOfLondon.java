import java.util.Scanner;
import java.io.File;

public class LloydOfLondon {
	
	public static void main(String[] args) throws Exception{
		
		Scanner input = new Scanner(new File("input.txt"));
		//Scanner input = new Scanner(new File("/storage/UsbDriveA/Java/EclipseWorkspace/St.Josephs-Programming-Competition/LloydOfLondon/input.txt"));
		int numRuns = Integer.parseInt(input.nextLine());
		
		for (int r=0;r<numRuns;r++){
			String firstLine = input.nextLine();
			int numCities = Integer.parseInt(firstLine.split(" ")[0]);
			int LONDON = Integer.parseInt(firstLine.split(" ")[1]) - 1;
			
			int[][] priceMap = new int[numCities][];
			
			for (int c=0;c<numCities;c++){
				priceMap[c] = new int[numCities];
				String[] prices = input.nextLine().split(" ");
				for (int s=0;s<prices.length;s++){
					priceMap[c][s] = Integer.parseInt(prices[s]);
				//	System.out.print(priceMap[c][s]+ " ");
				}
			//	System.out.println();
			}
			for(int n=0;n<numCities;n++)
				if (n!= LONDON)
					System.out.print(getBestPriceOfTrip(priceMap, new int[]{LONDON}, n)+" ");
		
				System.out.println();	
				}
		
	
	}
	
	public static int getBestPriceOfTrip(int[][] priceMap, int[] trail, int to){
		
		
		
		if(trail[trail.length-1] == to)
			return 0;
		
		int[] prices = new int[0];
		int[] nextDestinations = new int[0];
		
		
		for(int t=priceMap.length-1;t>=0;t--){
			if (priceMap[trail[trail.length-1]][t] != 0 && !isInArray(trail, t)){
				nextDestinations = push(nextDestinations, t);
				prices = push(prices, priceMap[trail[trail.length-1]][t]  + getBestPriceOfTrip(priceMap, push(trail, t), to));
			}	
		}
		
		
		if(prices.length == 0)
			return -1;
		
		int bestPriceIndex = -1;
		
		
		for(int i=0;i<prices.length;i++){
			if (prices[i] != -1){
				bestPriceIndex = i;
				break;
			}
		}
		
		if (bestPriceIndex == -1)
			return -1;
		
		for(int i=0;i<prices.length;i++){
			if (prices[i] < prices[bestPriceIndex]&&prices[i]!=-1){
				bestPriceIndex = i;
				
			}
		}
			
		int price =  getBestPriceOfTrip(priceMap, push(trail, nextDestinations[bestPriceIndex]), to);
		
		
		return priceMap[trail[trail.length-1]][nextDestinations[bestPriceIndex]] + price;
		
		
		
	}
	
	public static int[] push(int[] array, int num){
		int[] newArray = new int[array.length+1];
		for(int n=0;n<array.length;n++)
			newArray[n] = array[n];
		
		newArray[array.length] = num;
		return newArray;
		
	}
	
	public static boolean isInArray(int[] array, int num){
		for (int n:array)
			if (n == num)
				return true;
		return false;
	}
	
	public static String showArray(int[] array){
		String swag = "[";
		for(int i:array)
			swag += " " + i;
		
		swag += "]";
		return swag;
	}
}
