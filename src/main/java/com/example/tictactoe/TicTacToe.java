package com.example.tictactoe;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import com.example.tictactoe.*;

 public class TicTacToe {
        public static void main(String[] args) {
            CheckWinner checkWinner = new CheckWinner();
            System.out.println("Witaj w grze, podaj rozmiar planszy");
            System.out.println("Legenda:");
            System.out.println("Wpisz 3 aby zagrać planszę 3x3");
            System.out.println("Wpisz 4 aby zagrać planszę 4x4");
            System.out.println("Wpisz 5 aby zagrać planszę 5x5");
            System.out.println("Wpisz 6 aby zagrać planszę 6x6" + " " + "itd.");
            int dim = new Scanner(System.in).nextInt();
            char[][] board = new char[dim][dim];
            for (int row = 0; row < dim; row++) {
                for (int column = 0; column < dim; column++) {
                    board[row][column] = '_';
                }
            }
            int movesCounter = 0;
            boolean vsComputer = chooseGameMode();
            char activePlayer = 'X';
            boolean won = false;
            boolean draw = false;
            while (movesCounter < dim * dim && !won && !draw) {
                printBoard(board);
                boolean moveWasCorrect = vsComputer ? performMoveForOnePlayer(board, activePlayer) : performMoveForTwoPlayers(board, activePlayer);
                if (moveWasCorrect) {
                    movesCounter++;
                    won = checkWinner.checkWinner(board, activePlayer);
                    draw = movesCounter == dim * dim && !won;
                    activePlayer = activePlayer == 'X' ? 'O' : 'X';
                } else {
                    System.out.println("Ruch niepoprawny, spróbuj ponownie");
                }
            }
            printBoard(board);
            if (draw) {
                System.out.println("Remis!");
            } else {
                System.out.println("Koniec gry :)");
                System.out.println("Przegrywa gracz: " + activePlayer);
            }
        }

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

        private static boolean performMoveForTwoPlayers(char[][] board, char activePlayer) {
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

        private static boolean chooseGameMode() {
            System.out.println("Wybierz tryb gry:");
            System.out.println("1. Gra dwuosobowa");
            System.out.println("2. Gra z komputerem");
            int mode = new Scanner(System.in).nextInt();
            return mode == 2;
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

        private static boolean isBoardFull(char[][] board) {
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


