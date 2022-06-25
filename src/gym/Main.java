package gym;

import java.io.IOException;

import Control.ClientNetwork;
import Control.DB;
import Control.ServerNetwork;

public class Main {
	public static void main(String[] args) throws IOException {
		DB data = new DB();
		data.func();
		ClientNetwork c = new ClientNetwork();
		c.client();

//		Collection.storeClient();
//		Collection.storeMemberShip();
//		Collection.storeTrainer();
//		Collection.storeGymClasses();
//		System.out.print("1.server 2.Client 3.crude");
//		Scanner sca = new Scanner(System.in);
//		int x = sca.nextInt();
//		switch(x) {
//		case 1:
////		ServerNetwork ser = new ServerNetwork(5000);
//		
//		break;
//		case 2:
////		ClientNetwork Net = new ClientNetwork("127.0.0.1", 5000);
//		break;
//		case 3:
//		userEdit.Func();
//		break;
//		}
//		
//		file.storeFile(Collection.c,Collection.m,Collection.t,Collection.g);
	}
}
