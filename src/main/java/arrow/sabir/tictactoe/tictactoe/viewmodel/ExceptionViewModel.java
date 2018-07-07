package arrow.sabir.tictactoe.tictactoe.viewmodel;

public class ExceptionViewModel implements ViewModel {

    private String message;

    public ExceptionViewModel(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
