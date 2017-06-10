package application;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CardDeck {

	Card[] cards;
	int deckSize = 52;

	private static CardDeck INSTANCE;

    private CardDeck(){}

    public static CardDeck getInstance(){
        if(INSTANCE==null)
            INSTANCE = new CardDeck();
        return INSTANCE;
    }

	Random rand = ThreadLocalRandom.current();

	public void shuffle(){
		cards = Card.getAllCards();//???

	    for (int i = cards.length - 1; i > 0; i--){
	      int index = rand.nextInt(i + 1);

	      Card pom = cards[index];
	      cards[index] = cards[i];
	      cards[i] = pom;
	    }
	}

	public Card getCard(){
		Card card = cards[deckSize-1];
		deckSize--;
		System.out.println(cards[deckSize-1]);
		return card;
	}

}
