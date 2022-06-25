package Model;

import java.io.Serializable;

public class GymClasses implements Serializable {
	// (type), (trainerID), (time).
	public String type;
	public int trainerID;
	public String time;

	public GymClasses(String type, int trainerID, String time) {
		super();
		this.type = type;
		this.trainerID = trainerID;
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "GymClasses [type=" + type + ", trainerID=" + trainerID + ", time=" + time + "]";
	}

}
