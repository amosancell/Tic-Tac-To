import java.util.Scanner;

class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 1 for single player and 2 for two player");
        String gameMode = scanner.nextLine();
        while(!(gameMode.equals("1") || gameMode.equals("2"))) {
            System.out.println("Please enter a valid gamemode");
            gameMode = scanner.nextLine();
        }
        if(gameMode.equals("2")) {
            MultiPlayer.main(args);
        }
        else {
            SinglePlayer.main(args);
            //System.out.println("1 player is not ready yet, sorry");
        }

    }
}