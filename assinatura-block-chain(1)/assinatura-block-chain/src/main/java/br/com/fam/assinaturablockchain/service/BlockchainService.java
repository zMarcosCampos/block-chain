package br.com.fam.assinaturablockchain.service;

import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fam.assinaturablockchain.entity.Block;
import br.com.fam.assinaturablockchain.vo.AssinaturaVO;

@Service
public class BlockchainService {

	@Autowired
	private static AssinaturaService service;

	static String[] genesisTransaction = { "AUGUWEB", "STATIC BLOCK" };
	static Block genesisBlock = new Block("AUGUWEBSTATICBLOCKGENERIC", genesisTransaction);

	public static String gerarHash(AssinaturaVO assinaturaVO) {
		String conteudo = assinaturaVO.getIdAssinatura().toString() + assinaturaVO.getSignerName()
				+ assinaturaVO.getSignerEmail() + assinaturaVO.getSenderName() + assinaturaVO.getSenderEmail()
				+ assinaturaVO.getContent();
		String[] block2Transactions = { conteudo };
		if (assinaturaVO.getIdAssinatura() == 1) {
			Block block = new Block(genesisBlock.getPreviousHash(), block2Transactions);
			return sha256Hex(block.toString());
		}
		String hashAnterior = pegarHashAnterior(assinaturaVO.getIdAssinatura());
		Block block = new Block(hashAnterior, block2Transactions);
		System.out.println("conteudo: " + conteudo);
		System.out.println("hash anterior solto: " + hashAnterior);
		System.out.println("hash anterior no block: " + block.getPreviousHash());
		System.out.println("bloco novo em sha256: " + sha256Hex(block.toString()));
		return sha256Hex(block.toString());
	}

	private static String pegarHashAnterior(Long id) {
		if (id != null) {
			AssinaturaVO assinatura = new AssinaturaVO();

			Long idAnterior = id - 1L;
			assinatura = service.buscarAssinaturaPorId(idAnterior);
			return assinatura.getHash();
		}

		return null;
	}

}