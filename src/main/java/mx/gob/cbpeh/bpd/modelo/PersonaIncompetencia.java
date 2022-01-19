package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="persona_incompetencia")
public class PersonaIncompetencia  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona_incompetencia")
	private int idPersonaIncompetencia;

	private String amaterno;

	private String apaterno;

	private String nombre;

	@ManyToOne
	@JoinColumn(name="id_edad")
	private CatEdad catEdad;

	@ManyToOne
	@JoinColumn(name="persona_incompetencia_estatus")
	private CatEstatus catEstatus;

	@ManyToOne
	@JoinColumn(name="id_municipio")
	private CatMunicipio catMunicipio;

	@ManyToOne
	@JoinColumn(name="id_sexo")
	private CatSexo catSexo;

	public PersonaIncompetencia() {
	}

	public int getIdPersonaIncompetencia() {
		return this.idPersonaIncompetencia;
	}

	public void setIdPersonaIncompetencia(int idPersonaIncompetencia) {
		this.idPersonaIncompetencia = idPersonaIncompetencia;
	}

	public String getAmaterno() {
		return this.amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public String getApaterno() {
		return this.apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CatEdad getCatEdad() {
		return this.catEdad;
	}

	public void setCatEdad(CatEdad catEdad) {
		this.catEdad = catEdad;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public CatMunicipio getCatMunicipio() {
		return this.catMunicipio;
	}

	public void setCatMunicipio(CatMunicipio catMunicipio) {
		this.catMunicipio = catMunicipio;
	}

	public CatSexo getCatSexo() {
		return this.catSexo;
	}

	public void setCatSexo(CatSexo catSexo) {
		this.catSexo = catSexo;
	}

}