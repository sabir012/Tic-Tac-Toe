package arrow.sabir.tictactoe.tictactoe.viewmodel;


public class BoardViewModel extends ViewModel {
    private String[][] board;

    private int rows;
    private int columns;


    public BoardViewModel(String[][] board, int rows, int columns){
        this.board = board;
        this.rows = rows;
        this.columns = columns;

    }

    public String[][] getBoard() {
        return board;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
