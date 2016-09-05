package main.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import main.WordMap;
import main.IntPair;

public class WordMapTest {
	
	ArrayList<Character> inputChars = new ArrayList<Character>();
	WordMap map;
	char[] chars = {
			'i', 'c', 'o', 'o',
			'n', 'r', 'o', 'u',
			't', 'r', 'o', 'g',
			'd', 'g', 'g', 'g'
	};
	int n = 4;
	
	@Before
	public void setUp() throws Exception {
		for (char c : chars) {
			inputChars.add(c);
		}
		map = new WordMap(inputChars, n);
	}

	@Test
	public void testCalculateCharIndex() {
		assertEquals(map.calculateCharIndex(2, 1), 6);
	}
	
	@Test
	public void testGetCharAt() {
		assertEquals(map.getCharAt(new IntPair(1, 2)), 'r');
		assertEquals(map.getCharAt(new IntPair(3, 1)), 'u');
	}
	
	@Test
	public void testNextCoordinate() {
		IntPair current = new IntPair(3, 0);
		IntPair next = map.getNextPosition(current, WordMap.Direction.UP_RIGHT);
		
		assertEquals(next.x, 0);
		assertEquals(next.y, 3);
	}
	
	@Test
	public void testFindWord() {
		IntPair end = map.findWord(new IntPair(2, 1), "door");
		assertEquals(end, null);
		end = map.findWord(new IntPair(0, 3), "door");
		System.out.println(end.x + ", " + end.y);
		assertEquals(end.equals(new IntPair(1, 2)), true);
	}
}
