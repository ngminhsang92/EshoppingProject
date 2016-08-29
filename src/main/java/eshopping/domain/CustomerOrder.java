package eshopping.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.util.StringUtils;

import eshopping.domain.BillingAddress;
import eshopping.domain.Cart;
import eshopping.domain.Customer;
import eshopping.domain.ShippingAddress;

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class CustomerOrder implements Serializable{


    private static final long serialVersionUID = -1546649310334411202L;

    @Id
    @GeneratedValue
    private int customerOrderId;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "customerId")
    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name="shippingAddressId")
    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    private ShippingAddress shippingAddress;

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
    
    public void validateItemsInfo(MessageContext messages) {
        //MessageContext messages = context.getMessageContext();
        if (StringUtils.isEmpty(this.cart.getCustomer().getCustomerName())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.customerName").
                defaultText("The customer name must not be null").build());
        } 
        else if (StringUtils.isEmpty(this.cart.getCustomer().getCustomerEmail())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.customerEmail").
                defaultText("The customer email must not be null").build());
        }
        else if (StringUtils.isEmpty(this.cart.getCustomer().getBillingAddress().getStreetName())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.billingAddress.streetName").
                    defaultText("The street name must not be null").build());
        } 
        else if (StringUtils.isEmpty(this.cart.getCustomer().getBillingAddress().getCity())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.billingAddress.city").
                    defaultText("The city name must not be null").build());
        }
        else if (StringUtils.isEmpty(this.cart.getCustomer().getBillingAddress().getState())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.billingAddress.state").
                    defaultText("The state name must not be null").build());
        } 
        else if (StringUtils.isEmpty(this.cart.getCustomer().getBillingAddress().getCountry())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.billingAddress.country").
                    defaultText("The country name must not be null").build());
        }
        else if (StringUtils.isEmpty(this.cart.getCustomer().getBillingAddress().getZipCode())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.billingAddress.zipCode").
                    defaultText("The zipCode must not be null").build());
        }
    
    }
    public void validateShippingDetail(ValidationContext context) {
        MessageContext messages = context.getMessageContext();
        if (StringUtils.isEmpty(this.cart.getCustomer().getShippingAddress().getStreetName())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.shippingAddress.streetName").
                    defaultText("The Street name must not be null").build());
        }
        else if (StringUtils.isEmpty(this.cart.getCustomer().getShippingAddress().getCity())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.shippingAddress.city").
                    defaultText("The City name must not be null").build());
        }
        else if (StringUtils.isEmpty(this.cart.getCustomer().getShippingAddress().getState())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.shippingAddress.state").
                    defaultText("The State name must not be null").build());
        }
        else if (StringUtils.isEmpty(this.cart.getCustomer().getShippingAddress().getCountry())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.shippingAddress.country").
                    defaultText("The Country must not be null").build());
        }
        else if (StringUtils.isEmpty(this.cart.getCustomer().getShippingAddress().getZipCode())) {
            messages.addMessage(new MessageBuilder().error().source("cart.customer.shippingAddress.zipCode").
                    defaultText("The zipCode must not be null").build());
        }
    }
}