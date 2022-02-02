package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "colaboracion_desaparecidos")
public class ColaboracionDesaparecidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // bi-directional many-to-one association to CatEstatus
    // @ManyToOne
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "aPaterno")
    private String aPaterno;
    @Column(name = "aMaterno")
    private String aMaterno;

    // bi-directional many-to-one association to Colaboracion
    @ManyToOne
    @JoinColumn(name = "id_expediente_colaboracion")
    private Colaboracion colaboracion;

    public ColaboracionDesaparecidos() {
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public Colaboracion getColaboracion() {
        return colaboracion;
    }

    public void setColaboracion(Colaboracion colaboracion) {
        this.colaboracion = colaboracion;
    }

}
