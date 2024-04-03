package ru.gb.springbootlesson8;

import org.springframework.stereotype.Component;
import ru.gb.springbootlesson8.homework.Timer;
import ru.gb.springbootlesson8.homework.Wait;

@Timer
@Component
public class Volvo {
    public void method1(String args){
        System.out.println("работа метода 1");
        
        // задержка 3 секунды
        Wait.start(3000);
    }

    public String method2(){
        System.out.println("работа метода 2");

        // задержка 1 секунда
        Wait.start(1000);

        return "result";
    }

//    @Loggable(level = Level.WARN)
    public void method3(){
        System.out.println("работа метода 3");

        // задержка 2 секунды
        Wait.start(2000);

        throw new RuntimeException("Ошибка в методе 3");
    }
}
