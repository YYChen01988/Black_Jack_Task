import static org.junit.Assert.*;
        import org.junit.*;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(Suit.HEARTS, Rank.JACK);
    }

    @Test
    public void canGetSuit(){
        // The result is not String class anymore, it becomes Suit class
//        assertEquals("Hearts",card.getSuit());
        assertEquals(Suit.HEARTS,card.getSuit());
    }

    @Test
    public void canGetRank() {
        assertEquals(Rank.JACK, card.getRank());
    }

    @Test
    public void aceHasValueOf1() {
        assertEquals(11, card.getValue());
    }

//    @Test
//    public void canGetAllSuits() {
//        Suit[] suits = [Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES];
//    }

}