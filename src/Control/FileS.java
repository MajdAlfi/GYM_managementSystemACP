package Control;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import Model.Client;
import Model.GymClasses;
import Model.MemberShip;
import Model.Trainer;
import View.Collection;

public class FileS implements Serializable {

	public File file = new File("Save.txt");
	ObjectOutput os = null;
	public ObjectOutputStream oos = null;
	ObjectInputStream ois = null;

	public void storeMemCli(Set<Client> c2, Set<MemberShip> m2) {

		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(c2);
			oos.writeObject(m2);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (Exception ex) {

			}
		}
	}

	public void storeTra(Set<Trainer> t2) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(t2);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (Exception ex) {

			}
		}
	}

	public void storeGym(Set<GymClasses> g) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(g);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (Exception ex) {

			}
		}

	}

	public void InsertInfo() throws ClassNotFoundException, EOFException {
		if (file.isFile()) {
			try {
				
				ois = new ObjectInputStream(new FileInputStream(file));
				Collection.Cli = (Set<Client>) ois.readObject();
				Collection.Mem = (Set<MemberShip>) ois.readObject();
				Collection.Tra = (Set<Trainer>) ois.readObject();
				Collection.Gym = (Set<GymClasses>) ois.readObject();
				
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ois != null)
						ois.close();
				} catch (Exception ex) {

				}
			}

		}
	}

}
