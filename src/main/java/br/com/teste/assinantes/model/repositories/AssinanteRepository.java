package br.com.teste.assinantes.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.teste.assinantes.model.entities.Assinante;

public interface AssinanteRepository extends CrudRepository<Assinante, Integer> {
	
	@Query("SELECT id FROM Assinante WHERE email = :email AND senha = :senha")
	public int findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
	
	@Query("SELECT email FROM Assinante WHERE cancelado is false")
	public Iterable<String> findEmailsAssinantes();
	
	public Assinante findById(int id);
	
}
