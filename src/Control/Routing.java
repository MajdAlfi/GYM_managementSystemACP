package Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Iterator;

import Model.Client;
import Model.GymClasses;
import Model.MemberShip;
import Model.Trainer;
import View.Collection;
import View.FirstChoice;
import View.userFunc;

public class Routing extends Thread {
	Socket clientSocket;
	PrintWriter out;
	BufferedReader in;
	ObjectOutputStream outToServer;
	 ObjectInputStream inFromServer;
	 static final String DB_URL = "jdbc:mysql://192.168.64.2/Name";
	 static final String USER = "Name";
	 static final String PASS = "passmajd2001";
	 static final String QUERY = "SELECT clientID, fName, lName, phoneNo,occupation,DOB FROM Client";
	 static final String QUERY2 = "SELECT clientID, startDate, endDate, accessToPool,payment,courseT FROM MemberShip";
	public Routing(Socket socket) throws IOException {
		this.clientSocket = socket;
		 out = new PrintWriter(
                clientSocket.getOutputStream(), true);
         in = new BufferedReader( new
                InputStreamReader(clientSocket.getInputStream()));
          outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
          inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		
	}
	
	public void run(){

       
        FirstChoice Fi = new FirstChoice();
        userFunc func = new  userFunc();

        int choosing = -1;
                 do{
                          try {
							choosing=Integer.parseInt(in.readLine());
						} catch (NumberFormatException e4) {
							// TODO Auto-generated catch block
//							e4.printStackTrace();
						} catch (IOException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}

                        switch(choosing){
                case 1: 
                	try{
                		int Sec;
                		 Sec=Integer.parseInt(in.readLine());
                		switch(Sec) {
                		case 1:
//                        Client newC= (Client) inFromServer.readObject();
//                        MemberShip newM = (MemberShip) inFromServer.readObject();
//                        Collection.Cli.add(newC);
//                        Collection.Mem.add(newM);
                       
                        out.println("your data has been saved successfully");
                        break;
                		case 2:
//                            GymClasses newG= (GymClasses) inFromServer.readObject();
//                            
//                            Collection.Gym.add(newG);
//                            
                            out.println("your data has been saved successfully");
                            break;
                		case 3:
//                            Trainer newT= (Trainer) inFromServer.readObject();
//                            
//                            Collection.Tra.add(newT);
//                            
                            out.println("your data has been saved successfully");
                            break;
                		
                		}

                }catch(Exception e){
                        System.out.println(e);
                }  break;
                case 2:
					
                	break;
                case 3:
                	try {
                		int hi;
                  		 hi=Integer.parseInt(in.readLine());
                  		switch(hi) {
                  		case 1:
                  			int xo =  hi = Integer.parseInt(in.readLine());
//                  			 Client newC= (Client) inFromServer.readObject();
//                             MemberShip newM = (MemberShip) inFromServer.readObject();
//                             Collection.Cli.add(newC);
//                             Collection.Mem.add(newM);

                        out.println("your data has been updated successfully");
                        break;
                        
                  		case 2:
                  			int jo=Integer.parseInt(in.readLine());
//                  			 GymClasses newG= (GymClasses) inFromServer.readObject();
//                             
//                             Collection.Gym.add(newG);
                             
                            out.println("your data has been updated successfully");
                  			break;
                  		case 3:
                  			int ss =Integer.parseInt(in.readLine());
//                            Trainer newT= (Trainer) inFromServer.readObject();
//                            
//                            Collection.Tra.add(newT);
//                          
                            out.println("your data has been updated successfully");
                  			
                      	break;
                  		
                  		}
                  		
                	}catch(Exception e) {
                		e.printStackTrace();
                	}
                	break;
               
                case 4:
                	 try {
                		 int ec;
                   		 ec=Integer.parseInt(in.readLine());
                   		
                   		switch(ec) {
                   		case 1:
                   		 int oo =Integer.parseInt(in.readLine());
 //                  		System.out.println(inFromServer.readObject());
//                        System.out.println(inFromServer.readObject());
                         break;
                   		case 2:
                   		 int oo1 =Integer.parseInt(in.readLine());
                        
                         break;
                   		case 3:
                   		 int oo11 =Integer.parseInt(in.readLine());
                            
                   			
                   		break;
                   		}
                 }catch(Exception e){
                	 e.printStackTrace();
                 }
                	break;
                case 5:
                	try {
                  		int Sec;
               		 Sec=Integer.parseInt(in.readLine());
               		switch(Sec) {
               		case 1:
                	 int oo =Integer.parseInt(in.readLine()) ;
                     outToServer.writeObject(func.DeleteCli(oo));
                     outToServer.writeObject(func.DeleteMem(oo));
                     break;
               		case 2:
               			int xo =Integer.parseInt(in.readLine()) ;
                        outToServer.writeObject(func.DeleteGym(xo));
                        break;
               		case 3:
               			int Ho =Integer.parseInt(in.readLine()) ;
                        outToServer.writeObject(func.DeleteTra(Ho));
                     break;
               		}
                         }catch(Exception e){
                        	 e.printStackTrace();
                         }
                	break;

        }}  while (choosing!= 0);


        out.close();
        try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        serverSocket.close();
	}

}
