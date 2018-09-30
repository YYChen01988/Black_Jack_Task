import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<>();
        populateDeck();
        shuffleDeck();
    }

//    public ArrayList<Card> getCards(){
//        return new ArrayList<Card>(cards);
//    }

    public void populateDeck() {
        for (Suit suit: Suit.values()){
            for (Rank rank : Rank.values()){
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    public int numberOfCards(){
        return this.cards.size();
    }


    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public boolean checkIfCardIsShuffled(){
        Card firstCard = cards.get(0);
        this.shuffleDeck();
        Card firstShuffledCard = cards.get(0);
        if (firstCard != firstShuffledCard){
            return true;
        }else{
            return false;
        }
    }


    public Card dealCard() {
        this.shuffleDeck();
        return this.cards.remove(0);
    }







//    public void giveCardToPlayer() {
//        for (Player player : players){
//            player.getCard(this.dealCard());
//        }
//    }


//    public Player game() {
//        this.dealCard();
//        Player winner = this.players.get(0);
//        for (Player player : players){
//            if (player.getHandValue()> winner.getHandValue()){
//                //return player;
//            }
//        }
//        return winner;
//    }


}
