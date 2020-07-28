package com.example.demo.acpect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Aspect
@Configuration
public class TestAspect {

    @Around("allControllerAdvice()")
    public void testLog(JoinPoint joinPoint) {
        var args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[1];
        log.info(request.getRequestURI());
        log.info(request.getHeader("User-Agent"));
        log.info(request.getLocalPort());
        log.info("Acpect called");
    }

    @Pointcut("(execution(public * com.example.demo.controller.*.*(..)))")
    public static void allControllerAdvice(){ }

}
