import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PlayerTest {
    @Test
    public void testAddCardToHand() {

        Player newPlayer = new Player("Daniel");

        newPlayer.addCardToHand(new Card(1, 1));
        Card newCard = new Card(2, 1);

        assertFalse(newPlayer.getHand().contains(newCard));

        newPlayer.addCardToHand(newCard);

        assertTrue(newPlayer.getHand().contains(newCard));
    }
}
