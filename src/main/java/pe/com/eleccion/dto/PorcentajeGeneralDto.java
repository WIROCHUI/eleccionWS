/**
 * 
 */
package pe.com.eleccion.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Wilder Chui
 * Date 17 may. 2021
 * Version 1.0
 */
public class PorcentajeGeneralDto {
	
	@Getter @Setter private double partidoCastillo;	
	@Getter @Setter private double partidoFujimori;	
	@Getter @Setter private double votoBlanco;	
	@Getter @Setter private double votoNulo;	
	@Getter @Setter private double votoImpugnado;	
	@Getter @Setter private double totalVotosEmitidos;
	

	public PorcentajeGeneralDto() {
		super();
	}

	public PorcentajeGeneralDto(int partidoCastillo, int partidoFujimori, int votoBlanco, int votoNulo,
			int votoImpugnado, int totalVotosEmitidos) {
		this.partidoCastillo = partidoCastillo;
		this.partidoFujimori = partidoFujimori;
		this.votoBlanco = votoBlanco;
		this.votoNulo = votoNulo;
		this.votoImpugnado = votoImpugnado;
		this.totalVotosEmitidos = totalVotosEmitidos;
	}
	
	
}
