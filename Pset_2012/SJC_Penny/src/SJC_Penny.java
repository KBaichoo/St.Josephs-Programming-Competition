import java.util.ArrayList;

public class SJC_Penny{

	
	public static void main(String[] args){
		//Assuming we have the input(Didn't know if we're restricted to one file)
		String[] itemName =  {"SJC Sweats","NYU Bag", "RPI tee", "MIT pants","USC scarf"};
		double[] itemPrice = {25.99,30.00,10.99,22.00,15.00}; 
		double[] discountPrice = new double[itemPrice.length];
		double total = calculatePrice(itemPrice);
		if(total < 100){
			printOutItems(itemName,itemPrice);
		}else{
			for(int i = 0; i < itemPrice.length; i++){
				discountPrice[i] = getDiscountedPrice(itemPrice[i],total);
			}
			if(total - calculatePrice(discountPrice) < 10.0){
				discountPrice[discountPrice.length - 1] = discountPrice[discountPrice.length - 1] + 10 - (total - calculatePrice(discountPrice));
				discountPrice[discountPrice.length - 1] = ((int)(discountPrice[discountPrice.length - 1] * 100))/100.0;
			}
			printOutItems(itemName,discountPrice);
		}
	}
	
	public static void printOutItems(String[] itemNames,double[] prices){
		for(int i = 0; i < itemNames.length; i++){
			System.out.println(itemNames[i] + " " + prices[i]);
		}
	}
	
	public static double getDiscountedPrice(double item, double total){
		//Gets the discount 
		double discountOffOfItem = ((int)((item / total ) * 1000));
		discountOffOfItem = discountOffOfItem / 100;
		
		//returns discounted price
		return (item - discountOffOfItem);
	}
	
	public static double calculatePrice( double[] items){
		double cost = 0;
		for(double itemPrice : items)
			cost += itemPrice;
		return cost;
	}


}