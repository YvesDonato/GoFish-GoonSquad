import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class GroupOfCardsTest {
    @Test
    public void testShuffle() {
        GroupOfCards newGroup = new GroupOfCards();
        GroupOfCards newGroup2 = new GroupOfCards();
        for (int i = 1; i <= 10; i++) {
            newGroup.addCard(new Card(i, 1));
            newGroup2.addCard(new Card(i, 1));
        }
        newGroup.shuffle();
        boolean atleastOneChange = false;
        for (int i = 0; i < 10; i++) {
            if (newGroup.getCard(i).getValNum() != newGroup2.getCard(i).getValNum()) {
                atleastOneChange = true;
            }
        }
        assertTrue(atleastOneChange);
    }

    @Test
    public void testTakeCard() {
        GroupOfCards newGroup = new GroupOfCards();
        newGroup.addCard(new Card(1, 1));
        newGroup.addCard(new Card(1, 1));

        assertEquals(2, newGroup.getSize());

        Card removedCard = newGroup.takeCard(0);

        assertFalse(newGroup.getCards().contains(removedCard));
        assertEquals(1, newGroup.getSize());
    }
}
