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

	@Column(name = "received", columnDefinition = "boolean default false")
	private boolean received;


	public Entrant() {
	}

	public Entrant(User user, Speciality speciality, int avZnoScore, boolean received) {
		this.user = user;
		this.speciality = speciality;
		this.avZnoScore = avZnoScore;
		this.received = received;
	}

	public Entrant(Integer id, User user, Speciality speciality, int avZnoScore, boolean received) {
		this.id = id;
		this.user = user;
		this.speciality = speciality;
		this.avZnoScore = avZnoScore;
		this.received = received;
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

	public boolean isReceived() {
		return received;
	}

	public void setReceived(boolean received) {
		this.received = received;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Entrant entrant = (Entrant) o;
		return avZnoScore == entrant.avZnoScore && received == entrant.received && Objects.equals(id, entrant.id) && Objects.equals(user, entrant.user) && Objects.equals(speciality, entrant.speciality);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, user, speciality, avZnoScore, received);
	}

	@Override
	public String toString() {
		return "Entrant{" +
				"id=" + id +
				", user=" + user +
				", speciality=" + speciality +
				", avZnoScore=" + avZnoScore +
				", received=" + received +
				'}';
	}
}
