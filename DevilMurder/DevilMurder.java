import java.util.Random;

/**
 * 魔鬼杀人算法 / 帽子戏法
 *
 * 0 代表白帽子 1 代表黑帽子
 */
public class DevilMurder {

    private byte[] hats;

    public DevilMurder(final int num) {
        init(num);
    }

    private void init(final int num) {
        if (num < 3) {
            throw new IllegalArgumentException("num must > 2");
        }
        hats = new byte[num];
        for (int i = 0; i < hats.length; i++) {
            hats[i] = (byte) (new Random().nextBoolean() ? 0 : 1);
        }
    }

    public byte[] getAnswer() {
        final int length = hats.length;
        final byte[] answer = new byte[length];

        final byte[] forwardsResult = new byte[length];
        forwardsResult[0] = 0;
        for (int i = 1; i < length; i++) {
            forwardsResult[i] = (byte) (forwardsResult[i - 1] ^ hats[i - 1]);
        }

        byte backwardsResult = 0;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = (byte) (backwardsResult ^ forwardsResult[i]);
            backwardsResult = (byte) (backwardsResult ^ answer[i]);
        }
        return answer;
    }

    public byte[] getHats() {
        return hats;
    }

    private static void print(final byte[] hats) {
        for (int i = 0; i < hats.length; i++) {
            System.out.printf("%s ", hats[i] == (byte) 0 ? "白" : "黑");
        }
        System.out.println();
    }

    public static void main(final String[] args) {
        final int num = 20;
        final DevilMurder test = new DevilMurder(num);
        final byte[] hats = test.getHats();
        final byte[] answer = test.getAnswer();
        print(hats);
        print(answer);

        int alive = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == hats[i]) {
                alive++;
            }
        }
        System.out.printf("存活人数： %d/%d\n", alive, num);
    }
}
