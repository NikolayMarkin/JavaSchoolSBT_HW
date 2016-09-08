package ru.sbt.server;

import ru.sbt.net.NetworkUtils;
import ru.sbt.net.domain.Request;
import ru.sbt.net.domain.Response;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;

public class Worker implements Runnable {
    private final Socket clientSocket;
    private final Object impl;

    public Worker(Socket clientSocket, Object impl) {
        this.clientSocket = clientSocket;
        this.impl = impl;
    }

    @Override
    public void run() {
        try {
            Request request = NetworkUtils.getDataFromSocket(clientSocket);

            Response response = calculateResponse(request);

            NetworkUtils.sendObject(clientSocket, response);

            clientSocket.close();
        } catch (IOException e) {
            writeToLog(e);
        }
    }

    private Response calculateResponse(Request request) {
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

    private void writeToLog(IOException e) {
        e.printStackTrace();
    }
}
