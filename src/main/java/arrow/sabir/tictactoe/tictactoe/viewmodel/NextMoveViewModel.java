package arrow.sabir.tictactoe.tictactoe.viewmodel;

import arrow.sabir.tictactoe.tictactoe.model.player.Player;


public class NextMoveViewModel implements ViewModel {

    private Player player;

    public NextMoveViewModel(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
