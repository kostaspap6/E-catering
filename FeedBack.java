
import java.time.LocalDateTime;

public class FeedBack 
{
	Store store ;
	Customer customer ;
	LocalDateTime date ;
	String text ;
	
	public FeedBack(Store Store, Customer Customer, LocalDateTime Date, String Text)
	{
		this.store = Store ;
		this.customer = Customer ;
		this.date = Date ;
		this.text = Text ;
	}
}
