package arrow.sabir.tictactoe.tictactoe.mediator;

import arrow.sabir.tictactoe.tictactoe.exception.CellMarkedException;
import arrow.sabir.tictactoe.tictactoe.exception.OutOfBoundMoveException;
import arrow.sabir.tictactoe.tictactoe.model.player.Computer;
import arrow.sabir.tictactoe.tictactoe.model.player.Player;
import arrow.sabir.tictactoe.tictactoe.utils.AI;
import arrow.sabir.tictactoe.tictactoe.utils.BoardUtils;
import arrow.sabir.tictactoe.tictactoe.model.GameState;
import arrow.sabir.tictactoe.tictactoe.model.Move;
import arrow.sabir.tictactoe.tictactoe.view.*;
import arrow.sabir.tictactoe.tictactoe.viewmodel.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class GameMediatorImpl implements GameMediator {
    private GameState gameState;
    private GameView gameView;


    @Autowired
    public GameMediatorImpl(GameState gameState){
        this.gameState = gameState;
        this.gameView = new WelcomeView();
    }


    @Override
    public void playerMoved(Move move) throws OutOfBoundMoveException, CellMarkedException {
        if (move.getColumn() > this.gameState.getBoardColumns() || move.getRow() > this.gameState.getBoardRows()
                || move.getRow() <= 0 || move.getColumn() <= 0) {
            throw new OutOfBoundMoveException();
        }

        if(this.gameState.getBoardState()[move.getRow() - 1][move.getColumn() - 1] != " "){
            throw new CellMarkedException();
        }

        this.gameState.getBoardState()[move.getRow() - 1][move.getColumn() - 1] =
                this.gameState.getPlayerStateMachine().getCurrentPlayer().getSign();

        this.gameView = new PlayerMoveView();
        this.gameView.draw(
                new PlayerMoveViewModel(this.gameState.getPlayerStateMachine().getCurrentPlayer(), move));

        this.gameState.getPlayerStateMachine().moveToNextPlayer();

        this.gameView = new BoardView();
        this.gameView.draw(
                new BoardViewModel(this.gameState.getBoardState(),
                        gameState.getBoardRows(),
                        gameState.getBoardColumns()));
    }

    @Override
    public void gameInitiated() {
        this.gameView =  new WelcomeView();
        this.gameView.draw(new WelcomeViewModel(this.gameState.getPlayerStateMachine().getPlayers()));

    }

    @Override
    public void gameStarted() {
        this.gameView = new BoardView();
        this.gameView.draw(
                new BoardViewModel(this.gameState.getBoardState(),
                        gameState.getBoardRows(),
                        gameState.getBoardColumns()));
    }

    @Override
    public boolean isWinnerFound() {
        List<String> signes = this.gameState.getPlayerStateMachine()
                                                            .getPlayers()
                                                            .stream()
                                                            .map(player -> player.getSign())
                                                            .collect(Collectors.toList());

        String[][] board = this.gameState.getBoardState();

        String winner = new BoardUtils().checkWinner(board, signes);

        if(winner != ""){
            Optional<Player> player = this.gameState.getPlayerStateMachine()
                                            .getPlayers()
                                            .stream()
                                            .filter(p->p.getSign() == winner)
                                            .findFirst();

            this.gameState.getPlayerStateMachine().setWinner(player.get());
            this.gameView = new WinnerView();
            this.gameView.draw(new WinnerViewModel(player.get()));

            return true;
        }


        return false;
    }

    @Override
    public boolean isBoardFull() {
        String[][] board = this.gameState.getBoardState();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == " "){
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void gameOver() {
        this.gameView = new GameOverView();

        this.gameView.draw(new GameOverViewModel());
    }

    @Override
    public void nextMove() {
        this.gameView = new NextMoveView();
        this.gameView.draw(new NextMoveViewModel(this.gameState.getPlayerStateMachine().getCurrentPlayer()));
    }

    @Override
    public void exceptionHandle(String message) {
        this.gameView = new ExceptionHandleView();
        this.gameView.draw(new ExceptionViewModel(message));
    }

    @Override
    public void computerMoved() throws OutOfBoundMoveException, CellMarkedException {
        Move computerMove = new AI().getComputerMove(this.gameState.getBoardState(), this.gameState.getBoardRows(), this.gameState.getBoardColumns());

        this.playerMoved(computerMove);
    }

    @Override
    public boolean isComputerMove() {
        if(this.gameState.getPlayerStateMachine().getCurrentPlayer() instanceof Computer){
            return true;
        }

        return false;
    }
}
