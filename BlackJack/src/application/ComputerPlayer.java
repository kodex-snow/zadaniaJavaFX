package application;

public class ComputerPlayer extends Player {

	int lastShowCardIndex;

	public ComputerPlayer() {
		super();
		lastShowCardIndex=-1;
	}

	public void showCard(){
		lastShowCardIndex++;
	}
	@Override
	public Card getGamerCard(int index){
		if (cards[index]!=null){
			return cards[index];
		}
		return null;
	}

	public boolean isShow(int cardIndex){
		if(cardIndex<=lastShowCardIndex)
			return true;
		return false;
	}

	public void play() {
		lastShowCardIndex=10;
		if (calculateValue()>=17){
			setEnd();
		}
		else
			addCard();
	}

}
