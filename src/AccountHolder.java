/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asogukb
 */
public class AccountHolder implements Runnable {
	private final Account account;
        private final int money;
	public AccountHolder(Account account,int money) {
		this.account = account;
                this.money = money;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			makeWithdrawal(money);
			if (account.getBalance() < 0) {
				System.out.println("Hesaptan fazla para çekildi. Hesapta para kalmamıştır!");
			}
		}
	}

	private  void makeWithdrawal(int withdrawAmount) {
		if (account.getBalance() >= withdrawAmount) {
			System.out.println(Thread.currentThread().getName()	+ " tarafından para çekiliyor $"+withdrawAmount);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException ex) {
			}
			account.withdraw(withdrawAmount);
			System.out.println(Thread.currentThread().getName()	+ " tarafından para çekme işlemi tamamlandı $"+withdrawAmount);
		} else {
			System.out.println("Para çekmek için  "	+ Thread.currentThread().getName() + " 'ın hesabında para kalmadı "
					+ account.getBalance());
		}
	}
}
