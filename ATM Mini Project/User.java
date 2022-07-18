import Service.Bank;
import Service.SBI;
import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;
import java.util.Scanner;

public class User {

  public static void main(String args[])
    throws InvalidAmountException, InsufficientBalanceException {
    String bankName = null, nextOption = null;
    int option = 0;
    double amount = 0.0, withdrawAmount = 0.0;
    Scanner sc = new Scanner(System.in);
    outerLoop:while (true) {
      System.out.println("Enter ATM Card (or Bank Name): ");
      bankName = "Service." + sc.next();
      try { //outer try
        Bank bank = (Bank) Class
          .forName(bankName)
          .getDeclaredConstructor()
          .newInstance();
        innerLoop:while (true) {
          System.out.println("Choose any of the Following: ");
          System.out.println("1. Withdraw");
          System.out.println("2. Deposite");
          System.out.println("3. Check Balance");
          System.out.println("4. Exit");
          option = sc.nextInt();
          try { //inner try
            switch (option) {
              case 1:
                System.out.println("Enter Amount to withdraw: ");
                amount = sc.nextDouble();
                withdrawAmount = bank.withdraw(amount);
                System.out.println("Withdraw Amount: " + withdrawAmount);
                break;
              case 2:
                System.out.println("Enter Amounnt ot deposite: ");
                amount = sc.nextDouble();
                bank.deposite(amount);
                break;
              case 3:
                System.out.println("Amount present in your Bank: " + amount);
                break;
              case 4:
                break innerLoop;
              default:
                System.out.println("Invalid option!");
            }
            System.out.println("Do you want to continue anymore? ");
            System.out.println("Enter Y or N: ");
            nextOption = sc.next();
            if ("N".equalsIgnoreCase(nextOption)) break outerLoop;
          } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
          } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
        }
      } catch (ClassNotFoundException e) {
        System.out.println(e.getMessage());
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
