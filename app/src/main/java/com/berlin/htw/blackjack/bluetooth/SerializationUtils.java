package com.berlin.htw.blackjack.bluetooth;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtils {

    public static byte[] serializeExample(int intValue, String stringValue, boolean boolValue) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeInt(intValue);
        oos.writeUTF(stringValue);
        oos.writeBoolean(boolValue);
        oos.close();
        return baos.toByteArray();
    }

    public static Object[] deserializeExample(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        int intValue = ois.readInt();
        String stringValue = ois.readUTF();
        boolean boolValue = ois.readBoolean();
        ois.close();
        return new Object[]{intValue, stringValue, boolValue};
    }
}
