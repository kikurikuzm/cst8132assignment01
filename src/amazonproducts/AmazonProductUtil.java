package amazonproducts;

import java.io.*;

public class AmazonProductUtil {
	public float convertStringToFloat(String desiredString){
		return Float.parseFloat(desiredString);
	}
		
	public static String[] lineReader(String fileName, int lineIndex) {
		try {
			FileReader fileReader = new FileReader(fileName);
				
			boolean readingLine = true;
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
					}
					if(currentLineIndex == lineIndex && currentCharacter.equals(',')) { //Only doing column stuff on the right line
						currentCSVArray[currentColumn] = currentString;
						currentColumn ++;
						currentString = "";
					} else {
						currentString += currentCharacter;
					}
					System.out.print(currentCharacter);
					lineCharacterIndex ++;
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