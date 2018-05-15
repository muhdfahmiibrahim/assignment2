import java.io.*;
import java.net.*;
import java.util.*;

public class servertext{

  public static void main(String[] args) throws Exception  {

      Scanner sc = new Scanner(System.in);
      while(true){
      System.out.println("Insert port number :");
      int portx=sc.nextInt();
      if(portx >= 1000 && portx <= 9999){

      ServerSocket sersock = new ServerSocket(portx);
      System.out.println("Waiting for client....");
      Socket sock = sersock.accept( );
      String clientIP = sock.getInetAddress().getHostAddress();
      String clientport = ""+sock.getLocalPort();
      String clientHN = sock.getInetAddress().getHostName();
      System.out.println("CONNECTED TO CLIENT : " + clientHN +" "+clientIP);             

      // reading from keyboard (keyRead object)
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

      // sending to client (pwrite object)

      OutputStream ostream = sock.getOutputStream();
      PrintWriter pwrite = new PrintWriter(ostream, true);

      // receiving from server ( receiveRead object)

      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

      String receiveMessage, sendMessage;              
      System.out.println("Press ctrl C if you want to exit...");
      
      while(true){

	sendMessage= keyRead.readLine();

	     if(sendMessage.equalsIgnoreCase("clientIP")){
	        System.out.println(clientIP);
		pwrite.println("*****");
		pwrite.flush();
		 }
	     
	     else if(sendMessage.equalsIgnoreCase("clientHN")){
		System.out.println(clientHN);
		pwrite.println("*****");
		pwrite.flush(); }

	     else if(sendMessage.equalsIgnoreCase("PORT")){
		System.out.println(clientport);
		pwrite.println("*****");
		pwrite.flush(); }

	     else{
			pwrite.println(sendMessage);
			pwrite.flush();
		}

        if((receiveMessage = receiveRead.readLine()) != null)
	{
		System.out.println(receiveMessage);
	}
      }
     }
	else{System.out.println("Invalid Number!!!");}}               
    }                    
}         
