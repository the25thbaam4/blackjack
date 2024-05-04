package com.berlin.htw.blackjack.game;

public class Card {
    private String value;
    private String type;

    Card (String value, String type){
        this.value = value;
        this.type = type;

    }

    public String toString(){
        return "("+value + "-" + type+")" + " ";
    }


}
