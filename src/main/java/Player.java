import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private Boolean isBusted;


    public Player(String name){
        this.hand = new ArrayList<>();
        this.name = name;
        this.isBusted = false;
    }

    public void getCard(Card ACard) {
        hand.add(ACard);
    }

    public int numberOfCards(){
        return hand.size();
    }

    public void emptyCards(){
         hand.clear();
    }



    public int getHandValue(){
        int total = 0;
        for (Card card : hand){
            total += card.getValue();
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public Boolean getBusted() {
        return isBusted;
    }

    public void setBusted(Boolean busted) {
        isBusted = busted;
    }
}
