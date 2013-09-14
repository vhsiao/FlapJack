import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<Card>();

    // Constructor
    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    // Called when player wants to hit
    public void addCard(Card card) {
        cards.add(card);
    }

    // Returns an array of length 1 or 2 containing possible values of the hand
    public int[] getValues() {
        int val0 = 0; // Hand value assuming first ace is valued at 1
        int val1 = 0; // Hand value assuming first ace is valued at 11
        boolean hasAce = false;
        int[] cardValue;

        // If Ace
        if(cardValue.length == 2) {
            // If Ace already exists in hand, just add 1
            if(hasAce) {
                val0 += cardValue[0]; // 1
                val1 += cardValue[0]; // 1
            }
            else {
                val0 += cardValue[0]; // 1
                val1 += cardValue[1]; // 11
                hasAce = true;
            }
        }

        // Otherwise single-value cards (2-10, J, Q, K)
        else {
            val0 += cardValue[0];
            val1 += cardValue[0];
        }

        if(val0 == val1) {
            return new int[] { val0 };
        }
        else {
            return new int[] {val0, val1};
        }
    }

   public Hand split(Shoe shoe) {
        // Can split only if hand has 2 cards
        if(cards.size() != 2) {
            return null;
        }

        Hand[] newHands = new Hand[2];
        newHands[0] = new Hand(new ArrayList<Card>());
        newHands[1] = new Hand(new ArrayList<Card>());

        newHands[0].addCard(shoe.removeTopCard());
        newHands[1].addCard(shoe.removeTopCard());

        return newHands;
   }
}