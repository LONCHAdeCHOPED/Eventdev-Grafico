package com.azahartech.eventdev.datos;
import com.azahartech.eventdev.modelo.Evento;
import jakarta.xml.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "catalago_eventos")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaEventosWrapper {

    @XmlElement(name = "evento")
    private List<Evento> lista = new ArrayList<>();

    public ListaEventosWrapper(){}

    public void setLista(List<Evento> lista) { this.lista = lista; }
    public List<Evento> getLista() { return lista; }
}
