package sig;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.utils.NonBlockingReader;

public class SigTerm{
	static boolean RUNNING=true;
	static String storedVal="";
	static boolean is27 = false;
	static boolean is91 = false;
	final static String ESC = "\u001b";
	final static String CSI = "[";
	final static String CSICODE = ESC+CSI;
	/**
		Moves the cursor *rows* cells in the given direction. If the cursor is already at the edge of the screen, this has no effect.
	**/
	public static void CursorUp(int rows) {
		System.out.print(CSICODE+rows+"A");
	}
	/**
		Moves the cursor *rows* cells in the given direction. If the cursor is already at the edge of the screen, this has no effect.
	**/
	public static void CursorDown(int rows) {
		System.out.print(CSICODE+rows+"B");
	}
	/**
		Moves the cursor *rows* cells in the given direction. If the cursor is already at the edge of the screen, this has no effect.
	**/
	public static void CursorRight(int cols) {
		System.out.print(CSICODE+cols+"C");
	}
	/**
		Moves the cursor *rows* cells in the given direction. If the cursor is already at the edge of the screen, this has no effect.
	**/
	public static void CursorLeft(int cols) {
		System.out.print(CSICODE+cols+"D");
	}
	/**
	Moves cursor to beginning of the line *lines* lines down. 
	**/
	public static void CursorLineDown(int lines) {
		System.out.print(CSICODE+lines+"E");
	}
	/**
	Moves cursor to beginning of the line *lines* lines up. 
	**/
	public static void CursorLineUp(int lines) {
		System.out.print(CSICODE+lines+"F");
	}
	/**
	Moves the cursor to column col.
	**/
	public static void CursorSetColumn(int col) {
		System.out.print(CSICODE+col+"G");
	}
	/**
		Moves the cursor to column *col*, row *row*. The values are 1-based.
	**/
	public static void CursorSetPosition(int col,int row) {
		System.out.print(CSICODE+row+";"+col+"H");
	}
	/**
		Clears part of the screen. If *mode* is 0, clear from cursor to end of screen. If *mode* is 1, clear from cursor to beginning of the screen. If *mode* is 2, clear entire screen. If *mode* is 3, clear entire screen and delete all lines saved in the scrollback buffer
	**/
	public static void EraseDisplay(int mode) {
		System.out.print(CSICODE+mode+"J");
	}
	/**
		Erases part of the line. If *mode* is 0, clear from cursor to the end of the line. If *mode* is 1, clear from cursor to beginning of the line. If *mode* is 2, clear entire line. Cursor position does not change.
	**/
	public static void EraseLine(int mode) {
		System.out.print(CSICODE+mode+"K");
	}
	/**
		Scroll whole page up by *lines* lines. New lines are added at the bottom.
	**/
	public static void ScrollUp(int lines) {
		System.out.print(CSICODE+lines+"S");
	}
	/**
		Scroll whole page down by *lines* lines. New lines are added at the top.
	**/
	public static void ScrollDown(int lines) {
		System.out.print(CSICODE+lines+"T");
	}
	/**
		Sets the color of all following text to (r,g,b). Colors can be between 0-255.
	**/
	public static void TextColor(int r,int g, int b) {
		System.out.print(CSICODE+"38;2;"+r+";"+g+";"+b+"m");
	}
	public static void BackgroundColor(int r,int g, int b) {
		System.out.print(CSICODE+"48;2;"+r+";"+g+";"+b+"m");
	}
	public static void UnderlineColor(int r,int g, int b) {
		System.out.print(CSICODE+"58;2;"+r+";"+g+";"+b+"m");
	}
	public static void TextColor(int id) {
		System.out.print(CSICODE+"38;5;"+id+"m");
	}
	public static void BackgroundColor(int id) {
		System.out.print(CSICODE+"48;5;"+id+"m");
	}
	public static void UnderlineColor(int id) {
		System.out.print(CSICODE+"58;5;"+id+"m");
	}
	public static String RESET = CSICODE+"0m";
	public static String BOLD = CSICODE+"1m";
	public static String DIM = CSICODE+"2m";
	public static String ITALIC = CSICODE+"3m";
	public static String UNDERLINE = CSICODE+"4m";
	public static String DOUBLEUNDERLINE = CSICODE+"21m";
	public static String BLINK = CSICODE+"5m";
	public static String FASTBLINK = CSICODE+"6m";
	public static String RESETFONT = CSICODE+"10m";
	public static String STRIKE = CSICODE+"9m";
	public static String RESETTEXTCOLOR = CSICODE+"39m";
	public static String RESETBACKGROUNDCOLOR = CSICODE+"49m";
	public static String RESETUNDERLINECOLOR = CSICODE+"59m";
	public static String BLACK = CSICODE+"30m";
	public static String RED = CSICODE+"31m";
	public static String GREEN = CSICODE+"32m";
	public static String YELLOW = CSICODE+"33m";
	public static String BLUE = CSICODE+"34m";
	public static String MAGENTA = CSICODE+"35m";
	public static String CYAN = CSICODE+"36m";
	public static String WHITE = CSICODE+"37m";
	public static String BRIGHT_BLACK = CSICODE+"90m";
	public static String BRIGHT_RED = CSICODE+"91m";
	public static String BRIGHT_GREEN = CSICODE+"92m";
	public static String BRIGHT_YELLOW = CSICODE+"93m";
	public static String BRIGHT_BLUE = CSICODE+"94m";
	public static String BRIGHT_MAGENTA = CSICODE+"95m";
	public static String BRIGHT_CYAN = CSICODE+"96m";
	public static String BRIGHT_WHITE = CSICODE+"97m";
	public static String BLACK_BACKGROUND = CSICODE+"40m";
	public static String RED_BACKGROUND = CSICODE+"41m";
	public static String GREEN_BACKGROUND = CSICODE+"42m";
	public static String YELLOW_BACKGROUND = CSICODE+"43m";
	public static String BLUE_BACKGROUND = CSICODE+"44m";
	public static String MAGENTA_BACKGROUND = CSICODE+"45m";
	public static String CYAN_BACKGROUND = CSICODE+"46m";
	public static String WHITE_BACKGROUND = CSICODE+"47m";
	public static String BRIGHT_BLACK_BACKGROUND = CSICODE+"100m";
	public static String BRIGHT_RED_BACKGROUND = CSICODE+"101m";
	public static String BRIGHT_GREEN_BACKGROUND = CSICODE+"102m";
	public static String BRIGHT_YELLOW_BACKGROUND = CSICODE+"103m";
	public static String BRIGHT_BLUE_BACKGROUND = CSICODE+"104m";
	public static String BRIGHT_MAGENTA_BACKGROUND = CSICODE+"105m";
	public static String BRIGHT_CYAN_BACKGROUND = CSICODE+"106m";
	public static String BRIGHT_WHITE_BACKGROUND = CSICODE+"107m";
	public static void Reset() {
		System.out.print(CSICODE+"0m");
	}
	public static void GetCursorPosition() {
		System.out.print(CSICODE+"6n");
	}
	/**
	Prints text to the console at the current cursor position.
	**/
	public static void Text(String text) {
		System.out.print(text);
	}
	
	static void RunTest() {
		EraseDisplay(2);
		CursorUp(3);
		Text("Test");		
		CursorDown(3);
		Text("Test2");
		CursorRight(5);
		Text("I am on the right!");
		CursorLeft(30);
		Text("Lefty");
		CursorLineDown(2);
		Text("Test");
		CursorLineUp(3);
		CursorSetColumn(6);
		Text("Above you!");
		CursorLineDown(3);
		CursorSetPosition(20,1);
		Text("I'm at the top!");
		CursorSetPosition(1,6);
		Text("This text was here");
		EraseLine(2);
		Text(BOLD+"But this text is here instead!");
		Text(RESET);
		CursorLineDown(1);
		Text(DOUBLEUNDERLINE+"And this will not be bold"+RESET);
		CursorLineDown(1);
		Text(BRIGHT_CYAN+BRIGHT_BLACK_BACKGROUND+"A little cyan!");
		CursorLineDown(2);
		CursorSetPosition(999999,1);
		CursorSetPosition(1,8);
		System.out.println(RESET);
	}

	static void HandleInput(NonBlockingReader r) {
		try {
			int ch = r.peek(250);
			if (ch!=NonBlockingReader.READ_EXPIRED) {
				if (!is27&&!is91&&ch==27) {
					is27=true;
				} else 
				if (is27&&!is91&&ch==91) {
					is91=true;
				} else
				if (is27&&is91) {
					//Possible special code.
					switch (ch) {
						case 65:{
							Text("UP");
						}break;
						case 66:{
							Text("DOWN");
						}break;
						case 67:{
							Text("RIGHT");
						}break;
						case 68:{
							Text("LEFT");
						}break;
					}
					is27=false;
					is91=false;
				} else
				{
					//Text(Integer.toString(ch));
					is27=is91=false;
				}
					r.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void Run(NonBlockingReader r) {
		while (RUNNING) {
			HandleInput(r);
			RefreshScreen();
		}
	}

	static void RefreshScreen() {
		CursorLineDown(1);
		ScrollUp(1);
	}
	
	public static void main(String[] args) {
		try {
			Terminal term = org.jline.terminal.TerminalBuilder.terminal();
			term.enterRawMode();
			NonBlockingReader r = term.reader();
			System.out.println(term.getWidth()+"x"+term.getHeight()+" size detected.");
			System.out.println("Done!");
			//RunTest();
			Run(r);
			r.shutdown();
			term.close();
		} catch (IOException e) {
			
		}
	}
}