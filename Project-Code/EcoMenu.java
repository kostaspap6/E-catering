


public class EcoMenu extends Menu
{
	int numberOfPersons ;
	Order.TypeOfEvent typeOfEvent ;
	float price ;
	
	public EcoMenu(Products[] Products, Owner Owner, Store Store, float Price)
	{
		super(Products, Price, Owner, Store) ;
		this.price = Price ;
	}
}
