package application;

public abstract class Player {

	CardDeck cardDeck;

	boolean isEnd = false;
	int sumOfPoints;
	Card[] cards;
	int lastCardIndex;

	public Player(){
		cardDeck = CardDeck.getInstance();
		cards = new Card[10];
		lastCardIndex = 0;
		sumOfPoints = 0;
		cards = new Card[10];
	}

	public void addCard(){
		cards[lastCardIndex] = cardDeck.getCard();
		lastCardIndex++;
	}

	public Card getGamerCard(int index){
		if (cards[index]!=null){
			return cards[index];
		}
		return null;
	}

	public void setEnd(){
		isEnd = true;
	}

public boolean isEnd(){
		return isEnd;
	}

	protected int calculateValue(){
		int result1=0;
		for(int i=0;i<lastCardIndex;i++){
			result1 += cards[i].getValue();
		}

		int result2 = 0;

		for(int i=0;i<lastCardIndex;i++){
			if(cards[i].getValue()==11)
				result2++;
			else
			result2 += cards[i].getValue();
		}

		return Math.max(result1,result2)>21? Math.min(result1, result2) :Math.max(result1, result2);
	}


}
