package amazonproducts;

public class AmazonProduct {
	private int id;
	private String name;
	private String[] variableArray;
	private AmazonProductCategory category;
	private AmazonProductSubCategory subCategory;
	private String imageURL;
	private String link;
	private float rating;
	private int numberOfRatings;
	private float discountPrice;
	private float actualPrice;
	
	AmazonProduct(int id, String name, AmazonProductCategory category, AmazonProductSubCategory subCategory,
String imageURL, String link, float rating, int numberOfRatings, float discountPrice, float actualPrice){
		this.id = id;
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.imageURL = imageURL;
		this.link = link;
		this.rating = rating;
		this.numberOfRatings = numberOfRatings;
		this.discountPrice = discountPrice;
		this.actualPrice = actualPrice;
	}
	
	AmazonProduct(String[] incomingVariableArray){
		this.variableArray = incomingVariableArray;
		this.name = incomingVariableArray[0];
		this.category = new AmazonProductCategory(incomingVariableArray[1]);
		this.subCategory = new AmazonProductSubCategory(incomingVariableArray[2],this.category);
		this.imageURL = incomingVariableArray[3];
		this.link = incomingVariableArray[4];
		this.rating = Float.valueOf(incomingVariableArray[5]);
		this.numberOfRatings = Integer.valueOf(incomingVariableArray[6]);
		this.discountPrice = Float.valueOf(incomingVariableArray[7]);
		this.actualPrice = Float.valueOf(incomingVariableArray[8]);
	}
	
	public float getActualPrice() {
		return this.actualPrice;
	}
	
	public float getDiscountPrice() {
		return this.discountPrice;
	}
	
	public int getID() {	
		return this.id;
	}
	
	public String getLink() {
		return this.link;
	}
	
	public AmazonProductCategory getMainCategory() {
		return this.category;
	}
	
	public AmazonProductSubCategory getSubCategory() {
		return this.subCategory;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumberOfRatings() {
		return this.numberOfRatings;
	}
	public float getRatings() {
		return this.rating;
	}
	
	public String getImageURL() {
		return this.imageURL;
	}
	
	public String[] getTitle() {//i dont know why its supposed to be called title :(
		return this.variableArray;
	}
	
	public void setTitle(String[] title) {
		this.variableArray = title;
	}
	
	public String toString() {
		return ("Product ID: " + this.id + ", Name: "+this.name+", Title: "+this.variableArray+",Category: "+this.category+
				", Subcategory: "+this.subCategory+", \nImage URL: "+this.imageURL+", \nProduct Page: "+this.link+
				", \nRating: "+this.rating+", Number of ratings: "+this.numberOfRatings+", Discount Price: "+this.discountPrice+
				", Normal Price: "+this.actualPrice);
	}
}
