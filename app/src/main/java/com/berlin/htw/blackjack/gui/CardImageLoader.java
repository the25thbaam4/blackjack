package com.berlin.htw.blackjack.gui;

import android.content.Context;
import android.widget.ImageView;

public class CardImageLoader {
    public static void loadCardImage(Context context, ImageView imageView, String cardName) {
        // Assuming cardName is in the format "10-C.png", "A-D.png", etc.
        String imageName = cardName.substring(0, cardName.lastIndexOf(".")); // Remove file extension
        int imageResource = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

        if (imageResource != 0) {
            imageView.setImageResource(imageResource);
        } else {
            // Handle case where resource is not found
        }
    }
}
