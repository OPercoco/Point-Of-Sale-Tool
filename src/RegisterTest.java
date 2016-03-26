import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;


public class RegisterTest {

	@Test
	public void testinput() throws ParseException, inputException{
		String[] rentaltest = {"LADW", "9/3/15", "5", "10"};
		String[] rentaloutput={"LADW", "9/3/15", "5", "10", "9/8/15", "1.99", "5", "$9.95", "10", "$1.00", "$8.95"};
				
		Register register = new Register();
		assertArrayEquals(rentaloutput, register.PointOfSaleTool(rentaltest));
		
		String[] rentaltest2 = {"CHNS", "7/2/15", "5", "25"};
		String[] rentaloutput2={"CHNS", "7/2/15", "5", "25", "7/7/15", "1.49", "3", "$4.47", "25", "$1.12", "$3.35"};
				
		assertArrayEquals(rentaloutput2, register.PointOfSaleTool(rentaltest2));
		
		String[] rentaltest3 = {"JAKD", "9/3/15", "6", "0"};
		String[] rentaloutput3={"JAKD", "9/3/15", "6", "0", "9/9/15", "2.99", "3", "$8.97", "0", "$0.00", "$8.97"};
				
		assertArrayEquals(rentaloutput3, register.PointOfSaleTool(rentaltest3));
		
		String[] rentaltest4 = {"JAKR", "7/2/20", "4", "50"};
		String[] rentaloutput4={"JAKR", "7/2/20", "4", "50", "7/6/20", "2.99", "1", "$2.99", "50", "$1.50", "$1.49"};
				
		assertArrayEquals(rentaloutput4, register.PointOfSaleTool(rentaltest4));
		
		String[] rentaltest5 = {"JAKD", "9/3/15", "5", "101"};
		String[] rentaloutput5={"JAKD", "9/3/15", "5", "101", "Exception"};
		
		//should fail here
		//assertArrayEquals(rentaloutput5, register.PointOfSaleTool(rentaltest5));
		}
		
	}
	
	/*
	 * this test the individual methods and classes that make up the tool
	 
	public void testMain() throws ParseException, inputException {
		String[] rentaltest = {"LADW", "9/3/15", "5", "15"};
		
		converter convert = new converter();
		int[] date = convert.getDate(rentaltest[1]); 
		int days = convert.getDays(rentaltest[2]);  
		Return returner = new Return();
		assertEquals("9/8/15", returner.dates(date, days));
		Charge charge = new Charge();
		double dCharge = charge.getCharge(rentaltest[0]);
		assertEquals(1.99, charge.getCharge(rentaltest[0]), 0.01);
		Discount discount = new Discount();
		discount.calculateDiscount(date);
	    int[][] dateArray = returner.generateArray(date, days);
		int chargeDays = discount.chargeDays(rentaltest[0], dateArray, days);
		assertEquals(5, discount.chargeDays(rentaltest[0], dateArray, days));
		double cost = charge.getCost(chargeDays, dCharge);
		assertEquals(9.95, charge.getCost(chargeDays, dCharge), 0.01);
		assertEquals(8.46, charge.getFinalCost(cost, rentaltest[3]), 0.01);
	}
	}
	*/


