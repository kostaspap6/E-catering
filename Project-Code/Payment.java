
import java.time.LocalDateTime;


public class Payment 
{
	Wallet wallet ;
	LocalDateTime paymentDate ;
	Order order ;
	double amount ;
	
	public Payment(Wallet Wallet , LocalDateTime PaymentDate, Order Order, double Amount )
	{
		this.wallet = Wallet ;
		this.paymentDate = PaymentDate ; 
		this.order = Order ;
		this.amount = Amount ; 
	}
	
	public Payment(Wallet Wallet , LocalDateTime PaymentDate, Order Order )
	{
		this.wallet = Wallet ;
		this.paymentDate = PaymentDate ; 
		this.order = Order ;
	}
}
