/**
 * 
 */
package pe.com.eleccion.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wilder Chui
 * Date 15 may. 2021
 * Version 1.0
 */
@Entity
@Table(name="DISTRITO")
public class Distrito implements Serializable{

	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Column(name = "NOMBRE",nullable = false)
	@Size(max=120)
	@Getter @Setter private String nombre;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATETIME",nullable = false)
	@Getter @Setter private Date createDatetime;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8265002799840988742L;

}
