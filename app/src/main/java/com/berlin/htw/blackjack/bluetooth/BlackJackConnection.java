package com.berlin.htw.blackjack.bluetooth;

public interface BlackJackConnection {
    void sendMessage(String recipient, String message);
    void receiveMessage(byte[] data);
    void blockUser(String userID);
}
