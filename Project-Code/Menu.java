
public class Menu 
{
	enum Products {
		Starter1 ,  Starter2 ,  Starter3 ,  Starter4 ,  Starter5 ,  Starter6 ,  Starter7 ,  Starter8 ,  Starter9 ,  Starter10 ,
		 mainDish1 ,  mainDish2 ,  mainDish3 ,  mainDish4 ,  mainDish5 ,  mainDish6 ,  mainDish7 ,  mainDish8 ,  mainDish9 ,  mainDish10 ,
		 Dessert1 ,  Dessert2 ,  Dessert3 ,  Dessert4 ,  Dessert5 ,  Dessert6 ,  Dessert7 ,  Dessert8 ,  Dessert9 ,  Dessert10 ,
		 Drink1 ,  Drink2 ,  Drink3 ,  Drink4 ,  Drink5 ,  Drink6 ,  Drink7 ,  Drink8 ,  Drink9 ,  Drink10 
		} ; 
	Products[] products ;
	double[] pricePerProduct ;
	//price per product, price per product* pl = menu 
	
	Owner owner ;
	Store store ;
	
	public Menu(Products[] Products,double[] PricePerProduct, Owner Owner, Store Store)
	{
		addProducts(Products,PricePerProduct) ;
		setOwner(Owner) ;
		this.store = Store ;
	}
	
	public Menu(Products[] Products,double[] PricePerProduct, Store Store)
	{
		addProducts(Products,PricePerProduct) ;
		this.store = Store ;
	}
	
	public Menu(Store Store)
	{
		this.store = Store ;
	}
	
	public void setOwner(Owner Owner)
	{
		this.owner = Owner ;
	}
	
	public void addProducts(Products[] newProducts, double[] PricePerProduct)
	{
		if(products == null)
		{
			this.products = newProducts ;
			this.pricePerProduct = PricePerProduct ;
		}
		else
		{
			Products[] a = new Products[products.length + newProducts.length] ;
			double[] b = new double[pricePerProduct.length + PricePerProduct.length] ;
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i >= products.length)
				{
					a[i] = newProducts[i-products.length] ;
					b[i] = PricePerProduct[i-pricePerProduct.length] ;
				}
				else
				{
					a[i] = products[i] ;
					b[i] = pricePerProduct[i] ;
				}
			}
			
			this.products = a ;
			this.pricePerProduct = b ;
		}
	}
	
	public void addProducts(Products newProducts,double pricePerProd)
	{
		if(products == null)
		{
			this.products = new Products[1] ;
			this.products[0] = newProducts ;
			this.pricePerProduct = new double[1];
			this.pricePerProduct[0] = pricePerProd ;
		}
		else
		{
			Products[] a = new Products[products.length + 1] ;
			double[] b = new double[pricePerProduct.length + 1] ;
			for(int i = 0 ; i < a.length ; i++)
			{
				if(i == products.length)
				{
					a[i] = newProducts ;
					b[i] = pricePerProd ;
				}
				else
				{
					a[i] = products[i] ;
					b[i] = pricePerProduct[i] ;
				}
			}
			
			this.products = a ;
			this.pricePerProduct = b ;
		}
		
		
	}
	
	public void viewMenu()
	{
		if(products == null)
		{
			System.out.println("This menu is empty") ;
		}
		else
		{
			for(int i = 0 ; i < products.length ; i++)
			{
				System.out.printf("%s : %.2f\n" , products[i] , pricePerProduct[i]) ;
			}
		}
	}
}
