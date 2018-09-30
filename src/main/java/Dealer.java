
public class Dealer extends Player {

    public Dealer(String name) {
        super(name);
    }

    public Card deal(Deck deck) {
        return deck.dealCard();
    }


}
