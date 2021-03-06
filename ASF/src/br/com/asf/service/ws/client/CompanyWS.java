
package br.com.asf.service.ws.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CompanyWS", targetNamespace = "http://ws.service.asf.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CompanyWS {


    /**
     * 
     * @return
     *     returns java.util.List<br.com.asf.service.ws.client.Company>
     */
    @WebMethod
    @WebResult(name = "company", targetNamespace = "")
    @RequestWrapper(localName = "getAllCompanies", targetNamespace = "http://ws.service.asf.com.br/", className = "br.com.asf.service.ws.client.GetAllCompanies")
    @ResponseWrapper(localName = "getAllCompaniesResponse", targetNamespace = "http://ws.service.asf.com.br/", className = "br.com.asf.service.ws.client.GetAllCompaniesResponse")
    public List<Company> getAllCompanies();

    /**
     * 
     * @param name
     * @param cnpj
     * @return
     *     returns br.com.asf.service.ws.client.ResponseMessage
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "signUpCompany", targetNamespace = "http://ws.service.asf.com.br/", className = "br.com.asf.service.ws.client.SignUpCompany")
    @ResponseWrapper(localName = "signUpCompanyResponse", targetNamespace = "http://ws.service.asf.com.br/", className = "br.com.asf.service.ws.client.SignUpCompanyResponse")
    public ResponseMessage signUpCompany(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "cnpj", targetNamespace = "")
        String cnpj);

    /**
     * 
     * @param id
     * @return
     *     returns br.com.asf.service.ws.client.ResponseMessage
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeCompany", targetNamespace = "http://ws.service.asf.com.br/", className = "br.com.asf.service.ws.client.RemoveCompany")
    @ResponseWrapper(localName = "removeCompanyResponse", targetNamespace = "http://ws.service.asf.com.br/", className = "br.com.asf.service.ws.client.RemoveCompanyResponse")
    public ResponseMessage removeCompany(
        @WebParam(name = "id", targetNamespace = "")
        String id);

}
