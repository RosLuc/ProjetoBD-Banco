package Banco;

import javax.persistence.*;


@Entity
@Table(name = "pessoa")
public class Pessoa {
	//static private EntityManager em = (EntityManager) Persistence.createEntityManagerFactory("MATA-INF/persistence.xml");
	@Id
	@SequenceGenerator(name = "pessoa", sequenceName = "pessoa_id_pessoa_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa")
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
            e.printStackTrace();
            return false;
        }
    }
}
