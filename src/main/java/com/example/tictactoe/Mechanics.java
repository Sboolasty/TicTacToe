package com.example.tictactoe;
import com.example.tictactoe.*;
import java.util.Scanner;

public class Mechanics {
    private static void ticTacToeBoard() {
        TicTacToe chooseGameMode = new TicTacToe();
        CheckWinner checkWinner = new CheckWinner();
        Mechanics printBoard = new Mechanics();
        PlayerVsComputerMode performMoveForOnePlayer = new PlayerVsComputerMode();
        PlayerVsPlayerMode performMoveForTwoPlayers = new PlayerVsPlayerMode();
        int dim = new Scanner(System.in).nextInt();
        char[][] board = new char[dim][dim];
        for (int row = 0; row < dim; row++) {
            for (int column = 0; column < dim; column++) {
                board[row][column] = '_';
            }
        }
    }
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        int dim = board.length;
        System.out.print("\t");
        for (int i = 0; i < dim; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int row = 0; row < dim; row++) {
            System.out.print(row + ":\t");
            for (int column = 0; column < dim; column++) {
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }

    private static boolean performMove(char[][] board, char activePlayer) {
        System.out.println(activePlayer + ", podaj nr wiersza");
        int row = new Scanner(System.in).nextInt();
        System.out.println(activePlayer + ", podaj nr kolumny");
        int col = new Scanner(System.in).nextInt();

        if (board[row][col] == '_') {
            board[row][col] = activePlayer;


            return true;
        } else {
            return false;
        }

    }
}