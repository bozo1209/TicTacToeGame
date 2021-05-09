package Game;

import java.util.Arrays;

public class GameBoard {

    private final String[][] gameBoard = new String[3][3];
    private static GameBoard gameBoardInstance = null;

    private GameBoard(){
        this.createGameBoard();
    }

    public static GameBoard getInstance(){
        if (gameBoardInstance == null){
            gameBoardInstance = new GameBoard();
        }
        return gameBoardInstance;
    }

    private void createGameBoard(){
        for (String[] strings : gameBoard) {
            Arrays.fill(strings, "");
        }
    }

    public void setGameBoardInstanceToNull(){
        gameBoardInstance = null;
    }

    public void setGameBoard(int row, int column, String playerSing){
        gameBoard[row][column] = playerSing;
    }

    public String[][] getGameBoard(){
        return gameBoard;
    }

    @SuppressWarnings("ForLoopReplaceableByForEach")
    public GameStatus resultsOfGame(){
        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard[i].length; j++){
                if (gameBoard[i][0].equals("x") && gameBoard[i][1].equals("x") && gameBoard[i][2].equals("x")){
                    return GameStatus.PLAYER1WIN;
                }else if (gameBoard[0][j].equals("x") && gameBoard[1][j].equals("x") && gameBoard[2][j].equals("x")){
                    return GameStatus.PLAYER1WIN;
                }else if (gameBoard[0][0].equals("x") && gameBoard[1][1].equals("x") && gameBoard[2][2].equals("x")){
                    return GameStatus.PLAYER1WIN;
                }else if (gameBoard[2][0].equals("x") && gameBoard[1][1].equals("x") && gameBoard[0][2].equals("x")){
                    return GameStatus.PLAYER1WIN;
                }else if (gameBoard[i][0].equals("o") && gameBoard[i][1].equals("o") && gameBoard[i][2].equals("o")){
                    return GameStatus.PLAYER2WIN;
                }else if (gameBoard[0][j].equals("o") && gameBoard[1][j].equals("o") && gameBoard[2][j].equals("o")){
                    return GameStatus.PLAYER2WIN;
                }else if (gameBoard[0][0].equals("o") && gameBoard[1][1].equals("o") && gameBoard[2][2].equals("o")){
                    return GameStatus.PLAYER2WIN;
                }else if (gameBoard[2][0].equals("o") && gameBoard[1][1].equals("o") && gameBoard[0][2].equals("o")){
                    return GameStatus.PLAYER2WIN;
                }
            }
        }

        if (!this.arrayHasEmptyElement(gameBoard)){
            return GameStatus.TIE;
        }
        return GameStatus.ONGOING;
    }

    private <T> boolean arrayHasEmptyElement(T[][] array){
        for (T[] arrayElement : array){
            for (T element : arrayElement){
                if (element.equals("")){
                    return true;
                }
            }
        }
        return false;
    }

}
