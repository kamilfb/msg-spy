//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.02 at 11:52:54 PM GMT 
//


package pl.baczkowicz.mqspy.swarm.generated.configuration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.baczkowicz.mqspy.swarm.generated.configuration package. 
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

    private final static QName _MqSpySwarmConfiguration_QNAME = new QName("http://baczkowicz.pl/spy/mq-spy-swarm/configuration", "MqSpySwarmConfiguration");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.baczkowicz.mqspy.swarm.generated.configuration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MqSpySwarmConfiguration }
     * 
     */
    public MqSpySwarmConfiguration createMqSpySwarmConfiguration() {
        return new MqSpySwarmConfiguration();
    }

    /**
     * Create an instance of {@link SwarmGroup }
     * 
     */
    public SwarmGroup createSwarmGroup() {
        return new SwarmGroup();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqSpySwarmConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://baczkowicz.pl/spy/mq-spy-swarm/configuration", name = "MqSpySwarmConfiguration")
    public JAXBElement<MqSpySwarmConfiguration> createMqSpySwarmConfiguration(MqSpySwarmConfiguration value) {
        return new JAXBElement<MqSpySwarmConfiguration>(_MqSpySwarmConfiguration_QNAME, MqSpySwarmConfiguration.class, null, value);
    }

}
