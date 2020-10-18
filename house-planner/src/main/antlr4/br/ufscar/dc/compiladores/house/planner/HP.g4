grammar HP;

map:
	'construction' 'is' declaration build* EOF;

declaration:
	'declare' IDENTIFIER 'as' type ';'	|
	'define' IDENTIFIER 'as' NUMBER		|
	'set' USERTYPE ';';
	
IDENTIFIER:
	'_' [a-z][0-9a-zA-Z_]*;

USERTYPE:
	[A-Z][a-zA-Z]*;

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
	'\'' ( ESC_SEQ | ~('\''|'\\') )* '\'';
	
fragment
ESC_SEQ: '\\\'';

COMMENT:'#' ~('\n'|'\r')* '\r'? '\n' -> skip;
WHITESPACE: ( ' ' |'\t' | '\r' | '\n') -> skip;

build:
	cmdImport		|
	cmdAddRoom		|
	cmdSubRoom		|
	cmdCreateAlert          |
	cmdBuildHouse;

cmdImport:
	'import(' IDENTIFIER ')' ';';

cmdAddRoom:
	'addRoom(' IDENTIFIER (',' IDENTIFIER)* ')' ';';

cmdSubRoom:
	'subRoom(' IDENTIFIER (',' IDENTIFIER)* ')' ';';

cmdCreateAlert:
	'createAlert(' (STRING | IDENTIFIER | NUMBER)+ ')' ';';

cmdBuildHouse:
	'buildHouse()' ';';
