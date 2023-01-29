public class Tea implements Beverage{

    int cost;


    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public String getDescription() {
        return "Tea";
    }
}
