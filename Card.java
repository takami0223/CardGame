class Card {
    public enum Suit {SPADE, HEART, DIAMOND, CLUB}
    private Suit suit;    // スート
    private int number;   // 番号

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
        // suitの先頭文字(例えばsuitがSPADEなら'S')を取得する。

        /*スペードの時*/
        if(suitid == 'S')
            return "[" + "\u001B[34m" + suitid + number + "\u001b[0m" + "]";

        /*ハートの時*/
        else if(suitid == 'H')
            return "[" + "\u001B[31m" + suitid + number + "\u001b[0m" + "]";

        /*ダイヤの時*/
        else if(suitid == 'D')
            return "[" + "\u001B[33m" + suitid + number + "\u001b[0m" + "]";

        /*クローバーの時*/
        else if(suitid == 'C')
            return "[" + "\u001B[32m" + suitid + number + "\u001b[0m" + "]";

        return "[" + suitid + number + "]";

    }
}