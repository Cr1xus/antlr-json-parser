import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Cr1xus on 11/11/16.
 */
public class jsonLoader extends jsonBaseListener {

    private ArrayList<jsonObject> objects;
    private ArrayList<jsonObject> children;

    private jsonObject rootObject = new jsonObject();
    private jsonObject currentObj;
    private int enterObjectCounter = 0;
    private boolean isArrayEntered = false;
    private int enterArrayCounter = 0;

    public jsonObject getRootObject(){
        return rootObject;
    }

    private jsonObject retrieveObjectWithLevel(int level){
        if(level == 0)
            return rootObject;

        jsonObject objToRetrieve = rootObject;
        for(int i = 0;i <= level;i++){
            if(objToRetrieve.children != null){
                objToRetrieve = objToRetrieve.children.get(objToRetrieve.children.size() - 1);
            }
        }
        return objToRetrieve;
    }

    @Override
    public void enterObject(jsonParser.ObjectContext ctx) {
        super.enterObject(ctx);
        jsonObject newObj = new jsonObject();

        if(enterObjectCounter == 0){
            if(rootObject.children == null)
                rootObject.children =  new ArrayList<>();

            newObj.parentObject = rootObject;
            rootObject.children.add(newObj);
            currentObj = newObj;
        }else{
            currentObj = this.retrieveObjectWithLevel(enterObjectCounter);
        }
        enterObjectCounter++;
    }

    @Override
    public void exitObject(jsonParser.ObjectContext ctx) {
        super.exitObject(ctx);

        if(isArrayEntered){
            jsonObject tmpObj = new jsonObject();
            tmpObj.parentObject = currentObj.parentObject;
            currentObj.parentObject.children.add(tmpObj);
        }
        enterObjectCounter--;
    }

    @Override
    public void enterPair(jsonParser.PairContext ctx) {
        super.enterPair(ctx);
        String k = ctx.STRING().getText();
        k = k.substring(1,k.length()-1);
        if(ctx.value().array() != null){
            jsonObject tmpObj = new jsonObject();
            tmpObj.parentObject = currentObj;
            currentObj.children = new ArrayList<>();
            currentObj.children.add(tmpObj);
            currentObj.key = k;
        }
        jsonKeyValue kvPair =  null;
        if(ctx.value().NUMBER() != null){
            kvPair =  new jsonKeyValue(k, ctx.value().NUMBER().getText(), Number.class);
        }else if(ctx.value().STRING() != null){
            String v = ctx.value().STRING().getText();
            v = v.substring(1,v.length()-1);
            kvPair =  new jsonKeyValue(k, v, String.class);
        }
        if(kvPair != null)
            currentObj.keyValues.add(kvPair);
    }

    @Override
    public void enterArray(jsonParser.ArrayContext ctx) {
        super.enterArray(ctx);
        isArrayEntered = true;
        enterArrayCounter++;
    }


    @Override
    public void exitArray(jsonParser.ArrayContext ctx) {
        super.exitArray(ctx);
        enterArrayCounter--;
        enterObjectCounter--;
        currentObj = this.retrieveObjectWithLevel(enterObjectCounter);
        if(enterArrayCounter == 0){
            isArrayEntered = false;
        }else{
            enterObjectCounter++;
        }
    }
}
