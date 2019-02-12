package Teste;

import Banco.*; 

public class TesteContaBancaria {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		Conta c = new Conta();
		
		p.setCPF("1001");
		p.setNome("Rosendo");
		p.setRG("222");
		p.setId_pessoa(1);
		
		c.setId_pessoa(1);
		c.setSaldo(00.00);
		
		//ContaBancariaDAO dao = new ContaBancariaDAO(p, c);
		
		p.salvarPessoa();
		
	}

}
