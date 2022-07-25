/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asogukb
 */
public class AccountThread implements Runnable {

    private final Account from;
    private final Account to;
    private final int amount;

    public AccountThread(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            // my realization
            makeWithdrawal(2000);
            if (from.getBalance() < 0) {
                System.out.println("Hesaptan fazla para çekildi. Hesapta para kalmamıştır!!");
            }
        }
    }

    private void makeWithdrawal(int withdrawAmount) {
        if (from.getBalance() >= withdrawAmount) {
            System.out.println(Thread.currentThread().getName() + " hesaptan çekilecek para $" + withdrawAmount);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println(Thread.currentThread().getName() + " para alışveriş işlemi tamamlanmıştır. Hesapta kalan para $" + from.getBalance());
            System.out.println(Thread.currentThread().getName() + " Paranın aktarıldığı hesaptaki para $" + to.getBalance());
        } else {
            System.out.println("Para çekmek için " + Thread.currentThread().getName() + " 'ın hesabında para kalmadı."
                    + from.getBalance());
        }
    }
}
