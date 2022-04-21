import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class GoFishTest {

    @Test
    public void testGetWinnerWithWinner() {
        GoFish newFish = new GoFish();
        newFish.createDeck();

        ArrayList<Card> player1Cards = new ArrayList<Card>();
        ArrayList<Card> player2Cards = new ArrayList<Card>();
        for (int i = 1; i <= 4; i++) {
            player1Cards.add(new Card(1, i));
            player2Cards.add(new Card(2, i));
            player2Cards.add(new Card(3, i));
        }

        newFish.addPlayer("Player1", player1Cards);
        newFish.addPlayer("Player2", player2Cards);
        String winner = newFish.getWinner();

        assertEquals("Player2", winner);
    }

    @Test
    public void testGetWinnerWithDraw() {
        GoFish newFish = new GoFish();
        newFish.createDeck();

        ArrayList<Card> player1Cards = new ArrayList<Card>();
        ArrayList<Card> player2Cards = new ArrayList<Card>();
        for (int i = 1; i <= 4; i++) {
            player1Cards.add(new Card(1, i));
            player2Cards.add(new Card(2, i));
        }

        newFish.addPlayer("Player1", player1Cards);
        newFish.addPlayer("Player2", player2Cards);
        String winner = newFish.getWinner();

        assertEquals("DRAW", winner);
    }

    @Test
    public void testGameOverCheckTrue() {
        GoFish newFish = new GoFish();
        newFish.createDeck();

        newFish.addPlayer("Player1", new ArrayList<Card>());
        newFish.addPlayer("Player2", new ArrayList<Card>());

        for (int i = 1; i <= 52; i++) {
            newFish.getDeck().takeCard(0);
        }

        assertTrue(newFish.gameOverCheck());
    }

    @Test
    public void testGameOverCheckFalse() {
        GoFish newFish = new GoFish();
        newFish.createDeck();

        newFish.addPlayer("Player1", new ArrayList<Card>());
        newFish.addPlayer("Player2", new ArrayList<Card>());

        assertFalse(newFish.gameOverCheck());
    }
}
