//package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 *
 * @author by Yves Donato
 * @author by David Vallecampo
 */
public class Player {
    private String name;
    private GroupOfCards hand = new GroupOfCards();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Card getCard(int i) {
        return hand.getCard(i);
    }

    public void removeCard(int i) {
        hand.removeCard(i);
    }

    public void setHand(Card card) {
        hand.setCards(card);
    }

    public void showHand(){
        System.out.println("\n" + name + "'s " +
                "Hand:");
        hand.showCards();
    }
    public int getSize() {
        return hand.getSize();
    }


}
