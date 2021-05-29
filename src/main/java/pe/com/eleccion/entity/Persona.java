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
public class Persona implements Serializable{
	
	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private long id;
	
	@Column(name = "DNI",nullable = false)
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
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_INSTITUCION")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@Getter @Setter private Institucion idInstitucion;
		
	@NotNull(message = "no puede ser vacia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MESA")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@Getter @Setter private Mesa idMesa;	

	@NotNull(message = "no puede ser vacia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DISTRITO")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@Getter @Setter private Distrito idDistrito;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATETIME")
	@Getter @Setter private Date createDatetime;
	
	public Persona() {
		super();
	}







	/**
	 * 
	 */
	private static final long serialVersionUID = 1565601512237863704L;

}
