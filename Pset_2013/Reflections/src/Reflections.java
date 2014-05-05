import java.io.File;
import java.util.Scanner;




public class Reflections {

	public static void main(String[] args) throws Exception{
		
		Scanner input = new Scanner(new File("input.txt"));
		
		int numGames = Integer.parseInt(input.nextLine());
		for(int game=0;game<numGames;game++){
			String first = input.nextLine();
			String second = input.nextLine();
			int height = Integer.parseInt(first.split(" ")[1]);
			int width = Integer.parseInt(first.split(" ")[0]);
			double initposx = Integer.parseInt(second.split(" ")[0]);
			double initposy = Integer.parseInt(second.split(" ")[1]);
			
			int initvelx = Integer.parseInt(second.split(" ")[2]);
			int initvely = Integer.parseInt(second.split(" ")[3]);
			
			int velx = Integer.parseInt(second.split(" ")[2]);
			int vely = Integer.parseInt(second.split(" ")[3]);
			double tickCount = 0;
			
			double posx = initposx;
			double posy = initposy;
		
			do{
				
				if(posx == 1 || posx == width)
					velx *= -1;
				if(posy == 1 || posy == height)
					vely *= -1;
				
				posx += .5*velx;
				posy += .5*vely;
				
				//System.out.println(tickCount+" "+posx+" "+posy+" "+velx+" "+vely);
				
				tickCount+=.5;
				
			}while(posx != initposx || posy != initposy || vely != initvely || velx != initvelx );
			
			System.out.println((int)tickCount);
			
		}
	}
}
