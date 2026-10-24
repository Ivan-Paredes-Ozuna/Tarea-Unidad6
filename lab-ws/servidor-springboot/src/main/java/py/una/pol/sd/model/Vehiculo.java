package py.una.pol.sd.model;

public class Vehiculo {

	private String marca;
	private String modelo;
	private Integer anio;

	public Vehiculo() {
	}
//
	public Vehiculo(String marca, String modelo, Integer anio) {
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return String.format("Vehiculo[marca='%s', modelo='%s', anio=%d]", marca, modelo, anio);
	}
}
