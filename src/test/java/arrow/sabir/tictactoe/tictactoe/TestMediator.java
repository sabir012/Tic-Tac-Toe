package arrow.sabir.tictactoe.tictactoe;

import arrow.sabir.tictactoe.tictactoe.exception.CellMarkedException;
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

import java.util.ArrayList;
import java.util.Arrays;

public class TestMediator extends TestCase {
    private GameState gameState;
    private GameMediator mediator;


    @Before
    public void setUp() {
        gameState = new GameState(
                new PlayerStateMachine(
                        new ArrayList<Player>(Arrays.asList(new Human("X")))), 3, 3);

        this.gameState.playerStateMachine.setNewPlayer(new Human("O"));
        this.gameState.playerStateMachine.setNewPlayer(new Computer("H"));

        for(int i=0; i<gameState.boardState.length;i++){
            for(int j=0; j<gameState.boardState[0].length;j++){
                gameState.boardState[i][j] = " ";
            }
        }

        mediator = new GameMediatorImpl(this.gameState);
    }

    @Test
    public void test_mediator_player_moved() throws OutOfBoundMoveException, CellMarkedException {
        //when
        Move move = new Move.MoveBuilder(1,1).build();
        mediator.playerMoved(move);

        //then
        assertEquals("X", this.gameState.boardState[0][0]);
    }

    @Test
    public void test_mediator_isComputer_move() throws OutOfBoundMoveException, CellMarkedException {
        //when
        mediator.playerMoved(new Move.MoveBuilder(1,1).build());
        mediator.playerMoved(new Move.MoveBuilder(2,2).build());

        boolean result = mediator.isComputerMove();

        //then
        assertEquals(true, result);
    }
}
