package ar.com.laboratory.examplebatchapi.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class PriceDollarResponse {
    private String moneda;
    private String casa;
    private String nombre;
    private double compra;
    private double venta;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date fechaActualizacion;
}
