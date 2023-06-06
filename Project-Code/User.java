
import java.time.LocalDateTime;


public class User 
{
	
	String name, surname, username, password,email ;
	int phoneNumber ;
	LocalDateTime dateOfBirth ;
	Wallet wallet ;
	enum State { Admin,Suspended, Active } ;
	State state ;
	Card card ;
	Request[] request ;
	
	public User(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth, Wallet Wallet, State State, Card Card)
	{
		this.name = Name ;
		this.surname= Surname ;
		this.username = Username ; 
		this.password = Password ;
		this.email = Email ;
		this.phoneNumber = PhoneNumber ;
		this.dateOfBirth = DateOfBirth ;
		this.wallet = Wallet ;
		this.state = State ;
		addCard(Card) ;
	}
	
	public User(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth)
	{
		this.name = Name ;
		this.surname= Surname ;
		this.username = Username ; 
		this.password = Password ;
		this.email = Email ;
		this.phoneNumber = PhoneNumber ;
		this.dateOfBirth = DateOfBirth ;
		this.wallet = new Wallet() ;
		this.state = State.Active ;
	}
	
	public void addCard(Card Card)
	{
		this.card = Card ;
		this.wallet.addCard(Card);
	}
	
	public void addRequest(Request[] newRequest)
	{
		if(request == null)
		{
			this.request = newRequest ;
		}
		else
		{
			Request[] a = new Request[request.length + newRequest.length] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i >= request.length)
				{
					a[i] = newRequest[i-request.length] ;
				}
				else
				{
					a[i] = request[i] ;
				}
			}
			
			this.request = a ;
		}
	}
	
	public void addRequest(Request newRequest)
	{
		if(request == null)
		{
			this.request = new Request[1] ;
			this.request[0] = newRequest ;
		}
		else
		{
			Request[] a = new Request[request.length + 1] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == request.length)
				{
					a[i] = newRequest ;
				}
				else
				{
					a[i] = request[i] ;
				}
			}
			
			this.request = a ;
		}
	}
	
	public void getUserProf()
	{
		System.out.printf("Name : %s\nSurnmae: %s\nUsername : %s\nPassword : %s\nEmail : %s\nPhone Number : %s\nDate Of Birth : \n" ,name, surname, username, password,email, phoneNumber, dateOfBirth.toString())  ;
		
	}
	
	public void deleteRequest(Request Request)
	{
		if(request == null)
		{
			
		}
		else if(request.length == 1)
		{
			Request[] newReqs = {new Request()} ;
			this.request = newReqs ;
		}
		else
		{
			int reqIndex = -1 ;
			Request[] newReqs = new Request[request.length - 1] ;
			for(int i = 0 ; i < request.length ; i++)
			{
				if(request[i].equals(Request))
				{
					reqIndex = i ;
					break ;
				}
			}
			
			for(int i = 0 ; i < request.length ; i++)
			{
				if(i == reqIndex)
				{
					continue ;
				}
				else if(i > reqIndex)
				{
					newReqs[i - 1] = request[i] ;
				}
				else
				{
					newReqs[i] = request[i] ;
				}
			}
			this.request = newReqs ;
			
		}
		
	}
}
