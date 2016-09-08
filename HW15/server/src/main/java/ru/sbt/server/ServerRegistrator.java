package ru.sbt.server;

import ru.sbt.net.NetworkUtils;
import ru.sbt.net.domain.Request;
import ru.sbt.net.domain.Response;
import ru.sbt.servicesimpls.CalculatorImpl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRegistrator {
    public static void listen(int port, Object impl) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось начать прослушивание порта № " + port, e);
        }


        while (true) {
            try (Socket client = serverSocket.accept()) {

                Request request = NetworkUtils.getDataFromSocket(client);

                Response response = calculateResponse(impl, request);

                NetworkUtils.sendObject(client, response);

                client.close();
            } catch (IOException e) {
                throw new RuntimeException("Ошибка отрытия сокета", e);
            }
        }
    }

    private static Response calculateResponse(Object impl, Request request) {
        Object[] requestArgs = request.getArgs();
        Class<?>[] parameterTypes = new Class<?>[requestArgs.length];
        for (int i = 0; i < requestArgs.length; i++) {
            parameterTypes[i] = requestArgs[i].getClass();
        }

        Method method = null;
        try {
            method = impl.getClass().getMethod(request.getMethodName(), parameterTypes);
        } catch (NoSuchMethodException e) {
            return new Response(null, e);
        }

        Object result = null;
        Throwable e = null;
        try {
            result = method.invoke(impl, requestArgs);
        } catch (Exception e1) {
            e = e1.getCause();
        }
        return new Response(result, e);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerRegistrator.listen(5000, new CalculatorImpl());
    }
}
