package com.berlin.htw.blackjack.bluetooth;

import net.sharksystem.asap.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ASAPClass implements ASAPPeer {

    private final CharSequence peerID;
    private final Map<CharSequence, ASAPStorage> storageMap;
    private final Map<CharSequence, Boolean> routingAllowedMap;
    private final Map<CharSequence, byte[]> extras;

    public ASAPClass(CharSequence peerID) {
        this.peerID = peerID;
        this.storageMap = new HashMap<>();
        this.routingAllowedMap = new HashMap<>();
        this.extras = new HashMap<>();
    }

    @Override
    public CharSequence getPeerID() {
        return peerID;
    }

    @Override
    public ASAPStorage getASAPStorage(CharSequence id) throws IOException, ASAPException {
        return storageMap.get(id);
    }

    @Override
    public boolean isASAPRoutingAllowed(CharSequence id) throws IOException, ASAPException {
        return routingAllowedMap.getOrDefault(id, ONLINE_EXCHANGE_DEFAULT);
    }

    @Override
    public void setASAPRoutingAllowed(CharSequence id, boolean allowed) throws IOException, ASAPException {
        routingAllowedMap.put(id, allowed);
    }

    @Override
    public boolean samePeer(ASAPPeer peer) {
        return this.peerID.equals(peer.getPeerID());
    }

    @Override
    public boolean samePeer(CharSequence id) {
        return this.peerID.equals(id);
    }

    @Override
    public void putExtra(CharSequence id, byte[] data) throws IOException, ASAPException {
        extras.put(id, data);
    }

    @Override
    public byte[] getExtra(CharSequence id) throws ASAPException, IOException {
        return extras.get(id);
    }

    // Implement listener management methods...
    // For brevity, the implementation of the following methods is omitted
    @Override
    public void addASAPChannelContentChangedListener(CharSequence channel, ASAPChannelContentChangedListener listener) {}
    @Override
    public void removeASAPChannelContentChangedListener(CharSequence channel, ASAPChannelContentChangedListener listener) {}
    @Override
    public void addASAPEnvironmentChangesListener(ASAPEnvironmentChangesListener listener) {}
    @Override
    public void removeASAPEnvironmentChangesListener(ASAPEnvironmentChangesListener listener) {}
    @Override
    public void addASAPMessageReceivedListener(CharSequence channel, ASAPMessageReceivedListener listener) {}
    @Override
    public void removeASAPMessageReceivedListener(CharSequence channel, ASAPMessageReceivedListener listener) {}
    @Override
    public int getNumberListener() {
        return 0;
    }
    @Override
    public void sendASAPMessage(CharSequence app, CharSequence uri, byte[] message) throws ASAPException {}
    @Override
    public void sendTransientASAPMessage(CharSequence app, CharSequence uri, byte[] message) throws ASAPException, IOException {}
}
