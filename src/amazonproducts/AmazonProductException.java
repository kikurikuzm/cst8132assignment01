package amazonproducts;

public class AmazonProductException extends Exception{
	public AmazonProductException(String errorMessage) {
		super(errorMessage);
	}
}