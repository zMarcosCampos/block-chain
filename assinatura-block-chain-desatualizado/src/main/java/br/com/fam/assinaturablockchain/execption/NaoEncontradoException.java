package br.com.fam.assinaturablockchain.execption;


public class NaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NaoEncontradoException(String msg) {
		super(msg);
	}
	
}
