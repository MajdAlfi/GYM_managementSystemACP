package View;
import static View.Collection.Cli;
import static View.Collection.Gym;
import static View.Collection.Mem;
import static View.Collection.Tra;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

import Control.FileS;
import Model.Client;
import Model.GymClasses;
import Model.MemberShip;
import Model.Trainer;
public class userEdit implements Serializable{

	public static void Func() throws ClassNotFoundException, FileNotFoundException, IOException,EOFException {
		int choice = -1;
		int choice2 = -1;
		int num;
		int num2;
		int num3;
		FileS file = new FileS();
//		file.InsertInfo();
		Iterator li = null;
		Iterator li2 = null;
		Iterator liGym = null;
		Iterator li2Tra = null;
		Scanner sca = new Scanner(System.in);
		Scanner sca1 = new Scanner(System.in);
		Scanner sca2 = new Scanner(System.in);
		do {
			System.out.println("1-Insert");
			System.out.println("2-Display");
			System.out.println("3-Update");
			System.out.println("4-Search");
			System.out.println("5-Delete");
			System.out.println("0-Exit");
			System.out.println("Enter your choice here:");
			choice = sca.nextInt();
			switch (choice) {
	case 1:
		System.out.println("1-New Member");
		System.out.println("2-New GymClass");
		System.out.println("3-New Trainer");
		Scanner scaM = new Scanner(System.in);
		choice2 = scaM.nextInt();
		Collection newG = new Collection();
		switch (choice2) {
		case 1:
			System.out.print("How many Members you want to add?");
			num = sca.nextInt();
			for (int i = 0; i < num; i++) {
				Client newCli;
				MemberShip newMem;
				System.out.print("Enter ClientID: ");
				int x = sca.nextInt();
				System.out.print("Enter First Name:");
				String a = sca1.next();
				System.out.print("Enter Last Name:");
				String b = sca1.next();
				System.out.print("Enter Phone Number:");
				String c = sca1.next();
				System.out.print("Enter occupation:");
				String d = sca1.next();
				System.out.print("Enter Date of Birth:");
				String e = sca1.next();
				System.out.print("Enter Length in months: ");
				int st = sca.nextInt();
				LocalDate g = LocalDate.now();
				LocalDate f = LocalDate.now().plusMonths(st);
				System.out.print("Access to pool: ");
				boolean h = sca2.nextBoolean();
				System.out.print("Enter Payment: ");
				Double p = sca.nextDouble();
				System.out.print("Enter Course Type: ");
				String t = sca1.next();
				newCli = new Client(x, a, b, c, d, e);
				newMem = new MemberShip(x, f, g, h, p, t);
				Collection.storeClient(newCli.clientID, newCli.fName, newCli.lName, newCli.phoneNo, newCli.occupation,
						newCli.DOB);
				Collection.storeMemberShip(newMem.clientID, newMem.startDate, newMem.endDate, newMem.accessToPool,
						newMem.payment, newMem.courseT);

			}
			file.storeMemCli(Cli, Mem);
			break;
		case 2:
			System.out.print("How many gym classes you want to add?");
			num2 = sca.nextInt();
			for (int i = 0; i < num2; i++) {
				GymClasses newCla;
				System.out.print("Enter Course Type:");
				String a = sca1.next();
				System.out.print("Enter TrainerID for the course:");
				int b = sca.nextInt();
				System.out.print("Enter Course Time:");
				String c = sca1.next();
				newG = new Collection();
				newCla = new GymClasses(a, b, c);
				Collection.storeGymClasses(newCla.type, newCla.trainerID, newCla.time);

			}
			file.storeGym(Gym);

			break;
		case 3:
			System.out.print("How many Trainers you want to add?");
			num3 = sca.nextInt();
			for (int i = 0; i < num3; i++) {
				Trainer newTra;
				System.out.print("Enter Trianer ID:");
				int a = sca.nextInt();
				System.out.print("Enter Trainer Name:");
				String b = sca1.next();
				System.out.print("Enter Trainer specialization:");
				String c = sca1.next();
				System.out.print("Enter Trainer courseT:");
				String d = sca1.next();
				newTra = new Trainer(a, b, c, d);

				Collection.storeTrainer(newTra.trainerID, newTra.trainerName, newTra.specialization, newTra.courseT);

			}
			file.storeTra(Tra);
			break;
		}
		break;
	case 2:
		if (file.file.isFile()) {
//		file.InsertInfo();
		newG = new Collection();
		System.out.println("--------------------------------------");
		li = Cli.iterator();
		while (li.hasNext()) {
			System.out.println(li.next());
		}
		System.out.println("--------------------------------------");

		li = Mem.iterator();
		while (li.hasNext()) {
			System.out.println(li.next());
		}

		System.out.println("--------------------------------------");
		li = Gym.iterator();
		while (li.hasNext()) {
			System.out.println(li.next());
		}
		System.out.println("--------------------------------------");
		li = Tra.iterator();
		while (li.hasNext()) {
			System.out.println(li.next());
		}
		System.out.println("--------------------------------------");
		}else {
			System.out.println("FIle does not exist");
		}
		break;
	case 3:
		if (file.file.isFile()) {
//			file.InsertInfo();
			System.out.println("1-New Member");
			System.out.println("2-New GymClass");
			System.out.println("3-New Trainer");
			int choiceUp;
			boolean found = false;
			choiceUp = sca.nextInt();
			System.out.print("Enter CLientId you want to update");
			int ok = sca.nextInt();
			newG = new Collection();
			System.out.println("--------------------------------------");
			li =  Cli.iterator();
			li2 =  Mem.iterator();	


			while (li.hasNext()) {
				Client e = (Client) li.next();
				if (e.getClientID() == ok) {
					Client newCli;
					while (li.hasNext()) {
						if (e.getClientID() == ok) {
							li.remove();
						}
					}
					int x = ok;
					System.out.print("Enter First Name:");
					String a = sca1.next();
					System.out.print("Enter Last Name:");
					String b = sca1.next();
					System.out.print("Enter Phone Number:");
					String c = sca1.next();
					System.out.print("Enter occupation:");
					String d = sca1.next();
					System.out.print("Enter Date of Birth:");
					String e1 = sca1.next();
					newCli = new Client(x, a, b, c, d, e1);
					
					Collection.storeClient(newCli.clientID, newCli.fName, newCli.lName, newCli.phoneNo, newCli.occupation,
							newCli.DOB);
					
					found = true;
				    }
				}
				while (li2.hasNext()) {
					MemberShip e2 = (MemberShip) li2.next();
					if (e2.getClientID() == ok) {
						MemberShip newMem;
						while (li2.hasNext()) {
							if (e2.getClientID() == ok) {
								li2.remove();
							}
						}
						int x = ok;
						System.out.print("Enter Length in months: ");
						int st = sca.nextInt();
						LocalDate g = LocalDate.now();
						LocalDate f = LocalDate.now().plusMonths(st);
						System.out.print("Access to pool: ");
						boolean h = sca2.nextBoolean();
						System.out.print("Enter Payment: ");
						Double p = sca.nextDouble();
						System.out.print("Enter Course Type: ");
						String t = sca1.next();
						newMem = new MemberShip(x, f, g, h, p, t);
						Collection.storeMemberShip(newMem.clientID, newMem.startDate, newMem.endDate, newMem.accessToPool,
								newMem.payment, newMem.courseT);
				}
				}

				
			
				
				
				if (found) {
					file.oos = new ObjectOutputStream(new FileOutputStream(file.file));
					file.storeMemCli(Cli, Mem);
					file.storeGym(Gym);
					file.storeTra(Tra);
					file.oos.close();
					
					System.out.println("Record updated successfully");
				} else {
					
					System.out.println("Not Found!");
				}
			
		} else {
			System.out.println("file not found!");
		}
			
		break;
	case 4:

		if (file.file.isFile()) {
//			file.InsertInfo();
			boolean found = false;
			System.out.print("Enter CLientId you want to search");
			int ok = sca.nextInt();
			newG = new Collection();
			System.out.println("--------------------------------------");
			li = Cli.iterator();
		    li2 = Mem.iterator();		
			while (li.hasNext()) {
				Client e = (Client) li.next();
				if (e.getClientID() == ok) {
					System.out.println(e);
					
					found = true;
				}
			}
				while (li2.hasNext()) {
					MemberShip e2 = (MemberShip) li2.next();
					if (e2.getClientID() == ok) {
						System.out.println(e2);
						
						found = true;
					}
				
				}
				if (!found) {
					System.out.println("Not Found!");
				} else {
					System.out.println("FIle does not exist");
				}
			
		} else {
			System.out.println("file not found!");
		}
		System.out.println("--------------------------------------");
		break;
	case 5:
		if (file.file.isFile()) {
//			file.InsertInfo();
			boolean found = false;
			System.out.print("Enter CLientId you want to delete");
			int ok = sca.nextInt();
			newG = new Collection();
			System.out.println("--------------------------------------");
			li = Cli.iterator();
		    li2 = Mem.iterator();		
			while (li.hasNext()) {
				Client e = (Client) li.next();
				if (e.getClientID() == ok) {
					li.remove();
					
					found = true;
				}
			}
				while (li2.hasNext()) {
					MemberShip e2 = (MemberShip) li2.next();
					if (e2.getClientID() == ok) {
						li2.remove();
						
						found = true;
					}
				}
				if (found) {
					file.oos = new ObjectOutputStream(new FileOutputStream(file.file));
					file.storeMemCli(Cli, Mem);
					file.oos.close();
					
					System.out.println("Record removed successfully");
				} else {
					
					System.out.println("Not Found!");
				}
			
		} else {
			System.out.println("file not found!");
		}
		System.out.println("--------------------------------------");
		break;
	}

} while (choice != 0);
{

}
}
}

