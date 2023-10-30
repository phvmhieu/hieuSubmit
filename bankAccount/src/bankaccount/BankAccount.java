/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankaccount;

import java.util.Scanner;


/**
 *
 * @author hieu
 */
public class BankAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        account ac = new account(100);
        users user1 = new users(ac);
        users user2 = new users(ac);
        users user3 = new users(ac);
        int choice;
        boolean check = true;
        while(check == true){
            System.out.println("============MENU============");
            System.out.println("========= 1. user 1 ========");
            System.out.println("========= 2. user 2 ========");
            System.out.println("========= 3. user 3 ========");
            System.out.println("========= 4. Exit   ========");
            System.out.println("============================");
            choice = sc.nextInt();
            switch(choice){
                case 1-> {
                    System.out.println("1. De nap tien");
                    System.out.println("2. De rut tien");
                    user1.choice = sc.nextInt();
                    System.out.println("Nhap so tien: ");
                    user1.amount = sc.nextDouble();
                    Thread thread1 = new Thread(user1);
                    thread1.start();
                    thread1.join();
                }
                case 2-> {
                    System.out.println("1. De nap tien");
                    System.out.println("2. De rut tien");
                    user2.choice = sc.nextInt();
                    System.out.println("Nhap so tien: ");
                    user2.amount = sc.nextDouble();
                    Thread thread2 = new Thread(user2);
                    thread2.start();
                    thread2.join();
                }
                case 3-> {
                    System.out.println("1. De nap tien");
                    System.out.println("2. De rut tien");
                    user3.choice = sc.nextInt();
                    System.out.println("Nhap so tien: ");
                    user3.amount = sc.nextDouble();
                    Thread thread3 = new Thread(user3);
                    thread3.start();
                    thread3.join();
                }
                case 4-> {
                    check = false;
                }
            }
        }
        
    }
    
}
