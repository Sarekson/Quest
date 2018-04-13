package com.javacardgame.cardgame.card;
/**
 * @author Eric Fletcher
 * @author Prady Rao
 * @date April 10 2018
 * Private project done to increase understanding of Java FX
 * Card template for Quest of the Round Table
 */
public abstract class Card {
	private static String type;
	private static String name;
	private static String image;
	/**
	 * Makes a card with no excess information
	 * @param type
	 * @param name
	 * @param image
	 */
	public Card(String type,String name,String image) {
		Card.type  = type;
		Card.name  = name;
		Card.image = image;
	}
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type
	 */
	public static void setType(String type) {
		Card.type = type;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public static void setName(String name) {
		Card.name = name;
	}
	/**
	 * @return image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image
	 */
	public static void setImage(String image) {
		Card.image = image;
	}
}