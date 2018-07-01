package arrow.sabir.tictactoe.tictactoe.exception;

public class CellMarkedException extends Exception {
    public CellMarkedException() {
    }

    public CellMarkedException(String message) {
        super(message);
    }

    public CellMarkedException(Throwable cause) {
        super(cause);
    }

    public CellMarkedException(String message, Throwable cause) {
        super(message, cause);
    }
}
