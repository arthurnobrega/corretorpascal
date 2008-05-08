program questao1;
var
quantgc, quantca, quantci: integer;
preco: real;

begin
	readln (quantgc);
	readln (quantca);
	readln (quantci);
	preco:= 0;

	if (quantgc <= 3)
	 then preco:= preco + 5 * quantgc
	 else preco:= preco + 3 * quantgc;

	if (quantca <=4)
	 then preco:= preco + 15 * quantca
	 else preco:= preco + 12 * quantca;

	if (quantci <=5)
	 then preco:= preco + 10 * quantci
	 else preco:= preco + 8 * quantci;

	writeln (preco);
end.
