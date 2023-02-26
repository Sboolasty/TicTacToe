package com.example.tictactoe;
import com.example.tictactoe.*;
import java.util.Scanner;

public class PlayerVsComputerMode {


    private static boolean performMoveForOnePlayer(char[][] board, char activePlayer) {
        if (activePlayer == 'X') {
            System.out.println(activePlayer + ", podaj nr wiersza");
            int row = new Scanner(System.in).nextInt();
            System.out.println(activePlayer + ", podaj nr kolumny");
            int col = new Scanner(System.in).nextInt();

            if (board[row][col] == '_') {
                board[row][col] = activePlayer;
                return true;
            } else {
                System.out.println("To pole jest już zajęte, wybierz inne");
                return false;
            }
        } else {
            System.out.println("Ruch komputera:");
            int[] move = findBestMove(board, activePlayer);
            board[move[0]][move[1]] = activePlayer;
            System.out.println("Komputer zagrał w wierszu " + move[0] + ", kolumnie " + move[1]);
            return true;
        }
    }
    public static int minimax(char[][] board, boolean isMaximizingPlayer) {
        CheckWinner checkWinner = new CheckWinner();
        if (checkWinner.checkWinner(board, 'X')) {
            return -10;
        } else if (checkWinner.checkWinner(board, 'O')) {
            return 10;
        } else if (isBoardFull(board)) {
            return 0;
        }

        if (isMaximizingPlayer) {
            int bestScore = Integer.MIN_VALUE;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == '_') {
                        board[row][col] = 'O';
                        int score = minimax(board,  false);
                        board[row][col] = '_';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == '_') {
                        board[row][col] = 'X';
                        int score = minimax(board, true);
                        board[row][col] = '_';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    public static int[] findBestMove(char[][] board, char player) {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '_') {
                    board[row][col] = player;
                    int score = minimax(board,  false);
                    board[row][col] = '_';
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = row;
                        bestMove[1] = col;
                    }
                }
            }
        }

        return bestMove;
    }
}
