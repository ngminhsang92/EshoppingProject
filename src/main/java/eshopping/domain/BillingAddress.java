package eshopping.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class BillingAddress implements Serializable {
	
	private static final long serialVersionUID = -6091579459463730482L;
	

	@Id
	@GeneratedValue
	private int billingAddressId;
	
	@NotEmpty(message="The street name must not be null")
	private String streetName;
	private String apartmentNumber;
	@NotEmpty(message="The city name must not be null")
	private String city;
	@NotEmpty(message="The state name must not be null")
	private String state;
	@NotEmpty(message="The country name must not be null")
	private String country;
	@NotEmpty(message="The zip code must be not null")
	@Pattern(regexp="[0-9]+", message="Wrong zip")
	private String zipCode;
	
	@OneToOne
    private Customer customer;
	
	public int getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(int billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "BillingAddress{" +
                "streetName='" + streetName + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
	
	

}
