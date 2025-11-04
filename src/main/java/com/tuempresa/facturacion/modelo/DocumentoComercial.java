package com.tuempresa.facturacion.modelo;
 
import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.tuempresa.facturacion.calculadores.*;

import lombok.*;

@Entity @Getter @Setter
@View(members=
"anyo, numero, fecha," + // Los miembros para la cabecera en una línea
"datos {" + // Una pestaña 'datos' para los datos principales del documento
    "cliente;" +
    "detalles;" +
    "observaciones" +
"}"
)

abstract public class DocumentoComercial extends Identificable{

    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class) // Año actual
    int anyo;
 
    @Column(length=6)
    @DefaultValueCalculator(value=CalculadorSiguienteNumeroParaAnyo.class,
        properties=@PropertyValue(name="anyo"))
    int numero;
 
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fecha;
 
    @Stereotype("MEMO")
    String observaciones;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false) // El cliente es obligatorio
    @ReferenceView("Simple")
    Cliente cliente;
    

    @ElementCollection
    @ListProperties(
            "producto.numero, producto.descripcion, cantidad, precioPorUnidad, " +
            "importe+[" + 
            	"documentoComercial.porcentajeIVA," +
            	"documentoComercial.iva," +
            	"documentoComercial.importeTotal" +
            "]" 
        )	
    Collection<Detalle> detalles;
    
    @Digits(integer=2, fraction=0) // Para indicar su tamaño
    BigDecimal porcentajeIVA;
       
    @ReadOnly
    @Stereotype("DINERO")
    @Money
    @Calculation("sum(detalles.importe) * porcentajeIVA / 100")
    BigDecimal iva;

    @ReadOnly
    @Stereotype("DINERO")
    @Money
    @Calculation("sum(detalles.importe) + iva")    
    BigDecimal importeTotal;    
}