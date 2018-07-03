package arrow.sabir.tictactoe.tictactoe.configuration;


import arrow.sabir.tictactoe.tictactoe.controller.Game;
import arrow.sabir.tictactoe.tictactoe.controller.GameController;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediator;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediatorImpl;
import arrow.sabir.tictactoe.tictactoe.model.GameState;
import arrow.sabir.tictactoe.tictactoe.model.player.Computer;
import arrow.sabir.tictactoe.tictactoe.model.player.Human;
import arrow.sabir.tictactoe.tictactoe.model.player.Player;
import arrow.sabir.tictactoe.tictactoe.model.player.PlayerStateMachine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;


@Configuration
public class GameConfig {

    @Value("${player.human.1.sign}")
    private Human player1;

    @Value("${player.human.2.sign}")
    private Human player2;

    @Value("${player.computer.sign}")
    private Computer player3;

    @Value("${screen.rows}")
    private int rows;

    @Value("${screen.columns}")
    private int columns;


    @Bean
    public Game game(GameMediator mediator){
        return new GameController(mediator);
    }

    @Bean
    public GameMediator mediator(GameState gameState) {
        return new GameMediatorImpl(gameState);
    }


    @Bean
    public GameState gameState(PlayerStateMachine playerStateMachine, int rows, int columns) {
       return new GameState(playerStateMachine, rows, columns);
    }

    @Bean
    public PlayerStateMachine playerStateMachine(){
        ArrayList<Player> players = new ArrayList<>();
        players.add(this.player1);
        players.add(this.player2);
        players.add(this.player3);

        return new PlayerStateMachine(players);
    }

    @Bean
    public int rows(){
        return rows;
    }

    @Bean
    public int columns(){
        return columns;
    }
}
