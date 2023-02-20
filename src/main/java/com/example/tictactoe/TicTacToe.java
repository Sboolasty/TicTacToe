package com.example.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Witaj w grze, podaj rozmiar planszy");
        int dim = new Scanner(System.in).nextInt();
        char[][] board = new char[dim][dim];
        int movesCounter = 0;
        char activePlayer = 'X';
        boolean won = false;
        while (movesCounter < dim * dim && !won) {
            printBoard(board);
            boolean moveWasCorrect = performMove(board, activePlayer);
            if (moveWasCorrect) {

                movesCounter++;
                won = checkWinner(board, activePlayer);
                activePlayer = activePlayer == 'X' ? 'O' : 'X';
            } else {
                System.out.println("Ruch niepoprawny, spróbuj ponownie");
            }
        }
        printBoard(board);
        System.out.println("Koniec gry :)");
    }

    private static boolean checkWinner(char[][] board, char activePlayer) {
        return checkFirstDiagonal(board, activePlayer) ||
                checkSecondDiagonal(board, activePlayer) ||
                checkWinInColumns(board, activePlayer) ||
                checkWinInRows(board, activePlayer);
    }

    private static boolean checkFirstDiagonal(char[][] board, char activePlayer) {
        int dim = board.length;
        for (int i = 0; i < dim; i++) {
            if (board[i][i] != activePlayer) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSecondDiagonal(char[][] board, char activePlayer) {
        int dim = board.length;
        for (int i = 0; i < dim; i++) {
            if (board[i][dim - i - 1] != activePlayer) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWinInRows(char[][] board, char activePlayer) {
        int dim = board.length;
        for (int row = 0; row < dim; row++) {
            boolean win = true;
            for (int col = 0; col < dim; col++) {
                if (board[row][col] != activePlayer) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkWinInColumns(char[][] board, char activePlayer) {
        int dim = board.length;
        for (int col = 0; col < dim; col++) {
            boolean win = true;
            for (int row = 0; row < dim; row++) {
                if (board[row][col] != activePlayer) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    private static boolean performMove(char[][] board, char activePlayer) {
        System.out.println(activePlayer + ", podaj nr wiersza");
        int row = new Scanner(System.in).nextInt();
        System.out.println(activePlayer + ", podaj nr kolumny");
        int col = new Scanner(System.in).nextInt();

        if (board[row][col] == 0) {
            board[row][col] = activePlayer;



            return true;
        } else {
            return false;
        }

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
}

