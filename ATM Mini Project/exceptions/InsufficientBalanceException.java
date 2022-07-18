package exceptions;

public class InsufficientBalanceException extends Exception {

  public InsufficientBalanceException() {
    super();
  }

  public InsufficientBalanceException(String umsg) {
    super(umsg);
  }
}
