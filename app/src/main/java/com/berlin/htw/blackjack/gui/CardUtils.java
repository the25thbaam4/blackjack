package com.berlin.htw.blackjack.gui;

import android.content.Context;

import com.berlin.htw.blackjack.game.model.Card;

/**
 * The type Card utils.
 */
public class CardUtils {

    /**
     * Gets card resource id.
     *
     * @param context the context
     * @param card    the card
     * @return the card resource id
     */
    public static int getCardResourceId(Context context, Card card) {
        String resourceName = card.getImagePath();
        return context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
    }
}

