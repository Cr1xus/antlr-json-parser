/**
 * Created by Cr1xus on 11/11/16.
 */
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.antlr.v4.gui.SystemFontMetrics;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static final String INPUT_JSON = "input.json";
    public static void main(String[] args) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(INPUT_JSON);
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found.");
            return;
        }

        jsonLexer lexer;
        try {
            lexer = new jsonLexer(new ANTLRInputStream(fileInputStream));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        jsonParser parser = new jsonParser(tokens);
        //ParserRuleContext ruleContext = parser.json();
        //Trees.inspect(ruleContext, parser);

        ParseTree tree = parser.json();
        ParseTreeWalker walker = new ParseTreeWalker();
        jsonLoader loader = new jsonLoader();
        walker.walk(loader, tree);
        jsonObject obj = loader.getRootObject();
        String str = XMLGen.transformJSONToXml(obj);
        System.out.println(str);
    }
}
