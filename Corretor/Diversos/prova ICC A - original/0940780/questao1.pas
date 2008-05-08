program b0940780;
var
	qntgc, qntcr, qntcn: integer;
	preco1, preco2, preco3, precof: real;

begin
	writeln ('entre com a quantidade de guarda chuva');
	readln (qntgc);
	writeln ('entre com a quantidade de carteiras');
	readln (qntcr);
	writeln ('entre com a quantidade de cintos');
	readln (qntcn);
   
	if (qntgc <= 3) 
	 then preco1 := qntgc * 5
	 else preco1 := qntgc * 3;
	
	if (qntcr <= 4)
	 then preco2 := qntcr * 15
	 else preco2 := qntcr * 12;

	if (qntcn <= 5)
	 then preco3 := qntcn * 10
	 else preco3 := qntcn * 8;

	precof := preco1 + preco2 + preco3;
	
	writeln (precof); 
end.

	 
