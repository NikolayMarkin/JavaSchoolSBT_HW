package ru.sbt.net;

import ru.sbt.serialization.SerializationUtils;

import java.io.*;
import java.net.Socket;

public class NetworkUtils {
    public static <T extends Serializable> void sendObject(Socket socket, T object) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(SerializationUtils.serializeToByte(object));
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось записать данные в сокет", e);
        }
    }

    public static <T extends Serializable> T getDataFromSocket(Socket server) {
        try {
            InputStream inputStream = server.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] data = new byte[1024];

            int nRead;
            while ((nRead = inputStream.read(data, 0, data.length)) > 0) {
                nRead = inputStream.read(data, 0, data.length);
                buffer.write(data, 0, nRead);
            }
            buffer.flush();

            return SerializationUtils.deserialize(buffer.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Не удалось считать данные из сокета", e);
        }
    }
}
