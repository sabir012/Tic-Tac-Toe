package arrow.sabir.tictactoe.tictactoe.view;


import arrow.sabir.tictactoe.tictactoe.model.player.Player;
import arrow.sabir.tictactoe.tictactoe.view.constant.BoardConstant;
import arrow.sabir.tictactoe.tictactoe.viewmodel.BoardViewModel;
import arrow.sabir.tictactoe.tictactoe.viewmodel.ViewModel;


public class BoardView extends GameView{

    @Override
    public void draw(ViewModel boardViewModel) {
        System.out.println();

        this.drawTopNumbers(((BoardViewModel)boardViewModel).getColumns());

        this.drawBoardBody(boardViewModel);
    }


    private  void drawLine(int columns){
        System.out.printf(" ");

        for(int i=0;i<columns;i++){
            System.out.printf(BoardConstant.ROW_SEPARATOR);
        }

        System.out.println();
    }

    private void drawTopNumbers(int columns){
        System.out.printf(BoardConstant.LEFT_START_MARGIN);

        for(int i = 1; i <= columns; i++){
            System.out.printf(BoardConstant.NUMBER_LEFT_MARGIN + i + BoardConstant.NUMBER_RIGHT_MARGIN);
        }

        System.out.println();
    }

    private void drawBoardBody(ViewModel boardViewModel){
        for (int i = 1; i <= ((BoardViewModel)boardViewModel).getRows(); i++){

            drawLine(((BoardViewModel)boardViewModel).getColumns());

            System.out.printf(i + BoardConstant.RIGHT_START_MARGIN);

            for(int j = 0; j < ((BoardViewModel)boardViewModel).getColumns(); j++){
                System.out.printf(BoardConstant.SEPARATOR);
                System.out.printf(BoardConstant.BOARD_ELEMENT_MARGIN);

                if(((BoardViewModel)boardViewModel).getBoard()[i-1][j] != null) {
                    System.out.printf(((BoardViewModel)boardViewModel).getBoard()[i-1][j]);
                }
                else {
                    ((BoardViewModel)boardViewModel).getBoard()[i-1][j] = " ";
                    System.out.printf(" ");
                }
                System.out.printf(BoardConstant.BOARD_ELEMENT_MARGIN);
            }

            System.out.printf(BoardConstant.SEPARATOR);
            System.out.println();
        }

        drawLine(((BoardViewModel)boardViewModel).getColumns());
    }
}
