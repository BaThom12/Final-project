package com.vmo.nopcommerce.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static Logger logger = LogManager.getLogger(Log.class);

    public static void info(String message, String... params) {
        if(params.length==0) {
            logger.info(message);
        }else{
            logger.info(String.format(message,params));
        }
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }
}
