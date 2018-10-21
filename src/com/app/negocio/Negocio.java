package com.app.negocio;

import com.app.entidades.Artefacto;

import java.util.ArrayList;
import java.util.List;

public class Negocio {

    public double obtenerIGV(Artefacto artefacto) {
        double igv = artefacto.getPrecio() * 0.18;
        return igv;
    }

    public double obtenerDescuento(Artefacto artefacto) {
        double descuento;
        if ("PHILLIPS".equalsIgnoreCase(artefacto.getMarca())) {
            descuento = artefacto.getPrecio() * 0.10;
            return descuento;
        }
        return 0;
    }

    public double obtenerMontoNeto(Artefacto artefacto) {
        double montoNeto = artefacto.getPrecio() - obtenerIGV(artefacto) - obtenerDescuento(artefacto);
        return montoNeto;
    }

    public List<Artefacto> obtenerCatalogo() {
        List<Artefacto> artefactos = new ArrayList<>();
        Artefacto artefacto1 = new Artefacto();
        artefacto1.setCodigo(101);
        artefacto1.setDescripcion("Cafetera");
        artefacto1.setMarca("PHILLIPS");
        artefacto1.setModelo("HD7447/20");
        artefacto1.setAniosGarantia(2);
        artefacto1.setPrecio(224.90);
        artefacto1.setIgv(obtenerIGV(artefacto1));
        artefacto1.setMontoNeto(obtenerMontoNeto(artefacto1));

        Artefacto artefacto2 = new Artefacto();
        artefacto2.setCodigo(102);
        artefacto2.setDescripcion("Microondas");
        artefacto2.setMarca("RECCO");
        artefacto2.setModelo("RMD-B20");
        artefacto2.setAniosGarantia(3);
        artefacto2.setPrecio(190.00);
        artefacto2.setIgv(obtenerIGV(artefacto2));
        artefacto2.setMontoNeto(obtenerMontoNeto(artefacto2));

        Artefacto artefacto3 = new Artefacto();
        artefacto3.setCodigo(103);
        artefacto3.setDescripcion("Refrigeradora");
        artefacto3.setMarca("LG");
        artefacto3.setModelo("GB45EV");
        artefacto3.setAniosGarantia(1);
        artefacto3.setPrecio(3455.00);
        artefacto3.setIgv(obtenerIGV(artefacto3));
        artefacto3.setMontoNeto(obtenerMontoNeto(artefacto3));

        artefactos.add(artefacto1);
        artefactos.add(artefacto2);
        artefactos.add(artefacto3);
        return artefactos;
    }

    public double obtenerTotalMontosNetos(List<Artefacto> lista) {
        double suma = 0;
        for (Artefacto a:lista) {
            suma = suma + a.getMontoNeto();
        }
        return suma;
    }
}
