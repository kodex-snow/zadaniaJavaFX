package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameController implements Initializable {

	@FXML
	Label result;
	@FXML
	Label player_score;
	@FXML
	Label computer_score;

	@FXML
	ImageView card1_comp;
	@FXML
	ImageView card2_comp;
	@FXML
	ImageView card3_comp;
	@FXML
	ImageView card4_comp;
	@FXML
	ImageView card5_comp;
	@FXML
	ImageView card6_comp;
	@FXML
	ImageView card7_comp;
	@FXML
	ImageView card8_comp;
	@FXML
	ImageView card9_comp;
	@FXML
	ImageView card10_comp;

	@FXML
	ImageView card1_player;
	@FXML
	ImageView card2_player;
	@FXML
	ImageView card3_player;
	@FXML
	ImageView card4_player;
	@FXML
	ImageView card5_player;
	@FXML
	ImageView card6_player;
	@FXML
	ImageView card7_player;
	@FXML
	ImageView card8_player;
	@FXML
	ImageView card9_player;
	@FXML
	ImageView card10_player;

	final int GAME_IN_PROGRESS=0;
	final int PLAYER_WIN=1;
	final int COMPUTER_WIN=2;
	final int REMIS=3;

	CardDeck cardDeck;
	ComputerPlayer computer;
	HumanPlayer player;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		startGame();
	}

	public GameController(){
		cardDeck = CardDeck.getInstance();
		computer = new ComputerPlayer();
		player = new HumanPlayer();

	}
	public void startGame(){

		result.setText("Wynik: ---");
		computer = new ComputerPlayer();
		player = new HumanPlayer();

		cardDeck.shuffle();
		computer.addCard();
		computer.addCard();
		computer.showCard();
		player.addCard();
		player.addCard();
		checkResult();
		refreshCards();
		computer_score.setText("---");
		}

	public void hit (){

		if(checkResult()==GAME_IN_PROGRESS){
			player.addCard();
			refreshCards();
		}

		if(checkResult()==GAME_IN_PROGRESS){
		computer.play();
		refreshCards();
		}

		if(checkResult()==COMPUTER_WIN)
			lose();
		 else if(checkResult()==PLAYER_WIN)
			win();
		 if(checkResult()==REMIS)
			remis();
	}

	public void pass(){
		
			player.setEnd();
			while(checkResult()==GAME_IN_PROGRESS){
				computer.play();
				refreshCards();
			}
			if(checkResult()==COMPUTER_WIN)
				lose();
			 else if(checkResult()==PLAYER_WIN)
				win();
			 if(checkResult()==REMIS)
				remis();
			
		
	}

	private void win(){
		result.setText("WYNIK : wygrana");
	}

	private void lose(){
		result.setText("WYNIK : przegrana");
	}

	private void remis(){
		result.setText("WYNIK : remis");
	}


	private int checkResult(){

		int computer_result = computer.calculateValue();
		int player_result = player.calculateValue();

		if(player_result>21 && computer_result<22)
			return COMPUTER_WIN;
		
		if(computer_result>21 && player_result<22)
			return PLAYER_WIN;

		if(player.isEnd&&computer.isEnd){
			
			if(computer_result==player_result)
				return REMIS;
			else if (computer_result>player_result)
				return COMPUTER_WIN;
			else
				return PLAYER_WIN;
		}

		return GAME_IN_PROGRESS;
	}

	private void refreshCards(){

		player_score.setText("Twoje punkty: "+player.calculateValue());
		computer_score.setText("Punkty krupiera: "+computer.calculateValue());



		if(player.getGamerCard(0)!=null)
			card1_player.setImage(new Image(player.getGamerCard(0).cardimg()));
		else
			card1_player.setImage(new Image("null_of_card.png"));


		if(computer.getGamerCard(0)==null)
			card1_comp.setImage(new Image("null_of_card.png"));
		else if(computer.isShow(0)==false){
			card1_comp.setImage(new Image("unknown_of_card.png"));
		}else
			card1_comp.setImage(new Image(computer.getGamerCard(0).cardimg()));



		if(player.getGamerCard(1)!=null)
			card2_player.setImage(new Image(player.getGamerCard(1).cardimg()));
		else
			card2_player.setImage(new Image("null_of_card.png"));

		if(player.getGamerCard(2)!=null)
			card3_player.setImage(new Image(player.getGamerCard(2).cardimg()));
		else
			card3_player.setImage(new Image("null_of_card.png"));

		if(player.getGamerCard(3)!=null)
			card4_player.setImage(new Image(player.getGamerCard(3).cardimg()));
		else
			card4_player.setImage(new Image("null_of_card.png"));

		if(player.getGamerCard(4)!=null)
			card5_player.setImage(new Image(player.getGamerCard(4).cardimg()));
		else
			card5_player.setImage(new Image("null_of_card.png"));

		if(player.getGamerCard(5)!=null)
			card6_player.setImage(new Image(player.getGamerCard(5).cardimg()));
		else
			card6_player.setImage(new Image("null_of_card.png"));

		if(player.getGamerCard(6)!=null)
			card7_player.setImage(new Image(player.getGamerCard(6).cardimg()));
		else
			card7_player.setImage(new Image("null_of_card.png"));

		if(player.getGamerCard(7)!=null)
			card8_player.setImage(new Image(player.getGamerCard(7).cardimg()));
		else
			card8_player.setImage(new Image("null_of_card.png"));

		if(player.getGamerCard(8)!=null)
			card9_player.setImage(new Image(player.getGamerCard(8).cardimg()));
		else
			card9_player.setImage(new Image("null_of_card.png"));

		if(player.getGamerCard(9)!=null)
			card10_player.setImage(new Image(player.getGamerCard(9).cardimg()));
		else
			card10_player.setImage(new Image("null_of_card.png"));

		if(computer.getGamerCard(1)==null)
			card2_comp.setImage(new Image("null_of_card.png"));
		else if(computer.isShow(1)==false){
			card2_comp.setImage(new Image("unknown_of_card.png"));
		}else
			card2_comp.setImage(new Image(computer.getGamerCard(1).cardimg()));
		if(computer.getGamerCard(2)==null)
			card3_comp.setImage(new Image("null_of_card.png"));
		else if(computer.isShow(2)==false){
			card3_comp.setImage(new Image("unknown_of_card.png"));
		}else
			card3_comp.setImage(new Image(computer.getGamerCard(2).cardimg()));
		if(computer.getGamerCard(3)==null)
			card4_comp.setImage(new Image("null_of_card.png"));
		else if(computer.isShow(3)==false){
			card4_comp.setImage(new Image("unknown_of_card.png"));
		}else
			card4_comp.setImage(new Image(computer.getGamerCard(3).cardimg()));
		if(computer.getGamerCard(4)==null)
			card5_comp.setImage(new Image("null_of_card.png"));
		else if(computer.isShow(4)==false){
			card5_comp.setImage(new Image("unknown_of_card.png"));
		}else
			card5_comp.setImage(new Image(computer.getGamerCard(4).cardimg()));
		if(computer.getGamerCard(5)==null)
			card6_comp.setImage(new Image("null_of_card.png"));
		else if(computer.isShow(5)==false){
			card6_comp.setImage(new Image("unknown_of_card.png"));
		}else
			card6_comp.setImage(new Image(computer.getGamerCard(5).cardimg()));
		if(computer.getGamerCard(6)==null)
			card7_comp.setImage(new Image("null_of_card.png"));
		else if(computer.isShow(6)==false){
			card7_comp.setImage(new Image("unknown_of_card.png"));
		}else
			card7_comp.setImage(new Image(computer.getGamerCard(6).cardimg()));
		if(computer.getGamerCard(7)==null)
			card8_comp.setImage(new Image("null_of_card.png"));
		else if(computer.isShow(7)==false){
			card8_comp.setImage(new Image("unknown_of_card.png"));
		}else
			card8_comp.setImage(new Image(computer.getGamerCard(7).cardimg()));
		if(computer.getGamerCard(8)==null)
			card9_comp.setImage(new Image("null_of_card.png"));
		else if(computer.isShow(8)==false){
			card9_comp.setImage(new Image("unknown_of_card.png"));
		}else
			card9_comp.setImage(new Image(computer.getGamerCard(8).cardimg()));

		if(computer.getGamerCard(9)==null)
			card10_comp.setImage(new Image("null_of_card.png"));
		else if(computer.isShow(9)==false){
			card10_comp.setImage(new Image("unknown_of_card.png"));
		}else
			card10_comp.setImage(new Image(computer.getGamerCard(9).cardimg()));

	} }

