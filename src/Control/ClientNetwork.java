package Control;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import View.Collection;
import View.FirstChoice;
import View.userFunc;
public class ClientNetwork {
    public void client() throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        final String DB_URL = "jdbc:mysql://192.168.64.2/Name";
   	    final String USER = "Name";
   	    final String PASS = "passmajd2001";
   	    final String QUERY = "SELECT clientID, fName, lName, phoneNo,occupation,DOB FROM Client";
	    final String QUERY2 = "SELECT clientID, startDate, endDate, accessToPool,payment,courseT FROM MemberShip";
        try {
            echoSocket = new Socket("127.0.0.1", 5000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in=new BufferedReader(new InputStreamReader(
                    echoSocket. getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know host: toshiba.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: toshiba.");
            System.exit(1);
        }

        ObjectOutputStream outToServer = new ObjectOutputStream(echoSocket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(echoSocket.getInputStream());
        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        FirstChoice Fi = new FirstChoice();
        userFunc func = new  userFunc();


int Num;
int Num2;
    do {
        Num= Fi.choice();
        out.println(Num);
        switch (Num) {
            case 1:
            	Num2 = Fi.secondCh();
            	out.println(Num2);
            	switch (Num2) {
                    case 1 :
            	
                    outToServer.writeObject(func.Cli());
                    outToServer.writeObject(func.Mem());
                    System.out.println(in.readLine());
                    break;
                    case 2:
                    	outToServer.writeObject(func.Gym());
                        System.out.println(in.readLine());
                    break;
                    case 3:
                    	outToServer.writeObject(func.Tra());
                        System.out.println(in.readLine());
                    break;
            	}
                break;
            case 2:
                try {
            		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					         Statement stmt = conn.createStatement();
					         ResultSet rs = stmt.executeQuery(QUERY);
					      ) {		      
					         while(rs.next()){
					            //Display values
					            System.out.print("clientID: " + rs.getInt("clientID"));
					            System.out.print(", fName: " + rs.getString("fName"));
					            System.out.print(", lName: " + rs.getString("lName"));
					            System.out.print(", phoneNo: " + rs.getString("phoneNo"));
					            System.out.print(", occupation: " + rs.getString("occupation"));
					            System.out.println(", DOB: " + rs.getString("DOB"));
					            System.out.println();
					           
					            
					         }
					      } catch (SQLException e) {
					         e.printStackTrace();
					      }
					try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					         Statement stmt = conn.createStatement();
					         ResultSet rs2 = stmt.executeQuery(QUERY2);
					      ) {		      
					         while(rs2.next()){
					            //Display values
					        	 System.out.print("clientID: " + rs2.getInt("clientID"));
					        	 System.out.print("startDate: " + rs2.getString("startDate"));
					        	 System.out.print(", endDate: " + rs2.getString("endDate"));
					        	 System.out.print(", accessToPool: " + rs2.getString("accessToPool"));
					        	 System.out.print(", payment: " + rs2.getDouble("payment"));
					        	 System.out.println(", courseT: " + rs2.getString("courseT"));
					           
					            
					         }
					      } catch (SQLException e) {
					         e.printStackTrace();
					      }
                } catch (Exception e) {

                }
                break;
            case 3:
            	try {   
            		int Num3 = Fi.fourthCh();
                	out.println(Num3);
            		
            		switch (Num3) {
            		case 1: 
            		out.println(func.update());
                    outToServer.writeObject(func.CliUp(func.ja));
                    outToServer.writeObject(func.MemUp(func.ja));
                    System.out.println(in.readLine());
                    break;
            		case 2:
            			out.println(func.update1());
            			outToServer.writeObject(func.GymUp(func.ja));
            			System.out.println(in.readLine());
            			break;
            		case 3:
            			out.println(func.update2());
            			outToServer.writeObject(func.TraUp(func.ja));
            			System.out.println(in.readLine());
                        break;
            				}	
            	 
            	 } catch (Exception e) {
                 	e.printStackTrace();
                 }
                break;
            case 4:
            	try {
            		int Num3;
            		Num3 = Fi.FifthCh();
                	out.println(Num3);
            		
            		switch (Num3) {
            		case 1: 
            	out.println(func.Search());
                outToServer.writeObject(func.SearchCli(func.xa));
                outToServer.writeObject(func.searchMem(func.xa));
                break;
            		case 2:
            	out.println(func.Search1());
            	outToServer.writeObject(func.SearchGym(func.xa));
            	break;
            	case 3:
            		out.println(func.Search2());
            		outToServer.writeObject(func.SearchTra(func.xa));
            		break;
            		}
        } catch (Exception e) {
        	e.printStackTrace();
        }
                break;
            case 5:
            	int Num3;
            	try {
            		Num3 = Fi.thirdCh();
                	out.println(Num3);
            		
            		switch (Num3) {
            		case 1: 
            		
            		out.println(func.Delete());
                    inFromServer.readObject();
                    inFromServer.readObject();
                    System.out.println("Record deleted successfully");
                    break;
            		case 2:
            			out.println(func.Delete1());
                        inFromServer.readObject();
                        
                        System.out.println("Record deleted successfully");
            			break;
            		case 3:
            			out.println(func.Delete2());
                        inFromServer.readObject();
                       
                        System.out.println("Record deleted successfully");
                        break;
            				}	
            	} catch (Exception e) {
                	e.printStackTrace();
                }
            	
            	break;
        }
    }while (Num !=0);





        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}