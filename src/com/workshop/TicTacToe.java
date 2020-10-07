package com.workshop;
import java.util.*;

public class TicTacToe {
	public static final int PLAYER = 1;
	public static final int COMPUTER = 2;
	
	public static List<Integer> positionsPlayer = new ArrayList<>();
	public static List<Integer> positionsComputer = new ArrayList<>();
	
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
	
	public static boolean fillMark(char[] board, int a, char letter) {
		if(board[a] == ' ') {
			System.out.println("Position is free : ");
			board[a] = letter;
			return true;
		}
		else {
			System.out.println("Position is occupied");
			System.out.println("Enter the position again : ");
			return false;
		}
	}
	
	public static String toss() {
		int toss = ((int)Math.floor(Math.random() * 10) % 2) + 1;
		if(toss == PLAYER) {
			System.out.println("Player will make the move first.");
			return "Player";
		}
		else {
			System.out.println("Computer will make the move first.");
			return "Computer";
		}
	}
	
	public static String currentStatusPlayer() {
		if(positionsPlayer.containsAll(Arrays.asList(1,2,3)) || positionsPlayer.containsAll(Arrays.asList(1,4,7)) || positionsPlayer.containsAll(Arrays.asList(1,5,9)) || positionsPlayer.containsAll(Arrays.asList(2,5,8)) || positionsPlayer.containsAll(Arrays.asList(3,6,9)) || positionsPlayer.containsAll(Arrays.asList(4,5,6)) || positionsPlayer.containsAll(Arrays.asList(7,8,9)) || positionsPlayer.containsAll(Arrays.asList(7,5,3))) {
			return "Player wins";
		}
		else {
			return "Winner not yet decided";
		}
	}
	
	public static String currentStatusComputer() {
		if(positionsComputer.containsAll(Arrays.asList(1,2,3)) || positionsComputer.containsAll(Arrays.asList(1,4,7)) || positionsComputer.containsAll(Arrays.asList(1,5,9)) || positionsComputer.containsAll(Arrays.asList(2,5,8)) || positionsComputer.containsAll(Arrays.asList(3,6,9)) || positionsComputer.containsAll(Arrays.asList(4,5,6)) || positionsComputer.containsAll(Arrays.asList(7,8,9)) || positionsComputer.containsAll(Arrays.asList(7,5,3))) {
			return "Computer wins";
		}
		else {
			return "Winner not yet decided";
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game!!!");
		
		char[] board = createBoard();
		
		String toss = toss();
		if(toss == "Player") {
			int flag = 0;
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

			int i = 0, j = 0, f = 0;
			while(i < 5 && j < 5) {
				if(flag == 0) {
					if(f != 1) {
						System.out.println("Enter the position you want to fill with your mark (1-9) : ");
						if(i >= 3) {
							System.out.println(currentStatusPlayer());
							if(currentStatusPlayer() == "Player wins") {
								f = 1;
								break;
							}
						}
						int a = sc.nextInt();
						if(!fillMark(board, a, player)) {
							flag = 0;
						}
						else {
							positionsPlayer.add(a);
							showBoard(board);
							flag = 1;
							i++;
						}
					}
				}
				else {
					if(f != 1) {
						System.out.println("Computer's turn : ");
						if(j >= 3) {
							System.out.println(currentStatusComputer());
							if(currentStatusComputer() == "Computer wins") {
								f = 1;
								break;
							}
						}
						int a = ((int)Math.floor(Math.random() * 10) % 9) + 1;
						if(!fillMark(board, a, computer)) {
							flag = 1;
						}
						else {
							positionsComputer.add(a);
							showBoard(board);
							flag = 0;
							j++;
						}
					}
				}
			}
			if(f == 0) {
				System.out.println("It's a tie");
			}
		}
		else {
			int flag = 1;
			System.out.println("Computer is choosing it's mark");
			int mark = ((int)Math.floor(Math.random() * 10) % 2) + 1;
			char player = ' ';
			char computer = ' ';
			if(mark == 1) {
				computer = 'X';
				player = 'O';
			}
			else {
				player = 'X';
				computer = 'O';
			}
			System.out.println("Player Mark : " + player + "\nComputer Mark : " + computer);
			
			int i = 0, j = 0, f = 0;
			while(i < 5 && j < 5) {
				if(flag == 1) {
					if(f != 1) {
						System.out.println("Computer's turn : ");
						if(j >= 3) {
							System.out.println(currentStatusComputer());
							if(currentStatusComputer() == "Computer wins") {
								f = 1;
								break;
							}
						}
						int a = ((int)Math.floor(Math.random() * 10) % 9) + 1;
						if(!fillMark(board, a, computer)) {
							flag = 1;
						}
						else {
							positionsComputer.add(a);
							showBoard(board);
							flag = 0;
							j++;
						}
					}
				}
				else{
					if(f != 1) {
						System.out.println("Enter the position you want to fill with your mark (1-9) : ");
						if(i >= 3) {
							System.out.println(currentStatusPlayer());
							if(currentStatusPlayer() == "Player wins") {
								f = 1;
								break;
							}
						}
						int a = sc.nextInt();
						if(!fillMark(board, a, player)) {
							flag = 0;
						}
						else {
							positionsPlayer.add(a);
							showBoard(board);
							flag = 1;
							i++;
						}
					}
				}
			}
			if(f == 0) {
				System.out.println("It's a tie");
			}
		}
	}
}