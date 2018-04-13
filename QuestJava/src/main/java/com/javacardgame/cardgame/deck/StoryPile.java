package com.javacardgame.cardgame.deck;
import java.util.*;
import com.javacardgame.cardgame.card.*;
/*
 * @author Eric Fletcher
 * @author Prady Rao
 * @date April 10 2018
 * Private project done to increase understanding of Java FX
 * Story card deck for Quest of the Round Table
 */
public class StoryPile extends Deck{
	static ArrayList<Card> x = new ArrayList<Card>(28);
	/*
	 * Makes a standard deck
	 * @param boolean determines if deck is full or empty
	 */
	public StoryPile(boolean d) {
		super(x);
		if (d) {
			initPile();
			Collections.shuffle(x);
			super.setX(x);
		}
	}
	//Going to compact this after fixes made to card types
	//change effects to be index numbers controlled by switch case
	//shields stored as bp with isShield set true
	//enemies strong is stored in foes not quest like allies
	public void initPile() {
		StoryCard tmpCard;
		tmpCard = new EventCard(9,"Event","Chivalrous Deed","",3,true,false,false);
		x.add(tmpCard);
		tmpCard = new EventCard(10,"Event","Pox","",-1,true,false,false);
		x.add(tmpCard);
		tmpCard = new EventCard(11,"Event","Plague","",-2,true,false,false);
		x.add(tmpCard);
		tmpCard = new EventCard(11,"Event","King's Call to Arms","",-1,-2,false,true,false);
		x.add(tmpCard);
		tmpCard = new EventCard(12,"Event","Prosperity Throughout the Realm","",2,false,true,false);
		x.add(tmpCard);
		tmpCard = new QuestCard("Quest","Journey Through the Enchanted Forest","",3);
		x.add(tmpCard);
		tmpCard = new QuestCard("Quest","Search for the Questing Beast","",4);
		x.add(tmpCard);
		tmpCard = new QuestCard("Quest","Defend the Queen's Honor","",4);
		x.add(tmpCard);
		tmpCard = new QuestCard("Quest","Slay the Dragon","",3);
		x.add(tmpCard);
		tmpCard = new QuestCard("Quest","Rescue the Fair Maiden","",3);
		x.add(tmpCard);
		tmpCard = new QuestCard("Quest","Search for the Holy Grail","",5);
		x.add(tmpCard);
		tmpCard = new QuestCard("Quest","Test of the Green Knight","",4);
		x.add(tmpCard);
		tmpCard = new TournamentCard(19,"Tournament","At Camelot","",3);
		x.add(tmpCard);
		tmpCard = new TournamentCard(19,"Tournament","At Orkney","",2);
		x.add(tmpCard);
		tmpCard = new TournamentCard(19,"Tournament","At Tintagel","",1);
		x.add(tmpCard);
		tmpCard = new TournamentCard(19,"Tournament","At York","",0);
		x.add(tmpCard);
		for (int i=0;i<2;i++) {
			tmpCard = new EventCard(20,"Event","King's Recoginiton","",2,true,false,false);
			x.add(tmpCard);
			tmpCard = new EventCard(21,"Event","Queen's Favor","",2,false,true,false);
			x.add(tmpCard);
			tmpCard = new EventCard(12,"Event","Court Called to Camelot","",-10,false,false,true);
			x.add(tmpCard);
			tmpCard = new QuestCard("Quest","Vanquish King Arthur's Enemies","",3);
			x.add(tmpCard);
			tmpCard = new QuestCard("Quest","Repel the Saxons Raiders","",2);
			x.add(tmpCard);
			tmpCard = new QuestCard("Quest","Boar Hunt","",2);
			x.add(tmpCard);
		}
	}
}
