import java.util.ArrayList;
import java.util.Scanner;

// Base class for donations
class Donation {
    String type;

    Donation(String type) {
        this.type = type;
    }
}

// Subclass for cloth donations
class ClothDonation extends Donation {
    String clothType;
    String size;

    ClothDonation(String type, String clothType, String size) {
        super(type);
        this.clothType = clothType;
        this.size = size;
    }
}

// Subclass for money donations
class MoneyDonation extends Donation {
    double amount;

    MoneyDonation(String type, double amount) {
        super(type);
        this.amount = amount;
    }
}

// Subclass for toy donations
class ToyDonation extends Donation {
    String toyType;

    ToyDonation(String type, String toyType) {
        super(type);
        this.toyType = toyType;
    }
}

// Subclass for book donations
class BookDonation extends Donation {
    String bookType;

    BookDonation(String type, String bookType) {
        super(type);
        this.bookType = bookType;
    }
}

// Subclass for groceries donations
class GroceriesDonation extends Donation {
    // Add any relevant properties for groceries

    GroceriesDonation(String type) {
        super(type);
    }
}

// Subclass for leftover food donations
class LeftoverFoodDonation extends Donation {
    // Add any relevant properties for leftover food

    LeftoverFoodDonation(String type) {
        super(type);
    }
}

// Main donation management application
public class DonationManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User information
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your address: ");
        String userAddress = scanner.nextLine();

        // Donation categories
        String[] categories = {"Clothes", "Toys", "Money", "Books", "Groceries", "Food", "Electronics", "Sports Equipment"};

        // ArrayList to store user donations
        ArrayList<Donation> userDonations = new ArrayList<>();

        // Donation process
        System.out.println("Select the categories in which you want to donate:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }

        System.out.print("Enter the category numbers separated by spaces (e.g., '1 2 3'): ");
        String selectedCategoriesInput = scanner.nextLine();
        String[] selectedCategories = selectedCategoriesInput.split(" ");

        for (String selectedCategory : selectedCategories) {
            int categoryIndex = Integer.parseInt(selectedCategory) - 1;
            String category = categories[categoryIndex];

            System.out.println("Select options for " + category + " donation:");

            switch (category) {
                case "Clothes":
                    // Display cloth types
                    System.out.println("Choose cloth type:");
                    System.out.println("1. SHIRT");
                    System.out.println("2. TSHIRT");
                    System.out.println("3. JEANS");
                    System.out.println("4. SHORTS");
                    // Add your own types here

                    System.out.print("Enter the number corresponding to the cloth type: ");
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    String clothType = getTypeFromChoice(typeChoice);

                    // Display cloth sizes
                    System.out.println("Choose cloth size:");
                    System.out.println("1. Small (S)");
                    System.out.println("2. Medium (M)");
                    System.out.println("3. Large (L)");
                    System.out.println("4. Extra Large (XL)");
                    System.out.println("5. Double Extra Large (XXL)");
                    // Add your own sizes here

                    System.out.print("Enter the number corresponding to the cloth size: ");
                    int sizeChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    String clothSize = getSizeFromChoice(sizeChoice);

                    userDonations.add(new ClothDonation(category, clothType, clothSize));
                    break;

                // ... (similar cases for other categories)

                default:
                    System.out.println("Invalid category.");
                    break;
            }
        }

        // Print user donation details
        printDonationDetails(userName, userAddress, userDonations);
    }

    // Function to get cloth type from user choice
    private static String getTypeFromChoice(int choice) {
        switch (choice) {
            case 1:
                return "SHIRT";
            case 2:
                return "TSHIRT";
            case 3:
                return "JEANS";
            case 4:
                return "SHORTS";
            // Add your own types here
            default:
                return "Invalid Type";
        }
    }

    // Function to get cloth size from user choice
    private static String getSizeFromChoice(int choice) {
        switch (choice) {
            case 1:
                return "Small (S)";
            case 2:
                return "Medium (M)";
            case 3:
                return "Large (L)";
            case 4:
                return "Extra Large (XL)";
            case 5:
                return "Double Extra Large (XXL)";
            // Add your own sizes here
            default:
                return "Invalid Size";
        }
    }

    // Function to print donation details
    private static void printDonationDetails(String userName, String userAddress, ArrayList<Donation> userDonations) {
        System.out.println("\nDonation Details:");
        System.out.println("Name: " + userName);
        System.out.println("Address: " + userAddress);
        System.out.println("Donations:");

        for (Donation donation : userDonations) {
            if (donation instanceof ClothDonation) {
                ClothDonation clothDonation = (ClothDonation) donation;
                System.out.println("- Cloth: Type - " + clothDonation.clothType + ", Size - " + clothDonation.size);
            } else if (donation instanceof MoneyDonation) {
                MoneyDonation moneyDonation = (MoneyDonation) donation;
                System.out.println("- Money: Amount - $" + moneyDonation.amount);
            } else if (donation instanceof ToyDonation) {
                ToyDonation toyDonation = (ToyDonation) donation;
                System.out.println("- Toy: Type - " + toyDonation.toyType);
            } else if (donation instanceof BookDonation) {
                BookDonation bookDonation = (BookDonation) donation;
                System.out.println("- Book: Type - " + bookDonation.bookType);
            } else if (donation instanceof GroceriesDonation) {
                System.out.println("- Groceries: Add relevant details here");
            } else if (donation instanceof LeftoverFoodDonation) {
                System.out.println("- Leftover Food: Add relevant details here");
            }
        }
    }
}
