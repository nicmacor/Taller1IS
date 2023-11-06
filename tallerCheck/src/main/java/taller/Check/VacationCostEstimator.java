package taller.Check;

import java.util.Scanner;

public final class VacationCostEstimator {
	
    // Represents the base cost of the vacation package.
    private static final int BASE_COST = 1000;
    
    // Represents the additional cost for Paris.
    private static final int COST_PARIS = 500;
    
    // Represents the additional cost for New YORK City.
    private static final int COST_NY = 600;
    
    // The low limit for people discount.
    private static final int DISC_NUM_LOW = 4;
    
    // The max limit for people discount.
    private static final int DISC_NUM_HIGH = 10;
    
    // Discount for groups between 4-10.
    private static final double DISCOUNT_LOW = 0.1;
    
    // Discount for groups that are more than 10 travelers.
    private static final double DISCOUNT_HIGH = 0.2;
    
    //The min of the duration for a vacation without penaltie.
    private static final double DURATION_MIN = 7;
    
    // The max duration of a vacation to apply for discount
    private static final double DURATION_MAX = 30;
    
    //Number of people that can apply for discount
    private static final double PROMO_NUM_TRA = 2;
    
    //Penaltie for a vacation for less than 7 days
    private static final double DURATION_PENALTIE = 200;
    
    //Discount for a gruop of 2 and more than 30 days
    private static final double PROMO_DISC = 200;
    
    //Limit of traveleres for a vacation
    private static final double MAX_TRAVELERS = 80;
    
    // Package all include cost
    private static final int ALL_INCLUSIVE_PACKAGE_COST = 200;
    
    // Package Adventures include
    private static final int ADVENTURE_ACTIVITIES_PACKAGE_COST = 150;
    
    // Package Spa and wellness
    private static final int SPA_AND_WELLNESS_PACKAGE_COST = 100;

    // Private constructor to prevent instantiation
    private VacationCostEstimator() {
        throw new UnsupportedOperationException("No constructor allowed");
    }
    /**
     * This method calculates the cost of a vacation package.
     *
     * @param args The command-line arguments (not used in this method).
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the destination of the vacation:");
        String destination = scanner.nextLine();
        System.out.println("Enter the number of travelers:");
        int numTravelers = scanner.nextInt();
        System.out.println("Enter the duration of the vacation in days:");
        int duration = scanner.nextInt();
        
        scanner.nextLine();

        int baseCost = BASE_COST;
        int additionalCost = 0;

        // Destination cost
        if ("Paris".equalsIgnoreCase(destination)) {
            additionalCost = COST_PARIS;
        } else if ("New York City".equalsIgnoreCase(destination)) {
            additionalCost = COST_NY;
        }

        int totalCost = baseCost + additionalCost;

        // Number of travelers discount
        if (numTravelers > DISC_NUM_LOW && numTravelers <= DISC_NUM_HIGH) {
            totalCost -= DISCOUNT_LOW * totalCost;
        } else if (numTravelers > DISC_NUM_HIGH) {
            totalCost -= DISCOUNT_HIGH * totalCost;
        }

        // Duration cost
        if (duration < DURATION_MIN) {
            totalCost += DURATION_PENALTIE;
        } else if (duration > DURATION_MAX || numTravelers == PROMO_NUM_TRA) {
            totalCost -= PROMO_DISC;
        }

        if (numTravelers > MAX_TRAVELERS) { // Number of travelers restriction
            System.out.println("Too much travelers for the system");
            System.out.println("Total cost: -1");
        } else {
            System.out.println("Total cost before add-ons: " + totalCost);
        }
        
        System.out.println("We have add-ons that might intrested you:");
        System.out.println("1.- ALl include add-on $200 per traveler");
        System.out.println("2.- Adventure add-on $150 per traveler");
        System.out.println("3.- Spa and Wellness add-on $100 per traveler");
        System.out.println("Do you want to add a package to your purchase? (yes/no)");
        
        String addOnDecision = scanner.nextLine();
        
        while ("yes".equalsIgnoreCase(addOnDecision)) {
        	System.out.println("Which add-on would you like to purchase? (1, 2 or 3)");
        	int addOn = scanner.nextInt();
        	
        	if (addOn<1 || addOn>3) {
        		System.out.println("Please select a correct number (1, 2 or 3)");
        	}
        	if (addOn==1) {
        		System.out.println("How many add-ons would you like: ");
        		int addOnNumberT=scanner.nextInt();
        		totalCost= totalCost + (addOnNumberT*ALL_INCLUSIVE_PACKAGE_COST);
        	}else if(addOn==2) {
        		System.out.println("How many add-ons would you like: ");
        		int addOnNumberT=scanner.nextInt();
        		totalCost= totalCost +(addOnNumberT *ADVENTURE_ACTIVITIES_PACKAGE_COST);
        	}else if(addOn==3) {
        		System.out.println("How many add-ons would you like: ");
        		int addOnNumberT=scanner.nextInt();
        		totalCost= totalCost +(addOnNumberT *SPA_AND_WELLNESS_PACKAGE_COST);
        	}
        	
        	scanner.nextLine();
        	
        	System.out.println("Would you like to add more add-ons? (yes/no)");
        	addOnDecision = scanner.nextLine();
        }
        
        System.out.println("Total cost: "+ totalCost);
        System.out.println("Have a great day :)");
        
        
        scanner.close();
    }
}
