package ma.fstt.persistence;

import java.util.List;

import jakarta.ejb.Remote;

import ma.fstt.entities.Etudiant;

@Remote
public interface EtudiantTraitementRemote {
	public void save(Etudiant etudiant);
	public void update(Etudiant etudiant);
	public void delete(Etudiant etudiant);
	public Etudiant getById(int idEtudiant);
	public List<Etudiant> list();
}