package com.codewr.all.example.log4j.config.xml;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author codewr
 */
public class CheckDeleteFileLogOld extends Thread {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CheckDeleteFileLogOld.class);
    private int numberDay;

    public CheckDeleteFileLogOld(int day) {
        numberDay = day;
    }

    @Override
    public void run() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        final Date firstDate = new Date();
        TimerTask tasknew = new TimerTask() {
            @Override
            public void run() {
                logger.info("check delete");
                File folder = new File("logs");
                for (File fileEntry : folder.listFiles()) {
                    if (!fileEntry.getName().equalsIgnoreCase("influxdb-proxy-server-udp.log")) {
                        try {
                            String fileName = fileEntry.getName();
                            String[] fileNameAr = fileName.split(".log.");
                            String date = fileNameAr[1];
                            Date dateFile = dateFormat.parse(date);
                            Date newDate = new Date();
                            if (newDate.getTime() - dateFile.getTime() > numberDay * 60 * 1000) {
                                if (fileEntry.delete()) {
                                    logger.info(fileEntry.getName() + " is deleted");
                                }
                            }
                        } catch (ParseException ex) {
                            logger.info("Error");
                        }
                    }

                }
            }
        };
        Timer timer = new Timer();

        timer.schedule(tasknew, firstDate, 60 * 1000);

    }

}
