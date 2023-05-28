
import java.time.LocalDateTime;
import java.util.Scanner ;





public class Test 
{
	static User[] users ;
	static Store[] stores ;
	static Customer[] customers ;
	static Owner[] owners ;
	static Admin[] admins ;
	
	public static int userLogin(String Username, String Password)
	{
		boolean usernameFound = false ;
		boolean passwordFound = false ;
		int userIndex = 0 ;
		if(users == null)
		{
			System.out.println("There are no users") ;
			return -1 ;
		}
		else
		{
			if(users.length == 1)
			{
				if(users[0].username.equals(Username))
				{
					usernameFound = true ;
					if(users[0].password.equals(Password))
					{
						passwordFound = true ;
						userIndex = 0 ;
						
						return 0 ;
					}
					else
					{
						System.out.println("Wrong Password") ;
						
					}
				}
				
			}
			else
			{
				for(int i = 0 ; i < users.length ; i++)
				{
					if(users[i].username.equals(Username) )
					{
						usernameFound = true ;
						if(users[i].password.equals(Password))
						{
							passwordFound = true ;
							userIndex = i ;
							return i ;
						}
						else
						{
							System.out.println("Wrong Password") ;
							
						}
					}
				}
				
				
			}
			
			if(passwordFound)
			{
				return userIndex ;
			}
			else
			{
				return -1 ;
			}
			
		}
	}
	
	public static void addCustomer(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth)
	{
		if(customers == null)
		{
			customers = new Customer[1] ;
			customers[0] = new Customer(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
		}
		else
		{
			Customer[] a = new Customer[customers.length + 1] ;
			for(int i = 0 ; i < customers.length ; i++)
			{
				a[i] = customers[i] ;
			}
			a[a.length-1] = new Customer(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
			customers = a ;
		}
	}
	
	public static void addAdmin(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth)
	{
		if(admins == null)
		{
			admins = new Admin[1] ;
			admins[0] = new Admin(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
		}
		else
		{
			Admin[] a = new Admin[admins.length + 1] ;
			for(int i = 0 ; i < admins.length ; i++)
			{
				a[i] = admins[i] ;
			}
			a[a.length-1] = new Admin(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
			admins = a ;
		}
	}
	
	public static void addOwner(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth)
	{
		if(owners == null)
		{
			owners = new Owner[1] ;
			owners[0] = new Owner(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
		}
		else
		{
			Owner[] a = new Owner[customers.length + 1] ;
			for(int i = 0 ; i < owners.length ; i++)
			{
				a[i] = owners[i] ;
			}
			a[a.length-1] = new Owner(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
			owners = a ;
		}
	}
	
	public static boolean createUser(String Name, String Surname, String Username, String Password, String Email, int PhoneNumber, LocalDateTime DateOfBirth, char C)
	{
		if(users == null)
		{
			users = new User[1] ;
			
			if(C == 'A')
			{
				users[0] = new Admin(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
				addAdmin(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
			}
			else if(C == 'C')
			{
				users[0] = new Customer(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
				addCustomer(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
				
			}
			else if(C == 'O')
			{
				users[0] = new Owner(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
				addOwner(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
			}
			else
			{
				users[0] = new User(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
			}
			
			
			return true ;
		}
		else
		{
			boolean breakpoint = false ;
			User[] User = new User[users.length + 1] ;
			
			for(int i = 0 ; i < users.length ; i++)
			{
				User[i] = users[i] ;
				if(users[i].username.equals(Username) )
				{
					System.out.println("Username already exists") ;
					breakpoint = true ;
					break ;
				}
			}
			
			if(breakpoint)
			{
				return false ;
			}
			else
			{
				User[User.length-1] = new User(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
				
				
				if(C == 'A')
				{
					User[User.length-1] = new Admin(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
					addAdmin(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
				}
				else if(C == 'C')
				{
					User[User.length-1] = new Customer(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
					addCustomer(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
				}
				else if(C == 'O')
				{
					
					User[User.length-1] = new Owner(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
					addOwner(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
				}
				else
				{
					User[User.length-1] = new User(Name, Surname, Username, Password, Email, PhoneNumber, DateOfBirth) ;
				}
				
				users = User ;
				return true ;
			}
			
		}
	}
	
	public static int getLoginForm()
	{
		String Username = "", Password="" ;
		
		Scanner input = new Scanner(System.in) ;
		
		System.out.println() ;
		System.out.println("User Login Form") ;
		System.out.printf("Username : ") ;
		Username = input.nextLine() ;
		System.out.printf("Password : ") ;
		Password = input.nextLine() ;
		
		
		int myUser = userLogin(Username, Password);
		
		if(myUser < 0)
		{
			System.out.println("User Does Not Exist") ;
		}
		else
		{
			System.out.printf("Logged in as user[%d]\n",myUser) ;
		}
		
		return myUser ;
	}
	
	public static boolean getRegistrationForm()
	{
		String Name, Surname, Username, Password, Email ;
		int PhoneNumber ;
		
		Scanner input = new Scanner(System.in) ;
		
		System.out.println() ;
		System.out.println("User Registration Form") ;
		System.out.printf("Username : ") ;
		Username = input.nextLine() ;
		System.out.printf("Password : ") ;
		Password = input.nextLine() ;
		System.out.printf("Name : ") ;
		Name = input.nextLine() ;
		System.out.printf("Surname : ") ;
		Surname = input.nextLine() ;
		System.out.printf("Email : ") ;
		Email = input.nextLine() ;
		System.out.printf("PhoneNumber : ") ;
		PhoneNumber = input.nextInt() ;
		System.out.println();
		
		
		if(createUser(Name, Surname, Username, Password, Email, PhoneNumber, LocalDateTime.now(),'U'))
		{
			System.out.println("User Created ");
			return true ;
		}
		else
		{
			return false ;
		}
	}
	
	public static void preLogForm()
	{
		System.out.println("Welcome to E-Catering") ;
		System.out.printf("\n\nIn order to continue you have to be logged in\nPress 1 : Log in\nPress 2 : Sign Up\n") ;
		
		Scanner input = new Scanner(System.in) ;
		int Choice  = input.nextInt() ;
		
		if(Choice == 1)
		{
			int thisUserIndex = getLoginForm() ;
			
			//LOOP TILL LOG IN
			while(thisUserIndex < 0)
			{
				thisUserIndex = getLoginForm() ;
			}
			
			if(users[thisUserIndex].getClass().toString().equals("class Admin"))
			{
				//Admin LOGGED
			}
			else if(users[thisUserIndex].getClass().toString().equals("class Owner"))
			{
				//Owner LOGGED
			}
			else if(users[thisUserIndex].getClass().toString().equals("class Customer"))
			{
				//Customer LOGGED
				int thisCustomerIndex = 0 ;
				
				for(int i = 0 ; i < customers.length ; i++)
				{
					if(users[thisUserIndex].username.equals(customers[i].username))
					{
						thisCustomerIndex = i ;
						break ;
					}
				}
				
				customers[thisCustomerIndex].getCustomerMenuMessage() ;
				
			}
			else
			{
				//User LOGGED
				
			}
			
		}
		else if(Choice == 2)
		{
			
			while(getRegistrationForm() == false ) 
			{
				//User not Created
			}
			
			
			
		}
		else
		{
			System.out.println("Wrong input") ;
		}
		
	}
	
	public static void addData()
	{
		//USER,WALLET,CARD CREATION
		createUser("Stelios", "Tzakas", "Username", "Password", "mail", 2102752783, LocalDateTime.now(),'C') ;
		users[0].wallet = new Wallet( 500, users[0] );
		customers[0].wallet = new Wallet( 500, users[0] );
		Card a = new Card(Card.CardType.credit, 25454, 999, "Name", LocalDateTime.now(), 200) ;
		users[0].addCard(a);
		customers[0].addCard(a);
		
		
		
		createUser("Antonis", "Mpatzo", "Uname", "Pword", "mail", 2102752783, LocalDateTime.now(),'O') ;
		users[1].wallet = new Wallet( 500, users[1] );
		
		//STORE CREATION
		stores = new Store[3] ;
		stores[0] = new Store("Katastima", "Mezonos 3", owners[0]) ;
		owners[0].addStore(stores[0]);
		
		stores[1] = new Store("Katastima", "Mezonos 7", owners[0]) ;
		owners[0].addStore(stores[0]);
		
		stores[2] = new Store("Katastima2", "Mezonos 67", owners[0]) ;
		owners[0].addStore(stores[0]);
		
		//Order CREATION
		Order A = new Order(LocalDateTime.now(), LocalDateTime.now(), 10, Order.TypeOfEvent.Baptism, true, Order.Status.Pending, stores[0]);
		customers[0].addOrder(A);
		Order B = new Order(LocalDateTime.now(), LocalDateTime.now(), 20, Order.TypeOfEvent.Wedding, false, Order.Status.Ongoing, stores[1]);
		customers[0].addOrder(B);
		Order C = new Order(LocalDateTime.now(), LocalDateTime.now(), 50, Order.TypeOfEvent.Wedding, true, Order.Status.Completed, stores[1]);
		customers[0].addOrder(C);
		
		//RATING FEEDBACK CREATION
		Rating S = new Rating(customers[0].order[0].store,customers[0],LocalDateTime.now(), 5);
		customers[0].addRating(customers[0].order[0].store, S);
		customers[0].order[0].store.addRating(S);
		FeedBack F = new FeedBack(customers[0].order[0].store,customers[0],LocalDateTime.now(),"Feed TEXT");
		customers[0].addFeedBack(customers[0].order[0].store, F);
		customers[0].order[0].store.addFeedBack(F);
	}
	
	public static void addManyData()
	{
		//USER CARD WALLET
		for(int i = 0 ; i < 100 ; i++)
		{
			char[] Type = {'C', 'A', 'O','U'} ;
			createUser("Stelios", "Tzakas", "Username"+ (char) i, "Password", "mail", i, LocalDateTime.now(),Type[i % 4]) ;
			users[i].wallet = new Wallet( i, users[i] );
			Card a = new Card(Card.CardType.credit, 25454, 999, "Name", LocalDateTime.now(), 1000 + i) ;
			users[i].addCard(a);
		}
	}
	
	public static void main(String[] args)
	{		
		
		addData() ;
		//addManyData() ;
		//preLogForm() ;
		
		customers[0].getCustomerMenuMessage() ;
		
		Scanner input = new Scanner(System.in) ;
		int option = input.nextInt() ;
		if(option == 1)
		{
			String searchParam ;
			System.out.printf("Search : ") ;
			input = new Scanner(System.in) ;
			searchParam = input.nextLine() ;
			
			if(stores == null)
			{
				System.out.println("There are no available Stores") ;
			}
			else
			{
				for(int i = 0 ; i < stores.length ; i++)
				{
					if(stores[i].name.equals(searchParam))
					{
						System.out.printf("Press %d : Send Order to %s\n" ,i+1,stores[i].name) ;
					}
				}
				
				input = new Scanner(System.in) ;
				int option1 = input.nextInt() ;
				if(option1 < stores.length && option1 > 0)
				{
					//ADD ORDER TO STORE[option1-1]
				}
				else
				{
					System.out.println("Wrong input") ;
				}
			}
			
			
		}
		else if(option == 2)
		{
			if(stores == null)
			{
				System.out.println("There are no available Stores") ;
			}
			else
			{
				for(int i = 0 ; i < stores.length ; i++)
				{
					System.out.printf("Press %d : Send Order to %s\n" ,i+1,stores[i].name) ;
				}
				
				input = new Scanner(System.in) ;
				int option1 = input.nextInt() ;
				if(option1 < stores.length && option1 > 0)
				{
					//ADD ORDER TO STORE[option1-1]
				}
				else
				{
					System.out.println("Wrong input") ;
				}
				
			}
			
		}
		else if(option == 3)
		{
			/*
			users[thisUserIndex].wallet.card.viewCard() ;
			users[thisUserIndex].wallet.message() ;
			input = new Scanner(System.in) ;
			int option1 = input.nextInt() ;
			if(option1 == 1)
			{
				users[thisUserIndex].wallet.deposit() ;
				customers[thisCustomerIndex].wallet.amount = users[thisUserIndex].wallet.amount ;
				customers[thisCustomerIndex].wallet.card.amount = users[thisUserIndex].wallet.card.amount ;
			}
			else if(option1 == 2)
			{
				users[thisUserIndex].wallet.withdraw() ;
				customers[thisCustomerIndex].wallet.amount = users[thisUserIndex].wallet.amount ;
				customers[thisCustomerIndex].wallet.card.amount = users[thisUserIndex].wallet.card.amount ;
			}
			else
			{
				System.out.println("Wrong input") ;
			}
			*/
		}
		else if(option == 4)
		{
			/*
			
			if(customers[thisCustomerIndex].order == null)
			{
				System.out.println("User hasnot made any Orders") ;
			}
			else
			{
				
				
				System.out.println(" 1 : Completed Orders") ;
				System.out.println(" 2 : Ongoing Orders") ;
				System.out.println(" 3 : Pending Orders") ;
				input = new Scanner(System.in) ;
				int option1 = input.nextInt() ;
				if(option1 >0 && option1 < 4)
				{
					int option2 ;
					switch(option1)
					{
					case 1:
						for(int i = 0 ; i < customers[thisCustomerIndex].order.length ; i++)
						{
							if(customers[thisCustomerIndex].order[i].status.equals(Order.Status.Completed))
							{
								System.out.printf("Order %d\n",i+1) ;
								customers[thisCustomerIndex].order[i].message();
								System.out.println() ;
							}
						}
						
						System.out.printf("Choose an order : ") ;
						input = new Scanner(System.in) ;
						option2 = input.nextInt() ;
						if(option2 <= 0 && option2-1> customers[thisCustomerIndex].order.length)
						{
							System.out.println("Wrong input") ;
						}
						else
						{
							customers[thisCustomerIndex].order[option2-1].message();
							System.out.printf("1 : Rate this Store\n") ;
							System.out.printf("2 : Send Feed Back to this Store\n") ;
							input = new Scanner(System.in) ;
							int option3 = input.nextInt() ;
							if(option3 == 1)
							{
								int rate ;
								System.out.println("Rating scale 1 to 5 (1 : Very Bad , 5 : Very Good) : ") ;
								input = new Scanner(System.in) ;
								rate = input.nextInt() ;
								Rating a = new Rating(customers[thisCustomerIndex].order[option2-1].store,customers[thisCustomerIndex],LocalDateTime.now(),rate);
								customers[thisCustomerIndex].addRating(customers[thisCustomerIndex].order[option2-1].store, a);
								customers[thisCustomerIndex].order[option2-1].store.addRating(a);
								
								
							}
							else if(option3 == 2)
							{
								String feedBackText ;
								System.out.println("The Text you would like to post on your feedback") ;
								input = new Scanner(System.in) ;
								feedBackText = input.nextLine() ;
								FeedBack a = new FeedBack(customers[thisCustomerIndex].order[option2-1].store,customers[thisCustomerIndex],LocalDateTime.now(),feedBackText);
								customers[thisCustomerIndex].addFeedBack(customers[thisCustomerIndex].order[option2-1].store, a);
								customers[thisCustomerIndex].order[option2-1].store.addFeedBack(a);
								
								
								
							}
							else
							{
								System.out.println("Wrong input") ;
							}
						}
						break;
					case 2:
						for(int i = 0 ; i < customers[thisCustomerIndex].order.length ; i++)
						{
							if(customers[thisCustomerIndex].order[i].status.equals(Order.Status.Ongoing))
							{
								System.out.printf("Order %d\n",i+1) ;
								customers[thisCustomerIndex].order[i].message();
								System.out.println() ;
							}
							
						}
						System.out.printf("Choose an order : ") ;
						input = new Scanner(System.in) ;
						option2 = input.nextInt() ;
						if(option2 <= 0 && option2-1> customers[thisCustomerIndex].order.length)
						{
							System.out.println("Wrong input") ;
						}
						else
						{
							customers[thisCustomerIndex].order[option2-1].message();
						}
						break;
					case 3:
						for(int i = 0 ; i < customers[thisCustomerIndex].order.length ; i++)
						{
							if(customers[thisCustomerIndex].order[i].status.equals(Order.Status.Pending))
							{
								System.out.printf("Order %d\n",i+1) ;
								customers[thisCustomerIndex].order[i].message();
								System.out.println() ;
							}
						}
						System.out.printf("Choose an order : ") ;
						input = new Scanner(System.in) ;
						option2 = input.nextInt() ;
						if(option2 <= 0 && option2-1> customers[thisCustomerIndex].order.length)
						{
							System.out.println("Wrong input") ;
						}
						else
						{
							customers[thisCustomerIndex].order[option2-1].message();
						}
						break;
					}
				}
				else
				{
					System.out.println("Wrong input") ;
				}
			}
			*/
		}
		else if(option == 5)
		{
			
		}
		else if(option == 6)
		{
			
		}
		else
		{
			
		}
	}
}
