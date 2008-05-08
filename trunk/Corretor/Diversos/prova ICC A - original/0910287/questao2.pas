program questao2;

Var
d : integer;
v , v1 : real;

begin
writeln ('escreva o dia do pagamento e o valor a ser pago');
readln( d , v);
	if (d <32) and ( d > 25 )
	    then v1 := v;
	if (d < 26) and ( d > 20 )
            then v1 := v - (v * 0.02);
        if (d < 21) and ( d > 15 )
            then v1 := v - (v * 0.04);
	if (d < 16) and ( d > 10)
	    then v1 := v - (v * 0.06);
	if (d < 11) and ( d > 5)
	    then v1 := v - (v * 0.08);
	if (d < 6) and ( d > 0)
	    then v1 := v - (v * 0.1);

writeln(v1:5:2);

end.
