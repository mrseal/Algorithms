public class Poker implements Comparable<Poker> {

    int num;
    Suit suit;

    public Poker(final int num, final Suit suit) {
        this.num = num;
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "[" + num + " " + suit + "]";
    }

    @Override
    public int compareTo(final Poker o) {
        return o.num - num;
    }

}
