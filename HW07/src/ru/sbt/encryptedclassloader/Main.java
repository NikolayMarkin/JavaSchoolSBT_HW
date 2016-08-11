package ru.sbt.encryptedclassloader;

import java.io.File;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        byte key = 17;
        ClassLoader loader =
                new EncryptedClassLoader(
                        key,
                        "C:/Data/java_projects/JavaSchoolSBT_HW/HW07/classes/",
                        Main.class.getClassLoader());

        Test test =  (Test)loader.loadClass("ru.sbt.encryptedclassloader.TestImpl").newInstance();
        test.doSomething();
    }
}
