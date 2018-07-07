package arrow.sabir.tictactoe.tictactoe.viewmodel;

import arrow.sabir.tictactoe.tictactoe.model.player.Player;


public class WinnerViewModel implements ViewModel {

    private Player winner;

    public WinnerViewModel(Player winner){
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }
}
