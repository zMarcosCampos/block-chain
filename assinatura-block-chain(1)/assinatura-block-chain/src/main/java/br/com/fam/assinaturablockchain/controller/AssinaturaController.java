package br.com.fam.assinaturablockchain.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fam.assinaturablockchain.service.AssinaturaService;
import br.com.fam.assinaturablockchain.vo.AssinaturaVO;

@RequestMapping("/assinatura")
@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "")
public class AssinaturaController {

	@Autowired
	AssinaturaService assinaturaService;

	@GetMapping("/{idAssinatura}")
	public AssinaturaVO buscarAssinaturaPorId(@PathVariable Long idAssinatura) {
		return assinaturaService.buscarAssinaturaPorId(idAssinatura);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AssinaturaVO salvarAssinatura(@Valid @RequestBody AssinaturaVO assinatura) {
		return assinaturaService.salvarAssinatura(assinatura);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public AssinaturaVO alterarAssinatura(@Valid @RequestBody AssinaturaVO assinatura) {
		return assinaturaService.alerarAssinatura(assinatura);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarAssinatura(@PathVariable Long idAssinatura) {
		 assinaturaService.deletarAssinatura(idAssinatura);
	}

}
