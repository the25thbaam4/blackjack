package com.berlin.htw.blackjack.game;

import android.content.Context;

public class Card implements CardInterface{
    private String value;
    private String type;
    private boolean isAce;

    Card (String value, String type){
        this.value = value;
        this.type = type;

    }
    @Override
    public int getValue() {
        if ("AJQK".contains(value)){
            if (value.equals( "A")){
                return 11;
            }
            return 10;
        }
        return Integer.parseInt(value);
    }

    @Override
    public boolean isAce(){
        return value.equals("A");
    }
    @Override
    public String toString(){
        return value + "-" + type;
    }

    public String getImagePath() {

      //  String imageName =  "card_" + value.toLowerCase() + "_" +  type.toLowerCase()  + ".png";
        String imageName = toString();
        return "@drawable/" + imageName;
    }

}
