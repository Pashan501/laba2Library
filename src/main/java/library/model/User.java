package library.model;

public class User {
	private long id;
	private String name;
	private String firstName;
	private String email;
	private String country;
	private String city;
	private String street;
	private String password;
	public User() {
		
	}
	public User(long id, String name, String firstName, String email, String country, String city, String street,
			String password) {
		
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.country = country;
		this.city = city;
		this.street = street;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", firstName=" + firstName + ", email=" + email + ", country="
				+ country + ", city=" + city + ", street=" + street + ", password=" + password + "]";
	}
	

}
