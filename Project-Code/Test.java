
import java.time.LocalDateTime;
import java.util.Scanner ;
import java.util.Random;

public class Test 
{
	static User[] users ;
	static Store[] stores ;
	static Customer[] customers ;
	static Owner[] owners ;
	static Admin[] admins ;
	
	
	public static int customerPostLog(int thisUserIndex,int thisCustomerIndex)
	{
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
					
					{
						
						
						
						if(option1 < stores.length && option1 > 0)
						{
							boolean mistake = false ;
							stores[option1-1].storeMessage() ;
							System.out.println("1 : Create Order ") ;
							System.out.println("2 : View Pricing ") ;
							System.out.println("3 : View Store Ratings ") ;
							input = new Scanner(System.in) ;
							int option2 = input.nextInt() ;
							if(option2 == 1)
							{
								
								int NumberOfPersons ;
								input = new Scanner(System.in) ;
								System.out.printf("Number of Persons : ") ;
								NumberOfPersons = input.nextInt() ;
								if(NumberOfPersons <= 0)
								{
									mistake = true ;
								}
								else
								{
									
								}
								
								input = new Scanner(System.in) ;
								Order.TypeOfEvent TypeOfEvent = Order.TypeOfEvent.Baptism ;
								int TypeOfEVEnt ;
								System.out.printf("1 : Wedding\n2 : Baptism\n3 : Corporate Event\n4 : Other\n") ;
								TypeOfEVEnt = input.nextInt() ;
								switch (TypeOfEVEnt)
								{
								case 1:
									TypeOfEvent = Order.TypeOfEvent.Wedding ;
									break;
								case 2:
									TypeOfEvent = Order.TypeOfEvent.Baptism ;
									break;
								case 3:
									TypeOfEvent = Order.TypeOfEvent.CorporateEvent ;
									break;
								case 4:
									TypeOfEvent = Order.TypeOfEvent.Other ;
									break;
								default:
									mistake = true ;
								}
								
								input = new Scanner(System.in) ;
								System.out.printf("Would you require equipment ?\n1 : Yes, 0 : No") ;
								int equiPment = input.nextInt() ;
								boolean Equipment = false ;
								
								if(equiPment == 1)
								{
									Equipment = true ;
								}
								else if(equiPment == 0)
								{
									Equipment = false ;
								}
								else
								{
									mistake = true ;
								}
								
								if(mistake)
								{
									System.out.println("Wrong input") ;
								}
								else
								{
									customers[thisCustomerIndex].createOrder(LocalDateTime.now(), LocalDateTime.now() , NumberOfPersons, TypeOfEvent, Equipment,  Order.Status.Pending, stores[option1-1]) ;
									stores[option1-1].addOrder(customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length - 1]);
									
									System.out.println() ;
									if(stores[option1-1].menu == null)
									{
										System.out.println("There are no menu's at this moment") ;
									}
									else
									{
										input = new Scanner(System.in) ;
										System.out.println("1 : Get Recommended Menu") ;
										System.out.println("2 : Create Custom Menu") ;
										int OPTIONARA = input.nextInt() ;
										if(OPTIONARA == 2)
										{
											System.out.println("Enter product number to add to your custom menu");
											System.out.println("Enter -1 when your are finished");
											int counter = 0 ;
											for(int i = 0 ; i < stores[option1-1].menu.length ; i++)
											{
												if(stores[option1-1].menu[i].products == null )
												{
													
												}
												else
												{
													for(int j = 0 ; j < stores[option1-1].menu[i].products.length ; j++)
													{
														System.out.printf("%d : %s\n", counter,stores[option1-1].menu[i].products[j]) ;
														counter++ ;
													}
													
													Menu.Products[] Products = new Menu.Products[counter];
													double[] PricePerProduct = new double[counter];
													counter = 0 ;
													for(int k = 0 ; k < stores[option1-1].menu.length ; k++)
													{
														for(int j = 0 ; j < stores[option1-1].menu[k].products.length ; j++)
														{
															Products[counter] = stores[option1-1].menu[k].products[j] ;
															PricePerProduct[counter] = stores[option1-1].menu[k].pricePerProduct[j] ;
															counter++ ;
														}
													}
													int OPTIONARA1 ;
													Menu myMenu = new Menu(stores[option1-1]) ;
													boolean breakPoint = false ;
													
													do
													{
														OPTIONARA1 = 0 ;
														input = new Scanner(System.in) ;
														OPTIONARA1 = input.nextInt() ;
														
														if(OPTIONARA1 >= 0 && OPTIONARA1 < counter)
														{
															myMenu.addProducts(Products[OPTIONARA1], PricePerProduct[OPTIONARA1]);
														}
														else if(OPTIONARA1 == 5000)
														{
															break ;
														}
														else
														{
															System.out.println("Wrong input") ;
															breakPoint = true ;
															break ;
														}
														
													}while(OPTIONARA1 != 5000) ;
													
													if(breakPoint)
													{
														
													}
													else
													{
														customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.addMenu(myMenu);
														stores[option1-1].order[stores[option1-1].order.length-1].shoppingCart.addMenu(myMenu);
														
														customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.calculatePrice();
														System.out.println("Total Price for your order : " + customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price) ;
														System.out.printf("Press 1 in order to procceed with payment \n") ;
														customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].calculatePrice();
														stores[option1-1].order[stores[option1-1].order.length-1].shoppingCart.calculatePrice();
														input= new Scanner(System.in) ;
														int option4 = input.nextInt() ;
														if(option4 == 1)
														{
															if(customers[thisCustomerIndex].wallet.amount > customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price)
															{
																Payment a = new Payment(customers[thisCustomerIndex].wallet , LocalDateTime.now(), customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1], customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price ) ;
																customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].addPayment(a);
																System.out.println("Old wallet amount " + customers[thisCustomerIndex].wallet.amount);
																customers[thisCustomerIndex].addnewPayment(a);
																customers[thisCustomerIndex].wallet.amount = customers[thisCustomerIndex].wallet.amount - customers[thisCustomerIndex].payment[customers[thisCustomerIndex].payment.length - 1].amount ;
																
																System.out.println("New wallet amount " + customers[thisCustomerIndex].wallet.amount);
															}
															else
															{
																System.out.println("Insufficient founds") ;
															}
														}
														else
														{
															System.out.println("Wrong input") ;
														}
													}
												}
												
											}
											
											
										}
										else if(OPTIONARA == 1)
										{

											System.out.println("Choose a Menu ") ;
											for(int i = 0 ; i < stores[option1-1].menu.length ; i++)
											{
												System.out.printf("Menu : %d\n",i+1) ;
												stores[option1-1].menu[i].viewMenu() ;
											}
											input= new Scanner(System.in) ;
											int option3 = input.nextInt() ;
											if(option3 <= 0 && option3 > stores[option1-1].menu.length )
											{
												System.out.println("Wrong input") ;
											}
											else
											{
												customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.addMenu(stores[option1-1].menu[option3-1]);
												stores[option1-1].order[stores[option1-1].order.length-1].shoppingCart.addMenu(stores[option1-1].menu[option3-1]);

												customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.calculatePrice();
												System.out.println("Total Price for your order : " + customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price) ;
												System.out.printf("Press 1 in order to procceed with payment \n") ;
												customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].calculatePrice();
												stores[option1-1].order[stores[option1-1].order.length-1].shoppingCart.calculatePrice();
												input= new Scanner(System.in) ;
												int option4 = input.nextInt() ;
												if(option4 == 1)
												{
													if(customers[thisCustomerIndex].wallet.amount > customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price)
													{
														Payment a = new Payment(customers[thisCustomerIndex].wallet , LocalDateTime.now(), customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1], customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price ) ;
														customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].addPayment(a);
														System.out.println("Old wallet amount " + customers[thisCustomerIndex].wallet.amount);
														customers[thisCustomerIndex].addnewPayment(a);
														customers[thisCustomerIndex].wallet.amount = customers[thisCustomerIndex].wallet.amount - customers[thisCustomerIndex].payment[customers[thisCustomerIndex].payment.length - 1].amount ;
														
														System.out.println("New wallet amount " + customers[thisCustomerIndex].wallet.amount);
													}
													else
													{
														System.out.println("Insufficient founds") ;
													}
												}
												else
												{
													System.out.println("Wrong input") ;
												}
											}
										
										}
										else
										{
											System.out.println("Wrong input");
										}
									}
									
								}				
							}
							else if(option2 == 2)
							{
								if(stores[option1-1].menu == null)
								{
									System.out.println("There are no menu's at this moment") ;
								}
								else
								{
									
									for(int i = 0 ; i < stores[option1-1].menu.length ; i++)
									{
										System.out.printf("Menu : %d\n",i+1) ;
										stores[option1-1].menu[i].viewMenu() ;
									}
									
								}
							}
							else if(option2 == 3)
							{
								if(stores[option1-1].rating == null)
								{
									System.out.println("Store has not any ratings") ;
								}
								else
								{
									for(int i = 0 ; i < stores[option1-1].rating.length ; i++)
									{
										System.out.printf("Rating %d from %s : %d\n",i+1,stores[option1-1].rating[i].customer.name , stores[option1-1].rating[i].rating) ;
									}
								}
								
							}
							else
							{
								System.out.println("Wrong input ") ;
							}
						}
						else
						{
							System.out.println("Wrong input") ;
						}
						
					}
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
					System.out.printf("Press %d : %s\n" ,i+1,stores[i].name) ;
				}
				
				input = new Scanner(System.in) ;
				int option1 = input.nextInt() ;
				if(option1 <= stores.length && option1 > 0)
				{
					boolean mistake = false ;
					stores[option1-1].storeMessage() ;
					System.out.println("1 : Create Order ") ;
					System.out.println("2 : View Pricing ") ;
					System.out.println("3 : View Store Ratings ") ;
					input = new Scanner(System.in) ;
					int option2 = input.nextInt() ;
					if(option2 == 1)
					{
						
						int NumberOfPersons ;
						input = new Scanner(System.in) ;
						System.out.printf("Number of Persons : ") ;
						NumberOfPersons = input.nextInt() ;
						if(NumberOfPersons <= 0)
						{
							mistake = true ;
						}
						else
						{
							
						}
						
						input = new Scanner(System.in) ;
						Order.TypeOfEvent TypeOfEvent = Order.TypeOfEvent.Baptism ;
						int TypeOfEVEnt ;
						System.out.printf("1 : Wedding\n2 : Baptism\n3 : Corporate Event\n4 : Other\n") ;
						TypeOfEVEnt = input.nextInt() ;
						switch (TypeOfEVEnt)
						{
						case 1:
							TypeOfEvent = Order.TypeOfEvent.Wedding ;
							break;
						case 2:
							TypeOfEvent = Order.TypeOfEvent.Baptism ;
							break;
						case 3:
							TypeOfEvent = Order.TypeOfEvent.CorporateEvent ;
							break;
						case 4:
							TypeOfEvent = Order.TypeOfEvent.Other ;
							break;
						default:
							mistake = true ;
						}
						
						input = new Scanner(System.in) ;
						System.out.printf("Would you require equipment ?\n1 : Yes, 0 : No") ;
						int equiPment = input.nextInt() ;
						boolean Equipment = false ;
						
						if(equiPment == 1)
						{
							Equipment = true ;
						}
						else if(equiPment == 0)
						{
							Equipment = false ;
						}
						else
						{
							mistake = true ;
						}
						
						if(mistake)
						{
							System.out.println("Wrong input") ;
						}
						else
						{
							customers[thisCustomerIndex].createOrder(LocalDateTime.now(), LocalDateTime.now() , NumberOfPersons, TypeOfEvent, Equipment,  Order.Status.Pending, stores[option1-1]) ;
							stores[option1-1].addOrder(customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length - 1]);
							
							System.out.println() ;
							if(stores[option1-1].menu == null)
							{
								System.out.println("There are no menu's at this moment") ;
							}
							else
							{
								input = new Scanner(System.in) ;
								System.out.println("1 : Get Recommended Menu") ;
								System.out.println("2 : Create Custom Menu") ;
								int OPTIONARA = input.nextInt() ;
								if(OPTIONARA == 2)
								{
									System.out.println("Enter product number to add to your custom menu");
									System.out.println("Enter 5000 when your are finished");
									int counter = 0 ;
									
									for(int i = 0 ; i < stores[option1-1].menu.length ; i++)
									{
										for(int j = 0 ; j < stores[option1-1].menu[i].products.length ; j++)
										{
											System.out.printf("%d : %s\n", counter,stores[option1-1].menu[i].products[j]) ;
											counter++ ;
										}
									}
									
									Menu.Products[] Products = new Menu.Products[counter];
									double[] PricePerProduct = new double[counter];
									counter = 0 ;
									for(int k = 0 ; k < stores[option1-1].menu.length ; k++)
									{
										for(int j = 0 ; j < stores[option1-1].menu[k].products.length ; j++)
										{
											Products[counter] = stores[option1-1].menu[k].products[j] ;
											PricePerProduct[counter] = stores[option1-1].menu[k].pricePerProduct[j] ;
											counter++ ;
										}
									}
									int OPTIONARA1 ;
									Menu myMenu = new Menu(stores[option1-1]) ;
									boolean breakPoint = false ;
									
									do
									{
										OPTIONARA1 = 0 ;
										input = new Scanner(System.in) ;
										OPTIONARA1 = input.nextInt() ;
										
										if(OPTIONARA1 >= 0 && OPTIONARA1 < counter)
										{
											myMenu.addProducts(Products[OPTIONARA1], PricePerProduct[OPTIONARA1]);
										}
										else if(OPTIONARA1 == 5000)
										{
											break ;
										}
										else
										{
											System.out.println("Wrong input") ;
											breakPoint = true ;
											break ;
										}
										
									}while(OPTIONARA1 != 5000) ;
									
									if(breakPoint)
									{
										
									}
									else
									{
										customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.addMenu(myMenu);
										stores[option1-1].order[stores[option1-1].order.length-1].shoppingCart.addMenu(myMenu);
										
										customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.calculatePrice();
										System.out.println("Total Price for your order : " + customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price) ;
										System.out.printf("Press 1 in order to procceed with payment \n") ;
										customers[0].order[customers[0].order.length-1].calculatePrice();
										stores[option1-1].order[stores[option1-1].order.length-1].shoppingCart.calculatePrice();
										input= new Scanner(System.in) ;
										int option4 = input.nextInt() ;
										if(option4 == 1)
										{
											if(customers[thisCustomerIndex].wallet.amount > customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price)
											{
												Payment a = new Payment(customers[thisCustomerIndex].wallet , LocalDateTime.now(), customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1], customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price ) ;
												customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].addPayment(a);
												System.out.println("Old wallet amount " + customers[thisCustomerIndex].wallet.amount);
												customers[thisCustomerIndex].addnewPayment(a);
												customers[thisCustomerIndex].wallet.amount = customers[thisCustomerIndex].wallet.amount - customers[thisCustomerIndex].payment[customers[thisCustomerIndex].payment.length - 1].amount ;
												
												System.out.println("New wallet amount " + customers[thisCustomerIndex].wallet.amount);
											}
											else
											{
												System.out.println("Insufficient founds") ;
											}
										}
										else
										{
											System.out.println("Wrong input") ;
										}
									}
									
								}
								else if(OPTIONARA == 1)
								{

									System.out.println("Choose a Menu ") ;
									for(int i = 0 ; i < stores[option1-1].menu.length ; i++)
									{
										System.out.printf("Menu : %d\n",i+1) ;
										stores[option1-1].menu[i].viewMenu() ;
									}
									input= new Scanner(System.in) ;
									int option3 = input.nextInt() ;
									if(option3 <= 0 && option3 >= stores[option1-1].menu.length )
									{
										System.out.println("Wrong input") ;
									}
									else
									{
										customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.addMenu(stores[option1-1].menu[option3-1]);
										stores[option1-1].order[stores[option1-1].order.length-1].shoppingCart.addMenu(stores[option1-1].menu[option3-1]);

										customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.calculatePrice();
										System.out.println("Total Price for your order : " + customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price) ;
										System.out.printf("Press 1 in order to procceed with payment \n") ;
										customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].calculatePrice();
										stores[option1-1].order[stores[option1-1].order.length-1].shoppingCart.calculatePrice();
										input= new Scanner(System.in) ;
										int option4 = input.nextInt() ;
										if(option4 == 1)
										{
											if(customers[thisCustomerIndex].wallet.amount > customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price)
											{
												Payment a = new Payment(customers[thisCustomerIndex].wallet , LocalDateTime.now(), customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1], customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].shoppingCart.price ) ;
												customers[thisCustomerIndex].order[customers[thisCustomerIndex].order.length-1].addPayment(a);
												System.out.println("Old wallet amount " + customers[thisCustomerIndex].wallet.amount);
												customers[thisCustomerIndex].addnewPayment(a);
												customers[thisCustomerIndex].wallet.amount = customers[thisCustomerIndex].wallet.amount - customers[thisCustomerIndex].payment[customers[thisCustomerIndex].payment.length - 1].amount ;
												
												System.out.println("New wallet amount " + customers[thisCustomerIndex].wallet.amount);
											}
											else
											{
												System.out.println("Insufficient founds") ;
											}
										}
										else
										{
											System.out.println("Wrong input") ;
										}
									}
								
								}
								else
								{
									System.out.println("Wrong input");
								}
							}
							
						}				
					}
					else if(option2 == 2)
					{
						if(stores[option1-1].menu == null)
						{
							System.out.println("There are no menu's at this moment") ;
						}
						else
						{
							
							for(int i = 0 ; i < stores[option1-1].menu.length ; i++)
							{
								System.out.printf("Menu : %d\n",i+1) ;
								stores[option1-1].menu[i].viewMenu() ;
							}
							
						}
					}
					else if(option2 == 3)
					{
						if(stores[option1-1].rating == null)
						{
							System.out.println("Store has not any ratings") ;
						}
						else
						{
							for(int i = 0 ; i < stores[option1-1].rating.length ; i++)
							{
								System.out.printf("Rating %d from %s : %d\n",i+1,stores[option1-1].rating[i].customer.name , stores[option1-1].rating[i].rating) ;
							}
						}
						
					}
					else
					{
						System.out.println("Wrong input ") ;
					}
				}
				else
				{
					System.out.println("Wrong input") ;
				}
				
			}
			
		}
		else if(option == 3)
		{
			
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
			
		}
		else if(option == 4)
		{
			
			
			if(customers[thisCustomerIndex].order == null)
			{
				System.out.println("User has not made any Orders") ;
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
						boolean exist = true ;
						for(int i = 0 ; i < customers[thisCustomerIndex].order.length ; i++)
						{
							if(customers[thisCustomerIndex].order[i].status.equals(Order.Status.Completed))
							{
								System.out.printf("Order %d\n",i+1) ;
								System.out.printf("Number Of Persons : %d\n" ,customers[thisCustomerIndex].order[i].numberOfPersons);
								System.out.printf("Type Of Event : %s\n" ,customers[thisCustomerIndex].order[i].typeOfEvent) ;
								
								System.out.println() ;
								exist = false ;
							}
						}
						
						if(exist)
						{
							System.out.println("There are not any Completed Orders") ;
						}
						else
						{
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
						}
						break;
					case 2:
						boolean exist1 = true ;
						for(int i = 0 ; i < customers[thisCustomerIndex].order.length ; i++)
						{
							if(customers[thisCustomerIndex].order[i].status.equals(Order.Status.Ongoing))
							{
								System.out.printf("Order %d\n",i+1) ;
								System.out.printf("Number Of Persons : %d\n" ,customers[thisCustomerIndex].order[i].numberOfPersons);
								System.out.printf("Type Of Event : %s\n" ,customers[thisCustomerIndex].order[i].typeOfEvent) ;
								System.out.println() ;
								exist1 = false ;
							}
							
						}
						
						if(exist1)
						{
							System.out.println("There are not any Ongoing Orders") ;
						}
						else
						{
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
							
						}
						break;
					case 3:
						boolean exist2 = true ;
						for(int i = 0 ; i < customers[thisCustomerIndex].order.length ; i++)
						{
							if(customers[thisCustomerIndex].order[i].status.equals(Order.Status.Pending))
							{
								System.out.printf("Order %d\n",i+1) ;
								System.out.printf("Number Of Persons : %d\n" ,customers[thisCustomerIndex].order[i].numberOfPersons);
								System.out.printf("Type Of Event : %s\n" ,customers[thisCustomerIndex].order[i].typeOfEvent) ;
								System.out.println() ;
								exist2 = false ;
							}
						}
						
						if(exist2)
						{
							System.out.println("There are not any Pending Orders") ;
						}
						else
						{
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
						}
						
						break;
					}
				}
				else
				{
					System.out.println("Wrong input") ;
				}
			}
			
		}
		else if(option == 5)
		{
			
			int option1 ;
			System.out.printf("Change your Profile\n") ;
			System.out.printf("1 : Name\n") ;
			System.out.printf("2 : Surname\n") ;
			System.out.printf("3 : Username\n") ;
			System.out.printf("4 : Password\n") ;
			System.out.printf("5 : Email\n") ;
			System.out.printf("6 : PhoneNumber\n") ;
			input = new Scanner(System.in) ;
			option1 = input.nextInt() ;
			if(option1 >= 1 && option1 <=6 )
			{
				switch(option1)
				{
				case 1:
					System.out.printf("Insert your new Name : ") ;
					input = new Scanner(System.in) ;
					users[thisUserIndex].name = input.nextLine() ;
					customers[thisCustomerIndex].name = users[thisUserIndex].name ;
					break;
				case 2:
					System.out.printf("Insert your new Surname : ") ;
					input = new Scanner(System.in) ;
					users[thisUserIndex].surname = input.nextLine() ;
					customers[thisCustomerIndex].surname = users[thisUserIndex].surname ;
					break;
				case 3:
					System.out.printf("Insert your new Username : ") ;
					input = new Scanner(System.in) ;
					users[thisUserIndex].username = input.nextLine() ;
					customers[thisCustomerIndex].username = users[thisUserIndex].username ;
					break;
				case 4:
					System.out.printf("Insert your new Password : ") ;
					input = new Scanner(System.in) ;
					users[thisUserIndex].password = input.nextLine() ;
					customers[thisCustomerIndex].password = users[thisUserIndex].password ;
					break;
				case 5:
					System.out.printf("Insert your new Email : ") ;
					input = new Scanner(System.in) ;
					users[thisUserIndex].email = input.nextLine() ;
					customers[thisCustomerIndex].email = users[thisUserIndex].email ;
					break;
				case 6:
					System.out.printf("Insert your new PhoneNumber : ") ;
					input = new Scanner(System.in) ;
					users[thisUserIndex].phoneNumber = input.nextInt() ;
					customers[thisCustomerIndex].phoneNumber = users[thisUserIndex].phoneNumber ;
					break;
				}
			}
			else
			{
				System.out.println("Wrong input") ;
			}
			
		}
		else if(option == 6)
		{
			
			if(admins == null)
			{
				System.out.println("Request forging is unavailable at this moment") ;
			}
			else
			{
				String requestString ;
				System.out.println("Type the text to your request") ;
				input = new Scanner(System.in) ;
				requestString = input.nextLine() ;
				
				Request newRequest1 = new Request(users[thisUserIndex],requestString);				
				newRequest1.setAdmin(admins[0]);
				users[thisUserIndex].addRequest(newRequest1);
				
				if(customers[thisCustomerIndex].request == null)
				{
					customers[thisCustomerIndex].request = new Request[1] ;
					customers[thisCustomerIndex].request[0] = newRequest1 ;
				}
				else
				{
					Request[] a = new Request[customers[thisCustomerIndex].request.length + 1] ;
					for(int i = 0 ; i < customers[thisCustomerIndex].request.length ; i++)
					{
						a[i] =  customers[thisCustomerIndex].request[i] ;
					}
					a[a.length - 1] = newRequest1 ;
					customers[thisCustomerIndex].request = a ;
				}
				
				
				
				
				for(int i = 0 ; i < admins.length ; i++)
				{
					if(admins[i].request == null)
					{
						admins[i].request = new Request[1] ;
						admins[i].request[0] = newRequest1 ;
					}
					else
					{
						Request[] a = new Request[admins[i].request.length + 1] ;
						for(int j = 0 ; j < admins[0].request.length ; j++)
						{
							a[j] =  admins[i].request[j] ;
						}
						a[a.length - 1] = newRequest1 ;
						admins[i].request = a ;
					}
					
				}
				
			}
			
			
		}
		else
		{
			
			thisCustomerIndex = 0 ;
			thisUserIndex = -1 ;
			
		}
		
		if(thisUserIndex == -1)
		{
			return -1 ;
		}
		else
		{
			return thisUserIndex ;
		}
	}
	
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
			Owner[] a = new Owner[owners.length + 1] ;
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
		System.out.println("What type of user are you ?") ;
		System.out.println("1 : Customer") ;
		System.out.println("2 : Owner") ;
		input = new Scanner(System.in) ;
		int option = input.nextInt() ;
		
		if(option == 1)
		{	
			if(createUser(Name, Surname, Username, Password, Email, PhoneNumber, LocalDateTime.now(),'C'))
			{
				System.out.println("User Created ");
				return true ;
			}
			else
			{
				return false ;
			}
		}
		else if(option == 2)
		{	
			if(createUser(Name, Surname, Username, Password, Email, PhoneNumber, LocalDateTime.now(),'O'))
			{
				System.out.println("User Created ");
				return true ;
			}
			else
			{
				return false ;
			}
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
				int thisAdminIndex = 0 ;
				
				for(int i = 0 ; i < admins.length ; i++)
				{
					if(users[thisUserIndex].username.equals(admins[i].username))
					{
						thisAdminIndex = i ;
						break ;
					}
				}
				
				do
				{
					admins[thisAdminIndex].getAdminMenuMessage();
				}while(adminPostLog(thisUserIndex, thisAdminIndex) != -1) ;
			}
			else if(users[thisUserIndex].getClass().toString().equals("class Owner"))
			{
				//Owner LOGGED
				if(users[thisUserIndex].state.equals(User.State.Admin))
				{
					System.out.println("1 : Admin Account") ;
					System.out.println("2 : Customer Account") ;
					input = new Scanner(System.in) ;
					int option = input.nextInt() ;
					if(option == 1)
					{
						int thisAdminIndex = 0 ;
						
						for(int i = 0 ; i < admins.length ; i++)
						{
							if(users[thisUserIndex].username.equals(admins[i].username))
							{
								thisAdminIndex = i ;
								break ;
							}
						}
						
						do
						{
							admins[thisAdminIndex].getAdminMenuMessage();
						}while(adminPostLog(thisUserIndex, thisAdminIndex) != -1) ;
					}
					else if(option == 2)
					{
						
						int thisOwnerIndex = 0 ;
						
						for(int i = 0 ; i < owners.length ; i++)
						{
							if(users[thisUserIndex].username.equals(owners[i].username))
							{
								thisOwnerIndex = i ;
								break ;
							}
						}
						
						do
						{
							owners[thisOwnerIndex].getOwnerMenuMessage() ;
							
						}while(ownerPostLog(thisUserIndex, thisOwnerIndex) != -1) ;
					}
					else
					{
						
					}
				}
				else
				{
					int thisOwnerIndex = 0 ;
					
					for(int i = 0 ; i < owners.length ; i++)
					{
						if(users[thisUserIndex].username.equals(owners[i].username))
						{
							thisOwnerIndex = i ;
							break ;
						}
					}
					
					do
					{
						owners[thisOwnerIndex].getOwnerMenuMessage() ;
						
					}while(ownerPostLog(thisUserIndex, thisOwnerIndex) != -1) ;
				}
				
			}
			else if(users[thisUserIndex].getClass().toString().equals("class Customer"))
			{
				//Customer LOGGED
				if(users[thisUserIndex].state.equals(User.State.Admin))
				{
					System.out.println("1 : Admin Account") ;
					System.out.println("2 : Customer Account") ;
					input = new Scanner(System.in) ;
					int option = input.nextInt() ;
					if(option == 1)
					{
						int thisAdminIndex = 0 ;
						
						for(int i = 0 ; i < admins.length ; i++)
						{
							if(users[thisUserIndex].username.equals(admins[i].username))
							{
								thisAdminIndex = i ;
								break ;
							}
						}
						
						do
						{
							admins[thisAdminIndex].getAdminMenuMessage();
						}while(adminPostLog(thisUserIndex, thisAdminIndex) != -1) ;
					}
					else if(option == 2)
					{
						int thisCustomerIndex = 0 ;
						
						for(int i = 0 ; i < customers.length ; i++)
						{
							if(users[thisUserIndex].username.equals(customers[i].username))
							{
								thisCustomerIndex = i ;
								break ;
							}
						}
						
						
						do
						{
							customers[thisCustomerIndex].getCustomerMenuMessage() ;
							
						}while(customerPostLog(thisUserIndex,thisCustomerIndex) != -1) ;
					}
					else
					{
						
					}
				}
				else
				{
					int thisCustomerIndex = 0 ;
					
					for(int i = 0 ; i < customers.length ; i++)
					{
						if(users[thisUserIndex].username.equals(customers[i].username))
						{
							thisCustomerIndex = i ;
							break ;
						}
					}
					
					
					do
					{
						customers[thisCustomerIndex].getCustomerMenuMessage() ;
						
					}while(customerPostLog(thisUserIndex,thisCustomerIndex) != -1) ;
				}
				
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
		createUser("Stelios", "Tzakas", "Username", "Password", "mail", 2102752883, LocalDateTime.now(),'C') ;
		users[0].wallet = new Wallet( 500, users[0] );
		customers[0].wallet = new Wallet( 5000, users[0] );
		Card a = new Card(Card.CardType.credit, 25454, 999, "Name", LocalDateTime.now(), 20000) ;
		users[0].addCard(a);
		customers[0].addCard(a);
		
		createUser("Antonis", "Mpatzo", "Uname", "Pword", "mail", 2102703283, LocalDateTime.now(),'O') ;
		users[1].wallet = new Wallet( 500, users[1] );
		owners[0].wallet = new Wallet( 500, users[1] );
		Card b1 = new Card(Card.CardType.credit, 25454, 999, "Name", LocalDateTime.now(), 23600) ;
		users[1].addCard(b1);
		owners[0].addCard(b1);
		
		createUser("Antonis", "Mpatzo", "Admin", "Pass", "mail", 2105743783, LocalDateTime.now(),'A') ;
		
		createUser("Dimitrios", "Nikolaou", "UsernameNik", "Password", "mail", 2104561233, LocalDateTime.now(),'C') ;
		users[3].wallet = new Wallet( 1000, users[3] );
		customers[1].wallet = new Wallet( 1000, users[3] );
		Card a1 = new Card(Card.CardType.credit, 25454, 999, "Name", LocalDateTime.now(), 5000) ;
		users[3].addCard(a1);
		customers[1].addCard(a1);
		
		createUser("Giannis", "Kanoulas", "GiannisKan", "PKan", "mail", 2102785283, LocalDateTime.now(),'O') ;
		users[4].wallet = new Wallet( 2000, users[4] );
		owners[1].wallet = new Wallet( 2000, users[4] );
		Card b2 = new Card(Card.CardType.credit, 12345, 753, "Name", LocalDateTime.now(), 45000) ;
		users[4].addCard(b2);
		owners[1].addCard(b2);
		
		createUser("Nikos", "Xatzis", "Xatzis", "PeterPan", "mail", 2135795283, LocalDateTime.now(),'O') ;
		users[5].wallet = new Wallet( 4500, users[5] );
		owners[2].wallet = new Wallet( 4500, users[5] );
		Card b3 = new Card(Card.CardType.credit, 25114, 951, "Name", LocalDateTime.now(), 200) ;
		users[5].addCard(b3);
		owners[2].addCard(b3);
		
		createUser("Loukas", "Karas", "UsernameKar", "Password", "mail", 2132561233, LocalDateTime.now(),'C') ;
		users[6].wallet = new Wallet( 1000, users[6] );
		customers[2].wallet = new Wallet( 1000, users[6] );
		Card a2 = new Card(Card.CardType.credit, 25454, 999, "Name", LocalDateTime.now(), 5000) ;
		users[6].addCard(a2);
		customers[2].addCard(a2);
		
		//STORE CREATION
		stores = new Store[5] ;
		stores[0] = new Store("Katastima", "Mezonos 3", owners[0]) ;
		owners[0].addStore(stores[0]);
		
		stores[1] = new Store("Katastima", "Mezonos 7", owners[0]) ;
		owners[0].addStore(stores[1]);
		
		stores[2] = new Store("Katastima2", "Mezonos 67", owners[0]) ;
		owners[0].addStore(stores[2]);
		
		stores[3] = new Store("Melandre", "Korinthou 3", owners[1]) ;
		owners[1].addStore(stores[3]);
		
		stores[4] = new Store("ZZ ", "Foka 356", owners[2]) ;
		owners[2].addStore(stores[4]);
		
		//ORDER CREATION
		Order A = new Order(LocalDateTime.now(), LocalDateTime.now(), 10, Order.TypeOfEvent.Baptism, true, Order.Status.Pending, stores[0]);
		customers[0].addOrder(A);
		stores[0].addOrder(customers[0].order[0]);
		
		Order B = new Order(LocalDateTime.now(), LocalDateTime.now(), 20, Order.TypeOfEvent.Wedding, false, Order.Status.Ongoing, stores[1]);
		customers[0].addOrder(B);
		stores[1].addOrder(customers[0].order[1]);
		
		Order C = new Order(LocalDateTime.now(), LocalDateTime.now(), 50, Order.TypeOfEvent.Wedding, true, Order.Status.Completed, stores[1]);
		customers[0].addOrder(C);
		stores[1].addOrder(customers[0].order[2]);
		
		Order D = new Order(LocalDateTime.now(), LocalDateTime.now(), 50, Order.TypeOfEvent.Wedding, true, Order.Status.Pending, stores[1]);
		customers[0].addOrder(D);
		stores[1].addOrder(customers[0].order[3]);
		
		Order D2 = new Order(LocalDateTime.now(), LocalDateTime.now(), 33, Order.TypeOfEvent.CorporateEvent, true, Order.Status.Pending, stores[3]);
		customers[1].addOrder(D2);
		stores[3].addOrder(customers[1].order[0]);
		
		Order D3 = new Order(LocalDateTime.now(), LocalDateTime.now(), 10, Order.TypeOfEvent.Baptism, false, Order.Status.Completed, stores[4]);
		customers[2].addOrder(D3);
		stores[4].addOrder(customers[2].order[0]);
		
		//PRODUCTS CREATION
		Menu.Products[] Prod = {Menu.Products.Starter1 , Menu.Products.Starter2 , Menu.Products.Starter3 , Menu.Products.Starter4 ,
		Menu.Products.Starter5 ,  Menu.Products.Starter6 ,  Menu.Products.Starter7 ,  Menu.Products.Starter8 ,  Menu.Products.Starter9 ,  Menu.Products.Starter10 ,
		Menu.Products.mainDish1 ,  Menu.Products.mainDish2 ,  Menu.Products.mainDish3 ,  Menu.Products.mainDish4 ,  Menu.Products.mainDish5 ,  Menu.Products.mainDish6 ,  Menu.Products.mainDish7 ,  Menu.Products.mainDish8 ,  Menu.Products.mainDish9 ,  Menu.Products.mainDish10 ,
		 Menu.Products.Dessert1 ,  Menu.Products.Dessert2 ,  Menu.Products.Dessert3 ,  Menu.Products.Dessert4 ,  Menu.Products.Dessert5 ,  Menu.Products.Dessert6 ,  Menu.Products.Dessert7 ,  Menu.Products.Dessert8 ,  Menu.Products.Dessert9 ,  Menu.Products.Dessert10 ,
		 Menu.Products.Drink1 ,  Menu.Products.Drink2 ,  Menu.Products.Drink3 ,  Menu.Products.Drink4 ,  Menu.Products.Drink5 , Menu.Products. Drink6 ,  Menu.Products.Drink7 ,  Menu.Products.Drink8 ,  Menu.Products.Drink9 ,  Menu.Products.Drink10 } ;
		double[] PRICE = {6.0, 7.5, 9.0, 8.5, 6.5, 10.0, 7.0, 9.5, 8.0, 6.0,12.0, 11.5, 10.0, 13.5, 14.0, 9.5, 10.5, 12.5, 13.0, 11.0,9.0, 8.5, 10.0, 9.5, 8.0, 11.0, 10.5, 9.5, 10.0, 8.5,7.0, 8.0, 7.5, 6.5, 9.0, 6.0, 7.5, 8.5, 7.0, 6.5} ;
		
		
		Menu.Products[] Prod1 = {Menu.Products.Starter1 , Menu.Products.Starter2 , Menu.Products.Starter3 , Menu.Products.Starter4 ,
		Menu.Products.Starter5 ,  Menu.Products.Starter6 ,  Menu.Products.Starter7 ,  Menu.Products.Starter8 ,  Menu.Products.Starter9 ,  Menu.Products.Starter10 ,
		Menu.Products.mainDish1 ,  Menu.Products.mainDish2 ,  Menu.Products.mainDish3 ,  Menu.Products.mainDish4 ,  Menu.Products.mainDish5 ,  Menu.Products.mainDish6 ,  Menu.Products.mainDish7 ,  Menu.Products.mainDish8 ,  Menu.Products.mainDish9 ,  Menu.Products.mainDish10 ,
		 Menu.Products.Dessert1 ,  Menu.Products.Dessert2 ,  Menu.Products.Dessert3 ,  Menu.Products.Dessert4 ,  Menu.Products.Dessert5 ,  Menu.Products.Dessert6 ,  Menu.Products.Dessert7 ,  Menu.Products.Dessert8 ,  Menu.Products.Dessert9 ,  Menu.Products.Dessert10 ,
		 Menu.Products.Drink1 ,  Menu.Products.Drink2 ,  Menu.Products.Drink3 ,  Menu.Products.Drink4 ,  Menu.Products.Drink5 , Menu.Products. Drink6 ,  Menu.Products.Drink7 ,  Menu.Products.Drink8 ,  Menu.Products.Drink9 ,  Menu.Products.Drink10 } ;
		double[] PRICE1 = {10.0, 7.5, 9.0, 8.5, 6.5, 10.0, 7.0, 9.5, 8.0, 6.0,12.0, 11.5, 10.0, 13.5, 14.0, 9.5, 10.5, 12.5, 13.0, 11.0,9.0, 8.5, 10.0, 9.5, 8.0, 11.0, 10.5, 9.5, 10.0, 8.5,7.0, 8.0, 7.5, 6.5, 9.0, 6.0, 7.5, 8.5, 7.0, 6.5} ;
		
		Menu.Products[] Prod2 = {  Menu.Products.Starter9 ,  Menu.Products.mainDish3 ,Menu.Products.Dessert5, Menu.Products.Drink10 } ;
		double[] PRICE2 = { 6.0, 9.5, 8.0, 6.5} ;
		
		Menu.Products[] Prod3 = {Menu.Products.Starter1 , Menu.Products.Starter2 , Menu.Products.Starter3, Menu.Products.mainDish1 ,
		Menu.Products.mainDish2, Menu.Products.Dessert1 ,  Menu.Products.Dessert2 ,  Menu.Products.Dessert3,
		Menu.Products.Drink1 ,  Menu.Products.Drink2 ,  Menu.Products.Drink3} ;
		double[] PRICE3 = {10.0, 7.5, 9.0, 8.5, 6.5, 10.0, 7.0, 9.5, 8.0, 6.0,12.0} ;
		
		//MENU CREATION
		Menu Me = new Menu(Prod, PRICE , stores[1].owner , stores[1]) ;
		stores[1].addMenu(Me);
		Menu Me1 = new Menu(Prod1, PRICE1 , stores[1].owner , stores[1]) ;
		stores[1].addMenu(Me1);
		
		Menu Me2 = new Menu(Prod2, PRICE2 , stores[3].owner , stores[3]) ;
		stores[3].addMenu(Me2);
		
		Menu Me3 = new Menu(Prod3, PRICE3 , stores[4].owner , stores[4]) ;
		stores[4].addMenu(Me3);
		
		//RATING CREATION
		Rating S = new Rating(customers[0].order[0].store,customers[0],LocalDateTime.now(), 5);
		customers[0].addRating(customers[0].order[0].store, S);
		customers[0].order[0].store.addRating(S);
		
		Rating S1 = new Rating(customers[0].order[3].store,customers[0],LocalDateTime.now(), 2);
		customers[0].addRating(customers[0].order[3].store, S1);
		customers[0].order[3].store.addRating(S1);
		
		Rating S2 = new Rating(customers[1].order[0].store,customers[1],LocalDateTime.now(), 4);
		customers[1].addRating(customers[1].order[0].store, S2);
		customers[1].order[0].store.addRating(S2);
		
		Rating S3 = new Rating(customers[2].order[0].store,customers[2],LocalDateTime.now(), 1);
		customers[2].addRating(customers[1].order[0].store, S3);
		customers[2].order[0].store.addRating(S3);
		
		//FeedBack CREATION
		FeedBack F = new FeedBack(customers[0].order[0].store,customers[0],LocalDateTime.now(),"Feed TEXT");
		customers[0].addFeedBack(customers[0].order[0].store, F);
		customers[0].order[0].store.addFeedBack(F);
		
		FeedBack F1 = new FeedBack(customers[0].order[0].store,customers[0],LocalDateTime.now(),"Feed TEXT");
		customers[0].addFeedBack(customers[0].order[3].store, F1);
		customers[0].order[3].store.addFeedBack(F1);
		
		FeedBack F2 = new FeedBack(customers[1].order[0].store,customers[1],LocalDateTime.now(),"Feed TEXT");
		customers[1].addFeedBack(customers[1].order[0].store, F2);
		customers[1].order[0].store.addFeedBack(F2);
		
		FeedBack F3 = new FeedBack(customers[2].order[0].store,customers[2],LocalDateTime.now(),"Feed TEXT");
		customers[2].addFeedBack(customers[2].order[0].store, F3);
		customers[2].order[0].store.addFeedBack(F3);
		
		
		//PAYMENT CREATION
		Payment Z = new Payment(customers[0].wallet , LocalDateTime.now(), customers[0].order[0], customers[0].order[0].shoppingCart.price ) ;
		customers[0].order[0].addPayment(Z);
		customers[0].addnewPayment(Z);
		
		Payment Z1 = new Payment(customers[1].wallet , LocalDateTime.now(), customers[1].order[0], customers[1].order[0].shoppingCart.price ) ;
		customers[1].order[0].addPayment(Z1);
		customers[1].addnewPayment(Z1);
		
		Payment Z2 = new Payment(customers[2].wallet , LocalDateTime.now(), customers[2].order[0], customers[2].order[0].shoppingCart.price ) ;
		customers[2].order[0].addPayment(Z2);
		customers[2].addnewPayment(Z2);
		
		
		//REQUEST CREATION 
		Request newRequest1 = new Request(users[0],"String");				
		newRequest1.setAdmin(admins[0]);
		users[0].addRequest(newRequest1);
		
		if(customers[0].request == null)
		{
			customers[0].request = new Request[1] ;
			customers[0].request[0] = newRequest1 ;
		}
		else
		{
			Request[] R = new Request[customers[0].request.length + 1] ;
			for(int i = 0 ; i < customers[0].request.length ; i++)
			{
				R[i] =  customers[0].request[i] ;
			}
			R[R.length - 1] = newRequest1 ;
			customers[0].request = R ;
		}
		
		
		
		
		for(int i = 0 ; i < admins.length ; i++)
		{
			if(admins[i].request == null)
			{
				admins[i].request = new Request[1] ;
				admins[i].request[0] = newRequest1 ;
			}
			else
			{
				Request[] R = new Request[admins[i].request.length + 1] ;
				for(int j = 0 ; j < admins[i].request.length ; j++)
				{
					R[j] =  admins[i].request[j] ;
				}
				R[R.length - 1] = newRequest1 ;
				admins[i].request = R ;
			}
			
		}
	}
	
	public static void addManyData()
	{
		//USER CARD WALLET
		String[] All = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
				"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z" } ;
		char[] Type = {'C', 'A', 'O','U'} ;
		Order.TypeOfEvent[] X = {Order.TypeOfEvent.Baptism , Order.TypeOfEvent.Wedding , Order.TypeOfEvent.CorporateEvent , Order.TypeOfEvent.Other} ;
		Order.Status[] X1 = {Order.Status.Completed , Order.Status.Ongoing , Order.Status.Pending} ; 
		Menu.Products[] Prod = {Menu.Products.Starter1 , Menu.Products.Starter2 , Menu.Products.Starter3 , Menu.Products.Starter4 ,
		Menu.Products.Starter5 ,  Menu.Products.Starter6 ,  Menu.Products.Starter7 ,  Menu.Products.Starter8 ,  Menu.Products.Starter9 ,  Menu.Products.Starter10 ,
		Menu.Products.mainDish1 ,  Menu.Products.mainDish2 ,  Menu.Products.mainDish3 ,  Menu.Products.mainDish4 ,  Menu.Products.mainDish5 ,  Menu.Products.mainDish6 ,  Menu.Products.mainDish7 ,  Menu.Products.mainDish8 ,  Menu.Products.mainDish9 ,  Menu.Products.mainDish10 ,
		Menu.Products.Dessert1 ,  Menu.Products.Dessert2 ,  Menu.Products.Dessert3 ,  Menu.Products.Dessert4 ,  Menu.Products.Dessert5 ,  Menu.Products.Dessert6 ,  Menu.Products.Dessert7 ,  Menu.Products.Dessert8 ,  Menu.Products.Dessert9 ,  Menu.Products.Dessert10 ,
		Menu.Products.Drink1 ,  Menu.Products.Drink2 ,  Menu.Products.Drink3 ,  Menu.Products.Drink4 ,  Menu.Products.Drink5 , Menu.Products. Drink6 ,  Menu.Products.Drink7 ,  Menu.Products.Drink8 ,  Menu.Products.Drink9 ,  Menu.Products.Drink10 } ;
		double[] PRICE = {6.0, 7.5, 9.0, 8.5, 6.5, 10.0, 7.0, 9.5, 8.0, 6.0,12.0, 11.5, 10.0, 13.5, 14.0, 9.5, 10.5, 12.5, 13.0, 11.0,9.0, 8.5, 10.0, 9.5, 8.0, 11.0, 10.5, 9.5, 10.0, 8.5,7.0, 8.0, 7.5, 6.5, 9.0, 6.0, 7.5, 8.5, 7.0, 6.5} ;
		char[] TypeOfMenu = {'E','S','L'} ;
		Random random1 = new Random() , random2 = new Random() , random3 = new Random() , random4 = new Random() , random5 = new Random();
		
		for(int i = 0 ; i < 100 ; i++)
		{
			String a = All[random1.nextInt(All.length)] + All[random2.nextInt(All.length)] + All[random3.nextInt(All.length)] + All[random4.nextInt(All.length)] ;
			String b = All[random1.nextInt(All.length)] + All[random2.nextInt(All.length)] + All[random3.nextInt(All.length)] + All[random4.nextInt(All.length)] ;
			createUser(a, b, "Username"+ a, "Password"+ b, "mail", i, LocalDateTime.now(),Type[i % 4]) ;
			users[i].wallet = new Wallet( i, users[i] );
			Card card = new Card(Card.CardType.credit, 25454, 999, "Name", LocalDateTime.now(), random1.nextFloat()) ;
			users[i].addCard(card);
			
			if(Type[i % 4] == 'C')
			{
				customers[customers.length - 1].addCard(card);
			}
			else if(Type[i % 4] == 'O')
			{
				owners[owners.length - 1].addCard(card);
			}
			else
			{
				
			}
		}
		
		//STORE
		stores = new Store[50] ;
		for(int i = 0 ; i < stores.length ; i++)
		{
			String a = All[random1.nextInt(All.length)] + All[random2.nextInt(All.length)] + All[random3.nextInt(All.length)] + All[random4.nextInt(All.length)] ;
			String b = All[random1.nextInt(All.length)] + All[random2.nextInt(All.length)] + All[random3.nextInt(All.length)] + All[random4.nextInt(All.length)] ;
			int c = random5.nextInt(owners.length) ;
			stores[i] = new Store(a, b, owners[c]) ;
			owners[c].addStore(stores[i]);
		}
		
		//ORDER
		for(int i = 0 ; i < 1000 ; i++)
		{
			int c = random5.nextInt(1000) ;
			int c1 = random5.nextInt(50) ;
			int c2 = random5.nextInt(customers.length) ;
			Order A = new Order(LocalDateTime.now(), LocalDateTime.now(), c, X[i % 4], true, X1[i % 3], stores[c1]);
			customers[c2].addOrder(A);
			stores[c1].addOrder(customers[c2].order[customers[c2].order.length - 1]);
		}
		
		//Prod,Price,Menu
		for(int i = 0 ; i < 100 ; i++)
		{
			int c1 = random1.nextInt(Prod.length) ;
			int c2 = random2.nextInt(Prod.length) ;
			int c3 = random3.nextInt(Prod.length) ;
			int c4 = random4.nextInt(Prod.length) ;
			int c5 = random5.nextInt(stores.length) ;
			Menu.Products[] Prodcuts = { Prod[c1] , Prod[c2] , Prod[c3] , Prod[c4]} ;
			double[] Price = { PRICE[c1] , PRICE[c2] , PRICE[c3] , PRICE[c4]} ;
			if(TypeOfMenu[i % 3] == 'E')
			{
				EcoMenu Me = new EcoMenu(Prodcuts, stores[c5].owner , stores[c5],Price ) ;
				stores[c5].addMenu(Me);
			}
			else if(TypeOfMenu[i % 3] == 'S')
			{
				StandardMenu Me = new StandardMenu(Prodcuts, stores[c5].owner , stores[c5],Price ) ;
				stores[c5].addMenu(Me);
			}
			else
			{
				LuxuryMenu Me = new LuxuryMenu(Prodcuts, stores[c5].owner , stores[c5],Price ) ;
				stores[c5].addMenu(Me);
			}
			
		}
		
		//RATING, FEEDBACK
		for(int i = 0 ; i < 100 ; i++)
		{
			int c1 = random1.nextInt(customers.length) ;
			int c2 = random2.nextInt(customers[c1].order.length) ;
			int c3 = 1 + random3.nextInt(5) ;
			String a = All[random1.nextInt(All.length)] + All[random2.nextInt(All.length)] + All[random3.nextInt(All.length)] + All[random4.nextInt(All.length)] ;
			String b = All[random1.nextInt(All.length)] + All[random2.nextInt(All.length)] + All[random3.nextInt(All.length)] + All[random4.nextInt(All.length)] ;
			Rating S = new Rating(customers[c1].order[c2].store,customers[c1],LocalDateTime.now(), c3);
			customers[c1].addRating(customers[c1].order[c2].store, S);
			customers[c1].order[c2].store.addRating(S);
			FeedBack F = new FeedBack(customers[c1].order[c2].store,customers[c1],LocalDateTime.now(),a + " " +b);
			customers[c1].addFeedBack(customers[c1].order[c2].store, F);
			customers[c1].order[c2].store.addFeedBack(F);
		}
		
		//PAYMENT
		for(int i = 0 ; i < 100 ; i++)
		{
			int c1 = random1.nextInt(customers.length) ;
			int c2 = random2.nextInt(customers[c1].order.length) ;
			Payment Z = new Payment(customers[c1].wallet , LocalDateTime.now(), customers[c1].order[c2], customers[c1].order[c2].shoppingCart.price ) ;
			customers[c1].order[0].addPayment(Z);
			customers[c1].addnewPayment(Z);
		}
	}

	public static int ownerPostLog(int thisUserIndex,int thisOwnerIndex)
	{
		Scanner input = new Scanner(System.in) ;
		int option1 = input.nextInt() ;
		
		if(option1 == 1)
		{
			
			System.out.println("Choose one store");
			
			for(int i = 0 ; i<owners[thisOwnerIndex].store.length ; i++)
			{
				System.out.printf("%d : %s, %s\n", i+1 ,owners[thisOwnerIndex].store[i].name, owners[thisOwnerIndex].store[i].address) ;
			}
			input = new Scanner(System.in) ;
			int thisStoreIndex = input.nextInt() ;
			
			if(thisStoreIndex <=0 && thisStoreIndex >owners[thisOwnerIndex].store.length)
			{
				System.out.println("Wrong input") ;
			}
			else
			{
				
				thisStoreIndex -= 1 ;
				owners[thisOwnerIndex].store[thisStoreIndex].storeMessage() ;
				
				System.out.println();
				System.out.println("1 : Edit ");
				System.out.println("2 : My Orders");
				System.out.println();
				
				input = new Scanner(System.in) ;
				int option2 = input.nextInt() ;
				
				if(option2 == 1)
				{
					 
					System.out.println() ;
					System.out.println("1 : Edit Pricing ") ;
					System.out.println("2 : Edit Store Information ") ;
					System.out.println() ;
					input = new Scanner(System.in) ;
					int OPTION = input.nextInt() ;
					
					if(OPTION == 1)
					{
						if(owners[thisOwnerIndex].store[thisStoreIndex].menu == null)
						{
							System.out.println("Store hasnot any menus") ;
						}
						else
						{
							System.out.println("Choose the Product that you wish to change its price") ;
							
							for(int i = 0 ; i < owners[thisOwnerIndex].store[thisStoreIndex].menu.length ; i++)
							{
								for(int j = 0 ; j < owners[thisOwnerIndex].store[thisStoreIndex].menu[i].products.length ; j++)
								{
									System.out.printf("%d : %s, %.2f\n",i*1000 + j+1 , owners[thisOwnerIndex].store[thisStoreIndex].menu[i].products[j],owners[thisOwnerIndex].store[thisStoreIndex].menu[i].pricePerProduct[j]) ;
								}
								
							}
							
							input = new Scanner(System.in) ;
							int option3 = input.nextInt() ;
							
							int thisMenuIndex = option3 / 1000 ;
							int thisProductIndex = option3 % 1000 ;
							thisProductIndex -= 1 ;
							
							if(thisMenuIndex >= owners[thisOwnerIndex].store[thisStoreIndex].menu.length || thisMenuIndex<0)
							{
								System.out.println("Wrong input") ;
							}
							else
							{
								if(thisProductIndex >= owners[thisOwnerIndex].store[thisStoreIndex].menu[thisMenuIndex].products.length || thisMenuIndex < 0)
								{
									System.out.println("Wrong input") ;
								}
								else
								{
									System.out.printf("New Price for %s :",owners[thisOwnerIndex].store[thisStoreIndex].menu[thisMenuIndex].products[thisProductIndex]) ;
									input = new Scanner(System.in) ;
									double option4 = input.nextDouble() ;
									if(option4 <= 0 )
									{
										System.out.println("Wrong input") ;
									}
									else
									{
										owners[thisOwnerIndex].store[thisStoreIndex].menu[thisMenuIndex].pricePerProduct[thisProductIndex] = option4 ;
										for(int i = 0 ; i < stores.length ; i++)
										{
											if(stores[i].equals(owners[thisOwnerIndex].store[thisStoreIndex]))
											{
												stores[i].menu[thisMenuIndex].pricePerProduct[thisProductIndex] = owners[thisOwnerIndex].store[thisStoreIndex].menu[thisMenuIndex].pricePerProduct[thisProductIndex] ;
												break ;
											}
										}
									}
									
								}
							}
						}
					}
					else if(OPTION == 2)
					{
						System.out.println();
						System.out.println("1 : Change Name");
						System.out.println("2 : Change Address");
						System.out.println();
						
						input = new Scanner(System.in) ;
						int option3 = input.nextInt() ;
						
						if(option3 == 1)
						{
							System.out.printf("New Name : ") ;
							
							input = new Scanner(System.in) ;
							String type = input.nextLine() ;
							
							owners[thisOwnerIndex].store[thisStoreIndex].name = type ;
							
							for(int i = 0 ; i < stores.length ; i++)
							{
								if(stores[i].equals(owners[thisOwnerIndex].store[thisStoreIndex]))
								{
									stores[i].name = type ;
									break ;
								}
							}
						}
						else if(option3 == 2)
						{
							System.out.printf("New Address : ") ;
							
							input = new Scanner(System.in) ;
							String type = input.nextLine() ;
							
							owners[thisOwnerIndex].store[thisStoreIndex].address = type ;
							
							for(int i = 0 ; i < stores.length ; i++)
							{
								if(stores[i].equals(owners[thisOwnerIndex].store[thisStoreIndex]))
								{
									stores[i].address = type ;
									break ;
								}
							}
						}
						else
						{
							System.out.println("Wrong input") ;
						}
					}
					else
					{
						System.out.println("Wrong input") ;
					}
						
					
				} 
				else if(option2 == 2)
				{
					System.out.println() ;
					System.out.println("1 : Pending Orders") ;
					System.out.println("2 : Ongoing Orders") ;
					System.out.println("3 : Completed Orders") ;
					System.out.println() ;
					input = new Scanner(System.in) ;
					int option3 = input.nextInt() ;
					
					if(owners[thisOwnerIndex].store[thisStoreIndex].order == null)
					{
						System.out.println("There are no available Orders") ;
					}
					else
					{
						int max = 0 ; 
						boolean exist = false ;
						if(option3 == 1)
						{
							
							for(int i = 0 ; i < owners[thisOwnerIndex].store[thisStoreIndex].order.length ; i++)
							{
								if(owners[thisOwnerIndex].store[thisStoreIndex].order[i].status.equals(Order.Status.Pending))
								{
									exist = true ;
									System.out.printf("Order %d \nNumber Of Persons : %d\nType Of Event : %s\n",i+1,owners[thisOwnerIndex].store[thisStoreIndex].order[i].numberOfPersons,owners[thisOwnerIndex].store[thisStoreIndex].order[i].typeOfEvent) ;
									max = i+1 ;
								}
							}
							
							
							if(exist)
							{
								System.out.println();
								System.out.printf("Choose an Order :") ;
								input = new Scanner(System.in) ;
								int option4 = input.nextInt() ;
								
								if(option4 <=0 || option4 > max)
								{
									System.out.println("Wrong input") ;
								}
								else
								{
									owners[thisOwnerIndex].store[thisStoreIndex].order[option4-1].message();
									System.out.printf("\nPress 1 : Aprove Order \nPress 2 : Disaprove Order\nChoice : ") ;
									input = new Scanner(System.in) ;
									int option5 = input.nextInt() ;
									
									if(option5 == 1 )
									{
										owners[thisOwnerIndex].store[thisStoreIndex].order[option4-1].status = Order.Status.Ongoing ;
										System.out.println("Order was approved you can find it on ongoing orders now") ;
									}
									else if(option5 == 2 )
									{
										owners[thisOwnerIndex].store[thisStoreIndex].deleteOrder(owners[thisOwnerIndex].store[thisStoreIndex].order[option4-1]) ;
										
										System.out.println("Order was deleted Successfully") ;
									}
									else
									{
										System.out.println("Wrong input") ;
									}
								}
							}
							
						}
						else if(option3 == 2)
						{
							for(int i = 0 ; i < owners[thisOwnerIndex].store[thisStoreIndex].order.length ; i++)
							{
								if(owners[thisOwnerIndex].store[thisStoreIndex].order[i].status.equals(Order.Status.Ongoing))
								{
									exist = true ;
									System.out.printf("Order %d \nNumber Of Persons : %d\nType Of Event : %s\n",i+1,owners[thisOwnerIndex].store[thisStoreIndex].order[i].numberOfPersons,owners[thisOwnerIndex].store[thisStoreIndex].order[i].typeOfEvent) ;
									max = i+1 ;
								}
							}
							
							if(exist)
							{
								System.out.println();
								System.out.printf("Choose an Order :") ;
								input = new Scanner(System.in) ;
								int option4 = input.nextInt() ;
								
								if(option4 <=0 || option4 > max)
								{
									System.out.println("Wrong input") ;
								}
								else
								{
									owners[thisOwnerIndex].store[thisStoreIndex].order[option4-1].message();
								}
							}
						}
						else if(option3 == 3)
						{
							for(int i = 0 ; i < owners[thisOwnerIndex].store[thisStoreIndex].order.length ; i++)
							{
								if(owners[thisOwnerIndex].store[thisStoreIndex].order[i].status.equals(Order.Status.Completed))
								{
									exist = true ;
									System.out.printf("Order %d \nNumber Of Persons : %d\nType Of Event : %s\n",i+1,owners[thisOwnerIndex].store[thisStoreIndex].order[i].numberOfPersons,owners[thisOwnerIndex].store[thisStoreIndex].order[i].typeOfEvent) ;
									max = i+1 ;
								}
							}
							
							if(exist)
							{
								boolean stop=false ;
								System.out.println();
								System.out.printf("Choose an Order :") ;
								input = new Scanner(System.in) ;
								int option4 = input.nextInt() ;
								
								if(option4 <=0 || option4 > max)
								{
									System.out.println("Wrong input") ;
								}
								else
								{
									owners[thisOwnerIndex].store[thisStoreIndex].order[option4-1].message();
									
									if(owners[thisOwnerIndex].store[thisStoreIndex].rating == null)
									{
										System.out.println("Rating doesnot exist for this order") ;
									}
									else
									{
										for(int k = 0 ; k < owners[thisOwnerIndex].store[thisStoreIndex].rating.length ; k++)
										{
											for(int i = 0 ; i < customers.length ; i++)
											{
												if(customers[i].rating == null)
												{
													continue ;
												}
												else
												{
													for(int j = 0 ; j < customers[i].rating.length ; j++)
													{
														if(owners[thisOwnerIndex].store[thisStoreIndex].rating[k].equals(customers[i].rating[j]))
														{
															System.out.printf("Rating for Order : %d\n", owners[thisOwnerIndex].store[thisStoreIndex].rating[k].rating) ;
															stop = true ;
															break ;
														}
														
														if(stop)
														{
															break ;
														}
													}
													
													
												}	
											}
										}
									}
									
									stop = false ;
									
									if(owners[thisOwnerIndex].store[thisStoreIndex].feedBack == null)
									{
										System.out.println("FeedBack doesnot exist for this order") ;
									}
									else
									{
										for(int k = 0 ; k < owners[thisOwnerIndex].store[thisStoreIndex].feedBack.length ; k++)
										{
											for(int i = 0 ; i < customers.length ; i++)
											{
												if(customers[i].feedBack == null)
												{
													continue ;
												}
												else
												{
													for(int j = 0 ; j < customers[i].feedBack.length ; j++)
													{
														if(owners[thisOwnerIndex].store[thisStoreIndex].feedBack[k].equals(customers[i].feedBack[j]))
														{
															System.out.printf("FeedBack for Order : %s\n", owners[thisOwnerIndex].store[thisStoreIndex].feedBack[k].text) ;
															stop = true ;
															break ;
														}
													}
													
													if(stop)
													{
														break ;
													}
												}
												
												if(stop)
												{
													break ;
												}
												
											}
											if(stop)
											{
												break ;
											}
										}
									}
									
									
								}
							}
						}
						else
						{
							System.out.println("Wrong input") ;
						}
					}
					
				}
				else
				{
					System.out.println("Wrong input") ;
				}
			}
			
		}
		else if(option1 == 2)
		{
			System.out.println();
			System.out.printf("Enter your store name : ") ;
			input = new Scanner(System.in) ;
			String Name = input.nextLine() ;
			System.out.printf("Enter your store address : ") ;
			String Address = input.nextLine() ;
			
			if(stores == null)
			{
				stores[0] = new Store(Name,Address,owners[thisOwnerIndex]) ;
				owners[thisOwnerIndex].addStore(stores[stores.length -1]);
				
				
				
				System.out.println();
				System.out.println("Choose the products and price you wish to serve ") ;
				System.out.println("Enter 5000 when you are finished") ;
				Menu.Products[] Products = {} ;
				double[] PRICE = {} ;
				
				Menu.Products[] ALLPRODUCTS = {Menu.Products.Starter1 , Menu.Products.Starter2 , Menu.Products.Starter3 ,
					Menu.Products.Starter4 , Menu.Products.Starter5 ,  Menu.Products.Starter6 ,  Menu.Products.Starter7 ,
					Menu.Products.Starter8 ,  Menu.Products.Starter9 ,	Menu.Products.Starter10 ,
					Menu.Products.mainDish1 ,  Menu.Products.mainDish2 ,  Menu.Products.mainDish3 ,  Menu.Products.mainDish4 ,
					Menu.Products.mainDish5 ,  Menu.Products.mainDish6 ,  Menu.Products.mainDish7 ,  Menu.Products.mainDish8 , 
					Menu.Products.mainDish9 ,  Menu.Products.mainDish10 ,
					Menu.Products.Dessert1 ,  Menu.Products.Dessert2 ,  Menu.Products.Dessert3 ,  Menu.Products.Dessert4 , 
					Menu.Products.Dessert5 ,  Menu.Products.Dessert6 ,  Menu.Products.Dessert7 ,  Menu.Products.Dessert8 , 
					Menu.Products.Dessert9 ,  Menu.Products.Dessert10 ,
					Menu.Products.Drink1 ,  Menu.Products.Drink2 ,  Menu.Products.Drink3 ,  Menu.Products.Drink4 ,
					Menu.Products.Drink5 , Menu.Products. Drink6 ,  Menu.Products.Drink7 ,  Menu.Products.Drink8 , 
					Menu.Products.Drink9 ,  Menu.Products.Drink10 } ;
				
				
				for(int i = 0 ; i < ALLPRODUCTS.length ; i++)
				{
					System.out.printf("%d : %s\n",i+1,ALLPRODUCTS[i]) ;
				}
				
				System.out.println();
				
				int options = 0 ;
				do
				{					
					input= new Scanner(System.in) ;
					options = input.nextInt() ;
					
					if(options > 0 && options <= ALLPRODUCTS.length)
					{
						System.out.printf("Price for product %s : ",ALLPRODUCTS[options - 1]) ;
						input = new Scanner(System.in) ;
						double priceopt = input.nextDouble() ;
						if(priceopt <= 0)
						{
							System.out.println("Wrong input") ;
						}
						else
						{
							if(Products == null)
							{
								Products[0] = ALLPRODUCTS[options - 1];
								PRICE[0] = priceopt ;
							}
							else
							{
								Menu.Products[] newProducts = new Menu.Products[Products.length + 1] ;
								double[] newPrice = new double[PRICE.length + 1] ;
								for(int i = 0 ; i < newProducts.length ; i++)
								{
									if(i == newProducts.length-1)
									{
										newProducts[i] = ALLPRODUCTS[options - 1] ;
										newPrice[i] = priceopt ;
									}
									else
									{
										newProducts[i] = Products[i] ;
										newPrice[i] = PRICE[i] ;
									}
								}
								Products = newProducts ;
								PRICE = newPrice ;
							}
						}
						
					}
					
					
					if(options == 5000)
					{
						break ;
					}
				}while(options != 5000 || !(options <= 0));
				
				System.out.println("Enter the type of menu you want to create") ;
				System.out.println("Enter 5000 when you are ready") ;
				int Newoptions1 = 0 ;
				do
				{
					System.out.println("1 : Create Eco Menu") ;
					System.out.println("2 : Create Standard Menu") ;
					System.out.println("3 : Create Luxury Menu") ;
					Newoptions1 = input.nextInt() ;
					
					if(Newoptions1 == 1)
					{
						System.out.println();
						System.out.println("Choose the products") ;
						System.out.println("Enter 5000 when you are finished") ;
						
						for(int i = 0 ; i < Products.length ; i++)
						{
							System.out.printf("%d : %s\n",i+1,Products[i]) ;
						}
						
						System.out.println();
						int newOptions2 = 0 ;
						Menu.Products[] Products2 = {} ;
						double[] price= {} ;
						
						do
						{
							input = new Scanner(System.in) ;
							newOptions2 = input.nextInt() ;
							if(Products == null)
							{
								Products2[0] = Products[newOptions2 - 1] ;
								price[0] = PRICE[newOptions2 - 1] ;
							}
							else
							{
								Menu.Products[] newP = new Menu.Products[Products.length + 1] ;
								double[] newD = new double[price.length + 1] ;
								for(int i = 0 ; i < newP.length ; i++)
								{
									if(i==newP.length - 1)
									{
										newP[i] = Products[newOptions2 - 1] ;
										newD[i] = PRICE[newOptions2 - 1] ;
									}
									else
									{
										newP[i] = Products2[i] ;
										newD[i] = price[i] ;
									}
								}
								Products2 = newP ;
								price = newD ;
							}
							
							
						}while(newOptions2 != 5000 || newOptions2 <= 0) ;
						
						EcoMenu mynewMenu = new EcoMenu(Products2, stores[stores.length-1].owner , stores[stores.length-1],price) ;
						stores[stores.length-1].addMenu(mynewMenu);
						
					}
					else if(Newoptions1 == 2)
					{
						System.out.println();
						System.out.println("Choose the products") ;
						System.out.println("Enter 5000 when you are finished") ;
						
						for(int i = 0 ; i < Products.length ; i++)
						{
							System.out.printf("%d : %s\n",i+1,Products[i]) ;
						}
						
						System.out.println();
						int newOptions2 = 0 ;
						Menu.Products[] Products2 = {} ;
						double[] price= {} ;
						
						do
						{
							input = new Scanner(System.in) ;
							newOptions2 = input.nextInt() ;
							if(Products == null)
							{
								Products2[0] = Products[newOptions2 - 1] ;
								price[0] = PRICE[newOptions2 - 1] ;
							}
							else
							{
								Menu.Products[] newP = new Menu.Products[Products.length + 1] ;
								double[] newD = new double[price.length + 1] ;
								for(int i = 0 ; i < newP.length ; i++)
								{
									if(i==newP.length - 1)
									{
										newP[i] = Products[newOptions2 - 1] ;
										newD[i] = PRICE[newOptions2 - 1] ;
									}
									else
									{
										newP[i] = Products2[i] ;
										newD[i] = price[i] ;
									}
								}
								Products2 = newP ;
								price = newD ;
							}
							
							
						}while(newOptions2 != 5000 || newOptions2 <= 0) ;
						
						StandardMenu mynewMenu = new StandardMenu(Products2, stores[stores.length-1].owner , stores[stores.length-1],price) ;
						stores[stores.length-1].addMenu(mynewMenu);
					}
					else if(Newoptions1 == 3)
					{
						System.out.println();
						System.out.println("Choose the products") ;
						System.out.println("Enter 5000 when you are finished") ;
						
						for(int i = 0 ; i < Products.length ; i++)
						{
							System.out.printf("%d : %s\n",i+1,Products[i]) ;
						}
						
						System.out.println();
						int newOptions2 = 0 ;
						Menu.Products[] Products2 = {} ;
						double[] price= {} ;
						
						do
						{
							input = new Scanner(System.in) ;
							newOptions2 = input.nextInt() ;
							if(Products == null)
							{
								Products2[0] = Products[newOptions2 - 1] ;
								price[0] = PRICE[newOptions2 - 1] ;
							}
							else
							{
								Menu.Products[] newP = new Menu.Products[Products.length + 1] ;
								double[] newD = new double[price.length + 1] ;
								for(int i = 0 ; i < newP.length ; i++)
								{
									if(i==newP.length - 1)
									{
										newP[i] = Products[newOptions2 - 1] ;
										newD[i] = PRICE[newOptions2 - 1] ;
									}
									else
									{
										newP[i] = Products2[i] ;
										newD[i] = price[i] ;
									}
								}
								Products2 = newP ;
								price = newD ;
							}
							
							
						}while(newOptions2 != 5000 || newOptions2 <= 0) ;
						
						LuxuryMenu mynewMenu = new LuxuryMenu(Products2, stores[stores.length-1].owner , stores[stores.length-1],price) ;
						stores[stores.length-1].addMenu(mynewMenu);
					}
					else 
					{
						System.out.println("Wrong input") ;
						break ;
					}
				}while(Newoptions1 != 5000 || Newoptions1 <=0 );
			}
			else
			{
				Store[] Store = new Store[stores.length + 1] ;
				for(int i = 0 ; i < Store.length ; i++)
				{
					if(i == Store.length-1)
					{
						Store[i] =  new Store(Name,Address,owners[thisOwnerIndex]) ;
						owners[thisOwnerIndex].addStore(Store[i]) ;
					}
					else
					{
						Store[i] = stores[i] ;
					}
				}
				stores = Store ;
				
				System.out.println();
				System.out.println("Choose the products and price you wish to serve ") ;
				System.out.println("Enter 5000 when you are finished") ;
				Menu.Products[] Products = {} ;
				double[] PRICE = {} ;
				
				Menu.Products[] ALLPRODUCTS = {Menu.Products.Starter1 , Menu.Products.Starter2 , Menu.Products.Starter3 ,
					Menu.Products.Starter4 , Menu.Products.Starter5 ,  Menu.Products.Starter6 ,  Menu.Products.Starter7 ,
					Menu.Products.Starter8 ,  Menu.Products.Starter9 ,	Menu.Products.Starter10 ,
					Menu.Products.mainDish1 ,  Menu.Products.mainDish2 ,  Menu.Products.mainDish3 ,  Menu.Products.mainDish4 ,
					Menu.Products.mainDish5 ,  Menu.Products.mainDish6 ,  Menu.Products.mainDish7 ,  Menu.Products.mainDish8 , 
					Menu.Products.mainDish9 ,  Menu.Products.mainDish10 ,
					Menu.Products.Dessert1 ,  Menu.Products.Dessert2 ,  Menu.Products.Dessert3 ,  Menu.Products.Dessert4 , 
					Menu.Products.Dessert5 ,  Menu.Products.Dessert6 ,  Menu.Products.Dessert7 ,  Menu.Products.Dessert8 , 
					Menu.Products.Dessert9 ,  Menu.Products.Dessert10 ,
					Menu.Products.Drink1 ,  Menu.Products.Drink2 ,  Menu.Products.Drink3 ,  Menu.Products.Drink4 ,
					Menu.Products.Drink5 , Menu.Products. Drink6 ,  Menu.Products.Drink7 ,  Menu.Products.Drink8 , 
					Menu.Products.Drink9 ,  Menu.Products.Drink10 } ;
				
				
				for(int i = 0 ; i < ALLPRODUCTS.length ; i++)
				{
					System.out.printf("%d : %s\n",i+1,ALLPRODUCTS[i]) ;
				}
				
				System.out.println();
				
				int options = 0 ;
				do
				{					
					input= new Scanner(System.in) ;
					options = input.nextInt() ;
					
					if(options > 0 && options <= ALLPRODUCTS.length)
					{
						System.out.printf("Price for product %s : ",ALLPRODUCTS[options - 1]) ;
						input = new Scanner(System.in) ;
						double priceopt = input.nextDouble() ;
						if(priceopt <= 0)
						{
							System.out.println("Wrong input") ;
						}
						else
						{
							if(Products == null)
							{
								Products[0] = ALLPRODUCTS[options - 1];
								PRICE[0] = priceopt ;
							}
							else
							{
								Menu.Products[] newProducts = new Menu.Products[Products.length + 1] ;
								double[] newPrice = new double[PRICE.length + 1] ;
								for(int i = 0 ; i < newProducts.length ; i++)
								{
									if(i == newProducts.length-1)
									{
										newProducts[i] = ALLPRODUCTS[options - 1] ;
										newPrice[i] = priceopt ;
									}
									else
									{
										newProducts[i] = Products[i] ;
										newPrice[i] = PRICE[i] ;
									}
								}
								Products = newProducts ;
								PRICE = newPrice ;
							}
						}
						
					}
					
					
					if(options == 5000)
					{
						break ;
					}
				}while(options != 5000 || !(options <= 0));
				
				
				
				
				System.out.println("Enter the type of menu you want to create") ;
				System.out.println("Enter 5000 when you are ready") ;
				int Newoptions1 = 0 ;
				do
				{
					System.out.println("1 : Create Eco Menu") ;
					System.out.println("2 : Create Standard Menu") ;
					System.out.println("3 : Create Luxury Menu") ;
					Newoptions1 = input.nextInt() ;
					
					if(Newoptions1 == 5000)
					{
						break ;
					}
					
					if(Newoptions1 == 1)
					{
						System.out.println();
						System.out.println("Choose the products") ;
						System.out.println("Enter 5000 when you are finished") ;
						
						for(int i = 0 ; i < Products.length ; i++)
						{
							System.out.printf("%d : %s\n",i+1,Products[i]) ;
						}
						
						System.out.println();
						int newOptions2 = 0 ;
						Menu.Products[] Products2 = new Menu.Products[0]  ;
						double[] price = new double[0] ;
						
						do
						{
							input = new Scanner(System.in) ;
							newOptions2 = input.nextInt() ;
							
							if(newOptions2 == 5000)
							{
								break ;
							}
							
							if(Products2 == null)
							{
								Products2[0] = Products[newOptions2 - 1] ;
								price[0] = PRICE[newOptions2 - 1] ;
							}
							else
							{
								Menu.Products[] newP = new Menu.Products[Products2.length + 1] ;
								double[] newD = new double[PRICE.length + 1] ;
								for(int i = 0 ; i < newP.length ; i++)
								{
									if(i==newP.length - 1)
									{
										newP[i] = Products[newOptions2 - 1] ;
										newD[i] = PRICE[newOptions2 - 1] ;
									}
									else
									{
										newP[i] = Products[i] ;
										newD[i] = PRICE[i] ;
									}
								}
								Products2 = newP ;
								price = newD ;
							}
							
							
						}while(newOptions2 != 5000 || newOptions2 <= 0) ;
						
						EcoMenu mynewMenu = new EcoMenu(Products2, stores[stores.length-1].owner , stores[stores.length-1],price) ;
						stores[stores.length-1].addMenu(mynewMenu);
						
					}
					else if(Newoptions1 == 2)
					{
						System.out.println();
						System.out.println("Choose the products") ;
						System.out.println("Enter 5000 when you are finished") ;
						
						for(int i = 0 ; i < Products.length ; i++)
						{
							System.out.printf("%d : %s\n",i+1,Products[i]) ;
						}
						
						System.out.println();
						int newOptions2 = 0 ;
						Menu.Products[] Products2 = new Menu.Products[0]  ;
						double[] price = new double[0] ;
						
						do
						{
							input = new Scanner(System.in) ;
							newOptions2 = input.nextInt() ;
							
							if(newOptions2 == 5000)
							{
								break ;
							}
							
							if(Products2 == null)
							{
								Products2[0] = Products[newOptions2 - 1] ;
								price[0] = PRICE[newOptions2 - 1] ;
							}
							else
							{
								Menu.Products[] newP = new Menu.Products[Products2.length + 1] ;
								double[] newD = new double[PRICE.length + 1] ;
								for(int i = 0 ; i < newP.length ; i++)
								{
									if(i==newP.length - 1)
									{
										newP[i] = Products[newOptions2 - 1] ;
										newD[i] = PRICE[newOptions2 - 1] ;
									}
									else
									{
										newP[i] = Products[i] ;
										newD[i] = PRICE[i] ;
									}
								}
								Products2 = newP ;
								price = newD ;
							}
							
							
						}while(newOptions2 != 5000 || newOptions2 <= 0) ;
						
						StandardMenu mynewMenu = new StandardMenu(Products2, stores[stores.length-1].owner , stores[stores.length-1],price) ;
						stores[stores.length-1].addMenu(mynewMenu);
					}
					else if(Newoptions1 == 3)
					{
						System.out.println();
						System.out.println("Choose the products") ;
						System.out.println("Enter 5000 when you are finished") ;
						
						for(int i = 0 ; i < Products.length ; i++)
						{
							System.out.printf("%d : %s\n",i+1,Products[i]) ;
						}
						
						System.out.println();
						int newOptions2 = 0 ;
						Menu.Products[] Products2 = new Menu.Products[0]  ;
						double[] price = new double[0] ;
						
						do
						{
							input = new Scanner(System.in) ;
							newOptions2 = input.nextInt() ;
							
							if(newOptions2 == 5000)
							{
								break ;
							}
							
							if(Products2 == null)
							{
								Products2[0] = Products[newOptions2 - 1] ;
								price[0] = PRICE[newOptions2 - 1] ;
							}
							else
							{
								Menu.Products[] newP = new Menu.Products[Products2.length + 1] ;
								double[] newD = new double[PRICE.length + 1] ;
								for(int i = 0 ; i < newP.length ; i++)
								{
									if(i==newP.length - 1)
									{
										newP[i] = Products[newOptions2 - 1] ;
										newD[i] = PRICE[newOptions2 - 1] ;
									}
									else
									{
										newP[i] = Products[i] ;
										newD[i] = PRICE[i] ;
									}
								}
								Products2 = newP ;
								price = newD ;
							}
							
							
						}while(newOptions2 != 5000 || newOptions2 <= 0) ;
						
						LuxuryMenu mynewMenu = new LuxuryMenu(Products2, stores[stores.length-1].owner , stores[stores.length-1],price) ;
						stores[stores.length-1].addMenu(mynewMenu);
					}
					else 
					{
						System.out.println("Wrong input") ;
						break ;
					}
				}while(Newoptions1 != 5000 || Newoptions1 <=0 );
			}
		}
		else
		{
			
			thisOwnerIndex = 0 ;
			thisUserIndex = -1 ;
			
		}
		
		if(thisUserIndex == -1)
		{
			return -1 ;
		}
		else
		{
			return thisUserIndex ;
		}
	}
	
	public static void upgradeAccount(User User)
	{
		int userIndex =  -1 ,userTypeIndex = -1 ;
		boolean admin,customer,owner ;
		admin=customer=owner=false ;
		
		for(int i = 0 ; i < users.length ; i++)
		{
			if(users[i].username.equals(User.username))
			{
				users[i].state = User.state.Admin ;
				userIndex = i ;
				break ;
			}
		}
		
		for(int i = 0 ; i < owners.length ; i++)
		{
			if(owners[i].username.equals(User.username))
			{
				userTypeIndex = i ;
				owner = true ;
				owners[i].state = User.state.Admin ;
				break ;
			}
		}
		
		for(int i = 0 ; i < customers.length ; i++)
		{
			if(customers[i].username.equals(User.username))
			{
				userTypeIndex = i ;
				customers[i].state = User.state.Admin ;
				customer = true ;
				break ;
			}
		}
		
		for(int i = 0 ; i < admins.length ; i++)
		{
			if(admins[i].username.equals(User.username))
			{
				userTypeIndex = i ;
				owners[i].state = User.state.Admin ;
				admin = true ;
				break ;
			}
		}
		
		addAdmin(User.name, User.surname, User.username, User.password, User.email, User.phoneNumber, User.dateOfBirth) ;
	}
	
	public static void deleteAccount(User User)
	{
		int userIndex =  -1 ,userTypeIndex = -1 ;
		boolean admin,customer,owner ;
		admin=customer=owner=false ;
		
		for(int i = 0 ; i < users.length ; i++)
		{
			if(users[i].username.equals(User.username))
			{
				userIndex = i ;
				break ;
			}
		}
		
		for(int i = 0 ; i < owners.length ; i++)
		{
			if(owners[i].username.equals(User.username))
			{
				userTypeIndex = i ;
				owner = true ;
				break ;
			}
		}
		
		for(int i = 0 ; i < customers.length ; i++)
		{
			if(customers[i].username.equals(User.username))
			{
				userTypeIndex = i ;
				customer = true ;
				break ;
			}
		}
		
		for(int i = 0 ; i < admins.length ; i++)
		{
			if(admins[i].username.equals(User.username))
			{
				userTypeIndex = i ;
				admin = true ;
				break ;
			}
		}
		
		if(owner == true )
		{
			User[] newUser = new User[users.length - 1] ;
			for(int i = 0 ; i < users.length ; i++)
			{
				if(i == userIndex)
				{
					continue ;
				}
				else if(i > userIndex)
				{
					newUser[i - 1] = users[i] ; 
				}
				else
				{
					newUser[i] = users[i] ;
				}
			}
			users = newUser ;
			
			Owner[] newOwner = new Owner[owners.length - 1] ;
			for(int i = 0 ; i < owners.length ; i++)
			{
				if(i == userTypeIndex)
				{
					continue ;
				}
				else if(i > userTypeIndex)
				{
					newUser[i - 1] = owners[i] ; 
				}
				else
				{
					newUser[i] = owners[i] ;
				}
			}
			owners = newOwner ;
		}
		else if(customer == true )
		{
			if(users.length == 1)
			{
				User[] USERS = new User[0] ;
				users = USERS ;
			}
			else
			{
				User[] newUser = new User[users.length - 1] ;
				for(int i = 0 ; i < users.length ; i++)
				{
					if(i == userIndex)
					{
						continue ;
					}
					else if(i > userIndex)
					{
						newUser[i - 1] = users[i] ; 
					}
					else
					{
						newUser[i] = users[i] ;
					}
				}
				users = newUser ;
			}
			
			Customer[] newCustomer = new Customer[customers.length - 1] ;
			for(int i = 0 ; i < customers.length ; i++)
			{
				if(i == userTypeIndex)
				{
					continue ;
				}
				else if(i > userTypeIndex)
				{
					newCustomer[i - 1] = customers[i] ; 
				}
				else
				{
					newCustomer[i] = customers[i] ;
				}
			}
			customers = newCustomer ;
		}
		else if(admin == true )
		{
			User[] newUser = new User[users.length - 1] ;
			for(int i = 0 ; i < users.length ; i++)
			{
				if(i == userIndex)
				{
					continue ;
				}
				else if(i > userIndex)
				{
					newUser[i - 1] = users[i] ; 
				}
				else
				{
					newUser[i] = users[i] ;
				}
			}
			users = newUser ;
			
			Admin[] newAdmin = new Admin[admins.length - 1] ;
			for(int i = 0 ; i < admins.length ; i++)
			{
				if(i == userTypeIndex)
				{
					continue ;
				}
				else if(i > userTypeIndex)
				{
					newAdmin[i - 1] = admins[i] ; 
				}
				else
				{
					newAdmin[i] = admins[i] ;
				}
			}
			admins = newAdmin ;
		}
		else
		{
			User[] newUser = new User[users.length - 1] ;
			for(int i = 0 ; i < users.length ; i++)
			{
				if(i == userIndex)
				{
					continue ;
				}
				else if(i > userIndex)
				{
					newUser[i - 1] = users[i] ; 
				}
				else
				{
					newUser[i] = users[i] ;
				}
			}
			users = newUser ;
			
			
		}
	}
	
	public static void delUpOptions(User User)
	{
		System.out.println();
		System.out.println("1 : Delete Account");
		System.out.println("2 : Upgrade Account to Admin");
		System.out.println();
		Scanner input = new Scanner(System.in) ;
		int option3 = input.nextInt() ;
		
		if(option3 == 1)
		{
			System.out.println();
			System.out.printf("1 : Confirm on deleting account %s\n",User.username) ;
			System.out.printf("2 : Cancelation of account delegation %s",User.username) ;
			System.out.println();
			
			input= new Scanner(System.in) ;
			int option4 = input.nextInt() ;
			
			if(option4 == 1)
			{
				deleteAccount(User) ;
			}
			else if(option4 == 2)
			{
				
			}
			else
			{
				System.out.println("Wrong input") ;
			}
		}
		else if(option3 == 2)
		{
			System.out.println();
			System.out.printf("1 : Confirm on upgrading account %s\n",User.username) ;
			System.out.printf("2 : Cancelation of account upgrade %s",User.username) ;
			System.out.println();
			
			input= new Scanner(System.in) ;
			int option4 = input.nextInt() ;
			
			if(option4 == 1)
			{
				upgradeAccount(User) ;
			}
			else if(option4 == 2)
			{
				
			}
			else
			{
				System.out.println("Wrong input") ;
			}
		}
		else
		{
			System.out.println("Wrong input") ;
		}
	}
	
	public static void deleteStore(Store Store,Owner User)
	{
		int thisStoreIndex = - 1 , thisUserStoreIndex = -1 ;
		
		Store[] newStores = new Store[stores.length - 1], newUserStores = new Store[User.store.length - 1] ;
		for(int i = 0 ; i < stores.length ; i++)
		{
			if(stores[i].equals(Store))
			{
				thisStoreIndex = i ;
			}
		}
		
		for(int i = 0 ; i < User.store.length ; i++)
		{
			if(User.store[i].equals(Store))
			{
				thisUserStoreIndex = i ;
			}
		}
		
		for(int i = 0 ; i < stores.length ; i++)
		{
			if(i == thisStoreIndex)
			{
				continue ;
			}
			else if( i > thisStoreIndex)
			{
				newStores[i-1] = stores[i] ;
			}
			else
			{
				newStores[i] = stores[i] ;
			}
		}
		stores = newStores ;
		
		for(int i = 0 ; i < User.store.length ; i++)
		{
			if(i == thisUserStoreIndex)
			{
				continue ;
			}
			else if( i > thisUserStoreIndex)
			{
				newUserStores[i-1] = User.store[i] ;
			}
			else
			{
				newUserStores[i] = User.store[i] ;
			}
		}
		User.store = newUserStores ;
	}
	
	public static void deleteRequest(Request Request)
	{
		

		for(int i = 0 ; i < admins.length ; i++)
		{
			if(admins[i].request == null )
			{
				continue ;
			}
			else
			{
				admins[i].deleteRequest(Request);
			}
		}
		
		for(int i = 0 ; i < users.length ; i++)
		{
			if(users[i].request == null )
			{
				continue ;
			}
			else
			{
				users[i].deleteRequest(Request);
			}
		}
		
		for(int i = 0 ; i < customers.length ; i++)
		{
			if(customers[i].request == null )
			{
				continue ;
			}
			else
			{
				customers[i].deleteRequest(Request);
			}
		}
		
		for(int i = 0 ; i < owners.length ; i++)
		{
			if(owners[i].request == null )
			{
				continue ;
			}
			else
			{
				owners[i].deleteRequest(Request);
			}
		}
	}
	
	public static int adminPostLog(int thisUserIndex,int thisAdminIndex)
	{
		Scanner input= new Scanner(System.in) ;
		int option1 = input.nextInt() ;
		
		if(option1 == 1)
		{
			int max = 0 ;
			for(int i = 0 ; i < users.length ; i++)
			{
				System.out.printf("%d : %s, %s\n", i + 1 , users[i].username,users[i].state) ;
				max = i+1 ;
			}
			
			System.out.printf("%d : View Owner Accounts\n%d : View Customer Accounts\n%d : View Admin Accounts\n",max+1,max+2,max+3) ;
			input = new Scanner(System.in) ;
			int option2 = input.nextInt() ;
			
			if(option2 <= 0 || option2 >max+3)
			{
				System.out.println("Wrong input") ;
			}
			else if(option2 == max+1)
			{
				
				for(int i = 0 ; i < owners.length ; i++)
				{
					System.out.printf("%d : %s, %s\n", i + 1 , owners[i].username,owners[i].state) ;
				}
				System.out.printf("%d : View expired\n", owners.length + 1 ) ;
				input = new Scanner(System.in) ;
				int option3= input.nextInt() ;
				
				if(option3 <= 0 || option3 >owners.length + 1)
				{
					System.out.println("Wrong input") ;
				}
				else if(option3 == owners.length + 1)
				{
					boolean a = false ;
					for(int i = 0 ; i < owners.length ; i++)
					{
						if(owners[i].state.equals(User.State.Suspended))
						{
							System.out.printf("%d : %s, %s\n", i + 1 , owners[i].username,owners[i].state) ;
							a= true ;
						}
						
					}
					
					if(!a)
					{
						System.out.println("There are not any suspended accounts ") ;
					}
					else
					{
						input = new Scanner(System.in) ;
						int option4= input.nextInt() ;
						
						if(option4 <= 0 || option4 >owners.length + 1)
						{
							System.out.println("Wrong input") ;
						}
						else
						{
							owners[option4 -1 ].getUserProf();
						}
					}
				}
				else
				{
					owners[option3 -1 ].getUserProf();
					System.out.println() ;
					System.out.println("1 : Upgrade to Admin") ;
					System.out.println("2 : View Stores") ;
					
					input = new Scanner(System.in) ;
					int option4= input.nextInt() ;
					
					if(option4 == 1)
					{
						System.out.println();
						System.out.printf("1 : Confirm on upgrading account %s\n",owners[option3 -1 ].username) ;
						System.out.printf("2 : Cancelation of account upgrade %s",owners[option3 -1 ].username) ;
						System.out.println();
						input = new Scanner(System.in) ;
						int option5= input.nextInt() ;
						
						if(option5 == 1)
						{
							upgradeAccount(owners[option3 -1 ]) ;
							
						}
						else if(option5 == 2)
						{
							
						}
						else
						{
							System.out.println("Wrong input") ;
						}
						
						
					}
					else if(option4 == 2)
					{
						if(owners[option3-1].store == null)
						{
							System.out.println("This owner has not any stores") ;
						}
						else
						{
							for(int i = 0 ; i < owners[option3-1].store.length ; i++)
							{
								System.out.printf("%d : %s, %s\n", i+1, owners[option3-1].store[i].name,owners[option3-1].store[i].address) ;
							}
							
							input = new Scanner(System.in) ;
							int option5= input.nextInt() ;
							
							if(option5 <= 0 || option5 > owners[option3-1].store.length)
							{
								System.out.println("Wrong input") ;
							}
							else
							{
								System.out.println();
								System.out.println("1 : Confirm Store delegation");
								System.out.println("2 : Cancel Store delegation");
								input = new Scanner(System.in) ;
								int option6= input.nextInt() ;
								if(option6 == 1)
								{
									deleteStore(owners[option3-1].store[option5-1] ,owners[option3-1]) ;
								}
								else if(option6 == 2)
								{
									
								}
								else
								{
									System.out.println("Wrong input") ;
								}
								
							}
						}
						
					}
					else
					{
						System.out.println("Wrong input") ;
					}
				}
			}
			else if(option2 == max + 2)
			{
				boolean noexist = true ;
				for(int i = 0 ; i < customers.length ; i++)
				{
					System.out.printf("%d : %s, %s\n", i + 1 , customers[i].username,customers[i].state) ;
					noexist = false ;
				}
				if(noexist)
				{
					System.out.println("There are not any customers") ;
				}
				else
				{
					input = new Scanner(System.in) ;
					int option3= input.nextInt() ;
					
					if(option3 <= 0 || option3 >customers.length)
					{
						System.out.println("Wrong input") ;
					}
					else
					{
						customers[option3 -1 ].getUserProf();
						delUpOptions(customers[option3 -1 ]) ;
					}
				}
			}
			else if(option2 == max + 3)
			{
				for(int i = 0 ; i < admins.length ; i++)
				{
					System.out.printf("%d : %s, %s\n", i + 1 , admins[i].username,admins[i].state) ;
					
				}
				
				input = new Scanner(System.in) ;
				int option3= input.nextInt() ;
				
				if(option3 <= 0 || option3 >admins.length)
				{
					System.out.println("Wrong input") ;
				}
				else
				{
					admins[option3 -1 ].getUserProf();
					System.out.println();
					System.out.println("1 : Delete Account");
					System.out.println();
					input = new Scanner(System.in) ;
					int option4 = input.nextInt() ;
					
					if(option4 == 1)
					{
						if(admins[thisAdminIndex].equals(admins[option3-1]))
						{
							System.out.println("You may not delete your own account ") ;
						}
						else
						{
							System.out.println();
							System.out.printf("1 : Confirm on deleting account %s\n",admins[option3 -1 ].username) ;
							System.out.printf("2 : Cancelation of account delegation %s",admins[option3 -1 ].username) ;
							System.out.println();
							
							input= new Scanner(System.in) ;
							int option5 = input.nextInt() ;
							
							if(option4 == 1)
							{
								deleteAccount(admins[option3 -1 ]) ;
							}
							else if(option4 == 2)
							{
								
							}
							else
							{
								System.out.println("Wrong input") ;
							}
						}
					}
					else
					{
						System.out.println("Wrong input") ;
					}
				}
			}
			else
			{
				users[option2 -1 ].getUserProf();
				delUpOptions(users[option2 -1 ]) ;
			}
		}
		else if(option1 == 2)
		{
			System.out.println();
			System.out.println("1 : View Pending Requests") ;
			System.out.println("2 : View Completed Requests") ;
			
			input = new Scanner(System.in) ;
			int option2 = input.nextInt() ;
			
			if(option2 == 1)
			{
				if(admins[thisAdminIndex].request == null)
				{
					System.out.println("There are not any requests") ;
				}
				else
				{
					boolean pendingReq = true ;
					for(int i = 0 ; i < admins[thisAdminIndex].request.length ; i++)
					{
						if(admins[thisAdminIndex].request[i].status.equals(Request.Status.Pending))
						{
							admins[thisAdminIndex].request[i].user.getUserProf();
							
							System.out.printf("\nRequest %d Text : \n%s\n",i+1,admins[thisAdminIndex].request[i].text) ;
							pendingReq = false ;
						}
					}
					
					if(pendingReq)
					{
						System.out.println("There are not any Pending Requests") ;
					}
					else
					{
						input = new Scanner(System.in) ;
						int option3 = input.nextInt() ;
						
						if(option3 <= 0 || option3 > admins[thisAdminIndex].request.length)
						{
							System.out.println("Wrong input") ;
						}
						else
						{
							System.out.println();
							System.out.println("1 : Answer to Request") ;
							System.out.println("2 : Delete Request") ;
							input = new Scanner(System.in) ;
							int option4 = input.nextInt() ;
							
							if(option4 == 1)
							{
								System.out.println("Enter your reply :") ;
								input = new Scanner(System.in) ;
								String reply = input.nextLine() ;
								admins[thisAdminIndex].request[option3-1].status = Request.Status.Completed ;
								System.out.println("Request was answered successfully") ;
							}
							else if(option4 == 2)
							{
								deleteRequest(admins[thisAdminIndex].request[option3-1] ) ;
								System.out.println("Request Deleted successfully") ;
							}
							else
							{
								System.out.println("Wrong input") ;
							}
					}
					}
					
				}
			}
			else if(option2 == 2)
			{
				if(admins[thisAdminIndex].request == null)
				{
					System.out.println("There are not any requests") ;
				}
				else
				{
					boolean noCompleted = true ;
					for(int i = 0 ; i < admins[thisAdminIndex].request.length ; i++)
					{
						if(admins[thisAdminIndex].request[i].status.equals(Request.Status.Completed))
						{
							admins[thisAdminIndex].request[i].user.getUserProf();
							
							System.out.printf("\nRequest Text : \n%s\n",admins[thisAdminIndex].request[i].text) ;
							noCompleted = false ;
						}
					}
					
					if(noCompleted)
					{
						System.out.println("There are not any completed requests") ;
					}
				}
			}
			else
			{
				System.out.println("Wrong input") ;
			}
		}
		else if(option1 == 3)
		{
			thisAdminIndex = -1 ;
			thisUserIndex = -1 ;
		}
		else
		{
			System.out.println("Wrong input") ;
		}
		
		if(thisUserIndex == -1)
		{
			return -1 ;
		}
		else
		{
			return thisUserIndex ;
		}
	}
	
	public static void main(String[] args)
	{		
		
		//addData() ;
		addManyData() ;
		
		createUser("Stelios", "Tzakas", "Username", "Password", "mail", 2102752883, LocalDateTime.now(),'C') ;
		users[users.length - 1].wallet = new Wallet( 500000, users[users.length - 1] );
		customers[customers.length - 1].wallet = new Wallet( 500000, users[users.length - 1] );
		Card a = new Card(Card.CardType.credit, 25454, 999, "Name", LocalDateTime.now(), 1000000) ;
		users[users.length - 1].addCard(a);
		customers[customers.length - 1].addCard(a);
		
		createUser("Antonis", "Mpatzo", "Uname", "Pword", "mail", 2102703283, LocalDateTime.now(),'O') ;
		users[users.length - 1].wallet = new Wallet( 500, users[users.length - 1] );
		owners[owners.length - 1].wallet = new Wallet( 500, users[users.length - 1] );
		Card b1 = new Card(Card.CardType.credit, 25454, 999, "Name", LocalDateTime.now(), 23600) ;
		users[users.length - 1].addCard(b1);
		owners[owners.length - 1].addCard(b1);
		
		createUser("Antonis", "Mpatzo", "Admin", "Pass", "mail", 2102752783, LocalDateTime.now(),'A') ;
		do
		{
			preLogForm() ;
		}while(true) ;
		

		
		
	}
}
