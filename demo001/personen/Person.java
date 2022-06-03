package demo001.personen;

public abstract class  Person {

	private int nr; 
	protected String lastName;
	protected String firstName;
	
	public Person(int nr, String lastname, String firstname) {
		
		this.nr=nr;
		this.lastName=lastname;
		this.firstName=firstname;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		
		this.nr = nr;
	}

	public String getLastName() {		
		return lastName;
	}

	public void setLastname(String lastname) {
		
		this.lastName = lastname;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		
		this.firstName = firstname;
	}
	
	protected abstract void printAusweis();
	
}