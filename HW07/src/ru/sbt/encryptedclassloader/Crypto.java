package ru.sbt.encryptedclassloader;

import java.io.IOException;
import java.nio.file.*;

public class Crypto {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:/Data/java_projects/JavaSchoolSBT_HW/HW07/classes/ru/sbt/encryptedclassloader", "TestImpl.class");

        byte key = 17;
        byte[] data = Files.readAllBytes(path);

        for (int i = 0; i < data.length; i++) {
            data[i] = (byte)(data[i] ^ key);
        }

        Files.write(path, data, StandardOpenOption.WRITE);
    }
}
