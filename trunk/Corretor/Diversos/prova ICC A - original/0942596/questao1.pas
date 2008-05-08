program questao1;
var
	gc, ca, ct:integer;
	preco1, preco2, preco3, total:integer;

begin
	readln (gc);
	if (gc <= 3) and (gc >= 0)
	then preco1 := 5 * gc
	else preco1 := 3 * gc;
	readln (ca);
	if (ca <= 4) and (ca >= 0)
	then preco2 := 15 * ca
	else preco2 := 12 * ca;
	readln (ct);
	if (ct <= 5) and (ct >= 0)
	then preco3 := 10 * ct
	else preco3 := 8 * ct;
	total := preco1 + preco2 + preco3;
	writeln ('total: ', total);
	if (gc < 0) or (ca < 0) or (ct < 0)
	then writeln ('VERIFIQUE SE O PRECO ESTA CORRETO');
end.
