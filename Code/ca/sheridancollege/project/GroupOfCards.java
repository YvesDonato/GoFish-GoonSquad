//package ca.sheridancollege.project;
/**
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modified by Yves Donato
 * @modified by David Vallecampo
 */
import java.util.ArrayList;
import java.util.Collections;
// Group of Cards or deck
public class GroupOfCards {
    private ArrayList<Card> cards = new ArrayList<Card>(); // arraylist of Cards

    // Getters and Setters
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getCard(int i){
        return cards.get(i);
    }

    public Card takeCard(int i){
        Card card = getCard(i);
        cards.remove(i);
        return card;
    }

    public int getSize() {
        return cards.size();
    }

    // Shuffle the cards within the arraylist
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Prints out the cards
    public void showCards(){
        for(Card card: cards){
            System.out.println(card);
        }
    }
}
