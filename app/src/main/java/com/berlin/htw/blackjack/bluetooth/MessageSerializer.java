package com.berlin.htw.blackjack.bluetooth;

import net.sharksystem.asap.ASAPException;
import net.sharksystem.asap.utils.ASAPSerialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MessageSerializer implements Message {
    private String recipient;
    private String message;
    private byte[] serializedMessage;

    public MessageSerializer(String recipient, String message) throws IOException {
        this.recipient = recipient;
        this.message = message;
        this.serialize();
    }

    public MessageSerializer(byte[] serializedMessage) throws IOException, ASAPException {
        this.serializedMessage = serializedMessage;
        this.deserialize();
    }

    private void serialize() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ASAPSerialization.writeCharSequenceParameter(this.recipient, baos);
        ASAPSerialization.writeCharSequenceParameter(this.message, baos);
        this.serializedMessage = baos.toByteArray();
    }

    private void deserialize() throws IOException, ASAPException {
        InputStream is = new ByteArrayInputStream(this.serializedMessage);
        this.recipient = ASAPSerialization.readCharSequenceParameter(is);
        this.message = ASAPSerialization.readCharSequenceParameter(is);
    }

    @Override
    public String getRecipient() {
        return this.recipient;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public byte[] getSerializedMessage() {
        return this.serializedMessage;
    }
}
