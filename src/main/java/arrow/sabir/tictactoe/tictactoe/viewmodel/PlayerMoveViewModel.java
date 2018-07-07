package arrow.sabir.tictactoe.tictactoe.viewmodel;

import arrow.sabir.tictactoe.tictactoe.model.Move;
import arrow.sabir.tictactoe.tictactoe.model.player.Player;

public class PlayerMoveViewModel implements ViewModel {

    private Player player;
    private Move move;


    public PlayerMoveViewModel(Player player, Move move){
        this.player = player;
        this.move = move;
    }

    public Player getPlayer() {
        return player;
    }

    public Move getMove() {
        return move;
    }
}
