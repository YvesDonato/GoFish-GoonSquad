import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modified by Yves Donato
 * @modified by David Vallecampo
 */
// The main code for goFish
public class goFish {
    Scanner scan = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList(); // Arraylist of players
    private GroupOfCards deck = new GroupOfCards(); // Arraylist of cards
    private int numPlayers = 0;

    // getting the number of players
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    // Method to create the deck
    public void createDeck() {
        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 13; y++) {
                Card card = new Card(y, x);
                deck.addCard(card);
            }
        }
        deck.shuffle(); // shuffles the deck
    }

    // Checking if the said card it inside the players hand
    public boolean check(int numVal, int playerSel, int currPlayer) {
        boolean cardCaught = false;
        int caught = 0;
        // check the hands of the player
        for (int i = 0; i < players.get(playerSel).getSize(); i++) {
            if (players.get(playerSel).getCard(i).getValNum() == numVal) {
                caught++;
                players.get(currPlayer).addCardToHand(players.get(playerSel).takeCard(i));
                i--;
                cardCaught = true;
            }
        }
        if (cardCaught == false) {
            System.out.println("Go Fish!");
            players.get(currPlayer).addCardToHand(deck.takeCard(0));
        } else {
            System.out.println("You caught " + caught + " card(s)");
        }
        return cardCaught;
    }

    // Play is the main base code for gofish
    public void play() {

        initialSetUp();

        System.out.println();
        for (int x = 0; x < numPlayers; x++) {
            System.out.println(players.get(x).getName() + "'s Turn:");
            int playerSel;
            if (numPlayers == 2) {
                playerSel = x == 0 ? 1 : 0;
            } else {
                System.out.println("Select player you will ask (NUM):");
                playerSel = scan.nextInt() - 1;
            }
            if (playerSel == x) {
                x--;
                System.out.println("Cannot reselect current player.");
                continue;
            }
            System.out.println("Guess card");
            System.out.println("Enter card value (NUM 1-13):");
            int numVal = scan.nextInt();
            scan.nextLine();
            boolean caughtCard = check(numVal, playerSel, x);
            players.get(x).showHand();
            System.out.println();
            if (declareWinner()) {
                break;
            } else if (x == numPlayers - 1) {
                x = 0;
            }
            if (caughtCard) {
                x--;
                System.out.println("Go again");
            }
        }
    }

    private void initialSetUp() {
        System.out.println("Enter number of players (minimum of 2)");
        numPlayers = scan.nextInt();
        scan.nextLine();
        if (numPlayers >= 2) {
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Register Player Names");
                Player player = new Player(scan.nextLine());
                players.add(player);
            }
        } else {
            System.out.println("Not enough players");
            System.exit(0);
        }
        createDeck();

        int numOfCards = numPlayers == 2 ? 5 : 7;

        for (int x = 0; x < numPlayers; x++) {
            for (int y = 0; y < numOfCards; y++) {
                players.get(x).addCardToHand(deck.takeCard(0));
            }
            players.get(x).showHand();
        }
    }

    // Declares the winner through check if there are cards and if the player
    // has more cards
    public boolean declareWinner() {
        boolean winner = false;
        for (int i = 0; i < players.size(); i++) {
            for (int x = 0; x < players.get(i).getSize(); x++) {
                int cardNum = 0;
                for (int y = 0; y < players.get(i).getSize(); y++) {
                    if (players.get(i).getCard(x).getValNum() == players.get(i).getCard(y).getValNum()) {
                        cardNum++;
                        if (cardNum >= 4) {
                            players.get(i).setBooks(1);
                        }
                    }
                }
            }
        }
        if (deck.getSize() == 0) {
            winner = true;
            for (int i = 0; i < players.size(); i++) {
                System.out.println(players.get(i).getName() + ": " + players.get(i).getBooks());
            }
            System.out.println("GAME OVER");
        }
        return winner;
    }

}
