package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..)) && !target(hello.hellospring.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        }finally {
            long end = System.currentTimeMillis();
            long time = end - start;

            System.out.println("time = " + time+ "ms");

        }
    }
}
