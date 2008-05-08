program questao2;

var
	a : integer;
	b , c : real;

begin
	readln (a, b);
	if (a <= 31) and (a >= 26)
	then
		begin
		c := b;
		writeln (c : 2 : 2)
		end;
	if (a <= 25) and (a >= 21)
	then 
		begin
		c := (b * 0.98);
		writeln (c : 2 : 2)
		end;
	if (a <= 20) and (a >= 16)
	then 
		begin
		c := (b * 0.96);
		writeln (c : 2 : 2)
		end;
	if (a <= 15) and (a >= 11)
	then 
		begin
		c := (b * 0.94);
		writeln (c : 2 : 2)
		end;
	if (a <= 10) and (a >= 6)
	then 
		begin
		c := (b * 0.92);
		writeln (c : 2 : 2)
		end;
	if (a <= 5) and (a >= 1)
	then 
		begin
		c := (b * 0.90);
		writeln (c : 2 : 2)
		end;
end.
