package arrow.sabir.tictactoe.tictactoe.model;


import arrow.sabir.tictactoe.tictactoe.model.player.PlayerStateMachine;
import org.springframework.beans.factory.annotation.Autowired;

public class GameState {

    private String[][] boardState;

    private PlayerStateMachine playerStateMachine;

    private int boardRows;
    private int boardColumns;


    @Autowired
    public GameState(PlayerStateMachine playerStateMachine, int rows, int columns){
        this.playerStateMachine = playerStateMachine;

        this.boardRows = rows;
        this.boardColumns = columns;

        this.boardState = new String[this.boardRows][this.boardColumns];
    }


    public String[][] getBoardState() {
        return boardState;
    }

    public PlayerStateMachine getPlayerStateMachine() {
        return playerStateMachine;
    }

    public int getBoardRows() {
        return boardRows;
    }

    public int getBoardColumns() {
        return boardColumns;
    }
}
