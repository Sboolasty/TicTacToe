package com.example.tictactoe;
import java.util.Arrays;
import java.util.Scanner;
import com.example.tictactoe.*;

public class TicTacToe {
    public static void main(String[] args) {
        CheckWinner checkWinner = new CheckWinner();
        Mechanics printBoard = new Mechanics();
        PlayerVsComputerMode performMoveForOnePlayer = new PlayerVsComputerMode();
        PlayerVsPlayerMode performMoveForTwoPlayers = new PlayerVsPlayerMode();

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
            printBoard.printBoard(board);
            boolean moveWasCorrect = vsComputer ? performMoveForOnePlayer.performMoveForOnePlayer(board, activePlayer) : performMoveForTwoPlayers.performMoveForTwoPlayers(board, activePlayer);
            if (moveWasCorrect) {
                movesCounter++;
                won = checkWinner.checkWinner(board, activePlayer);
                draw = movesCounter == dim * dim && !won;
                activePlayer = activePlayer == 'X' ? 'O' : 'X';
            } else {
                System.out.println("Ruch niepoprawny, spróbuj ponownie");
            }
        }
        printBoard.printBoard(board);
        if (draw) {
            System.out.println("Remis!");
        } else {
            System.out.println("Koniec gry :)");
            System.out.println("Przegrywa gracz: " + activePlayer);
        }
    }


    private static boolean chooseGameMode() {
        System.out.println("Wybierz tryb gry:");
        System.out.println("1. Gra dwuosobowa");
        System.out.println("2. Gra z komputerem");
        int mode = new Scanner(System.in).nextInt();
        return mode == 2;
    }
}