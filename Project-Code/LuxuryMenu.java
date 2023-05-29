

public class LuxuryMenu extends Menu
{
	int numberOfPersons ;
	Order.TypeOfEvent typeOfEvent ;
	float price ;
	
	public LuxuryMenu(Products[] Products, Owner Owner, Store Store, double[] Price)
	{
		super(Products, Price, Owner, Store) ;
	}
}
