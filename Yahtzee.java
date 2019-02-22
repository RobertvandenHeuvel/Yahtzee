import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

	public static void main(String[] args) {
		
		YahtzeeSpel spel1 = new YahtzeeSpel();
		spel1.werpen();
		spel1.spelen();
	}

}
class YahtzeeSpel{
	void spelen(){
		int a = 0;
		System.out.println("Speel met (Enter) en stop met (q).");
		while (a == 0) {
		Scanner scanner = new Scanner(System.in);
		String invoer = scanner.nextLine();
		switch(invoer) {
		case "":
			System.out.println("Speel met (Enter) en stop met (q).");
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
	int werpen() {
		Random random = new Random();
		int dobbel = random.nextInt(6) + 1;
		System.out.println(dobbel);
		return dobbel;
	}
}
