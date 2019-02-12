package Banco;

import javax.persistence.*;

@Entity
@Table(name = "conta", schema = "jpa")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_conta", nullable = false)
	int id_conta;
	
	@Column(name = "id_pessoa", nullable = false,
			insertable = true, updatable = true, unique = false)
	int id_pessoa;
	
	@Column(name = "saldo", nullable = false,
			insertable = true, updatable = true, unique = false)
	double saldo;
	
	public Conta() {
		
	}

	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}

	public int getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
