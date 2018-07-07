package arrow.sabir.tictactoe.tictactoe.view;


import arrow.sabir.tictactoe.tictactoe.model.player.Player;
import arrow.sabir.tictactoe.tictactoe.viewmodel.ViewModel;
import arrow.sabir.tictactoe.tictactoe.viewmodel.WelcomeViewModel;


public class WelcomeView implements GameView {

    @Override
    public void draw(ViewModel welcomeViewModel) {
        System.out.println("Welcome to the TIC-TAC-TOE Game");

        System.out.printf("Players:");

        StringBuilder builder = new StringBuilder();
        builder.append("  ");

        for (Player player: ((WelcomeViewModel)welcomeViewModel).getPlayers()){
            builder.append(player.getSign());
            builder.append("  ");
        }

        System.out.printf(builder.toString());

        System.out.println();

        System.out.println("Due to start or close the game please type proper command [start/close]:");
    }
}
