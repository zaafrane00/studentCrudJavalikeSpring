import nu.xom.*;

import java.io.File;
import java.io.IOException;

public class DataBaseConfig {
    public File file;
    public Document doc;

    public DataBaseConfig() {
        try {
            file = new File("src/Config.xml");
            System.out.println(file);
            // builder builds xml data
            Builder builder = new Builder();
            doc = builder.build(file);
        } catch (ParsingException e) {
            System.err.println("ParsingException");
        } catch (IOException e) {
            System.err.println("IOException");
        }
    }

    DataBaseParams getParams(int pos) {
        // get the root element <databases>
        Element root = (Element) doc.getRootElement();
        // gets all element with tag <database>
        Elements database = root.getChildElements("database");
        // get the current database element
        Element db = (Element) database.get(pos);
        // get the name element and its children: first and last
        Element driver = db.getFirstChildElement("driver");
        Element connection = db.getFirstChildElement("connection");
        Element url = connection.getFirstChildElement("url");
        Element session = connection.getFirstChildElement("session");
        Element password = connection.getFirstChildElement("password");
/*        System.out.println(driver);
        System.out.println(connection);
        System.out.println(url);
        System.out.println(session);
        System.out.println(password);*/
        String driverT, urlT, sessionT, passwordT;
        try {
            driverT = driver.getValue();
            urlT = url.getValue();
            sessionT = session.getValue();
            passwordT = password.getValue();
            DataBaseParams params = new DataBaseParams(driverT, urlT, sessionT, passwordT);
          /*  System.out.println(driverT);
            System.out.println(urlT);
            System.out.println(sessionT);
            System.out.println(passwordT);*/
            return params;
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

/*    public static void main(String ...args){
        DataBaseConfig xx=new DataBaseConfig();
       xx.getParams(0);

    }*/

}
