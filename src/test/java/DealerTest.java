import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Dealer dealer;
    Deck deck;

    @Before
    public void before(){
        dealer = new Dealer("Dealer");
        deck = new Deck();
    }

    @Test
    public void dealerCanDeal() {
        Card card = dealer.deal(deck);
        assertEquals(51,deck.numberOfCards());
    }
}

