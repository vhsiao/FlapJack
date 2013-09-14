package Engine;

public class Session {

    Casino casino;
    Strategy strategy;
    Shoe shoe;
    Game[] games;
    double totalProfit;
    double totalWage;
    double averageProfit;
    double gameWonPercentage;
    int numberOfWonGame;


    public Session(Casino casino, Strategy strategy, Shoe shoe) {
        this.casino = casino;
        this.strategy = strategy;
        this.shoe = shoe;

        totalProfit = 0.0;
        totalWage = 0.0;
        averageProfit = 0.0;
        gameWonPercentage = 0.0;
        numberOfWonGame = 0;

        games = new Game[casino.getNumberOfGames()];
    }

    public void playGames() {
        for (int i = 0; i < casino.getNumberOfGames(); i++) {
            games[i] = new Game(strategy, casino, shoe, 10);
            games[i].play();
        }
        solve();
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    private void solve() {
        for (int i = 0; i < casino.getNumberOfGames(); i++) {
            totalProfit += games[i].getProfit();
            totalWage += games[i].getActualAmountWagered();
            numberOfWonGame += totalProfit > 0 ? 1 : 0;
        }
        Simulator.finished(this);
    }

    public double getTotalWage() {
        return totalWage;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public double getGameWonPercentage() {
        return numberOfWonGame * 100.0 / casino.getNumberOfGames();
    }
}