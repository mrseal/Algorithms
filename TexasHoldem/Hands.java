import java.util.Arrays;

public class Hands {

    Poker[] pokers;
    Poker[] sorted;
    Rank rank;

    public Hands(final Poker[] pokers) {
        this.pokers = pokers;
        sorted = Arrays.copyOf(pokers, pokers.length);
        Arrays.sort(sorted);
    }

    public Rank getRank() {
        if (rank == null) {
            rank = calculateRank();
        }
        return rank;
    }

    private Rank calculateRank() {
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
            if (sorted[0].getNum() == 14) {
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
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[i].getNum() == sorted[j].getNum()) {
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
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i - 1].getNum() - sorted[i].getNum() != 1) {
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
