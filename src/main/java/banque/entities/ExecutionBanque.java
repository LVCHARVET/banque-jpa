package banque.entities;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExecutionBanque {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();

		tran.begin();

		Adresse a = new Adresse(51, "rue Anatole France", 69100, "Villeurbanne");

		Banque banque = new Banque();
		banque.setNom("Credit Agricole");

		em.persist(banque);

		Client client = new Client();
		client.setNom("Charvet");
		client.setPrenom("Louis-Valentin");
		client.setDateNaissance(new Date(95, 8, 20));
		client.setAdresse(a);
		client.setBanque(banque);

		em.persist(client);

		LivretA compte1 = new LivretA();
		compte1.setNumero("1111");
		compte1.setSolde(1111.0);
		compte1.setTaux(4.0);

		em.persist(compte1);

		compte1.getClients().add(client);

		AssuranceVie compte2 = new AssuranceVie();
		compte2.setNumero("2222");
		compte2.setSolde(2222.0);
		compte2.setDateFin(new Date(123, 9, 24));
		compte2.setTaux(8.0);

		em.persist(compte2);

		Virement ope1 = new Virement();
		ope1.setDate(new Date(123, 9, 24));
		ope1.setMontant(500);
		ope1.setMotif("Just4FunBrooooooo");
		ope1.setBeneficiaire("M.GleSeum");

		em.persist(ope1);

		tran.commit();

		int id = client.getId();
		System.out.println(id);

		em.close();
		emf.close();
	}

}
