package com.berlin.htw.blackjack.bluetooth;

import android.app.Activity;

import com.berlin.htw.blackjack.game.BlackJackGame;

import net.sharksystem.asap.ASAP;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The type Bt game.
 */
public class BTGame extends BlackJackGame {
    /**
     * The constant ASAP_Messenger.
     */
    public static final String ASAP_Messenger = "ASAP_MESSENGER";
    private CharSequence id;
    /**
     * The Instance.
     */
    static BTGame instance;

    /**
     * Instantiates a new Bt game.
     *
     * @param supportedFormats the supported formats
     * @param initialActivity  the initial activity
     */
    protected BTGame(Collection<CharSequence> supportedFormats, Activity initialActivity) {
        //super(supportedFormats, initialActivity);
        this.id = ASAP.createUniqueID();
    }

    /**
     * Application instance bt game.
     *
     * @param initialActivity the initial activity
     * @return the bt game
     */
    public static BTGame applicationInstance(Activity initialActivity) {
        if (BTGame.instance == null) {
            Collection<CharSequence> formats = new ArrayList<>();
            formats.add(ASAP_Messenger);

            BTGame.instance = new BTGame(formats, initialActivity);
            BTGame.instance.startGame();
        }

        return BTGame.instance;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static BTGame getInstance() {
        return instance;
    }

    /**
     * Gets owner id.
     *
     * @return the owner id
     */
    public CharSequence getOwnerID() {
        return this.id;
    }
}
