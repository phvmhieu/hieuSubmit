/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaccount;

/**
 *
 * @author hieu
 */
class account{
    double balance;

    public account(double balance) {
        this.balance = balance;
    }
}

class users implements Runnable{
    account ac;
    int count = 5;
    double amount;
    int choice;

    public users(account ac) {
        this.ac = ac;
    }

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(count != 0){
            synchronized(ac){
                if(this.choice == 1){
                    ac.balance += amount;
                    this.count--;
                    System.out.println("Nap: " + amount + " So du hien tai la: " + ac.balance);
                }else if(this.choice == 2){
                    if(ac.balance >= amount){
                        ac.balance -= amount;
                        this.count--;
                        System.out.println("Rut: " + amount + " So du hien tai la: " + ac.balance);
                    }else{
                        System.out.println("So du khong du!");
                    }
                }else{
                    System.out.println("Nhap lai lua chon!");
                }
            }
        }else{
            System.out.println("Su dung het so lan giao dich!");
        }
    }
    
}