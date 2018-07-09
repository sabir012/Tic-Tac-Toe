package arrow.sabir.tictactoe.tictactoe.mediator;

import arrow.sabir.tictactoe.tictactoe.exception.CellMarkedException;
import arrow.sabir.tictactoe.tictactoe.exception.OutOfBoundMoveException;
import arrow.sabir.tictactoe.tictactoe.model.Move;
import arrow.sabir.tictactoe.tictactoe.view.GameView;

public interface GameMediator {
    void playerMoved(Move move) throws OutOfBoundMoveException, CellMarkedException;

    void gameInitiated();

    void gameStarted();

    boolean isWinnerFound();

    boolean isBoardFull();

    void gameOver();

    void nextMove();

    void exceptionHandle(String message);

    boolean isComputerMove();

    void computerMoved() throws OutOfBoundMoveException, CellMarkedException;

    GameView getView();
}
