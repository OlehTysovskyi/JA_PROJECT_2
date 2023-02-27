package source.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specialitys")
public class Speciality {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spl_id")
	private Integer specialityID;
	@Column(name = "spl_num")
	private Integer specialityNumber;
	@Column(name = "spl_name")
	private String specialityName;
	@Column(name = "educt_id")
	private String educationalDegree;
	@Column(name = "contract_amount")
	private Integer contractAmount;
	@Column(name = "avrg_zno_mark")
	private Integer avrgZnoMark;

	public Speciality() {
	}

	public Speciality(Integer specialityNumber, String specialityName, String educationalDegree, Integer contractAmount,
			Integer avrgZnoMark) {
		this.specialityNumber = specialityNumber;
		this.specialityName = specialityName;
		this.educationalDegree = educationalDegree;
		this.contractAmount = contractAmount;
		this.avrgZnoMark = avrgZnoMark;
	}

	public Speciality(Integer specialityID, Integer specialityNumber, String specialityName, String educationalDegree,
			Integer contractAmount, Integer avrgZnoMark) {
		this.specialityID = specialityID;
		this.specialityNumber = specialityNumber;
		this.specialityName = specialityName;
		this.educationalDegree = educationalDegree;
		this.contractAmount = contractAmount;
		this.avrgZnoMark = avrgZnoMark;
	}

	public Integer getSpecialityID() {
		return specialityID;
	}

	public void setSpecialityID(Integer specialityID) {
		this.specialityID = specialityID;
	}

	public Integer getSpecialityNumber() {
		return specialityNumber;
	}

	public void setSpecialityNumber(Integer specialityNumber) {
		this.specialityNumber = specialityNumber;
	}

	public String getSpecialityName() {
		return specialityName;
	}

	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
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
		return Objects.hash(avrgZnoMark, contractAmount, educationalDegree, specialityID, specialityName,
				specialityNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Speciality other = (Speciality) obj;
		return Objects.equals(avrgZnoMark, other.avrgZnoMark) && Objects.equals(contractAmount, other.contractAmount)
				&& Objects.equals(educationalDegree, other.educationalDegree)
				&& Objects.equals(specialityID, other.specialityID)
				&& Objects.equals(specialityName, other.specialityName)
				&& Objects.equals(specialityNumber, other.specialityNumber);
	}

	@Override
	public String toString() {
		return "Speciality [specialityID=" + specialityID + ", specialityNumber=" + specialityNumber
				+ ", specialityName=" + specialityName + ", educationalDegree=" + educationalDegree
				+ ", contractAmount=" + contractAmount + ", avrgZnoMark=" + avrgZnoMark + "]";
	}

}
