package com.cms.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeUtils {

    public static DateFormat  MM__DD__YYYY        = new SimpleDateFormat("MM/dd/yyyy");
    private static DateFormat DD__MM__YYYY        = new SimpleDateFormat("dd/MM/yyyy");
    public static DateFormat  DD_MMM_yy_z         = new SimpleDateFormat("dd MMM, yyyy");
    public static DateFormat  DD_MMM_YYYY_HYPHEN  = new SimpleDateFormat("dd-MMM-yyyy");
    public static DateFormat  DD_MM_YYYY          = new SimpleDateFormat("dd-MM-yyyy");
    private static DateFormat DD__MMM__YYYY       = new SimpleDateFormat("yyyy/MM/dd");
    public static DateFormat  DD_MMM_yy_HH_mm     = new SimpleDateFormat("dd MMM, yyyy HH:mm");
    public static DateFormat  DD_MMM              = new SimpleDateFormat("dd MMM,");
    public static DateFormat  DD_MMMM_YYYY        = new SimpleDateFormat("dd MMMM yyyy, hh:mm a");
    public static DateFormat  DD_MM_YYYY_HH_MM_SS = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public static DateFormat  YYYY_MM_YY          = new SimpleDateFormat("YYYY-MM-dd");
    public static DateFormat  HH_MM_A             = new SimpleDateFormat("hh:mm a");

    public static Timestamp getCurrentTimestamp() {
        Calendar calendar = Calendar.getInstance();
        return new Timestamp(calendar.getTimeInMillis());
        
    }

    public static Calendar getDateddMMyyy(String strDate) {
        Calendar cal = Calendar.getInstance();
        try {
            Date date = (Date) DD__MM__YYYY.parse(strDate);
            cal.setTime(date);
        } catch (Exception e) {
            cal = null;
        }
        return cal;
    }

    public static Calendar stringToCalendarWithTime(String strDate) {
        Calendar cal = Calendar.getInstance();
        try {
            Date date = (Date) DD_MM_YYYY_HH_MM_SS.parse(strDate);
            cal.setTime(date);
        } catch (Exception e) {
            cal = null;
        }
        return cal;
    }

    public static Calendar stringToCalendar(String dateStr) {
        Calendar cal = null;
        if (dateStr != null && !"".equals(dateStr)) {
            try {
                Date d = (Date) MM__DD__YYYY.parse(dateStr);
                cal = Calendar.getInstance();
                cal.setTime(d);
            } catch (Exception e) {
                cal = null;
            }
        }
        return cal;
    }

    public static Timestamp stringToTimestamp(String dateStr) {
        Calendar cal = getDateddMMyyy(dateStr);
        return calenderToTimestamp(cal);
    }

    public static Timestamp calenderToTimestamp(Calendar cal) {
        Timestamp ts = null;
        if (cal != null) {
            try {
                ts = new Timestamp(cal.getTimeInMillis());
            } catch (Exception e) {
                ts = null;
            }
        }
        return ts;
    }

    public static Calendar timestampToCalender(Timestamp timestamp) {
        Calendar cal = Calendar.getInstance();
        if (timestamp == null)
            return null;
        try {
            if (timestamp != null) {
                cal.setTime((Date) timestamp);
            }
        } catch (Exception e) {
            cal = null;
        }
        return cal;
    }

    public static String getDateInDdMmAndYYYY(Calendar c) {
        if (c == null)
            return null;
        return DD_MMM_yy_z.format(c.getTime());
    }

    public static String getDateInDdMmAndYYYY(Timestamp timestamp) {
        Calendar c = timestampToCalender(timestamp);
        if (c == null)
            return null;
        return DD_MMM_yy_z.format(c.getTime());
    }

    public static String getDateInDdMMMAndYYYY(Calendar c) {
        if (c == null)
            return null;
        return DD_MMM_YYYY_HYPHEN.format(c.getTime());
    }

    public static String getDateInDdMMMAndYYYY(Timestamp timestamp) {
        Calendar c = timestampToCalender(timestamp);
        if (c == null)
            return null;
        return DD_MMM_YYYY_HYPHEN.format(c.getTime());
    }

    public static Calendar getDateddMMyyyy(String strDate) {
        Calendar cal = Calendar.getInstance();
        try {
            Date date = (Date) DD_MM_YYYY.parse(strDate);
            cal.setTime(date);
        } catch (Exception e) {
            cal = null;
        }
        return cal;
    }

    public static Timestamp stringToTimestampInYYYYDDMM(String dateStr) {
        Calendar cal = getDateddMMMyyy(dateStr);
        return calenderToTimestamp(cal);
    }

    public static Calendar getDateddMMMyyy(String strDate) {
        Calendar cal = Calendar.getInstance();
        try {
            Date date = (Date) DD__MMM__YYYY.parse(strDate);
            cal.setTime(date);
        } catch (Exception e) {
            cal = null;
        }
        return cal;
    }

    public static String getDateInDdMmYyyyHhMmInUIFormat(Calendar c) {
        if (c == null)
            return "";
        return DD_MMM_yy_HH_mm.format(c.getTime());
    }

    public static String getDateInDdMmYyyyHhMmInUIFormat(Timestamp timestamp) {
        Calendar c = timestampToCalender(timestamp);
        if (c == null)
            return "";
        return DD_MMM_yy_HH_mm.format(c.getTime());
    }

    public static String getDateInDdMMM(Timestamp timestamp) {
        Calendar c = timestampToCalender(timestamp);
        if (c == null)
            return null;
        return DD_MMM.format(c.getTime());
    }

    public static String getDateddMMyyy(Timestamp timestamp) {
        Calendar c = timestampToCalender(timestamp);
        if (c == null)
            return null;
        return DD__MM__YYYY.format(c.getTime());
    }

    public static Long getLong(Timestamp date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }

    public static String getDateInDdMmAndYYYY1(Timestamp timestamp) {
        Calendar c = timestampToCalender(timestamp);
        if (c == null)
            return null;
        return DD_MMMM_YYYY.format(c.getTime());
    }

    public static String getDateInYYYYMMdd(Timestamp timestamp) {
        Calendar c = timestampToCalender(timestamp);
        if (c == null)
            return null;
        return YYYY_MM_YY.format(c.getTime());
    }

    public static String getCurrentDateInSpecificFormat(Timestamp timestamp) {
        if (timestamp != null) {
            Calendar currentCalDate = timestampToCalender(timestamp);
            String dayNumberSuffix = getDayNumberSuffix(currentCalDate.get(Calendar.DAY_OF_MONTH));
            DateFormat dateFormat = new SimpleDateFormat(" d'" + dayNumberSuffix + "' MMM yyyy, hh:mm a");
            return dateFormat.format(currentCalDate.getTime());
        }
        return null;
    }

    private static String getDayNumberSuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
        case 1:
            return "st";
        case 2:
            return "nd";
        case 3:
            return "rd";
        default:
            return "th";
        }
    }

    public static Calendar getCalendarFromExcel(String s) {
        Calendar cal = null;
        if (s != null && !"".equals(s)) {
            s = s.trim();
            SimpleDateFormat sdf = null;
            Pattern p = Pattern.compile("[a-zA-Z]");
            Matcher m = p.matcher(s);
            if (m.find()) {
                if (s.contains("-")) {
                    String dateElement[] = s.split("-");
                    if (3 == dateElement.length) {
                        sdf = new SimpleDateFormat("dd-MMM-yyyy");
                    }
                } else if (s.contains("/")) {
                    String dateElement[] = s.split("/");
                    if (3 == dateElement.length) {
                        sdf = new SimpleDateFormat("dd/MMM/yyyy");
                    }
                } else if (s.contains(".")) {
                    String dateElement[] = s.split(".");
                    if (3 == dateElement.length) {
                        sdf = new SimpleDateFormat("MMM.dd.yyyy");
                    }
                }
            } else {
                if (s.contains("-")) {
                    String dateElement[] = s.split("-");
                    if (3 == dateElement.length) {
                        sdf = new SimpleDateFormat("dd-MM-yyyy");
                    }
                } else if (s.contains("/")) {
                    String dateElement[] = s.split("/");
                    if (3 == dateElement.length) {
                        sdf = new SimpleDateFormat("dd/MM/yyyy");
                    }
                } else if (s.contains(".")) {
                    String dateElement[] = s.split("[.]");
                    if (3 == dateElement.length) {
                        sdf = new SimpleDateFormat("MM.dd.yyyy");
                    }
                }
            }
            if (sdf != null) {
                cal = Calendar.getInstance();
                try {
                    Date date = (Date) sdf.parse(s);
                    cal.setTime(date);
                } catch (Exception e) {
                    cal = null;
                }
                return cal;
            }
        }
        return cal;
    }

    public static int compareTimestampDates(Timestamp ts1, Timestamp ts2) {
        Date date1 = new Date(ts1.getTime());
        Date date2 = new Date(ts2.getTime());
        return date1.compareTo(date2);
    }

    public static Timestamp getLongToTimestamp(long timeInMilliseconds) {
        if (timeInMilliseconds > 0) {
            Date date = new Date(timeInMilliseconds * 1000L);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String formattedDate = sdf.format(date);
            return StringUtilityClass.stringWithTimeToTimestamp(formattedDate);
        }
        return null;
    }

    public static String getDateInDdMMAndYYYYFromTimeStamp(Timestamp timestamp) {
        Calendar c = timestampToCalender(timestamp);
        if (c == null)
            return null;
        return DD_MM_YYYY.format(c.getTime());
    }

    public static String getDateByAddingOrSubtratingDays(int totalDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, totalDays);
        Date ed = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        String startDateStr = formatter.format(ed);
        return startDateStr;
    }
    
    public static String getTimeFromTimestampInHHMM(Timestamp timestamp) {
        Calendar c = timestampToCalender(timestamp);
        if (c == null)
            return null;
        return HH_MM_A.format(c.getTime());
    }

}

