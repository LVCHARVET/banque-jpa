package banque.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte {

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_FIN")
	Date dateFin;

	@Column(name = "TAUX", length = 10, nullable = false)
	double taux;

	public AssuranceVie() {
		// TODO Auto-generated constructor stub
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
