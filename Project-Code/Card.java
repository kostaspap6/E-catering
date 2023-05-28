
import java.time.LocalDateTime;

public class Card 
{
	
	enum CardType {credit, debit} ;
	CardType cardType ;
	int cardNumber,cVV ;
	String cardOwnerName ;
	LocalDateTime cardDate ;
	float amount ;
	
	public Card(CardType CardType, int CardNumber, int CVV, String CardOwnerName, LocalDateTime CardDate, float Amount)
	{
		this.cardType = CardType ;
		this.cardNumber = CardNumber ;
		this.cVV = CVV ;
		this.cardOwnerName = CardOwnerName ;
		this.cardDate = CardDate ;
		this.amount = Amount ;
	}
	
	public void viewCard()
	{
		System.out.printf("%s\n%d\n%d\n%s\n",cardType,cardNumber,cVV,cardOwnerName) ;
	}
	
}
