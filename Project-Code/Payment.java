
import java.time.LocalDateTime;


public class Payment 
{
	Wallet wallet ;
	LocalDateTime paymentDate ;
	Order order ;
	Float amount ;
	
	public Payment(Wallet Wallet , LocalDateTime PaymentDate, Order Order, Float Amount )
	{
		this.wallet = Wallet ;
		this.paymentDate = PaymentDate ; 
		this.order = Order ;
		this.amount = Amount ; 
	}
}
