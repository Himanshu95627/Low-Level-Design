package src;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        int emojiSmilingHeart = 0x1F60D;
        System.out.println("game winner is: "+game.startGame() + Character.toString(emojiSmilingHeart));
    }

}
