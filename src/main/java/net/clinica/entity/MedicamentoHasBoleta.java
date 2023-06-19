package net.clinica.entity;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_medicamento_has_boleta")
public class MedicamentoHasBoleta implements Serializable{
	@EmbeddedId
	private MedicamentoHasBoletaPK pk;
	
	
	//Relación MUCHOS  a UNO "Medicamento"
	@ManyToOne
	@JoinColumn(name="cod_med",referencedColumnName = "cod_med",insertable = false,updatable =false)
	private Medicamento medicamento;//ASOCI.
	
	//Relación MUCHOS  a UNO "Boleta"
	@ManyToOne
	@JoinColumn(name="num_bol",referencedColumnName = "num_bol",insertable = false,updatable =false)
	private Boleta boleta;//ASOCI.
	
	@Column(name = "pre")
	private double precio;
	
	private int cantidad;

	public MedicamentoHasBoletaPK getPk() {
		return pk;
	}

	public void setPk(MedicamentoHasBoletaPK pk) {
		this.pk = pk;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
