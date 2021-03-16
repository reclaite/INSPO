public class Main {

    public static void main(String[] args) {
        CoolNumber number = new CoolNumber();
        number.generateCoolNumbers();
        number.bruteForce("А111ВС197");
        number.hashSetSearch("А111ВС197");
        number.treeSetSearch("А111ВС197");
        number.bruteForce("У777НС66");
        number.hashSetSearch("У777НС66");
        number.treeSetSearch("У777НС66");
    }
}
