package amazonproducts;

import java.util.Scanner;
import java.io.File;

public class AmazonProductManager {
	private AmazonProductList productList = null;
	public boolean isRunning = true;
	
	public void createProductList() throws AmazonProductException {
		Scanner input = new Scanner(System.in);

		// TODO Auto-generated catch block
		System.out.println("Name of file to create Productlist: ");
		String fileName = input.nextLine();
		File file = new File(fileName);
		
		if (!file.isFile()) {
			throw new AmazonProductException("Invalid file name.");
		}
		
		productList = new AmazonProductList();
		productList.createList(fileName);
		
		System.out.println("Product list created successfully!");
		
	}
	
	public void saveProductList(){
		Scanner input = new Scanner(System.in);

		System.out.println("Name to save your ProductList: ");
		String fileName = input.nextLine();
		
		try {
			productList.saveList(fileName);
		} catch (AmazonProductException e) {
			e.printStackTrace();
		}
		
		System.out.println("Your ProductList was saved successfully!");
	}
	
	public void manageProductList() {//what is this supposed to do
		System.out.println("manage productlist");
	}
	
	public void showProductList() throws AmazonProductException {
		if(productList == null) {
			throw new AmazonProductException("No productList found!");
		}
		
		productList.printList();
	}
	
	public AmazonProduct createProduct(int lineToRead) {
		String[] parsedDetails = AmazonProductUtil.lineReader("sampleproducts.csv", lineToRead);
		AmazonProduct newProduct = new AmazonProduct(parsedDetails);
		return newProduct;	
	}
	
	public void editProduct() throws AmazonProductException {
		if(productList == null) {
			throw new AmazonProductException("No productList found!");
		}
		
		Scanner input = new Scanner(System.in);
		int desiredIndex = 0;
		AmazonProduct selectedProduct = null;
		String desiredField;
		String desiredEdit;
		String[] modifiedProduct;
		int fieldIndex = 0;
		
		String[] availableFields = {"id","name","category","subcategory","image url","product url","rating","number of ratings","sale price","actual price"};
		
		boolean settingIndex = true;
		boolean selectingField = true;
		
		while(settingIndex == true) {
			System.out.println("Please input the desired product's index: ");
			desiredIndex = Integer.valueOf(input.next());
			
			try {
				selectedProduct = productList.findProductByIndex(desiredIndex);
				System.out.println("You chose: " + selectedProduct + '\n');
				settingIndex = false;
			} catch (AmazonProductException e) {
				e.printStackTrace();
			}
		}
		
		while(selectingField == true) {
			System.out.println("Please choose a field to edit. You may choose from: [name, category, subcategory, image url, "
					+ "product url, rating, number of ratings, sale price, actual price]");
			System.out.println("Please input the field you would like to edit: ");
			
			desiredField = input.next();
			desiredField.strip();
			desiredField.toLowerCase();
			
			for(int i = 0; i < availableFields.length; i++) {
				if(desiredField.equals(availableFields[i])) {
					fieldIndex = i;
					System.out.println("You chose " + desiredField);
					selectingField = false;
				}
			}
			
			if(selectingField == true) {
				System.out.println("Valid field was not selected.");
			}
			
		}
		
		System.out.println("Please enter your edit: ");
		desiredEdit = input.next();
		
		modifiedProduct = selectedProduct.getTitle();
		modifiedProduct[fieldIndex] = desiredEdit;
		
		try {
			productList.edit(desiredIndex, new AmazonProduct(modifiedProduct));
			System.out.println("Product successfully modified.");
		} catch (AmazonProductException e) {
			e.printStackTrace();
		}
	}
	
	public void addProduct() throws AmazonProductException {
		if(productList == null) {
			throw new AmazonProductException("No productList found!");
		}
		
		Scanner input = new Scanner(System.in);
		String[] workingProduct = new String[10];
		String[] availableFields = {"id","name","category","subcategory","image url","product url","rating","number of ratings","sale price","actual price"};
		
		workingProduct[0] = String.valueOf(productList.getSize()+1);
		
		for(int i = 1; i < availableFields.length; i++) {
			System.out.println("Please input a new "+availableFields[i]+": ");
			workingProduct[i] = input.next();
		}
		try {
			productList.add(new AmazonProduct(workingProduct));
		} catch(Exception e){
			System.out.println("Product creation failed.");
		}
	}
	
	public void deleteProduct() throws AmazonProductException {
		if(productList == null) {
			throw new AmazonProductException("No productList found!");
		}
		
		Scanner input = new Scanner(System.in);
		int desiredIndex;
		
		System.out.println("Please provide an index to delete: ");
		
		desiredIndex = Integer.valueOf(input.next());
		
		try {
			productList.delete(desiredIndex);
			System.out.println("Successfully deleted product @ index " + desiredIndex);
		} catch (AmazonProductException e) {
			e.printStackTrace();
		}
	}
	
	public void search() {
		Scanner input = new Scanner(System.in);
		System.out.println("Search query for data in productlist:");
		String query = input.next();
		productList.search(query);
		
		input.close();
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
				try {
					this.createProductList();
				} catch (AmazonProductException e) {
					e.printStackTrace();
				}
				break;
			case "2":
				try {
					this.showProductList();
				} catch (AmazonProductException e) {
					e.printStackTrace();
				}
				break;
			case "3":
				try {
					this.addProduct();
				} catch (AmazonProductException e) {
					e.printStackTrace();
				}
				break;
			case "4":
				try {
					this.editProduct();
				} catch (AmazonProductException e) {
					e.printStackTrace();
				}
				break;
			case "5":
				try {
					this.deleteProduct();
				} catch (AmazonProductException e) {
					e.printStackTrace();
				}
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
			default:
				System.out.println("Invalid option.");
		}
	}
	
	public void exit() {
		System.out.println("""
				=========================
				|| [Application ended] ||
				=========================""");
		isRunning = false;
	}
	
	public static void main(String[] args) {
		AmazonProductManager manager = new AmazonProductManager();
		while(manager.isRunning) {
			manager.showMenu();
		}
	}
}