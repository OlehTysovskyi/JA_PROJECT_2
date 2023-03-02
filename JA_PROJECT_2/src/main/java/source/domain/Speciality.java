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
	@Column(name = "educt_deegre")
	private String educationalDegree;
	@Column(name = "contract_amount")
	private Integer contractAmount;
	@Column(name = "min_av_zno")
	private Integer minAvZno;

	public Speciality() {
	}

	public Speciality(Integer specialityNumber, String specialityName, String educationalDegree, Integer contractAmount,
			Integer minAvZno) {
		this.specialityNumber = specialityNumber;
		this.specialityName = specialityName;
		this.educationalDegree = educationalDegree;
		this.contractAmount = contractAmount;
		this.minAvZno = minAvZno;
	}

	public Speciality(Integer specialityID, Integer specialityNumber, String specialityName, String educationalDegree,
			Integer contractAmount, Integer minAvZno) {
		this.specialityID = specialityID;
		this.specialityNumber = specialityNumber;
		this.specialityName = specialityName;
		this.educationalDegree = educationalDegree;
		this.contractAmount = contractAmount;
		this.minAvZno = minAvZno;
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

	public Integer getMinAvZno() {
		return minAvZno;
	}

	public void setMinAvZno(Integer minAvZno) {
		this.minAvZno = minAvZno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contractAmount, educationalDegree, minAvZno, specialityID, specialityName,
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
		return Objects.equals(contractAmount, other.contractAmount)
				&& Objects.equals(educationalDegree, other.educationalDegree)
				&& Objects.equals(minAvZno, other.minAvZno) && Objects.equals(specialityID, other.specialityID)
				&& Objects.equals(specialityName, other.specialityName)
				&& Objects.equals(specialityNumber, other.specialityNumber);
	}

	@Override
	public String toString() {
		return "Speciality [specialityID=" + specialityID + ", specialityNumber=" + specialityNumber
				+ ", specialityName=" + specialityName + ", educationalDegree=" + educationalDegree
				+ ", contractAmount=" + contractAmount + ", minAvZno=" + minAvZno + "]";
	}

}
