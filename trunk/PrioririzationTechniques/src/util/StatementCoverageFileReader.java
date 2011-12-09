package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatementCoverageFileReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner inputFile;
		try {
			inputFile = new Scanner(new File("src/util/DOM4JNavigator_Cover.txt"));
//			inputFile = new Scanner(new File("src/util/CoberturaPorClasse.txt"));
			
			ArrayList<LineElement> lineElements = new ArrayList<LineElement>();
			while (inputFile.hasNext()) {
				String line = inputFile.nextLine();
				String[] elements = line.split(" ");
				LineElement le;
				if (elements.length > 5){
					le = new LineElement(elements[0], Integer.parseInt(elements[2]), Integer.parseInt(elements[4].substring(1)), Integer.parseInt(elements[6].substring(1)));
				}else le = new LineElement(elements[0], Integer.parseInt(elements[2]), Integer.parseInt(elements[4].substring(1)));
				lineElements.add(le);
//				System.out.println(le);	
			}
			
			Collections.sort(lineElements);
			write(lineElements);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void write(ArrayList<LineElement> lineElements) {
		int index = 0;
		for (int i = lineElements.size()-1; i >= 0 ; i--) {
			index++;
			System.out.println(index+".  "+lineElements.get(i));
		} 		
	}

}
