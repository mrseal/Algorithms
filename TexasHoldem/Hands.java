import java.util.Arrays;

public class Hands {

    Poker[] pokers;
    Poker[] ordered;

    public Hands(final Poker[] pokers) {
        this.pokers = pokers;
        ordered = Arrays.copyOf(pokers, pokers.length);
        Arrays.sort(ordered);
    }

    public Rank getRank() {
        final Poker[] p = Arrays.copyOf(pokers, pokers.length);
        Arrays.sort(p);

        int flushOrStraight = 0;
        if (isFlush()) {
            flushOrStraight |= 1;
        }
        if (isStraight()) {
            flushOrStraight |= 2;
        }

        switch (flushOrStraight) {
        case 3: {
            if (ordered[0].getNum() == 14) {
                return Rank.ROYAL_FLUSH;
            } else {
                return Rank.STRAIGHT_FLUSH;
            }
        }
        case 2:
            return Rank.STRAIGHT;
        case 1:
            return Rank.FLUSH;
        }

        int duplicates = 0;
        for (int i = 0; i < ordered.length - 1; i++) {
            for (int j = i + 1; j < ordered.length; j++) {
                if (ordered[i].getNum() == ordered[j].getNum()) {
                    duplicates++;
                }
            }
        }

        switch (duplicates) {
        case 0:
            return Rank.HIGH_HAND;
        case 1:
            return Rank.ONE_PAIR;
        case 2:
            return Rank.TWO_PAIRS;
        case 3:
            return Rank.THREE_OF_A_KIND;
        case 4:
            return Rank.FULL_HOUSE;
        case 6:
            return Rank.FOUR_OF_A_KIND;
        }

        return null;
    }

    private boolean isFlush() {
        final Suit suit1 = pokers[0].getSuit();
        for (int i = 1; i < pokers.length; i++) {
            if (pokers[i].getSuit() != suit1) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraight() {
        for (int i = 1; i < ordered.length; i++) {
            if (ordered[i - 1].getNum() - ordered[i].getNum() != 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Poker poker : pokers) {
            sb.append(poker);
            sb.append(" ");
        }
        return sb.toString();
    }

}
