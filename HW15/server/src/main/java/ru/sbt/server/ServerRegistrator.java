package ru.sbt.server;

import ru.sbt.net.NetworkUtils;
import ru.sbt.net.domain.Request;
import ru.sbt.net.domain.Response;
import ru.sbt.servicesimpls.CalculatorImpl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ServerRegistrator {
    public static final int NUMBER_OF_THREADS = 4;

    public static void listen(int port, Object impl) {

        final ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось начать прослушивание порта № " + port, e);
        }


        while (true) {
            try {
                Socket client = serverSocket.accept();

                threadPool.execute(new Worker(client, impl));

            } catch (IOException e) {
                throw new RuntimeException("Ошибка отрытия сокета", e);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerRegistrator.listen(5000, new CalculatorImpl());
    }
}
