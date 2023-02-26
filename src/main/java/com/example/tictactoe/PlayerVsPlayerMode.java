package com.example.tictactoe;
import com.example.tictactoe.*;
import java.util.Scanner;

public class PlayerVsPlayerMode {
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
}
