package ru.sbt.serialization;

import java.io.*;

public class SerializationUtils {
    public static byte[] serializeToByte(Serializable o) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream stream = new ObjectOutputStream(bytes)) {
            stream.writeObject(o);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось сериализовать объект", e);
        }
        return bytes.toByteArray();
    }

    public static <T> T deserialize(byte[] bytes) {
        try (ObjectInputStream stream = new ObjectInputStream(
                new ByteArrayInputStream(bytes))) {
            return (T) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Не удалось десериализовать объект", e);
        }
    }
}