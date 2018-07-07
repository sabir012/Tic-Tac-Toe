package arrow.sabir.tictactoe.tictactoe.view;

import arrow.sabir.tictactoe.tictactoe.viewmodel.NextMoveViewModel;
import arrow.sabir.tictactoe.tictactoe.viewmodel.ViewModel;

public class NextMoveView implements GameView {

    @Override
    public void draw(ViewModel viewModel) {
        System.out.println("Now turn of the Player '"+((NextMoveViewModel)viewModel).getPlayer().getSign()+"'. Please type your move with pattern 'row,column'");
    }
}
