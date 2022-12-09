/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 11
*/

import java.util.Random;

public class CardHolder implements Runnable{
    private CreditCard card;

    CardHolder(CreditCard card){
        this.card = card;
    }

    @Override
    public void run() {
        Random random = new Random(7);
        int number = random.nextInt(6);
        for(int i = 0; i < number; i++) {
            makeWithdrawl();
        }
    }

    private synchronized void makeWithdrawl(){
        if(card.getBalance() < 500){
            System.out.println("Not enough funds in " + Thread.currentThread() + ". Balance: " + card.getBalance());
        } else {
            try{
                System.out.println(Thread.currentThread().getName() + ", before withdrawing 500, the balance is: " + card.getBalance());
                Thread.sleep(6000);
                card.makeWithdrawl(500);
                System.out.println(Thread.currentThread().getName() + " after making withdrawl of 500, Current Balance: " + card.getBalance());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
