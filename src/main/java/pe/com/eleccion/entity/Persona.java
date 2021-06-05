/**
 * 
 */
package pe.com.eleccion.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wilder Chui
 * Date 15 may. 2021
 * Version 1.0
 */
@Entity
@Table(name="PERSONA")
@NamedQueries({
	@NamedQuery(name = "Persona.findAllFlag", query = "SELECT e FROM Persona e where e.flgGrabado = :flgGrabado "),
	@NamedQuery(name = "Persona.findAllFlagAndDistrito", query = "SELECT e FROM Persona e where e.flgGrabado = :flgGrabado and e.idDistrito.id = :idDistrito order by e.createDatetime desc "),
	@NamedQuery(name = "Persona.findByDni", query = "SELECT e FROM Persona e where e.dni = :dni "),
				
})
public class Persona implements Serializable{
	
	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private long id;
	
	@Column(name = "DNI",nullable = false, unique=true)
	@Size(max=8)
	@Getter @Setter private int dni;
	
	@Column(name = "NOMBRE",nullable = false)
	@Size(max=80)
	@Getter @Setter private String nombre;
	
	@Size(max=80)
	@Column(name = "APELLIDO_PATERNO",nullable = false)
	@Getter @Setter private String apellidoPaterno;
	
	@Size(max=80)
	@Column(name = "APELLIDO_MATERNO",nullable = false)
	@Getter @Setter private String apellidoMaterno;
	
	@NotNull(message = "no puede ser vacia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DISTRITO",nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@Getter @Setter private Distrito idDistrito;
	
	@NotNull(message = "no puede ser vacia")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_INSTITUCION",nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@Getter @Setter private Institucion idInstitucion;
	
	@Column(name = "PERU_LIBRE")
	@Getter @Setter private int peruLibre;
	
	@Column(name = "FUERZA_POPULAR")
	@Getter @Setter private int fuerzaPopular;
	
	@Column(name = "VOTO_BLANCO")
	@Getter @Setter private int votoBlanco;
	
	@Column(name = "VOTO_NULO")
	@Getter @Setter private int votoNulo;
	
	@Column(name = "VOTO_IMPUGNADO")
	@Getter @Setter private int votoImpugnado;
	
	@Column(name = "TOTAL_VOTO_EMITIDO")
	@Getter @Setter private int totalVotoEmitido;
	
	@Column(name = "FLG_GRABADO",nullable = false)
	@Getter @Setter private int flgGrabado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATETIME")
	@Getter @Setter private Date createDatetime;
	
	public Persona() {
	}

	public Persona(long id, @Size(max = 8) int dni, @Size(max = 80) String nombre,
			@Size(max = 80) String apellidoPaterno, @Size(max = 80) String apellidoMaterno,
			@NotNull(message = "no puede ser vacia") Distrito idDistrito,
			@NotNull(message = "no puede ser vacia") Institucion idInstitucion, int peruLibre, int fuerzaPopular,
			int votoBlanco, int votoNulo, int votoImpugnado, int totalVotoEmitido, int flgGrabado,
			Date createDatetime) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.idDistrito = idDistrito;
		this.idInstitucion = idInstitucion;
		this.peruLibre = peruLibre;
		this.fuerzaPopular = fuerzaPopular;
		this.votoBlanco = votoBlanco;
		this.votoNulo = votoNulo;
		this.votoImpugnado = votoImpugnado;
		this.totalVotoEmitido = totalVotoEmitido;
		this.flgGrabado = flgGrabado;
		this.createDatetime = createDatetime;
	}

	public Persona(int peruLibre, int fuerzaPopular, int votoBlanco, int votoNulo, int votoImpugnado,
			int totalVotoEmitido) {
		this.peruLibre = peruLibre;
		this.fuerzaPopular = fuerzaPopular;
		this.votoBlanco = votoBlanco;
		this.votoNulo = votoNulo;
		this.votoImpugnado = votoImpugnado;
		this.totalVotoEmitido = totalVotoEmitido;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1565601512237863704L;

}
