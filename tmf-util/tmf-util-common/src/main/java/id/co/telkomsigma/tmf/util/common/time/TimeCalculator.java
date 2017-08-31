package id.co.telkomsigma.tmf.util.common.time;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TimeCalculator {

	/**
	 * 
	 * @param p_DateToVerify
	 * @param p_DateFromDB
	 * @return false : expired, true : valid
	 */
	public static boolean calculateExpiryDate(Date p_DateToVerify, Date p_DateFromDB) {
		if (p_DateToVerify.compareTo(p_DateFromDB) < 0){
			return true;
		}
        return false;
    }
	
	/*
	*  Convenience method to add a specified number of minutes to a Date object
	*  From: http://stackoverflow.com/questions/9043981/how-to-add-minutes-to-my-date
	*  @param  minutes  The number of minutes to add
	*  @param  beforeTime  The time that will have minutes added to it
	*  @return  A date object with the specified number of minutes added to it 
	*/
	public static Date addMinutesToDate(int minutes, Date beforeTime){
	    final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

	    long curTimeInMs = beforeTime.getTime();
	    Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
	    return afterAddingMins;
	}
	
	public static int getDaysBetweenTwoDates(Date p_DateStart, Date  p_DateEnd){
		 Calendar cal1 = new GregorianCalendar();
	     Calendar cal2 = new GregorianCalendar();
	     cal1.setTime(p_DateStart);
	     cal2.setTime(p_DateEnd);
		return (int)( (cal1.getTime().getTime() - cal2.getTime().getTime()) / (1000 * 60 * 60 * 24));
	}
	
	public static Date addNDaysToDate(int p_NumberOfDaysToAdd, Date p_DateToModify){
		Calendar c = Calendar.getInstance();
		c.setTime(p_DateToModify);
		c.add(Calendar.DATE, p_NumberOfDaysToAdd);		
		return c.getTime();
	}
}
