program questao1;
	var a, b, c, x1, x2, x3, tot : real;

	begin
		
		readln(a, b, c);
		
		if (a < 3) or (a = 3)
			then 
				begin	
					x1:= 5*a;
	
				end;
		if (a > 3)
			then	
				begin
					x1:= 3*a;
				
				end;
		
		if (b < 4) or (b = 4)
			then
				begin
					x2:= 15*b;
					
				end;
		if (b > 4)
			then		
				begin
					x2:= 12*b;
					
				end;
	
		if (c < 5) or (c = 5)
			then
				begin			
					x3:= 10*c;
				
				end;
		if (c > 5)
			then
				begin
					x3:= 8*c; 
				
				end;
		
		tot:= (x1 + x2 + x3);
		writeln(tot:4:2);
		
		if (a < 0) or (b < 0) or (c < 0)
			then
			
	end.



