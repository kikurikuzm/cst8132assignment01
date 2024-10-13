package amazonproducts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class AmazonProductManager {
	private AmazonProductList productList;
	private final ArrayList<String> DEFAULT_TITLE = new ArrayList<String>(Arrays.asList(AmazonProductUtil.lineReader("Backpacks.csv", 0)));
	Scanner scan = new Scanner(System.in);
	
	public void createProductList() throws AmazonProductException{
		
		System.out.println("Name of file to create Productlist: ");
		String fileName = scan.nextLine();
		File file = new File(fileName);
		
		if (!file.isFile()) {
			throw new AmazonProductException("Invalid file");
		}
		
		AmazonProductList productList = new AmazonProductList();
		productList.createList(fileName);
		
		System.out.println("Product list created successfully!");
	}
	
	public void saveProductList() {
		
	}
	
	public void showProductList() {
		
	}
	
	public void editProduct() {
		
	}
	
	public void addProduct() {
		
	}
	
	public void deleteProduct() {
		
	}
	
	public void search() {
		
	}
	
	public static void createProduct(int lineToRead) { //update variable name
		String[] stringArrayReturned = AmazonProductUtil.lineReader("Backpacks.csv", lineToRead);
		for(int i = 0; i < stringArrayReturned.length; i++) {
			System.out.println(stringArrayReturned[i]);
			
		}
	}
	
	public void showMenu() {
		
	}
	
	public void exit() {
		
	}
	
	public void manageProductList() {
		
	}
	
	public static void main(String[] args) {
	}
}