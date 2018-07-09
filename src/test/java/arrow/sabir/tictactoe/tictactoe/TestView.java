package arrow.sabir.tictactoe.tictactoe;

import arrow.sabir.tictactoe.tictactoe.controller.GameController;
import arrow.sabir.tictactoe.tictactoe.exception.CellMarkedException;
import arrow.sabir.tictactoe.tictactoe.exception.OutOfBoundMoveException;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediator;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediatorImpl;
import arrow.sabir.tictactoe.tictactoe.model.Move;
import arrow.sabir.tictactoe.tictactoe.view.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestView extends TestParentSetUp{
    private GameMediator mediator;
    private GameController game;


    @Before
    public void setUp() {
        super.setUp();

        for(int i=0; i<this.getGameState().boardState.length;i++){
            for(int j=0; j<this.getGameState().boardState[0].length;j++){
                this.getGameState().boardState[i][j] = " ";
            }
        }

        this.getGameState().boardState[0][0] = "X";
        this.getGameState().boardState[0][1] = "X";
        this.getGameState().boardState[0][2] = "X";

        mediator = new GameMediatorImpl(this.getGameState());

        game = new GameController(mediator);
    }

    @Test
    public void test_shouldDrawWelcomeView() {
        this.mediator.gameInitiated();

        assertTrue(this.mediator.getView() instanceof WelcomeView);
    }

    @Test
    public void test_shouldDrawBoardView() throws OutOfBoundMoveException, CellMarkedException {
        this.mediator.playerMoved(new Move.MoveBuilder(3,3).build());

        assertTrue(this.mediator.getView() instanceof BoardView);
    }

    @Test
    public void test_shouldDrawBoardViewStarted() {
        this.mediator.gameStarted();

        assertTrue(this.mediator.getView() instanceof BoardView);
    }

    @Test
    public void test_shouldDrawGameOverView() {
        this.mediator.gameOver();

        assertTrue(this.mediator.getView() instanceof GameOverView);
    }

    @Test
    public void test_shouldDrawNextMoveView() {
        this.mediator.nextMove();

        assertTrue(this.mediator.getView() instanceof NextMoveView);
    }

    @Test
    public void test_shouldDrawWinnerView() {
        this.mediator.isWinnerFound();

        assertTrue(this.mediator.getView() instanceof WinnerView);
    }
}
