package home.jmlExercises;

import java.io.*;
import java.util.stream.Stream;

class SpacebarRemover {
	
	public static void main(String[] args) {
		String path = "D:\\University\\3 Year\\Ingegneria del Software\\Programming\\src\\home\\jmlExercises\\";
		String inputTextFileName = "in.txt";
		String outputTextFileName = "out1.txt"; //append mode ON
		
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path + inputTextFileName))) {
			
			reader.lines().map((s) -> {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) != ' ') {
						builder.append(s.charAt(i));
					}
				}
				return builder.toString();
			}).forEach((s) -> {
				try (FileWriter writer = new FileWriter(path + outputTextFileName, true)) {
					writer.write(s + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
