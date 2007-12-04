Program Transito;
Var 
	tipo, dia, desconto : integer;
	valor, multa : real;
begin
	readln (tipo);
	readln (dia);
	if (tipo = 1)
		then valor := 100
		else if (tipo = 2)
					then  valor := 200
					else  valor := 500;
	if  (dia <= 5)
		then desconto := 25
	else  if  (dia <= 10)
		then desconto := 20
	else  if  (dia <= 15)
		then desconto := 15
	else  if  (dia <= 20)
		then desconto := 10
	else  if  (dia <= 25)
		then desconto := 5
		else desconto := 0;
	multa := valor * ( 1 - desconto/100);
	writeln (multa);
end.
