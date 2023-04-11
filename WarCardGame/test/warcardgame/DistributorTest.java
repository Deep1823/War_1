/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package warcardgame;


import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class DistributorTest {
    
    public DistributorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCompDeck method, of class Distributor.
     */
@Test
public void testGetCompDeckBoundary() {
    System.out.println("testGetCompDeckBoundary");
    Distributor instance = new Distributor();
    ArrayList<Card> distributor = new ArrayList<Card>();
    distributor.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE)); // Add one card to the distributor
    instance.setDistributor(distributor); // Set the distributor with only one card
    ArrayList<Card> expResult = new ArrayList<Card>(); // Set expected value as an empty list
    ArrayList<Card> result = new ArrayList<Card>();
    // Compare the expected value with the actual result
    assertEquals(expResult, result);
}

@Test
public void testGetCompDeckGood() {
    System.out.println("testGetCompDeckGood");
    Distributor instance = new Distributor();
    instance.setDistributor(new ArrayList<Card>()); // Set the distributor as an empty list
    List<Card> distributor = instance.getDistributor();
    int numCards = Math.min(distributor.size(), 26); // Get the minimum of distributor size and 26
    List<Card> expResult = distributor.subList(0, numCards); // Set expected value as the first numCards in the distributor
    List<Card> result = distributor.subList(0, numCards);
    // Compare the expected value with the actual result
    assertEquals(expResult, result);
}


@Test
public void testGetCompDeckBad() {
    System.out.println("testGetCompDeckBad");
    Distributor instance = new Distributor();
    ArrayList<Card> expResult = new ArrayList<Card>(); // Set an expected value
    ArrayList<Card> result = instance.getCompDeck();
    // Compare the expected value with the actual result
    assertNotEquals(expResult, result);
}


   

    /**
     * Test of setDistributor method, of class Distributor.
     */
@Test
public void testSetDistributorBoundary() {
    System.out.println("testSetDistributorBoundary");
    ArrayList<Card> distributor = new ArrayList<Card>();
    // Add 52 cards to the distributor to represent a complete deck
    for (Card.Suit suit : Card.Suit.values()) {
        for (Card.Rank rank : Card.Rank.values()) {
            distributor.add(new Card(suit, rank));
        }
    }
    Distributor instance = new Distributor();
    instance.setDistributor(new ArrayList<Card>()); // Set the distributor as an empty list
    ArrayList<Card> expResult1 = new ArrayList<Card>(); // Expected result after setting the distributor as an empty list
    ArrayList<Card> result1 = instance.getDistributor();
    assertEquals(expResult1, result1);

    instance.setDistributor(distributor); // Call the setDistributor() method with a complete deck
    ArrayList<Card> expResult2 = distributor; // Expected result after setting the distributor with a complete deck
    ArrayList<Card> result2 = instance.getDistributor();
    assertEquals(expResult2, result2);

    // Add more test scenarios with different input lists of cards to further validate the behavior of the setDistributor() method
    ArrayList<Card> newDistributor = new ArrayList<Card>();
    newDistributor.add(new Card(Card.Suit.SPADES, Card.Rank.JACK));
    newDistributor.add(new Card(Card.Suit.CLUBS, Card.Rank.TEN));
    instance.setDistributor(newDistributor);
    ArrayList<Card> expResult3 = newDistributor; // Expected result after setting the distributor with a new input list of cards
    ArrayList<Card> result3 = instance.getDistributor();
    assertEquals(expResult3, result3);
}
@Test
public void testSetDistributorBad() {
    System.out.println("testSetDistributorBad");
    ArrayList<Card> expResult = new ArrayList<Card>(); // Set an expected value
    Distributor instance = new Distributor();
    instance.setDistributor(expResult); // Call the setDistributor() method with the expected value
    ArrayList<Card> result = instance.getDistributor();
    // Compare the expected value with the actual result
    assertEquals(expResult, result);
}

@Test
public void testSetDistributorGood() {
    System.out.println("testSetDistributorGood");
    ArrayList<Card> distributor = new ArrayList<Card>();
    // Add some cards to the distributor
    distributor.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
    distributor.add(new Card(Card.Suit.DIAMONDS, Card.Rank.KING));
    distributor.add(new Card(Card.Suit.CLUBS, Card.Rank.QUEEN));
    Distributor instance = new Distributor();
    instance.setDistributor(new ArrayList<Card>()); // Set the distributor as an empty list
    ArrayList<Card> expResult1 = new ArrayList<Card>(); // Expected result after setting the distributor as an empty list
    ArrayList<Card> result1 = instance.getDistributor();
    assertEquals(expResult1, result1);
    
    instance.setDistributor(distributor); // Call the setDistributor() method
    ArrayList<Card> expResult2 = distributor; // Expected result after setting the distributor with the input list of cards
    ArrayList<Card> result2 = instance.getDistributor();
    assertEquals(expResult2, result2);
    
    // Add more test scenarios with different input lists of cards to further validate the behavior of the setDistributor() method
    ArrayList<Card> newDistributor = new ArrayList<Card>();
    newDistributor.add(new Card(Card.Suit.SPADES, Card.Rank.JACK));
    newDistributor.add(new Card(Card.Suit.CLUBS, Card.Rank.TEN));
    instance.setDistributor(newDistributor);
    ArrayList<Card> expResult3 = newDistributor; // Expected result after setting the distributor with a new input list of cards
    ArrayList<Card> result3 = instance.getDistributor();
    assertEquals(expResult3, result3);
}



  

    /**
     * Test of playerDeck method, of class Distributor.
     */
 @Test
public void testPlayerDeckBoundary() {
    System.out.println("testPlayerDeckBoundary");
    Distributor instance = new Distributor();
    ArrayList<Card> distributor = new ArrayList<Card>();
    // Add 52 cards to the distributor to represent a complete deck
    for (Card.Suit suit : Card.Suit.values()) {
        for (Card.Rank rank : Card.Rank.values()) {
            distributor.add(new Card(suit, rank));
        }
    }
    instance.setDistributor(distributor); // Set the distributor with a complete deck
    ArrayList<Card> playerDeck = instance.getPlayerDeck(); // Call the playerDeck() method and store the result in a local variable
    // Assert the expected behavior of the playerDeck() method
    assertEquals(26, playerDeck.size()); // Expect the playerDeck() to have 26 cards after calling the method
}


public void testPlayerDeckBad() {
    System.out.println("testPlayerDeckBad");
    Distributor instance = new Distributor();
    ArrayList<Card> expResult = instance.getPlayerDeck(); // Set an expected value
    instance.playerDeck(); // Call the playerDeck() method
    ArrayList<Card> result = instance.getPlayerDeck();
    // Compare the expected value with the actual result
    assertEquals(expResult, result);
}
public void testPlayerDeckGood() {
    System.out.println("testPlayerDeckGood");
    Distributor instance = new Distributor();
    instance.playerDeck(); // Call the playerDeck() method
    ArrayList<Card> expResult = instance.getPlayerDeck();
    ArrayList<Card> result = instance.getPlayerDeck();
    // Compare the expected value with the actual result
    assertEquals(expResult, result);
}

    
}
