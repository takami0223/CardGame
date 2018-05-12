import java.util.Random;
class CardStock {
    private Card[] stock; // ��D�iCard�̔z��j
    private int index;  // �J�[�h���w���Ă���ʒu

    public static final int SUIT_COUNT = 4;    //�X�[�g(���)�̐�
    public static final int MAX_NUMBER = 13;   //�J�[�h�̐��l�̍ő�l
    public static final int MAX_CARDNUM = SUIT_COUNT * MAX_NUMBER;  //�J�[�h���̍ő�l

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
        // 4*13���̑S��ނ�Card�𐶐����Cstock�ɕێ�����
        // �z��stock�̑傫���̓X�[�g�̎�ސ�(4) * 13�ƂȂ�
        stock = new Card[Card.Suit.values().length * MAX_NUMBER];
        index = 0; // �ŏ��̃J�[�h���w���Ă����Ԃɂ���

        int i=0;
        for(Card.Suit suit: Card.Suit.values()) {
            // Suit�̎�ނ�ω������Ȃ��烋�[�v����
            for(int num=1; num<=MAX_NUMBER; num++){
                Card card = new Card(suit, num);
                stock[i] = card;
                i++;
            }
        }
    }

    public Card deal() {
        // 1���u�����v�A���Ȃ킿�Astock��index�Ԗڂ�Card��Ԃ��Aindex��1��������B
        // �����O��index��stock�͈̔͊O���w���Ă���ꍇ�Anull��Ԃ��B
        if(index<0 || index>=stock.length){
            System.out.println(">�J�[�h�����ׂĎg���Ă��܂��܂���");
            return null;
        }
        Card c = stock[index];
        index++;
        return c;
    }

    public void shuffle() {
        // stock���V���b�t������
        index = 0; // �ŏ��̃J�[�h���w���Ă����Ԃɂ���

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
        // index �Ԗڂ��� n ���̃J�[�h���o�͂���
        for(int i=0; i<n; i++)
            System.out.print(stock[index+i]);
        System.out.println(); //���s���o��
    }

    public void showResult(Hand hand, Player player) {
        if(hand.isFlush() && hand.isRoyal()){
            System.out.println("���C�����X�g���[�g�t���b�V��");
            player.add_points(100);
        }else if(hand.isFlush() && hand.isStraight()){
            System.out.println("�X�g���[�g�t���b�V��");
            player.add_points(50);
        }else if(hand.isFourCards()){
            System.out.println("�t�H�[�J�[�h");
            player.add_points(30);
        }else if(hand.isOnePair() && hand.isThreeCards()){
            System.out.println("�t���n�E�X");
            player.add_points(20);
        }else if(hand.isFlush()){
            System.out.println("�t���b�V��");
            player.add_points(10);
        }else if(hand.isStraight()){
            System.out.println("�X�g���[�g");
            player.add_points(5);
        }else if(hand.isThreeCards()){
            System.out.println("�X���[�J�[�h");
            player.add_points(3);
        }else if(hand.isTwoPair()){
            System.out.println("�c�[�y�A");
            player.add_points(2);
        }else if(hand.isOnePair()){
            System.out.println("�����y�A");
            player.add_points(1);
        }else{
            System.out.println("���Ȃ�");
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