
import java.time.LocalDateTime;
import java.util.Scanner ;



public class Wallet 
{
	float amount ;
	User user ;
	Card card ;
	
	public Wallet(float Amount, User User, Card Card)
	{
		this.amount = Amount ;
		this.user = User ;
		addCard(Card) ;
	}
	
	public Wallet(float Amount, User User)
	{
		this.amount = Amount ;
		this.user = User ;
	}
	
	public Wallet()
	{
		this.amount = 0 ;
	}
	
	public void addCard(Card Card)
	{
		this.card = Card ;
	}
	
	public void message()
	{
		System.out.printf("Balance : %.2f\n1 : Deposit\n2 : Withdraw\n",amount) ;
	}
	
	public void deposit()
	{
		Scanner input = new Scanner(System.in) ;
		float transfer ;
		if(card == null)
		{
			System.out.println("There is not a Card connected to your account") ;
		}
		else
		{
			
			Card.CardType cardType = Card.CardType.credit ;
			int cardNumber,cVV ;
			String cardOwnerName ;
			LocalDateTime cardDate = LocalDateTime.now() ;
			
			System.out.printf("1 : credit\n2 : debit\n" ) ;
			int CardType = input.nextInt() ; 
			if(CardType == 1)
			{
				cardType = Card.CardType.credit ;
			}
			else if(CardType == 2)
			{
				cardType = Card.CardType.debit ;
			}
			else
			{
				System.out.println("Wrong input") ;
			}
			
			System.out.printf("Card Number : " ) ;
			input = new Scanner(System.in) ;
			cardNumber = input.nextInt() ;
			
			System.out.printf("CVV : " ) ;
			input = new Scanner(System.in) ;
			cVV = input.nextInt() ;
			
			System.out.printf("Card Owner Name : " ) ;
			input = new Scanner(System.in) ;
			cardOwnerName = input.nextLine() ;
			
			if(card.cardType.equals(cardType) && card.cardNumber == cardNumber && card.cVV == cVV && card.cardOwnerName.equals(cardOwnerName))
			{
				System.out.printf("How many money would you like to deposit : ") ;
				input = new Scanner(System.in) ;
				transfer = input.nextFloat() ;

				if(transfer > card.amount && transfer > 0)
				{
					System.out.println("Insufficient Founds") ;
				}
				else
				{
					card.amount = card.amount - transfer ;
					amount = amount + transfer ;
					System.out.println("\nSuccessful Transaction") ;
					System.out.printf("Wallet amount : %.2f\nCard amount : %.2f\n",amount ,card.amount);
				}
			}
			else
			{
				System.out.println("Your card information are incorrect ") ;
			}
			
		}
	}
	
	public void withdraw()
	{
		Scanner input = new Scanner(System.in) ;
		float transfer ;
		if(card == null)
		{
			System.out.println("There is not a Card connected to your account") ;
		}
		else
		{
			Card.CardType cardType = Card.CardType.credit ;
			int cardNumber,cVV ;
			String cardOwnerName ;
			LocalDateTime cardDate = LocalDateTime.now() ;
			
			System.out.printf("1 : credit\n2 : debit\n" ) ;
			int CardType = input.nextInt() ; 
			if(CardType == 1)
			{
				cardType = Card.CardType.credit ;
			}
			else if(CardType == 2)
			{
				cardType = Card.CardType.debit ;
			}
			else
			{
				System.out.println("Wrong input") ;
			}
			
			System.out.printf("Card Number : " ) ;
			input = new Scanner(System.in) ;
			cardNumber = input.nextInt() ;
			
			System.out.printf("CVV : " ) ;
			input = new Scanner(System.in) ;
			cVV = input.nextInt() ;
			
			System.out.printf("Card Owner Name : " ) ;
			input = new Scanner(System.in) ;
			cardOwnerName = input.nextLine() ;
			
			if(card.cardType.equals(cardType) && card.cardNumber == cardNumber && card.cVV == cVV && card.cardOwnerName.equals(cardOwnerName) )
			{
				System.out.println("How many money would you like to withdraw : ") ;
				transfer = input.nextFloat() ;
				
				if(transfer > amount && transfer > 0)
				{
					System.out.println("Insufficient founds") ;
				}
				else
				{
					card.amount = card.amount + transfer ;
					amount = amount - transfer ;
					System.out.println("\nSuccessful Transaction") ;
					System.out.printf("Wallet amount : %.2f\nCard amount : %.2f\n",amount ,card.amount);
				}
			}
			else
			{
				System.out.println("Your card information are incorrect ") ;
			}
		}
	}
}
