package exceptions;

public class InvalidAmountException extends Exception {

  public InvalidAmountException() {
    super();
  }

  public InvalidAmountException(String umsg) {
    super(umsg);
  }
}
