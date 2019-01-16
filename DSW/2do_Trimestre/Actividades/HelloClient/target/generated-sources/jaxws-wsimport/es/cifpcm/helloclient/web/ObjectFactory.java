
package es.cifpcm.helloclient.web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.cifpcm.helloclient.web package. 
 * <p>An ObjectFactory allows you to programatically 
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

    private final static QName _HelloResponse_QNAME = new QName("http://hellosoap.cifpcm.es/", "helloResponse");
    private final static QName _Doble_QNAME = new QName("http://hellosoap.cifpcm.es/", "doble");
    private final static QName _DobleResponse_QNAME = new QName("http://hellosoap.cifpcm.es/", "dobleResponse");
    private final static QName _Hello_QNAME = new QName("http://hellosoap.cifpcm.es/", "hello");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.cifpcm.helloclient.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Doble }
     * 
     */
    public Doble createDoble() {
        return new Doble();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link DobleResponse }
     * 
     */
    public DobleResponse createDobleResponse() {
        return new DobleResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hellosoap.cifpcm.es/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Doble }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hellosoap.cifpcm.es/", name = "doble")
    public JAXBElement<Doble> createDoble(Doble value) {
        return new JAXBElement<Doble>(_Doble_QNAME, Doble.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DobleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hellosoap.cifpcm.es/", name = "dobleResponse")
    public JAXBElement<DobleResponse> createDobleResponse(DobleResponse value) {
        return new JAXBElement<DobleResponse>(_DobleResponse_QNAME, DobleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hellosoap.cifpcm.es/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

}
