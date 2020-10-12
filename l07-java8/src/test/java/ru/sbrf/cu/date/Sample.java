package ru.sbrf.cu.date;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sample {
    @Test
    public void testDate(){
        Date date = new Date(); // масло маслянное, да ещё и маслом помазанное?..
        Calendar calendar = new GregorianCalendar();
        // TODO внимательно на месяц
        calendar.set( 2015, 9, 16 );
        date = calendar.getTime();
    }

    @Test
    public void printTodayInAnyCalendars(){
        DateFormat format = new SimpleDateFormat("dd/MM/yy");
        System.out.println(format.format(new Date())); //12/10/20
    }


    @Test
    public void testLocalDate(){

        LocalDate localDate = LocalDate.of(1961, 4, 12);
        LocalDate now = LocalDate.now();
        localDate.format(DateTimeFormatter.ofPattern("dd/MM/yy"));

        LocalDateTime localDateTime = LocalDateTime
                .of(1961, 4, 12, 9, 7 );
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Europe/Paris"));
        System.out.println(zonedDateTime);
    }


}
