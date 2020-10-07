package com.workshop;
import java.util.*;

public class TicTacToe {
	static Scanner sc = new Scanner(System.in);
	public static char[] createBoard() {
		char[] board = new char[10];
		for(int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}
	
	public static char chooseLetter() {
		char letter = sc.next().charAt(0);
		return letter;
	}
	
	public static void showBoard(char[] board) {
		int row = (board.length - 1)/3;
		int col = (board.length - 1)/3;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print("|   ");
				System.out.print(board[j]);
				System.out.print("   |");
			}
			System.out.println("\n\n");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game!!!");
		
		char[] board = createBoard();
		System.out.println("Enter the letter you want to pick. Choose between 'X' or 'O' : ");
		char letter = chooseLetter();
		char player = ' ';
		char computer = ' ';
		if(letter == 'X') {
			player = 'X';
			computer = 'O'; 
		}
		else {
			computer = 'X';
			player = 'O';
		}
		System.out.println("Player Mark : " + player + "\nComputer Mark : " + computer);
		showBoard(board);
	}
}