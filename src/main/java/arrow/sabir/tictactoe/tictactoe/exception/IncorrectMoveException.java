package arrow.sabir.tictactoe.tictactoe.exception;


public class IncorrectMoveException extends Exception {
    public IncorrectMoveException() {
    }

    public IncorrectMoveException(String message) {
        super(message);
    }

    public IncorrectMoveException(Throwable cause) {
        super(cause);
    }

    public IncorrectMoveException(String message, Throwable cause) {
        super(message, cause);
    }
}
