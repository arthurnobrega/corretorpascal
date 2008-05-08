program questao2;

var
	a : integer;
	b, valor1, valor2, valor3, valor4, valor5, valor6 : real;

begin
	writeln ('Informe o dia do pagamento');
	writeln ('e o valor nominal do pagamento: ');

	readln (a, b);

	if (a >=26) and (a <=31) 
		then 
		begin	
			valor1 := 1 * b ;
			writeln ('valor efetivamente pago: ') ;
			writeln (valor1 :1:0) ;
			
			
		end;
 
	
	
	if (a >=21) and (a <=25)
		then
		begin
			valor2 := (98/100) * b ;
			writeln ('valor efetivamente pago: ') ;
			writeln (valor2 :1:0) ;
			
		end;
	
	
	if (a >=16) and (a <=20)
		then
		begin	
			valor3 := (96/100) * b ;
			writeln ('valor efetivamente pago: ') ;
			writeln (valor3 :1:0) ;
			
		end;
	
	
	if (a >=11) and (a <=15)
		then
		begin
			valor4 := (94/100) * b ;
			writeln ('valor efetivamente pago: ') ;
			writeln (valor4 :1:0) ;

	end;
	
	
	if (a >=6) and (a <=10)
		then
		begin
			valor5 := (92/100) * b ;
			writeln ('valor efetivamente pago: ') ;
			writeln (valor5 :1:0) ;

		end;
	
	if (a >=1) and (a <=5)
		then
		begin
			valor6 := (90/100) * b ;
			writeln ('valor efetivamente pago: ') ;
			writeln (valor6 :1:0) ;

		end;
	
end.
