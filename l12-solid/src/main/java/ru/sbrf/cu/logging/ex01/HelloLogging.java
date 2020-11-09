package ru.sbrf.cu.logging.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloLogging {
    private static Logger logger = LoggerFactory.getLogger(HelloLogging.class);

    public static void main(String[] args) {
        new HelloLogging().log();
    }

    private void log() {
        String value = "test";

//      Устаревший вариант
//        if (logger.isDebugEnabled()) {
//            logger.debug("Hello logging:" + value);
//        }

        //Современный вариант
        logger.debug("Hello logging:{}", value);

        try {
            Thread.sleep(3_000);
            throw new RuntimeException("exception for log");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            logger.error("exception log:", e);
        }
    }
}
