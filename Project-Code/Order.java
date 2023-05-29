
import java.time.LocalDateTime;

public class Order 
{
	
	LocalDateTime datetimeOfOrder, dateOfEvent ;
	int numberOfPersons ;
	double price ;
	enum TypeOfEvent {Wedding, Baptism, CorporateEvent, Other} ;
	TypeOfEvent typeOfEvent ;
	boolean equipment ;
	enum Status { Pending, Ongoing, Completed} ;
	Status status ;
	Store store ;
	Payment payment ;
	ShoppingCart shoppingCart ;
	
	public Order(LocalDateTime DatetimeOfOrder, LocalDateTime DateOfEvent, int NumberOfPersons, TypeOfEvent TypeOfEvent,boolean Equipment, Status Status, Store Store, Payment Payment, ShoppingCart ShoppingCart)
	{
		this.datetimeOfOrder = DatetimeOfOrder ;
		this.dateOfEvent = DateOfEvent ;
		this.numberOfPersons = NumberOfPersons ;
		this.typeOfEvent = TypeOfEvent ;
		this.equipment = Equipment ;
		this.status = Status ;
		this.store = Store ;
		addPayment(Payment) ;
		this.shoppingCart = ShoppingCart  ;
		
	}
	
	public Order(LocalDateTime DatetimeOfOrder, LocalDateTime DateOfEvent, int NumberOfPersons, TypeOfEvent TypeOfEvent,boolean Equipment, Status Status, Store Store)
	{
		this.datetimeOfOrder = DatetimeOfOrder ;
		this.dateOfEvent = DateOfEvent ;
		this.numberOfPersons = NumberOfPersons ;
		this.typeOfEvent = TypeOfEvent ;
		this.equipment = Equipment ;
		this.status = Status ;
		this.store = Store ;
		this.shoppingCart = new ShoppingCart(NumberOfPersons, TypeOfEvent, Equipment) ;
		
		
	}
	
	public void addPayment(Payment newPayment)
	{
		this.payment = newPayment ;
	}
	
	public void calculatePrice()
	{
		shoppingCart.calculatePrice();
		this.price = shoppingCart.price ;
	}
	
	public void message()
	{
		calculatePrice() ;
		System.out.printf("Number Of Persons : %d\n",numberOfPersons);
		System.out.printf("Type Of Event : %s\n", typeOfEvent);
		System.out.printf("Equipmet : %b\n",equipment);
		System.out.printf("Order Status : %s\n",status);
		System.out.printf("Store Name : %s, %s\n",store.name,store.address);
		
	}
}
