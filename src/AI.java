public class AI {

    private Board board;

    public AI(Board theBoard) {
        board = theBoard;
    }

    public int randomMove() {
        int place = (int) (Math.random() * 9) + 1;
        while(board.hasVal(place)) {
            place = (int) (Math.random() * 9) + 1;
        }
        return place;
    }

    //more efficient way? will end up checking 3 for each way to win
    /*public int[] stopWinPos() {
        for(int i=0; i < 3; i++) {
            //checks if horizontal pair
            if(board.valAt(i,0).equals(board.valAt(i,1)) && !board.hasValSpecific(i,3)) {
                return new int[]{i,3};
            }
            //checks if vertical is possible win
            if(board.valAt(0,i).equals(board.valAt(1,i)) && !board.hasValSpecific(3,i)){
                return new int[]{3,i};
            }
        }
        if(board.valAt(0,0).equals(board.valAt(1,1)) && !board.hasValSpecific(2,2)) {
            return new int[]{2,2};
        }
        if(board.valAt(0,2).equals(board.valAt(1,1)) && !board.hasValSpecific(2,0))) {
            return new int[]{2,0};
        }
        return new int[]{5};
    }*/



}