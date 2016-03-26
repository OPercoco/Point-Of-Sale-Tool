
public class Charge {

		public Charge(){
			
		}
		
		public double getCharge(String code){
			if(code.equals("LADW")){
				return 1.99;
			}else if(code.equals("CHNS")){
				return 1.49;
			}else{
				return 2.99;
			}
		}

		/*
		 * returns the prediscount cost
		 */
		public double getCost(int chargeDays, double dCharge) {
			double c = (double) chargeDays;
			return moneyFormat(c * dCharge);
		}

		/*
		 * gets final cost of the tool
		 */
		public double getFinalCost(double cost, String discount) {
			double dis = Double.parseDouble(discount);
			double discountamount = (dis/100) * cost;
			discountamount = moneyFormat(discountamount);
			System.out.println("Discount: $" + discountamount);
			
			double finalCost = cost - (discountamount);
			finalCost = Math.round(finalCost * 100);
			finalCost = finalCost/100;
			return finalCost;
		}
		/*
		 * gives us the money format
		 */
		public double moneyFormat(double money){
			money = Math.round(money * 100);
			money = money/100;
			return money;
		}

		public double getDiscounted(double cost, String discount) {
			double dis = Double.parseDouble(discount);
			double discountamount = (dis/100) * cost;
			discountamount = moneyFormat(discountamount);
			return discountamount;
		}
}

