/**
 * Created by Cr1xus on 11/13/16.
 */

import java.io.File;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class XMLGen {

    public static String transformJSONToXml(jsonObject json){
        String strRepr = null;
        if(json == null)
            return null;

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("root");

            for(jsonObject obj: json.children){
                if(obj.children != null){
                    for(jsonObject innerObj: obj.children){
                        if(innerObj != null && innerObj.keyValues != null){
                            Element el = doc.createElement(obj.key);
                            for(jsonKeyValue keyVal: innerObj.keyValues){
                                Element innerEl = doc.createElement(keyVal.key);
                                innerEl.appendChild(doc.createTextNode(keyVal.value));
                                innerEl.setAttribute("type", keyVal.type.toString());
                                el.appendChild(innerEl);
                            }
                            rootElement.appendChild(el);
                        }
                    }
                }

                if(obj.keyValues != null){
                    for(jsonKeyValue keyVal: obj.keyValues){
                        Element el = doc.createElement(keyVal.key);
                        el.appendChild(doc.createTextNode(keyVal.value));
                        el.setAttribute("type", keyVal.type.toString());
                        rootElement.appendChild(el);
                    }
                }
            }
            doc.appendChild(rootElement);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            strRepr = writer.getBuffer().toString().replaceAll("\n|\r", "");


        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return strRepr;
    }
}
