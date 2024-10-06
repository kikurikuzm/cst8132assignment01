package amazonproducts;

public class AmazonProductManager {
	private AmazonProductList productList;
	
	public void createProductList(){
		
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
		createProduct(31);
	}
}