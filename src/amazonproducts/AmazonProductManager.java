package amazonproducts;

import java.util.Scanner;

public class AmazonProductManager {
	private AmazonProductList productList;
	
	public void createProductList(){
		System.out.println("create productlist");
	}
	
	public void saveProductList() {
		System.out.println("save productlist");
	}
	
	public void manageProductList() {
		System.out.println("manage productlist");
	}
	
	public void showProductList() {
		System.out.println("show productlist");
	}
	
	public AmazonProduct createProduct(int lineToRead) {
		String[] parsedDetails = AmazonProductUtil.lineReader("Backpacks.csv", lineToRead);
		AmazonProduct newProduct = new AmazonProduct(parsedDetails);
		return newProduct;	
	}
	
	public void editProduct() {
		System.out.println("edit product");
	}
	
	public void addProduct() {
		System.out.println("add product");
	}
	
	public void deleteProduct() {
		System.out.println("delete product");
	}
	
	public void search() {
		System.out.println("search for item in productlist");
	}
	
	public void showMenu() {
		System.out.print("""
				================================
				|| Menu - Best Sellers OOP/A1 ||
				================================
				1. Create Productlist
				2. Show Productlist
				3. Add Product
				4. Edit a Product
				5. Delete a Product
				6. Save Productlist
				7. Search in the list
				8. Exit
				Choose an option: """);
		Scanner input = new Scanner(System.in);
		
		switch(input.next()) {
			case "1":
				this.createProductList();
				break;
			case "2":
				this.saveProductList();
				break;
			case "3":
				this.addProduct();
				break;
			case "4":
				this.editProduct();
				break;
			case "5":
				this.deleteProduct();
				break;
			case "6":
				this.saveProductList();
				break;
			case "7":
				this.search();
				break;
			case "8":
				this.exit();
				break;
		}
	}
	
	public void exit() {
		System.out.println("""
				=========================
				|| [Application ended] ||
				=========================""");
	}
	
	public static void main(String[] args) {
		AmazonProductManager manager = new AmazonProductManager();
		boolean isRunning = true;
		while(isRunning) {
			manager.showMenu();			
		}
	}
}