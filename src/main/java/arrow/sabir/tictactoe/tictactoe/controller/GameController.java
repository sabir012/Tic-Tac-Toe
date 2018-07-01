package arrow.sabir.tictactoe.tictactoe.controller;

import arrow.sabir.tictactoe.tictactoe.exception.CellMarkedException;
import arrow.sabir.tictactoe.tictactoe.exception.IncorrectMoveException;
import arrow.sabir.tictactoe.tictactoe.exception.OutOfBoundMoveException;
import arrow.sabir.tictactoe.tictactoe.mediator.GameMediator;
import arrow.sabir.tictactoe.tictactoe.model.Move;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;


public class GameController implements Game{

    private GameMediator mediator;
    private Scanner scanner;

    @Autowired
    public GameController(GameMediator mediator){
        this.mediator = mediator;

        this.scanner = new Scanner(System.in);
    }


    @Override
    public void init() {
        mediator.gameInitiated();

        String command = scanner.next();

        switch (command){
            case "start":{
                this.start();

                break;
            }

            case "close":{
                this.end();
                break;
            }

            default:{
                System.out.println("Incorrect command. Game is shutting down...");
            }
        }
    }

    @Override
    public void start() {
        mediator.gameStarted();

        while(!mediator.isWinnerFound() && !mediator.isBoardFull()) {

            try {
                mediator.nextMove();

                if(!mediator.isComputerMove()) {
                    String command = scanner.next();

                    Move playerMove = convertCommandToMove(command);

                    mediator.playerMoved(playerMove);
                }
                else {
                    mediator.computerMoved();
                }
            }
            catch (IncorrectMoveException ex){
                mediator.exceptionHandle("Your command is wrong. Please write correct move command: 'row,column'");
            }
            catch (OutOfBoundMoveException ex){
                mediator.exceptionHandle("Please write correct cell coordinates.");
            }
            catch (CellMarkedException ex){
                mediator.exceptionHandle("Following cell has already marked. Please mark new cell.");
            }
        }

        this.end();
    }

    @Override
    public void end() {
        mediator.gameOver();
    }


    public Move convertCommandToMove(String command) throws IncorrectMoveException{
        int row = 0;
        int column = 0;

        try {
            int commaIndex = command.indexOf(',');

            row = Integer.parseInt(command.substring(0, commaIndex));
            column = Integer.parseInt(command.substring(commaIndex + 1, command.length()));

        }
        catch (Exception e){
            throw new IncorrectMoveException();
        }

        return new Move(row,column);
    }
}
