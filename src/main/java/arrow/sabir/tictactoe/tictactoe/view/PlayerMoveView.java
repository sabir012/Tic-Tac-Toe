package arrow.sabir.tictactoe.tictactoe.view;

import arrow.sabir.tictactoe.tictactoe.viewmodel.PlayerMoveViewModel;
import arrow.sabir.tictactoe.tictactoe.viewmodel.ViewModel;

public class PlayerMoveView implements GameView {
    @Override
    public void draw(ViewModel viewModel) {
        System.out.println("Player "+
                ((PlayerMoveViewModel)viewModel).getPlayer().getSign()+
                " marked cell ["+((PlayerMoveViewModel)viewModel).getMove().row +
                ","+((PlayerMoveViewModel)viewModel).getMove().column + "]");
    }
}
