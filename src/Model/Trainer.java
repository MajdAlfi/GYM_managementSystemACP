package Model;

import java.io.Serializable;

public class Trainer implements Serializable {
//(trainerID), (trainerName), (specialization), (courseT).
	public int trainerID;
	public String trainerName;
	public String specialization;
	public String courseT;

	public Trainer(int trainerID, String trainerName, String specialization, String courseT) {
		super();
		this.trainerID = trainerID;
		this.trainerName = trainerName;
		this.specialization = specialization;
		this.courseT = courseT;
	}

	public int getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getCourseT() {
		return courseT;
	}

	public void setCourseT(String courseT) {
		this.courseT = courseT;
	}

	@Override
	public String toString() {
		return "Trainer [trainerID=" + trainerID + ", trainerName=" + trainerName + ", specialization=" + specialization
				+ ", courseT=" + courseT + "]";
	}

}
