package HomeworkSecondBook.Homework1.Test;

import HomeworkSecondBook.Homework1.test2.Line;
import HomeworkSecondBook.Homework1.test2.Size;

import java.util.Random;

public class ClientGenerator implements Runnable{
    private Line line;
    private int clientCount;

    public ClientGenerator(Line line, int clientCount) {
        this.line = line;
        this.clientCount = clientCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < clientCount) {
            Thread.currentThread().setName(" Появился клиент");
            count++;
            line.add(new Client(getRandomSize(), getRandomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }

}