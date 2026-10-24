package py.una.pol.sd.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.una.pol.sd.model.Vehiculo;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

	private final List<Vehiculo> vehiculos = new ArrayList<>();

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Vehiculo>> listar() throws UnknownHostException {
		InetAddress local = InetAddress.getLocalHost();

		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Servidor", local.getHostName() + " / " + local.getHostAddress());
		headers.add("X-Fecha", new Date().toString());

		return new ResponseEntity<>(new ArrayList<>(vehiculos), headers, HttpStatus.OK);
	}

	@PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> crear(@RequestBody Vehiculo vehiculo) {
		if (vehiculo == null || vehiculo.getMarca() == null || vehiculo.getModelo() == null || vehiculo.getAnio() == null) {
			return new ResponseEntity<>("Debe enviar marca, modelo y anio.", HttpStatus.BAD_REQUEST);
		}

		vehiculos.add(vehiculo);
		return new ResponseEntity<>("Se creó correctamente el vehículo: " + vehiculo.toString(), HttpStatus.OK);
	}
}
