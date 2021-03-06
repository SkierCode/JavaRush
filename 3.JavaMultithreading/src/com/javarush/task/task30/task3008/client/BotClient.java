package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int random = (int) (Math.random() * 100);
        return String.format("date_bot_%d", random);
    }

    public static void main(String[] args) {

        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            if (message != null) {

                ConsoleHelper.writeMessage(message);
                if (message.contains(":")) {
                    String[] words = message.split(": ");
                    String userName = words[0];
                    String text = words[1];
                    SimpleDateFormat sdf = null;
                    switch (text) {
                        case "дата":
                            sdf = new SimpleDateFormat("d.MM.YYYY");
                            break;
                        case "день":
                            sdf = new SimpleDateFormat("d");
                            break;
                        case "месяц":
                            sdf = new SimpleDateFormat("MMMM");
                            break;
                        case "год":
                            sdf = new SimpleDateFormat("YYYY");
                            break;
                        case "время":
                            sdf = new SimpleDateFormat("H:mm:ss");
                            break;
                        case "час":
                            sdf = new SimpleDateFormat("H");
                            break;
                        case "минуты":
                            sdf = new SimpleDateFormat("m");
                            break;
                        case "секунды":
                            sdf = new SimpleDateFormat("s");
                            break;
                    }
                    if (sdf != null)
                        sendTextMessage(String.format("Информация для %s: %s", userName, sdf.format(Calendar.getInstance().getTime())));
                }
            }
        }
    }
}

