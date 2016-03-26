import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * class to calculate the two Discounts, july 4th, and independance day.  July 4th is either July 4th, or the closest weekday it falls on. Independance is
 * the first monday in september
 */
public class Discount {
	public String ind;
	public String jul;
	     public Discount(){
        	  		 
 		
         }
         public void calculateDiscount(int[] date) throws ParseException{
        	 int year = date[2];
         	ind = findIndependanceDay(year);
         	jul = findJulyFourth(year);
         
       }
         
         /*
          * method to find where independance day falls
          */
		private String findIndependanceDay(int year) throws ParseException {
			String testyear = "20" + year;
			for (int i =1; i < 8; i++){
			     String test = 9 + "/" + i + "/" + testyear;
				
			     int dayOfWeek = getDayOfWeek(test);
	 		     
	 		     if(dayOfWeek == 2){
	 		    	 return "9/" + i + "/20" + year;
	 		    	
	 		     }
			}
			return null;
		    }
		 /*
         * method to find where July 4th day falls
         */
		private String findJulyFourth(int year) throws ParseException {
			int day = 4;
			
			int dayOfWeek = getDayOfWeek("7/4/20" + year);
			  //this if statement checks if july 4th is a weekend, if its sunday (1) it adds one day to get the monday, if its saturday (7) it subtracts one day
	 		if (dayOfWeek == 1 || dayOfWeek == 7){
	 			 if (dayOfWeek == 1){day = day + 1;}
	 			 else if(dayOfWeek == 7){ day = day - 1;}
	 		 }
	 		
	 		 return "7/" + day + "/20" + year;
	 		
	 		 
		}
		/*
		 * method finds how many chargeable days are in each rental period using the following: 
		 * the rental code, the start date, the end date, and how many weekends/holidays fall inbetween
		 * each rental code has a different way of being charged
		 */
		public int chargeDays(String code, int[][] dates, int days) throws ParseException{
			int charge = days;
			int weekends = 0;
			String date = "";
			
			if(code.equals("LADW")){ //handles the ladder, charged every day
			   return days;
			}else if(code.equals("CHNS")){ //handles the chainsaw, no charge for weekends
				for(int i = 0; i < dates.length; i++){
					date = dates[i][0] + "/" + dates[i][1] + "/" + dates[i][2];
					if(getDayOfWeek(date) == 1 || getDayOfWeek(date) == 7){
						weekends = weekends + 1;
					}
				    
				}
				charge = days - weekends;
			}else{ //handles the jackhammer, no charge for weekends or holidays
				for(int i = 0; i < dates.length; i++){
				date = dates[i][0] + "/" + dates[i][1] + "/20" + dates[i][2];
				if(getDayOfWeek(date) == 1){//sunday
					weekends = weekends + 1;								
				}
				else if(getDayOfWeek(date) == 7){//saturday
					weekends = weekends + 1;
					}
				else if(isHoliday(date) == true){//holiday
					weekends = weekends + 1;
														
				}
			}
				charge = days - weekends;
			}
			
			
			return charge;
		}
		
		/*
		 * quick method to check if passed date is a holiday
		 */
		private boolean isHoliday(String date) {
			
			if(date.equals(jul)){
			
				return true;
			}
			if(date.equals(ind)){
				
				return true;
			}
			return false;
		}
		/*
		 * quick method to check what day of the week it is, SUNDAY = 1;
		 */
		public int getDayOfWeek(String Date) throws ParseException{
			 Date yourDate = new SimpleDateFormat("M/dd/yyyy").parse(Date);
	 		 Calendar c = Calendar.getInstance();
	 		 c.setTime(yourDate);
	 		 int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	 		 
	 		 return dayOfWeek;
		}
		
}
