package esprit.tn.examenrdv.Aspects;



import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Define a pointcut that matches any method in the service package that starts with 'add'
    @After("execution(* esprit.tn.examenrdv.Service.*.add*(..))")
    public void logAfterAddMethods() {
        System.out.println("méthode exécutée");
    }
}

