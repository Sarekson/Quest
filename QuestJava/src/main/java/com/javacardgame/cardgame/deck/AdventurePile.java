package com.javacardgame.cardgame.deck;
import java.util.*;
import com.javacardgame.cardgame.card.*;
/*
 * @author Eric Fletcher
 * @author Prady Rao
 * @date April 10 2018
 * Private project done to increase understanding of Java FX
 * Adventure card deck for Quest of the Round Table
 */
public class AdventurePile extends Deck{
	static ArrayList<Card> x = new ArrayList<Card>(125);
	/*
	 * Makes a standard deck
	 * @param boolean determines if deck is full or empty
	 */
	public AdventurePile(boolean d) {
		super(x);
		
		if (d) {
			initPile();
			Collections.shuffle(x);
			super.setX(x);
		}
	}
	//Going to compact this after fixes made to card types
	//change effects to be index numbers controlled by switch case
	//Bonus bp is stored as bp2 and bonus bid is also stored this way but with isBid true
	//Bid limit is stored as bp with isBidLimit set to true
	//bonus bp is stored as inc between the two
	public void initPile() {
		AdventureCard tmpCard;
		tmpCard = new AllyCard(1,"Ally","Sir Gawain","",10,10);
		x.add(tmpCard);
		tmpCard = new AllyCard(2,"Ally","King Pellinore","",true,true,10,4);
		x.add(tmpCard);
		tmpCard = new AllyCard(3,"Ally","Sir Percival","",5,15);
		x.add(tmpCard);
		tmpCard = new AllyCard(4,"Ally","Sir Tristan","",10,10);
		x.add(tmpCard);
		tmpCard = new AllyCard("Ally","King Arthur","",true,true,10,2);
		x.add(tmpCard);
		tmpCard = new AllyCard("Ally","Queen Guinevere","",true,3);
		x.add(tmpCard);
		tmpCard = new AllyCard(5,"Ally","Merlin","");
		x.add(tmpCard);
		tmpCard = new AllyCard(6,"Ally","Queen Iseult","",true,2,1);
		x.add(tmpCard);
		tmpCard = new AllyCard(7,"Ally","Sir Lancelot","",15,10);
		x.add(tmpCard);
		tmpCard = new AllyCard("Ally","Sir Galahad","",15);
		x.add(tmpCard);
		tmpCard = new FoeCard(14,"Foe","Dragon","",50,70);
		x.add(tmpCard);
		for (int i=0;i<16;i++) {
			tmpCard = new WeaponCard("Weapon","Sword","",10);
			x.add(tmpCard);
		}
		for (int i=0;i<11;i++) {
			tmpCard = new WeaponCard("Weapon","Horse","",10);
			x.add(tmpCard);
		}
		for (int i=0;i<8;i++) {
			tmpCard = new AmourCard("Amour","","",true,true,10,1);
			x.add(tmpCard);
			tmpCard = new FoeCard("Foe","Thieves","",5);
			x.add(tmpCard);
			tmpCard = new FoeCard(15,"Foe","Saxon Knight","",15,25);
			x.add(tmpCard);
			tmpCard = new WeaponCard("Weapon","Battle-ax","",15);
			x.add(tmpCard);
		}
		for (int i=0;i<7;i++) {
			tmpCard = new FoeCard("Foe","Robber Knight","",15);
			x.add(tmpCard);
		}
		for (int i=0;i<6;i++) {
			tmpCard = new FoeCard(13,"Foe","Evil Knight","",20,30);
			x.add(tmpCard);
			tmpCard = new WeaponCard("Weapon","Dagger","",5);
			x.add(tmpCard);
			tmpCard = new WeaponCard("Weapon","Lance","",20);
			x.add(tmpCard);
		}
		for (int i=0;i<5;i++) {
			tmpCard = new FoeCard(15,"Foe","Saxons","",10,20);
			x.add(tmpCard);
			tmpCard = new FoeCard(8,"Foe","Mordred","",30);
			x.add(tmpCard);
		}
		for (int i=0;i<4;i++) {
			tmpCard = new FoeCard(16,"Foe","Boar","",5,15);
			x.add(tmpCard);
		}
		for (int i=0;i<3;i++) {
			tmpCard = new FoeCard(17,"Foe","Black Knight","",25,35);
			x.add(tmpCard);
		}
		for (int i=0;i<2;i++) {
			tmpCard = new FoeCard(18,"Foe","Green Knight","",25,40);
			x.add(tmpCard);
			tmpCard = new FoeCard("Foe","Giant","",40);
			x.add(tmpCard);
			tmpCard = new TestCard(true,"Test","Test of the Questing Beast","",4);
			x.add(tmpCard);
			tmpCard = new TestCard("Test","Test of Temptation","");
			x.add(tmpCard);
			tmpCard = new TestCard("Test","Test of Valor","");
			x.add(tmpCard);
			tmpCard = new TestCard(true,"Test","Test of Morgan Le Fey","",3);
			x.add(tmpCard);
			tmpCard = new WeaponCard("Weapon","Excalibur","",30);
			x.add(tmpCard);
		}
	}
}