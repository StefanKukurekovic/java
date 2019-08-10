public class Main {

    public static void main(String[] args) {

        double tempTwo = AreaCalculator.area(5);
        System.out.println("Radius = " + tempTwo);

        double temp = AreaCalculator.area(5.0, 4.0);
        System.out.println("Area = " + temp);
    }
}
