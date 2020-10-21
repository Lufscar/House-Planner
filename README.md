#House Planner Language
#### Com a HPL você pode definir uma lista de cômodos e verificar a validade destes, analisando a estrutura básica de uma casa e a área disponível para a construção.
![Logo](https://drive.google.com/file/d/1I-BSMcdGRBYSMsZ8eOGJEmjdYa0bCgYT/view?usp=sharing)

A linguagem foi projetada durante a discilplina de Construção de Compiladores 1, ministrada pelo professor Danieal Lucrédio **@dlucredio**, durante o Ensino Não Presencial Empergencial - 2020, da Universidade Federal de São Carlos (UFSCar), por:
* Luciana Oliveira de Souza Gomes **@lufscar**
* Vinicius de Oliveira Peixoto **@viniciuspeixoto**

#### Comandos na HPL:
* `construction blockname is` Definição de um módulo "blockname"
* `declare _identifier as Type;` Declaração de um identificador "_identifier" do tipo "Type"
* `define CONSTANT as NUMBER;` Definição uma constante "CONSTANT" como "NUMBER"
* `set UserType` Declaração de um novo tipo de identificador "UserType"
* `measureArea(_identifier);` Leitura da área e atribuição ao cômodo _identifier
* `addRoom(_identifier);` Adição do cômodo _identifier na planta da casa
* `subRoom(_identifier);` Remoção do cômodo _identifier na planta da casa
* `createAlert(observações);` Escrita da string "obsvações"
* `buildHouse();` verificação de fim de código e retono do resultado

#### Tipos de Dado: 
* **Identificador / _IDENTIFIER_**: usado para os cômodos da casa, na forma: underline + string iniciando em letra minúscula
* **Número / _NUMBER_**: usado para expressão da área, na forma de número inteiro ou real (com ponto)
* **Tipos Básicos / _basicType_**: usado para definir os cômodos essenciais para uma casa completa e simples
> * **Bedroom**: Quarto 
> * **LivingRoom**: Sala 
> * **BathRoom**: Banheiro 
> * **Kitchen**: Cozinha
* **Tipo do Usuário / _USERTYPE_**: usado para definir novos tipos de cômodo

## Como Usar?
Você precisa:
1.  Baixar ou clonar este repositório na sua máquina local
2.  Ter instalada a IDE Apache NetBeans IDE 12.0 (ou equivalente)
3.  Abrir o projeto na sua IDE e "construir" o projeto, na IDE sugerida basta clicar no botão "clean and build" simbolizado por um martelo e uma vassoura
4.  Escrever o seu programa na linguagem HPL num arquivo .txt
5.  Abrir o seu prompt de comando e usar o seguinte comando:
> `java -jar "C:\CAMINHO\House-Planner\house-planner\target\house-planner-1.0-SNAPSHOT-jar-with-dependencies.jar" "C:\CAMINHO\PROGRAMA.txt" "C:\CAMINHO\SAIDA.txt"`

6. Não se esqueça de substituir **CAMINHO**, **respectivamente**, pelo caminho até o diretório do **projeto**, até seu **programa** e até o local onde a **saída** deve ser salva. Também substitua **PROGRAMA** pelo **nome** **do** **seu** **programa** salvo e SAIDA para o nome desejado para o arquivo de saída.

## Como Funciona?
A HPL é definida por uma gramática, explicada na página Home desta Wiki, e pode ser encontrada no arquivo HP.g4 dentro deste projeto.
O compilador da lingúagem é composto por 3 analisadores (léxico, sintático e semântico) e por um gerador de código.
#### Análise Léxica:
O analisador léxico pode identificar os seguintes erros: 
* Simbolo não indentificado
* Cadeia não fechada
#### Análise Sintática:
O analisador sintático pode identificar os seguintes erros: 
* Operação entre tipos de dados diferentes
* Comandos incompletos
#### Análise Semântico:
O analisador semântico pode identificar os seguintes erros: 
* Declaração de um indentificador já existente
* Uso de um identificador não declarado
* Uso de um tipo não declarado
#### Geração de Código: 
Ao rodar o código é gerada uma tabela com os cômodos validados e as seguintes infos pra cada cômodo:
* Nome: IDENTIFIER
* Tipo: type
* Área: NUMBER
