package arrow.sabir.tictactoe.tictactoe.model;


import arrow.sabir.tictactoe.tictactoe.model.player.PlayerStateMachine;
import org.springframework.beans.factory.annotation.Autowired;

public class GameState {

    public final String[][] boardState;
    public final PlayerStateMachine playerStateMachine;

    public final int boardRows;
    public final int boardColumns;


    @Autowired
    public GameState(PlayerStateMachine playerStateMachine, int rows, int columns){
        this.playerStateMachine = playerStateMachine;

        this.boardRows = rows;
        this.boardColumns = columns;

        this.boardState = new String[this.boardRows][this.boardColumns];
    }
}
