package amazonproducts;

public class AmazonProductSubCategory {
	private AmazonProductCategory category;
	private String subCategoryName;
	
	AmazonProductSubCategory(String name, AmazonProductCategory parentCategory){
		subCategoryName = name;
		category = parentCategory;
	}
	
	public AmazonProductCategory getCategory() {
		return category;
	}
	
	public String getSubCategory() {
		return subCategoryName;
	}
	
	public void setCategory(AmazonProductCategory desiredCategory) {
		category = desiredCategory;
	}
	
	public void setSubCategory(String subCategoryName) {
		this.subCategoryName = subCategoryName; 
	}
}
