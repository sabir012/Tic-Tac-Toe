package arrow.sabir.tictactoe.tictactoe;

import arrow.sabir.tictactoe.tictactoe.controller.GameController;
import arrow.sabir.tictactoe.tictactoe.exception.CellMarkedException;
import arrow.sabir.tictactoe.tictactoe.exception.IncorrectMoveException;
import arrow.sabir.tictactoe.tictactoe.exception.OutOfBoundMoveException;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediator;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediatorImpl;
import arrow.sabir.tictactoe.tictactoe.model.GameState;
import arrow.sabir.tictactoe.tictactoe.model.Move;
import arrow.sabir.tictactoe.tictactoe.model.player.Computer;
import arrow.sabir.tictactoe.tictactoe.model.player.Human;
import arrow.sabir.tictactoe.tictactoe.model.player.Player;
import arrow.sabir.tictactoe.tictactoe.model.player.PlayerStateMachine;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;


public class TestException extends TestCase {

    private GameState gameState;
    private GameMediator mediator;

    private GameController game;


    @Before
    public void setUp() {
        gameState = new GameState(
                new PlayerStateMachine(
                        new ArrayList<Player>(Arrays.asList(new Human("X")))), 3, 3);

        this.gameState.playerStateMachine.setNewPlayer(new Human("O"));
        this.gameState.playerStateMachine.setNewPlayer(new Computer("H"));

        mediator = new GameMediatorImpl(this.gameState);

        game = new GameController(mediator);
    }


    @Test
    public void test_shouldThrowCellMarkedException(){
        //when
        this.gameState.boardState[1][1] = "X";

        //then
        assertThatThrownBy(()->mediator.playerMoved(new Move.MoveBuilder(2,2).build()))
                .isInstanceOf(CellMarkedException.class);
    }

    @Test
    public void test_shouldThrowOutOfBoundExceptionColumn(){
        //then
        assertThatThrownBy(()->mediator.playerMoved(new Move.MoveBuilder(1,20).build()))
                .isInstanceOf(OutOfBoundMoveException.class);
    }

    @Test
    public void test_shouldThrowOutOfBoundExceptionRow(){
        //then
        assertThatThrownBy(()->mediator.playerMoved(new Move.MoveBuilder(20,1).build()))
                .isInstanceOf(OutOfBoundMoveException.class);
    }

    @Test
    public void test_shouldThrowIncorrectMoveException(){
        //When
        String commandStr = "test";

        //then
        assertThatThrownBy(()->game.convertCommandToMove(commandStr))
                .isInstanceOf(IncorrectMoveException.class);
    }
}
