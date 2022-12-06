package ma.fstt.beans;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import jakarta.ejb.Stateful;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.persistence.PersistenceContext;
import ma.fstt.entities.Etudiant;
import ma.fstt.persistence.EtudiantTraitementRemote;

@Stateless(name="getudiant")
public class EtudiantTraitementBean implements EtudiantTraitementRemote {
	@PersistenceContext(unitName="Etudiant")
	private EntityManager entityManager;
	
	@Override
	public void save(Etudiant etudiant) {
		System.out.println("Save : " + etudiant.toString());		
		entityManager.persist(etudiant);
	}

	@Override
	public void update(Etudiant etudiant) {
		System.out.println("Update : " + etudiant.toString());
		entityManager.refresh(etudiant);
	}

	@Override
	public void delete(Etudiant etudiant) {
		System.out.println("Delete : " + etudiant.toString());
		entityManager.remove(etudiant);
	}

	@Override
	public Etudiant getById(int idEtudiant) {
		System.out.println("idEtudiant : " + idEtudiant);
		Etudiant etudiant = entityManager.find(Etudiant.class, idEtudiant);
		if(etudiant == null)
			throw new RuntimeException("Etudiant introuvale !");
		return etudiant;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> list() {
		System.out.println("List des �tudiants");
		Query qry = entityManager.createQuery("Select e from Etudiant e");
		return qry.getResultList();
	}

}

