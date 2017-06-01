package com.zy.test.aspectj;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Aspect
public class AutoInjectDependecyAspect implements ApplicationContextAware {
    private static final Logger LOGGER = Logger.getLogger( AutoInjectDependecyAspect.class );
 
    private static ApplicationContext context ;
//
//
//    @Pointcut( "execution(  (@org.springframework.beans.factory.annotation.Configurable *).new())" )
//    public void constructor() {
//    	System.out.println("切点");
//    }
//
//    @Before( "constructor()" )
//    public void injectAutoWiredFields( JoinPoint aPoint ) {
//        Class theClass = aPoint.getTarget().getClass();
//        try{
//            Field[] theFields = theClass.getDeclaredFields();
//            for ( Field thefield : theFields ) {
//                for ( Annotation theAnnotation : thefield.getAnnotations() ) {
//                    if ( theAnnotation instanceof Autowired ) {
//                        // found a field annotated with 'AutoWired'
//                        if ( !thefield.isAccessible() ) {
//                            thefield.setAccessible( true );
//                        }
//                        System.out.println("thefield.getName():"+thefield.getType() +"context:"+context);
//                        Object theBean = context.getBean( thefield.getType());
//                        if ( theBean != null ) {
//                            thefield.set( aPoint.getTarget(), theBean );
//                        }
//                    }
//                }
//            }
//        } catch ( Exception e ) {
//            LOGGER.error( "An error occured while trying to inject bean on mapper '" + aPoint.getTarget().getClass() + "'", e );
//        }
//
//    }

    @Override
    public void setApplicationContext( ApplicationContext aApplicationContext ) throws BeansException {
    	context = aApplicationContext;
    }

}
