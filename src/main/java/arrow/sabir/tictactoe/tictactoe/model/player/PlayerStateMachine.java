package arrow.sabir.tictactoe.tictactoe.model.player;

import java.util.ArrayList;


public class PlayerStateMachine {

    private ArrayList<Player> players = new ArrayList<>();

    private Player currentPlayer;

    private Player winner;


    public PlayerStateMachine(ArrayList<Player> players){
        this.players = players;

        this.currentPlayer = this.players.get(0);
    }


    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public void moveToNextPlayer(){
        int currentPlayerIndex = players.indexOf(currentPlayer);

        int nextIndex = (currentPlayerIndex + 1) % players.size();

        this.currentPlayer = players.get(nextIndex);
    }

    public void setWinner(Player player){
        this.winner = player;
    }

    public void setNewPlayer(Player player){
        players.add(player);
    }
}
