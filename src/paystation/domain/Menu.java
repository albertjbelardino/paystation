//depositcoins()
//display()
//buyticket()
//cancel()
//changeratestrat()
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

import java.util.Scanner;

/**
 *
 * @author tue72283
 */
public class Menu {
    
    Scanner scan = new Scanner(System.in);
    PayStation ps = new PayStationImpl();
    
    public Menu() {
        int selection = -1;
        
        while(selection != 6) {
            displayMenu();
            selection = scan.nextInt();
            switch(selection) {
                case 1:
                    //depositCoins();
                case 2:
                    //display();
                case 3:
                    //buyTicket();
                case 4:
                    //cancel();
                case 5:
<<<<<<< HEAD
                    //changeRateStrategy();
=======
                    changeRateStrategy();
                    break;
                default:
                    System.out.println("Invalid input, enter a number from 1-6");
                    break;
>>>>>>> 2e1f7a5d51c1982a2a80d1442027f413842e16de
            }
        }
    }
    
    public static void displayMenu() {
        // Display menu graphics
        System.out.println("============================");
        System.out.println("|   PayStation Menu    |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. DepositCoins       |");
        System.out.println("|        2. Display                 |");
        System.out.println("|        3. Buy ticket                |");
        System.out.println("|        4. Cancel                     |");
        System.out.println("|        5. Change Rate Strategy       |");       
        System.out.println("============================");
    }
    
    public void display(){
        System.out.println("You have purchased " + ps.readDisplay() + " minutes");
    }
    
    public void buyTicket(){
        display();
        ps.buy();
    }
}
