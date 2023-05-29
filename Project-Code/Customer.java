
import java.time.LocalDateTime;




public class Customer extends User 
{
	
	Request[] request ;
	Order[] order ;
	Rating[] rating ;
	FeedBack[] feedBack ;
	Payment[] payment ;
	
	public Customer(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth, Wallet Wallet, State State, Card Card, Request[] Request, Order[] Order)
	{
		super(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth, Wallet, State, Card) ;
		addRequest(Request) ;
		addOrder(Order) ;
	}
	
	public Customer(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth)
	{
		super(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
		this.state = User.State.Active ;
	}
	
	public void createOrder(LocalDateTime DatetimeOfOrder, LocalDateTime DateOfEvent, int NumberOfPersons, Order.TypeOfEvent TypeOfEvent,boolean Equipment, Order.Status Status, Store Store)
	{
		Order a = new Order(DatetimeOfOrder, DateOfEvent, NumberOfPersons, TypeOfEvent,Equipment, Status, Store) ;
		Payment b = new Payment(wallet,DatetimeOfOrder, a) ;
		a.addPayment(b) ;
		addOrder(a) ;
	}
	
	public void addPayment(Payment[] newPayment)
	{
		if(payment == null)
		{
			this.payment = newPayment ;
		}
		else
		{
			Payment[] a = new Payment[payment.length + newPayment.length] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i >= payment.length)
				{
					a[i] = newPayment[i-payment.length] ;
				}
				else
				{
					a[i] = payment[i] ;
				}
			}
			
			this.payment = a ;
		}
	}
	
	public void addnewPayment(Payment newPayment)
	{
		if(payment == null)
		{
			this.payment = new Payment[1] ;
			this.payment[0] = newPayment ;
		}
		else
		{
			Payment[] a = new Payment[payment.length + 1] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == payment.length)
				{
					a[i] = newPayment ;
				}
				else
				{
					a[i] = payment[i] ;
				}
			}
			
			this.payment = a ;
		}
	}

	public void addOrder(Order[] newOrder)
	{
		if(order == null)
		{
			this.order = newOrder ;
		}
		else
		{
			Order[] a = new Order[order.length + newOrder.length] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i >= order.length)
				{
					a[i] = newOrder[i-order.length] ;
				}
				else
				{
					a[i] = order[i] ;
				}
			}
			
			this.order = a ;
		}
	}
	
	public void addOrder(Order newOrder)
	{
		if(order == null)
		{
			this.order = new Order[1] ;
			this.order[0] = newOrder ;
		}
		else
		{
			Order[] a = new Order[order.length + 1] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == order.length)
				{
					a[i] = newOrder ;
				}
				else
				{
					a[i] = order[i] ;
				}
			}
			
			this.order = a ;
		}
	}
	
	
	public void addRating(Store Store, Rating Rating)
	{
		Store.addRating(Rating) ;
		
		if(rating == null)
		{
			this.rating = new Rating[1] ;
			this.rating[0] = Rating ;
		}
		else
		{
			Rating[] a = new Rating[rating.length + 1] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == rating.length)
				{
					a[i] = Rating ;
				}
				else
				{
					a[i] = rating[i] ;
				}
			}
			
			this.rating = a ;
		}
	}
	
	public void addFeedBack(Store Store, FeedBack FeedBack)
	{
		Store.addFeedBack(FeedBack) ;
		
		if(feedBack == null)
		{
			this.feedBack = new FeedBack[1] ;
			this.feedBack[0] = FeedBack ;
		}
		else
		{
			FeedBack[] a = new FeedBack[feedBack.length + 1] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == feedBack.length)
				{
					a[i] = FeedBack ;
				}
				else
				{
					a[i] = feedBack[i] ;
				}
			}
			
			this.feedBack = a ;
		}
	}
	
	public void getCustomerMenuMessage()
	{
		System.out.println();
		System.out.println("Press 1 : Search") ;
		System.out.println("Press 2 : Stores") ;
		System.out.println("Press 3 : Wallet") ;
		System.out.println("Press 4 : Your Orders") ;
		System.out.println("Press 5 : Customize Your Profile") ;
		System.out.println("Press 6 : Send Request") ;
		System.out.println("Press 7 : Log Out") ;
		System.out.println();
		
	}
	
	
	
}
