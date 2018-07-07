package arrow.sabir.tictactoe.tictactoe.model;

public class Move {
    public final int row;
    public final int column;

    private Move(MoveBuilder builder){
        this.row = builder.row;
        this.column = builder.column;
    }

    public static class MoveBuilder{
        private int row;
        private int column;

        public MoveBuilder(int row, int column){
            this.row = row;
            this.column = column;
        }

        public Move build() {
            return new Move(this);
        }
    }
}
