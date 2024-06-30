package com.berlin.htw.blackjack.bluetooth;

public class MessageImpl implements Message {
    private String recipient;
    private String message;

    public MessageImpl(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public String getRecipient() {
        return recipient;
    }

    @Override
    public String getMessage() {
        return message;
    }
}