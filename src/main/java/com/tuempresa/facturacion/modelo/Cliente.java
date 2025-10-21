package com.tuempresa.facturacion.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(
	name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
	members="numero, nombre" // Muestra únicamente numero y nombre en la misma línea
)
public class Cliente {

	@Id
	@Column(length = 6 )
	int numero;
	@Column(length = 50 )
	@Required
	String nombre;
	@Embedded @NoFrame
	Direccion direccion;
}
