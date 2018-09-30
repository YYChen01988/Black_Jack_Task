import java.util.ArrayList;

public class Game {

    private Deck deck;
    private Dealer dealer;
    private ArrayList<Player> players;

    public Game(Deck deck, Dealer dealer, ArrayList<Player> players){
        this.deck = deck;
        this.dealer = dealer;
        this.players = players;

    }

    public void dealInitialCards(ArrayList<Player> players, Dealer dealer){
        for (Player player : players) {
            Card card1 = dealer.deal(deck);
            Card card2 = dealer.deal(deck);
            player.getCard(card1);
            player.getCard(card2);
        }
        Card card1 = dealer.deal(deck);
        Card card2 = dealer.deal(deck);
        dealer.getCard(card1);
        dealer.getCard(card2);
    }

    public void playersDecide(ArrayList<Player> players, Dealer dealer){
        for (Player player : players){
            if (player.getHandValue() <= 16){
                Card card = dealer.deal(deck);
                player.getCard(card);
            }
        }
    }

    public void checkBustedPlayers(ArrayList<Player> players){
        //check player is busted or not
        for (Player player :players){
            if (player.getHandValue() > 21){
                player.setBusted(true);
            }
        }
    }


    public void dealerDecides(Dealer dealer){
        //dealer check if over 16
        if (dealer.getHandValue() <= 16){
            Card card = dealer.deal(deck);
            dealer.getCard(card);
        }
    }


    public ArrayList<Player> getWinners(ArrayList<Player> players, Dealer dealer){
        //check who is winner 1. dealer busted(players who stay win
        ArrayList<Player> winners = new ArrayList<>();
        if (dealer.getHandValue()>21){

            for (Player player :players){
                if (player.getBusted() == false){
                    winners.add(player);
                }
            }
            return winners;
        }else{
            Boolean isDraw = false;
            for (Player player: players){
                //!player.getBusted() == false
                if (player.getHandValue() >= dealer.getHandValue() && !player.getBusted()){
                    winners.add(player);

                    if (player.getHandValue() == dealer.getHandValue() && !player.getBusted()){
                        if (isDraw == false){
                            winners.add(dealer);
                        }
                        isDraw = true;
                    }
                }
            }
            return winners;
        }

    }

    public ArrayList<Player> play() {
        dealInitialCards(this.players, this.dealer);
        playersDecide(this.players, this.dealer);
        checkBustedPlayers(this.players);
        dealerDecides(this.dealer);
        return getWinners(this.players, this.dealer);
    }

}
