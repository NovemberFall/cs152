// Generated from /Users/Git/cs152/proj_part2/FeatherweightJavaScript.g4 by ANTLR 4.8
 package edu.sjsu.fwjs.parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FeatherweightJavaScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, IF=6, ELSE=7, WHILE=8, FUNCTION=9, 
		VAR=10, PRINT=11, INT=12, BOOL=13, NULL=14, MUL=15, DIV=16, ADD=17, SUB=18, 
		MOD=19, GREATER_THAN=20, LESS_THAN=21, GREATER_THAN_EQUAL_TO=22, LESS_THAN_EQUAL_TO=23, 
		EQUAL_TO=24, SEPARATOR=25, IDENTIFIER=26, NEWLINE=27, WS=28, LINE_COMMENT=29, 
		BLOCK_COMMENT=30, ASGN=31;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_expr = 2, RULE_block = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "expr", "block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'{'", "'}'", "'if'", "'else'", "'while'", 
			"'function'", "'var'", "'print'", null, null, "'null'", "'*'", "'/'", 
			"'+'", "'-'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "ELSE", "WHILE", "FUNCTION", 
			"VAR", "PRINT", "INT", "BOOL", "NULL", "MUL", "DIV", "ADD", "SUB", "MOD", 
			"GREATER_THAN", "LESS_THAN", "GREATER_THAN_EQUAL_TO", "LESS_THAN_EQUAL_TO", 
			"EQUAL_TO", "SEPARATOR", "IDENTIFIER", "NEWLINE", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT", "ASGN"
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
	public String getGrammarFileName() { return "FeatherweightJavaScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FeatherweightJavaScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8);
				stat();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << VAR) | (1L << PRINT) | (1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << IDENTIFIER))) != 0) );
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintContext extends StatContext {
		public TerminalNode PRINT() { return getToken(FeatherweightJavaScriptParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(FeatherweightJavaScriptParser.SEPARATOR, 0); }
		public PrintContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenElseContext extends StatContext {
		public TerminalNode IF() { return getToken(FeatherweightJavaScriptParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(FeatherweightJavaScriptParser.ELSE, 0); }
		public IfThenElseContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterIfThenElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitIfThenElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitIfThenElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenContext extends StatContext {
		public TerminalNode IF() { return getToken(FeatherweightJavaScriptParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfThenContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterIfThen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitIfThen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitIfThen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends StatContext {
		public TerminalNode WHILE() { return getToken(FeatherweightJavaScriptParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BareExprContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(FeatherweightJavaScriptParser.SEPARATOR, 0); }
		public BareExprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterBareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitBareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitBareExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new BareExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				expr(0);
				setState(14);
				match(SEPARATOR);
				}
				break;
			case 2:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				match(IF);
				setState(17);
				match(T__0);
				setState(18);
				expr(0);
				setState(19);
				match(T__1);
				setState(20);
				block();
				setState(21);
				match(ELSE);
				setState(22);
				block();
				}
				break;
			case 3:
				_localctx = new IfThenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				match(IF);
				setState(25);
				match(T__0);
				setState(26);
				expr(0);
				setState(27);
				match(T__1);
				setState(28);
				block();
				}
				break;
			case 4:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(30);
				match(WHILE);
				setState(31);
				match(T__0);
				setState(32);
				expr(0);
				setState(33);
				match(T__1);
				setState(34);
				block();
				}
				break;
			case 5:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				match(PRINT);
				setState(37);
				match(T__0);
				setState(38);
				expr(0);
				setState(39);
				match(T__1);
				setState(40);
				match(SEPARATOR);
				}
				break;
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(FeatherweightJavaScriptParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(FeatherweightJavaScriptParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(FeatherweightJavaScriptParser.MOD, 0); }
		public MulDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitMulDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarAsgnContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(FeatherweightJavaScriptParser.IDENTIFIER, 0); }
		public TerminalNode ASGN() { return getToken(FeatherweightJavaScriptParser.ASGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarAsgnContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterVarAsgn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitVarAsgn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitVarAsgn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GREATER_THAN() { return getToken(FeatherweightJavaScriptParser.GREATER_THAN, 0); }
		public TerminalNode LESS_THAN() { return getToken(FeatherweightJavaScriptParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN_EQUAL_TO() { return getToken(FeatherweightJavaScriptParser.GREATER_THAN_EQUAL_TO, 0); }
		public TerminalNode LESS_THAN_EQUAL_TO() { return getToken(FeatherweightJavaScriptParser.LESS_THAN_EQUAL_TO, 0); }
		public TerminalNode EQUAL_TO() { return getToken(FeatherweightJavaScriptParser.EQUAL_TO, 0); }
		public ComparisonContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(FeatherweightJavaScriptParser.BOOL, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullContext extends ExprContext {
		public TerminalNode NULL() { return getToken(FeatherweightJavaScriptParser.NULL, 0); }
		public NullContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclContext extends ExprContext {
		public TerminalNode VAR() { return getToken(FeatherweightJavaScriptParser.VAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FeatherweightJavaScriptParser.IDENTIFIER, 0); }
		public TerminalNode ASGN() { return getToken(FeatherweightJavaScriptParser.ASGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(FeatherweightJavaScriptParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(FeatherweightJavaScriptParser.SUB, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarAppContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(FeatherweightJavaScriptParser.IDENTIFIER, 0); }
		public VarAppContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterVarApp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitVarApp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitVarApp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FucAppContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(FeatherweightJavaScriptParser.IDENTIFIER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FucAppContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterFucApp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitFucApp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitFucApp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncDeclContext extends ExprContext {
		public TerminalNode FUNCTION() { return getToken(FeatherweightJavaScriptParser.FUNCTION, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncDeclContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitFuncDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(FeatherweightJavaScriptParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(45);
				match(T__0);
				setState(46);
				expr(0);
				setState(47);
				match(T__1);
				}
				break;
			case 2:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				match(INT);
				}
				break;
			case 3:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				match(BOOL);
				}
				break;
			case 4:
				{
				_localctx = new NullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				match(NULL);
				}
				break;
			case 5:
				{
				_localctx = new VarDeclContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(VAR);
				setState(53);
				match(IDENTIFIER);
				setState(54);
				match(ASGN);
				setState(55);
				expr(5);
				}
				break;
			case 6:
				{
				_localctx = new VarAsgnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(IDENTIFIER);
				setState(57);
				match(ASGN);
				setState(58);
				expr(4);
				}
				break;
			case 7:
				{
				_localctx = new VarAppContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				match(IDENTIFIER);
				}
				break;
			case 8:
				{
				_localctx = new FuncDeclContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				match(FUNCTION);
				setState(61);
				match(T__0);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << FUNCTION) | (1L << VAR) | (1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(62);
					expr(0);
					}
				}

				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(65);
					match(T__2);
					setState(66);
					expr(0);
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				match(T__1);
				setState(73);
				block();
				}
				break;
			case 9:
				{
				_localctx = new FucAppContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				match(IDENTIFIER);
				setState(75);
				match(T__0);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << FUNCTION) | (1L << VAR) | (1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(76);
					expr(0);
					}
				}

				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(79);
					match(T__2);
					setState(80);
					expr(0);
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(98);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(90);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(93);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(96);
						((ComparisonContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_THAN) | (1L << LESS_THAN) | (1L << GREATER_THAN_EQUAL_TO) | (1L << LESS_THAN_EQUAL_TO) | (1L << EQUAL_TO))) != 0)) ) {
							((ComparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(97);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FullBlockContext extends BlockContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public FullBlockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterFullBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitFullBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitFullBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpBlockContext extends BlockContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public SimpBlockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).enterSimpBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherweightJavaScriptListener ) ((FeatherweightJavaScriptListener)listener).exitSimpBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FeatherweightJavaScriptVisitor ) return ((FeatherweightJavaScriptVisitor<? extends T>)visitor).visitSimpBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new FullBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(T__3);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << VAR) | (1L << PRINT) | (1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(104);
					stat();
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
				match(T__4);
				}
				break;
			case T__0:
			case IF:
			case WHILE:
			case FUNCTION:
			case VAR:
			case PRINT:
			case INT:
			case BOOL:
			case NULL:
			case IDENTIFIER:
				_localctx = new SimpBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				stat();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!u\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\3\2\6\2\f\n\2\r\2\16\2\r\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3-\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\4\3\4\7\4F\n\4\f\4\16\4"+
		"I\13\4\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\4\3\4\7\4T\n\4\f\4\16\4W\13\4\3"+
		"\4\5\4Z\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4e\n\4\f\4\16\4h\13"+
		"\4\3\5\3\5\7\5l\n\5\f\5\16\5o\13\5\3\5\3\5\5\5s\n\5\3\5\2\3\6\6\2\4\6"+
		"\b\2\5\4\2\21\22\25\25\3\2\23\24\3\2\26\32\2\u0086\2\13\3\2\2\2\4,\3\2"+
		"\2\2\6Y\3\2\2\2\br\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f\r\3\2\2\2\r\13\3"+
		"\2\2\2\r\16\3\2\2\2\16\3\3\2\2\2\17\20\5\6\4\2\20\21\7\33\2\2\21-\3\2"+
		"\2\2\22\23\7\b\2\2\23\24\7\3\2\2\24\25\5\6\4\2\25\26\7\4\2\2\26\27\5\b"+
		"\5\2\27\30\7\t\2\2\30\31\5\b\5\2\31-\3\2\2\2\32\33\7\b\2\2\33\34\7\3\2"+
		"\2\34\35\5\6\4\2\35\36\7\4\2\2\36\37\5\b\5\2\37-\3\2\2\2 !\7\n\2\2!\""+
		"\7\3\2\2\"#\5\6\4\2#$\7\4\2\2$%\5\b\5\2%-\3\2\2\2&\'\7\r\2\2\'(\7\3\2"+
		"\2()\5\6\4\2)*\7\4\2\2*+\7\33\2\2+-\3\2\2\2,\17\3\2\2\2,\22\3\2\2\2,\32"+
		"\3\2\2\2, \3\2\2\2,&\3\2\2\2-\5\3\2\2\2./\b\4\1\2/\60\7\3\2\2\60\61\5"+
		"\6\4\2\61\62\7\4\2\2\62Z\3\2\2\2\63Z\7\16\2\2\64Z\7\17\2\2\65Z\7\20\2"+
		"\2\66\67\7\f\2\2\678\7\34\2\289\7!\2\29Z\5\6\4\7:;\7\34\2\2;<\7!\2\2<"+
		"Z\5\6\4\6=Z\7\34\2\2>?\7\13\2\2?A\7\3\2\2@B\5\6\4\2A@\3\2\2\2AB\3\2\2"+
		"\2BG\3\2\2\2CD\7\5\2\2DF\5\6\4\2EC\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2"+
		"\2HJ\3\2\2\2IG\3\2\2\2JK\7\4\2\2KZ\5\b\5\2LM\7\34\2\2MO\7\3\2\2NP\5\6"+
		"\4\2ON\3\2\2\2OP\3\2\2\2PU\3\2\2\2QR\7\5\2\2RT\5\6\4\2SQ\3\2\2\2TW\3\2"+
		"\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XZ\7\4\2\2Y.\3\2\2\2Y\63\3"+
		"\2\2\2Y\64\3\2\2\2Y\65\3\2\2\2Y\66\3\2\2\2Y:\3\2\2\2Y=\3\2\2\2Y>\3\2\2"+
		"\2YL\3\2\2\2Zf\3\2\2\2[\\\f\16\2\2\\]\t\2\2\2]e\5\6\4\17^_\f\r\2\2_`\t"+
		"\3\2\2`e\5\6\4\16ab\f\f\2\2bc\t\4\2\2ce\5\6\4\rd[\3\2\2\2d^\3\2\2\2da"+
		"\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\7\3\2\2\2hf\3\2\2\2im\7\6\2\2"+
		"jl\5\4\3\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2"+
		"ps\7\7\2\2qs\5\4\3\2ri\3\2\2\2rq\3\2\2\2s\t\3\2\2\2\r\r,AGOUYdfmr";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}