package Teste;

import java.util.List;
import Banco.*; 
import Interface.Interface;

public class TesteContaBancaria {

	public static void main(String[] args) {
		
		Interface.main(args);
		
		Pessoa p = new Pessoa();
		p.setCPF("1001");
		p.setNome("Rosendo Lucas");
		p.setRG("222");
		
		//p.salvarPessoa(p);
		//p = p.buscarPessoa(1);
		
		List<Pessoa> lista = p.ListPessoa();
		for(int i = 0; i < lista.size(); i++ ) {
			System.out.println(lista.get(i));
		}
		
		Conta c = new Conta();
		//c.setId_conta(2);
		c.setSaldo(500.00);
		//c.setPessoa(p.buscarPessoa(2));
		//c.salvarConta();
		c.removerConta(1);
		List<Conta> lista2 = c.ListConta();
		for(int i = 0; i < lista2.size(); i++ ) {
			System.out.println(lista2.get(i));
		}
		
	}

}
