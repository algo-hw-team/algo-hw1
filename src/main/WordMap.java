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
		int prevX = x;
		int prevY = y;
		
		switch (direction) {
		
		// 4방향. x,y 좌표가 범위를 나갈 경우 +n 또는 -n 해줌
		case UP:
			y -= 1;
			if (y < 0) y += n;
			break;
			
		case RIGHT:
			x += 1;
			if (x >= n) x -= n;
			break;
			
		case DOWN:
			y += 1;
			if (y >= n) y -= n;
			break;
			
		case LEFT:
			x -= 1;
			if (x < 0) x += n;
			break;
			
		// 범위 나갈 경우 x,y 좌표 swap
		case UP_RIGHT:
			y -= 1;
			x += 1;
			if (isOutOfRange(x, y)) {
				y = prevX;
				x = prevY;
			}
			break;
			
		case DOWN_LEFT:
			y += 1;
			x -= 1;
			if (isOutOfRange(x, y)) {
				y = prevX;
				x = prevY;
			}
			break;
			
		// 범위 나갈 경우 y = n-x, x = n-y
		case DOWN_RIGHT:
			y += 1;
			x += 1;
			if (isOutOfRange(x, y)) {
				y = n - prevX - 1;
				x = n - prevY - 1;
			}
			break;
			
		case UP_LEFT:
			y -= 1;
			x -= 1;
			if (isOutOfRange(x, y)) {
				y = n - prevX - 1;
				x = n - prevY - 1;
			}
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
	
	/**
	 * x 또는 y가 범위 밖에 나갔는지 계산
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isOutOfRange(int x, int y) {
		return (x < 0) || (x >= n) || (y < 0) || (y >= n);
	}
}