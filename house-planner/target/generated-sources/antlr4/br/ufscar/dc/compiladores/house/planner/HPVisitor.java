// Generated from br\u005Cufscar\dc\compiladores\house\planner\HP.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.house.planner;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HPVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HPParser#map}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap(HPParser.MapContext ctx);
	/**
	 * Visit a parse tree produced by {@link HPParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(HPParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HPParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(HPParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HPParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicType(HPParser.BasicTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HPParser#newType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewType(HPParser.NewTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HPParser#build}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuild(HPParser.BuildContext ctx);
	/**
	 * Visit a parse tree produced by {@link HPParser#cmdImportArea}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdImportArea(HPParser.CmdImportAreaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HPParser#cmdAddRoom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAddRoom(HPParser.CmdAddRoomContext ctx);
	/**
	 * Visit a parse tree produced by {@link HPParser#cmdSubRoom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSubRoom(HPParser.CmdSubRoomContext ctx);
	/**
	 * Visit a parse tree produced by {@link HPParser#cmdCreateAlert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdCreateAlert(HPParser.CmdCreateAlertContext ctx);
	/**
	 * Visit a parse tree produced by {@link HPParser#cmdBuildHouse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdBuildHouse(HPParser.CmdBuildHouseContext ctx);
}