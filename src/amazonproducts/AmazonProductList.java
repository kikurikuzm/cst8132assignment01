package amazonproducts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AmazonProductList {
	// define array length from CSV columns:
	private static final int NUMCOLS = Array.getLength(AmazonProductUtil.lineReader("Backpacks.csv", 0));
	// pull column titles from CSV:
	private final ArrayList<String> DEFAULT_TITLE = new ArrayList<>(Arrays.asList(AmazonProductUtil.lineReader("Backpacks.csv", 0)));
	private ArrayList<AmazonProduct> bestsellers;

	public void createList(String CSVFileName) throws AmazonProductException {
		int productQuantity = 0;

		File file = new File(CSVFileName);
		if (!file.isFile()) { // check da file real
			throw new AmazonProductException("File not found...");
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(CSVFileName))){
			while (reader.readLine() != null) productQuantity++; // count CSV lines
			
			for (int i = 0 ; i < productQuantity ; i++) {
				bestsellers.add(i, AmazonProduct.AmazonProduct(AmazonProductUtil.lineReader(CSVFileName, i))); // store products starting from 0 index
			}
		} catch (IOException e) {
			throw new AmazonProductException("Product list creation error!"); // disaster strikes
		}
	}

	public void saveList(String idk) {//argument??????

	}

	public void printList() {

	}

	public void edit(int id, AmazonProduct product) {

	}

	public AmazonProduct findProductByIndex(int id) {

		
	}

	public int getSize() {

	}

	public void add(AmazonProduct productToAdd) {

	}

	public void delete(int id) {

	}

	public void search(String productName) {//not sure if variable name is accurate

	}
}
