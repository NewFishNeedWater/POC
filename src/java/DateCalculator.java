import java.util.HashMap;
import java.util.Map;

public class DateCalculator {


    public Integer calculateDaysOfYear(int year, int month, int day){
        if(!checkDateValid(year,month,day)){
            return -1;
        }

        Map<Integer,Integer> monthAndDays= new HashMap<>();
        Integer daysOfYear = day;
        //Put month & days of month to a map
        monthAndDays.put(1,31);
        //If the year is leap year, the days of Feb is 29.
        if (isLeapYear(year)) {
            monthAndDays.put(2,29);
        }else{
            monthAndDays.put(2,28);
        }
        monthAndDays.put(3,31);
        monthAndDays.put(4,30);
        monthAndDays.put(5,31);
        monthAndDays.put(6,30);
        monthAndDays.put(7,31);
        monthAndDays.put(8,31);
        monthAndDays.put(9,30);
        monthAndDays.put(10,31);
        monthAndDays.put(11,30);
        monthAndDays.put(12,31);

        for(Map.Entry<Integer,Integer> entry : monthAndDays.entrySet()){
            //If the month < input month, add to days of month
            if(entry.getKey()<month){
                daysOfYear+=entry.getValue();
            }
        }
        return daysOfYear;
    }

    private Boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private Boolean checkDateValid(int year,int month,int day){

        if(year >= 1970 && month <= 12 && month > 0 && day>0 && day<=31){
            return true;
        }else{
            return false;
        }
    }

}
