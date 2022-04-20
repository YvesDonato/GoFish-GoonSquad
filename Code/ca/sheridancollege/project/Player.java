/**
 *
 * @author by Yves Donato
 * @author by David Vallecampo
 */
// Class of the player contains the name, hand, and number of books
public class Player {
    private String name;
    private int books = 0;
    private GroupOfCards hand = new GroupOfCards();

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    //Getters and Setters
    public int getBooks() {
        return books;
    }

    public void setBooks(int books) {
        this.books += books;
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
