package View;

import java.util.Date;
import java.io.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import Model.Client;
import Model.GymClasses;
import Model.MemberShip;
import Model.Trainer;

public class Collection implements Serializable {

	public static Set<Client> Cli = new LinkedHashSet<Client>();
	public static Set<MemberShip> Mem = new LinkedHashSet<MemberShip>();
	public static Set<Trainer> Tra = new LinkedHashSet<Trainer>();
	public static Set<GymClasses> Gym = new LinkedHashSet<GymClasses>();

	public static void storeClient(int a, String b, String c1, String d, String e, String f) {
		try {
			Cli.add(new Client(a, b, c1, d, e, f));

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void storeMemberShip(int x, LocalDate a, LocalDate b, boolean c2, Double d, String e2) {
		try {
			
			Mem.add(new MemberShip(x, a, b, c2, d, e2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void storeTrainer(int a, String b, String c2, String d) {
		try {
			Tra.add(new Trainer(a, b, c2, d));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void storeGymClasses(String a, int b, String c1) {
		try {
			Gym.add(new GymClasses(a, b, c1));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
