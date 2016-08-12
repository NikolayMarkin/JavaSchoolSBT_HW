package ru.sbt.encryptedclassloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncryptedClassLoader extends ClassLoader {

    private final byte key;
    private final String rootDir;

    public EncryptedClassLoader(byte key, String dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.rootDir = dir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        final Class<?> result;
        try {
            String classPath = name.replace('.', '/').concat(".class");
            Path path = Paths.get(rootDir, classPath);

            byte[] data = Files.readAllBytes(path);

            for (int i = 0; i < data.length; i++) {
                data[i] = (byte)(data[i] ^ key);
            }

            result = defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Ошибка чтения зашифрованного файла", e);
        }
        if (result == null) {
            throw new ClassNotFoundException(name);
        }
        return result;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("java") || name.equals("ru.sbt.encryptedclassloader.Test")) {
            return super.loadClass(name);
        }
        return findClass(name);
    }
}
