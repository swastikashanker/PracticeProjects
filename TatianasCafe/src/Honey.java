public class Honey extends BeverageDecorator{

    int cost;
    private Beverage beverage;

    public Honey(int cost, Beverage beverage) {
        this.cost = cost;
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return (this.beverage.getCost()+this.cost);
    }

    @Override
    public String getDescription() {
        return (this.beverage.getDescription()+"Topped with Honey");
    }
}
