
import java.util.Scanner;

// Names & IDs:
// Abdulaziz Alabdulkarim , 446170153
// Ziad Khalid, 446102036
// GitHub Repo Link: https://github.com/A3zewy/Member

public class LibrarySimulator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Member St1 = new Member(442157689, "Ali", 0);
        Member St2 = new Member(443157689, "Ziad", 0);
        Member St3 = new Member(444157689, "Abdulaziz", 0);

        boolean exit = true;

        while (exit) {

            System.out.println("\n======== Welcome to the Library Simulation ========");
            System.out.println("Select option:");
            System.out.println("1. Login as (" + St1.getId() + ") (" + St1.getName() + ")");
            System.out.println("2. Login as (" + St2.getId() + ") (" + St2.getName() + ")");
            System.out.println("3. Login as (" + St3.getId() + ") (" + St3.getName() + ")");
            System.out.println("4. Login as Administrator");
            System.out.println("5. Exit the program");

            int Choice = input.nextInt();

            if (Choice >= 1 && Choice <= 3) {

                Member current = null;

                if (Choice == 1)
                    current = St1;
                else if (Choice == 2)
                    current = St2;
                else if (Choice == 3)
                    current = St3;

                boolean Session = true;

                while (Session) {

                    System.out.println("\nWelcome " + current.getName() + "!");
                    System.out.println("1. View borrowed books");
                    System.out.println("2. Borrow book");
                    System.out.println("3. Return book");
                    System.out.println("4. View session summary");
                    System.out.println("5. Exit to main menu");
                    System.out.print("Choose an option: ");

                    int userAction = input.nextInt();

                    switch (userAction) {
                        case 1:
                            current.viewBorrowedCount();
                            break;

                        case 2:
                            current.borrowOne();
                            break;

                        case 3:
                            current.returnOne();
                            break;

                        case 4:
                            current.displayStatistics();
                            break;

                        case 5:
                            current.reset();
                            Session = false;
                            break;

                        default:
                            System.out.println("Invalid input, try again.");
                    }
                }
            }

            else if (Choice == 4) {

                boolean adminActive = true;

                while (adminActive) {

                    System.out.println("\n======== Welcome Admin ========");
                    System.out.println("1. View Total Revenue");
                    System.out.println("2. Most Frequent Operation");
                    System.out.println("3. Exit to Main Menu");
                    System.out.print("Choose an option: ");

                    int adminAction = input.nextInt();

                    switch (adminAction) {

                        case 1:
                            System.out.printf("The Total Revenue is: %.2f\n", Member.TotalRevenue);
                            break;

                        case 2:
                            if (Member.TotalBorrows > Member.TotalReturns)
                                System.out.println("Most frequent operation is Borrow: " + Member.TotalBorrows);
                            else if (Member.TotalReturns > Member.TotalBorrows)
                                System.out.println("Most frequent operation is Return: " + Member.TotalReturns);
                            else
                                System.out.println("Operations are equal.\nBorrows: " + Member.TotalBorrows +
                                        "\nReturns: " + Member.TotalReturns);
                            break;

                        case 3:
                            adminActive = false;
                            break;

                        default:
                            System.out.println("Invalid input, try again.");
                    }
                }

            }

            else if (Choice == 5) {
                System.out.println("The program is managed by Abdulaziz and Ziad.");
                System.out.println("------- Goodbye! -------");
                exit = false;
            }

            else {
                System.out.println("Invalid input, try again.");
            }
        }

        input.close();
    }
}
