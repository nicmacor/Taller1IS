package taller.Check;

import java.util.Scanner;

public class VacationCostEstimator {
//CHECKSTYLE:OFF
	public static void main(String[] args) {
//CHECKSTYLE:ON
		Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the destination of the vacation :");
        String destination = scanner.nextLine();
        
        System.out.println("Enter the number of travelers:");
        int numTravelers = scanner.nextInt();
        
        System.out.println("Enter the duration of the vacation in days:");
        int duration = scanner.nextInt();
        
        int baseCost = 1000;
        
        int additionalCost = 0;
        
        //Destination cost
        
        if (destination.equalsIgnoreCase("Paris")) {
            additionalCost = 500;
        } else if (destination.equalsIgnoreCase("New York City")) {
            additionalCost = 600;
        }
        int totalCost = baseCost + additionalCost;
        
        //Number of travelers discount
        
        if (numTravelers > 4 && numTravelers <= 10) {
            totalCost -= 0.1 * totalCost;
        } else if (numTravelers > 10) {
            totalCost -= 0.2 * totalCost;
        }
        
        //Duration cost
        
        if (duration < 7) {
            totalCost += 200;
        } else if (duration > 30 || numTravelers == 2) { //promotional discount
            totalCost -= 200;
        }
        
        if (numTravelers > 80) { // number of travelers restriction
            System.out.println("The vacation package is not available for groups of more than 80 persons.");
            System.out.println("Total cost: -1");
        } else {
            System.out.println("Total cost: " + totalCost);
        }
        scanner.close();
	}
}
