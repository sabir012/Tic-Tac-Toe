package arrow.sabir.tictactoe.tictactoe.utils;

import arrow.sabir.tictactoe.tictactoe.model.Move;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AI {

    public Move getComputerMove(String[][] board, int rows, int columns) {
        int row = ThreadLocalRandom.current().nextInt(1, rows+1);
        int column = ThreadLocalRandom.current().nextInt(1, columns+1);

        while(board[row-1][column-1] != " "){
            row = ThreadLocalRandom.current().nextInt(1, rows+1);
            column = ThreadLocalRandom.current().nextInt(1, columns+1);
        }

        return new Move.MoveBuilder(row,column).build();
    }
}
