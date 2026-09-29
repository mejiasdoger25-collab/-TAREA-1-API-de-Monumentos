package com.salesianos.dam.tareamonumentos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monument {

    /*
    Su ID (un número entero)
    El código de país (según el código ISO 3166-1 alfa 2).
    El nombre del país.
    El nombre de la ciudad.
            Su localización (latitud, longitud).
    El nombre del monumento
    Un descripción del mismo
    La URL de una foto.
    */

    @Id @GeneratedValue
    private Long id;
    private String countryCode;
    private String countryName;
    private String cityName;
    private float latitude;
    private float length;
    private String monumentName;
    private String monumentDescription;
    private String imageURL;


}
