package arrow.sabir.tictactoe.tictactoe;

import arrow.sabir.tictactoe.tictactoe.mediator.GameMediator;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediatorImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestGameLogic extends TestParentSetUp {
    private GameMediator mediator;


    @Before
    public void setUp() {
        super.setUp();

        mediator = new GameMediatorImpl(this.getGameState());
    }

    @Test
    public void test_shouldReturnWinnerFoundByRow(){
        this.getGameState().boardState[0][0] = "X";
        this.getGameState().boardState[0][1] = "X";
        this.getGameState().boardState[0][2] = "X";

        assertEquals(true, mediator.isWinnerFound());
    }

    @Test
    public void test_shouldReturnWinnerFoundByColumn(){
        this.getGameState().boardState[0][0] = "X";
        this.getGameState().boardState[1][0] = "X";
        this.getGameState().boardState[2][0] = "X";

        assertEquals(true, mediator.isWinnerFound());
    }

    @Test
    public void test_shouldReturnWinnerFoundByDiagonal(){
        this.getGameState().boardState[0][0] = "X";
        this.getGameState().boardState[1][1] = "X";
        this.getGameState().boardState[2][2] = "X";

        assertEquals(true, mediator.isWinnerFound());
    }

    @Test
    public void test_shouldReturnWinnerNotFoundByRow(){
        this.getGameState().boardState[0][0] = "X";
        this.getGameState().boardState[0][1] = "X";

        assertEquals(false, mediator.isWinnerFound());
    }

    @Test
    public void test_shouldReturnWinnerNotFoundByColumn(){
        this.getGameState().boardState[0][0] = "X";
        this.getGameState().boardState[1][0] = "X";

        assertEquals(false, mediator.isWinnerFound());
    }

    @Test
    public void test_shouldReturnWinnerNotFoundByDiagonal(){
        this.getGameState().boardState[0][0] = "X";
        this.getGameState().boardState[1][1] = "X";

        assertEquals(false, mediator.isWinnerFound());
    }

    @Test
    public void test_shouldReturnBoardIsFull(){
        for(int i=0;i<this.getGameState().boardState.length;i++){
            for(int j=0; j<this.getGameState().boardState[0].length;j++){
                this.getGameState().boardState[i][j] = "X";
            }
        }

        assertEquals(true, mediator.isBoardFull());
    }
}
