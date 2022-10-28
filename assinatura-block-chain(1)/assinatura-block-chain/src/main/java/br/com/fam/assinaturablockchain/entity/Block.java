package br.com.fam.assinaturablockchain.entity;

import java.util.Arrays;

public class Block {

	private String previousHash;
	private String[] transactions;

	private int blockHash;

	public Block(String previousHash, String[] transactions) {
		this.previousHash = previousHash;
		this.transactions = transactions;

		Object[] contens = { Arrays.hashCode(transactions), previousHash };
		this.blockHash = Arrays.hashCode(contens);

	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
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

	@Override
	public String toString() {
		return "Block [previousHash=" + previousHash + ", transactions=" + Arrays.toString(transactions)
				+ ", blockHash=" + blockHash + "]";
	}

}
