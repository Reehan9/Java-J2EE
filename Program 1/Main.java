// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MissedCallManager manager = new MissedCallManager();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add contact");
            System.out.println("2. Add missed call");
            System.out.println("3. Display missed calls");
            System.out.println("4. Delete contact");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact phone number: ");
                    String phoneNumber = scanner.nextLine();
                    manager.addContact(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter missed call phone number: ");
                    String missedCallNumber = scanner.nextLine();
                    manager.acceptMissedCall(missedCallNumber);
                    break;
                case 3:
                    manager.displayMissedCalls();
                    break;
                case 4:
                    System.out.print("Enter a phone number to delete from contacts: ");
                    String numberToDelete = scanner.nextLine();
                    manager.deleteNumber(numberToDelete);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
