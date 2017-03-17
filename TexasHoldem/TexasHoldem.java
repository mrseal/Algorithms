import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TexasHoldem {

    public static void main(final String[] args) {
        final List<Poker> deck = prepareDeck();
        shuffleDeck(deck);

        final Hands hands = new Hands(deck.subList(0, 5).toArray(new Poker[5]));
        System.out.println("|| RANDOM ||");
        System.out.println(hands);
        System.out.println(hands.getRank());

        System.out.println("\n|| RULES ||");
        final Poker h14 = new Poker(14, Suit.HEARTS);
        final Poker d14 = new Poker(14, Suit.DIAMONDS);
        final Poker s14 = new Poker(14, Suit.SPADES);
        final Poker c14 = new Poker(14, Suit.CLUBS);
        final Poker h13 = new Poker(13, Suit.HEARTS);
        final Poker h12 = new Poker(12, Suit.HEARTS);
        final Poker s12 = new Poker(12, Suit.SPADES);
        final Poker h11 = new Poker(11, Suit.HEARTS);
        final Poker h10 = new Poker(10, Suit.HEARTS);
        final Poker h9 = new Poker(9, Suit.HEARTS);
        final Poker h3 = new Poker(3, Suit.HEARTS);
        final Poker c10 = new Poker(10, Suit.CLUBS);

        final Hands royalFlush = new Hands(new Poker[] { h13, h10, h12, h14, h11 });
        print(royalFlush);
        final Hands straightFlush = new Hands(new Poker[] { h13, h10, h12, h9, h11 });
        print(straightFlush);
        final Hands fourOfAKind = new Hands(new Poker[] { h14, d14, h12, c14, s14 });
        print(fourOfAKind);
        final Hands fullHouse = new Hands(new Poker[] { h14, d14, h12, c14, s12 });
        print(fullHouse);
        final Hands flush = new Hands(new Poker[] { h13, h10, h3, h9, h11 });
        print(flush);
        final Hands straight = new Hands(new Poker[] { h13, c10, h12, h14, h11 });
        print(straight);
        final Hands threeOfAKind = new Hands(new Poker[] { h14, d14, h3, c14, s12 });
        print(threeOfAKind);
        final Hands twoPairs = new Hands(new Poker[] { h10, d14, c10, c14, s12 });
        print(twoPairs);
        final Hands onePair = new Hands(new Poker[] { h10, h3, c10, c14, s12 });
        print(onePair);
        final Hands highHand = new Hands(new Poker[] { h10, d14, h9, h3, s12 });
        print(highHand);
    }

    public static List<Poker> prepareDeck() {
        final List<Poker> deck = new ArrayList<>();
        final Suit[] suits = Suit.values();
        for (final Suit suit : suits) {
            for (int j = 2; j <= 14; j++) {
                deck.add(new Poker(j, suit));
            }
        }
        return deck;
    }

    public static void shuffleDeck(final List<Poker> deck) {
        Collections.shuffle(deck);
    }

    private static void print(final Hands hands) {
        System.out.printf("(%2s)  %-16s %s\n", hands.getRank().getValue(), hands.getRank(), hands);
    }
}
