package ru.gb.springbootlesson8.homework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Component
public class TimerAspect {

    @Pointcut("within(@ru.gb.springbootlesson8.homework.Timer *)") // реагирует на все методы в классе с аннотацией Timer
    public void annotatedClassMethods(){}

    @Pointcut("@annotation(ru.gb.springbootlesson8.homework.Timer)") // реагирует на отдельные методы с аннотацией Timer
    public void annotatedMethods(){}

    @Around("annotatedClassMethods() || annotatedMethods()") // применение поинткатов
        public Object timer(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            System.out.println(joinPoint.getSignature().getDeclaringType().getSimpleName()
                    + " - "
                    + joinPoint.getSignature().getName()
                    + " #("
                    + (System.currentTimeMillis() - start)/1000
                    + ")");
        }
        return null;
    }
}