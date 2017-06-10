package application;

public enum Card {

two_of_clubs (2,"2_of_clubs.png"),
two_of_diamonds(2,"2_of_diamonds.png"),
two_of_hearts (2,"2_of_diamonds.png"),
two_of_spades (2,"2_of_diamonds.png"),

three_of_clubs (3,"3_of_clubs.png"),
three_of_diamonds(3,"3_of_clubs.png"),
three_of_hearts(3,"3_of_clubs.png"),
three_of_spades(3,"3_of_clubs.png"),

four_of_clubs (4,"4_of_clubs.png"),
four_of_diamonds(4,"4_of_clubs.png"),
four_of_hearts(4,"4_of_clubs.png"),
four_of_spades(4,"4_of_clubs.png"),

five_of_clubs (5,"5_of_clubs.png"),
five_of_diamonds(5,"5_of_clubs.png"),
five_of_hearts(5,"5_of_clubs.png"),
five_of_spades(5,"5_of_clubs.png"),

six_of_clubs (6,"6_of_clubs.png"),
six_of_diamonds(6,"6_of_clubs.png"),
six_of_hearts(6,"6_of_clubs.png"),
six_of_spades(6,"6_of_clubs.png"),

seven_of_clubs (7,"7_of_clubs.png"),
seven_of_diamonds(7,"7_of_clubs.png"),
seven_of_hearts(7,"7_of_clubs.png"),
seven_of_spades(7,"7_of_clubs.png"),

eight_of_clubs (8,"8_of_clubs.png"),
eight_of_diamonds(8,"8_of_clubs.png"),
eight_of_hearts(8,"8_of_clubs.png"),
eight_of_spades(8,"8_of_clubs.png"),

nine_of_clubs (9,"9_of_clubs.png"),
nine_of_diamonds(9,"9_of_clubs.png"),
nine_of_hearts(9,"9_of_clubs.png"),
nine_of_spades (9,"9_of_clubs.png"),

ten_of_clubs (10,"10_of_clubs.png"),
ten_of_diamonds(10,"10_of_clubs.png"),
ten_of_hearts(10,"10_of_clubs.png"),
ten_of_spades(10,"10_of_clubs.png"),

ace_of_clubs (11,"ace_of_clubs.png"),
ace_of_diamonds(11,"ace_of_diamonds.png"),
ace_of_hearts(11,"ace_of_hearts.png"),
ace_of_spades(11,"ace_of_spades.png"),

jack_of_clubs (10,"4_of_clubs.png"),
jack_of_diamonds(10,"jack_of_diamonds.png"),
jack_of_hearts(10,"jack_of_hearts.png"),
jack_of_spades(10,"jack_of_spades.png"),

king_of_clubs (10,"king_of_clubs.png"),
king_of_diamonds(10,"king_of_diamonds.png"),
king_of_hearts(10,"king_of_hearts.png"),
king_of_spades(10,"king_of_spades.png"),

queen_of_clubs (4,"4_of_clubs.png"),
queen_of_diamonds(10,"queen_of_diamonds.png"),
queen_of_hearts(10,"queen_of_hearts.png"),
queen_of_spades(10,"queen_of_spades.png");

    private final String card_img;
    private final int value;

    Card(int value,String card_img) {
       this.value = value;
       this.card_img = card_img;
    }

	public int getValue() {
		return value;
	}

	public String cardimg() {
		return card_img;
	}

	public static Card getCard(String name){

		for(Card card: Card.values()){
			if((card.name().equals(name))){
				return card;
			}

		}
		return two_of_clubs;
	}

	public static Card[] getAllCards(){

		Card [] cards = new Card[52];
		int i = 0;
		for(Card card: Card.values()){
			cards[i] = card;
			i++;
		}
		return cards;
	}

}
