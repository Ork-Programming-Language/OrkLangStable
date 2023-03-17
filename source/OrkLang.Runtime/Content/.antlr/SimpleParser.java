// Generated from d:\OrkLangStable\OrkLangStable\source\OrkLang.Runtime\Content\Simple.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, WHILE=27, BOOL_OPERATOR=28, INTEGER=29, FLOAT=30, 
		STRING=31, BOOL=32, NULL=33, WS=34, IDENTIFIER=35, Comment=36;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_statement = 2, RULE_ifBlock = 3, 
		RULE_elseIfBlock = 4, RULE_whileBlock = 5, RULE_namespaceBlock = 6, RULE_constructorBlock = 7, 
		RULE_classBlock = 8, RULE_funcBlock = 9, RULE_assignment = 10, RULE_functionCall = 11, 
		RULE_expression = 12, RULE_memberAccess = 13, RULE_argumentList = 14, 
		RULE_multOp = 15, RULE_addOp = 16, RULE_compareOp = 17, RULE_boolOp = 18, 
		RULE_constant = 19, RULE_block = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "statement", "ifBlock", "elseIfBlock", "whileBlock", 
			"namespaceBlock", "constructorBlock", "classBlock", "funcBlock", "assignment", 
			"functionCall", "expression", "memberAccess", "argumentList", "multOp", 
			"addOp", "compareOp", "boolOp", "constant", "block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'if'", "'('", "')'", "'else'", "'namespace'", "'constructor'", 
			"'class'", "'func'", "','", "'='", "'!'", "'.'", "'*'", "'/'", "'%'", 
			"'+'", "'-'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'{'", "'}'", 
			null, null, null, null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "WHILE", "BOOL_OPERATOR", "INTEGER", "FLOAT", "STRING", 
			"BOOL", "NULL", "WS", "IDENTIFIER", "Comment"
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
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimpleParser.EOF, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__24) | (1L << WHILE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(42);
				line();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
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

	public static class LineContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public WhileBlockContext whileBlock() {
			return getRuleContext(WhileBlockContext.class,0);
		}
		public FuncBlockContext funcBlock() {
			return getRuleContext(FuncBlockContext.class,0);
		}
		public NamespaceBlockContext namespaceBlock() {
			return getRuleContext(NamespaceBlockContext.class,0);
		}
		public ConstructorBlockContext constructorBlock() {
			return getRuleContext(ConstructorBlockContext.class,0);
		}
		public ClassBlockContext classBlock() {
			return getRuleContext(ClassBlockContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				statement();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				ifBlock();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				whileBlock();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				funcBlock();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(54);
				namespaceBlock();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 6);
				{
				setState(55);
				constructorBlock();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 7);
				{
				setState(56);
				classBlock();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 8);
				{
				setState(57);
				block();
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

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(60);
				assignment();
				}
				break;
			case 2:
				{
				setState(61);
				functionCall();
				}
				break;
			}
			setState(64);
			match(T__0);
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

	public static class IfBlockContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfBlockContext elseIfBlock() {
			return getRuleContext(ElseIfBlockContext.class,0);
		}
		public IfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBlock; }
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__1);
			setState(67);
			match(T__2);
			setState(68);
			expression(0);
			setState(69);
			match(T__3);
			setState(70);
			block();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(71);
				match(T__4);
				setState(72);
				elseIfBlock();
				}
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

	public static class ElseIfBlockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public ElseIfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfBlock; }
	}

	public final ElseIfBlockContext elseIfBlock() throws RecognitionException {
		ElseIfBlockContext _localctx = new ElseIfBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elseIfBlock);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				block();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				ifBlock();
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

	public static class WhileBlockContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(SimpleParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfBlockContext elseIfBlock() {
			return getRuleContext(ElseIfBlockContext.class,0);
		}
		public WhileBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileBlock; }
	}

	public final WhileBlockContext whileBlock() throws RecognitionException {
		WhileBlockContext _localctx = new WhileBlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whileBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(WHILE);
			setState(80);
			match(T__2);
			setState(81);
			expression(0);
			setState(82);
			match(T__3);
			setState(83);
			block();
			{
			setState(84);
			match(T__4);
			setState(85);
			elseIfBlock();
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

	public static class NamespaceBlockContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public NamespaceBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceBlock; }
	}

	public final NamespaceBlockContext namespaceBlock() throws RecognitionException {
		NamespaceBlockContext _localctx = new NamespaceBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_namespaceBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__5);
			setState(88);
			match(IDENTIFIER);
			setState(89);
			block();
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

	public static class ConstructorBlockContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstructorBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorBlock; }
	}

	public final ConstructorBlockContext constructorBlock() throws RecognitionException {
		ConstructorBlockContext _localctx = new ConstructorBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constructorBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__6);
			setState(92);
			match(IDENTIFIER);
			setState(93);
			block();
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

	public static class ClassBlockContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ClassBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBlock; }
	}

	public final ClassBlockContext classBlock() throws RecognitionException {
		ClassBlockContext _localctx = new ClassBlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__7);
			setState(96);
			match(IDENTIFIER);
			setState(97);
			block();
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

	public static class FuncBlockContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcBlock; }
	}

	public final FuncBlockContext funcBlock() throws RecognitionException {
		FuncBlockContext _localctx = new FuncBlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__8);
			setState(100);
			match(IDENTIFIER);
			setState(101);
			match(T__2);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(102);
				match(IDENTIFIER);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(103);
					match(T__9);
					setState(104);
					match(IDENTIFIER);
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(112);
			match(T__3);
			setState(113);
			block();
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(IDENTIFIER);
			setState(116);
			match(T__10);
			setState(117);
			expression(0);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(IDENTIFIER);
			setState(120);
			match(T__2);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << INTEGER) | (1L << FLOAT) | (1L << STRING) | (1L << BOOL) | (1L << NULL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(121);
				expression(0);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(122);
					match(T__9);
					setState(123);
					expression(0);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(131);
			match(T__3);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParenthesizedExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesizedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ConstantExpressionContext extends ExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class AdditiveExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public AdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class NotExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ComparisonExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CompareOpContext compareOp() {
			return getRuleContext(CompareOpContext.class,0);
		}
		public ComparisonExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class MultiplicativeExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultOpContext multOp() {
			return getRuleContext(MultOpContext.class,0);
		}
		public MultiplicativeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public BooleanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new ConstantExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
				constant();
				}
				break;
			case 2:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(IDENTIFIER);
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(T__2);
				setState(138);
				expression(0);
				setState(139);
				match(T__3);
				}
				break;
			case 5:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(T__11);
				setState(142);
				expression(5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(161);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(146);
						multOp();
						setState(147);
						expression(5);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(150);
						addOp();
						setState(151);
						expression(4);
						}
						break;
					case 3:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(153);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(154);
						compareOp();
						setState(155);
						expression(3);
						}
						break;
					case 4:
						{
						_localctx = new BooleanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(157);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(158);
						boolOp();
						setState(159);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class MemberAccessContext extends ParserRuleContext {
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
	 
		public MemberAccessContext() { }
		public void copyFrom(MemberAccessContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FieldCallExpressionContext extends MemberAccessContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public FieldCallExpressionContext(MemberAccessContext ctx) { copyFrom(ctx); }
	}
	public static class MethodCallExpressionContext extends MemberAccessContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodCallExpressionContext(MemberAccessContext ctx) { copyFrom(ctx); }
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_memberAccess);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new MethodCallExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(IDENTIFIER);
				setState(167);
				match(T__12);
				setState(168);
				match(IDENTIFIER);
				setState(169);
				match(T__2);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << INTEGER) | (1L << FLOAT) | (1L << STRING) | (1L << BOOL) | (1L << NULL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(170);
					argumentList();
					}
				}

				setState(173);
				match(T__3);
				}
				break;
			case 2:
				_localctx = new FieldCallExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(IDENTIFIER);
				setState(175);
				match(T__12);
				setState(176);
				match(IDENTIFIER);
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

	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			expression(0);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(180);
				match(T__12);
				setState(181);
				expression(0);
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class MultOpContext extends ParserRuleContext {
		public MultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOp; }
	}

	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
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

	public static class AddOpContext extends ParserRuleContext {
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__17) ) {
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

	public static class CompareOpContext extends ParserRuleContext {
		public CompareOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareOp; }
	}

	public final CompareOpContext compareOp() throws RecognitionException {
		CompareOpContext _localctx = new CompareOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_compareOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
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

	public static class BoolOpContext extends ParserRuleContext {
		public TerminalNode BOOL_OPERATOR() { return getToken(SimpleParser.BOOL_OPERATOR, 0); }
		public BoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOp; }
	}

	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_boolOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(BOOL_OPERATOR);
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(SimpleParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(SimpleParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(SimpleParser.BOOL, 0); }
		public TerminalNode NULL() { return getToken(SimpleParser.NULL, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << STRING) | (1L << BOOL) | (1L << NULL))) != 0)) ) {
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

	public static class BlockContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__24);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__24) | (1L << WHILE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(198);
				line();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			match(T__25);
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
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u00d1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\7\2.\n\2\f\2\16\2\61\13\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\4\3\4\5\4A\n\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5L\n\5\3\6\3\6\5\6P\n\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\7\13l\n\13\f\13\16\13o\13\13\5\13q\n\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\r\177\n\r\f\r\16\r"+
		"\u0082\13\r\5\r\u0084\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u0092\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00a4\n\16\f\16\16\16\u00a7"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\5\17\u00ae\n\17\3\17\3\17\3\17\3\17\5"+
		"\17\u00b4\n\17\3\20\3\20\3\20\7\20\u00b9\n\20\f\20\16\20\u00bc\13\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\7\26\u00ca"+
		"\n\26\f\26\16\26\u00cd\13\26\3\26\3\26\3\26\2\3\32\27\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*\2\6\3\2\20\22\3\2\23\24\3\2\25\32\3\2\37"+
		"#\2\u00d6\2/\3\2\2\2\4<\3\2\2\2\6@\3\2\2\2\bD\3\2\2\2\nO\3\2\2\2\fQ\3"+
		"\2\2\2\16Y\3\2\2\2\20]\3\2\2\2\22a\3\2\2\2\24e\3\2\2\2\26u\3\2\2\2\30"+
		"y\3\2\2\2\32\u0091\3\2\2\2\34\u00b3\3\2\2\2\36\u00b5\3\2\2\2 \u00bd\3"+
		"\2\2\2\"\u00bf\3\2\2\2$\u00c1\3\2\2\2&\u00c3\3\2\2\2(\u00c5\3\2\2\2*\u00c7"+
		"\3\2\2\2,.\5\4\3\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3"+
		"\2\2\2\61/\3\2\2\2\62\63\7\2\2\3\63\3\3\2\2\2\64=\5\6\4\2\65=\5\b\5\2"+
		"\66=\5\f\7\2\67=\5\24\13\28=\5\16\b\29=\5\20\t\2:=\5\22\n\2;=\5*\26\2"+
		"<\64\3\2\2\2<\65\3\2\2\2<\66\3\2\2\2<\67\3\2\2\2<8\3\2\2\2<9\3\2\2\2<"+
		":\3\2\2\2<;\3\2\2\2=\5\3\2\2\2>A\5\26\f\2?A\5\30\r\2@>\3\2\2\2@?\3\2\2"+
		"\2AB\3\2\2\2BC\7\3\2\2C\7\3\2\2\2DE\7\4\2\2EF\7\5\2\2FG\5\32\16\2GH\7"+
		"\6\2\2HK\5*\26\2IJ\7\7\2\2JL\5\n\6\2KI\3\2\2\2KL\3\2\2\2L\t\3\2\2\2MP"+
		"\5*\26\2NP\5\b\5\2OM\3\2\2\2ON\3\2\2\2P\13\3\2\2\2QR\7\35\2\2RS\7\5\2"+
		"\2ST\5\32\16\2TU\7\6\2\2UV\5*\26\2VW\7\7\2\2WX\5\n\6\2X\r\3\2\2\2YZ\7"+
		"\b\2\2Z[\7%\2\2[\\\5*\26\2\\\17\3\2\2\2]^\7\t\2\2^_\7%\2\2_`\5*\26\2`"+
		"\21\3\2\2\2ab\7\n\2\2bc\7%\2\2cd\5*\26\2d\23\3\2\2\2ef\7\13\2\2fg\7%\2"+
		"\2gp\7\5\2\2hm\7%\2\2ij\7\f\2\2jl\7%\2\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2"+
		"mn\3\2\2\2nq\3\2\2\2om\3\2\2\2ph\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7\6\2\2"+
		"st\5*\26\2t\25\3\2\2\2uv\7%\2\2vw\7\r\2\2wx\5\32\16\2x\27\3\2\2\2yz\7"+
		"%\2\2z\u0083\7\5\2\2{\u0080\5\32\16\2|}\7\f\2\2}\177\5\32\16\2~|\3\2\2"+
		"\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3"+
		"\2\2\2\u0082\u0080\3\2\2\2\u0083{\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u0086\7\6\2\2\u0086\31\3\2\2\2\u0087\u0088\b\16\1\2\u0088"+
		"\u0092\5(\25\2\u0089\u0092\7%\2\2\u008a\u0092\5\30\r\2\u008b\u008c\7\5"+
		"\2\2\u008c\u008d\5\32\16\2\u008d\u008e\7\6\2\2\u008e\u0092\3\2\2\2\u008f"+
		"\u0090\7\16\2\2\u0090\u0092\5\32\16\7\u0091\u0087\3\2\2\2\u0091\u0089"+
		"\3\2\2\2\u0091\u008a\3\2\2\2\u0091\u008b\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u00a5\3\2\2\2\u0093\u0094\f\6\2\2\u0094\u0095\5 \21\2\u0095\u0096\5\32"+
		"\16\7\u0096\u00a4\3\2\2\2\u0097\u0098\f\5\2\2\u0098\u0099\5\"\22\2\u0099"+
		"\u009a\5\32\16\6\u009a\u00a4\3\2\2\2\u009b\u009c\f\4\2\2\u009c\u009d\5"+
		"$\23\2\u009d\u009e\5\32\16\5\u009e\u00a4\3\2\2\2\u009f\u00a0\f\3\2\2\u00a0"+
		"\u00a1\5&\24\2\u00a1\u00a2\5\32\16\4\u00a2\u00a4\3\2\2\2\u00a3\u0093\3"+
		"\2\2\2\u00a3\u0097\3\2\2\2\u00a3\u009b\3\2\2\2\u00a3\u009f\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\33\3\2\2"+
		"\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7%\2\2\u00a9\u00aa\7\17\2\2\u00aa\u00ab"+
		"\7%\2\2\u00ab\u00ad\7\5\2\2\u00ac\u00ae\5\36\20\2\u00ad\u00ac\3\2\2\2"+
		"\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b4\7\6\2\2\u00b0\u00b1"+
		"\7%\2\2\u00b1\u00b2\7\17\2\2\u00b2\u00b4\7%\2\2\u00b3\u00a8\3\2\2\2\u00b3"+
		"\u00b0\3\2\2\2\u00b4\35\3\2\2\2\u00b5\u00ba\5\32\16\2\u00b6\u00b7\7\17"+
		"\2\2\u00b7\u00b9\5\32\16\2\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\37\3\2\2\2\u00bc\u00ba\3\2\2"+
		"\2\u00bd\u00be\t\2\2\2\u00be!\3\2\2\2\u00bf\u00c0\t\3\2\2\u00c0#\3\2\2"+
		"\2\u00c1\u00c2\t\4\2\2\u00c2%\3\2\2\2\u00c3\u00c4\7\36\2\2\u00c4\'\3\2"+
		"\2\2\u00c5\u00c6\t\5\2\2\u00c6)\3\2\2\2\u00c7\u00cb\7\33\2\2\u00c8\u00ca"+
		"\5\4\3\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\7\34"+
		"\2\2\u00cf+\3\2\2\2\22/<@KOmp\u0080\u0083\u0091\u00a3\u00a5\u00ad\u00b3"+
		"\u00ba\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}