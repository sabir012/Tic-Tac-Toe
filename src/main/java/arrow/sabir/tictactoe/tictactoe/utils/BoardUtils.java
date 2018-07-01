package arrow.sabir.tictactoe.tictactoe.utils;

import java.util.List;

public class BoardUtils {

    private final int WINNER_RULE = 3;

    public String checkWinner(String[][] board, List<String> signes){
        String result = this.checkRows(board,signes);
        if(result != ""){
            return result;
        }

        result = this.checkColumns(board, signes);
        if(result != ""){
            return result;
        }

        result = this.checkLeftDiagonal(board, signes);
        if(result != ""){
            return result;
        }

        result = this.checkRightDiagonal(board, signes);
        if(result != ""){
            return result;
        }

        return "";
    }


    private String checkRows(String[][] board, List<String> signes){
        String lookingSign;
        int signCounter = 0;

        for(int i = 0; i < board.length; i++){
            lookingSign = board[i][0];

            for(int j = 0; j < board[0].length; j++){
                if(lookingSign == board[i][j] && signes.contains(lookingSign)){
                    signCounter+=1;
                }
                else {
                    lookingSign = board[i][j];
                    signCounter = 1;
                }

                if(signCounter == WINNER_RULE){
                    return lookingSign;
                }
            }

            signCounter = 0;
        }

        return "";
    }

    private String checkColumns(String[][] board, List<String> signes){
        String lookingSign;
        int signCounter = 0;

        // Check all columns
        for(int i = 0; i < board[0].length; i++){
            lookingSign = board[0][i];

            for(int j = 0; j < board.length; j++){
                if(lookingSign == board[j][i] && signes.contains(lookingSign)){
                    signCounter+=1;
                }
                else {
                    lookingSign = board[j][i];
                    signCounter = 1;
                }

                if(signCounter == WINNER_RULE){
                    return lookingSign;
                }
            }

            signCounter = 0;
        }

        return "";
    }

    private String checkLeftDiagonal(String[][] board, List<String> signes){
        String lookingSign;
        int signCounter = 0;

        int j = 0;

        while(j< board.length){
            int rowIndex = 0;
            int columnIndex = j;

            lookingSign = board[0][j];
            signCounter = 0;

            while(columnIndex>=0){

                if(lookingSign == board[rowIndex][columnIndex] && signes.contains(lookingSign)){
                    signCounter+=1;
                }
                else {
                    lookingSign = board[rowIndex][columnIndex];
                    signCounter = 1;
                }

                if(signCounter == WINNER_RULE){
                    return lookingSign;
                }

                rowIndex+=1;
                columnIndex-=1;
            }

            j+=1;
        }

        int i = 1;
        j = board.length - 1;

        while(i < board.length){
            int rowIndex = i;
            int columnIndex = board.length - 1;

            lookingSign = board[i][j];
            signCounter = 0;

            while(rowIndex < board.length){
                if(lookingSign == board[rowIndex][columnIndex] && signes.contains(lookingSign)){
                    signCounter+=1;
                }
                else {
                    lookingSign = board[rowIndex][columnIndex];
                    signCounter = 1;
                }

                if(signCounter == WINNER_RULE){
                    return lookingSign;
                }

                rowIndex+=1;
                columnIndex-=1;
            }

            i+=1;
        }

        return "";
    }

    private String checkRightDiagonal(String[][] board, List<String> signes){
        String lookingSign;
        int signCounter = 0;

        int j = board.length - 1;

        while(j >= 0){
            int rowIndex = 0;
            int columnIndex = j;

            lookingSign = board[0][j];
            signCounter = 0;

            while(columnIndex < board.length){

                if(lookingSign == board[rowIndex][columnIndex] && signes.contains(lookingSign)){
                    signCounter+=1;
                }
                else {
                    lookingSign = board[rowIndex][columnIndex];
                    signCounter = 1;
                }

                if(signCounter == WINNER_RULE){
                    return lookingSign;
                }

                rowIndex+=1;
                columnIndex+=1;
            }

            j-=1;
        }

        int i = 1;

        while(i < board.length){
            int rowIndex = i;
            int columnIndex = 0;

            lookingSign = board[rowIndex][columnIndex];
            signCounter = 0;

            while(rowIndex < board.length){
                if(lookingSign == board[rowIndex][columnIndex] && signes.contains(lookingSign)){
                    signCounter+=1;
                }
                else {
                    lookingSign = board[rowIndex][columnIndex];
                    signCounter = 1;
                }

                if(signCounter == WINNER_RULE){
                    return lookingSign;
                }

                rowIndex+=1;
                columnIndex+=1;
            }

            i+=1;
        }

        return "";
    }

}
