import com.sun.tools.javac.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tester {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date beginDate = dateFormat.parse("1970-01-01");
        Date endDate = dateFormat.parse("9999-12-31");
        //get random date
        Long time = (long) (Math.random()*(endDate.getTime()-beginDate.getTime()));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));

        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH);
        Integer day = calendar.get(Calendar.DATE);

        DateCalculator calculator = new DateCalculator();
        //check if the calculator works fine
        Assert.check(-1 == calculator.calculateDaysOfYear(1960,2,28));
        Assert.check(-1 == calculator.calculateDaysOfYear(1970,13,31));
        Assert.check(-1 == calculator.calculateDaysOfYear(1970,12,32));
        Assert.check(28+31 == calculator.calculateDaysOfYear(2021,2,28));


        System.out.println("---------------Input Year : " + year);
        System.out.println("---------------Input Month : " + month);
        System.out.println("---------------Input Day : " + day);

        Integer daysOfYear = calculator.calculateDaysOfYear(year,month,day);

        System.out.println("---------------Days Of Year : " +daysOfYear);

    }






}
