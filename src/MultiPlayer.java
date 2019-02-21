import java.util.Scanner;
import java.io.Console;
import java.util.Arrays;
//java.io.Console


public class MultiPlayer {

    public static class HidePassword {

        private static char[] password = {'d','o','u','b','l','e','S','p','e','e','d'};

        public static boolean promptPass() {
            Console console = System.console();
            if(console != null) {
                char[] input = null;
                try {
                    input = console.readPassword("Please enter Password");
                    return Arrays.equals(input,password);

                } finally {

                }
            } else {
                throw new RuntimeException("No console, can't get password");
            }
        }
    }

    public static void main(String[] args) {

        //makes board, displays it, and sets up user input
        Board board = new Board();
        board.display();
        Scanner scanner = new Scanner(System.in);
        String symbol = "X";
        boolean cheating = false;

        while(!board.isFinished()) {

            //prompts person to make move
            if(symbol.equals("X")) {
                System.out.println("Player 1 make your move");
            }
            else {
                System.out.println("Player 2 make your move");
            }

            //takes inputted move and makes sure that no one has gone there yet
            String input = scanner.nextLine();
            //make backdoor for people with password
            if(input.equals("admin.CODERED")) {
                if(HidePassword.promptPass()) {
                    cheating = true;
                    System.out.println("READY");
                    input = scanner.nextLine();
                }
            }

            int inputVal = Integer.valueOf("5");
            while(board.hasVal(inputVal)) {
                System.out.println("That place is taken, enter a new position");
                input = scanner.nextLine();
                inputVal = Integer.valueOf(input);
            }

            //updates board
            board.update(inputVal,symbol);
            board.display();

            //switches players
            if(!cheating) {
                if(symbol.equals("X")) {
                    symbol = "O";
                }
                else {
                    symbol = "X";
                }
            }
        }
    }
}
