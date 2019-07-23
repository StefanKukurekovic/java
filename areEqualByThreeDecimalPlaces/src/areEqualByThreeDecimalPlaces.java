public class areEqualByThreeDecimalPlaces {
    public static boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
        return Math.abs(firstNum * 1000 - secondNum * 1000) < 1;
    }
}
