package ru.sbt.client;

import ru.sbt.net.NetworkUtils;
import ru.sbt.net.domain.Request;
import ru.sbt.net.domain.Response;
import ru.sbt.serialization.SerializationUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

public class ClientInvocationHandler implements InvocationHandler {
    private final String host;
    private final int port;

    public ClientInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Request request = new Request(method.getName(), args);
        try (Socket server = new Socket(host, port)) {

            NetworkUtils.sendObject(server, request);

            Response response = NetworkUtils.getDataFromSocket(server);

            server.close();

            if (response.getException() != null) {
                throw response.getException();
            }

            return response.getResult();
        }
    }


}
