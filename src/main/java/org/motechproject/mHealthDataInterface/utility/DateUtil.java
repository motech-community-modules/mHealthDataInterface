package org.motechproject.mHealthDataInterface.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date Util
 */
public final class DateUtil {

    private DateUtil() {
    }

    public static String formatToOpenMrsDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return dateFormat.format(date.getTime());
    }

    public static Date parseOpenMrsDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return dateFormat.parse(date);
    }

}
