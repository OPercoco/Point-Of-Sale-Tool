import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
 * calculate start and end date
 * send off to discount
 * calculate whether discount dates are inbetween those dates
 * 
 * then, calculate total cost
 */
public class Register {
/*
 * Objects are stored as String arrays, and parsed when necessary.  [tool code][checkout date][rental days][discount]
 * 
 */
	public String[] PointOfSaleTool(String[] input) throws ParseException, inputException {
		//String[] input = {"JAKR", "7/2/20", "4", "50"};
		String[] output = new String[11];
		output[0] = input[0];
		output[1] = input[1];
		output[2] = input[2];
		output[3] = input[3];
		//fires up the converter
		converter convert = new converter();
		int[] date = convert.getDate(input[1]); //gets the date
		int days = convert.getDays(input[2]);   //gets the days rented
		
		//this block of code handles the exception catching
		if(days < 1){ 
			throw new inputException("Sorry, you cannot rent for less than one day ");
			
		}
		if(Integer.parseInt(input[3]) > 100){
			throw new inputException("Sorry, you cannot have a discount greater than 100%");
			
		}
		else if(Integer.parseInt(input[3]) < 0){
			throw new inputException("Sorry, you cannot have a discount less than 0%");
			
		}
		//prints all the necessary info for the input
		System.out.println("Tool Code: " + input[0]);
		System.out.println("Checkout Day: " + input[1]);
		System.out.println("Rental Days: " + input[2]);
		System.out.println("Discount: " + input[3] + "%");
		System.out.println("=======output zone=======");
		
				
		//returner handles the days the tool will be out, and when it will get returned
		Return returner = new Return();
		String rDate = returner.dates(date, days);
		System.out.println("Return date: " + rDate);
		output[4] = rDate;
		//get daily charge
		Charge charge = new Charge();
		double dCharge = charge.getCharge(input[0]);
		System.out.println("Daily charge: $" + dCharge);
		output[5] = "" + dCharge;
		//calculates holidays and discounts
		Discount discount = new Discount();
		discount.calculateDiscount(date);
		
		
		int[][] dateArray = returner.generateArray(date, days);
		
		int chargeDays = discount.chargeDays(input[0], dateArray, days);
		System.out.println("Charge days: " + chargeDays);
		output[6] = chargeDays + "";
		double cost = charge.getCost(chargeDays, dCharge);
		System.out.println("Prediscount charge: " + charge.moneyFormat2(cost));
		output[7] = "" + charge.moneyFormat2(cost);
		System.out.println("Discount: " + input[3] + "%");
		output[8] = input[3] + "";
		double discounted = charge.getDiscounted(cost, input[3]);
		output[9] = charge.moneyFormat2(discounted);
		double Fcost = charge.getFinalCost(cost, input[3]);
		System.out.println("Final cost: $" + Fcost);
		output[10] = charge.moneyFormat2(Fcost);
		return output;
	}
    
}
