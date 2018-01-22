package day6;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class Day6Localization {

    public static void main(String[] args) {

        String langCode = "vi";
        String cntrCode = "vn";
        Locale current = Locale.getDefault();
        Locale vietnam = new Locale(langCode, cntrCode);
        Locale russian = new Locale("ru", "ru");

        ZonedDateTime today = ZonedDateTime.now();

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, current);
        System.out.println(df.format(today.toInstant().toEpochMilli()));

        DateFormat dfv = DateFormat.getDateInstance(DateFormat.FULL, vietnam);
        System.out.println(dfv.format(today.toInstant().toEpochMilli()));

        DateFormat dfr = DateFormat.getDateInstance(DateFormat.FULL, russian);
        System.out.println(dfr.format(today.toInstant().toEpochMilli()));

        NumberFormat nf = NumberFormat.getCurrencyInstance(current);
        NumberFormat nfr = NumberFormat.getCurrencyInstance(russian);
        NumberFormat nfv = NumberFormat.getCurrencyInstance(vietnam);

        System.out.println(nf.format(2000));
        System.out.println(nfr.format(2000));
        System.out.println(nfv.format(2000));

        ResourceBundle bundle = ResourceBundle.getBundle("day6/resources", russian);
        System.out.println(bundle.getString("greeting"));
    }
}
