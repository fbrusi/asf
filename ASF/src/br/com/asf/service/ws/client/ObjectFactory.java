
package br.com.asf.service.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.asf.service.ws.client package. 
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

    private final static QName _GetAllCompanies_QNAME = new QName("http://ws.service.asf.com.br/", "getAllCompanies");
    private final static QName _GetAllCompaniesResponse_QNAME = new QName("http://ws.service.asf.com.br/", "getAllCompaniesResponse");
    private final static QName _SignUpCompany_QNAME = new QName("http://ws.service.asf.com.br/", "signUpCompany");
    private final static QName _SignUpCompanyResponse_QNAME = new QName("http://ws.service.asf.com.br/", "signUpCompanyResponse");
    private final static QName _RemoveCompany_QNAME = new QName("http://ws.service.asf.com.br/", "removeCompany");
    private final static QName _RemoveCompanyResponse_QNAME = new QName("http://ws.service.asf.com.br/", "removeCompanyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.asf.service.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveCompany }
     * 
     */
    public RemoveCompany createRemoveCompany() {
        return new RemoveCompany();
    }

    /**
     * Create an instance of {@link SignUpCompany }
     * 
     */
    public SignUpCompany createSignUpCompany() {
        return new SignUpCompany();
    }

    /**
     * Create an instance of {@link SignUpCompanyResponse }
     * 
     */
    public SignUpCompanyResponse createSignUpCompanyResponse() {
        return new SignUpCompanyResponse();
    }

    /**
     * Create an instance of {@link GetAllCompanies }
     * 
     */
    public GetAllCompanies createGetAllCompanies() {
        return new GetAllCompanies();
    }

    /**
     * Create an instance of {@link GetAllCompaniesResponse }
     * 
     */
    public GetAllCompaniesResponse createGetAllCompaniesResponse() {
        return new GetAllCompaniesResponse();
    }

    /**
     * Create an instance of {@link RemoveCompanyResponse }
     * 
     */
    public RemoveCompanyResponse createRemoveCompanyResponse() {
        return new RemoveCompanyResponse();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public Company createCompany() {
        return new Company();
    }

    /**
     * Create an instance of {@link ResponseMessage }
     * 
     */
    public ResponseMessage createResponseMessage() {
        return new ResponseMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCompanies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.asf.com.br/", name = "getAllCompanies")
    public JAXBElement<GetAllCompanies> createGetAllCompanies(GetAllCompanies value) {
        return new JAXBElement<GetAllCompanies>(_GetAllCompanies_QNAME, GetAllCompanies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCompaniesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.asf.com.br/", name = "getAllCompaniesResponse")
    public JAXBElement<GetAllCompaniesResponse> createGetAllCompaniesResponse(GetAllCompaniesResponse value) {
        return new JAXBElement<GetAllCompaniesResponse>(_GetAllCompaniesResponse_QNAME, GetAllCompaniesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignUpCompany }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.asf.com.br/", name = "signUpCompany")
    public JAXBElement<SignUpCompany> createSignUpCompany(SignUpCompany value) {
        return new JAXBElement<SignUpCompany>(_SignUpCompany_QNAME, SignUpCompany.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignUpCompanyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.asf.com.br/", name = "signUpCompanyResponse")
    public JAXBElement<SignUpCompanyResponse> createSignUpCompanyResponse(SignUpCompanyResponse value) {
        return new JAXBElement<SignUpCompanyResponse>(_SignUpCompanyResponse_QNAME, SignUpCompanyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCompany }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.asf.com.br/", name = "removeCompany")
    public JAXBElement<RemoveCompany> createRemoveCompany(RemoveCompany value) {
        return new JAXBElement<RemoveCompany>(_RemoveCompany_QNAME, RemoveCompany.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCompanyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.asf.com.br/", name = "removeCompanyResponse")
    public JAXBElement<RemoveCompanyResponse> createRemoveCompanyResponse(RemoveCompanyResponse value) {
        return new JAXBElement<RemoveCompanyResponse>(_RemoveCompanyResponse_QNAME, RemoveCompanyResponse.class, null, value);
    }

}
