package basics;

public class Flight {
	private int seats;
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
public static void main(String[] args) {
	Flight fl1= new Flight();
	fl1.setSeats(200);
	System.out.println(fl1.getSeats());
}
}
