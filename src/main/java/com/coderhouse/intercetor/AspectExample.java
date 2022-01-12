package com.coderhouse.intercetor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExample {

    Logger logger = LogManager.getLogger(AspectExample.class);

    @Pointcut("execution(* com.coderhouse.controller." +
            "MessageController.getMensajeById(..))")
    void paraBusquedasById() {}

    @Before("paraBusquedasById()")
    void beforeAdviceMethod1() {
        //mostra en log
        logger.info("Se ejecutó el before advice antes " +
                "de la ejecución del método getMensajeById() 01");
    }

    @Before("paraBusquedasById()")
    void beforeAdviceMethod2() {
        //insertar en una tabla de una bd
        logger.info("Se ejecutó el before advice antes " +
                "de la ejecución del método getMensajeById() 02");
    }

    @Before("paraBusquedasById()")
    void beforeAdviceMethod3() {
        // insetar en caché
        logger.info("Se ejecutó el before advice antes " +
                "de la ejecución del método getMensajeById() 03");
    }

    @Pointcut("execution(* com.coderhouse.controller.*.*(..))")
    void paraBusquedasAll() {}

    @Before("paraBusquedasAll()")
    void beforeAdviceMethodAll() {
        logger.info("Se ejecutó el before advice antes de la ejecución " +
                "de cualquier método del paquete controller");
    }

}
