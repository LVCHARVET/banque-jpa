package banque.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte {

	@Column(name = "TAUX", length = 10, nullable = false)
	double taux;

	public LivretA() {
	}

	@Override
	public String toString() {
		return "LivretA [taux=" + taux + "]";
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
