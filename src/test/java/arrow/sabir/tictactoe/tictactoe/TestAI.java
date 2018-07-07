package arrow.sabir.tictactoe.tictactoe;

import arrow.sabir.tictactoe.tictactoe.model.GameState;
import arrow.sabir.tictactoe.tictactoe.model.Move;
import arrow.sabir.tictactoe.tictactoe.model.player.Computer;
import arrow.sabir.tictactoe.tictactoe.model.player.Human;
import arrow.sabir.tictactoe.tictactoe.model.player.Player;
import arrow.sabir.tictactoe.tictactoe.model.player.PlayerStateMachine;
import arrow.sabir.tictactoe.tictactoe.utils.AI;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestAI extends TestCase {
    private GameState gameState;


    @Before
    public void setUp() {
        gameState = new GameState(
                new PlayerStateMachine(
                        new ArrayList<Player>(Arrays.asList(new Human("X")))), 3, 3);

        this.gameState.playerStateMachine.setNewPlayer(new Human("O"));
        this.gameState.playerStateMachine.setNewPlayer(new Computer("H"));

        for(int i=0; i<gameState.boardState.length;i++){
            for(int j=0; j<gameState.boardState[0].length;j++){
                gameState.boardState[i][j] = "X";
            }
        }
    }

    @Test
    public void test_shouldReturnMove_1_1(){
        //when
        this.gameState.boardState[0][0] = " ";
        Move move = new AI().getComputerMove(
                this.gameState.boardState,
                this.gameState.boardRows,
                this.gameState.boardColumns);

        //then
        assertEquals(1, move.row);
        assertEquals(1, move.column);
    }

}
