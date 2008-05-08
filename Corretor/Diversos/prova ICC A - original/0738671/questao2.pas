program questao2; 

	var dia: integer;
	    pagam, totalreal: real; 

begin 
	 
	readln (dia, pagam); 

if ((26<dia) and (31<dia))
	then 
		begin 
		totalreal:= pagam; 
		end 
	else 
if ((21<=dia) and (dia<=25)) 
	then 
		begin 
		totalreal:= pagam*0.98; 
		end
	else 
if ((16<=dia) and (dia<=20))
	then 
		begin 
		totalreal:= pagam*0.96; 
		end 
	else 
if ((11<=dia) and (dia<=15))
	then 
		begin 
		totalreal:= pagam*0.94; 
		end 
	else 
if ((6<=dia) and (dia<=10))
	then 
		begin 
		totalreal:= pagam*0.92; 
		end 
	else 
if ((1<=dia) and (dia<=5))
	then 
		begin 
		totalreal := pagam*0.9; 
		end;
	
begin 
	writeln (totalreal:10:10); 
	end; 
end.

	
