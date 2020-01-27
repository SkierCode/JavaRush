package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message;
            do {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
            } while (message.getType() != MessageType.USER_NAME
                    || message.getData().isEmpty()
                    || message.getData() == null
                    || connectionMap.containsKey(message.getData()));

            connectionMap.put(message.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return message.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String key : connectionMap.keySet()) {
                if (!key.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, key));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() != MessageType.TEXT) ConsoleHelper.writeMessage("Ты чо вводишь, вводи текст?");
                else sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));

            }
        }

        @Override
        public void run() {
            String userName = null;
            ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом: " + socket.getRemoteSocketAddress().toString());
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом " + e.getMessage());
            } finally {
                if (userName != null) {connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                    ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите порт сервера");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }


}
