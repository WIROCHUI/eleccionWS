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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wilder Chui
 * Date 17 may. 2021
 * Version 1.0
 */
@Entity
@Table(name="VOTACION")
public class Votacion implements Serializable{

	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Column(name = "PERU_LIBRE",nullable = false)
	@Getter @Setter private int partidoCastillo;
	
	@Column(name = "FUERZA_POPULAR",nullable = false)
	@Getter @Setter private int partidoFujimori;
	
	@Column(name = "VOTO_BLANCO")
	@Getter @Setter private int votoBlanco;
	
	@Column(name = "VOTO_NULO")
	@Getter @Setter private int votoNulo;
	
	@Column(name = "VOTO_IMPUGNADO")
	@Getter @Setter private int votoImpugnado;
	
	@Column(name = "TOTAL_VOTO_EMITOS")
	@Getter @Setter private int totalVotosEmitidos;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATETIME")
	@Getter @Setter private Date createDatetime;
	
	@NotNull(message = "no puede ser vacia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERSONA")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@Getter @Setter private Persona idPersona;



	/**
	 * 
	 */
	private static final long serialVersionUID = -548771744211289281L;
}
