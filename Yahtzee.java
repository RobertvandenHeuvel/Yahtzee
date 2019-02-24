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
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList();
	int[] blokkeerArray = new int[5];
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
		int a = 0;
		int aantalWorpen = 1;
		System.out.println("Speel met (Enter) en stop met (q).");
		Scanner scanner = new Scanner(System.in);
		while (a == 0) {
		String invoer = scanner.nextLine();
			switch(invoer) {
			case "":
				System.out.println("WORP" + aantalWorpen);
				System.out.println("12345");
				for (Dobbelsteen deDobbelsteen: dobbelstenen) {
					deDobbelsteen.werpen();
					System.out.print(deDobbelsteen.dobbel);
				}
				System.out.println();
				vasthouden();
				aantalWorpen++;
				System.out.print("Speel met (Enter) en stop met (q).");
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
	void vasthouden() {
		System.out.println("Voer een 0 in voor de dobbelstenen die je opnieuw wil gooien en 1 voor de worpen die je wilt vasthouden (bijv. 00110).");
		Scanner scanner2 = new Scanner(System.in);
		String invoer2 = scanner2.nextLine();
		Integer x = Integer.parseInt(invoer2);
		//System.out.println(invoer2);
		//System.out.println(x);
		Integer[] invoerArray = new Integer[5];
		for (int i = 0; i<invoerArray.length; i++) {
			int d = x%10;
			invoerArray[i] = d;
		//	System.out.print(invoerArray[i]);
			x /= 10;
			}
	    Collections.reverse(Arrays.asList(invoerArray)); 
		for (int i = 0; i<invoerArray.length; i++) {
			System.out.print(invoerArray[i]);
		}
		System.out.println();
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