package arrow.sabir.tictactoe.tictactoe.view;

import arrow.sabir.tictactoe.tictactoe.viewmodel.ViewModel;
import arrow.sabir.tictactoe.tictactoe.viewmodel.WinnerViewModel;

public class WinnerView extends GameView {

    @Override
    public void draw(ViewModel viewModel) {
        System.out.println("We have a WINNER!!! Congratulation Player: "+ ((WinnerViewModel)viewModel).getWinner().getSign());
    }
}
