package com.javacardgame.cardgame.deck;
import java.util.*;
import com.javacardgame.cardgame.card.*;
/*
 * @author Eric Fletcher
 * @author Prady Rao
 * @date April 10 2018
 * Private project done to increase understanding of Java FX
 * Supportive non interactive player cards for Quest of the Round Table
 */
//shields and 1 or 0 rank
//shields not acquired and acquired are both suppose to be visible
public class Table extends Deck{
	static ArrayList<Card> x = new ArrayList<Card>(10);
	static Card rank;
	/*
	 * Makes a standard deck
	 */
	public Table() {
		super(x);
	}
}