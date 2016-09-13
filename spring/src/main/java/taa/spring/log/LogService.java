package taa.spring.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogService {
  
  @Before("execution(* taa..*.*(..))")
  public void log(JoinPoint joinPoint){
      System.out.println("Completed : " + joinPoint);        
  }
  /*
  @Around("execution(* taa..*.*(..))")
  public void logAround(ProceedingJoinPoint pjp){
    System.out.println("Log secu : Around");
  }
*/
}
