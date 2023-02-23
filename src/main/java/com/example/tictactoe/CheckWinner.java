package com.example.tictactoe;
import com.example.tictactoe.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckWinner {

    public static boolean checkWinner(char[][] board, char activePlayer) {
        return checkFirstDiagonal(board, activePlayer) ||
                checkSecondDiagonal(board, activePlayer) ||
                checkWinInColumns(board, activePlayer) ||
                checkWinInRows(board, activePlayer);
    }

    public static boolean checkFirstDiagonal(char[][] board, char activePlayer) {
        int dim = board.length;
        for (int i = 0; i < dim; i++) {
            if (board[i][i] != activePlayer) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSecondDiagonal(char[][] board, char activePlayer) {
        int dim = board.length;
        for (int i = 0; i < dim; i++) {
            if (board[i][dim - i - 1] != activePlayer) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWinInRows(char[][] board, char activePlayer) {
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

    public static boolean checkWinInColumns(char[][] board, char activePlayer) {
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

    @Test
    public void testCheckFirstDiagonalWithNoWin() {
        char[][] board = {
                {'O', '-', '-'},
                {'-', 'X', '-'},
                {'-', '-', 'O'}
        };
        assertFalse(CheckWinner.checkFirstDiagonal(board, 'X'));
    }

    @Test
    public void testCheckFirstDiagonalWithWin() {
        char[][] board = {
                {'O', '-', '-'},
                {'-', 'O', '-'},
                {'-', '-', 'O'}
        };
        assertTrue(CheckWinner.checkFirstDiagonal(board, 'O'));
    }

    @Test
    public void testCheckSecondDiagonalWithNoWin() {
        char[][] board = {
                {'O', '-', '-'},
                {'-', 'X', '-'},
                {'-', '-', 'O'}
        };
        assertFalse(CheckWinner.checkSecondDiagonal(board, 'X'));
    }

    @Test
    public void testCheckSecondDiagonalWithWin() {
        char[][] board = {
                {'-', '-', 'O'},
                {'-', 'O', '-'},
                {'O', '-', '-'}
        };
        assertTrue(CheckWinner.checkSecondDiagonal(board, 'O'));
    }

    @Test
    public void testCheckWinInRowsWithNoWin() {
        char[][] board = {
                {'O', '-', '-'},
                {'-', 'X', '-'},
                {'-', '-', 'O'}
        };
        assertFalse(CheckWinner.checkWinInRows(board, 'X'));
    }

    @Test
    public void testCheckWinInRowsWithWin() {
        char[][] board = {
                {'-', 'X', 'X'},
                {'-', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        assertTrue(CheckWinner.checkWinInRows(board, 'O'));
    }

    @Test
    public void testCheckWinInColumnsWithNoWin() {
        char[][] board = {
                {'O', '-', '-'},
                {'-', 'X', '-'},
                {'-', '-', 'O'}
        };
        assertFalse(CheckWinner.checkWinInColumns(board, 'X'));
    }

    @Test
    public void testCheckWinInColumnsWithWin() {
        char[][] board = {
                {'-', 'X', 'O'},
                {'-', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        assertTrue(CheckWinner.checkWinInColumns(board, 'X'));
    }

    @Test
    public void testCheckWinnerWithNoWin() {
        char[][] board = {
                {'O', '-', '-'},
                {'-', 'X', '-'},
                {'-', '-', 'O'}
        };
        assertFalse(CheckWinner.checkWinner(board, 'X'));
    }

    @Test
    public void testCheckWinnerWithWin() {
        char[][] board = {
                {'-', 'X', 'O'},
                {'-', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        assertTrue(CheckWinner.checkWinner(board, 'X'));
    }
}