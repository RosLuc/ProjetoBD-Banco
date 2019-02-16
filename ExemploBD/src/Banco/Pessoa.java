package Banco;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	//static private EntityManager em = (EntityManager) Persistence.createEntityManagerFactory("MATA-INF/persistence.xml");
	
	@Id
	@SequenceGenerator(name = "pessoas", sequenceName = "pessoa_id_pessoa_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoas")
	@Column(name = "id_pessoa")
	int id_pessoa;
	
	@Column(name = "nome", nullable = false, unique = false)
	String nome;
	
	@Column(name = "cpf", nullable = false, unique = false)
	String CPF;
	
	@Column(name = "rg", nullable = false, unique = false)
	String RG;
	
	public int getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id_pessoa=" + id_pessoa + ", nome=" + nome + ", cpf=" + CPF + ", rg=" + RG +"]";
	}
	
	
	public boolean salvarPessoa(){
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
            return false;
        }
    }
	
	public boolean atualizarPessoa(){
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
            return false;
        }
    }
	
	static public Pessoa buscarPessoa(int id){
        try{
            EntityManager s = Persistence.createEntityManagerFactory("my-app").createEntityManager();
            EntityTransaction tx_part = s.getTransaction();
            tx_part.begin();
            Pessoa p = s.find(Pessoa.class, id);
            tx_part.commit();
            s.close();
            return p;
        }
        catch(Exception e){
            System.err.println("Erro: "+e);
            return null;
        }
    }
	
	public boolean removerPessoa(Pessoa p){
        try{
            EntityManager s = Persistence.createEntityManagerFactory("my-app").createEntityManager();
            EntityTransaction tx_part = s.getTransaction();
            tx_part.begin();
            if (!s.contains(p)) {
                p = s.merge(p);
            }
            s.remove(p);
            tx_part.commit();
            s.close();
            return true;
        }
        catch(Exception e){
            System.err.println("Erro: "+e);
            return false;
        }
    }
	
	static public List<Pessoa> ListPessoa(){
		List<Pessoa> lista;
        try{
            EntityManager s = Persistence.createEntityManagerFactory("my-app").createEntityManager();
            EntityTransaction tx_part = s.getTransaction();
            tx_part.begin();
            //CriteriaQuery<Pessoa> c = s.getCriteriaBuilder().createQuery(Pessoa.class);
            lista = new ArrayList<Pessoa>();
            lista = s.createQuery(s.getCriteriaBuilder().createQuery(Pessoa.class)).getResultList();
            s.close();
            return lista;
        }
        catch(Exception e){
            System.err.println("Erro: "+e);
            return null;
        }
    }
	
	static public boolean validarPessoa(Pessoa p) {
		List<Pessoa> lista;
		lista = Pessoa.ListPessoa();
		for(int i = 0; i < lista.size(); i++) {
			if((p.getCPF().equals(lista.get(i).getCPF()) || p.getRG().equals(lista.get(i).getRG())) && 
					(p.getId_pessoa() != lista.get(i).getId_pessoa())) {
				return false;
			}
		}
		return true;
	}
}