
package com.csvtoexcel.csvtoexcel;

import java.time.LocalDate;

public class BacklogItem {
    
    private String nombrePbi;
    private Long idPbi;
    private int estimacionInicial;
    private String estimacionActual;
    private String horasFaltantes;
    private String fechaFin;

    public BacklogItem(String nombrePbi, Long idPbi, int estimacionInicial, String estimacionActual,String horasFaltantes , String fechaFin) {
        this.nombrePbi = nombrePbi;
        this.idPbi = idPbi;
        this.estimacionInicial = estimacionInicial;
        this.estimacionActual = estimacionActual;
        this.horasFaltantes = horasFaltantes;
        this.fechaFin = fechaFin;
    }

    public void setNombrePbi(String nombrePbi) {
        this.nombrePbi = nombrePbi;
    }

    public void setIdPbi(Long idPbi) {
        this.idPbi = idPbi;
    }

    public void setEstimacionInicial(int estimacionInicial) {
        this.estimacionInicial = estimacionInicial;
    }

    public void setEstimacionActual(String estimacionActual) {
        this.estimacionActual = estimacionActual;
    }

    public void setHorasFaltantes(String horasFaltantes) {
        this.horasFaltantes = horasFaltantes;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public String getNombrePbi() {
        return nombrePbi;
    }

    public Long getIdPbi() {
        return idPbi;
    }

    public int getEstimacionInicial() {
        return estimacionInicial;
    }

    public String getEstimacionActual() {
        return estimacionActual;
    }

    public String getHorasFaltantes() {
        return horasFaltantes;
    }

    public String getFechaFin() {
        return fechaFin;
    }
    
}

