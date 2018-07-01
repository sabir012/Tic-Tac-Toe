package arrow.sabir.tictactoe.tictactoe.model.player;

public abstract class Player {

    private String sign;

    public Player(String sign){
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
