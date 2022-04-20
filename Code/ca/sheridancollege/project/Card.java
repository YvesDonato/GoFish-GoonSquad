//package ca.sheridancollege.project;
/**
 *
 * @author by Yves Donato
 * @author by David Vallecampo
 */
enum Value {
    ACE, JACK, QUEEN, KING
}

enum Suit {
    HEARTS, DIAMONDS, SPADES, CLUBS
}

public class Card {
    private int valNum;
    private String valstr;
    private int suitNum;
    private String suitstr;

    public Card(int valNum, int suitNum) {
        this.valNum = valNum;
        this.suitNum = suitNum;
    }

    public String getValstr() {
        if (valNum == 1) {
            valstr = String.valueOf(Value.ACE + " OF");
        } else if (valNum == 11) {
            valstr = String.valueOf(Value.JACK + " OF");
        } else if (valNum == 12) {
            valstr = String.valueOf(Value.QUEEN + " OF");
        } else if (valNum == 13) {
            valstr = String.valueOf(Value.KING + " OF");
        } else {
            valstr = String.valueOf(valNum);
        }
        return valstr;
    }

    public String getSuitstr() {
        if (suitNum == 1) {
            suitstr = String.valueOf(Suit.HEARTS);
        } else if (suitNum == 2) {
            suitstr = String.valueOf(Suit.DIAMONDS);
        } else if (suitNum == 3) {
            suitstr = String.valueOf(Suit.SPADES);
        } else if (suitNum == 4) {
            suitstr = String.valueOf(Suit.CLUBS);
        }
        return suitstr;
    }

    public int getValNum() {
        return valNum;
    }

    public void setValNum(int valNum) {
        this.valNum = valNum;
    }

    public int getSuitNum() {
        return suitNum;
    }

    public void setSuitNum(int suitNum) {
        this.suitNum = suitNum;
    }

    public String toString() {
        return getValstr() + " " + getSuitstr();
    }

}
