package com.jshx.qyjbxx.getartificialpersonbyorgcode;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-12-15T15:54:17.770+08:00
 * Generated source version: 3.1.4
 * 
 */
@WebServiceClient(name = "GetArtificialPersonByOrgCode", 
                  wsdlLocation = "http://esb.sipac.gov.cn:5888/services/getArtificialPersonByOrgCode?wsdl",
                  targetNamespace = "http://www.apusic.com/esb/GetArtificialPersonByOrgCode") 
public class GetArtificialPersonByOrgCode_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.apusic.com/esb/GetArtificialPersonByOrgCode", "GetArtificialPersonByOrgCode");
    public final static QName GetArtificialPersonByOrgCodeHttpSoap12Endpoint = new QName("http://www.apusic.com/esb/GetArtificialPersonByOrgCode", "GetArtificialPersonByOrgCodeHttpSoap12Endpoint");
    public final static QName GetArtificialPersonByOrgCodeHttpSoap11Endpoint = new QName("http://www.apusic.com/esb/GetArtificialPersonByOrgCode", "GetArtificialPersonByOrgCodeHttpSoap11Endpoint");
    static {
        URL url = null;
        try {
            url = new URL("http://esb.sipac.gov.cn:5888/services/getArtificialPersonByOrgCode?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(GetArtificialPersonByOrgCode_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://esb.sipac.gov.cn:5888/services/getArtificialPersonByOrgCode?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public GetArtificialPersonByOrgCode_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public GetArtificialPersonByOrgCode_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GetArtificialPersonByOrgCode_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    /**
     *
     * @return
     *     returns GetArtificialPersonByOrgCodePortType
     */
    @WebEndpoint(name = "GetArtificialPersonByOrgCodeHttpSoap12Endpoint")
    public GetArtificialPersonByOrgCodePortType getGetArtificialPersonByOrgCodeHttpSoap12Endpoint() {
        return super.getPort(GetArtificialPersonByOrgCodeHttpSoap12Endpoint, GetArtificialPersonByOrgCodePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GetArtificialPersonByOrgCodePortType
     */
    @WebEndpoint(name = "GetArtificialPersonByOrgCodeHttpSoap12Endpoint")
    public GetArtificialPersonByOrgCodePortType getGetArtificialPersonByOrgCodeHttpSoap12Endpoint(WebServiceFeature... features) {
        return super.getPort(GetArtificialPersonByOrgCodeHttpSoap12Endpoint, GetArtificialPersonByOrgCodePortType.class, features);
    }


    /**
     *
     * @return
     *     returns GetArtificialPersonByOrgCodePortType
     */
    @WebEndpoint(name = "GetArtificialPersonByOrgCodeHttpSoap11Endpoint")
    public GetArtificialPersonByOrgCodePortType getGetArtificialPersonByOrgCodeHttpSoap11Endpoint() {
        return super.getPort(GetArtificialPersonByOrgCodeHttpSoap11Endpoint, GetArtificialPersonByOrgCodePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GetArtificialPersonByOrgCodePortType
     */
    @WebEndpoint(name = "GetArtificialPersonByOrgCodeHttpSoap11Endpoint")
    public GetArtificialPersonByOrgCodePortType getGetArtificialPersonByOrgCodeHttpSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(GetArtificialPersonByOrgCodeHttpSoap11Endpoint, GetArtificialPersonByOrgCodePortType.class, features);
    }

}
