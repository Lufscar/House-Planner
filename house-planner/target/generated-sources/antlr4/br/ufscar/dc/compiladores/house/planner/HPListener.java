// Generated from br\u005Cufscar\dc\compiladores\house\planner\HP.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.house.planner;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HPParser}.
 */
public interface HPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HPParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(HPParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(HPParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link HPParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(HPParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(HPParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HPParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(HPParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(HPParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HPParser#basicType}.
	 * @param ctx the parse tree
	 */
	void enterBasicType(HPParser.BasicTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#basicType}.
	 * @param ctx the parse tree
	 */
	void exitBasicType(HPParser.BasicTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HPParser#newType}.
	 * @param ctx the parse tree
	 */
	void enterNewType(HPParser.NewTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#newType}.
	 * @param ctx the parse tree
	 */
	void exitNewType(HPParser.NewTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HPParser#build}.
	 * @param ctx the parse tree
	 */
	void enterBuild(HPParser.BuildContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#build}.
	 * @param ctx the parse tree
	 */
	void exitBuild(HPParser.BuildContext ctx);
	/**
	 * Enter a parse tree produced by {@link HPParser#cmdMeasureArea}.
	 * @param ctx the parse tree
	 */
	void enterCmdMeasureArea(HPParser.CmdMeasureAreaContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#cmdMeasureArea}.
	 * @param ctx the parse tree
	 */
	void exitCmdMeasureArea(HPParser.CmdMeasureAreaContext ctx);
	/**
	 * Enter a parse tree produced by {@link HPParser#cmdAddRoom}.
	 * @param ctx the parse tree
	 */
	void enterCmdAddRoom(HPParser.CmdAddRoomContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#cmdAddRoom}.
	 * @param ctx the parse tree
	 */
	void exitCmdAddRoom(HPParser.CmdAddRoomContext ctx);
	/**
	 * Enter a parse tree produced by {@link HPParser#cmdSubRoom}.
	 * @param ctx the parse tree
	 */
	void enterCmdSubRoom(HPParser.CmdSubRoomContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#cmdSubRoom}.
	 * @param ctx the parse tree
	 */
	void exitCmdSubRoom(HPParser.CmdSubRoomContext ctx);
	/**
	 * Enter a parse tree produced by {@link HPParser#cmdCreateAlert}.
	 * @param ctx the parse tree
	 */
	void enterCmdCreateAlert(HPParser.CmdCreateAlertContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#cmdCreateAlert}.
	 * @param ctx the parse tree
	 */
	void exitCmdCreateAlert(HPParser.CmdCreateAlertContext ctx);
	/**
	 * Enter a parse tree produced by {@link HPParser#cmdBuildHouse}.
	 * @param ctx the parse tree
	 */
	void enterCmdBuildHouse(HPParser.CmdBuildHouseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HPParser#cmdBuildHouse}.
	 * @param ctx the parse tree
	 */
	void exitCmdBuildHouse(HPParser.CmdBuildHouseContext ctx);
}