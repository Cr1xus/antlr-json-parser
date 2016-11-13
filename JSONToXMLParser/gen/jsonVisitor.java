// Generated from /Users/Cr1xus/IdeaProjects/JSONToXMLParser/src/json.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link jsonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface jsonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link jsonParser#json}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson(jsonParser.JsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(jsonParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(jsonParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(jsonParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(jsonParser.ValueContext ctx);
}