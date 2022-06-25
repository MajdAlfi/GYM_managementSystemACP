package Model;

import java.io.Serializable;

public class Client implements Serializable {
	// (ClientID), (firstName), (lastName), (phoneNo), (occupation), (DOB).
	public int clientID;
	public String fName;
	public String lName;
	public String phoneNo;
	public String occupation;
	public String DOB;

	public Client(int clientID, String fName, String lName, String phoneNo, String occupation, String DOB) {
		super();
		this.clientID = clientID;
		this.fName = fName;
		this.lName = lName;
		this.phoneNo = phoneNo;
		this.occupation = occupation;
		this.DOB = DOB;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Client [clientID=" + clientID + ", fName=" + fName + ", lName=" + lName + ", phoneNo=" + phoneNo
				+ ", occupation=" + occupation + ", DOB=" + DOB + "]";
	}

}
