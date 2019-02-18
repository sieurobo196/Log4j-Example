package com.codewr.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 *
 * @author codewr
 */
public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws InterruptedException {

        MDC.put("logFileName", "head1");

        logger.debug("hello");

        int count = 0;
        while (true) {

            logger.debug("Log INFO" + count);
            logger.error("Log ERROR" + count);
            logger.debug("Log DEBUG" + count);
            logger.warn("Log WARN" + count);
            Thread.sleep(1000);
            if (count == 10) {
                break;
            }
            count++;
        }
        MDC.remove("logFileName");
    }
}
