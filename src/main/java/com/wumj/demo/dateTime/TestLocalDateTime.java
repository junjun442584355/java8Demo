package com.wumj.demo.dateTime;

import org.junit.Test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Set;

/**
 * @author wumj
 * @date 2020-06-20 13:47
 */
public class TestLocalDateTime {
    /*
    * LocalDate
    * LocalTime
    * LocalDateTime
    *
    * */
    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("ldt = " + ldt);

        LocalDate of1 = LocalDate.of(2019, 9, 7);
        System.out.println("of1 = " + of1);

                LocalDateTime of = LocalDateTime.of(2019, 9, 7, 18, 8, 34);
        System.out.println("of = " + of);

        System.out.println(ldt.plusYears(2));

        System.out.println(ldt.minusHours(5));

        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getDayOfYear());
        System.out.println(ldt.getDayOfWeek());
        System.out.println(ldt.getMonthValue());


        System.out.println();
    }

    /*
    * instant时间戳
    * */

    @Test
    public void test2(){
        Instant now = Instant.now();
        System.out.println("now = " + now);//默认获取UTC时区
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);

        System.out.println(now.toEpochMilli());
        System.out.println(Instant.ofEpochSecond(1));
    }


    /*
    * Duration:计算两个时间的间隔
    * Period：计算两个日期间的间隔
    *
    * */
    @Test
    public void test3(){
        Instant now = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant now1 = Instant.now();
        System.out.println(Duration.between(now, now1).toMillis());

        System.out.println("------------------------------");

        LocalTime lt =LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime lt2 =LocalTime.now();
        System.out.println(Duration.between(lt, lt2).toMillis());


    }

    @Test
    public void test4(){
        LocalDate ld=LocalDate.now();
        LocalDate localDate = LocalDate.of(2021,4,7);
        System.out.println(Period.between(ld, localDate) );

    }

    /*
    * TemporalAdjuster:时间矫正器
    *
    *
    * */
    @Test
    public void test5(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime localDateTime = now.withDayOfMonth(21);
        System.out.println("localDateTime = " + localDateTime);

        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("with = " + with);
        System.out.println(now);

        /*自定义*/
        LocalDateTime with1 = now.with((e) -> {
            LocalDateTime ldt = (LocalDateTime) e;
            DayOfWeek dayOfWeek = ldt.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(1);
            }

        });
        System.out.println("with1 = " + with1);
    }

    /*
    * DateTimeFormatter:格式化时间/日期
    * */
    @Test
    public void test6(){
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now1 = now.plusDays(1);
        String format = now.format(isoDateTime);
        System.out.println("isoDateTime = " + format);

        /*
        * 自定义
        * */
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy--MM===dd HH:mm:ss");
        System.out.println(now.format(dateTimeFormatter));
        System.out.println(dateTimeFormatter.format(now1));

        String format1 = dateTimeFormatter.format(now1);
        LocalDateTime parse = LocalDateTime.parse(format1,dateTimeFormatter);
        System.out.println("parse = " + parse);

    }

    /*
    * ZonedDate,ZoneTime,ZoneDateTime
    *
    * */
    @Test
    public void test7() throws ParseException {
        /*Set<String> zoneSet = ZoneId.getAvailableZoneIds();
        zoneSet.forEach(System.out::println);*/

        /*LocalDateTime date = LocalDateTime.now();
        LocalDateTime firstday = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("firstday:" + firstday);
        System.out.println("now:" + date);
        System.out.println("lastDay:" + lastDay);*/


       /* DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("now = " + now.format(dateTimeFormatter));
        LocalDateTime beginDateTime = now.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0);
        System.out.println("beginDateTime = " + beginDateTime.format(dateTimeFormatter));
        LocalDateTime endDateTime = now.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59);
        System.out.println("endDateTime = " + endDateTime);

        LocalDateTime dayendDateTime = now.withHour(0).withMinute(0).withSecond(0);
        System.out.println("endDateTime = " + dayendDateTime);*/



        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now.format(formatter) = " + now.format(formatter));
        LocalDateTime beginDateTime = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("beginDateTime.format(formatter) = " + beginDateTime.format(formatter));
*/

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");

            Date clockInTime = sdf.parse("16:29");
            Date beOnDutyTime = sdf.parse("08:03");
           long time = clockInTime.getTime() - beOnDutyTime.getTime();
        System.out.println("time = " + time);
        Date result = new Date(time);
        System.out.println(sdf.format(result));






    }

    @Test
    public void test8(){
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);

        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("Asia/Aden"));
        ZonedDateTime zonedDateTime = now1.atZone(ZoneId.of("Asia/Aden"));
        System.out.println("zonedDateTime = " + zonedDateTime);
    }

    @Test
    public void test09(){
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, 2020);

        cal.set(Calendar.MONTH, 7-1);

        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));

        Date time = cal.getTime();
        String format = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
        System.out.println("format = " + format);
    }

    @Test
    public void test10(){
        System.out.println(getIpAddress());
    }

    public String getIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("IP地址获取失败" + e.toString());
        }
        return "";
    }


}
