package source.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrants")
public class Entrant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "spl_id", referencedColumnName = "spl_id")
	private Speciality speciality;

	@Column(name = "av_zno_score")
	private int avZnoScore;

	public Entrant() {
	}

	public Entrant(User user, Speciality speciality, int avZnoScore) {
		this.user = user;
		this.speciality = speciality;
		this.avZnoScore = avZnoScore;
	}

	public Entrant(Integer id, User user, Speciality speciality, int avZnoScore) {
		this.id = id;
		this.user = user;
		this.speciality = speciality;
		this.avZnoScore = avZnoScore;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public int getAvZnoScore() {
		return avZnoScore;
	}

	public void setAvZnoScore(int avZnoScore) {
		this.avZnoScore = avZnoScore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avZnoScore, id, speciality, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrant other = (Entrant) obj;
		return avZnoScore == other.avZnoScore && Objects.equals(id, other.id)
				&& Objects.equals(speciality, other.speciality) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "EntrantSpeciality [id=" + id + ", user=" + user + ", speciality=" + speciality + ", avZnoScore="
				+ avZnoScore + "]";
	}

}
