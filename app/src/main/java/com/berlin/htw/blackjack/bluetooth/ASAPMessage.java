package com.berlin.htw.blackjack.bluetooth;

import net.sharksystem.asap.ASAPHop;
import net.sharksystem.asap.ASAPMessageReceivedListener;
import net.sharksystem.asap.ASAPMessages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * The type Asap message.
 */
public class ASAPMessage implements ASAPMessageReceivedListener {
    private final String peerName;

    /**
     * Instantiates a new Asap message.
     *
     * @param peerName the peer name
     */
    ASAPMessage(String peerName) {
        this.peerName = peerName;
    }

    @Override
    public void asapMessagesReceived(ASAPMessages messages, String s, List<ASAPHop> list) throws IOException {
        CharSequence format = messages.getFormat();
        CharSequence uri = messages.getURI();
        if (peerName != null) {
            System.out.print(peerName);
        }

        System.out.println("asap message received (" + format + " | " + uri + "). size == " + messages.size());
        Iterator<byte[]> yourPDUIter = messages.getMessages();
        while (yourPDUIter.hasNext()) {
            //   TestUtils.deserializeExample(yourPDUIter.next());
        }
    }

}
