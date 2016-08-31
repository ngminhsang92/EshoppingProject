package eshopping.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;


@Aspect
public class LoggerAdvice {
	    @Autowired
	    private ILogger logger;
	    
		@Before("within(eshopping.dao.daoImpl.*)")
		public void logbeforemethod(JoinPoint joinpoint){
			//System.out.println("Before calling method = " + joinpoint.getSignature().getName());	
			logger.log("calling -- " + joinpoint.getTarget()+ "." + joinpoint.getSignature().getName() + "-- method ");
		}
		
		@Around("within(eshopping.dao.daoImpl.*)")
		public Object invoke(ProceedingJoinPoint call ) throws Throwable {
			 StopWatch sw = new StopWatch();
			 sw.start(call.getSignature().getName());
			 Object retVal = call.proceed();
			 sw.stop();

			long totaltime = sw.getLastTaskTimeMillis();
			
			//System.out.println("Time to execute --" + call.getSignature().getName() + "-- method  took " + totaltime + "ms");
			logger.log("Time to execute --"+ call.getTarget()+ "." + call.getSignature().getName() + "-- method  took " + totaltime + "ms");
			
			return retVal;
		}
		
//		@After("execution(* com.estore.integration.impl.JMSSenderImpl.sendJMSMessage(..)) && args(text)")
//		public void logafterjmsmethod(JoinPoint joinpoint,String text){
//			//System.out.println("After calling method = " + joinpoint.getSignature().getName() + "  Text: " + text);
//			logger.log(text);
//		}
		
}
