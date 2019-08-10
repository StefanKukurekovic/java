public class Main {

    public static void main(String[] args) {

        String newChar = "a";

        switch (newChar.toUpperCase()){
            case "A": case "B": case "C": case "D": case "E":
                System.out.println(newChar.toUpperCase() + " character is found");
                break;
                default:
                    System.out.println("Not found");
                    break;

        }

    }
}
