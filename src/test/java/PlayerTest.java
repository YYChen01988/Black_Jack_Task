import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Card card;

    @Before
    public void before(){
        player = new Player("Player 1");
        card = new Card(Suit.DIAMONDS, Rank.ACE);
    }


    @Test
    public void hasName() {
        assertEquals("Player 1", player.getName());
    }

    @Test
    public void canGetACard() {
        player.getCard(card);
        assertEquals(1, player.numberOfCards());
    }

    @Test
    public void canEmptyHand() {
        player.emptyCards();
        assertEquals(0, player.numberOfCards());
    }

    @Test
    public void canHandValue() {
        player.getCard(card);
        assertEquals(1,player.getHandValue());
    }

}
