import java.util.ArrayList;

/**
 *
 * @author by Yves Donato
 * @author by David Vallecampo
 */
// Class of the player contains the name, hand, and number of books
public class Player {
    private String name;
    private GroupOfCards hand = new GroupOfCards();

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getBooks() {
        int books = 0;
        for (int x = 1; x <= 13; x++) {
            int y = x;
            if (getHand().stream().filter((f) -> f.getValNum() == y).count() == 4) {
                books++;
            }
        }
        return books;
    }

    public String getName() {
        return name;
    }

    public Card getCard(int i) {
        return hand.getCard(i);
    }

    public Card takeCard(int i) {
        return hand.takeCard(i);
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public ArrayList<Card> getHand() {
        return hand.getCards();
    }

    // Printing out the Hand
    public void showHand() {
        System.out.println("\n" + name + "'s " +
                "Hand:");
        hand.showCards();
    }

    // retrieving the size of the Hand
    public int getSize() {
        return hand.getSize();
    }

}
