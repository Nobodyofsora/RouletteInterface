package sample;

public class Players {
    private String name;
    public int credit;
    private int bet; // odd number: 37/ even number: 38 / number 0-36 / red / black
    private int moneyBet;
    public int win;
    public boolean completedTurn = false;

    public Players(String name, int
            credit) {
        this.name = name;
        this.credit = credit;
        this.win=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBet() {
        return bet;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getMoneyBet() {
        return moneyBet;
    }

    public void setMoneyBet(int moneyBet) {
        this.moneyBet = moneyBet;
    }

    @Override
    public String toString() {
        return  name +
                "\n Credit =" + credit +
                "\n}" +
                "";
    }
}
