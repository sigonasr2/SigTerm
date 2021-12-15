package sig;

import java.io.IOException;
import java.io.Reader;

import org.jline.terminal.Terminal;
import org.jline.utils.NonBlockingReader;

public class SigTerm{
	static boolean RUNNING=true;
	static String storedVal="";
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
	public static String MAGENTA = CSICODE+"35m";
	public static String BLACK_BACKGROUND = CSICODE+"40m";
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
		Text(DIM+MAGENTA+BLACK_BACKGROUND+"A little purple!");
		CursorLineDown(2);
		CursorSetPosition(999999,1);
		CursorSetPosition(1,8);
		System.out.println(RESET);
	}
	
	public static void main(String[] args) {
		try {
			Terminal term = org.jline.terminal.TerminalBuilder.terminal();
			term.enterRawMode();
			NonBlockingReader r = term.reader();
			System.out.println(term.getWidth()+"x"+term.getHeight()+" size detected.");
			System.out.println("Done!");
			RunTest();
			while (RUNNING) {
				int ch = r.peek(250);
				if (ch!=NonBlockingReader.READ_EXPIRED) {
					Text(Integer.toString(r.read()));
				} else {
					Text("...");
				}
				CursorLineDown(1);
				ScrollUp(1);
			}
			r.shutdown();
			term.close();
		} catch (IOException e) {
			
		}
	}
}