/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asogukb
 */
public class Person {
        String name;
        String userName;
        int balance;
        
        Person(String name, String userName,int balance){
        this.name = name;
        this.userName = userName;
        this.balance = balance;
        }
        
        public int getBalance() {
		return balance;
	}
	public void withdraw(int amount) {
		balance = balance - amount;
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
}
