package amazonproducts;

import java.io.*;

public class AmazonProductUtil {
	public float convertStringToFloat(String desiredString){
		return Float.parseFloat(desiredString);
	}
		
	public static String[] lineReader(String fileName, int lineIndex) {
		try {
			FileReader fileReader = new FileReader(fileName);
			
			int currentLineIndex = 0;
			int currentColumn = 0;
			String currentString = "";
			String[] currentCSVArray = new String[10];
			
			while (currentLineIndex <= lineIndex) 
				try {
					Character currentCharacter = (char)fileReader.read(); // read first character of line 0 to start off
					
					// while loop to make the fileReader pass the first line of "column title" CSV data
					while (currentCharacter != '\n') { // read until the end of the line
						currentCharacter = (char)fileReader.read(); // read the next character
						if (currentCharacter == '\n') { // if we just got to the end of the line...
							currentLineIndex ++; // ...increment the current line index and...
						}
					}
					currentCharacter = (char)fileReader.read(); // ...read the first character on the second line
					
					while(currentLineIndex != lineIndex) { // if I'm reading the wrong line rn
						while (currentCharacter != '\n') { // read until the end of the line
							currentCharacter = (char)fileReader.read();
							if (currentCharacter == '\n') { // if we just got to the end of the line...
								currentLineIndex ++; // ...increment the current line index and loop until I'm on the right line
							}
						}
					}
					
					// reading the correct line number
					while (currentLineIndex == lineIndex) { // I am finally reading the right line
						
						// case where commas must be extracted with data from inside double quotes
						do { // this do-while accommodates for one column potentially having several values inside quotes
							if (currentCharacter == '"') {
								currentCharacter = (char)fileReader.read(); // go to next character after the opening quote
								while (currentCharacter != '"') { // read all characters up until closing quote
									currentString += currentCharacter; // read non-quotes into string
									currentCharacter = (char)fileReader.read(); // reader will be on closing quote on last iteration
								}
								currentCharacter = (char)fileReader.read(); // read next character after closing quote
							}
						} while (currentCharacter != ',' && currentCharacter != '\n'); // reader will be on a delimiting comma on last iteration (except at EOL)
						
						// case where column data does not have quotes
						while (currentCharacter != ',' && currentCharacter != '\n') {
							currentString += currentCharacter;
							currentCharacter = (char)fileReader.read();  // reader will be on a delimiting comma on last iteration (except at EOL)
						}
						
						// at this point, currentCharacter must be either , or \n
						if (currentCharacter == ',') {
							// column incrementing process
							currentCSVArray[currentColumn] = currentString; // store data
							currentColumn++; // next column
							currentString = ""; // reset string
							currentCharacter = (char)fileReader.read();
						} else { // if this is executed, currentCharacter must be \n
							// line incrementing process
							currentColumn = 0; // reset column
							currentString = ""; // reset string
							currentLineIndex++; // after reading the correct line, this exits the reading loop
						}
					}
				} 
				catch (IOException e){
					System.out.println("IOException");
					System.out.println(e);
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