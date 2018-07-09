package arrow.sabir.tictactoe.tictactoe;

import arrow.sabir.tictactoe.tictactoe.controller.GameController;
import arrow.sabir.tictactoe.tictactoe.exception.CellMarkedException;
import arrow.sabir.tictactoe.tictactoe.exception.IncorrectMoveException;
import arrow.sabir.tictactoe.tictactoe.exception.OutOfBoundMoveException;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediator;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediatorImpl;
import arrow.sabir.tictactoe.tictactoe.model.Move;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class TestException extends TestParentSetUp {
    private GameMediator mediator;
    private GameController game;


    @Before
    public void setUp() {
        super.setUp();

        mediator = new GameMediatorImpl(this.getGameState());

        game = new GameController(mediator);
    }


    @Test
    public void test_shouldThrowCellMarkedException(){
        this.getGameState().boardState[1][1] = "X";

        assertThatThrownBy(()->mediator.playerMoved(new Move.MoveBuilder(2,2).build()))
                .isInstanceOf(CellMarkedException.class);
    }

    @Test
    public void test_shouldThrowOutOfBoundExceptionColumn(){

        assertThatThrownBy(()->mediator.playerMoved(new Move.MoveBuilder(1,20).build()))
                .isInstanceOf(OutOfBoundMoveException.class);
    }

    @Test
    public void test_shouldThrowOutOfBoundExceptionRow(){

        assertThatThrownBy(()->mediator.playerMoved(new Move.MoveBuilder(20,1).build()))
                .isInstanceOf(OutOfBoundMoveException.class);
    }

    @Test
    public void test_shouldThrowIncorrectMoveException(){
        String commandStr = "test";

        assertThatThrownBy(()->game.convertCommandToMove(commandStr))
                .isInstanceOf(IncorrectMoveException.class);
    }
}
