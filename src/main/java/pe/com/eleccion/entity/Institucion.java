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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */
@Entity
@Table(name="INSTITUCION")
public class Institucion implements Serializable{

	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Size(max=80)
	@Column(name = "NOMBRE",nullable = false)
	@Getter @Setter private String nombre;
	
	@Size(max=150)
	@Column(name = "DIRECCION",nullable = false)
	@Getter @Setter private String direccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DISTRITO")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@Getter @Setter private Distrito idDistrito;
	
	@Column(name = "CREATE_DATETIME",nullable = false)
	@Temporal(TemporalType.DATE)
	@Getter @Setter private Date createDatetime;

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9059614188089843350L;

}
