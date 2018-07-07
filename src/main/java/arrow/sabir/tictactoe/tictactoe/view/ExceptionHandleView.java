package arrow.sabir.tictactoe.tictactoe.view;

import arrow.sabir.tictactoe.tictactoe.viewmodel.ExceptionViewModel;
import arrow.sabir.tictactoe.tictactoe.viewmodel.ViewModel;

public class ExceptionHandleView implements GameView {

    @Override
    public void draw(ViewModel viewModel) {
        System.out.println(((ExceptionViewModel)viewModel).getMessage());
    }
}
