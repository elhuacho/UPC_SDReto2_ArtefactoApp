package com.app.pruebas;

import com.app.entidades.Artefacto;
import com.app.negocio.Negocio;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class PruebaNegocio {

    @Test
    public void pruebaIGV() {
        Artefacto artefacto = new Artefacto();
        artefacto.setCodigo(101);
        artefacto.setDescripcion("Cafetera");
        artefacto.setMarca("PHILLIPS");
        artefacto.setModelo("HD7447/20");
        artefacto.setAniosGarantia(2);
        artefacto.setPrecio(224.90);
        Negocio negocio = new Negocio();
        double igv = negocio.obtenerIGV(artefacto);
        Assert.assertEquals(40.482, igv, 0);
    }

    @Test
    public void pruebaDescuento() {
        Artefacto artefacto = new Artefacto();
        artefacto.setCodigo(101);
        artefacto.setDescripcion("Microondas");
        artefacto.setMarca("PHILLIPS");
        artefacto.setModelo("PH-123");
        artefacto.setAniosGarantia(1);
        artefacto.setPrecio(190.00);
        Negocio negocio = new Negocio();
        double descuento = negocio.obtenerDescuento(artefacto);
        Assert.assertEquals(19.0, descuento, 0);
    }

    @Test
    public void pruebaMontoNeto() {
        Artefacto artefacto = new Artefacto();
        artefacto.setCodigo(103);
        artefacto.setDescripcion("Refrigeradora");
        artefacto.setMarca("LG");
        artefacto.setModelo("GB45EV");
        artefacto.setAniosGarantia(1);
        artefacto.setPrecio(3455.00);
        Negocio negocio = new Negocio();
        double montoNeto = negocio.obtenerMontoNeto(artefacto);
        Assert.assertEquals(2833.1, montoNeto, 0);
    }

    @Test
    public void pruebaCatalogo() {
        Negocio negocio = new Negocio();
        List<Artefacto> lista = negocio.obtenerCatalogo();
        Assert.assertEquals(3, lista.size());
    }

    @Test
    public void pruebaTotalMontosNetos() {
        Negocio negocio = new Negocio();
        List<Artefacto> lista = negocio.obtenerCatalogo();
        double totalMontosNetos = negocio.obtenerTotalMontosNetos(lista);
        Assert.assertEquals(3150.828, totalMontosNetos, 0);
    }
}
