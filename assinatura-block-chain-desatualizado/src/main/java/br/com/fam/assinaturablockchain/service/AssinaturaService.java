package br.com.fam.assinaturablockchain.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fam.assinaturablockchain.entity.AssinaturaEntity;
import br.com.fam.assinaturablockchain.execption.NaoEncontradoException;
import br.com.fam.assinaturablockchain.execption.ParametroInvalidoException;
import br.com.fam.assinaturablockchain.repository.AssinaturaRepository;
import br.com.fam.assinaturablockchain.vo.AssinaturaVO;


@Service
public class AssinaturaService {

	private static final String NAO_ENCONTRADO = "Não foi possível encontrar nenhuma assinatura com esse id:";

	private static final Logger logger = LoggerFactory.getLogger(AssinaturaService.class);

	@Autowired
	AssinaturaRepository assinaturaRepository;

	public AssinaturaVO buscarAssinaturaPorId(Long idAssinatura) {

		logger.info("INICIANDO CONSULTA DE ASSINATURA POR ID: {}", idAssinatura);

		AssinaturaEntity assinatura = assinaturaRepository.findById(idAssinatura)
				.orElseThrow(() -> new NaoEncontradoException(NAO_ENCONTRADO + idAssinatura));

		AssinaturaVO vo = converterResultadoVO(assinatura);

		logger.info("ASSINATURA ENCONTRADA  COM ID: {}", idAssinatura);

		return vo;
	}

	public AssinaturaVO salvarAssinatura(AssinaturaVO assinaturaCadastrar) {

		verificarNomeJaCadastrado(assinaturaCadastrar.getSignerName());
		verificarEmailJaCadastrado(assinaturaCadastrar.getSignerEmail());

		AssinaturaEntity assinaturaEntity = converterCadastroVoParaEntity(assinaturaCadastrar);
		assinaturaEntity = assinaturaRepository.save(assinaturaEntity);

		logger.info("ASSINATURA SALVA COM SUCESSO!");

		return converterEntityParaAssinaturaVO(assinaturaEntity);

	}

	public AssinaturaVO alerarAssinatura(AssinaturaVO assinaturaAlterar) {

		logger.info("VERIFICANDO SE EXISTE O ID");

		AssinaturaEntity assinaturaEntity = assinaturaRepository.findById(assinaturaAlterar.getIdAssinatura())
				.orElseThrow(
						() -> new NaoEncontradoException(NAO_ENCONTRADO
								+ assinaturaAlterar.getIdAssinatura()));

		if (!assinaturaEntity.getSignerName().equals(assinaturaAlterar.getSignerName())) {

			verificarNomeJaCadastrado(assinaturaAlterar.getSignerName());
			verificarEmailJaCadastrado(assinaturaAlterar.getSignerEmail());
		}

		AssinaturaVO assinatura = alterar(assinaturaEntity, assinaturaAlterar);

		logger.info("ASSINATURA  ATUALIZADO COM ID: {}", assinaturaAlterar.getIdAssinatura());

		return assinatura;
	}

	@Transactional
	public void deletarAssinatura(Long idAssinatura) {
		AssinaturaEntity assinatura = assinaturaRepository.findById(idAssinatura)
				.orElseThrow(() -> new NaoEncontradoException(NAO_ENCONTRADO + idAssinatura));

		assinaturaRepository.delete(assinatura);
	}

	private AssinaturaVO alterar(AssinaturaEntity assinaturaEntity, AssinaturaVO assinaturaAlterarVO) {

		assinaturaEntity.setId(assinaturaAlterarVO.getIdAssinatura());
		assinaturaEntity.setSenderName(assinaturaAlterarVO.getSenderName());
		assinaturaEntity.setSenderEmail(assinaturaAlterarVO.getSenderEmail());
		assinaturaEntity.setSignerName(assinaturaAlterarVO.getSignerName());
		assinaturaEntity.setSignerEmail(assinaturaAlterarVO.getSignerEmail());
		assinaturaEntity.setFileName(assinaturaAlterarVO.getFileName());

		assinaturaRepository.save(assinaturaEntity);

		return converterEntityParaAssinaturaVO(assinaturaEntity);

	}

	private AssinaturaVO converterEntityParaAssinaturaVO(AssinaturaEntity assinaturaEntity) {
		AssinaturaVO assinaturaVO = new AssinaturaVO();
		assinaturaVO.setIdAssinatura(assinaturaEntity.getId());
		assinaturaVO.setSenderName(assinaturaEntity.getSenderName());
		assinaturaVO.setSenderEmail(assinaturaEntity.getSenderEmail());
		assinaturaVO.setSignerName(assinaturaEntity.getSenderName());
		assinaturaVO.setSignerEmail(assinaturaEntity.getSignerEmail());
		assinaturaVO.setFileName(assinaturaEntity.getFileName());
		return assinaturaVO;
	}

	private AssinaturaEntity converterCadastroVoParaEntity(AssinaturaVO vo) {
		AssinaturaEntity entity = new AssinaturaEntity();
		entity.setSenderName(vo.getSenderName());
		entity.setSenderEmail(vo.getSenderEmail());
		entity.setSignerName(vo.getSignerName());
		entity.setSignerEmail(vo.getSignerEmail());
		entity.setFileName(vo.getFileName());
		return entity;

	}

	private void verificarNomeJaCadastrado(String signerName) {

		AssinaturaEntity assinatura = assinaturaRepository.findBySignerName(signerName);

		if (assinatura != null) {
			throw new ParametroInvalidoException("Já existe uma assinatura com esse nome: " + signerName);
		}
	}

	private void verificarEmailJaCadastrado(String signerEmail) {

		AssinaturaEntity assinatura = assinaturaRepository.findBySignerEmail(signerEmail);

		if (assinatura != null) {
			throw new ParametroInvalidoException("Já existe uma assinatura com esse email: " + signerEmail);
		}
	}

	private AssinaturaVO converterResultadoVO(AssinaturaEntity entity) {
		AssinaturaVO vo = new AssinaturaVO();
		vo.setIdAssinatura(entity.getId());
		vo.setSenderName(entity.getSenderName());
		vo.setSenderEmail(entity.getSenderEmail());
		vo.setSignerName(entity.getSignerName());
		vo.setSignerEmail(entity.getSignerEmail());
		vo.setFileName(entity.getFileName());
		return vo;
	}
	
	

	
	
	
	
	
	

	
	}


