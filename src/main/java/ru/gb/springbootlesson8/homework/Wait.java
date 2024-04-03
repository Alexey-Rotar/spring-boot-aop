package ru.gb.springbootlesson8.homework;

public class Wait {

    /**
     * Имитация задержки
     * @param ms задержка в миллисекундах
     */
    public static void start(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
