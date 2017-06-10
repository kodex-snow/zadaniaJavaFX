package kot.kotsnow.ookEditor;

public class Positions{
	private int startPosition;
	private int endPosition;

	static final boolean POSITION_SET=true;
	final static int NO_AVAILABLE_MATCHES = -1;

	private boolean isPositionSet = !POSITION_SET;

	public Positions() {
		startPosition=0;
		endPosition=NO_AVAILABLE_MATCHES;
	}



	int getStartPosition() {
		return startPosition;
	}

	int getEndPosition(){
		return endPosition;
	}

	 void setPositions(int start, int end){
		startPosition = start;
		endPosition = end;
		isPositionSet=POSITION_SET;
	}

	boolean isPositionsSet(){
		return isPositionSet;
	}

	void unsetPosition(){
		startPosition=0;
		endPosition=NO_AVAILABLE_MATCHES;
		isPositionSet=!POSITION_SET;

	}

	int length(){
		return endPosition-startPosition;
	}

}