import java.lang.reflect.Type;

/**
 * Created by Cr1xus on 11/13/16.
 */
public class jsonKeyValue {

    public String key;
    public String value;
    public Type type;

    public jsonKeyValue(String key, String value, Type type){
        this.key = key;
        this.value = value;
        this.type = type;
    }
}
