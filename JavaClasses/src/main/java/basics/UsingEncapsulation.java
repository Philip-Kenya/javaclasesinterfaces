package basics;

class UsingEncapsulation {
	private int pass, seats;

	UsingEncapsulation() {

	}

	public void addPassager(){
		if(pass<seats)
			pass+=1;
		else
			handleTooMany();

	}

	private void handleTooMany() {
		System.out.println("Too many");	
	}
	
	public boolean hasRoom(UsingEncapsulation f1)
	{
		int total= this.pass + f1.pass;
		return total<this.seats;
	}

}
