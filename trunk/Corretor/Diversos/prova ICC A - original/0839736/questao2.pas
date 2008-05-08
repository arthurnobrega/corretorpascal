program questao2;
	var   dia: integer;  a, b: real;

	begin
		
		readln(dia);
		
		readln(b);
		
		if (dia > 0) and (dia < 6)
			then
				begin 
					a:= 0.9*b
				end;
		
		if (dia > 5) and (dia <11)
			then 
				begin	
					a:= 0.92*b
	
				end;
		if (dia > 10) and (dia < 16)
			then
				begin 
					a:= 0.94*b
				end;
		if (dia > 15) and (dia < 21)
			then
				begin 
					a:= 0.96*b
				end;
		if (dia > 20) and (dia < 26)
			then
				begin 
					a:= 0.98*b
				end;
		if (dia > 25) and (dia < 32)
			then
				begin 
					a:= b
				end;
		

		writeln(a:4:2);
	end.
		
