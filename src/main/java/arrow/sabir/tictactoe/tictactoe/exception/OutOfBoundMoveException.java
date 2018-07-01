package arrow.sabir.tictactoe.tictactoe.exception;

public class OutOfBoundMoveException extends Exception {
    public OutOfBoundMoveException() {
    }

    public OutOfBoundMoveException(String message) {
        super(message);
    }

    public OutOfBoundMoveException(Throwable cause) {
        super(cause);
    }

    public OutOfBoundMoveException(String message, Throwable cause) {
        super(message, cause);
    }
}
