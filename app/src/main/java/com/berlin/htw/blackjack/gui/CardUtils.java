package com.berlin.htw.blackjack.gui;

import android.content.Context;

import com.berlin.htw.blackjack.game.model.Card;

public class CardUtils {

    public static int getCardResourceId(Context context, Card card) {
        String resourceName = card.getImagePath();
        return context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
    }
}

