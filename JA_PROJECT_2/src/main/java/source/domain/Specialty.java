package source.domain;

import java.util.Objects;

public class Specialty {

	private Integer specialtyID;
	private String specialtyNumber;
	private String specialtyName;
	private String educationalDegree;
	private Integer contractAmount;
	private Integer avrgZnoMark;

	public Specialty() {
	}

	public Specialty(String specialtyNumber, String specialtyName, String educationalDegree, Integer contractAmount,
			Integer avrgZnoMark) {
		this.specialtyNumber = specialtyNumber;
		this.specialtyName = specialtyName;
		this.educationalDegree = educationalDegree;
		this.contractAmount = contractAmount;
		this.avrgZnoMark = avrgZnoMark;
	}

	public Specialty(Integer specialtyID, String specialtyNumber, String specialtyName, String educationalDegree,
			Integer contractAmount, Integer avrgZnoMark) {
		this.specialtyID = specialtyID;
		this.specialtyNumber = specialtyNumber;
		this.specialtyName = specialtyName;
		this.educationalDegree = educationalDegree;
		this.contractAmount = contractAmount;
		this.avrgZnoMark = avrgZnoMark;
	}

	public Integer getSpecialtyID() {
		return specialtyID;
	}

	public void setSpecialtyID(Integer specialtyID) {
		this.specialtyID = specialtyID;
	}

	public String getSpecialtyNumber() {
		return specialtyNumber;
	}

	public void setSpecialtyNumber(String specialtyNumber) {
		this.specialtyNumber = specialtyNumber;
	}

	public String getSpecialtyName() {
		return specialtyName;
	}

	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}

	public String getEducationalDegree() {
		return educationalDegree;
	}

	public void setEducationalDegree(String educationalDegree) {
		this.educationalDegree = educationalDegree;
	}

	public Integer getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(Integer contractAmount) {
		this.contractAmount = contractAmount;
	}

	public Integer getAvrgZnoMark() {
		return avrgZnoMark;
	}

	public void setAvrgZnoMark(Integer avrgZnoMark) {
		this.avrgZnoMark = avrgZnoMark;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avrgZnoMark, contractAmount, educationalDegree, specialtyID, specialtyName,
				specialtyNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specialty other = (Specialty) obj;
		return Objects.equals(avrgZnoMark, other.avrgZnoMark) && Objects.equals(contractAmount, other.contractAmount)
				&& Objects.equals(educationalDegree, other.educationalDegree)
				&& Objects.equals(specialtyID, other.specialtyID) && Objects.equals(specialtyName, other.specialtyName)
				&& Objects.equals(specialtyNumber, other.specialtyNumber);
	}

	@Override
	public String toString() {
		return "Specialty [specialtyID=" + specialtyID + ", specialtyNumber=" + specialtyNumber + ", specialtyName="
				+ specialtyName + ", educationalDegree=" + educationalDegree + ", contractAmount=" + contractAmount
				+ ", avrgZnoMark=" + avrgZnoMark + "]";
	}

}
