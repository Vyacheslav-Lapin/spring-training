package lab.aop;


import lab.model.Customer;
import lab.model.Squishy;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Politeness {

    @Before("execution(* sellSquishy(..))")
    public void sayHello(JoinPoint joinPiont) {
        AopLog.append("Hello " + ((Customer) joinPiont.getArgs()[0]).getName() + ". How are you doing? \n");
    }

    @AfterReturning(pointcut = "execution(* sellSquishy(..))",
            returning = "retVal", argNames = "retVal")
    public void askOpinion(Object retVal) {
        AopLog.append("Is " + ((Squishy) retVal).getName() + " Good Enough? \n");
    }

    public void sayYouAreNotAllowed() {
        AopLog.append("Hmmm... \n");
    }

    public void sayGoodBye() {
        AopLog.append("Good Bye! \n");
    }

    public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
        AopLog.append("Hi! \n");
        Object retVal = pjp.proceed();
        AopLog.append("See you! \n");
        return retVal;
    }

}