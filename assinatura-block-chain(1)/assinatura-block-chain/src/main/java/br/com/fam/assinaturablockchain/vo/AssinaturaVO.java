package br.com.fam.assinaturablockchain.vo;

import java.io.Serializable;

public class AssinaturaVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idAssinatura;
	
	private String senderName;
	
	private String senderEmail;
	
	private String signerName;
	
	private String signerEmail;
	
	private String content;
	
	private String hash;

	public Long getIdAssinatura() {
		return idAssinatura;
	}

	public void setIdAssinatura(Long idAssinatura) {
		this.idAssinatura = idAssinatura;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSignerName() {
		return signerName;
	}

	public void setSignerName(String signerName) {
		this.signerName = signerName;
	}

	public String getSignerEmail() {
		return signerEmail;
	}

	public void setSignerEmail(String signerEmail) {
		this.signerEmail = signerEmail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "AssinaturaVO [idAssinatura=" + idAssinatura + ", senderName=" + senderName + ", senderEmail="
				+ senderEmail + ", signerName=" + signerName + ", signerEmail=" + signerEmail + ", content=" + content
				+ ", hash=" + hash + "]";
	}

}
