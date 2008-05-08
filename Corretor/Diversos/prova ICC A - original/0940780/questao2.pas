program ba0940780;
var
	dia, desconto: integer;
	valor, total: real;

begin
	writeln ('dia do pagamento');
	readln (dia);
	writeln ('valor nominal');
	readln (valor);

	if (dia <= 5)
	then desconto := 10
	else if (dia >= 6) and (dia <= 10)
	then desconto := 8
	else if (dia >= 11) and (dia <= 15)
	then desconto := 6
	else if (dia >= 16) and (dia <= 20)
	then desconto := 4
	else if (dia >= 21) and (dia <= 25)
	then desconto := 2
	else if (dia >= 26) and (dia <= 31)
	then desconto := 0;

	total := valor * (1 - desconto / 100);
	writeln (total);
end.
