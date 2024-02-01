package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Starting Amount: ");
		double startamount = scan.nextDouble();
		
		System.out.print("Win Probability: ");
		double winchance = scan.nextDouble();
		
		System.out.print("Win Limit: ");
		double winlimit = scan.nextDouble();
		
		System.out.print("Days: ");
		int simulations = scan.nextInt();
		
		double remainamount = startamount;
		
		int count = 0;
		double predictruin = 0;
		
		for(int i = 0; i < simulations; i++) {

			while (0 < remainamount && remainamount < winlimit) {
				
				if (Math.random() < winchance) {
					remainamount = remainamount+1;
				}
				else {
					remainamount = remainamount-1;
				}
				count++;
			}
			
			if (remainamount == 0) {
				System.out.println("Day " + i + ". Loss. " + count + " Games Played.");
				predictruin++;
			}
			
			if (remainamount == winlimit) {
				System.out.println("Day " + i + ". Win. " + count + " Games Played.");
			}
			
			count = 0;
			remainamount = startamount;
		}
		
		double a = (1-winchance)/winchance;
		
		double expectruin = (Math.pow(a, startamount) - Math.pow(a,  winlimit))/(1-Math.pow(a,  winlimit));
		System.out.println(expectruin);
		
		System.out.println("Ruin Rate: " + (predictruin/simulations));
		

	}

}