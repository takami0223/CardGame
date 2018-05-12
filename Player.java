class Player {

    private int points=0;   //“_”
    private int money=100;  //Š‹à
    private int bets=0;     //Š|‚¯‹à

    public void add_points(int point) {
        points += point;
    }

    public void add_bets(int bet) {
        bets += bet;
        money -= bet;
    }
    public void add_money(int mon) {
        money += mon;
    }

    public int get_points() {
        return points;
    }

    public int get_money() {
        return money;
    }

    public int get_bets() {
        return bets;
    }

    public void reset_points() {
        points = 0;
    }

    public void reset_money() {
        money = 100;
    }

    public void reset_bets() {
        bets = 0;
    }
}