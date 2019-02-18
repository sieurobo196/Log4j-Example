package com.codewr.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 *
 * @author codewr
 */
public class Head {

    private final static Logger logger = LoggerFactory.getLogger(Head.class);

    public static void main(String[] args) throws InterruptedException {

        MDC.put("logFileName", "head1");

        logger.debug("Log INFO");
        logger.error("Log ERROR");
        logger.debug("Log DEBUG");
        logger.warn("Log WARN");

        MDC.remove("logFileName");

    }

}
