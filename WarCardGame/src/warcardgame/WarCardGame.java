/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package warcardgame;
import warcardgame.GameLogic;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class WarCardGame {

   //contains the main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.println("Hey "+name+"!, ");
        System.out.println("Welcome to the War!\n");

        System.out.println("Here are the game rules:");
        System.out.println("- The deck is divided equally between two players.");
        System.out.println("- Each player draws one card from their deck at a time.");
        System.out.println("- The player with the higher value card wins the round.");
        System.out.println("- If both players draw cards with the same value, a war is declared.");
        System.out.println("- In a war, each player draws four cards from their deck and puts them face down.");
        System.out.println("- Each player then draws one card from their deck and the player with the higher value card wins all the cards on the table.");
        System.out.println("- The game continues until one player has all the cards in the deck.");
        System.out.println("- In this case we also have placed a condition in  which at the end of the both players deck, the one with the most number of card in their collector deck wins.");

        GameLogic gl = new GameLogic();

        gl.playIt();

       }
    
}
