package br.com.fam.assinaturablockchain.entity;

import java.util.Arrays;

public class Block {

	private int previousHash;
	private String[] transactions;

	private int blockHash;

	public Block(int previousHash, String[] transactions) {
		this.previousHash = previousHash;
		this.transactions = transactions;

		Object[] contens = { Arrays.hashCode(transactions), previousHash };
		this.blockHash = Arrays.hashCode(contens);

	}

	public int getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(int previousHash) {
		this.previousHash = previousHash;
	}

	public String[] getTransactions() {
		return transactions;
	}

	public void setTransactions(String[] transactions) {
		this.transactions = transactions;
	}

	public int getBlockHash() {
		return blockHash;
	}

	public void setBlockHash(int blockHash) {
		this.blockHash = blockHash;
	}

}
