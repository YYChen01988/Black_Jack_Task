public enum Rank {

    //it can be passed on more than one eg. ACE(1, "Green", true, new Card)
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

//    final is like const in Java, it cant be changed
    private final int value;

    Rank(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
