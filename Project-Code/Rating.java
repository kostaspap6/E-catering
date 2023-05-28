
import java.time.LocalDateTime;

public class Rating 
{
	Store store ;
	Customer customer ;
	LocalDateTime date ;
	int rating ;
	
	public Rating(Store Store, Customer Customer, LocalDateTime Date, int Rating)
	{
		this.store = Store ;
		this.customer = Customer ;
		this.date = Date ;
		this.rating = Rating ;
	}
	
	
	
	
}
