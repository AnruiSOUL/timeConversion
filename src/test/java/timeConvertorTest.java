import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by randallcrame on 2/15/17.
 */
public class timeConvertorTest {
    String time,time2, time3, time4, time5, time6, time7, time8, time9, nottime, time10;

    @Before
    public void setUp(){
        time = "1:30 PM";
        time2 ="12:50 AM";
        time3 = "4:12 pm";
        time4 = "10:34 am";
        time5 = "23:11 pm";
        time6 = "13:34 Pm";
        time7 = "12:99 pm";
        time8 = "10:22 pp";
        time9 = "1:30am";
        nottime = "isijsdfj";
        time10 = "10:i0 AM";
    }

    @Test
    public void isTimeTest(){
        boolean actual = TimeConvertor.isTimeFormat(time);
        Assert.assertTrue("Expects True to match patten", actual);
    }

    @Test
    public void isTime2Test(){
        boolean actual = TimeConvertor.isTimeFormat(time2);
        Assert.assertTrue("Expects True to match patten", actual);
    }

    @Test
    public void isTime3Test(){
        boolean actual = TimeConvertor.isTimeFormat(time3);
        Assert.assertTrue("Expects True to match patten", actual);
    }

    @Test
    public void isTime4Test(){
        boolean actual = TimeConvertor.isTimeFormat(time4);
        Assert.assertTrue("Expects True to match patten", actual);
    }

    @Test
    public void isTime5Test(){
        boolean actual = TimeConvertor.isTimeFormat(time5);
        Assert.assertFalse("Expects False due to 23 hours to match patten", actual);
    }

    @Test
    public void isTime6Test(){
        boolean actual = TimeConvertor.isTimeFormat(time6);
        Assert.assertFalse("Expects False due to 13 hours to match patten", actual);
    }

    @Test
    public void isTime7Test(){
        boolean actual = TimeConvertor.isTimeFormat(time7);
        Assert.assertFalse("Expects False to match patten", actual);
    }

    @Test
    public void isTime8Test(){
        boolean actual = TimeConvertor.isTimeFormat(time8);
        Assert.assertFalse("Expects False to match patten", actual);
    }

    @Test
    public void isTime9Test(){
        boolean actual = TimeConvertor.isTimeFormat(time9);
        Assert.assertFalse("Expects False due to spacing to match patten", actual);
    }
    @Test
    public void isTime10Test(){
        boolean actual = TimeConvertor.isTimeFormat(time10);
        Assert.assertFalse("Expects False due to NonDigit to match patten", actual);
    }

    @Test
    public void isTimeNotTimeTest(){
        boolean actual = TimeConvertor.isTimeFormat(nottime);
        Assert.assertFalse("Expects False due to not being a time to match patten", actual);
    }

    @Test
    public void parseTimeHoursTest(){
        String expected = "1";
        String actual = TimeConvertor.parseTime(time)[0];
        Assert.assertEquals("Expects to return '1'", expected, actual);
    }

    @Test
    public void parseTimeMinutesTest(){
        String expected = "30";
        String actual = TimeConvertor.parseTime(time)[1];
        Assert.assertEquals("Expects to return '30'", expected, actual);
    }

    @Test
    public void parseTimePMTest(){
        String expected = "PM";
        String actual = TimeConvertor.parseTime(time)[2];
        Assert.assertEquals("Expects to return 'PM'", expected, actual);
    }

    @Test
    public void convertHourTest(){
        String expected = " twelve";
        String actual = TimeConvertor.convertHour(TimeConvertor.parseTime(time2)[0]);
        Assert.assertEquals("Expects to return 'twelve'", expected, actual);
    }

    @Test
    public void convertMinutes50Test(){
        String expected = " fifty";
        String actual = TimeConvertor.convertMinutes(TimeConvertor.parseTime(time2)[1]);
        Assert.assertEquals("Expects to return ' fifty'", expected, actual);
    }

    @Test
    public void convertMinutesTwelveTest(){
        String expected = " twelve";
        String actual = TimeConvertor.convertMinutes(TimeConvertor.parseTime(time3)[1]);
        Assert.assertEquals("Expects to return 'twelve'", expected, actual);
    }

    @Test
    public void convertMinutesTest(){
        String expected = " thirty four";
        String actual = TimeConvertor.convertMinutes(TimeConvertor.parseTime(time4)[1]);
        Assert.assertEquals("Expects to return 'thirty four'", expected, actual);
    }

    @Test
    public void convertAMTest(){
        String expected = " ante meridiem.";
        String actual = TimeConvertor.convertAMPM(TimeConvertor.parseTime(time2)[2]);
        Assert.assertEquals("Expects to return ' ante meridiem.'", expected, actual);
    }

    @Test
    public void convertPMTest(){
        String expected = " post meridiem.";
        String actual = TimeConvertor.convertAMPM(TimeConvertor.parseTime(time)[2]);
        Assert.assertEquals("Expects to return ' post meridiem.'", expected, actual);
    }

    @Test
    public void tellTimeTest(){
        String expected = "The time is one thirty post meridiem.";
        String actual = TimeConvertor.tellTime(time);
        Assert.assertEquals("Return the proper time.", expected, actual);
    }

    @Test
    public void tellTimeElseTest(){
        String expected = "Not a properly formatted time";
        String actual = TimeConvertor.tellTime(time9);
        Assert.assertEquals("Return the else String", expected, actual);
    }
}
