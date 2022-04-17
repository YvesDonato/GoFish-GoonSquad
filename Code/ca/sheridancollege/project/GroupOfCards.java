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

public class GroupOfCards {
    private ArrayList<Card> cards = new ArrayList();
    private int size = 0;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(Card card) {
        cards.add(card);
    }

    public Card getCard(int i){
        return cards.get(i);
    }
    public void removeCard(int i){
        cards.remove(i);
    }
    public int getSize() {
        size = cards.size();
        return size;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void showCards(){
        for(Card card: cards){
            System.out.println(card);
        }
    }
}
