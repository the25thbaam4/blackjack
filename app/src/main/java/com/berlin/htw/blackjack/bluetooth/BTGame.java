package com.berlin.htw.blackjack.bluetooth;

import android.app.Activity;

import com.berlin.htw.blackjack.game.BlackJackGame;

import net.sharksystem.asap.ASAP;

import java.util.ArrayList;
import java.util.Collection;

public class BTGame extends BlackJackGame {
    public static final String ASAP_Messenger = "ASAP_MESSENGER";
    private CharSequence id;
    static BTGame instance;

    protected BTGame(Collection<CharSequence> supportedFormats, Activity initialActivity) {
        //super(supportedFormats, initialActivity);
        this.id = ASAP.createUniqueID();
    }

    public static BTGame applicationInstance(Activity initialActivity) {
        if (BTGame.instance == null) {
            Collection<CharSequence> formats = new ArrayList<>();
            formats.add(ASAP_Messenger);

            BTGame.instance = new BTGame(formats, initialActivity);
            BTGame.instance.startGame();
        }

        return BTGame.instance;
    }

    public static BTGame getInstance() {
        return instance;
    }

    public CharSequence getOwnerID() {
        return this.id;
    }
}
