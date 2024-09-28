
package com.csvtoexcel.csvtoexcel;

import java.time.LocalDate;

public class BacklogItem {
    
    private String nombrePbi;
    private Long idPbi;
    private int estimulacionInicial;
    private int estimulacionActual;
    private int horasFaltantes;
    private LocalDate fechaFin;

    public BacklogItem(String nombrePbi, Long idPbi, int estimulacionInicial, int estimulacionActual, LocalDate fechaFin) {
        this.nombrePbi = nombrePbi;
        this.idPbi = idPbi;
        this.estimulacionInicial = estimulacionInicial;
        this.estimulacionActual = estimulacionActual;
        this.horasFaltantes = estimulacionInicial - estimulacionActual;
        this.fechaFin = fechaFin;
    }

    public String getNombrePbi() {
        return nombrePbi;
    }

    public Long getIdPbi() {
        return idPbi;
    }

    public int getEstimulacionInicial() {
        return estimulacionInicial;
    }

    public int getEstimulacionActual() {
        return estimulacionActual;
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

    public void setEstimulacionInicial(int estimulacionInicial) {
        this.estimulacionInicial = estimulacionInicial;
    }

    public void setEstimulacionActual(int estimulacionActual) {
        this.estimulacionActual = estimulacionActual;
    }

    public void setHorasFaltantes(int horasFaltantes) {
        this.horasFaltantes = horasFaltantes;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    
}
