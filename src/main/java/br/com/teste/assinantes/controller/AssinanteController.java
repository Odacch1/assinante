package br.com.teste.assinantes.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.assinantes.model.entities.Assinante;
import br.com.teste.assinantes.model.repositories.AssinanteRepository;

@RestController
@RequestMapping(path = "/assinante")
public class AssinanteController {
	
	@Autowired
	private AssinanteRepository assinanteRepository;
	
	@GetMapping
	public String telaInicial() {
		return "Utilize o Email e senha para entrar no sistema e cancelar/ativar a assinatura.";
	}
	
	@PostMapping
	public @ResponseBody Assinante salvarAssinante(@Valid Assinante assinante) {
		assinanteRepository.save(assinante);
		return assinante;
	}
	
	@PutMapping("/cancelarAssinatura")
	public String cancelarAssinatura(String email, String senha) {
		int id = -1;
		try {
			id = assinanteRepository.findByEmailAndSenha(email, senha);
		} catch (Exception e) {
			return "Cadastro não encontrado";
		}
		
		Optional<Assinante> assinante = Optional.ofNullable(assinanteRepository.findById(id));
		assinante.get().setCancelado(true);
		assinanteRepository.save(assinante.get());
		return "Assinatura do(a) " + assinante.get().getNome() + " cancelada";
	}
	
	@PutMapping("/ativarAssinatura")
	public String ativarAssinatura(String email, String senha) {
		int id = -1;
		try {
			id = assinanteRepository.findByEmailAndSenha(email, senha);
		} catch (Exception e) {
			return "Cadastro não encontrado";
		}
		Optional<Assinante> assinante = Optional.ofNullable(assinanteRepository.findById(id));
		assinante.get().setCancelado(false);
		assinanteRepository.save(assinante.get());
		return "Assinatura do(a) " + assinante.get().getNome() + " ativada";
	}
	
	@GetMapping(path = "/login")
	public boolean getLogin(String email, String senha) {
		int id = assinanteRepository.findByEmailAndSenha(email, senha);
		return id == -1 ? false : true;
	}
	
	@GetMapping(path = "/listaEmails")
	public Iterable<String> getListaEmails(){
		return assinanteRepository.findEmailsAssinantes();
	}
	
}
