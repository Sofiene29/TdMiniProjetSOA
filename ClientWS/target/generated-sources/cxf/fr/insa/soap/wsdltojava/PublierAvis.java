
package fr.insa.soap.wsdltojava;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java pour publierAvis complex type.
 * 
 * &lt;p&gt;Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="publierAvis"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="avisTexte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publierAvis", propOrder = {
    "nom",
    "avisTexte"
})
public class PublierAvis {

    protected String nom;
    protected String avisTexte;

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Obtient la valeur de la propriété avisTexte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvisTexte() {
        return avisTexte;
    }

    /**
     * Définit la valeur de la propriété avisTexte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvisTexte(String value) {
        this.avisTexte = value;
    }

}
