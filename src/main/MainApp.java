package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainApp {
	
	public static void main(String[] args) {
		
		String InputPath = "./input.txt";
		String OutputPath = "./2013147550.txt";
		
		String OutputString = "";
		
		StringBuilder builder = new StringBuilder();
		
		try {
			//모든 인풋 텍스트를 라인단위로 리스트에 저장한다.
			BufferedReader br = new BufferedReader(new FileReader(InputPath));
			BufferedWriter bw = new BufferedWriter(new FileWriter(OutputPath));
			String sCurrentLine;
			ArrayList<String> inputlist = new ArrayList<>();
			while ((sCurrentLine = br.readLine()) != null) {
				inputlist.add(sCurrentLine);
			}
			
			//algorithm
			//인풋 리스트의 첫 스트링에서  N, M을 파싱하고 첫 스트링을 삭제한다.
			int N = Integer.parseInt(inputlist.get(0).split(" ")[0]);
			int M = Integer.parseInt(inputlist.get(0).split(" ")[1]);
			inputlist.remove(0);
			
			//WordMap을 만들기위해 인풋 리스트의 N개의 스트링을 파싱하여 각 글자마다 Character List에 추가한다.
			ArrayList<Character> CharList = new ArrayList<Character>();
			for (int i = 0; i < N; i++) {
				char[] charArray = inputlist.get(i).replace(" ", "").toCharArray();
				for (int j = 0; j < charArray.length; j++) {
					CharList.add(charArray[j]);
				}
			}
			
			//WordMap 생성
			WordMap map = new WordMap(CharList, N);
			
			for (int i = N; i < inputlist.size(); i++) {
				String target = inputlist.get(i);
				char firstLetter = target.charAt(0);
				boolean findWord = false;
				for (int index = 0; index < N*N; index++) {
					int x = index % N;
					int y = index / N;
					if (firstLetter == map.getCharAt(new IntPair(x, y))){
						IntPair end = map.findWord(new IntPair(x, y), target);
						if (end != null) {
							builder.append(y + " " + x + " " + end.y + " " + end.x).append(System.getProperty("line.separator"));
							findWord = true;
							break;
						}
					}
				}
				if(!findWord) {
					builder.append(0).append(System.getProperty("line.separator"));
				}
			}
			
			OutputString = builder.toString();
			bw.write(OutputString);
			bw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}