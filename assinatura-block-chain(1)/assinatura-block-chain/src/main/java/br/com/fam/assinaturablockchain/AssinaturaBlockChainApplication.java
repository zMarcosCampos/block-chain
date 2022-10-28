package br.com.fam.assinaturablockchain;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fam.assinaturablockchain.entity.Block;

@SpringBootApplication
@EnableAutoConfiguration
public class AssinaturaBlockChainApplication {

	ArrayList<Block> blockchain = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(AssinaturaBlockChainApplication.class, args);
	}
}
