package arrow.sabir.tictactoe.tictactoe;

import arrow.sabir.tictactoe.tictactoe.mediator.GameMediator;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediatorImpl;
import arrow.sabir.tictactoe.tictactoe.model.GameState;
import arrow.sabir.tictactoe.tictactoe.model.player.Computer;
import arrow.sabir.tictactoe.tictactoe.model.player.Human;
import arrow.sabir.tictactoe.tictactoe.model.player.Player;
import arrow.sabir.tictactoe.tictactoe.model.player.PlayerStateMachine;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class TestGameLogic extends TestCase {
    private GameState gameState;
    private GameMediator mediator;


    @Before
    public void setUp() {
        gameState = new GameState(
                new PlayerStateMachine(
                        new ArrayList<Player>(Arrays.asList(new Human("X")))), 3, 3);

        this.gameState.getPlayerStateMachine().setNewPlayer(new Human("O"));
        this.gameState.getPlayerStateMachine().setNewPlayer(new Computer("H"));

        mediator = new GameMediatorImpl(this.gameState);
    }

    @Test
    public void test_row_winner_found(){
        //when
        this.gameState.getBoardState()[0][0] = "X";
        this.gameState.getBoardState()[0][1] = "X";
        this.gameState.getBoardState()[0][2] = "X";

        //then
        assertEquals(true, mediator.isWinnerFound());
    }

    @Test
    public void test_column_winner_found(){
        //when
        this.gameState.getBoardState()[0][0] = "X";
        this.gameState.getBoardState()[1][0] = "X";
        this.gameState.getBoardState()[2][0] = "X";

        //then
        assertEquals(true, mediator.isWinnerFound());
    }

    @Test
    public void test_diagonal_winner_found(){
        //when
        this.gameState.getBoardState()[0][0] = "X";
        this.gameState.getBoardState()[1][1] = "X";
        this.gameState.getBoardState()[2][2] = "X";

        //then
        assertEquals(true, mediator.isWinnerFound());
    }

    @Test
    public void test_row_winner_not_found(){
        //when
        this.gameState.getBoardState()[0][0] = "X";
        this.gameState.getBoardState()[0][1] = "X";

        //then
        assertEquals(false, mediator.isWinnerFound());
    }

    @Test
    public void test_column_winner_not_found(){
        //when
        this.gameState.getBoardState()[0][0] = "X";
        this.gameState.getBoardState()[1][0] = "X";

        //then
        assertEquals(false, mediator.isWinnerFound());
    }

    @Test
    public void test_diagonal_winner_not_found(){
        //when
        this.gameState.getBoardState()[0][0] = "X";
        this.gameState.getBoardState()[1][1] = "X";

        //then
        assertEquals(false, mediator.isWinnerFound());
    }

    @Test
    public void test_board_full(){
        //when
        for(int i=0;i<this.gameState.getBoardState().length;i++){
            for(int j=0; j<this.gameState.getBoardState()[0].length;j++){
                this.gameState.getBoardState()[i][j] = "X";
            }
        }

        //then
        assertEquals(true, mediator.isBoardFull());
    }
}
