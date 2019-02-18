package com.codewr.examplelog4j;

import org.apache.log4j.Logger;

/**
 *
 * @author codewr
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getLogger(App.class);
        int count = 0;
        while (true) {
            logger.info("Log INFO" + count);
            logger.error("Log ERROR" + count);
            logger.debug("Log DEBUG" + count);
            logger.warn("Log WARN" + count);
            Thread.sleep(1000);
            count++;
        }

    }

}
