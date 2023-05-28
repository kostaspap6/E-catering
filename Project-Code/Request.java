
public class Request 
{
	Admin admin ;
	User user ;
	String text ;
	enum Status{ Completed, Pending} ;
	Status status ;
	
	public Request(Admin Admin,	User User, String Text,	Status Status)
	{
		this.admin = Admin ;
		this.user = User ;
		this.text = Text ;
		this.status = Status ;
	}
	
	public Request(User User, String Text)
	{
		this.user = User ;
		this.text = Text ;
		this.status = Status.Pending ;
	}
	
	public void setAdmin(Admin Admin)
	{
		this.admin = Admin ;
	}
	
}
