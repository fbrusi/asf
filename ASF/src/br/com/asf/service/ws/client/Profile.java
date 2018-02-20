
package br.com.asf.service.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de profile.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="profile">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ANALISTA"/>
 *     &lt;enumeration value="ADMINISTRADOR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "profile")
@XmlEnum
public enum Profile {

    ANALISTA,
    ADMINISTRADOR;

    public String value() {
        return name();
    }

    public static Profile fromValue(String v) {
        return valueOf(v);
    }

}
