package amazonproducts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AmazonProductUtil {
	public static float convertStringToFloat(String desiredString){
		return Float.parseFloat(desiredString);
	}

	public static String[] lineReader(String fileName, int lineIndex) {
		try {
			FileReader fileReader = new FileReader(fileName);

			boolean betweenCommas = false;
			int lineCharacterIndex = 0;
			int currentLineIndex = 0;
			int currentColumn = 0;
			String currentString = "";
			String[] currentCSVArray = new String[10];

			while (currentLineIndex <= lineIndex) {
				try {
					Character currentCharacter = (char)fileReader.read();
					if(currentCharacter.equals('\n')) {
						currentLineIndex ++;
						currentColumn = 0;
					} else if(currentLineIndex == lineIndex && currentCharacter.equals('"')) { //check for a first double quote
						currentCharacter = (char)fileReader.read();
						while (!currentCharacter.equals('"')) {
							currentString += currentCharacter;
							currentCharacter = (char)fileReader.read();
						}
					} else if(currentLineIndex == lineIndex && currentCharacter.equals(',')) { //Only doing column stuff on the right line
						currentCSVArray[currentColumn] = currentString;
						currentColumn ++;
						currentString = "";
					} else {
						currentString += currentCharacter;
					}
//					System.out.print(currentCharacter);
				}
				catch (IOException e){
					System.out.println("IOException");
					System.out.println(e);
				}

			}

			return currentCSVArray; //Return the collection of columns for the corresponding line
		}
		catch (FileNotFoundException e){
			System.out.println("File not found.");
			System.out.println(e);
		}

		return new String[1]; //Returning small array when function fails

	}

}
