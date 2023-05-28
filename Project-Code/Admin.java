
import java.time.LocalDateTime;



public class Admin extends User
{
	Request[] request ;
	
	public Admin(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth, Wallet Wallet, State State, Card Card, Request[] Request)
	{
		super(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth, Wallet, State, Card) ;
		addRequest(Request) ;
	}
	
	public Admin(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth)
	{
		super(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
		this.state = User.State.Admin ;
	}
	
	
}
