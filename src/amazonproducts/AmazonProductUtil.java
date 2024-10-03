package amazonproducts;

import java.io.*;

public class AmazonProductUtil {
	public void convertStringToFloat(String desiredString){
		//return float
	}
		
	public static void lineReader(String fileName, int index) {
		try {
			FileReader fileReader = new FileReader(fileName);
				
			boolean readingLine = true;
			int lineCharacterIndex = 0;
			int currentLineIndex = 0;
				
			while (currentLineIndex <= index) {
				try {
					Character currentCharacter = (char)fileReader.read();
					if(currentCharacter.equals('\n')) {
						currentLineIndex ++;
					}
					System.out.print(currentCharacter);
					lineCharacterIndex ++;
				}
				catch (IOException e){
					System.out.println("IOException -");
					System.out.println(e);
				}
				
			}
		}
		catch (FileNotFoundException e){
			System.out.println("File not found.");
			System.out.println(e);
		}
			  
	}
	
}
