import java.io.*;
import java.net.*;
import java.util.*;

public class clienttext{

  public static void main(String[] args) throws Exception {
     
     Scanner scan = new Scanner(System.in);
     while(true){
     System.out.println("Insert port number :");
     int portx=scan.nextInt();
     if(portx >= 1000 && portx <=9999){

     Socket sock = new Socket("192.168.1.43", portx);
     
     // reading from keyboard (keyRead object)
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

     // sending to client (pwrite object)
     OutputStream ostream = sock.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(ostream, true);

      // receiving from server ( receiveRead object)
     InputStream istream = sock.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

     System.out.println("CONNECTED TO SERVER");
     String receiveMessage, sendMessage;               
     System.out.println("Press ctrl C if you want to exit...");

     while(true){

	//receive from server
	if((receiveMessage = receiveRead.readLine()) != null)
	{
		System.out.println("Server:"+receiveMessage);
	}

        sendMessage = keyRead.readLine();  // keyboard reading
        pwrite.println("Client:"+sendMessage);       // sending to server
	pwrite.flush();                    // flush the data         
    }               
   }
	else{ System.out.println("Invalid Number!!");}}
  }                    
}              
