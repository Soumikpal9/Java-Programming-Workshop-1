package com.workshop;
import java.util.*;

public class TicTacToe {
	public static final int PLAYER = 1;
	public static final int COMPUTER = 2;
	
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
		for(int i = 1; i < board.length; i+=3) {
			for(int j = i; j < i+3; j++) {
				System.out.print("|   ");
				System.out.print(board[j]);
				System.out.print("   |");
			}
			System.out.println();
			System.out.println("___________________________");
			System.out.println();
		} 
	}
	
	public static void fillMark(char[] board, int a, char letter) {
		if(board[a] == ' ') {
			System.out.println("Position is free : ");
			board[a] = letter;
		}
		else {
			System.out.println("Position is occupied");
		}
	}
	
	public static void toss() {
		int toss = ((int)Math.floor(Math.random() * 10) % 2) + 1;
		if(toss == PLAYER) {
			System.out.println("Player will make the move first.");
		}
		else {
			System.out.println("Computer will make the move first.");
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
		toss();
		System.out.println("Enter the position you want to fill with your mark (1-9) : ");
		int a = sc.nextInt();
		fillMark(board, a, player);
		showBoard(board);
	}
}