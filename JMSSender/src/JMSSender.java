import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.naming.InitialContext;
                                                                           
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueSender;
import javax.jms.DeliveryMode;
import javax.jms.QueueSession;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
public class JMSSender {

	 public static void main(String[] args) {  
	        try  
	        {   //Create and start connection  
	            InitialContext ctx=new InitialContext();  
	            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("myqueueconnection");  
	            QueueConnection con=f.createQueueConnection();  
	            con.start();  
	            //2) create queue session  
	            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
	            //3) get the Queue object  
	            Queue t=(Queue)ctx.lookup("myqueue");  
	            //4)create QueueSender object         
	            QueueSender sender=ses.createSender(t);  
	            //5) create TextMessage object  
	            TextMessage msg=ses.createTextMessage();  
	             msg.setText("Yes i am sending the text"); 
	           
	           
	            while(true)  
	            {  
	               
	              
	               
	                sender.send(msg);  
	                System.out.println("Message successfully sent.");  
	            }  
	            //8) connection close  
	          //  con.close();  
	        }catch(Exception e){System.out.println(e);}  
	    }  
}
