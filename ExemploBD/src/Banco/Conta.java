package Banco;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "conta")
public class Conta {
	
	@Id
	@SequenceGenerator(name = "conta", sequenceName = "conta_id_conta_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta")
	@Column(name = "id_conta", nullable = false)
	int id_conta;
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa", nullable = false, unique = false)
	Pessoa pessoa;
	
	@Column(name = "saldo", nullable = false, unique = false)
	double saldo;
	
	public Conta() {
		
	}

	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "Conta [id_conta=" + id_conta + ", pessoa=" + pessoa + ", saldo=" + saldo + "]";
	}
	
	public boolean salvarConta(){
        try{
            EntityManager s = Persistence.createEntityManagerFactory("my-app").createEntityManager();
            EntityTransaction tx_part = s.getTransaction();
            tx_part.begin();
            s.persist(this);
            tx_part.commit();
            s.close();
            return true;
        }
        catch(Exception e){
            System.err.println("Erro: "+e);
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean removerConta(int id_conta){
        try{
            EntityManager s = Persistence.createEntityManagerFactory("my-app").createEntityManager();
            EntityTransaction tx_part = s.getTransaction();
            tx_part.begin();
            Conta conta = s.find(Conta.class, id_conta);
            if(conta != null) s.remove(conta);
            tx_part.commit();
            s.close();
            return true;
        }
        catch(Exception e){
            System.err.println("Erro: "+ e);
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean atualizarConta(){
        try{
            EntityManager s = Persistence.createEntityManagerFactory("my-app").createEntityManager();
            EntityTransaction tx_part = s.getTransaction();
            tx_part.begin();
            s.merge(this); 
            tx_part.commit();
            s.close();
            return true;
        }
        catch(Exception e){
            System.err.println("Erro: "+e);
            e.printStackTrace();
            return false;
        }
    }
	
	public List<Conta> ListConta(){
		List<Conta> lista;
        try{
            EntityManager s = Persistence.createEntityManagerFactory("my-app").createEntityManager();
            EntityTransaction tx_part = s.getTransaction();
            tx_part.begin();
            lista = new ArrayList<Conta>();
            lista = s.createQuery(s.getCriteriaBuilder().createQuery(Conta.class)).getResultList();
            s.close();
            return lista;
        }
        catch(Exception e){
            System.err.println("Erro: "+e);
            return null;
        }
    }
}
