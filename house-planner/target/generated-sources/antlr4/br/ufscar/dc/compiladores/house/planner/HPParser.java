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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, IDENTIFIER=19, USERTYPE=20, NUMBER=21, STRING=22, COMMENT=23, 
		WHITESPACE=24;
	public static final int
		RULE_map = 0, RULE_declaration = 1, RULE_type = 2, RULE_basicType = 3, 
		RULE_newType = 4, RULE_build = 5, RULE_cmdImport = 6, RULE_cmdAddRoom = 7, 
		RULE_cmdSubRoom = 8, RULE_cmdCreateAlert = 9, RULE_cmdBuildHouse = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"map", "declaration", "type", "basicType", "newType", "build", "cmdImport", 
			"cmdAddRoom", "cmdSubRoom", "cmdCreateAlert", "cmdBuildHouse"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'construction'", "'is'", "'declare'", "'as'", "';'", "'define'", 
			"'set'", "'Bedroom'", "'LivingRoom'", "'Bathroom'", "'Kitchen'", "'import('", 
			"')'", "'addRoom('", "','", "'subRoom('", "'createAlert('", "'buildHouse()'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "IDENTIFIER", "USERTYPE", "NUMBER", 
			"STRING", "COMMENT", "WHITESPACE"
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
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(HPParser.EOF, 0); }
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
			match(T__0);
			setState(23);
			match(T__1);
			setState(24);
			declaration();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) {
				{
				{
				setState(25);
				build();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
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
		public TerminalNode IDENTIFIER() { return getToken(HPParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(HPParser.NUMBER, 0); }
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
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(T__2);
				setState(34);
				match(IDENTIFIER);
				setState(35);
				match(T__3);
				setState(36);
				type();
				setState(37);
				match(T__4);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(T__5);
				setState(40);
				match(IDENTIFIER);
				setState(41);
				match(T__3);
				setState(42);
				match(NUMBER);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				match(T__6);
				setState(44);
				match(USERTYPE);
				setState(45);
				match(T__4);
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
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case USERTYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				newType();
				}
				break;
			case T__7:
			case T__8:
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
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
			setState(52);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
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
			setState(54);
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
		public CmdImportContext cmdImport() {
			return getRuleContext(CmdImportContext.class,0);
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
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				cmdImport();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				cmdAddRoom();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				cmdSubRoom();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 4);
				{
				setState(59);
				cmdCreateAlert();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
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

	public static class CmdImportContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HPParser.IDENTIFIER, 0); }
		public CmdImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).enterCmdImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HPListener ) ((HPListener)listener).exitCmdImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HPVisitor ) return ((HPVisitor<? extends T>)visitor).visitCmdImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdImportContext cmdImport() throws RecognitionException {
		CmdImportContext _localctx = new CmdImportContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdImport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__11);
			setState(64);
			match(IDENTIFIER);
			setState(65);
			match(T__12);
			setState(66);
			match(T__4);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(HPParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HPParser.IDENTIFIER, i);
		}
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
			setState(68);
			match(T__13);
			setState(69);
			match(IDENTIFIER);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(70);
				match(T__14);
				setState(71);
				match(IDENTIFIER);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(T__12);
			setState(78);
			match(T__4);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(HPParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HPParser.IDENTIFIER, i);
		}
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
			setState(80);
			match(T__15);
			setState(81);
			match(IDENTIFIER);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(82);
				match(T__14);
				setState(83);
				match(IDENTIFIER);
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(T__12);
			setState(90);
			match(T__4);
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
			setState(92);
			match(T__16);
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
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
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0) );
			setState(98);
			match(T__12);
			setState(99);
			match(T__4);
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
			setState(101);
			match(T__17);
			setState(102);
			match(T__4);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32k\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3\4\5\4\65\n\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7@\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\7\tK\n\t\f\t\16\tN\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\nW\n"+
		"\n\f\n\16\nZ\13\n\3\n\3\n\3\n\3\13\3\13\6\13a\n\13\r\13\16\13b\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\4\3\2\n\r"+
		"\4\2\25\25\27\30\2j\2\30\3\2\2\2\4\60\3\2\2\2\6\64\3\2\2\2\b\66\3\2\2"+
		"\2\n8\3\2\2\2\f?\3\2\2\2\16A\3\2\2\2\20F\3\2\2\2\22R\3\2\2\2\24^\3\2\2"+
		"\2\26g\3\2\2\2\30\31\7\3\2\2\31\32\7\4\2\2\32\36\5\4\3\2\33\35\5\f\7\2"+
		"\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \36"+
		"\3\2\2\2!\"\7\2\2\3\"\3\3\2\2\2#$\7\5\2\2$%\7\25\2\2%&\7\6\2\2&\'\5\6"+
		"\4\2\'(\7\7\2\2(\61\3\2\2\2)*\7\b\2\2*+\7\25\2\2+,\7\6\2\2,\61\7\27\2"+
		"\2-.\7\t\2\2./\7\26\2\2/\61\7\7\2\2\60#\3\2\2\2\60)\3\2\2\2\60-\3\2\2"+
		"\2\61\5\3\2\2\2\62\65\5\n\6\2\63\65\5\b\5\2\64\62\3\2\2\2\64\63\3\2\2"+
		"\2\65\7\3\2\2\2\66\67\t\2\2\2\67\t\3\2\2\289\7\26\2\29\13\3\2\2\2:@\5"+
		"\16\b\2;@\5\20\t\2<@\5\22\n\2=@\5\24\13\2>@\5\26\f\2?:\3\2\2\2?;\3\2\2"+
		"\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@\r\3\2\2\2AB\7\16\2\2BC\7\25\2\2CD\7"+
		"\17\2\2DE\7\7\2\2E\17\3\2\2\2FG\7\20\2\2GL\7\25\2\2HI\7\21\2\2IK\7\25"+
		"\2\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\17"+
		"\2\2PQ\7\7\2\2Q\21\3\2\2\2RS\7\22\2\2SX\7\25\2\2TU\7\21\2\2UW\7\25\2\2"+
		"VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\17\2"+
		"\2\\]\7\7\2\2]\23\3\2\2\2^`\7\23\2\2_a\t\3\2\2`_\3\2\2\2ab\3\2\2\2b`\3"+
		"\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\17\2\2ef\7\7\2\2f\25\3\2\2\2gh\7\24\2\2"+
		"hi\7\7\2\2i\27\3\2\2\2\t\36\60\64?LXb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}