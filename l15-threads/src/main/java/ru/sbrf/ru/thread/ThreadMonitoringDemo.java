package ru.sbrf.ru.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ThreadMonitoringDemo {
    private static final Logger logger = LoggerFactory.getLogger( ThreadMonitoringDemo.class );

    public static void main( String[] args ) {
        Thread thread = new Thread( () -> {
            while ( true ) {
                logger.info( "Hello from {}", Thread.currentThread().getName() );
                sleep();
            }
        } );
        thread.setName( "Thread-Monitoring-Demo" );
        thread.start();
    }

    private static void sleep() {
        try {
            Thread.sleep( TimeUnit.SECONDS.toMillis( 10 ) );
        } catch ( InterruptedException e ) {
            Thread.currentThread().interrupt();
        }
    }
}
