package util.datareaders;
import util.constants.Constants;
public class ElementReader {

    public static String readElement( String elementName) {
        PropertiesReader.readProperties(Constants.MAIN_RESOURCES_DATA + "element.properties");
        return PropertiesReader.getPropertyValue(elementName);
    }
}
