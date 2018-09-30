public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        // getSuits();
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public int getValue() {
        //ordinal return index number in value
//        return this.rank.ordinal()+ 1;
        return this.rank.getValue();
    }

//    public void getSuits(){
//        for (Suit suit : Suit.values()){
//            System.out.println(suit);
//        }
//    }
}