package arrow.sabir.tictactoe.tictactoe;

import arrow.sabir.tictactoe.tictactoe.model.Move;
import arrow.sabir.tictactoe.tictactoe.utils.AI;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAI extends TestParentSetUp {

    @Before
    public void setUp() {
        super.setUp();

        for(int i=0; i<this.getGameState().boardState.length;i++){
            for(int j=0; j<this.getGameState().boardState[0].length;j++){
                this.getGameState().boardState[i][j] = "X";
            }
        }
    }

    @Test
    public void test_shouldReturnMove_1_1(){
        //when
        this.getGameState().boardState[0][0] = " ";
        Move move = new AI().getComputerMove(
                this.getGameState().boardState,
                this.getGameState().boardRows,
                this.getGameState().boardColumns);

        //then
        assertEquals(1, move.row);
        assertEquals(1, move.column);
    }

}
