package Service;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;

public class SBI implements Bank {

  private double bal;

  public double withdraw(double amt)
    throws InsufficientBalanceException, InvalidAmountException {
    try {
      if (amt <= 0) {
        throw new InvalidAmountException("Invalid amount entered by user");
      } else if (amt > bal) {
        throw new InsufficientBalanceException(
          "There isn't much money in your account"
        );
      }
    } catch (InvalidAmountException e) {
      System.out.println("Invalid amount entered by user");
    } catch (InsufficientBalanceException e) {
      System.out.println("There isn't much money in your account");
    }
    return bal = bal - amt;
  }

  public void deposite(double amt) throws InvalidAmountException {
    try {
      if (amt <= 0) {
        throw new InvalidAmountException("Invalid amount eneterd by user");
      }
    } catch (InvalidAmountException e) {
      System.out.println("Invalid amount entered by user");
    }
    bal = bal + amt;
  }
}
