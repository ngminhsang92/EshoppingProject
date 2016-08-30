package eshopping.integrationImpl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estore.integration.JMSSender;

@Component
public class JMSSenderImpl implements JMSSender{
	//@Autowired hornetq
	//private JmsTemplate jmsTemplate;
	
	//Rabbitmq
	@Autowired
	private RabbitTemplate rabbitTemplate;
    
    public void sendJMSMessage(final String text) {
    	/*
    	if (jmsTemplate != null)
    	{
	    	MessageCreator mc = new MessageCreator() {
	        	public Message createMessage(Session session) throws JMSException {
	                return session.createTextMessage(text);
	              }
	    	};
	    	
	        jmsTemplate.send(mc);            
	        System.out.println("Sending message with text : " + text);
    	}*/
    	
    	if (rabbitTemplate != null)
    	{
    		rabbitTemplate.convertAndSend(text);
    		System.out.println("Sending message with text : " + text);
    	}

    }
}
