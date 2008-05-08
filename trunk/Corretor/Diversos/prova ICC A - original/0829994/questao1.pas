program questao1;

var
	a, b, c, valor1, valor2, valor3, total : integer;

begin
	writeln ('Informe o numero de guarda-chuvas,');
	writeln ('carteiras e cintos: ');

	readln (a, b, c);

	begin
	if (a <= 3)
		then 
			valor1 := 5*a
			else
				if (a >3)
					then valor1 := 3*a ;

	if (b <= 4)
		then
			valor2 := 15*b
			else
				if (b >4)
					then valor2 := 12*b ;

	if (c <=5)
		then
			valor3 := 10*c
			else
				if (C >5)
					then valor3 := 8*c ;
	end;
	
	total := valor1 + valor2 + valor3 ;	
	writeln ('valor total da compra: ');
	writeln	(total);

end.
