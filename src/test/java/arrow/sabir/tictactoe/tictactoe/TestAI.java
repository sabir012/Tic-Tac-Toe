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

        this.gameState.getPlayerStateMachine().setNewPlayer(new Human("O"));
        this.gameState.getPlayerStateMachine().setNewPlayer(new Computer("H"));

        for(int i=0; i<gameState.getBoardState().length;i++){
            for(int j=0; j<gameState.getBoardState()[0].length;j++){
                gameState.getBoardState()[i][j] = "X";
            }
        }
    }

    @Test
    public void test_AI_can_found_last_cell(){
        //when
        this.gameState.getBoardState()[0][0] = " ";
        Move move = new AI().getComputerMove(
                this.gameState.getBoardState(),
                this.gameState.getBoardRows(),
                this.gameState.getBoardColumns());

        //then
        assertEquals(1, move.getRow());
        assertEquals(1, move.getColumn());
    }

}
