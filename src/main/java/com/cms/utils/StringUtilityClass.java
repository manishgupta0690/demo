package com.cms.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringUtilityClass {

    public static DateFormat         YYYY_MM_DD_HYPHEN                       = new SimpleDateFormat("yyyy-MM-dd");
    public static DateFormat         YYYY_MM_DD_HH_MM_HYPHEN                 = new SimpleDateFormat("yyyy-MM-dd hh:mma");
    public static DateFormat         DD_MMM_yy_z                             = new SimpleDateFormat("dd MMM, yyyy");
    public static DateFormat         DD_MMM_yy_HH_MM_HYPHEN                  = new SimpleDateFormat("dd MMM, yyyy hh:mm a");
    public static DateFormat         DD_MM_YYYY_HYPHEN                       = new SimpleDateFormat("dd-MM-yyyy");
    public static DateFormat         YYYY_MM_DD_HH_MM_HYPHEN_TIME            = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static DateFormat         YYYY_MM_DD_HH_MM_HYPHEN_TIME_WITH_SLASH = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public static final List<String> DAYS_OF_WEEK                            = Arrays.asList("sunday", "monday", "tuesday", "wednesday", "thursday",
                                                                                     "friday", "saturday");

    public static final Logger       logger                                  = LoggerFactory.getLogger(StringUtilityClass.class);

    public static boolean isNotNullAndNotEmpty(String str) {
        if (str != null && !"".equals(str.trim())) {
            return true;
        }
        return false;
    }

    public static List<String> getStringListFromString(String str, String delim) {
        if (str == null || "".equals(str)) {
            return null;
        }
        List<String> stringList = new ArrayList<String>();
        if (!"".equals(str)) {
            if ("".equals(delim)) {
                delim = ",";
            }
            String strArray[] = str.split(delim);
            if (strArray != null && strArray.length > 0) {
                for (String s : strArray) {
                    stringList.add(s.trim());
                }
            }
        }
        return stringList;
    }

    public static String getStringFromStringList(List<String> stringList, String delim) {
        StringBuffer sb = new StringBuffer();
        if (stringList != null && stringList.size() > 0) {
            if ("".equals(delim)) {
                delim = ",";
            }
            for (String s : stringList) {
                sb.append(s);
                sb.append(delim);
            }
            if (!"".equals(sb)) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static int stringToInt(String str, int defaultVal) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            i = defaultVal;
        }
        return i;
    }

    public static String getRandomString(int length) {
       // String charset = "0123456789abcdefghijklmnopqrstuvwxyz";
        String charset = "0123456789123456789123456789";
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        return sb.toString();
    }

    public static String getRandomDigit(int length) {
        String charset = "0123456789";
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        return sb.toString();
    }

    public static String serializeStringArray(String[] strings, String delim, String delimRegex) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            if (i != 0) {
                sbuf.append(delim);
            }
            if (strings[i] != null) {
                sbuf.append(strings[i].replaceAll(delimRegex, ""));
            }
        }
        return sbuf.toString();
    }

    public static List<String> getStringToList(String data, String regexValue) {
        String dataArray[] = data.split(regexValue);
        if (dataArray != null && dataArray.length > 0) {
            List<String> list = new ArrayList<String>();
            for (int index = 0; index < dataArray.length; index++) {
                list.add(dataArray[index]);
            }
            return list;
        }
        return null;
    }

    public static Timestamp stringToTimeStampWithTime(String dateStr) {
        Calendar cal = null;
        if (StringUtilityClass.isNotNullAndNotEmpty(dateStr)) {
            try {
                java.util.Date d = YYYY_MM_DD_HH_MM_HYPHEN.parse(dateStr);
                cal = Calendar.getInstance();
                cal.setTime(d);
            } catch (ParseException e) {
                cal = null;
            }
        }
        Timestamp t = calenderToTimestamp(cal);
        return t;
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
                cal.setTime(timestamp);
            }
        } catch (Exception e) {
            cal = null;
        }
        return cal;
    }

    public static String dateToDayOfWeek(String date) {
        Timestamp ts = stringToTimeStampWithOutTime(date);
        GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
        cal.setTime(ts);
        return ((DAYS_OF_WEEK.get(cal.get(Calendar.DAY_OF_WEEK) - 1)));
    }

    public static String dateToTodayDayOfWeek() {
        Timestamp ts = DateTimeUtils.getCurrentTimestamp();
        GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
        cal.setTime(ts);
        return ((DAYS_OF_WEEK.get(cal.get(Calendar.DAY_OF_WEEK) - 1)));
    }

    public static String getDateInDdMmAndYYYY(Timestamp timestamp) {
        return getDateInDdMmAndYYYY(timestampToCalender(timestamp));
    }

    public static String getDateInDdMmAndYYYY(Calendar c) {
        if (c == null)
            return null;
        return DD_MMM_yy_z.format(c.getTime());
    }

    public static int getInteger(HttpServletRequest request, String no, int defaultVal) {
        int i = defaultVal;
        if (request != null && no != null && !"".equals(no)) {
            try {
                i = request.getParameter(no) != null ? Integer.parseInt(request.getParameter(no).trim()) : defaultVal;
            } catch (NumberFormatException nfe) {
                i = defaultVal;
            }
        }
        return i;
    }

    public static String getStringFromStringArray(String[] stringList, String delim) {
        StringBuffer sb = new StringBuffer();
        if (stringList != null && stringList.length > 0) {
            if ("".equals(delim)) {
                delim = ",";
            }
            for (String s : stringList) {
                sb.append(s);
                sb.append(delim);
            }
            if (!"".equals(sb)) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static Timestamp stringToTimeStampWithOutTime(String appointmentDate) {
        Calendar cal = null;
        if (StringUtilityClass.isNotNullAndNotEmpty(appointmentDate)) {
            try {
                java.util.Date d = YYYY_MM_DD_HYPHEN.parse(appointmentDate);
                cal = Calendar.getInstance();
                cal.setTime(d);
            } catch (ParseException e) {
                cal = null;
            }
        }
        Timestamp t = calenderToTimestamp(cal);
        return t;
    }

    public static Calendar stringToCalanderWithOutTime(String appointmentDate) {
        Calendar cal = null;
        if (StringUtilityClass.isNotNullAndNotEmpty(appointmentDate)) {
            try {
                java.util.Date d = YYYY_MM_DD_HYPHEN.parse(appointmentDate);
                cal = Calendar.getInstance();
                cal.setTime(d);
            } catch (ParseException e) {
                cal = null;
            }
        }
        return cal;
    }

    public static double getDouble(HttpServletRequest request, String no, double defaultVal) {
        double i = defaultVal;
        if (request != null && no != null && !"".equals(no)) {
            try {
                i = request.getParameter(no) != null ? Double.parseDouble(request.getParameter(no)) : defaultVal;
            } catch (NumberFormatException nfe) {
                i = defaultVal;
            }
        }
        return i;
    }

    public static String formatTime(String time) {
        try {
            if (StringUtilityClass.isNotNullAndNotEmpty(time) && time.contains(":")) {
                String[] arr = (String[]) (StringUtilityClass.isNotNullAndNotEmpty(time) ? time.split(":") : "");
                String hour = arr[0].trim();
                String min = arr[1].trim();
                if (StringUtilityClass.isNotNullAndNotEmpty(hour)) {
                    if (hour.length() == 1) {
                        hour = "0" + hour;
                    }
                }
                if (StringUtilityClass.isNotNullAndNotEmpty(min)) {
                    if (min.length() == 3) {
                        min = "0" + min;
                    }
                }
                time = hour + ":" + min;
            } else {
                String timeEx = StringUtilityClass.isNotNullAndNotEmpty(time) ? time.substring(time.length() - 2) : "";
                String hour = StringUtilityClass.isNotNullAndNotEmpty(time) ? time.substring(0, time.length() - 2) : "";
                if (StringUtilityClass.isNotNullAndNotEmpty(hour)) {
                    if (hour.length() == 1) {
                        hour = "0" + hour;
                    }
                }
                String min = "00";
                time = hour + ":" + min + timeEx;
            }

            return time;

        } catch (Exception e) {

        }
        return "";
    }

    public static String getTwelveHourFormatTime(String time) {

        int hour = 0;
        int min = 0;
        String timeEx = "am";
        final String AM_TIMEX = "am";
        final String PM_TIMEX = "pm";
        try {
            if (StringUtilityClass.isNotNullAndNotEmpty(time) && (time.contains(AM_TIMEX) || time.contains(PM_TIMEX))) {
                return formatTime(time);
            }

            if (StringUtilityClass.isNotNullAndNotEmpty(time)) {
                String[] timeArray = time.split(":");
                hour = Integer.parseInt(timeArray[0]);
                if (hour >= 12) {
                    timeEx = "pm";
                }
                hour = ((hour + 11) % 12 + 1);
                min = Integer.parseInt(timeArray[1].split(" ")[0]);

            }
            return formatTime(hour + ":" + min + timeEx);
        } catch (Exception e) {
            logger.error("error while formatting time...", e);
            return "";
        }
    }

   /* public static String getAppointmentNextTime(String startTime, String avgSlotTime) {
        String minutes = startTime.substring(3, 5);

        int hour = CommonUtils.getIntegerFromString(startTime.substring(0, 2));
        String suffixAmOrPm = startTime.substring(5, 7);
        int totalminutes = ((CommonUtils.getIntegerFromString(minutes) + CommonUtils.getIntegerFromString(avgSlotTime)));
        if ((totalminutes > 60)) {
            totalminutes = totalminutes % 60;
            hour = ((hour + 11) % 12 + 2);
            if (hour >= 12) {
                if (suffixAmOrPm == "am") {
                    suffixAmOrPm = "pm";
                } else {
                    suffixAmOrPm = "am";
                }
            }
        }
        if ((totalminutes) == 60) {
            totalminutes = 0;
            hour = ((hour + 11) % 12 + 2);
            if (hour >= 12) {
                hour = hour % 12;
                if (suffixAmOrPm.equalsIgnoreCase("am")) {
                    suffixAmOrPm = "pm";
                } else {
                    suffixAmOrPm = "am";
                }
            }
        }
        if (totalminutes == 0) {
            return "" + hour + ":00" + suffixAmOrPm + "";
        }
        return "" + hour + ":" + totalminutes + suffixAmOrPm + "";
    }

    public static String getDiffOfTwoTimes(Date time1, Date time2) {

        long diff = time1.getTime() - time2.getTime();
        double diffInHours = diff / ((double) 1000 * 60 * 60);
        
         * System.out.println(diffInHours); System.out.println("Hours " +
         * (int)diffInHours); System.out.println("Minutes " + (diffInHours -
         * (int)diffInHours)*60 );
         
        return (int) diffInHours + ":" + (diffInHours - (int) diffInHours) * 60 + "";
    }*/

    public static String getTwentyFourHourFormatTime(String time) {
        String timedate = DateTimeUtils.getCurrentTimestamp().toString().substring(0, 10);
        time = formatTime(time);
        String timeEx = StringUtilityClass.isNotNullAndNotEmpty(time) ? time.substring(time.length() - 2) : "";
        timeEx = timeEx != null && timeEx.trim().length() < 2 ? time.substring(time.length() - 3) : timeEx;
        time = time != null && !time.contains(" ") ? time.replace(timeEx, " " + timeEx) : time;
        String trmdTime = time != null ? time.trim() : "";
        if (StringUtilityClass.isNotNullAndNotEmpty(trmdTime)) {
            String TTArray[] = null;
            if (trmdTime.contains(" ")) {
                TTArray = trmdTime.split(" ");
                time = TTArray != null && TTArray.length > 1 ? (TTArray[0] != null && TTArray[1] != null ? TTArray[0].trim() + TTArray[1].trim() : "")
                        : "";
            }

            time = StringUtilityClass.isNotNullAndNotEmpty(time) ? time.replace(TTArray[1], ":00 " + TTArray[1]) : "";
        }
        String input = timedate + " " + time;

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
        DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        String output = null;
        try {
            date = df.parse(input);
            output = outputformat.format(date);
            System.out.println(output);
            return output.length() > 10 ? output.substring(11) : "";
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return null;
    }

    public static Timestamp stringDDMMYYYYToTimeStampWithTime(String dateStr) {
        Calendar cal = null;
        if (StringUtilityClass.isNotNullAndNotEmpty(dateStr)) {
            try {
                java.util.Date d = DD_MM_YYYY_HYPHEN.parse(dateStr);
                cal = Calendar.getInstance();
                cal.setTime(d);
            } catch (ParseException e) {
                cal = null;
            }
        }
        Timestamp t = calenderToTimestamp(cal);
        return t;
    }

    public static int convertTimeToInt(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        int tNo = hour * 60 + min;
        return tNo;

    }

    public static String convertIntToTime(int no) {
        String hour = String.valueOf(no / 60);
        String min = String.valueOf(no % 60);
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        if (min.length() == 1) {
            min = "0" + min;
        }
        return hour + ":" + min;

    }

    public static String getDateInDdMmAndYYYYWithTime(Timestamp timestamp) {
        return getDateInDdMmAndYYYYWithTime(timestampToCalender(timestamp));
    }

    public static String getDateInDdMmAndYYYYWithTime(Calendar c) {
        if (c == null)
            return null;
        return DD_MMM_yy_HH_MM_HYPHEN.format(c.getTime());
    }

    public static String convertDateToDdMmYy(Date date) {
        String DATE_FORMAT_NOW = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        String stringDate = sdf.format(date);
        return stringDate;
    }

    public static String getDateSuffixFromDay(int day) {
        switch (day) {
        case 1:
        case 21:
        case 31:
            return "st";
        case 2:
        case 22:
            return "nd";
        case 3:
        case 23:
            return "rd";
        default:
            return "th";
        }
    }

    public static String getStringFromIntList(List<Integer> intList, String delim) {
        StringBuffer sb = new StringBuffer("");
        if (intList != null && intList.size() > 0) {
            for (Integer id : intList) {
                sb.append(id + delim);
            }
            if (!"".equals(sb) && sb.length() > 0)
                return sb.substring(0, sb.length() - delim.length());
        }
        return sb.toString();
    }

    public static String getStringFromIntSet(Set<Integer> intSet, String delim) {
        List<Integer> intList = null;
        if (intSet != null && intSet.size() > 0) {
            intList = new ArrayList<Integer>(intSet);
        }
        return getStringFromIntList(intList, delim);
    }

    public static Timestamp stringWithTimeToTimestamp(String dateString) {
        Calendar cal = null;
        if (StringUtilityClass.isNotNullAndNotEmpty(dateString)) {
            try {
                java.util.Date d = YYYY_MM_DD_HH_MM_HYPHEN_TIME.parse(dateString);
                cal = Calendar.getInstance();
                cal.setTime(d);
            } catch (ParseException e) {
                cal = null;
            }
        }
        Timestamp t = calenderToTimestamp(cal);
        return t;
    }

    public static Timestamp stringWithTimeToTimestampWithSlash(String dateString) {
        Calendar cal = null;
        if (StringUtilityClass.isNotNullAndNotEmpty(dateString)) {
            try {
                java.util.Date d = YYYY_MM_DD_HH_MM_HYPHEN_TIME_WITH_SLASH.parse(dateString);
                cal = Calendar.getInstance();
                cal.setTime(d);
            } catch (ParseException e) {
                cal = null;
            }
        }
        Timestamp t = calenderToTimestamp(cal);
        return t;
    }

    public static int getMonthNumberFromString(String monthName) {
        int monthNum = 0;

        if (monthName.equalsIgnoreCase("Jan")) {

        } else if (monthName.equalsIgnoreCase("Feb")) {
            monthNum = 1;
        } else if (monthName.equalsIgnoreCase("Mar")) {
            monthNum = 2;
        } else if (monthName.equalsIgnoreCase("Apr")) {
            monthNum = 3;
        } else if (monthName.equalsIgnoreCase("May")) {
            monthNum = 4;
        } else if (monthName.equalsIgnoreCase("Jun")) {
            monthNum = 5;
        } else if (monthName.equalsIgnoreCase("Jul")) {
            monthNum = 6;
        } else if (monthName.equalsIgnoreCase("Aug")) {
            monthNum = 7;
        } else if (monthName.equalsIgnoreCase("Sep")) {
            monthNum = 8;
        } else if (monthName.equalsIgnoreCase("Oct")) {
            monthNum = 9;
        } else if (monthName.equalsIgnoreCase("Nov")) {
            monthNum = 10;
        } else if (monthName.equalsIgnoreCase("Dec")) {
            monthNum = 11;
        }
        return monthNum;
    }

    public static String getMonthNameFromNumber(int monthNo) {
        String monthName = "";
        if (monthNo == 1) {
            return "JAN";
        } else if (monthNo == 2) {
            return "FEB";
        } else if (monthNo == 3) {
            return "MAR";
        } else if (monthNo == 4) {
            return "APR";
        } else if (monthNo == 5) {
            return "MAY";
        } else if (monthNo == 6) {
            return "JUN";
        } else if (monthNo == 7) {
            return "JUL";
        } else if (monthNo == 8) {
            return "AUG";
        } else if (monthNo == 9) {
            return "SEP";
        } else if (monthNo == 10) {
            return "OCT";
        } else if (monthNo == 11) {
            return "NOV";
        } else if (monthNo == 12) {
            return "DEC";
        }

        return monthName;
    }

    public static String toCamelCase(String inputString) {
        String result = "";
        if (inputString.length() == 0) {
            return result;
        }
        char firstChar = inputString.charAt(0);
        char firstCharToUpperCase = Character.toUpperCase(firstChar);
        result = result + firstCharToUpperCase;
        for (int i = 1; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            char previousChar = inputString.charAt(i - 1);
            if (previousChar == ' ') {
                char currentCharToUpperCase = Character.toUpperCase(currentChar);
                result = result + currentCharToUpperCase;
            } else {
                char currentCharToLowerCase = Character.toLowerCase(currentChar);
                result = result + currentCharToLowerCase;
            }
        }
        return result;
    }

    public static String getPastWeakDate() {
        int x = -3;
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, x);
        Date sevenDaysAgoDate = cal.getTime();
        String dateString = YYYY_MM_DD_HYPHEN.format(sevenDaysAgoDate.getTime());
        return dateString;
    }

    public static boolean isSapIdValid(String sapId) {
        if (StringUtilityClass.isNotNullAndNotEmpty(sapId)) {
            return sapId.matches("^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$");
        }
        return false;
    }

    public static CharSequence getStringFromStringSet(Set<String> stringSet, String delim) {
        StringBuffer sb = new StringBuffer();
        if (stringSet != null && stringSet.size() > 0) {
            if ("".equals(delim)) {
                delim = ",";
            }
            for (String s : stringSet) {
                sb.append(s);
                sb.append(delim);
            }
            if (!"".equals(sb)) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static String superTrim(String input) {
        if (StringUtilityClass.isNotNullAndNotEmpty(input)) {
            input = input.replaceAll(" ", "").replaceAll("\\s", "").replaceAll("\\n", "");
            return input;
        }
        return "";
    }

  /*  @SuppressWarnings("resource")
    public static String readAddressFromAddressFile() {
        logger.debug("inside method readAddressIdFromAddressFile");
        BufferedReader br = null;
        String addressIds = "";
        Set<Integer> addressIdSet = new HashSet<Integer>();
        try {
            String fileName = StringUtilityClass.isNotNullAndNotEmpty(KeyValuePairCache
                    .getValueForKey(KeyValuePair.UPDATE_ADDRESS_MIGRATION_SCRIPT_FILE_LOCATION)) ? KeyValuePairCache
                    .getValueForKey(KeyValuePair.UPDATE_ADDRESS_MIGRATION_SCRIPT_FILE_LOCATION) : "";
            if (StringUtilityClass.isNotNullAndNotEmpty(fileName)) {
                br = new BufferedReader(new FileReader(fileName));
                String addressIdLine;
                while ((addressIdLine = br.readLine()) != null) {
                    addressIdSet.add(Integer.parseInt(addressIdLine));
                    addressIds = getStringFromIntSet(addressIdSet, ",");
                }
                return addressIds;
            }
        } catch (Exception e) {
            logger.debug("error while reading file from address file");
        }
        return "";
    }*/

    public static String removeSymbolForZigy(String input) {
        if (StringUtilityClass.isNotNullAndNotEmpty(input)) {
            input = input.replaceAll("/", "");
            return input;
        }
        return "";
    }
}
