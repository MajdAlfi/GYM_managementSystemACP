package View;

import static View.Collection.Cli;
import static View.Collection.Gym;
import static View.Collection.Mem;
import static View.Collection.Tra;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import Control.DB;
import Model.Client;
import Model.GymClasses;
import Model.MemberShip;
import Model.Trainer;

public class userFunc {
	Scanner Sca = new Scanner(System.in);
	int x;
	 static final String DB_URL = "jdbc:mysql://192.168.64.2/Name";
	 static final String USER = "Name";
	 static final String PASS = "passmajd2001";
	 public static int ja;
	 public static int xa;
	 static final String QUERY = "SELECT clientID, fName, lName, phoneNo,occupation,DOB FROM Client";
	 static final String QUERY2 = "SELECT clientID, startDate, endDate, accessToPool,payment,courseT FROM MemberShip";
	 static final String QUERY3 = "SELECT trainerID, trainerName, specialization, courseT FROM Trainer";
	 static final String QUERY4 = "SELECT type, trainerID, time FROM GymClasses";
	
public Client Cli() {

//	
//		Client newCli;
//		
		System.out.print("Enter ClientID: ");
		x = Sca.nextInt();
		System.out.print("Enter First Name:");
		String a = Sca.next();
		System.out.print("Enter Last Name:");
		String b = Sca.next();
		System.out.print("Enter Phone Number:");
		String c = Sca.next();
		System.out.print("Enter occupation:");
		String d = Sca.next();
		System.out.print("Enter Date of Birth:");
		String e = Sca.next();

//		 newCli = new Client(x, a, b, c, d, e);
//		 Collection.storeClient(newCli.clientID, newCli.fName, newCli.lName, newCli.phoneNo, newCli.occupation,
//					newCli.DOB);
//	
		 try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		 String sql = "INSERT INTO Client VALUES ("+x+ "," +"'"+ a+"'"+ "," +"'"+b+"'"+ ","+"'"+  c+"'"+ ","+"'"+ d+"'"+ ","+ 
				 "'"+e +"'"+ ")";
		 stmt.executeUpdate(sql);
		
		 } catch (SQLException kl) {
	         kl.printStackTrace();
	      } 
	return null;
	
}
public MemberShip Mem() {
//	MemberShip newMem = null;
	System.out.print("Enter Length in months: ");
	int st = Sca.nextInt();
	LocalDate g = LocalDate.now();
	LocalDate f = LocalDate.now().plusMonths(st);
	System.out.print("Access to pool: ");
	boolean h = Sca.nextBoolean();
	System.out.print("Enter Payment: ");
	Double p = Sca.nextDouble();
	System.out.print("Enter Course Type: ");
	String t = Sca.next();
//	newMem = new MemberShip(x, f, g, h, p, t);
//	Collection.storeMemberShip(newMem.clientID, newMem.startDate, newMem.endDate, newMem.accessToPool,
//			newMem.payment, newMem.courseT);
	 try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {
	 String sql = "INSERT INTO MemberShip VALUES ("+x+ ","+"'"+ g+"'"+ ","+"'"+ f+"'"+ ","+"'"+h+"'"+","+
				p+ ","+"'"+t+"'"+")";
	 stmt.executeUpdate(sql);
	
	 } catch (SQLException kl) {
         kl.printStackTrace();
      } 
	
	
	return null;
	
}
public GymClasses Gym () {

		GymClasses newCla;
		System.out.print("Enter Course Type:");
		String a = Sca.next();
		System.out.print("Enter TrainerID for the course:");
		int b = Sca.nextInt();
		System.out.print("Enter Course Time:");
		String c = Sca.next();
//		newCla = new GymClasses(a, b, c);
//		Collection.storeGymClasses(newCla.type, newCla.trainerID, newCla.time);
		 try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		 String sql = "INSERT INTO GymClasses VALUES (" +"'"+a+"'" +","+ b +"," +"'"+ c+"'"+")";
		 stmt.executeUpdate(sql);
		
		 } catch (SQLException kl) {
	         kl.printStackTrace();
	      } 
	return null;
	
}
public Trainer Tra () {
//	Trainer newTra;
	System.out.print("Enter Trianer ID:");
	int a = Sca.nextInt();
	System.out.print("Enter Trainer Name:");
	String b = Sca.next();
	System.out.print("Enter Trainer specialization:");
	String c = Sca.next();
	System.out.print("Enter Trainer courseT:");
	String d = Sca.next();
//	newTra = new Trainer(a, b, c, d);
//
//	Collection.storeTrainer(newTra.trainerID, newTra.trainerName, newTra.specialization, newTra.courseT);
	 try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {
	 String sql = "INSERT INTO Trainer VALUES (" + a+","+ "'"+ b+"'"+"," +"'"+c+"'"+","+ "'"+d+"'"+ ")";
	 stmt.executeUpdate(sql);
	
	 } catch (SQLException kl) {
         kl.printStackTrace();
      } 
	
	return null;
	
}
public int Search() {
	System.out.println("Enter Client id you want to search");
	xa = Sca.nextInt();
	return xa;
}
public int Search1() {
	System.out.println("Enter Trainer id for the gym class you want to search");
	xa = Sca.nextInt();
	return xa;
}
public int Search2() {
	System.out.println("Enter Trainer id you want to search");
	xa = Sca.nextInt();
	return xa;
}
public int Delete() {
	System.out.println("Enter CLient id you want to Delete");
	return Sca.nextInt();
}
public int Delete1() {
	System.out.println("Enter Trainer id of the Gym Classes you want to Delete");
	return Sca.nextInt();
}
public int Delete2() {
	System.out.println("Enter Trainer id you want to Delete");
	return Sca.nextInt();
}
public int update() {
	System.out.println("Enter CLient id you want to Update");
	ja = Sca.nextInt();
	return ja;
}
public int update1() {
	System.out.println("Enter Trainer id of the gym class you want to Update");
	ja = Sca.nextInt();
	return ja;
}
public int update2() {
	System.out.println("Enter Trainer id you want to Update");
	ja = Sca.nextInt();
	return ja;
}
public Client SearchCli(int id) {
//	boolean found = false;
//	Iterator li = Cli.iterator();
//	Client stuff = null;
//	while (li.hasNext()) {
//		Client e = (Client) li.next();
//		if (e.getClientID() == id) {
//			System.out.println(e);
//			stuff = e;
//			found = true;
//		}if (!found) {
//			System.out.println("Not Found!");
//		}
//	}
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();) {
		ResultSet rs = stmt.executeQuery(QUERY);
		System.out.println("Fetching records with database...");
		 String sql = QUERY +
		            " WHERE clientID = "+id;
		         rs = stmt.executeQuery(sql);

		         while(rs.next()){
		            //Display values
		        	 //clientID, fName, lName, phoneNo,occupation,DOB FROM Client
		            System.out.print("clientID: " + rs.getInt("clientID"));
		            System.out.print(", fName: " + rs.getString("fName"));
		            System.out.print(", lName: " + rs.getString("lName"));
		            System.out.print(", phoneNo: " + rs.getString("phoneNo"));
		            System.out.print(", occupation: " + rs.getString("occupation"));
		            System.out.println(", DOB: " + rs.getString("DOB"));
		         }
		         rs.close();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	return null;
}
public MemberShip searchMem(int id) {
//	boolean found = false;
//	MemberShip stuff = null;
//	Iterator li2 = Mem.iterator();	
//	while (li2.hasNext()) {
//		MemberShip e2 = (MemberShip) li2.next();
//		if (e2.getClientID() == id) {
//			System.out.println(e2);
//			stuff = e2;
//			found = true;
//		}
//	}
//	if (!found) {
//		System.out.println("Not Found!");
//	}
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();) {
		ResultSet rs = stmt.executeQuery(QUERY2);
		System.out.println("Fetching records with database...");
		 String sql = QUERY2 +
		            " WHERE clientID = "+id;
		         rs = stmt.executeQuery(sql);

		         while(rs.next()){
		            //Display values
		        	 //SELECT clientID, startDate, endDate, accessToPool,payment,courseT FROM MemberShip
		            System.out.print("clientID: " + rs.getInt("clientID"));
		            System.out.print(", startDate: " + rs.getString("startDate"));
		            System.out.print(", endDate: " + rs.getString("endDate"));
		            System.out.print(", accessToPool: " + rs.getString("accessToPool"));
		            System.out.print(", payment: " + rs.getDouble("payment"));
		            System.out.println(", courseT: " + rs.getString("courseT"));
		         }
		         rs.close();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	return null;
}
public Trainer SearchTra(int id) {
//	boolean found = false;
//	Iterator li = Tra.iterator();
//	Trainer stuff = null;
//	while (li.hasNext()) {
//		Trainer e = (Trainer) li.next();
//		if (e.getTrainerID() == id) {
//			System.out.println(e);
//			stuff = e;
//			found = true;
//		}if (!found) {
//			System.out.println("Not Found!");
//		}
//	}
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();) {
		ResultSet rs = stmt.executeQuery(QUERY3);
		System.out.println("Fetching records with database...");
		 String sql = QUERY3 +
		            " WHERE trainerID = "+id;
		         rs = stmt.executeQuery(sql);

		         while(rs.next()){
		            //Display values
		            System.out.print("trainerID: " + rs.getInt("trainerID"));
		            System.out.print(", trainerName: " + rs.getString("trainerName"));
		            System.out.print(", specialization: " + rs.getString("specialization"));
		            System.out.println(", courseT: " + rs.getString("courseT"));
		         }
		         rs.close();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	return null;
//	return stuff;
}
public GymClasses SearchGym(int id) {
//	boolean found = false;
//	Iterator li = Gym.iterator();
//	GymClasses stuff = null;
//	while (li.hasNext()) {
//		GymClasses e = (GymClasses) li.next();
//		if (e.getTrainerID() == id) {
//			System.out.println(e);
//			stuff = e;
//			found = true;
//		}if (!found) {
//			System.out.println("Not Found!");
//		}
//	}
//	return stuff;
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();) {
		ResultSet rs = stmt.executeQuery(QUERY4);
		System.out.println("Fetching records with database...");
		 String sql = QUERY4 +
		            " WHERE trainerID = "+id;
		         rs = stmt.executeQuery(sql);

		         while(rs.next()){
		            //Display values
		        	 //type, trainerID, time
		            System.out.print("trainerID: " + rs.getInt("trainerID"));
		            System.out.print(", type: " + rs.getString("type"));
		            System.out.println(", time: " + rs.getString("time"));
		         }
		         rs.close();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	return null;
}

public Client DeleteCli(int id) throws SQLException {
//	boolean found = false;
//	Collection newG = new Collection();
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         String sql = "DELETE FROM Client " +
	            "WHERE clientID ="+ id;
	         stmt.executeUpdate(sql);
	}catch (SQLException e) {
        e.printStackTrace();
     } 
//	Iterator li = Cli.iterator();	
//	while (li.hasNext()) {
//		Client e = (Client) li.next();
//		if (e.getClientID() == id) {
//			li.remove();
//			
//			found = true;
//		}
//	}
	return null;
	
}
public MemberShip DeleteMem(int id) {
	boolean found = false;
	Collection newG = new Collection();
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         String sql = "DELETE FROM MemberShip " +
	            "WHERE clientID ="+ id;
	         stmt.executeUpdate(sql);
	}catch (SQLException e) {
       e.printStackTrace();
    } 
//	Iterator li2 = Mem.iterator();		
//	while (li2.hasNext()) {
//		MemberShip e2 = (MemberShip) li2.next();
//		if (e2.getClientID() == id) {
//			li2.remove();
//			
//			found = true;
//		}
//	}
	return null;
}
public GymClasses DeleteGym(int id) throws SQLException {
	boolean found = false;
	Collection newG = new Collection();
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         String sql = "DELETE FROM GymClasses " +
	            "WHERE trainerID ="+ id;
	         stmt.executeUpdate(sql);
	}catch (SQLException e) {
        e.printStackTrace();
     } 
//	Iterator li = Gym.iterator();	
//	while (li.hasNext()) {
//		GymClasses e = (GymClasses) li.next();
//		if (e.getTrainerID() == id) {
//			li.remove();
//			
//			found = true;
//		}
//	}
	return null;
	
}
public Trainer DeleteTra(int id) throws SQLException {
	boolean found = false;
	Collection newG = new Collection();
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         String sql = "DELETE FROM Trainer " +
	            "WHERE trainerID ="+ id;
	         stmt.executeUpdate(sql);
	}catch (SQLException e) {
        e.printStackTrace();
     } 
//	Iterator li = Tra.iterator();	
//	while (li.hasNext()) {
//		Trainer e = (Trainer) li.next();
//		if (e.getTrainerID() == id) {
//			li.remove();
//			
//			found = true;
//		}
//	}
	return null;
	
}

public Client CliUp(int id) {
//    Iterator li =  Collection.Cli.iterator();
//	 while (li.hasNext()) {
//	 		
//		 
//			Client e2 = (Client) li.next();
//			if (e2.getClientID() == id) {
//				while (li.hasNext()) {
//					if (e2.getClientID() == id) {
//						li.remove();
//					}
//				}
//			}
//	 
//	 }
//	Client newCli;
	
	System.out.print("Enter First Name:");
	String a = Sca.next();
	System.out.print("Enter Last Name:");
	String b = Sca.next();
	System.out.print("Enter Phone Number:");
	String c = Sca.next();
	System.out.print("Enter occupation:");
	String d = Sca.next();
	System.out.print("Enter Date of Birth:");
	String e = Sca.next();
//	
//	newCli = new Client(id, a, b, c, d, e);
//	
//	Collection.storeClient(newCli.clientID, newCli.fName, newCli.lName, newCli.phoneNo, newCli.occupation,
//			newCli.DOB);


	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         String sql = "UPDATE Client " +
	            "SET fName = '"+ a+"' WHERE clientID in ("+id+")";
	         stmt.executeUpdate(sql);
	         String sql1 = "UPDATE Client " +
	 	            "SET lName = '"+b +"' WHERE clientID in ("+id+")";
	         stmt.executeUpdate(sql1);
	         String sql2 = "UPDATE Client " +
		 	            "SET phoneNo = '"+c +"' WHERE clientID in ("+id+")";
	         stmt.executeUpdate(sql2);
	         String sql3 = "UPDATE Client " +
		 	            "SET occupation = '"+d +"' WHERE clientID in ("+id+")";
	         stmt.executeUpdate(sql3);
	         String sql4 = "UPDATE Client " +
		 	            "SET DOB = '"+e +"' WHERE clientID in ("+id+")";
	         stmt.executeUpdate(sql4);
	         
	         
	         
	        
	         
 } catch (SQLException eq) {
    eq.printStackTrace();
 } 

return null;

}
public MemberShip MemUp(int id) {
//    Iterator li2 =  Collection.Mem.iterator();
// 	 while (li2.hasNext()) {
//			MemberShip e = (MemberShip) li2.next();
//			if (e.getClientID() == id) {
//				
//				while (li2.hasNext()) {
//					if (e.getClientID() == id) {
//						li2.remove();
//					}
//				}
//			}
// }
//	MemberShip newMem;
	 
	System.out.print("Enter Length in months: ");
	int st = Sca.nextInt();
	LocalDate g = LocalDate.now();
	LocalDate f = LocalDate.now().plusMonths(st);
	System.out.print("Access to pool: ");
	boolean h = Sca.nextBoolean();
	System.out.print("Enter Payment: ");
	Double p = Sca.nextDouble();
	System.out.print("Enter Course Type: ");
	String t = Sca.next();
	
//	newMem = new MemberShip(id, f, g, h, p, t);
//	Collection.storeMemberShip(newMem.clientID, newMem.startDate, newMem.endDate, newMem.accessToPool,
//			newMem.payment, newMem.courseT);
//	
//	 startDate, endDate, accessToPool,payment,courseT
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         String sql = "UPDATE MemberShip " +
	            "SET startDate = '"+g +"' WHERE clientID in ("+id+")";
	         stmt.executeUpdate(sql);
	         String sql1 = "UPDATE MemberShip " +
	 	            "SET endDate = '"+f +"' WHERE clientID in ("+id+")";
	         stmt.executeUpdate(sql1);
	         
	         String sql2 = "UPDATE MemberShip " +
		 	            "SET accessToPool = '"+h +"' WHERE clientID in ("+id+")";
	         stmt.executeUpdate(sql2);
	         String sql3 = "UPDATE MemberShip " +
		 	            "SET payment = '"+p +"' WHERE clientID in ("+id+")";
	         stmt.executeUpdate(sql3);
	         String sql4 = "UPDATE MemberShip " +
		 	            "SET courseT = '"+t +"' WHERE clientID in ("+id+")";
	         stmt.executeUpdate(sql4);
	         
	        
	         
	         
	         
} catch (SQLException eq) {
   eq.printStackTrace();
} 
	return null;
	
}
public GymClasses GymUp (int id) {
//    Iterator li4 =  Collection.Gym.iterator();
//	 while (li4.hasNext()) {
//	 		
//		 
//			GymClasses e2 = (GymClasses) li4.next();
//			if (e2.getTrainerID() == id) {
//				while (li4.hasNext()) {
//					if (e2.getTrainerID() == id) {
//						li4.remove();
//					}
//				}
//			}
//	 
//	 }
//	GymClasses newCla;
	System.out.print("Enter Course Type:");
	String a = Sca.next();
	System.out.print("Enter Course Time:");
	String c = Sca.next();
//	newCla = new GymClasses(a, id, c);
//	Collection.storeGymClasses(newCla.type, newCla.trainerID, newCla.time);
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         String sql = "UPDATE GymClasses " +
	            "SET type = '"+ a +"' WHERE trainerID in ("+id+")";
	         stmt.executeUpdate(sql);
		      
	         String sql1 = "UPDATE GymClasses " +
	            "SET trainerID = "+ id +" WHERE trainerID in ("+id+")";
	         stmt.executeUpdate(sql1);
	         String sql2 = "UPDATE GymClasses " +
	 	            "SET time = '"+ c +"' WHERE trainerID in ("+id+")";
	 	         stmt.executeUpdate(sql2);
	} catch (SQLException eq) {
		   eq.printStackTrace();
		}   
	         
return null;

}
public Trainer TraUp (int id) {
//    Iterator li3 =  Collection.Tra.iterator();
//	 while (li3.hasNext()) {
//	 		
//		 
//			Trainer e2 = (Trainer) li3.next();
//			if (e2.getTrainerID() == id) {
//				while (li3.hasNext()) {
//					if (e2.getTrainerID() == id) {
//						li3.remove();
//					}
//				}
//			}
//	 
//	 }
//	Trainer newTra;
	System.out.print("Enter Trainer Name:");
	String b = Sca.next();
	System.out.print("Enter Trainer specialization:");
	String c = Sca.next();
	System.out.print("Enter Trainer courseT:");
	String d = Sca.next();
//	newTra = new Trainer(id, b, c, d);

//	Collection.storeTrainer(newTra.trainerID, newTra.trainerName, newTra.specialization, newTra.courseT);
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         String sql = "UPDATE Trainer " +
	            "SET trainerID = "+ id +" WHERE trainerID in ("+id+")";
	         stmt.executeUpdate(sql);
		      
	         String sql1 = "UPDATE Trainer " +
	            "SET trainerName = '"+ b +"' WHERE trainerID in ("+id+")";
	         stmt.executeUpdate(sql1);
	         String sql2 = "UPDATE Trainer " +
	 	         "SET specialization = '"+ c +"' WHERE trainerID in ("+id+")";
	 	         stmt.executeUpdate(sql2);
	 	        String sql3 = "UPDATE Trainer " +
		 	            "SET courseT = '"+ d +"' WHERE trainerID in ("+id+")";
		 	         stmt.executeUpdate(sql3);
	} catch (SQLException eq) {
		   eq.printStackTrace();
		} 
	
	return null;
	
}



}
