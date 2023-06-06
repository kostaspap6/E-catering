
public class Store 
{
	String name, address ;
	Owner owner ;
	Menu[] menu ;
	Rating[] rating ;
	FeedBack[] feedBack ;
	Order[] order ;
	
	public Store(String Name, String Address, Owner Owner)
	{
		this.name = Name ;
		this.address = Address ;
		this.owner =  Owner;
	}
	
	public Store(String Name, String Address, Owner Owner, Menu[] Menu, Rating[] Rating, FeedBack[] FeedBack,	Order[] Order )
	{
		this.name = Name ;
		this.address = Address ;
		this.owner =  Owner;
		addMenu(Menu) ;
		addRating(Rating) ;
		addFeedBack(FeedBack) ;
		addOrder(Order) ;
	}
	
	public void addRating(Rating[] newRating)
	{
		
		if(rating == null)
		{
			this.rating = newRating ;
		}
		else
		{
			Rating[] a = new Rating[rating.length + newRating.length] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i >= rating.length)
				{
					a[i] = newRating[i-rating.length] ;
				}
				else
				{
					a[i] = rating[i] ;
				}
			}
			
			this.rating = a ;
		}
		
	}
	
	public void addRating(Rating newRating)
	{
		if(rating == null)
		{
			this.rating = new Rating[1] ;
			this.rating[0] = newRating ;
		}
		else
		{
			Rating[] a = new Rating[rating.length + 1] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == rating.length)
				{
					a[i] = newRating ;
				}
				else
				{
					a[i] = rating[i] ;
				}
			}
			
			this.rating = a ;
		}	
		
	}
	
	public void addFeedBack(FeedBack[] newFeedBack)
	{
		if(feedBack == null)
		{
			this.feedBack = newFeedBack ;
		}
		else
		{
			FeedBack[] a = new FeedBack[feedBack.length + newFeedBack.length] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i >= feedBack.length)
				{
					a[i] = newFeedBack[i-feedBack.length] ;
				}
				else
				{
					a[i] = feedBack[i] ;
				}
			}
			
			this.feedBack = a ;
		}
				
	}
	
	public void addFeedBack(FeedBack newFeedBack)
	{
		if(feedBack == null)
		{
			this.feedBack = new FeedBack[1] ;
			this.feedBack[0] = newFeedBack ;
		}
		else
		{
			FeedBack[] a = new FeedBack[feedBack.length + 1] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == feedBack.length)
				{
					a[i] = newFeedBack ;
				}
				else
				{
					a[i] = feedBack[i] ;
				}
			}
			
			this.feedBack = a ;
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
	
	public void storeMessage()
	{
		float avgRating,sum ;
		sum = 0 ;
		if(rating == null)
		{
			System.out.printf("Name : %s\nAddress : %s\nOwner Name : %s\n",name,address,owner.name) ;
		}
		else
		{
			for(int i = 0 ; i < rating.length ; i++)
			{
				sum = sum + rating[i].rating ;
			}
			avgRating = sum / rating.length ;
			System.out.printf("Name : %s\nAddress : %s\nOwner Name : %s\nAverage Rating : %.2f\n",name,address,owner.name,avgRating) ;
		}
		
	}
	
	public void deleteOrder(Order Order)
	{
		boolean point = false ;
		Order[] a = new Order[order.length-1] ;
		
		if(order == null)
		{
			
		}
		else if(order.length == 1)
		{
			order = null ;
		}
		else
		{
			for(int i = 0 ; i < order.length ; i++)
			{
				if(order[i].equals(Order))
				{
					point = true ;
				}
				else
				{
					if(point)
					{
						a[i-1] = order[i] ;
					}
					else
					{
						a[i] = order[i] ;
					}
				}
			}
			
			this.order = a ;
		}
		
	}
}
