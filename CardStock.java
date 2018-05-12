import java.util.Random;
class CardStock {
    private Card[] stock; // 台札（Cardの配列）
    private int index;  // カードを指している位置

    public static final int SUIT_COUNT = 4;    //スート(種類)の数
    public static final int MAX_NUMBER = 13;   //カードの数値の最大値
    public static final int MAX_CARDNUM = SUIT_COUNT * MAX_NUMBER;  //カード数の最大値

    public static final int ROYAL_STRAIGHT_FLUSH = 100;
    public static final int STRAIGHT_FLUSH = 50;
    public static final int FOUR_CARDS = 30;
    public static final int FULL_HOUSE = 20;
    public static final int FLUSH = 10;
    public static final int STRAIGHT = 5;
    public static final int THREE_CARDS = 3;
    public static final int TWO_PAIR = 2;
    public static final int ONE_PAIR = 1;
    public static final int NONE = 0;

    CardStock() {
        // 4*13枚の全種類のCardを生成し，stockに保持する
        // 配列stockの大きさはスートの種類数(4) * 13となる
        stock = new Card[Card.Suit.values().length * MAX_NUMBER];
        index = 0; // 最初のカードを指している状態にする

        int i=0;
        for(Card.Suit suit: Card.Suit.values()) {
            // Suitの種類を変化させながらループする
            for(int num=1; num<=MAX_NUMBER; num++){
                Card card = new Card(suit, num);
                stock[i] = card;
                i++;
            }
        }
    }

    public Card deal() {
        // 1枚「引く」、すなわち、stockのindex番目のCardを返し、indexを1増加する。
        // 増加前のindexがstockの範囲外を指している場合、nullを返す。
        if(index<0 || index>=stock.length){
            System.out.println(">カードをすべて使ってしまいました");
            return null;
        }
        Card c = stock[index];
        index++;
        return c;
    }

    public void shuffle() {
        // stockをシャッフルする
        index = 0; // 最初のカードを指している状態にする

        int i, len = stock.length;
        Random rnd = new Random();
        for (i = len-1; i>0; i--) {
            int j = rnd.nextInt(i + 1);
            if (i != j) {
                Card temp = stock[i];
                stock[i] = stock[j];
                stock[j] = temp;
            }
        }
    }

    public Hand makeHand(int cardNum) {
        if(index + cardNum > MAX_CARDNUM)
            return null;

        Card[] handcards = new Card[cardNum];

        for(int i=0; i<cardNum; i++)
            handcards[i] = stock[index + i];

        Hand hand = new Hand(handcards);
        index += cardNum;
        return hand;
    }

    public void overLapDel(String[] str) {
        for(int i=0; i<str.length; i++){
            for(int j=0; j<str.length; j++){
                if(i != j){
                    if(str[i].equals(str[j]))
                        str[j] = "0";
                }
            }
        }
    }

    public void showStock(int n) {
        // index 番目から n 個分のカードを出力する
        for(int i=0; i<n; i++)
            System.out.print(stock[index+i]);
        System.out.println(); //改行を出力
    }

    public void showResult(Hand hand, Player player) {
        if(hand.isFlush() && hand.isRoyal()){
            System.out.println("ロイヤルストレートフラッシュ");
            player.add_points(100);
        }else if(hand.isFlush() && hand.isStraight()){
            System.out.println("ストレートフラッシュ");
            player.add_points(50);
        }else if(hand.isFourCards()){
            System.out.println("フォーカード");
            player.add_points(30);
        }else if(hand.isOnePair() && hand.isThreeCards()){
            System.out.println("フルハウス");
            player.add_points(20);
        }else if(hand.isFlush()){
            System.out.println("フラッシュ");
            player.add_points(10);
        }else if(hand.isStraight()){
            System.out.println("ストレート");
            player.add_points(5);
        }else if(hand.isThreeCards()){
            System.out.println("スリーカード");
            player.add_points(3);
        }else if(hand.isTwoPair()){
            System.out.println("ツーペア");
            player.add_points(2);
        }else if(hand.isOnePair()){
            System.out.println("ワンペア");
            player.add_points(1);
        }else{
            System.out.println("役なし");
        }
    }

    public int getResult(Hand hand) {
        if(hand.isFlush() && hand.isRoyal())
            return ROYAL_STRAIGHT_FLUSH;
        else if(hand.isFlush() && hand.isStraight())
            return STRAIGHT_FLUSH;
        else if(hand.isFourCards())
            return FOUR_CARDS;
        else if(hand.isOnePair() && hand.isThreeCards())
            return FULL_HOUSE;
        else if(hand.isFlush())
            return FLUSH;
        else if(hand.isStraight())
            return STRAIGHT;
        else if(hand.isThreeCards())
            return THREE_CARDS;
        else if(hand.isTwoPair())
            return TWO_PAIR;
        else if(hand.isOnePair())
            return ONE_PAIR;
        else
            return NONE;
    }
}