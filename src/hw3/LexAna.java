package hw3;

import java.io.*;
import java.util.Scanner;

public class LexAna {
	/* Global declarations */
	/* Variables */
	static int charClass;
	static char[] lexeme = new char[100];
	static char nextChar;
	static int lexLen;
	static int token;
	static int nextToken;
	static File in_fp;
	static FileInputStream fis;

	/* Character classes */
	static final int LETTER = 0, DIGIT = 1, UNKNOWN = 99, EOF = -1;

	/* Token codes */
	static int INT_LIT = 10, IDENT = 11, ASSIGN_OP = 20, ADD_OP = 21, SUB_OP = 22, MULT_OP = 23, DIV_OP = 24,
			LEFT_PAREN = 25, RIGHT_PAREN = 26;

	// Main method
	public static void main(String[] args) throws FileNotFoundException {
		/* Open the input data file and process its contents */

		in_fp = new File("front.in");
		fis = new FileInputStream(in_fp);

		if (!(in_fp.exists())) {
			System.out.println("Error cannot open file");
		} else {
			getChar();
			do {
				lex();
			} while (nextToken != EOF);
		}

	}

	/*
	 * errno_t err; err = fopen_s(&in_fp, "C:/Users/puc/Desktop/front.in", "r"); if
	 * (err != 0) printf("ERROR - cannot open front.in \n"); else { getChar(); do {
	 * lex(); } while (nextToken != EOF) {
	 * 
	 * } }
	 */

	/* Function declarations */
	/* addChar - a function to add nextChar to lexeme */
	public static void addChar() {
		if (lexLen <= 98) {
			lexeme[lexLen++] = nextChar;
			lexeme[lexLen] = 0;
		} else
			System.out.println("Error - lexeme is too long \n");
	}

	/*
	 * getChar - a function to get the next character of input and determine its
	 * character class
	 */
	public static void getChar() {
		/*
		 * try { nextChar = (char) fis.read(); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */

		int character = 0; // has to be int for reader
		try {
			character = fis.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextChar = (char) character;
		if (character != -1) {
			if (Character.isAlphabetic(nextChar)) {
				charClass = LETTER;
			} else if (Character.isDigit(nextChar)) {
				charClass = DIGIT;
			} else {
				charClass = UNKNOWN;
			}
		} else {
			charClass = EOF;
		}
	}

	/*
	 * getNonBlank - a function to call getChar until it returns a non-whitespace
	 * character
	 */
	public static void getNonBlank() {
		while (Character.isWhitespace(nextChar))
			getChar();

	}

	/*
	 * lookup - a function to lookup operators and parentheses and return the token
	 */
	public static int lookup(char ch) {
		switch (ch) {
		case '(':
			addChar();
			nextToken = LEFT_PAREN;
			break;
		case ')':
			addChar();
			nextToken = RIGHT_PAREN;
			break;
		case '+':
			addChar();
			nextToken = ADD_OP;
			break;
		case '-':
			addChar();
			nextToken = SUB_OP;
			break;
		case '*':
			addChar();
			nextToken = MULT_OP;
			break;
		case '/':
			addChar();
			nextToken = DIV_OP;
			break;
		default:
			addChar();
			nextToken = EOF;
			break;
		}
		return nextToken;
	}

	/*
	 * lex - a simple lexical analyzer for arithmetic expressions
	 */
	public static int lex() {
		lexLen = 0;
		getNonBlank();
		switch (charClass) {

		/* Parse identifiers */
		case LETTER:
			addChar();
			getChar();
			while (charClass == LETTER || charClass == DIGIT) {
				addChar();
				getChar();
			}
			nextToken = IDENT;
			break;

		/* Parse integer literals */
		case DIGIT:
			addChar();
			getChar();
			while (charClass == DIGIT) {
				addChar();
				getChar();
			}
			nextToken = INT_LIT;
			break;
		/* Parentheses and operators */
		case UNKNOWN:
			lookup(nextChar);
			getChar();
			break;
		/* EOF */
		case EOF:
			nextToken = EOF;
			lexeme[0] = 'E';
			lexeme[1] = 'O';
			lexeme[2] = 'F';
			lexeme[3] = 0;
			break;

		} /* End of switch */

		String temp = "";
		for (int i = 0; i < lexeme.length; i++) {
			if (lexeme[i] == 0)
				break;
			temp = temp + lexeme[i];
		}

		System.out.printf("Next token is: %d, Next lexeme is %s%n", nextToken,temp);
		return nextToken;
	} /* End of function lex */

}
