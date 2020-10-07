package com.workshop;

public class TicTacToe {
	
	public static void createBoard() {
		char[] board = new char[10];
		for(int i = 1; i < board.length; i++) {
			i = '0';
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game!!!");
	}
}
