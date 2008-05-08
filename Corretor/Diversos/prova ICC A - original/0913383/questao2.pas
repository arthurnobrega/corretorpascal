program questao2;
var
dia, desconto: integer;
valorn, total: real;

begin
	readln (dia);
	readln (valorn);

	if dia<=5
	 then desconto:= 10
	 else if dia<=10
	  then desconto:= 8
	else if dia<=15
	  then desconto:= 6
	else if dia<=20
	  then desconto:= 4
	else if dia<=25
	  then desconto:= 2
	else desconto:= 0;
	
	total:= valorn * (1 - desconto/100);
	writeln (total);
end.
