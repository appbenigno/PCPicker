/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker;
import java.net.URL;
import java.net.URLEncoder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
/**
 *
 * @author admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Coordinates")
public class Coordinates {

    /**
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public double getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(double lng) {
        this.lng = lng;
    }
    @XmlElement(name = "lat")
    protected double lat;
    @XmlElement(name = "lng")
    protected double lng;
   
    
    public static Coordinates getCoordinates(String _currentLocation){        
        Double lat =0.0;
        Double lng =0.0;  
        try{
            URL url = new URL("https://maps.googleapis.com/maps/api/geocode/xml?address="
                        //+ _currentLocation.replaceAll(" ", "+")   
                        + URLEncoder.encode(_currentLocation,"UTF-8")
                        + "&key="
                        + "AIzaSyA9GSrFDlDtDCRlcZzB9alI1X86VBLXsqA");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression exprLat = xpath.compile("/GeocodeResponse/result/geometry/location/lat");
            XPathExpression exprLng = xpath.compile("/GeocodeResponse/result/geometry/location/lng");
            lat = Double.parseDouble(exprLat.evaluate(doc, XPathConstants.STRING).toString());
            lng = Double.parseDouble(exprLng.evaluate(doc, XPathConstants.STRING).toString());            
        }
        catch(Exception e)
        {
            System.out.println("getcoordinates " + e);
        }
        Coordinates c = new Coordinates();
        c.setLat((double) lat);
        c.setLng((double) lng);
        return c;
    }
}
