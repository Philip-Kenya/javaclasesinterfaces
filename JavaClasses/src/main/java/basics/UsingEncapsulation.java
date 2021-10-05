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

}
