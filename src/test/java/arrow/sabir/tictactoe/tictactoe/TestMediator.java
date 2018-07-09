package arrow.sabir.tictactoe.tictactoe;

import arrow.sabir.tictactoe.tictactoe.exception.CellMarkedException;
import arrow.sabir.tictactoe.tictactoe.exception.OutOfBoundMoveException;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediator;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediatorImpl;
import arrow.sabir.tictactoe.tictactoe.model.Move;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestMediator extends TestParentSetUp {
    private GameMediator mediator;


    @Before
    public void setUp() {
        super.setUp();

        for(int i=0; i<getGameState().boardState.length;i++){
            for(int j=0; j<getGameState().boardState[0].length;j++){
                getGameState().boardState[i][j] = " ";
            }
        }

        mediator = new GameMediatorImpl(this.getGameState());
    }

    @Test
    public void test_shouldReturnPlayerMovedX() throws OutOfBoundMoveException, CellMarkedException {
        Move move = new Move.MoveBuilder(1,1).build();
        mediator.playerMoved(move);

        assertEquals("X", this.getGameState().boardState[0][0]);
    }

    @Test
    public void test_shouldReturnIsComputerMoveTrue() throws OutOfBoundMoveException, CellMarkedException {
        mediator.playerMoved(new Move.MoveBuilder(1,1).build());
        mediator.playerMoved(new Move.MoveBuilder(2,2).build());

        boolean result = mediator.isComputerMove();

        assertEquals(true, result);
    }
}
