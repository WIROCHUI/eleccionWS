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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */
@Entity
@Table(name="MESA")
public class Mesa implements Serializable{
	
	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Column(name = "NUMERO_MESA",nullable = false)
	@Getter @Setter private int numeroMesa;
	
	@Column(name = "ELECTOR_TOTAL",nullable = false)
	@Getter @Setter private int electorTotal;
	
	@Column(name = "ELECTOR_PARTICIPANTE",nullable = false)
	@Getter @Setter private int electorParticipante;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_INSTITUCION")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@Getter @Setter private Institucion institucion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATETIME",nullable = false)
	@Getter @Setter private Date createDatetime;

	/**
	 * 
	 */
	private static final long serialVersionUID = -5993612645288657672L;

}
