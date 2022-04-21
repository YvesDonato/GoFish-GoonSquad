import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modified by Yves Donato
 * @modified by David Vallecampo
 */
// The main code for GoFish
public class GoFish {
    Scanner scan = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList<Player>(); // Arraylist of players
    private GroupOfCards deck = new GroupOfCards(); // Arraylist of cards
    private int numPlayers = 0;

    public GroupOfCards getDeck() {
        return deck;
    }

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

    // Play is the main base code for GoFish
    public void play() {

        initialSetUp();
        showPlayerHands();

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
            if (gameOverCheck()) {
                break;
            } else if (x == numPlayers - 1 && !caughtCard) {
                x = -1;
            }
            if (caughtCard) {
                x--;
                System.out.println("Go again");
            }
        }
    }

    public void addPlayer(String name, ArrayList<Card> cards) {
        Player player = new Player(name);
        for (Card card : cards) {
            player.addCardToHand(card);
        }
        players.add(player);
    }

    public void showPlayerHands() {
        for (Player player : players) {
            player.showHand();
        }
    }

    public void initialSetUp() {
        createDeck();
        System.out.println("Enter number of players (minimum of 2)");
        numPlayers = scan.nextInt();
        scan.nextLine();
        setUpPlayers(numPlayers);
    }

    public void setUpPlayers(int numPlayers) {
        if (numPlayers >= 2) {
            int numOfCards = numPlayers == 2 ? 5 : 7;
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Enter player name: ");
                String playerName = scan.nextLine();
                ArrayList<Card> playerCards = new ArrayList<Card>();
                for (int j = 0; j < numOfCards; j++) {
                    playerCards.add(deck.takeCard(0));
                }
                addPlayer(playerName, playerCards);
            }
        } else {
            System.out.println("Not enough players");
            System.exit(0);
        }
    }

    // Declares the winner through check if there are cards and if the player
    // has more cards
    public boolean gameOverCheck() {
        boolean winner = false;
        if (deck.getSize() == 0) {
            winner = true;
            String winnerName = getWinner();
            System.out.println(winnerName == "DRAW" ? "Game is a DRAW" : "The winner is " + winnerName + "!!!");
        }
        return winner;
    }

    public String getWinner() {
        int highScore = 0;
        String winnerName = "";
        for (int i = 0; i < players.size(); i++) {

            int playersScore = players.get(i).getBooks();
            String playersName = players.get(i).getName();
            System.out.println(playersName + ": " + playersScore);

            if (playersScore > highScore) {
                highScore = playersScore;
                winnerName = playersName;
            } else if (playersScore == highScore) {
                winnerName = "DRAW";
            }
        }
        return winnerName;
    }
}
