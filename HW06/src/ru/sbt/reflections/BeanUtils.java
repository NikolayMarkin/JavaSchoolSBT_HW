package ru.sbt.reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.sbt.domain.TestClass1;
import ru.sbt.domain.TestClass2;

public class BeanUtils {

    public static void main(String[] args) {


        TestClass1 from = new TestClass1(123, "456", 789d);
        TestClass1 to = new TestClass1();

        assign(to, from);

        if (to.getDoubleField() == from.getDoubleField() &&
                to.getIntField() == from.getIntField() &&
                to.getStrField().equals(from.getStrField())) {
            System.out.println("Копирование TestClass1 -> TestClass2 успешно");
        }

        TestClass2 from2 = new TestClass2(123, "456", 789d);
        TestClass2 to2 = new TestClass2();

        assign(to2, from2);

        if (to2.getDoubleField() == from2.getDoubleField() &&
                to2.getIntField() == from2.getIntField() &&
                to2.getStrField().equals(from2.getStrField())) {
            System.out.println("Копирование TestClass2 -> TestClass2 успешно");
        }

        TestClass1 from3 = new TestClass1(123, "456", 789d);
        TestClass2 to3 = new TestClass2();

        assign(to3, from3);

        if (to3.getDoubleField() == from3.getDoubleField() &&
                to3.getIntField() == from3.getIntField() &&
                to3.getStrField().equals(from3.getStrField())) {
            System.out.println("Копирование TestClass1 -> TestClass2 успешно");
        }

    }

    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        Map<String, Method> allFieldsAndGetters = getAllGetters(from);
        Map<String, Method> allFieldsAndSetters = getAllSetters(to);

        for (Map.Entry<String, Method> fieldWithSetter : allFieldsAndSetters.entrySet()) {
            if (allFieldsAndGetters.containsKey(fieldWithSetter.getKey())){
                Method setter = fieldWithSetter.getValue();
                Method getter = allFieldsAndGetters.get(fieldWithSetter.getKey());
                Class<?> setterParamType = setter.getParameterTypes()[0];
                Class<?> getterValueType = getter.getReturnType();

                if (isCompatible(setterParamType, getterValueType)){
                    try {
                        setter.invoke(to, getter.invoke(from));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException("Exception during reflection access", e);
                    }
                }
            }
        }


    }

    private static boolean isCompatible(Class<?> typeSetter, Class<?> typeGetter) {
        while (typeGetter != null) {
            if (typeSetter.equals(typeGetter)){
                return true;
            }
            typeGetter = typeGetter.getSuperclass();
        }
        return false;
    }

    private static Map<String, Method> getAllGetters(Object o) {
        Map<String, Method> allFieldsAndGetters = new HashMap<>();
        Class<?> clazz = o.getClass();

        Pattern pattern = Pattern.compile("^get[A-Z]+");
        Matcher matcher;

        Method[] declaredMethods = clazz.getMethods();
        for (Method method : declaredMethods) {
            matcher = pattern.matcher(method.getName());
            if (matcher.find()) {
                if (method.getParameterCount() == 0 && method.getReturnType() != void.class) {

                    allFieldsAndGetters.put(method.getName().substring(3),method);
                }
            }
        }
        return allFieldsAndGetters;
    }

    private static Map<String, Method> getAllSetters(Object o) {
        Map<String, Method> allFieldsAndSetters = new HashMap<>();
        Class<?> clazz = o.getClass();

        Pattern pattern = Pattern.compile("^set[A-Z]+");
        Matcher matcher;

        Method[] declaredMethods = clazz.getMethods();
        for (Method method : declaredMethods) {
            matcher = pattern.matcher(method.getName());
            if (matcher.find()) {
                if (method.getParameterCount() == 1 && method.getReturnType() == void.class) {
                    allFieldsAndSetters.put(method.getName().substring(3),method);;
                }
            }
        }
        return allFieldsAndSetters;
    }
}
