package quixada.npi.springproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sigla;

    @Enumerated(EnumType.STRING)
    private Turno turno;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    public Curso(){

    }

    public Curso( String nome, String sigla, Turno turno) {
		this.nome = nome;
		this.sigla = sigla;
		this.turno = turno;
	}   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	} 
    
}