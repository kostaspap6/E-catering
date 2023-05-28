
public class Menu 
{
	enum Products {A,B,C,D} ; //CHANGE
	Products[] products ;
	//price per product, price per product* pl = menu 
	float price ;
	Owner owner ;
	Store store ;
	
	public Menu(Products[] Products,float Price, Owner Owner, Store Store)
	{
		addProducts(Products) ;
		this.price = Price ;
		setOwner(Owner) ;
		this.store = Store ;
	}
	
	public Menu(Products[] Products,float Price, Store Store)
	{
		addProducts(Products) ;
		this.price = Price ;
		this.store = Store ;
	}
	
	public void setOwner(Owner Owner)
	{
		this.owner = Owner ;
	}
	
	public void addProducts(Products[] newProducts)
	{
		if(products == null)
		{
			this.products = newProducts ;
		}
		else
		{
			Products[] a = new Products[products.length + newProducts.length] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i >= products.length)
				{
					a[i] = newProducts[i-products.length] ;
				}
				else
				{
					a[i] = products[i] ;
				}
			}
			
			this.products = a ;
		}
	}
	
	public void addProducts(Products newProducts)
	{
		if(products == null)
		{
			this.products = new Products[1] ;
			this.products[0] = newProducts ;
		}
		else
		{
			Products[] a = new Products[products.length + 1] ;
			
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == products.length)
				{
					a[i] = newProducts ;
				}
				else
				{
					a[i] = products[i] ;
				}
			}
			
			this.products = a ;
		}
		
		
	}
}
