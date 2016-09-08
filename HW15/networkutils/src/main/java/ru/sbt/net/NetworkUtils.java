package ru.sbt.net;

import ru.sbt.serialization.SerializationUtils;

import java.io.*;
import java.net.Socket;

public class NetworkUtils {
    public static <T extends Serializable> void sendObject(Socket socket, T object) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(outputStream);
            byte[] buffer = SerializationUtils.serializeToByte(object);

            dos.writeInt(buffer.length);
            dos.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось записать данные в сокет", e);
        }
    }

    public static <T extends Serializable> T getDataFromSocket(Socket socket) {
        try {
            InputStream input = socket.getInputStream();
            DataInputStream dis = new DataInputStream(input);

            int dataLength = dis.readInt();
            byte[] data = new byte[dataLength];
            dis.readFully(data);

            return SerializationUtils.deserialize(data);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось считать данные из сокета", e);
        }
    }
}
