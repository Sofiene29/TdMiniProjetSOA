
package fr.insa.soap.wsdltojava;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.insa.soap.wsdltojava package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PublierAvis_QNAME = new QName("http://soap.insa.fr/", "publierAvis");
    private final static QName _PublierAvisResponse_QNAME = new QName("http://soap.insa.fr/", "publierAvisResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.insa.soap.wsdltojava
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PublierAvis }
     * 
     */
    public PublierAvis createPublierAvis() {
        return new PublierAvis();
    }

    /**
     * Create an instance of {@link PublierAvisResponse }
     * 
     */
    public PublierAvisResponse createPublierAvisResponse() {
        return new PublierAvisResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublierAvis }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PublierAvis }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.insa.fr/", name = "publierAvis")
    public JAXBElement<PublierAvis> createPublierAvis(PublierAvis value) {
        return new JAXBElement<PublierAvis>(_PublierAvis_QNAME, PublierAvis.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublierAvisResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PublierAvisResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.insa.fr/", name = "publierAvisResponse")
    public JAXBElement<PublierAvisResponse> createPublierAvisResponse(PublierAvisResponse value) {
        return new JAXBElement<PublierAvisResponse>(_PublierAvisResponse_QNAME, PublierAvisResponse.class, null, value);
    }

}
