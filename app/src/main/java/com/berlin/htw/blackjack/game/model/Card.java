package com.berlin.htw.blackjack.game.model;

/**
 * The type Card.
 */
public class Card implements CardInterface {
    private String value;
    private String type;
    private boolean isAce;

    /**
     * Instantiates a new Card.
     *
     * @param value the value
     * @param type  the type
     */
    public Card(String value, String type) {
        this.value = value;
        this.type = type;

    }

    @Override
    public int getValue() {
        if ("AJQK".contains(value)) {
            if (value.equals("A")) {
                return 11;
            }
            return 10;
        }
        return Integer.parseInt(value);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isAce() {
        return value.equals("A");
    }

    @Override
    public String toString() {
        return value + "_" + type;
    }

    /**
     * Gets image path.
     *
     * @return the image path
     */
    public String getImagePath() {

        return "card_" + value.toLowerCase() + "_" + type.toLowerCase();
    }

}
