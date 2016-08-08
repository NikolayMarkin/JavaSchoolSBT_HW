package ru.sbt.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;

public class Utils {
    /*
     * Проверить, что все String константы имеют значение = их имени
     * public static final String MONDAY = "MONDAY";
     */
    public static void checkStringConstNameConvention(Object o) {
        Class<?> clazz = o.getClass();
        if (clazz != null) {
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                Class<?> type = field.getType();
                if (type.getName().equals("java.lang.String")) {
                    int modifiers = field.getModifiers();
                    if (Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers)) {
                        String fieldName = field.getName();
                        try {
                            field.setAccessible(true);
                            String fieldValue = (String) field.get(o);

                            if (!fieldName.equals(fieldValue)) {
                                throw new RuntimeException("Константа " + fieldName + " имеет значение не равное ее имени");
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException("Exception during reflection acces", e);
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
