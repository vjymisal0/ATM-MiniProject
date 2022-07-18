package Service;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;

public interface Bank
{
    public abstract double withdraw(double amt) throws InsufficientBalanceException, InvalidAmountException;
    public abstract void deposite(double amt) throws InvalidAmountException;
}

