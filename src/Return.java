/*
 * return class deals with most functions youd use a calendar for
 */
public class Return {
	

	//adding a zero as the first month keeps the index of the array in line with months how youd expect in a date, ie January isn't 0, its 1
	int[] months={0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 	
	/*
	 * Simple constructor
	 */
          public Return(){
        	       	  
        	  
          }
          /*
           * method to split passed string into usable date, also takes in number of days
           */
          public String dates(int[] date, int days){
        	 
        	  
        	  leapYear(date[2]);
        	  int[] checkout = checkout(date, days);
        	  
        	  return checkout[0] + "/" + checkout[1] + "/" + checkout[2];
          }
          
         
		/*
           * calculates the date you return it
           * 
           * *note: change this to make a [][] of all days you have it
           */
          private int[] checkout(int[] date, int days) {
        	int[] returnDate = new int[3];
        	
        	if(date[1] + days > months[date[0]] && date[0] == 12){
        		
				returnDate[0] = 1;
				returnDate[1] = days - (months[date[0]] - date[1]);
				returnDate[2] = date[2] + 1;
			}else if(date[1] + days > months[date[0]] && date[0] != 12){
				returnDate[0] = date[0] + 1;
				returnDate[1] = days - (months[date[0]] - date[1]);
				returnDate[2] = date[2];
					
				
			}else{
				
				returnDate[0] = date[0];
				returnDate[1] = date[1] + days;
				returnDate[2] = date[2];
				
			}
        	int[][] returnArray =  generateArray(date, days);
        	
			
			return returnDate;
		}
          
          /*
           * generates the array of dates the rental period is over, this is then later used to check weekends and holidays.
           */
		public int[][] generateArray(int[] date, int days) {
			int[][]returnArray = new int[days + 1][3];
			
			returnArray[0][0] = date[0];
			returnArray[0][1] = date[1];
			returnArray[0][2] = date[2];
			
			for(int i=1; i<=days; i++){
				if(returnArray[i - 1][1] + 1 > months[returnArray[i - 1][0]] && returnArray[i-1][0] != 12){
				returnArray[i][0]= returnArray[i - 1][0] + 1;
				returnArray[i][1]= 1;
				returnArray[i][2]= returnArray[i - 1][2];
				}else if(returnArray[i - 1][1] + 1 > months[returnArray[i - 1][0]] && returnArray[i-1][0] == 12){
					returnArray[i][0]= 1;
					returnArray[i][1]= 1;
					returnArray[i][2]= returnArray[i - 1][2] + 1;
				}else{
					
					returnArray[i][0]= returnArray[i - 1][0];
					returnArray[i][1]= returnArray[i - 1][1] + 1;
					returnArray[i][2]= returnArray[i - 1][2];
					
				}
				
     		}
        	     
        	return returnArray;
		}
		/*
           * calculates leap year: year%4 == 0; then its a leap year
           */
          public void leapYear(int year){
        	  if(year%4 == 0){
        		  months[2] = 29;
        	  }
          }
          
          
          private void printarray(int[] checkout) {
  			for(int i = 0; i<checkout.length; i++){
  				System.out.print(checkout[i] + ", ");
  			}
  			System.out.println("");
  			
  		}
}
