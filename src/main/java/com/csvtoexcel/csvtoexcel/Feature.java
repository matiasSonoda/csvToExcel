
package com.csvtoexcel.csvtoexcel;

import java.util.ArrayList;
import java.util.List;


public class Feature {
    
    private String correo;
    private String equipo;
    private String nombreDesarrollo;
    private boolean fix;
    private Long idDevOps;
    private List<BacklogItem> backlogItems;

    public Feature(String correo, String equipo, String nombreDesarrollo, boolean fix, Long idDevOps) {
        this.correo = correo;
        this.equipo = equipo;
        this.nombreDesarrollo = nombreDesarrollo;
        this.fix = fix;
        this.idDevOps = idDevOps;
        this.backlogItems = new ArrayList<>();
    }

   

    public String getCorreo() {
        return correo;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getNombreDesarrollo() {
        return nombreDesarrollo;
    }

    public boolean isFix() {
        return fix;
    }

    public Long getIdDevOps() {
        return idDevOps;
    }
    
    public List<BacklogItem> getBacklogItems(){
        return backlogItems;
    }
  

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setNombreDesarrollo(String nombreDesarrollo) {
        this.nombreDesarrollo = nombreDesarrollo;
    }

    public void setFix(boolean fix) {
        this.fix = fix;
    }

    public void setIdDevOps(Long idDevOps) {
        this.idDevOps = idDevOps;
    }

    public void setBacklogItem( BacklogItem item) {
        this.backlogItems.add(item);
    }
    
}
