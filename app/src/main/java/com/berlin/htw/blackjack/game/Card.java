package com.berlin.htw.blackjack.game;

public class Card {
    private String value;
    private String type;
    private boolean isAce;

    Card (String value, String type){
        this.value = value;
        this.type = type;

    }

    public int getValue() {
        if ("AJQK".contains(value)){
            if (value == "A"){
                return 11;
            }
            return 10;
        }
        return Integer.parseInt(value);
    }


    public boolean isAce(){
        return value.equals("A");
    }

    public String toString(){
        return value + "-" + type;
    }

    public String getImagePath() {
        return "cards/" + toString() + ".png";
    }

}
