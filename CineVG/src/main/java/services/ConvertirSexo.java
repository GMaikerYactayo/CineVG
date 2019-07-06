package services;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author Ctorres
 *//**
 *
 * @author Ctorres
 */
@FacesConverter("convertir")
public class ConvertirSexo implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        String SEXCLI = "";
        if (value != null) {
            SEXCLI = (String) value;
            switch (SEXCLI) {
                case "M":
                    SEXCLI = "MASCULINO";
                    break;
                case "F":
                    SEXCLI = "FEMENINO";
                    break;
            }
        }
        return SEXCLI;
    }
    
}
