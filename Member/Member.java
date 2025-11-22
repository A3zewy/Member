package phase2;
import java.util.Scanner;
//                            https://github.com/A3zewy/Member
/*
 * 					Abdulaziz Alabdulkarim , 446170153
 * 					Ziad Khalid, 446102036
 * 
 */

public class Member {  
    // Instance attributes (session + persistent borrowedCount)  
    private int id;  
    private String name;  
    private int borrowedCount;      // number of books currently borrowed (persistent)  
    private int numViewBorrowed;    // number of times view borrowed count used (session)  
    private int numBorrows;         // number of borrow operations in this session  
    private int numReturns;         // number of return operations in this session  
    private double sessionFees;     // total fees incurred in the session  
  
    // Class-level totals (accumulate across all members/sessions)  
    public static double TotalRevenue = 0.0;  
    public static int TotalViewBorrowed = 0;  
    public static int TotalBorrows = 0;  
    public static int TotalReturns = 0;  
  
    // Constructor  
    public Member(int id, String name, int borrowedCount) {  
        this.id = id;  
        this.name = name;  
        this.borrowedCount = borrowedCount;  
      
    }  
  
    // Private helpers for constraints  
    private boolean canBorrow() {  
        return borrowedCount < 5;   //if true meaning that can borrow  
    }  
  
    private boolean canReturn() {  
        return borrowedCount > 0; //if true meaning that can return  
    }  
  
    // View current borrowed count (increments view counters)  
    public void viewBorrowedCount() {  
        numViewBorrowed++;  
        TotalViewBorrowed++;  
        System.out.println("Books currently borrowed: " + borrowedCount);  
    }  
  
    // Borrow one book: returns true if success, false otherwise  
    public boolean borrowOne() {  
        if (!canBorrow()) {  
            System.out.println("You cannot borrow more than 5 books.");  
            return false;  
        }  
        borrowedCount++;  
        numBorrows++;  
        TotalBorrows++;  
        sessionFees += 0.50;  
        TotalRevenue += 0.50;  
        System.out.printf("Book borrowed successfully. Fee: %.2f\n", 0.50);  
        return true;  
    }  
  
    // Return one book: returns true if success, false otherwise  
    public boolean returnOne() {  
        if (!canReturn()) {  
            System.out.println("You have no books to return.");  
            return false;  
        }  
        borrowedCount--;  
        numReturns++;  
        TotalReturns++;  
        System.out.println("Book returned successfully.");  
        return true;  
    }  
  
    // Display session statistics for this member  
    public void displayStatistics() {  
        System.out.println("====== Session Summary for " + name + " (ID: " + id + ") ======");  
        System.out.println("Books Borrowed (this session): " + numBorrows);  
        System.out.println("Books Returned (this session): " + numReturns);  
        System.out.println("Times View Borrowed Count used (this session): " + numViewBorrowed);  
        System.out.printf("Fees Incurred (this session): %.2f\n", sessionFees);  
    }  
  
    // Reset session statistics (used at the start of each login/session)  
    public void reset() {  
        this.numViewBorrowed = 0;  
        this.numBorrows = 0;  
        this.numReturns = 0;  
        this.sessionFees = 0.0;  
    }  
  
    // Getters & Setters as needed  
    public int getId() {  
        return id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public int getBorrowedCount() {  
        return borrowedCount;  
    }  
  
    public double getSessionFees() {  
        return sessionFees;  
    }  
  
    // Setter for borrowedCount if needed externally (not used in this program)  
}
 class LibararySimulator{

public static void main(String[]args) {
	Scanner input=new Scanner(System.in);
	
	Member St1=new Member(442157689,"Ali",0);
	Member St2=new Member(443157689,"ziad",0);
	Member St3=new Member(444157689,"abdulaziz",0);
boolean exit= true ; 
	while(exit) {//starting while
	System.out.println("\n========welcome to the libarary simulation========.");
	System.out.println("Select option :");
	System.out.println("1.login as "+"("+St1.getId()+")"+" ("+St1.getName()+")");
	System.out.println("2.login as "+"("+St2.getId()+")"+" ("+St2.getName()+")");
	System.out.println("3.login as "+"("+St3.getId()+")"+" ("+St3.getName()+")");
	System.out.println("4. login as Administrator ");
	System.out.println("5. exit the program ");
	int Choice=input.nextInt();
	if (1<=Choice&&3>=Choice) {// check user input 
		Member current=null;
		if(Choice==1)
			current=St1;
		
		else if(Choice==2) {
			current=St2;
	}
		else if (Choice==3) {
			current =St3;
		}
		boolean Session =true;
		while(Session) {// starting session while 
			
			System.out.println("\n welcome  "+current.getName()+"!");
			System.out.println("1. view borrowed books ");
			System.out.println("2. borrow book");
			System.out.println("3. return book ");
			System.out.println("4. view session summary ");
			System.out.println("5. exit to main menu");
			System.out.println("choice an option :");
			int userAcction=input.nextInt();
			switch(userAcction) {
			case 1 :
				current.viewBorrowedCount();
				break; // close case 1
			case 2:
				current.borrowOne();
				break;//close case 2
			case 3:
				current.returnOne();
				break;//close case 3
			case 4:
				current.displayStatistics();
				break;//close case 4
			case 5:
					current.rest();
				Session =false;
				break;//close case 5
				default:
					System.out.println("invalid input try again ");
			
			}// close switch user acction 
				
		}// close session while
		
	
	}// close if statetement
	
	else if (Choice==4) {//start choice admin
		boolean adminActive =true ; 
		
		while(adminActive){//start while admin
		System.out.println("\n======== Welcome Admin ========");
		System.out.println("1. view total Revenue  ");
		System.out.println("2. Most frequent opration  ");
		System.out.println("3. Exit to Main Menu  ");
		System.out.println("Choice an option  ");
int adminAction=input.nextInt();

	switch(adminAction) {//start switch admin
	case 1: System.out.printf("The total Revenue is "+Member.TotalRevenue);
	break;//break case 1 
	
	case 2 :{if(Member.TotalBorrows>Member.TotalReturns) 
		System.out.println("Most frequent opration is Borrow : "+Member.TotalBorrows);
		else if (Member.TotalBorrows<Member.TotalReturns) 
			System.out.println("Most frequent opration is Returns : "+Member.TotalReturns);
		else
			System.out.println("The Oprations are equal /n the borrows are : "+Member.TotalBorrows+" /n and the returns are :  "+Member.TotalReturns);
	}
	break; //break case 2 
	case 3 : adminActive=false ; 
break ; //break case 3 
default : System.out.println("invalid input try agian ");

	}//close switch admin
	
		}//close while admin
		
		
	}//close admin 
	else if (Choice==5) {
	
		System.out.println("THE PROGRAM IS MANAGED BY ABDULAZIZ AND ZIAD.");
        System.out.println("-------goodbye!!-------");
	exit = false ;//end the program 
	}
	else {System.out.println("invalid input try agian");
		
	}
	

	
}//close while 


}
}
 



