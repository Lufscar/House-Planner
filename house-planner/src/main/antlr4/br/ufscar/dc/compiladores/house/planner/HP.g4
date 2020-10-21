grammar HP;

/* PALAVRAS RESERVADAS */

CONSTRUCTION:   'construction';
IS:             'is';
DECLARE:        'declare';
AS:             'as';
DEFINE:         'define';
SET:            'set';

/* TOKEN */
SEMICOLON:      ';';
UNDERSCORE:     '_';
OPENPAR:        '(';
CLOSEPAR:       ')';

map:
	CONSTRUCTION BLOCKNAME IS declaration* (build* cmdBuildHouse)* EOF;

declaration:
	DECLARE IDENTIFIER AS type SEMICOLON	|
	DEFINE CONSTANT AS NUMBER		|
	SET USERTYPE SEMICOLON;
	
IDENTIFIER:
	UNDERSCORE [a-z][0-9a-zA-Z_]*;

CONSTANT:
        [A-Z]+;

USERTYPE:
	[A-Z]+[a-z]+[a-zA-Z]*;

BLOCKNAME:
        [a-z]+;

type:
	newType	|
	basicType;

basicType:
	'Bedroom'		|
	'LivingRoom'            |
	'Bathroom'		|
	'Kitchen';
	
newType:
	USERTYPE;

NUMBER:
	[0-9]+		|
	[0-9]+ '.' [0-9]+;

STRING:
	'\'' (~('\n'))*? '\'';

COMMENT:'#' ~('\n'|'\r')* '\r'? '\n' -> skip;
WHITESPACE: ( ' ' |'\t' | '\r' | '\n') -> skip;

ERRO_CAD:
    '\'' (~('\''))*? '\n';
ERRO_SIMB:
    .?;

build:
	cmdMeasureArea		|
	cmdAddRoom		|
	cmdSubRoom		|
	cmdCreateAlert;

cmdMeasureArea:
	'measureArea' OPENPAR IDENTIFIER CLOSEPAR SEMICOLON;

cmdAddRoom:
	'addRoom' OPENPAR IDENTIFIER (',' IDENTIFIER)* CLOSEPAR SEMICOLON;

cmdSubRoom:
	'subRoom' OPENPAR IDENTIFIER (',' IDENTIFIER)* CLOSEPAR SEMICOLON;

cmdCreateAlert:
	'createAlert' OPENPAR (STRING | IDENTIFIER | CONSTANT | NUMBER)+ CLOSEPAR SEMICOLON;

cmdBuildHouse:
	'buildHouse' OPENPAR CLOSEPAR SEMICOLON;


