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

    @NotEmpty
    private String turno;
    
    @OneToMany(mappedBy = "curso", cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Usuario> usuarios;

    public Curso(){

    }

    public Curso( String nome, String sigla, String turno) {
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

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
}