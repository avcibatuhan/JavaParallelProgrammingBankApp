/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asogukb
 */
public class Account {
	private int balance = 6000;

    Account(int balance) {
       this.balance = balance; 
    }
    
    public synchronized void deposit(long amount) {
        checkAmountNonNegative(amount);
        balance += amount;
    }
    
    private static void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }

	public int getBalance() {
		return balance;
	}
	public void withdraw(int amount) {
		balance = balance - amount;
	}
}
