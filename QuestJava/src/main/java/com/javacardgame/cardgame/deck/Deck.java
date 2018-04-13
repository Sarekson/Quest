package com.javacardgame.cardgame.deck;
import java.util.*;
import com.javacardgame.cardgame.card.*;
/*
 * @author Eric Fletcher
 * @author Prady Rao
 * @date April 10 2018
 * Private project done to increase understanding of Java FX
 * Base deck for Quest of the Round Table
 */
//super deck class
//need to make RankPile - rest of rank cards not in table
//             Play - quest stages piles
public abstract class Deck {
	private static ArrayList<Card> x;
	/*
	 * Makes a standard deck
	 * @param ArrayList is the deck
	 */
	public Deck(ArrayList<Card> x) {
		Deck.x = x;
	}
	/*
	 * @return ArrayList deck of cards
	 */
	public ArrayList<Card> getX() {
		return x;
	}
	/*
	 * @param ArrayList new deck of cards
	 */
	public static void setX(ArrayList<Card> x) {
		Deck.x = x;
	}
}