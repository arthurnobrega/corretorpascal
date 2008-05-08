program questao1;
{O programa irá ler a quantidade comprada de cada produto(guarda - chuvas; carteiras ; cintos)
e dará como saída o valor total de compra.}

Var
g, c1,c2, a, b, d ,e : real;

begin

readln( g, c1, c2);
	if ( g <= 3 )
		then  a := (g * 5)
		else  a := (g * 3);
	if ( c1 <= 4 ) 
		then b := (c1 * 15)
		else b := (c1 * 12);
	if (c2 <=5 )
		then d := (c2 * 10)
		else d := (c2 * 8);
e := a + b + d;

writeln (e:5:2);
end. 
