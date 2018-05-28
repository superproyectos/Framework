package com.framework.Figuras;

import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.TipoCuerpo;

/** Conjunto de propiedades de los cuerpos que se rigen por físicas*/

public interface PropiedadesFisicas
{
    /** Establece la densidad del cuerpo*/

    void setDensidad(float densidad);

    /** Establece la fricción del cuerpo*/

    void setFriccion(float friccion);

    /** Establece la elasticidad del cuerpo*/

    void setRebote(float restitucion);

    /** Establece el cuerpo como sensor*/

    void setSensor(boolean sensor);

    /** Establece la densidad,fricción y elasticidad del cuerpo*/

    void setPropiedades(float densidad,float friccion,float restitucion);

    /** Establece el tipo de cuerpo*/

    void setTipoCuerpo(TipoCuerpo tipoCuerpo);

    /** Genera un cambio de posición*/

    void cambioPosicion();
}
