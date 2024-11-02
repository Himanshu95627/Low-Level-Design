package src;



import src.models.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;


    public void initializeGame(){

        //creating 2 Players
       players = new LinkedList<>();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter the name of player 1:");
        String name = inputScanner.nextLine();
        PieceX crossPiece = new PieceX();
        Player player1 = new Player(name, crossPiece);

        PieceO noughtsPiece = new PieceO();
        System.out.println("Enter the name of player two: ");
        Player player2 = new Player(inputScanner.nextLine(), noughtsPiece);

        players.add(player1);
        players.add(player2);

        //initializeBoard
        gameBoard = new Board(3);
    }

    public String startGame(){

        boolean noWinner = true;
        while(noWinner){

            //take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            //get the free space from the board
            gameBoard.printBoard();
            //read the user input
            System.out.print("Player:" + playerTurn.getPlayerName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            while (inputColumn<0 || inputRow <0 || inputColumn >= gameBoard.getSize() || inputRow>= gameBoard.getSize()){
                System.out.println("Please enter number between 0 - "+(gameBoard.getSize()-1));
                System.out.print("Player:" + playerTurn.getPlayerName() + " Enter row,column: ");
                inputScanner = new Scanner(System.in);
                 s = inputScanner.nextLine();
                values = s.split(",");
                inputRow = Integer.valueOf(values[0]);
                inputColumn = Integer.valueOf(values[1]);
            }

            //place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn, playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorredt possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPlayingPiece().getPieceType());
            if(winner) {
                return playerTurn.getPlayerName();
            }
        }

        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.getSize();i++) {

            if(gameBoard.getBoard()[row][i] == null || gameBoard.getBoard()[row][i].getPieceType() != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.getSize();i++) {

            if(gameBoard.getBoard()[i][column] == null || gameBoard.getBoard()[i][column].getPieceType() != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.getSize();i++,j++) {
            if (gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getPieceType() != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.getSize()-1; i<gameBoard.getSize();i++,j--) {
            if (gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getPieceType() != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}

