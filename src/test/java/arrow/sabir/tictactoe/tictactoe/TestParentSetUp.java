package arrow.sabir.tictactoe.tictactoe;


import arrow.sabir.tictactoe.tictactoe.model.GameState;
import arrow.sabir.tictactoe.tictactoe.model.player.Computer;
import arrow.sabir.tictactoe.tictactoe.model.player.Human;
import arrow.sabir.tictactoe.tictactoe.model.player.Player;
import arrow.sabir.tictactoe.tictactoe.model.player.PlayerStateMachine;

import java.util.ArrayList;
import java.util.Arrays;

public class TestParentSetUp {
    private GameState gameState;

    public void setUp() {
        gameState = new GameState(
                new PlayerStateMachine(
                        new ArrayList<Player>(Arrays.asList(new Human("X")))), 3, 3);

        this.gameState.playerStateMachine.setNewPlayer(new Human("O"));
        this.gameState.playerStateMachine.setNewPlayer(new Computer("H"));
    }


    public GameState getGameState() {
        return gameState;
    }
}
