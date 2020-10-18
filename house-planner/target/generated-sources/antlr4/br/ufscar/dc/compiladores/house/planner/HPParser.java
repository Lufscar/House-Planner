// Generated from br\u005Cufscar\dc\compiladores\house\planner\HP.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.house.planner;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, CONSTRUCTION=11, IS=12, DECLARE=13, AS=14, DEFINE=15, SET=16, 
		SEMICOLON=17, UNDERSCORE=18, OPENPAR=19, CLOSEPAR=20, IDENTIFIER=21, USERTYPE=22, 
		BLOCKNAME=23, NUMBER=24, STRING=25, COMMENT=26, WHITESPACE=27, ERRO_CAD=28, 
		ERRO_SIMB=29;
	public static final int
		RULE_map = 0, RULE_declaration = 1, RULE_type = 2, RULE_basicType = 3, 
		RULE_newType = 4, RULE_build = 5, RULE_cmdImportArea = 6, RULE_cmdAddRoom = 7, 
		RULE_cmdSubRoom = 8, RULE_cmdCreateAlert = 9, RULE_cmdBuildHouse = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"map", "declaration", "type", "basicType", "newType", "build", "cmdImportArea", 
			"cmdAddRoom", "cmdSubRoom", "cmdCreateAlert", "cmdBuildHouse"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Bedroom'", "'LivingRoom'", "'Bathroom'", "'Kitchen'", "'importArea'", 
			"'addRoom'", "','", "'subRoom'", "'createAlert'", "'buildHouse'", "'construction'", 
			"'is'", "'declare'", "'as'", "'define'", "'set'", "';'", "'_'", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "CONSTRUCTION", 
			"IS", "DECLARE", "AS", "DEFINE", "SET", "SEMICOLON", "UNDERSCORE", "OPENPAR", 
			"CLOSEPAR", "IDENTIFIER", "USERTYPE", "BLOCKNAME", "NUMBER", "STRING", 
			"COMMENT", "WHITESPACE", "ERRO_CAD", "ERRO_SIMB"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MapContext extends ParserRuleContext {
		public TerminalNode CONSTRUCTION() { return getToken(HPParser.CONSTRUCTION, 0); }
		public TerminalNode BLOCKNAME() { return getToken(HPParser.BLOCKNAME, 0); }
		public TerminalNode IS() { return getToken(HPParser.IS, 0); }
		public TerminalNode EOF() { return getToken(HPParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<BuildContext> build() {
			return getRuleContexts(BuildContext.class);
		}
		public BuildContext build(int i) {
			return getRuleContext(BuildContext.class,i);
		}
		public MapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitMap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitMap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_map);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(CONSTRUCTION);
			setState(23);
			match(BLOCKNAME);
			setState(24);
			match(IS);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECLARE) | (1L << DEFINE) | (1L << SET))) != 0)) {
				{
				{
				setState(25);
				declaration();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
				{
				{
				setState(31);
				build();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(HPParser.DECLARE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HPParser.IDENTIFIER, 0); }
		public TerminalNode AS() { return getToken(HPParser.AS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(HPParser.SEMICOLON, 0); }
		public TerminalNode DEFINE() { return getToken(HPParser.DEFINE, 0); }
		public TerminalNode NUMBER() { return getToken(HPParser.NUMBER, 0); }
		public TerminalNode SET() { return getToken(HPParser.SET, 0); }
		public TerminalNode USERTYPE() { return getToken(HPParser.USERTYPE, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(DECLARE);
				setState(40);
				match(IDENTIFIER);
				setState(41);
				match(AS);
				setState(42);
				type();
				setState(43);
				match(SEMICOLON);
				}
				break;
			case DEFINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(DEFINE);
				setState(46);
				match(IDENTIFIER);
				setState(47);
				match(AS);
				setState(48);
				match(NUMBER);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				match(SET);
				setState(50);
				match(USERTYPE);
				setState(51);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public NewTypeContext newType() {
			return getRuleContext(NewTypeContext.class,0);
		}
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case USERTYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				newType();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				basicType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicTypeContext extends ParserRuleContext {
		public BasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterBasicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitBasicType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitBasicType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_basicType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewTypeContext extends ParserRuleContext {
		public TerminalNode USERTYPE() { return getToken(HPParser.USERTYPE, 0); }
		public NewTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterNewType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitNewType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitNewType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewTypeContext newType() throws RecognitionException {
		NewTypeContext _localctx = new NewTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_newType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(USERTYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuildContext extends ParserRuleContext {
		public CmdImportAreaContext cmdImportArea() {
			return getRuleContext(CmdImportAreaContext.class,0);
		}
		public CmdAddRoomContext cmdAddRoom() {
			return getRuleContext(CmdAddRoomContext.class,0);
		}
		public CmdSubRoomContext cmdSubRoom() {
			return getRuleContext(CmdSubRoomContext.class,0);
		}
		public CmdCreateAlertContext cmdCreateAlert() {
			return getRuleContext(CmdCreateAlertContext.class,0);
		}
		public CmdBuildHouseContext cmdBuildHouse() {
			return getRuleContext(CmdBuildHouseContext.class,0);
		}
		public BuildContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_build; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterBuild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitBuild(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitBuild(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuildContext build() throws RecognitionException {
		BuildContext _localctx = new BuildContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_build);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				cmdImportArea();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				cmdAddRoom();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				cmdSubRoom();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				cmdCreateAlert();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				cmdBuildHouse();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdImportAreaContext extends ParserRuleContext {
		public TerminalNode OPENPAR() { return getToken(HPParser.OPENPAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HPParser.IDENTIFIER, 0); }
		public TerminalNode CLOSEPAR() { return getToken(HPParser.CLOSEPAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(HPParser.SEMICOLON, 0); }
		public CmdImportAreaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdImportArea; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterCmdImportArea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitCmdImportArea(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitCmdImportArea(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdImportAreaContext cmdImportArea() throws RecognitionException {
		CmdImportAreaContext _localctx = new CmdImportAreaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdImportArea);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__4);
			setState(70);
			match(OPENPAR);
			setState(71);
			match(IDENTIFIER);
			setState(72);
			match(CLOSEPAR);
			setState(73);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdAddRoomContext extends ParserRuleContext {
		public TerminalNode OPENPAR() { return getToken(HPParser.OPENPAR, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(HPParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HPParser.IDENTIFIER, i);
		}
		public TerminalNode CLOSEPAR() { return getToken(HPParser.CLOSEPAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(HPParser.SEMICOLON, 0); }
		public CmdAddRoomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAddRoom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterCmdAddRoom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitCmdAddRoom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitCmdAddRoom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdAddRoomContext cmdAddRoom() throws RecognitionException {
		CmdAddRoomContext _localctx = new CmdAddRoomContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdAddRoom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__5);
			setState(76);
			match(OPENPAR);
			setState(77);
			match(IDENTIFIER);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(78);
				match(T__6);
				setState(79);
				match(IDENTIFIER);
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(CLOSEPAR);
			setState(86);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdSubRoomContext extends ParserRuleContext {
		public TerminalNode OPENPAR() { return getToken(HPParser.OPENPAR, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(HPParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HPParser.IDENTIFIER, i);
		}
		public TerminalNode CLOSEPAR() { return getToken(HPParser.CLOSEPAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(HPParser.SEMICOLON, 0); }
		public CmdSubRoomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdSubRoom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterCmdSubRoom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitCmdSubRoom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitCmdSubRoom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdSubRoomContext cmdSubRoom() throws RecognitionException {
		CmdSubRoomContext _localctx = new CmdSubRoomContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdSubRoom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__7);
			setState(89);
			match(OPENPAR);
			setState(90);
			match(IDENTIFIER);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(91);
				match(T__6);
				setState(92);
				match(IDENTIFIER);
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			match(CLOSEPAR);
			setState(99);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdCreateAlertContext extends ParserRuleContext {
		public TerminalNode OPENPAR() { return getToken(HPParser.OPENPAR, 0); }
		public TerminalNode CLOSEPAR() { return getToken(HPParser.CLOSEPAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(HPParser.SEMICOLON, 0); }
		public List<TerminalNode> STRING() { return getTokens(HPParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(HPParser.STRING, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(HPParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HPParser.IDENTIFIER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(HPParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(HPParser.NUMBER, i);
		}
		public CmdCreateAlertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdCreateAlert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterCmdCreateAlert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitCmdCreateAlert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitCmdCreateAlert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdCreateAlertContext cmdCreateAlert() throws RecognitionException {
		CmdCreateAlertContext _localctx = new CmdCreateAlertContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdCreateAlert);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__8);
			setState(102);
			match(OPENPAR);
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0) );
			setState(108);
			match(CLOSEPAR);
			setState(109);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdBuildHouseContext extends ParserRuleContext {
		public TerminalNode OPENPAR() { return getToken(HPParser.OPENPAR, 0); }
		public TerminalNode CLOSEPAR() { return getToken(HPParser.CLOSEPAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(HPParser.SEMICOLON, 0); }
		public CmdBuildHouseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdBuildHouse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterCmdBuildHouse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitCmdBuildHouse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitCmdBuildHouse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdBuildHouseContext cmdBuildHouse() throws RecognitionException {
		CmdBuildHouseContext _localctx = new CmdBuildHouseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdBuildHouse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__9);
			setState(112);
			match(OPENPAR);
			setState(113);
			match(CLOSEPAR);
			setState(114);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37w\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\2\7\2#\n\2\f\2\16\2"+
		"&\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"\67\n\3\3\4\3\4\5\4;\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7F\n\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\tS\n\t\f\t\16\tV\13\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n`\n\n\f\n\16\nc\13\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\6\13k\n\13\r\13\16\13l\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\4\3\2\3\6\4\2\27\27\32\33\2w\2\30"+
		"\3\2\2\2\4\66\3\2\2\2\6:\3\2\2\2\b<\3\2\2\2\n>\3\2\2\2\fE\3\2\2\2\16G"+
		"\3\2\2\2\20M\3\2\2\2\22Z\3\2\2\2\24g\3\2\2\2\26q\3\2\2\2\30\31\7\r\2\2"+
		"\31\32\7\31\2\2\32\36\7\16\2\2\33\35\5\4\3\2\34\33\3\2\2\2\35 \3\2\2\2"+
		"\36\34\3\2\2\2\36\37\3\2\2\2\37$\3\2\2\2 \36\3\2\2\2!#\5\f\7\2\"!\3\2"+
		"\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\7\2\2\3(\3"+
		"\3\2\2\2)*\7\17\2\2*+\7\27\2\2+,\7\20\2\2,-\5\6\4\2-.\7\23\2\2.\67\3\2"+
		"\2\2/\60\7\21\2\2\60\61\7\27\2\2\61\62\7\20\2\2\62\67\7\32\2\2\63\64\7"+
		"\22\2\2\64\65\7\30\2\2\65\67\7\23\2\2\66)\3\2\2\2\66/\3\2\2\2\66\63\3"+
		"\2\2\2\67\5\3\2\2\28;\5\n\6\29;\5\b\5\2:8\3\2\2\2:9\3\2\2\2;\7\3\2\2\2"+
		"<=\t\2\2\2=\t\3\2\2\2>?\7\30\2\2?\13\3\2\2\2@F\5\16\b\2AF\5\20\t\2BF\5"+
		"\22\n\2CF\5\24\13\2DF\5\26\f\2E@\3\2\2\2EA\3\2\2\2EB\3\2\2\2EC\3\2\2\2"+
		"ED\3\2\2\2F\r\3\2\2\2GH\7\7\2\2HI\7\25\2\2IJ\7\27\2\2JK\7\26\2\2KL\7\23"+
		"\2\2L\17\3\2\2\2MN\7\b\2\2NO\7\25\2\2OT\7\27\2\2PQ\7\t\2\2QS\7\27\2\2"+
		"RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\26\2"+
		"\2XY\7\23\2\2Y\21\3\2\2\2Z[\7\n\2\2[\\\7\25\2\2\\a\7\27\2\2]^\7\t\2\2"+
		"^`\7\27\2\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2"+
		"\2de\7\26\2\2ef\7\23\2\2f\23\3\2\2\2gh\7\13\2\2hj\7\25\2\2ik\t\3\2\2j"+
		"i\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7\26\2\2op\7\23\2"+
		"\2p\25\3\2\2\2qr\7\f\2\2rs\7\25\2\2st\7\26\2\2tu\7\23\2\2u\27\3\2\2\2"+
		"\n\36$\66:ETal";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}