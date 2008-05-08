program questao2;

var
	payday : integer;
	valor1, valor2, valor3, valor4, valor5, valor6 : real;

begin
	{writeln ('por favor, coloque a data do pagamento e o valor');}
	readln (payday, valor1);
	if (payday>=26) and (payday<=31) then
	writeln (valor1:2:2)
	else if (payday>=21) and (payday<=25) then
	begin
	valor2 := (valor1*0.98);
	writeln (valor2:2:2);
	end
	else if (payday>=16) and (payday<=20) then
	begin
	valor3 := (valor1*0.96);
	writeln (valor3:2:2);
	end
	else if (payday>=11) and (payday<=15) then
	begin
	valor4 := (valor1*0.94);
	writeln (valor4:2:2);
	end
	else if (payday>=6) and (payday<=10) then
	begin
	valor5 := (valor1*0.92);
	writeln (valor5:2:2);
	end
	else if (payday>=1) and (payday<=5) then
	begin
	valor6 := (valor1*0.9);
	writeln (valor6:2:2);
	end;
end.
