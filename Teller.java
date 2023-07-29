import java.util.Scanner;
import javax.naming.InsufficientResourcesException;
import javax.security.auth.login.AccountNotFoundException;

//The code starts by creating a Teller object.
public class Teller {
    public static void main(String[] args) throws AccountNotFoundException, InsufficientResourcesException, NegativeArraySizeException{
        Teller menu = new Teller();
        menu.display();
    }
    /*This code defines a new instance of Bank called bank.
    It then creates an instance of BankAccount called bankAccount.*/
    Bank bank = new Bank();
    BankAccount bankAccount = new BankAccount();
    
    //A Scanner object is used to read input from the user, who enters their bank account number into the program's input field.
    Scanner scanner = new Scanner(System.in);
   
    //The main method then calls the display() method of the newly created Teller object, which displays a menu of options to the user.
    public void display() throws AccountNotFoundException, InsufficientResourcesException, NegativeArraySizeException {
    	System.out.println("-----------------------------------------------");
    	System.out.println("Welcome to the Jamaica Bank of the West Indies!"); //Displays a welcome message to the user. 
    	System.out.println("-----------------------------------------------");
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        	System.out.println("**************************************************");
        	System.out.println("Please enter a number from the following menu: ");
        	  System.out.println("1) Open a new account.\n" +
                      "2) Open an existing account.\n" +
                      "3) View total assets of all bank accounts.\n" +
                      "4) Delete an account.\n"+
                      "5) Edit account.\n"+
                      "6) Exit.");
            System.out.println("***************************************************");

        int number1 = scanner.nextInt();

        //Continues to ask the user for input until they asks to exit.
        if (number1 == 1) {
            bankAccount = bank.createAccount(scanner.nextLine());
            display2();
        }
        else if (number1 == 2){ 
            bank.findAccount(bankAccount.getAccountName());
            display2();
        }
        else if (number1 == 3){
            bank.getTotalAssets(null);
            display2();
        }
        else if (number1 == 4) {
            bank.getDelete();
            display2();
            }
    	else if (number1 == 5) {
			bank.getEdit();
    		display2();
        }
        else if (number1 == 6){ 
        	System.out.println("-------------------------------------");
            System.out.println("Thank you for doing business with us!"); //Displays a message to the user when they close the program.
            System.out.println("-------------------------------------"); 
            System.exit(0);
        }
        else {
            System.out.println("\nInvalid selection!"); //Displays a message if an invalid option is entered. 
            display();
    		}
    }

    public void display2() throws AccountNotFoundException, InsufficientResourcesException, NegativeArraySizeException {
        while (true){
            //Second menu.
        	System.out.println();
        	System.out.println("***************************************************");
            System.out.println("Please enter a number from the following list: ");
            System.out.println("1) Withdraw from an account\n" +
                    "2) Deposit to an account\n" +
                    "3) Check account balance\n" +
                    "4) Choose interest rate for your account\n" +
                    "5) Go back\n" +
                    "6) Exit");
            System.out.println("***************************************************");

            int number2 = scanner.nextInt();
            if (number2 == 1){
                //Withdraw method including subtracting input from balance.
                System.out.println("\nPlease enter the amount you would like to withdraw: ");
                double debit = scanner.nextDouble();
                bank.findAccount(bankAccount.getAccountName()).withdraw(debit);
                System.out.println("\nYour new balance is: " + bank.findAccount(bankAccount.getAccountName()).getBalance());
            }
            else if (number2 == 2){
                //Deposit method including converting input to cents.
                System.out.println("\nPlease enter the amount would like to deposit, in a whole number: ");
                int depositAmount = scanner.nextInt();
                bank.findAccount(bankAccount.getAccountName()).deposit(depositAmount);
                System.out.println("\nYour new balance is: " + bank.findAccount(bankAccount.getAccountName()).getBalance());
            }
            else if (number2 == 3){
                System.out.println("\nYour balance is " + bank.findAccount(bankAccount.getAccountName()).getBalance());
            }
            else if (number2 == 4){
                System.out.println("\nPlease enter your desired interest rate. \nExample: 0.05 is 5%. \nYour balance will not reflect your interest rate if you currently have less than $1000.");
                double rate = scanner.nextDouble();
                bank.findAccount(bankAccount.getAccountName()).setInterestRate(rate);
                System.out.println("\nYour new interest rate is " + bank.findAccount(bankAccount.getAccountName()).getInterestRate(rate)); //Shows the user their interest rate. 
            }
            else if (number2 == 5){
                display();
            }
            else if (number2 == 6){
            	System.out.println("-------------------------------------");
                System.out.println("Thank you for doing business with us."); //Displays a message after the program is closed. 
                System.out.println("-------------------------------------");
                System.exit(0);
            }
            else{
                System.out.println("\nInvalid selection!"); //Displays a message if an incorrect option is entered.  
                display2();

            }
        }
    } //End of main class.

	} //End of class. 
