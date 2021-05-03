package AI;

import Game.GameBoard;
import Game.GameStatus;

import java.util.Arrays;

public class TicTacToeAI {

    public static CustomPair bestMove(){
        GameBoard gameBoard = GameBoard.getInstance();
        CustomPair move = null;
//        int bestScore = Integer.MIN_VALUE;
        int bestScore = Integer.MAX_VALUE;
        //        move = new CustomPair(2,2);

        outerLoop:
        for (int i = 0; i < gameBoard.getGameBoard().length; i++){
            for (int j = 0; j < gameBoard.getGameBoard()[i].length; j++){
                if (gameBoard.getGameBoard()[i][j].equals("")){
//                    System.out.println("GameBoard.getInstance().getGameBoard()[i][j].equals(\"\")");
                    gameBoard.setGameBoard(i, j, "o");
                    int score = minimax(gameBoard, 0, false);
                    System.out.println("if i: " + i + " j: " + j);
                    System.out.println("score: " + score + " bestscore: " + bestScore);
//                    System.out.println(Arrays.deepToString(gameBoard.getGameBoard()));
//                    System.out.println("bestMove() " + score);
//                    System.out.println("bestscore " + bestScore);
                    gameBoard.setGameBoard(i, j, "");
                    if (score < bestScore){
//                        System.out.println("score > bestScore");
                        bestScore =score;
                        move = new CustomPair(i,j);
//                        break outerLoop;
                    }
                }
            }
        }
//        System.out.println("*************");
//        System.out.println(move.toString());
        System.out.println("move: (" + move.getRow() + ", " + move.getColumn() + ")" );
        return move;
    }

//    int score = switch (GameBoard.getInstance().resultsOfGame()){
//
//        default -> throw new IllegalStateException("Unexpected value: " + GameBoard.getInstance().resultsOfGame());
//    }

    GameStatus gameStatus = GameBoard.getInstance().resultsOfGame();

    private static int minimax(GameBoard gameBoard, int depth, boolean isMaximizing){
        if (!gameBoard.resultsOfGame().equals(GameStatus.ONGOING)) {
//            System.out.println("!gameBoard.resultsOfGame().equals(GameStatus.ONGOING)");
            return switch (gameBoard.resultsOfGame()) {
                case PLAYER1WIN -> 100;
                case PLAYER2WIN -> -100;
                case TIE -> 0;
                default -> throw new IllegalStateException("Unexpected value: " + gameBoard.resultsOfGame());
            };
        }


//            int i = switch (GameBoard.getInstance().resultsOfGame()){
//                case PLAYER1WIN -> -1;
//                case PLAYER2WIN -> 1;
//                case TIE -> 0;
//                default -> throw new IllegalStateException("Unexpected value: " + GameBoard.getInstance().resultsOfGame());
//            };
//            System.out.println("i: " + i);
//            return i;
//        }

//        int kk;
//        if (kk == null)

//        if (gameBoard.getGameValue() != Integer.MIN_VALUE){
//            return gameBoard.getGameValue();
//        }

//        System.out.println(gameBoard.getGameValue());

        int bestScore;
        if (isMaximizing){
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < gameBoard.getGameBoard().length; i++){
                for (int j = 0; j < gameBoard.getGameBoard()[i].length; j++){
                    if (gameBoard.getGameBoard()[i][j].equals("")){
                        gameBoard.setGameBoard(i, j, "o");
                        int score = minimax(gameBoard, depth + 1, false);
//                        System.out.println(Arrays.deepToString(gameBoard.getGameBoard()));
                        gameBoard.setGameBoard(i, j, "");
//                        System.out.println("if i: " + i + " j: " + j);
//                        System.out.println("score: " + score + " bestscore: " + bestScore);
                        bestScore = Math.max(score, bestScore);
//                        System.out.println("po score: " + score + " bestscore: " + bestScore);
//                        bestScore = Math.max(score, bestScore) - depth;
//                        if (score > bestScore){
//                            bestScore = score;
//                        }
//                        return bestScore;
                    }
                }
            }
            return bestScore;
        }else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < GameBoard.getInstance().getGameBoard().length; i++){
                for (int j = 0; j < GameBoard.getInstance().getGameBoard()[i].length; j++){
                    if (gameBoard.getGameBoard()[i][j].equals("")){
                        gameBoard.setGameBoard(i, j, "x");
                        int score = minimax(gameBoard, depth + 1, true);
//                        System.out.println(Arrays.deepToString(gameBoard.getGameBoard()));
                        gameBoard.setGameBoard(i, j, "");
//                        System.out.println("else i: " + i + " j: " + j);
//                        System.out.println("score: " + score + " bestscore: " + bestScore);
                        bestScore = Math.min(score, bestScore);
//                        System.out.println("po score: " + score + " bestscore: " + bestScore);
//                        bestScore = Math.min(score, bestScore) + depth;
//                        if (score < bestScore){
//                            bestScore = score;
//                        }
//                        return bestScore;
                    }
                }
            }
            return bestScore;
        }
//        System.out.println(bestScore);
//        return bestScore;
//        return 1;
    }
}