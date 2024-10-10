package amazonproducts;

public class AmazonProduct {
	private int id;
	private String name;
	private String[] title;
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
	
	// constructor that accepts returned lineReader string array to create product
	AmazonProduct(String[] readerInfo){
		this.id = Integer.parseInt(readerInfo[0]);
		this.name = readerInfo[1];
		new AmazonProductCategory(readerInfo[2]);
		new AmazonProductSubCategory(readerInfo[3]);
		this.imageURL = readerInfo[4];
		this.link = readerInfo[5];
		this.rating = Float.parseFloat(readerInfo[6]);
		this.numberOfRatings = Integer.parseInt(readerInfo[7]);
		this.discountPrice = Float.parseFloat(readerInfo[8]);
		this.actualPrice = Float.parseFloat(readerInfo[9]);
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
	
	public String[] getTitle() {
		return this.title;
	}
	
	public void setTitle(String[] title) {
		this.title = title;
	}
	
	public String toString() {
		return ("Product ID:" + this.id + ", Name: "+this.name+", Title: "+this.title+",Category: "+this.category+
				", Subcategory: "+this.subCategory+", \nImage URL: "+this.imageURL+", \nProduct Page: "+this.link+
				", \nRating: "+this.rating+", Number of ratings: "+this.numberOfRatings+", Discount Price: "+this.discountPrice+
				", Normal Price: "+this.actualPrice);
	}
}
