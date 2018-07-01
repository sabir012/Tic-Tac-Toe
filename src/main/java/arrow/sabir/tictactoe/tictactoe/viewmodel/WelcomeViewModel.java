package arrow.sabir.tictactoe.tictactoe.viewmodel;

import arrow.sabir.tictactoe.tictactoe.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class WelcomeViewModel extends ViewModel {

    private ArrayList<Player> players;

    public WelcomeViewModel(ArrayList<Player> players){
        super();
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
