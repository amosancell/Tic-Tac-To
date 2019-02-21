import java.util.Scanner;

public class SinglePlayer {

    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        AI ai = new AI(board);
        board.display();

        while(!board.isFinished()) {
            System.out.println("Please make your move");
            String input = scanner.nextLine();
            int inputVal = Integer.valueOf(input);
            while(board.hasVal(inputVal)) {
                System.out.println("That place is taken, enter a new position");
                input = scanner.nextLine();
                inputVal = Integer.valueOf(input);
            }
            board.update(inputVal,"X");
            board.update(ai.randomMove(),"O");
            board.display();
        }

    }
}
