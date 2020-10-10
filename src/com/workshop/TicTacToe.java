package com.workshop;
import java.util.*;

public class TicTacToe {
	public static final int PLAYER = 1;
	public static final int COMPUTER = 2;
	public static char player = ' ';
	public static char computer = ' ';
	public static char[] board = new char[10];
	
	public static List<Integer> positionsPlayer = new ArrayList<>();
	public static List<Integer> positionsComputer = new ArrayList<>();
	
	static Scanner sc = new Scanner(System.in);
	public static char[] createBoard() {
		for(int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}
	
	public static char chooseLetter() {
		char letter = sc.next().charAt(0);
		return letter;
	}
	
	public static void showBoard() {
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
	
	public static boolean fillMark(int a) {
		if(board[a] == ' ') {
			System.out.println("Position is free : ");
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
	
	public static int getWinMove() {
		if(positionsPlayer.containsAll(Arrays.asList(1,2)) && fillMark(3))	return 3;
		if(positionsPlayer.containsAll(Arrays.asList(1,3)) && fillMark(2))	return 2;
		if(positionsPlayer.containsAll(Arrays.asList(2,3)) && fillMark(1))	return 1;
		
		if(positionsPlayer.containsAll(Arrays.asList(1,4)) && fillMark(7))	return 7;
		if(positionsPlayer.containsAll(Arrays.asList(1,7)) && fillMark(4))	return 4;
		if(positionsPlayer.containsAll(Arrays.asList(4,7)) && fillMark(1))	return 1;
		
		if(positionsPlayer.containsAll(Arrays.asList(1,5)) && fillMark(9))	return 9;
		if(positionsPlayer.containsAll(Arrays.asList(1,9)) && fillMark(5))	return 5;
		if(positionsPlayer.containsAll(Arrays.asList(5,9)) && fillMark(1))	return 1;

		if(positionsPlayer.containsAll(Arrays.asList(2,5)) && fillMark(8))	return 8;
		if(positionsPlayer.containsAll(Arrays.asList(2,8)) && fillMark(5))	return 5;
		if(positionsPlayer.containsAll(Arrays.asList(5,8)) && fillMark(2))	return 2;
		
		if(positionsPlayer.containsAll(Arrays.asList(3,6)) && fillMark(9))	return 9;
		if(positionsPlayer.containsAll(Arrays.asList(3,9)) && fillMark(6))	return 6;
		if(positionsPlayer.containsAll(Arrays.asList(6,9)) && fillMark(3))	return 3;
		
		if(positionsPlayer.containsAll(Arrays.asList(4,5)) && fillMark(6))	return 6;
		if(positionsPlayer.containsAll(Arrays.asList(4,6)) && fillMark(5))	return 5;
		if(positionsPlayer.containsAll(Arrays.asList(5,6)) && fillMark(4))	return 4;
		
		if(positionsPlayer.containsAll(Arrays.asList(7,8)) && fillMark(9))	return 9;
		if(positionsPlayer.containsAll(Arrays.asList(7,9)) && fillMark(8))	return 8;
		if(positionsPlayer.containsAll(Arrays.asList(8,9)) && fillMark(7))	return 7;

		if(positionsPlayer.containsAll(Arrays.asList(3,5)) && fillMark(7))	return 7;
		if(positionsPlayer.containsAll(Arrays.asList(3,7)) && fillMark(5))	return 5;
		if(positionsPlayer.containsAll(Arrays.asList(5,7)) && fillMark(3))	return 3;
		
		else return 0;
	}
	
	public static int cornerMove() {
		if(fillMark(1)) {
			return 1;
		}
		else if(fillMark(3)) {
			return 3;
		}
		else if(fillMark(7)) {
			return 7;
		}
		else if(fillMark(9)) {
			return 9;
		}
		else if(fillMark(5)) {
			return 5;
		}
		else {
			if(fillMark(2)) {
				return 2;
			}
			else if(fillMark(4)) {
				return 4;
			}
			else if(fillMark(6)) {
				return 6;
			}
			else if(fillMark(8)) {
				return 8;
			}
			else return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game!!!");
		
		board = createBoard();
		
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
						if(j >= 3) {
							System.out.println(currentStatusComputer());
							if(currentStatusComputer() == "Computer wins") {
								f = 1;
								break;
							}
						}
						int a = sc.nextInt();
						if(fillMark(a)) {
							board[a] = player;
							positionsPlayer.add(a);
							showBoard();
							flag = 1;
							i++;
						}
						else {
							flag = 0;
						}
					}
				}
				else {
					if(f != 1) {
						System.out.println("Computer's turn : ");
						if(i >= 3) {
							System.out.println(currentStatusPlayer());
							if(currentStatusPlayer() == "Player wins") {
								f = 1;
								break;
							}
						}
						if(j >= 1) {
							int a = getWinMove();
							if(a == 0) {
								a = cornerMove();
								if(a == 0) {
									a = ((int)Math.floor(Math.random() * 10) % 9) + 1;
								}
							}
							board[a] = computer;
							positionsComputer.add(a);
							showBoard();
							flag = 0;
							j++;
						}
						else{
							int a = ((int)Math.floor(Math.random() * 10) % 9) + 1;
							if(fillMark(a)) {
								board[a] = computer;
								positionsComputer.add(a);
								showBoard();
								flag = 0;
								j++;
							}
							else {
								flag = 1;
							}
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
						if(i >= 3) {
							System.out.println(currentStatusPlayer());
							if(currentStatusPlayer() == "Player wins") {
								f = 1;
								break;
							}
						}
						if(j > 1) {
							int a = getWinMove();
							if(a == 0) {
								a = cornerMove();
								if(a == 0) {
									a = ((int)Math.floor(Math.random() * 10) % 9) + 1;
								}
							}
							board[a] = computer;
							positionsComputer.add(a);
							showBoard();
							flag = 0;
							j++;
						}
						else{
							int a = ((int)Math.floor(Math.random() * 10) % 9) + 1;
							if(fillMark(a)) {
								board[a] = computer;
								positionsComputer.add(a);
								showBoard();
								flag = 0;
								j++;
							}
							else {
								flag = 1;
							}
						}
					}
				}
				else{
					if(f != 1) {
						System.out.println("Enter the position you want to fill with your mark (1-9) : ");
						if(j >= 3) {
							System.out.println(currentStatusComputer());
							if(currentStatusComputer() == "Computer wins") {
								f = 1;
								break;
							}
						}
						int a = sc.nextInt();
						if(fillMark(a)) {
							board[a] = player;
							positionsPlayer.add(a);
							showBoard();
							flag = 1;
							i++;
						}
						else {
							flag = 0;
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