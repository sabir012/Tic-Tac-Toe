package arrow.sabir.tictactoe.tictactoe.view;

import arrow.sabir.tictactoe.tictactoe.viewmodel.ViewModel;

public class GameOverView extends GameView {
    @Override
    public void draw(ViewModel gameViewModel) {
        System.out.println("GAME OVER !!!");
    }
}
