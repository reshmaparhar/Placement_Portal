
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class tcpserver {
    public static void main(String args[]){ 
        String regno,name,gender,email,dob,phone;
        try {
           
            
             int portNumber = 8084;
             String data="SERVER IS RUNNING";
            ServerSocket self = new ServerSocket(portNumber);
                  
                  Socket client = self.accept();
                  System.out.println("Server Ready");
                  PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                 // System.out.println("Sending data: "+data);
                  BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 
            
                 
             out.println(data);
             
         while(!in.ready()){}
             System.out.println("Registration no "+in.readLine()+" added into database");   
             
             out.close();
             client.close();
             self.close();
             } catch (IOException ex) {
             System.out.println("server problem"+ex); 
             }
             }
         
    }


