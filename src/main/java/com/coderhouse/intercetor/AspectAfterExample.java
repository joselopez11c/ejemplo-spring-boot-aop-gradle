package com.coderhouse.intercetor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAfterExample {

    Logger logger = LogManager.getLogger(AspectAfterExample.class);

    @Pointcut("execution(* com.coderhouse.controller.MessageController.getMensajeById(..))")
    void alTerminarBusquedas() {}

    @Pointcut("execution(* com.coderhouse.controller.*.*(..))")
    void alTerminarBusquedasAll() {}

    @After("alTerminarBusquedasAll()")
    void afterAdviceMethodAll() {
        logger.info("Se ejecutó el after advice luego de la ejecución de cualquier método del paquete controller");
    }

    @After("alTerminarBusquedas()")
    void aftereAdviceMethod() {
        logger.info("Se ejecutó el after advice luego de la ejecución del método con o sin excepcion");
    }

}
