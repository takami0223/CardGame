import java.util.*;

class Hand {
    public static final int HAND_CARDNUM = 3;
    Card cards[];

    Hand(Card[] cards) {
        this.cards = cards;
    }

    /*ワンペアか判断*/
    public boolean isOnePair() {
        if(getNumberCount(2) == 1)
            return true;
        else
            return false;
    }

    /*ツーペアか判断*/
    public boolean isTwoPair() {
        if(getNumberCount(2) == 2)
            return true;
        else
            return false;
    }

    /*スリーカードか判断*/
    public boolean isThreeCards() {
        if(getNumberCount(3) == 1)//getNumberCount(cards[0].getNumber()) == 3)
            return true;
        else
            return false;
    }

    /*フォーカードか判断*/
    public boolean isFourCards() {
        if(getNumberCount(4) == 1)
            return true;
        else
            return false;
    }

    /*ストレートか判断*/
    public boolean isStraight() {
        int[] n = getSortedNumbers();

        if(n[0]==1 && n[1]==10 && n[2]==11 && n[3]==12 && n[4]==13)
            return true;

        for(int i = 0; i < cards.length-1; i++) {
            if(n[i]+1 != n[i+1])
                return false;
        }
        return true;
    }

    /*フラッシュか判断*/
    public boolean isFlush() {
        for(int i = 1; i < cards.length; i++) {
            if(cards[i].getSuit() != cards[i-1].getSuit())
                return false;
        }
        return true;
    }

    /*ロイヤルストレートフラッシュか判断*/
    public boolean isRoyal() {
        int[] n = getSortedNumbers();

        if(n[0]==1 && n[1]==10 && n[2]==11 && n[3]==12 && n[4]==13)
            return true;
        return false;
    }

    public int getNumberCount(int c) {
        int[] count = new int[CardStock.MAX_NUMBER];

        for(int i = 0; i < cards.length; i++)
            count[cards[i].getNumber()-1]++;

        int ret = 0;
        for(int i = 0; i < CardStock.MAX_NUMBER; i++) {
            //System.out.println(count[i]);
            if(count[i] == c)
                ret++;
        }
        return ret;
    }

    public int[] getSortedNumbers() {
        int[] n = new int[cards.length];
        for (int i=0; i<cards.length; i++) {
            n[i] = cards[i].getNumber();
        }
        Arrays.sort(n);
        return n;
    }

    @Override
    public String toString() {
        String s = "<";
        for(int i = 0; i < cards.length; i++)
            s = s + cards[i];
        s = s + ">";
        return s;
    }
}