package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int address;
	private String street;
	private String city;
	private String state;
	private int zip;
	
	public House() {
		super();
		this.address = 1234;
	}
	
	public House(int address, String street, String city, String state, int zip) {
		super();
		setAddress(address);
		setStreet(street);
		setCity(city);
		setState(state);
		setZip(zip);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return address + " " + street + "\n" + city + ", " + state + " " + zip;
	}
	
	
}
