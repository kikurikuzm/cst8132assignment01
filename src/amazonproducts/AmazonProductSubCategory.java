package amazonproducts;

public class AmazonProductSubCategory {
	private String subCategoryName;
	private AmazonProductCategory category;
	
	AmazonProductSubCategory(String givenName, AmazonProductCategory parentCategory) {
		this.subCategoryName = givenName;
	}
	
}
