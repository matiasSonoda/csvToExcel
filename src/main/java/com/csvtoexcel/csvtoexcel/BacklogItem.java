
package com.csvtoexcel.csvtoexcel;

import java.time.LocalDate;

public class BacklogItem {
    
    private String nombrePbi;
    private Long idPbi;
    private int estimacionInicial;
    private int estimacionActual;
    private int horasFaltantes;
    private LocalDate fechaFin;

    public BacklogItem(String nombrePbi, Long idPbi, int estimacionInicial, int estimacionActual, LocalDate fechaFin) {
        this.nombrePbi = nombrePbi;
        this.idPbi = idPbi;
        this.estimacionInicial = estimacionInicial;
        this.estimacionActual = estimacionActual;
        this.horasFaltantes = estimacionInicial - estimacionActual;
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

    public int getEstimacionActual() {
        return estimacionActual;
    }

    public int getHorasFaltantes() {
        return horasFaltantes;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setNombrePbi(String nombrePbi) {
        this.nombrePbi = nombrePbi;
    }

    public void setIdPbi(Long idPbi) {
        this.idPbi = idPbi;
    }

    public void setEstimulacionInicial(int estimacionInicial) {
        this.estimacionInicial = estimacionInicial;
    }

    public void setEstimulacionActual(int estimacionActual) {
        this.estimacionActual = estimacionActual;
    }

    public void setHorasFaltantes(int horasFaltantes) {
        this.horasFaltantes = horasFaltantes;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    
}
