package arrow.sabir.tictactoe.tictactoe;

import arrow.sabir.tictactoe.tictactoe.controller.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TictactoeApplication {

    @Autowired
    private Game game;

    public static void main(String[] args) {
        SpringApplication.run(TictactoeApplication.class, args);
    }


    @PostConstruct
    public void init() {
        game.init();
    }
}
