package lab.aop;

import lab.model.Customer;
import lab.model.Squishy;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Politeness {

    @Pointcut("execution(* sellSquishy(..))")
    public void sellSquishy() {
//        throw new UnsupportedOperationException();
    }

    @Before("sellSquishy()")
    public void sayHello(JoinPoint joinPoint) {
        AopLog.append(
                "Hello %s. How are you doing?\n",
                ((Customer) joinPoint.getArgs()[0]).name()
        );
    }

    @AfterReturning(
            pointcut = "sellSquishy()",
            returning = "retVal",
            argNames = "retVal"
    )
    public void askOpinion(Object retVal) {
        AopLog.append(
                "Is %s Good Enough?\n",
                ((Squishy) retVal).getName()
        );
    }

    @AfterThrowing("sellSquishy()")
    public void sayYouAreNotAllowed() {
        AopLog.append("Hmmm...\n");
    }

    @After("sellSquishy()")
    public void sayGoodBye() {
        AopLog.append("Good Bye!\n");
    }

    @Around("sellSquishy()")
    public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
        AopLog.append("Hi!\n");
        Object retVal = pjp.proceed();
        AopLog.append("See you!\n");
        return retVal;
    }
}