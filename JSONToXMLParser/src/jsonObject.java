import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Cr1xus on 11/11/16.
 */
public class jsonObject {
    public jsonObject parentObject;
    public String key;
    public ArrayList<jsonKeyValue> keyValues =  new ArrayList<>();
    public ArrayList<jsonObject> children;
}
