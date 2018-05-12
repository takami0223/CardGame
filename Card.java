class Card {
    public enum Suit {SPADE, HEART, DIAMOND, CLUB}
    private Suit suit;    // �X�[�g
    private int number;   // �ԍ�

    Card(Suit suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    public Suit getSuit() {
        return suit;
    }
    public int getNumber() {
        return number;
    }
    @Override
    public String toString() {
        char suitid = suit.name().charAt(0);
        // suit�̐擪����(�Ⴆ��suit��SPADE�Ȃ�'S')���擾����B

        /*�X�y�[�h�̎�*/
        if(suitid == 'S')
            return "[" + "\u001B[34m" + suitid + number + "\u001b[0m" + "]";

        /*�n�[�g�̎�*/
        else if(suitid == 'H')
            return "[" + "\u001B[31m" + suitid + number + "\u001b[0m" + "]";

        /*�_�C���̎�*/
        else if(suitid == 'D')
            return "[" + "\u001B[33m" + suitid + number + "\u001b[0m" + "]";

        /*�N���[�o�[�̎�*/
        else if(suitid == 'C')
            return "[" + "\u001B[32m" + suitid + number + "\u001b[0m" + "]";

        return "[" + suitid + number + "]";

    }
}