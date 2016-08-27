package eshopping.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import eshopping.domain.BillingAddress;
import eshopping.domain.Cart;
import eshopping.domain.ShippingAddress;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Customer implements Serializable {
	
	 private static final long serialVersionUID = 5140900014886997914L;
	 
	 @Id
	 @GeneratedValue
	 private int customerId;
	 
	 @NotEmpty(message="The customer name must not be null")
	 @NotNull(message="The customer name must not be null")
	 private String customerName;
	 
	 @NotEmpty(message="The customer email must not be null")
	 @Pattern(regexp=".+@.+\\..+", message="Wrong email")
	 private String customerEmail;
	 private String customerPhone;
	 
	 @NotEmpty(message="The customer username must not be null")
	 private String username;
	 
	 @NotEmpty(message="The customer password must not be null")
	 @Length(min=6, message="Password should be more than 5 characters")
	 private String password;
	 
	 private boolean enabled;
	
	 @OneToOne
	 @JoinColumn(name="billingAddressId")
	 @Valid
	 private BillingAddress billingAddress;
	 
	 @OneToOne
	 @JoinColumn(name="shippingAddress")
	 @Valid
	 private ShippingAddress shippingAddress;
	 
	 @OneToOne
	 @JoinColumn(name="cartId")
	 @JsonIgnore
	 private Cart cart;

	 public int getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(int customerId) {
	        this.customerId = customerId;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getCustomerEmail() {
	        return customerEmail;
	    }

	    public void setCustomerEmail(String customerEmail) {
	        this.customerEmail = customerEmail;
	    }

	    public String getCustomerPhone() {
	        return customerPhone;
	    }

	    public void setCustomerPhone(String customerPhone) {
	        this.customerPhone = customerPhone;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public boolean isEnabled() {
	        return enabled;
	    }

	    public void setEnabled(boolean enabled) {
	        this.enabled = enabled;
	    }

	    public BillingAddress getBillingAddress() {
	        return billingAddress;
	    }

	    public void setBillingAddress(BillingAddress billingAddress) {
	        this.billingAddress = billingAddress;
	    }

	    public ShippingAddress getShippingAddress() {
	        return shippingAddress;
	    }

	    public void setShippingAddress(ShippingAddress shippingAddress) {
	        this.shippingAddress = shippingAddress;
	    }

	    public Cart getCart() {
	        return cart;
	    }

	    public void setCart(Cart cart) {
	        this.cart = cart;
	    }

}
