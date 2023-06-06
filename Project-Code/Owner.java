
import java.time.LocalDateTime;



public class Owner extends User
{
	Request[] request ;
	Store[] store ;
	
	public Owner(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth, Wallet Wallet, State State, Card Card, Request[] Request, Store[] Store)
	{
		super(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth, Wallet, State, Card) ;
		addRequest(Request) ;
		addStore(Store) ;
	}
	
	public Owner(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth)
	{
		super(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
		this.state = User.State.Active ;
	}

	public void addStore(Store[] newStore)
	{
		if(store == null)
		{
			this.store = newStore ;
		}
		else
		{
			Store[] a = new Store[store.length + newStore.length] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i >= store.length)
				{
					a[i] = newStore[i-store.length] ;
				}
				else
				{
					a[i] = store[i] ;
				}
			}
			
			this.store = a ;
		}
	}
	
	public void addStore(Store newStore)
	{
		if(store == null)
		{
			this.store = new Store[1] ;
			this.store[0] = newStore ;
		}
		else
		{
			Store[] a = new Store[store.length + 1] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == store.length)
				{
					a[i] = newStore ;
				}
				else
				{
					a[i] = store[i] ;
				}
			}
			
			this.store = a ;
		}
	}
	
	public void addMenu(Store Store, Menu Menu)
	{
		Store.addMenu(Menu);
	}
	
	public void createMenu(Store Store,Menu.Products[] Products,double[] Price)
	{
		Menu a  = new Menu(Products, Price, Store) ;
		a.setOwner(Store.owner);
		addMenu(Store,a) ;
		
	}
	
	public void getOwnerMenuMessage()
	{
		System.out.println();
		System.out.println("Press 1 : View Stores") ;
		System.out.println("Press 2 : Create Store Page") ;
		System.out.println("Press 3 : Log Out") ;
		System.out.println();
		
	}
}
