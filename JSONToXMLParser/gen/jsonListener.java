// Generated from /Users/Cr1xus/IdeaProjects/JSONToXMLParser/src/json.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link jsonParser}.
 */
public interface jsonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link jsonParser#json}.
	 * @param ctx the parse tree
	 */
	void enterJson(jsonParser.JsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link jsonParser#json}.
	 * @param ctx the parse tree
	 */
	void exitJson(jsonParser.JsonContext ctx);
	/**
	 * Enter a parse tree produced by {@link jsonParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(jsonParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link jsonParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(jsonParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link jsonParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(jsonParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link jsonParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(jsonParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link jsonParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(jsonParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link jsonParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(jsonParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link jsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(jsonParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link jsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(jsonParser.ValueContext ctx);
}