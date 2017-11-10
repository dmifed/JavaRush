package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by DIMA on 10.11.2017.
 */
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
        int number = (int) (Math.random()*100);
        return "date_bot_" + number;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if(message != null & message.contains(":")){
                String[] data = message.split(": ");
                String userName = data[0];
                String mes = data[1];
                Calendar calendar = new GregorianCalendar();
                Date date = calendar.getTime();

                if(mes.equals("дата")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(date));
                }
                if(mes.equals("день")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(date));
                }
                if(mes.equals("месяц")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(date));
                }
                if(mes.equals("год")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(date));

                }
                if(mes.equals("время")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(date));
                }
                if(mes.equals("час")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(date));
                }
                if(mes.equals("минуты")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("m");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(date));
                }
                if(mes.equals("секунды")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("s");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(date));
                }

            }
            //super.processIncomingMessage(message);
        }
    }
}
