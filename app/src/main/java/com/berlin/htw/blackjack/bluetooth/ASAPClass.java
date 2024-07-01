package com.berlin.htw.blackjack.bluetooth;

import net.sharksystem.asap.ASAPPeer;

public class ASAPClass  {
    static final CharSequence BLACKJACK = "application/x-blackjack";
    static final CharSequence GAME_URI = "://game_data";
    private ASAPPeer playerOne;
    public ASAPClass (ASAPPeer asapPeer){
        this.playerOne = asapPeer;
    }
}
