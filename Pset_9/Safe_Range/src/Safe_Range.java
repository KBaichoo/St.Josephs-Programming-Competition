import java.util.Scanner;

public class Safe_Range{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String mpg = input.nextLine();
		String capacity = input.nextLine();
		calculateSafeRange(mpg,capacity);
		input.close();
	}
	
	public static void calculateSafeRange(String milesPerGallon,String tankCapacity){
		double capacity = Double.parseDouble(tankCapacity);
		double mpg = Double.parseDouble(milesPerGallon);
		
		System.out.println("MPG=" + mpg + ";Fuel capacity=" + capacity + ";gallons;Range=" + ((capacity - 1) * mpg));
		
	}
	
}