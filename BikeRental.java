import java.util.ArrayList;
import java.util.Scanner;

public class BikeRental {

    static Scanner input = new Scanner(System.in);

    // Lists to store data
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> startTimes = new ArrayList<>();
    static ArrayList<Integer> endTimes = new ArrayList<>();
    static ArrayList<Integer> costs = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            // Menu
            System.out.println("\n===== BIKE RENTAL SYSTEM =====");
            System.out.println("1. Rent a Bike");
            System.out.println("2. View Rentals");
            System.out.println("3. Calculate Cost Only");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    rentBike();
                    break;
                case 2:
                    showRentals();
                    break;
                case 3:
                    calculateOnly();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        input.close();
    }

    // Rent a bike
    static void rentBike() {
        input.nextLine(); // clear buffer

        System.out.print("Enter customer name: ");
        String name = input.nextLine();

        System.out.print("Enter start time (0-23): ");
        int start = input.nextInt();

        System.out.print("Enter end time (1-24): ");
        int end = input.nextInt();

        // validation
        if (start < 0 || start > 23 || end < 1 || end > 24 || start >= end) {
            System.out.println("Invalid input.");
            return;
        }

        int cost = calculateCost(start, end);

        // store data
        names.add(name);
        startTimes.add(start);
        endTimes.add(end);
        costs.add(cost);

        System.out.println("Rental saved. Cost: " + cost + " RWF");
    }

    // Show all rentals
    static void showRentals() {
        if (names.isEmpty()) {
            System.out.println("No rentals yet.");
            return;
        }

        System.out.println("\n--- Rental List ---");

        for (int i = 0; i < names.size(); i++) {
            System.out.println("Customer: " + names.get(i));
            System.out.println("Start: " + startTimes.get(i));
            System.out.println("End: " + endTimes.get(i));
            System.out.println("Cost: " + costs.get(i) + " RWF");
            System.out.println("--------------------");
        }
    }

    // Calculate cost without saving
    static void calculateOnly() {
        System.out.print("Enter start time: ");
        int start = input.nextInt();

        System.out.print("Enter end time: ");
        int end = input.nextInt();

        if (start >= end) {
            System.out.println("Invalid input.");
            return;
        }

        int cost = calculateCost(start, end);
        System.out.println("Total cost: " + cost + " RWF");
    }

    // Cost calculation
    static int calculateCost(int start, int end) {
        int total = 0;

        for (int hour = start; hour < end; hour++) {

            if ((hour >= 0 && hour < 7) || (hour >= 21 && hour < 24)) {
                total += 500;
            } else if ((hour >= 7 && hour < 14) || (hour >= 19 && hour < 21)) {
                total += 1000;
            } else {
                total += 1500;
            }
        }

        return total;
    }
}