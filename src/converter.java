
public class converter {
	public converter(){
		
	}
	/*
	 * converts a string into a useable date array
	 */
	public int[] getDate(String a){
		int[] date = new int[3];
		String[] b = a.split("/");
		date[0] = Integer.parseInt(b[0]);
		date[1] = Integer.parseInt(b[1]);
		date[2] = Integer.parseInt(b[2]);
		
		return date;
	}
	
	/*
	 * converts a string into a day
	 */
	public int getDays(String a){
		return Integer.parseInt(a);
	}
}
