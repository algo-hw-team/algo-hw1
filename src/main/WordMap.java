package main;

import java.util.ArrayList;

public class WordMap {
	
	public static enum Direction {
		UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT, UP_LEFT;
	}
	
	/**
	 * Constructor
	 * @param inputChars
	 * @param _n
	 * @constructor
	 */
	public WordMap(ArrayList<Character> inputChars, int _n) {
		chars = new ArrayList<Character>(inputChars);
		n = _n;
	}
	
	/**
	 * 해당 위치에서 8 방향으로 word가 존재하는지 체크.
	 * @param start 시작 위치
	 * @param word 찾을 단어
	 * @return 존재할 경우 end position 반환. 없을 경우 null 반환
	 */
	public IntPair findWord(IntPair start, String word) {
		int length = word.length();
		IntPair current, end = null;
		boolean hasMatched;
		
		for (Direction direction : Direction.values()) {
			hasMatched = true;
			current = start;
			
			for (int i = 0; i < length; i++) {
				end = current;
				
				// 존재하지 않을 경우
				if (word.charAt(i) != getCharAt(current)) {
					hasMatched = false;
					break;
				}
				current = getNextPosition(current, direction);
			}
			
			if (hasMatched) {
				return end;
			}
		}
		
		return null;
	}
	
	/**
	 * 해당 방향으로 이동한 next position 반환
	 * @param current
	 * @param direction
	 * @return
	 */
	public IntPair getNextPosition(IntPair current, Direction direction) {
		int x = current.x;
		int y = current.y;
		
		switch (direction) {
		
		case UP:
			y -= 1;
			break;
			
		case UP_RIGHT:
			y -= 1;
			x += 1;
			break;
			
		case RIGHT:
			x += 1;
			break;
			
		case DOWN_RIGHT:
			y += 1;
			x += 1;
			break;
			
		case DOWN:
			y += 1;
			break;
			
		case DOWN_LEFT:
			y += 1;
			x -= 1;
			break;
			
		case LEFT:
			x -= 1;
			break;
			
		case UP_LEFT:
			y -= 1;
			x -= 1;
			break;
		
		}
		
		if (x >= n) x -= n;
		if (x < 0) x += n;
		if (y >= n) y -= n;
		if (y < 0) y += n;
		
		return new IntPair(x, y);
	}
	
	/**
	 * x, y 값으로 char index 계산
	 * @param x
	 * @param y
	 * @return
	 */
	public int calculateCharIndex(int x, int y) {
		return x + (y * n);
	}
	
	/**
	 * x, y 위치에 해당하는 char 값 반환
	 * @param position
	 * @return char
	 */
	public char getCharAt(IntPair position) {
		return chars.get(calculateCharIndex(position.x, position.y));
	}
	
	// private
	
	private ArrayList<Character> chars;
	private int n;
}