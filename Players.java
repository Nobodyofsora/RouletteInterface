package sample;

public class Players {
    private String name;
    public double credit;
    private int bet; // odd number: 37/ even number: 38 / number 0-36 / red / black
    private int moneyBet;
    public int win;

    public Players(String name, double credit) {
        this.name = name;
        this.credit = credit;
        this.win=0;
    }
    public String getName() {
        return name;
    }


    public int getBet() {
        return bet;
    }

    public void setCredit(double credit) {
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
