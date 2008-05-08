program questao1;

	    var guard, cart, cint, pcint, pguard, pcart,total : integer;

begin 
	
	readln (guard,cart,cint); 

	if (guard>3) 
		then 
			begin
			pguard:= 3*guard;
			end 
		else 
			begin 
			pguard:= 5*guard; 
			end; 
	if (cart>4) 
		then 
			begin 
			pcart:= 12*cart; 
			end 
		else 
			begin 
			pcart:= 15*cart;
			end;
	if (cint>5)
		then 
			begin 
			pcint:= 8*cint; 
			end
		else 
			begin 
			pcint:= 10*cint;  
			end; 
	begin 
		total:= pguard+pcint+pcart; 
		writeln (total);
	end;
end.
