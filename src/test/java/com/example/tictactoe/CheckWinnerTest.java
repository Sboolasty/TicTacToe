package com.example.tictactoe;

import org.testng.annotations.Test;
import com.example.tictactoe.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckWinnerTest {


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
