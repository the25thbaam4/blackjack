package com.berlin.htw.blackjack.bluetooth;

import net.sharksystem.asap.ASAPPeer;

/**
 * The type Asap class.
 */
public class ASAPClass {
    /**
     * The Blackjack.
     */
    static final CharSequence BLACKJACK = "application/x-blackjack";
    /**
     * The Game uri.
     */
    static final CharSequence GAME_URI = "://game_data";
    private ASAPPeer playerOne;

    /**
     * Instantiates a new Asap class.
     *
     * @param asapPeer the asap peer
     */
    public ASAPClass(ASAPPeer asapPeer) {
        this.playerOne = asapPeer;
    }
}
