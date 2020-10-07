package com.workshop;

public class TicTacToe {
	
	public static char[] createBoard() {
		char[] board = new char[10];
		for(int i = 1; i < board.length; i++) {
			board[i] = '0';
		}
		return board;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game!!!");
		
		char[] board = createBoard();
	}
}
