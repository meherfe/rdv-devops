package esprit.tn.examenrdv.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Define a pointcut that matches any method in the service package that starts with 'add'
    @After("execution(* esprit.tn.examenrdv.services.*.add*(..))")
    public void logAfterAddMethods() {
        logger.info("méthode exécutée");
    }
}