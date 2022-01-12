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

    @Pointcut("execution(* com.coderhouse.controller.MessageController.getMensajeById(..))")
    void paraBusquedas() {}

    @Pointcut("execution(* com.coderhouse.controller.*.*(..))")
    void paraBusquedasAll() {}

    @Before("paraBusquedasAll()")
    void beforeAdviceMethodAll() {
        logger.info("Se ejecutó el before advice antes de la ejecución de cualquier método del paquete controller");
    }

    @Before("paraBusquedas()")
    void beforeAdviceMethod() {
        logger.info("Se ejecutó el before advice antes de la ejecución del método");
    }

}
