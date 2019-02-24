import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

	public static void main(String[] args) {
		
		YahtzeeSpel spel1 = new YahtzeeSpel();
		spel1.dobbelstenenVerzamelen();
		spel1.spelen();
	}

}
class YahtzeeSpel{
	int aantalWorpen;
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList();
	Integer[] invoerArray = new Integer[5];
	int[] blokkeerArray = {0,0,0,0,0};
	void dobbelstenenVerzamelen(){
		for(int i = 0 ; i < 5; i ++) {
			dobbelstenen.add(new Dobbelsteen());
		}
		//checken dat de ArrayList vult met dobbelstenen
		//for (Dobbelsteen deDobbelsteen: dobbelstenen) {
		//	System.out.println(deDobbelsteen);
		//}
	}
	void spelen(){
		aantalWorpen = 1;
		Scanner scanner = new Scanner(System.in);
		for(int j = 0; j<3 ;j++) {
			System.out.println("Speel met (Enter) en stop met (q).");
			String invoer = scanner.nextLine();
			switch(invoer) {
			case "":
				System.out.println("WORP" + aantalWorpen);
				System.out.println("12345");
				for(int i = 0; i<5;i++) {
					if (blokkeerArray[i] == 0) {
						dobbelstenen.get(i).werpen();
						System.out.print(dobbelstenen.get(i).dobbel);
					}else {
						System.out.print("1");
					}
				}
				System.out.println();
				vasthouden();
				aantalWorpen++;
				break;
			case "q":
				System.out.println("Het spel is over.");
				System.exit(0);
				break;
			default:
				System.out.println("Verkeerde invoer. Speel met (Enter) en stop met (q).");
				break;	
			}
		}
	}
	Integer[] vasthouden() {
		switch(aantalWorpen) {
		case 3:
			return invoerArray;
		default:
			System.out.println("Voer een 0 in voor de dobbelstenen die je opnieuw wil gooien en 1 voor de worpen die je wilt vasthouden (bijv. 00110).");
			Scanner scanner2 = new Scanner(System.in);
			String invoer2 = scanner2.nextLine();
			Integer x = Integer.parseInt(invoer2);
			//System.out.println(invoer2);
			//System.out.println(x);
			for (int i = 0; i<invoerArray.length; i++) {
				int d = x%10;
				invoerArray[i] = d;
			//	System.out.print(invoerArray[i]);
				x /= 10;
				}
		    Collections.reverse(Arrays.asList(invoerArray)); 
			//for (int i = 0; i<invoerArray.length; i++) {
			//	System.out.print(invoerArray[i]);
			//}
			for(int i = 0;i<blokkeerArray.length; i++) {
				blokkeerArray[i] = invoerArray[i];
			//	System.out.print(blokkeerArray[i]);
			}
			return invoerArray;
		}
	}
}
class Dobbelsteen{
	int dobbel;
	int werpen() {
		Random random = new Random();
		dobbel = random.nextInt(6) + 1;
	//	System.out.println(dobbel);
		return dobbel;
	}
}