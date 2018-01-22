package day5;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Day5DateTime {

    // 00.00  1 JAN 1970 - start..     number of milliseconds since this

    // ALSO HAVE NANO AND MILLI for ZonedDateTime/LocalDateTime/LocalTime -- java.TIME (two diff)

    // THEY COME FROM TIMEZONES

    public static void main(String[] args) {

        Date today = new Date();
        System.out.println(today.getTime()); // get ms for today
        System.out.println(today.toString());

        GregorianCalendar gDate = new GregorianCalendar(1989,1,21);
        Date dob = new Date(gDate.getTimeInMillis());
        System.out.println(dob.before(today));

        Locale loc = new Locale("en", "US");
        DateFormat df = SimpleDateFormat.getDateInstance(SimpleDateFormat.FULL, loc);
        System.out.println(df.format(today));

        Date beginning = new Date(Long.MAX_VALUE);
        System.out.println(df.format(beginning));

        System.out.println("-------------------------------");
        // comes in Java SE8
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(zdt.toString());


        ZonedDateTime todayzdt = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        LocalDateTime dateob = LocalDateTime.of(1973,5,10,0,0,0);

        long daysAlice = TimeUnit.MILLISECONDS.toDays(todayzdt.toInstant().toEpochMilli() - dob.toInstant().toEpochMilli());
        System.out.println(daysAlice / 365);

    }
}
