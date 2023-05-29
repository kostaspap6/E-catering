
import java.time.LocalDateTime;
import java.util.Scanner ;

public class Test 
{
	static User[] users ;
	static Store[] stores ;
	static Customer[] customers ;
	static Owner[] owners ;
	static Admin[] admins ;
	
	public static void customerPostLog(int thisUserIndex,int thisCustomerIndex)
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
			thisUserIndex = 0 ;
			
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
				customerPostLog(thisUserIndex,thisCustomerIndex) ;
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
		customers[0].wallet = new Wallet( 5000, users[0] );
		Card a = new Card(Card.CardType.credit, 25454, 999, "Name", LocalDateTime.now(), 20000) ;
		users[0].addCard(a);
		customers[0].addCard(a);
		
		
		
		createUser("Antonis", "Mpatzo", "Uname", "Pword", "mail", 2102752783, LocalDateTime.now(),'O') ;
		users[1].wallet = new Wallet( 500, users[1] );
		owners[0].wallet = new Wallet( 500, users[1] );
		
		createUser("Antonis", "Mpatzo", "Admin", "Pass", "mail", 2102752783, LocalDateTime.now(),'A') ;
		
		//STORE CREATION
		stores = new Store[3] ;
		stores[0] = new Store("Katastima", "Mezonos 3", owners[0]) ;
		owners[0].addStore(stores[0]);
		
		stores[1] = new Store("Katastima", "Mezonos 7", owners[0]) ;
		owners[0].addStore(stores[0]);
		
		stores[2] = new Store("Katastima2", "Mezonos 67", owners[0]) ;
		owners[0].addStore(stores[0]);
		
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
		
		//PRODUCTS CREATION
		Menu.Products[] Prod = {Menu.Products.A , Menu.Products.B , Menu.Products.C , Menu.Products.D} ;
		double[] PRICE = {1,2.3,4,5} ;
		
		//MENU CREATION
		Menu Me = new Menu(Prod, PRICE , stores[1].owner , stores[1]) ;
		stores[1].addMenu(Me);
		
		//RATING CREATION
		Rating S = new Rating(customers[0].order[0].store,customers[0],LocalDateTime.now(), 5);
		customers[0].addRating(customers[0].order[0].store, S);
		customers[0].order[0].store.addRating(S);
		
		//PAYMENT CREATION
		Payment Z = new Payment(customers[0].wallet , LocalDateTime.now(), customers[0].order[0], customers[0].order[0].shoppingCart.price ) ;
		customers[0].order[0].addPayment(Z);
		customers[0].addnewPayment(Z);
		
		
		//FeedBack CREATION
		FeedBack F = new FeedBack(customers[0].order[0].store,customers[0],LocalDateTime.now(),"Feed TEXT");
		customers[0].addFeedBack(customers[0].order[0].store, F);
		customers[0].order[0].store.addFeedBack(F);
		
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
				for(int j = 0 ; j < admins[0].request.length ; j++)
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
		preLogForm() ;
		
		
		
		
	}
}
