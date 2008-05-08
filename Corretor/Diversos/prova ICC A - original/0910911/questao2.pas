program questao2;
{O programa irá ler o dia do pagamento e o valor nominal a ser pago; dará como saida
o valor a ser pago de acordo com o dia do pagamento.}

Var 
d : integer;
v, v1 : real;


begin 
readln( d, v);
	if (d <=31) and (d >=26)
	    then v1 := v;
	     if (d <= 25) and (d >= 21)
		then v1 := v - (v * 0.02);
			if (d <= 20) and (d >= 16)
			   then v1 := v - ( v * 0.04);
			 	if (d <=15) and (d >=11)
				   then v1 := v - (v * 0.06);
				       if ( d <=10) and (d <=6)
					   then v1 := v - (v * 0.08);
						if ( d <= 5) and ( d >=1)
						   then v1 := v - (v * 0.1);
writeln(v1:5:2);
	
end.	
			    
