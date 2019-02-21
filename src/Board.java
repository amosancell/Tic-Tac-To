public class Board {
    private String[][] board;

    //initializes board as 3x3
    public Board() {
        board = new String[3][3];
        for(int i=0; i < 3; i++) {
            for(int j=0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
    }

    //prints board
    public void display() {
        System.out.println("----------");
        for(int i=0; i < 3; i++) {
            System.out.print(board[i][0]);
            System.out.print(" | ");
            System.out.print(board[i][1]);
            System.out.print(" | ");
            System.out.print(board[i][2]);
            System.out.println();
            System.out.println("----------");
        }
    }

    //checks if board spot is filled
    public boolean hasVal(int place) {
        return !(board[(place - 1) / 3][(place - 1) % 3].equals(" "));

    }

    public boolean hasValSpecific(int val1, int val2) {
        return !(board[val1][val2].equals(" "));
    }

    public String valAt(int val1, int val2) {
        return board[val1][val2];
    }


    //updates boarad to represent players making moves
    public void update(int place, String symbol) {
        board[(place - 1) / 3][(place - 1) % 3] = symbol;
    }

    //checks if boaard is full
    //used for tie games
    public boolean isFull() {
        for(int i=1; i < 10; i++) {
            if(!this.hasVal(i))  {
                return false;
            }
        }
        return true;
    }

    //to store if win is possible and where
    private class Result {
        private boolean win;
        private int place;

        public Result(boolean theWin, int thePlace) {
            win = theWin;
            place = thePlace;
        }

    }


    public Result winH() {
        boolean canWin = false;
        //place is place in user units
        int place = -1;
        for(int i=0; i < 3; i++) {
            //checks consecutive on left
            if(board[i][0].equals(board[i][1]) && !this.hasValSpecific(i,2)) {
                canWin = true;
                place = 3 * i + 3;
            }
            //checks gap between
            else if(board[i][0].equals(board[i][2]) && !this.hasValSpecific(i,1)) {
                canWin = true;
                place = 3 * i + 2;
            }
            //checks consecutive on the right
            else if(board[i][1].equals(board[i][2]) && !this.hasValSpecific(i,0)) {
                canWin = true;
                place = 3 * i + 1;
            }
        }
        return new Result(canWin,place);
    }

    public Result winV() {
        boolean canWin = false;
        //place is place in user units
        int place = -1;
        for(int i=0; i < 3; i++) {
            //checks consecutive on top
            if(board[0][i].equals(board[1][i]) && !this.hasValSpecific(2,i)) {
                canWin = true;
                place = 7 + i;
            }
            //checks gap between
            else if(board[0][i].equals(board[2][i]) && !this.hasValSpecific(1,i)) {
                canWin = true;
                place = 4 + i;
            }
            //checks consecutive on the bottom
            else if(board[1][i].equals(board[2][i]) && !this.hasValSpecific(0,i)) {
                canWin = true;
                place = 1 + i;
            }
        }
        return new Result(canWin,place);
    }

    public Result diagWin() {
        boolean canWin = false;
        int place = -1;
        //diag starting top left
        if(board[0][0].equals(board[1][1]) && !this.hasValSpecific(2,2)) {
            canWin = true;
            place = 9;
        }
        else if(board[0][0].equals(board[2][2]) && !this.hasValSpecific(1,1)) {
            canWin = true;
            place = 5;
        }
        else if(board[1][1].equals(board[2][2]) && !this.hasValSpecific(0,0)) {
            canWin = true;
            place = 1;
        }
        //diag starting top right
        if(board[0][2].equals(board[1][1]) && !this.hasValSpecific(2,0)) {
            canWin = true;
            place = 7;
        }
        else if(board[0][2].equals(board[2][0]) && !this.hasValSpecific(1,1)) {
            canWin = true;
            place = 5;
        }
        else if(board[1][1].equals(board[2][0]) && !this.hasValSpecific(0,3)) {
            canWin = true;
            place = 3;
        }
        return new Result(canWin,place);
    }

    //checks if a player has won/tie game occurred
    public boolean isFinished() {
        for(int i=0; i < 3; i++) {
            //checks if win horizontal
            if(!board[i][0].equals(" ") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                System.out.println(board[i][0] + " wins!");
                return true;
            }
            //checks if win vertical
            else if(!board[0][i].equals(" ") && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])) {
                System.out.println(board[0][i] + " wins!");
                return true;
            }
        }
        //check if win diagonal
        if(!board[0][0].equals(" ") && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            System.out.println(board[0][0] + " wins!");
            return true;
        }
        else if(!board[0][2].equals(" ") && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            System.out.println(board[0][2] + " wins!");
            return true;
        }
        //since else if, checks if tie game
        else if(this.isFull()) {
            System.out.println("Tie game!");
            return true;
        }
        return false;
    }
}