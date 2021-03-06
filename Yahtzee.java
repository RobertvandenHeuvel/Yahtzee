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
		System.out.println("Het spel is afgelopen.");
	}

}
class YahtzeeSpel{
	int aantalWorpen;
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList();
	int[] blokkeerArray = {0,0,0,0,0};
	void dobbelstenenVerzamelen(){
		for(int i = 0 ; i < 5; i ++) {
			dobbelstenen.add(new Dobbelsteen());
		}
	}
	void spelen(){
		aantalWorpen = 1;
		Scanner scanner = new Scanner(System.in);
		for(int j = 0; j<100 ;j++) {
			String huidigeTotaal = "";
			if (huidigeTotaal == "11111") {
				System.out.println("Yahtzee! Het spel is afgelopen.");
			}else if (huidigeTotaal == "22222") {
				System.out.println("Yahtzee! Het spel is afgelopen.");
			}else if (huidigeTotaal == "33333") {
				System.out.println("Yahtzee! Het spel is afgelopen.");
			}else if (huidigeTotaal == "44444") {
				System.out.println("Yahtzee! Het spel is afgelopen.");
			}else if (huidigeTotaal == "55555") {
				System.out.println("Yahtzee! Het spel is afgelopen.");
			}else if (huidigeTotaal == "66666") {
				System.out.println("Yahtzee! Het spel is afgelopen.");
			}
			System.out.println("Speel met (Enter) en stop met (q).");
			String invoer = scanner.nextLine();
			switch(invoer) {
			case "":
				System.out.println("WORP" + aantalWorpen);
				System.out.println("12345");
				for(int i = 0; i<5;i++) {
					if (blokkeerArray[i] != 0) {
						huidigeTotaal += dobbelstenen.get(i).worpGeschiedenis;
						System.out.print(dobbelstenen.get(i).worpGeschiedenis);
					}else {
						dobbelstenen.get(i).werpen();
						huidigeTotaal += dobbelstenen.get(i).dobbel;
						System.out.print(dobbelstenen.get(i).dobbel);
					}
				}
				System.out.println();
			//	System.out.println("Huidige totaal: "+ huidigeTotaal);
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
	int[] vasthouden() { //verkeerde invoer leidt tot exceptions
			System.out.println("Welke posities wilt u vasthouden? 0 voor geen, anders bijvoorbeeld 124.");
			int NogEenKeerInput = 1;
			Scanner scanner2 = new Scanner(System.in);
			while(NogEenKeerInput>0) {
				String invoer2 = scanner2.nextLine();
				int invoer2Int = Integer.parseInt(invoer2);
				if (invoer2Int == 0) {
				System.out.println("Geen dobbelstenen vastgehouden.");
				NogEenKeerInput--;
			}
			else if (invoer2Int > 0 && invoer2Int <=12345) {
				for(int i = 0; i<5; i++) {
					blokkeerArray[i] = 0;
				}
				for (int i = 0; i< invoer2.length(); i++) {
					int blokkeren = Integer.parseInt(invoer2.substring(i,i+1)) -1;
					blokkeerArray[blokkeren] = 1;
					}
				NogEenKeerInput--;
			}
			else {
				System.out.println("Verkeerde invoer. Welke posities wilt u vasthouden? 0 voor geen, anders bijvoorbeeld 124.");
			}
		}
			return blokkeerArray;
	}
}
class Dobbelsteen{
	int dobbel;
	String worpGeschiedenis = "";
	int werpen() {
		Random random = new Random();
		dobbel = random.nextInt(6) + 1;
		worpGeschiedenis = "";
		worpGeschiedenis += dobbel;
		return dobbel;
	}
}