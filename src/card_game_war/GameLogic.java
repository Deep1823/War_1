package warcardgame;

import warcardgame.Distributor;
import warcardgame.Card;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic extends Distributor {

    // all the arrayLists used in this class
    private ArrayList<Card> playerCollectorDeck = new ArrayList<Card>();
    private ArrayList<Card> compCollectorDeck = new ArrayList<Card>();
    private ArrayList<Card> warCollectingPlayerDeck = new ArrayList<Card>();
    private ArrayList<Card> warCollectingComputerDeck = new ArrayList<Card>();
    // datafileds
    private int playerScoreCounter, compScoreCounter = 0;
    private int randomNumComp = (int) (Math.random() * 26);

    public GameLogic() {
        super();
    }

    public ArrayList<Card> getPlayerCollectorDeck() {
        return playerCollectorDeck;
    }

    public void setPlayerCollectorDeck(ArrayList<Card> playerCollectorDeck) {
        this.playerCollectorDeck = playerCollectorDeck;
    }

    public ArrayList<Card> getCompCollectorDeck() {
        return compCollectorDeck;
    }

    public void setCompCollectorDeck(ArrayList<Card> compCollectorDeck) {
        this.compCollectorDeck = compCollectorDeck;
    }

    public ArrayList<Card> getWarCollectingPlayerDeck() {
        return warCollectingPlayerDeck;
    }

    public void setWarCollectingPlayerDeck(ArrayList<Card> warCollectingPlayerDeck) {
        this.warCollectingPlayerDeck = warCollectingPlayerDeck;
    }

    public ArrayList<Card> getWarCollectingComputerDeck() {
        return warCollectingComputerDeck;
    }

    public void setWarCollectingComputerDeck(ArrayList<Card> warCollectingComputerDeck) {
        this.warCollectingComputerDeck = warCollectingComputerDeck;
    }

    public int getPlayerScoreCounter() {
        return playerScoreCounter;
    }

    public void setPlayerScoreCounter(int playerScoreCounter) {
        this.playerScoreCounter = playerScoreCounter;
    }

    public int getCompScoreCounter() {
        return compScoreCounter;
    }

    public void setCompScoreCounter(int compScoreCounter) {
        this.compScoreCounter = compScoreCounter;
    }

    public int getRandomNumComp() {
        return randomNumComp;
    }

    public void setRandomNumComp(int randomNumComp) {
        this.randomNumComp = randomNumComp;
    }

    // main logic
    public void playIt() {

        Scanner sc = new Scanner(System.in);

        System.out.println("You have: ");
        System.out.println(super.getPlayerDeck());
        System.out.println();

        // System.out.println(super.getCompDeck());
        System.out.print("Enter the index number of card you want to play: ");
        int index = sc.nextInt();
        Card playerCard = super.getPlayerDeck().get(index);
        Card computerCard = super.getCompDeck().get(randomNumComp);

        // System.out.println(super.getPlayerDeck().get(index));
        // System.out.println(super.getCompDeck().get(randomNumComp));
        while (!(super.getCompDeck().isEmpty()) || !(super.getPlayerDeck().isEmpty())) {
            randomNumComp = (int) (Math.random() * (super.getCompDeck().size() - 1));
            playerCard = super.getPlayerDeck().get(index);
            computerCard = super.getCompDeck().get(randomNumComp);

            if (playerCard.getValue() > computerCard.getValue()) {

                System.out.println("\nYou Won!!");
                playerCollectorDeck.add(computerCard);
                playerCollectorDeck.add(playerCard);
                super.getCompDeck().remove(computerCard);
                super.getPlayerDeck().remove(playerCard);
                playerScoreCounter++;
            } else if (playerCard.getValue() == computerCard.getValue()) {
                 System.out.println("Your Play: " + playerCard);
            System.out.println("Computer's Play: " + computerCard + "\n");
                while(playerCard.getValue() == computerCard.getValue()){
                    super.getPlayerDeck().remove(playerCard);

                if (super.getPlayerDeck().isEmpty() || super.getPlayerDeck().size() < 4) {
                    super.setPlayerDeck(playerCollectorDeck);
                }

                System.out.println("\nSame value it's a WAR !!!");
                System.out.println("Drawing the firs four cards from both decks...");
                System.out.println("Now you have: ");
                System.out.println(super.getPlayerDeck());

                for (int i = 0; i < 4; i++) {
                    warCollectingPlayerDeck.add(i, super.getPlayerDeck().get(i));
                    warCollectingComputerDeck.add(i, super.getCompDeck().get(i));
                }

                System.out.println("Now draw any card from the deck...");
                System.out.print("Enter the card number you want to draw(ideally the one after the four cards i.e(index no.4): ");
                index = sc.nextInt();
                randomNumComp = (int) (Math.random() * (super.getCompDeck().size() - 1));
                playerCard = super.getPlayerDeck().get(index);
                computerCard = super.getCompDeck().get(randomNumComp);

                if (playerCard.getValue() > computerCard.getValue()) {
                    randomNumComp = (int) (Math.random() * (super.getCompDeck().size() - 1));
                    System.out.println("\nYou Won!!");
                    for (int i = 0; i < 4; i++) {

                        playerCollectorDeck.add(warCollectingComputerDeck.get(i));
                        playerCollectorDeck.add(warCollectingPlayerDeck.get(i));
                        super.getCompDeck().remove(warCollectingComputerDeck.get(i));
                        super.getPlayerDeck().remove(warCollectingPlayerDeck.get(i));

                    }

                    playerCollectorDeck.add(computerCard);
                    playerCollectorDeck.add(playerCard);
                    super.getCompDeck().remove(computerCard);
                    super.getPlayerDeck().remove(playerCard);
                    playerScoreCounter++;

                } else {

                    System.out.println("\nThe computer won");
                    for (int i = 0; i < 4; i++) {
                        compCollectorDeck.add(warCollectingPlayerDeck.get(i));
                        compCollectorDeck.add(warCollectingComputerDeck.get(i));
                        super.getCompDeck().remove(warCollectingComputerDeck.get(i));
                        super.getPlayerDeck().remove(warCollectingPlayerDeck.get(i));
                    }

                    compCollectorDeck.add(computerCard);
                    compCollectorDeck.add(playerCard);
                    super.getCompDeck().remove(computerCard);
                    super.getPlayerDeck().remove(playerCard);
                    compScoreCounter++;

                }

                System.out.println(warCollectingComputerDeck + "\n" + warCollectingPlayerDeck);
                    
                }

                

            } else {
                randomNumComp = (int) (Math.random() * (super.getCompDeck().size() - 1));
                System.out.println("\nThe computer won");
                compCollectorDeck.add(computerCard);
                compCollectorDeck.add(playerCard);
                super.getCompDeck().remove(computerCard);
                super.getPlayerDeck().remove(playerCard);
                compScoreCounter++;

            }

            System.out.println("Your Play: " + playerCard);
            System.out.println("Computer's Play: " + computerCard + "\n");
            System.out.println("Now you have: ");
            System.out.println(super.getPlayerDeck());

            if (super.getPlayerDeck().isEmpty()) {
                break;
            }
            System.out.print("Enter any card number: ");
            index = sc.nextInt();

        }

//        System.out.println("Your score: " + playerScoreCounter + " \n" + "Computer's Score: " + compScoreCounter);
        System.out.println("Your collector Deck: " + playerCollectorDeck.size() + "\n" + "Computer's collector Deck: " + compCollectorDeck.size());

        if (playerCollectorDeck.size() > compCollectorDeck.size()) {
            System.out.println("Congrulations!!\nYou have won the game!");
        } else if (playerCollectorDeck.size() == compCollectorDeck.size()) {
            System.out.println("It's a tie between the computer and you!!");
        } else {
            System.out.println("Computer won the game\nBetter luck next time");
        }
        sc.close();
    }
}
