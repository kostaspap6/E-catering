
public class ShoppingCart 
{
	
	int numberOfPersons;
	Order.TypeOfEvent typeOfEvent ;
	boolean equipment ;
	double price ;
	Menu[] menu ;
	
	public ShoppingCart(int NumberOfPersons, Order.TypeOfEvent TypeOfEvent, boolean Equipment, float Price, Menu[] Menu)
	{
		this.numberOfPersons = NumberOfPersons ;
		this. typeOfEvent = TypeOfEvent ;
		this.equipment = Equipment ;
		this.price = Price ;
		this.menu = Menu ;
	}
	
	public ShoppingCart(int NumberOfPersons, Order.TypeOfEvent TypeOfEvent, boolean Equipment)
	{
		this.numberOfPersons = NumberOfPersons ;
		this. typeOfEvent = TypeOfEvent ;
		this.equipment = Equipment ;
		this.price = 0 ;
	}
	
	public void addMenu(Menu[] newMenu)
	{
		if(menu == null)
		{
			this.menu = newMenu ;
		}
		else
		{
			Menu[] a = new Menu[menu.length + newMenu.length] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i >= menu.length)
				{
					a[i] = newMenu[i-menu.length] ;
				}
				else
				{
					a[i] = menu[i] ;
				}
			}
			
			this.menu = a ;
		}
	}
	
	public void addMenu(Menu newMenu)
	{
		if(menu == null)
		{
			this.menu = new Menu[1] ;
			this.menu[0] = newMenu ;
		}
		else
		{
			Menu[] a = new Menu[menu.length + 1] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == menu.length)
				{
					a[i] = newMenu ;
				}
				else
				{
					a[i] = menu[i] ;
				}
			}
			
			this.menu = a ;
		}
		
		
	}
	
	public void calculatePrice()
	{
		if(menu == null)
		{
			this.price = 0 ;
		}
		else
		{
			double tot = 0 ;
			for(int i = 0 ; i < menu.length ; i++)
			{
				for(int j = 0 ; j < menu[i].pricePerProduct.length ; j++)
				{
					tot += menu[i].pricePerProduct[j] ;
				}
			}
			
			if(equipment)
			{
				this.price = numberOfPersons * ( tot /4 + 1000 );
			}
			else
			{
				this.price = numberOfPersons * ( tot /4 );
			}
		}
	}
	
}
