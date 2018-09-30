import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class GameTest {

    Game game;
    Dealer dealer;
    Player player1;
    Player player2;
    Deck deck;
    ArrayList<Player> players;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer("Dealer");
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        game = new Game(deck, dealer, players);
    }


    @Test
    public void canDealInitialCards() {
        game.dealInitialCards(players, dealer);
        assertEquals(46, deck.numberOfCards());
        assertEquals(2, player1.numberOfCards());
    }

    @Test
    public void canCheckPlayerIsBusted() {
        Card card1 = new Card(Suit.HEARTS, Rank.JACK);
        player1.getCard(card1);
        player2.getCard(card1);
        player2.getCard(card1);
        game.checkBustedPlayers(players);
        assertEquals(false, player1.getBusted());
        assertEquals(true, player2.getBusted());
    }

    @Test
    public void canCheckPlayersDecisions() {
        Card card1 = new Card(Suit.HEARTS, Rank.JACK);
        Card card2 = new Card(Suit.HEARTS, Rank.KING);
        Card card3 = new Card(Suit.HEARTS, Rank.TWO);
        player1.getCard(card1);
        player1.getCard(card3);
        player2.getCard(card1);
        player2.getCard(card2);
        assertEquals(2, player1.numberOfCards());
        assertEquals(2, player2.numberOfCards());
        game.playersDecide(players, dealer);
        assertEquals(3, player1.numberOfCards());
        assertEquals(2, player2.numberOfCards());
    }

    @Test
    public void canCheckDealerCardValueIsLessThan16() {
        Card card1 = new Card(Suit.HEARTS, Rank.JACK);
        dealer.getCard(card1);
        assertEquals(1, dealer.numberOfCards());
        game.dealerDecides(dealer);
        assertEquals(2, dealer.numberOfCards());
    }

    @Test
    public void canCheckDealerCardValueIsOver16() {
        Card card1 = new Card(Suit.HEARTS, Rank.JACK);
        Card card2 = new Card(Suit.HEARTS, Rank.KING);
        dealer.getCard(card1);
        dealer.getCard(card2);
        assertEquals(2, dealer.numberOfCards());
        game.dealerDecides(dealer);
        assertEquals(2, dealer.numberOfCards());
    }

    @Test
    public void canGetWinnerWhenDealerIsLessThan21() {
        Card card1 = new Card(Suit.HEARTS, Rank.JACK);
        Card card2 = new Card(Suit.HEARTS, Rank.KING);
        dealer.getCard(card1);
        //dealer.getCard(card2);
        Card card3 = new Card(Suit.HEARTS, Rank.TWO);
        player1.getCard(card3);
        player2.getCard(card2);
        ArrayList<Player> result = game.getWinners(players,dealer);
        assertEquals(player2, result.get(0));
    }

    @Test
    public void canGetWinnerWhenDealerIsOver21() {
        Card card1 = new Card(Suit.HEARTS, Rank.JACK);
        Card card2 = new Card(Suit.HEARTS, Rank.KING);
        dealer.getCard(card1);
        dealer.getCard(card2);
        Card card3 = new Card(Suit.HEARTS, Rank.TWO);
        player1.getCard(card3);
        player2.getCard(card2);
        ArrayList<Player> result = game.getWinners(players,dealer);
        assertEquals(2, result.size());
    }


    @Test
    public void canGetWinnerWhenIsADraw() {
        Card card1 = new Card(Suit.HEARTS, Rank.JACK);
        dealer.getCard(card1);
        player1.getCard(card1);
        player2.getCard(card1);
        ArrayList<Player> result = game.getWinners(players,dealer);
        assertEquals(3, result.size());
    }
}
