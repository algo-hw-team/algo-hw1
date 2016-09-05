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
		
		String InputPath = "C:\\hw1\\input.txt";
		String OutputPath = "C:\\hw1\\2013147550.txt";
		
		String OutputString = "";
		
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(InputPath));
			BufferedWriter bw = new BufferedWriter(new FileWriter(OutputPath));
			String sCurrentLine;
			ArrayList<String> inputlist = new ArrayList<>();
			while ((sCurrentLine = br.readLine()) != null) {
				inputlist.add(sCurrentLine);
			}
			
			//algorithm
			int N = Integer.parseInt(inputlist.get(0).split(" ")[0]);
			int M = Integer.parseInt(inputlist.get(0).split(" ")[1]);
			
			inputlist.remove(0);
			
			ArrayList<Character> CharMap = new ArrayList<Character>();
			for (int i = 0; i < N; i++) {
				String[] charset = inputlist.get(i).split(" ");
				for (int j = 0; j < )
			}
			
			builder.append(System.getProperty("line.separator"));
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