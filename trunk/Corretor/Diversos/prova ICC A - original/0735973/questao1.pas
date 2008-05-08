program questao1;

var
	a, b, c, x, y, z, q : real;

begin
	readln (a, b, c);
	if (a <= 3)
	then
		begin
		x := (a * 5)
		end
	else
		begin
		x := (a * 3)
		end;
	
	if (b <= 4)
	then
		begin
		y := (b * 15)
		end
	else
		begin
		y := (b * 12)
		end;
	
	if (c <= 5)
	then
		begin
		z := (c * 10)
		end
	else
		begin
		z := (c * 8)
		end;
	q := (x + y + z); 
	writeln (q : 2 : 2)
end.
