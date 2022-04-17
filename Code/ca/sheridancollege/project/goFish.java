//package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modified by Yves Donato
 * @modified by David Vallecampo
 */
public class goFish {
    Scanner scan = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList();
    private GroupOfCards deck = new GroupOfCards();
    private int numplayers = 0;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void createDeck(){
        for(int x = 1; x <= 4; x++){
            for (int y = 1; y <= 13; y++){
                Card card = new Card(y, x);
                deck.setCards(card);
            }
        }
        deck.shuffle();
    }
    public void Check(int numVal, int playerSel, int currPlayer){
        int index = -1;
        int playerNum=-1;
        int caught = 0;
        for (int i = 0; i < players.get(playerSel-1).getSize(); i++) {
            if (players.get(playerSel-1).getCard(i).getValNum() == numVal) {
                index = i;
                caught++;
                players.get(currPlayer).setHand(players.get(playerSel-1).getCard(index));
                players.get(playerSel-1).removeCard(index);
                i--;
            }
            else{
                playerNum = 1;
            }
        }
        if(index == -1 && playerNum != -1){
            System.out.println("Go Fish!");
            players.get(playerNum).setHand(deck.getCard(0));
        }
        else {
            System.out.println("Caught: " + caught);
        }
    }

    public void play(){
        System.out.println("Enter number of players (minimum of 2)");
        numplayers = scan.nextInt();
        scan.nextLine();
        if (numplayers >= 2) {
            for (int i = 0; i < numplayers; i++) {
                System.out.println("Register Player Names");
                Player player = new Player(scan.nextLine());
                players.add(player);
            }
        }
        else{
            System.exit(0);
        }
        createDeck();

        if(numplayers == 2){
            for(int x = 0; x < numplayers; x++){
                for(int y = 0; y < 7; y++) {
                    players.get(x).setHand(deck.getCard(y));
                    deck.removeCard(y);
                }
                players.get(x).showHand();
            }
        }
        else{
            for(int x = 0; x < numplayers; x++){
                for(int y = 0; y < 5; y++) {
                    players.get(x).setHand(deck.getCard(y));
                    deck.removeCard(y);
                }
                players.get(x).showHand();
            }
        }
        System.out.println();
        Boolean game = true;
        while (game){
            for(int x = 0; x < numplayers; x++){
                System.out.println(players.get(x).getName()+ "'s Turn:");
                System.out.println("Select player you will ask (NUM):");
                int playerSel = scan.nextInt();
                System.out.println("Guess card:");
                System.out.println("Enter card value (NUM 1-13):");
                int numVal = scan.nextInt();
                scan.nextLine();
                Check(numVal,playerSel,x);
                players.get(x).showHand();
                System.out.println();
                if(declareWinner()){
                    break;
                }
            }
        }
    }

    public boolean declareWinner(){
        boolean winner = true;
        for (int i = 0; i < players.size(); i++) {
            for (int x = 0; x < players.get(i).getSize(); x++) {
                int cardNum = 0;
                for (int y = 0; y < players.get(i).getSize(); y++) {
                    if(players.get(i).getCard(x).getValNum() == players.get(i).getCard(y).getValNum()){
                        cardNum++;
                        if (cardNum >= 4){
                            players.get(i).setBooks(1);
                        }
                    }
                }
            }
        }
        if(deck.getSize() == 0){
            winner = false;
            for (int i = 0; i < players.size(); i++) {
                System.out.println(players.get(i).getName()+ ": " + players.get(i).getBooks());
            }
        }
        return winner;
    }

}
