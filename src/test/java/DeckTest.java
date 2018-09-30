import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeckTest {
    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
//        deck.populateDeck();
//        deck.shuffleDeck();
    }

//    @Test
//    public void deckStartEmpty() {
//        Deck newDeck = new Deck();
//        assertEquals(0, newDeck.numberOfCards());
//    }

    @Test
    public void deckHas52Cards() {
        assertEquals(52, deck.numberOfCards());
    }

    @Test
    public void canShuffleCards() {
        assertEquals(true, deck.checkIfCardIsShuffled());

    }

    @Test
    public void canDealCards() {
        //assertNotNull is checking if it does return something
        assertNotNull(deck.dealCard());
        assertEquals(51, deck.numberOfCards());
    }








//    @Test
//    public void canGiveACardToPlayer() {
//        //deck.populateCards();
//        //deck.shuffleCards();
//        deck.dealCard();
//        deck.giveCardToPlayer();
//        assertEquals(1, player1.getTheCardValue());
//    }

        @Test
    public void canGetAWinner() {

    }



}
