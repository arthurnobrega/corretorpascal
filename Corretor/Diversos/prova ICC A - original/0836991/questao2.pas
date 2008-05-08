program questao2;
var 
	dia : integer;
	valor, total : real;
begin
	readln ( dia, valor );
	if (dia > 0) and (dia < 6 ) then total := (0.9*valor);
	if (dia > 5) and (dia < 11) then total := (0.92*valor);
	if (dia > 10) and (dia < 16) then total := (0.94*valor);
	if (dia > 15) and (dia < 21) then total := (0.96*valor);
	if (dia > 20) and (dia < 26) then total := (0.98*valor);
	if (dia > 25) and (dia < 32) then total := (valor);
	writeln ('total : ',total:5:2);
end.
