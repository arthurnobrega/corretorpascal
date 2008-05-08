	program questao1;	
	var
	a, b, c, x1, x2, x3, soma: integer;
	begin
	
	readln (a, b, c);
	if (a<=3)
	then
	x1 := (a*5);
	if (a>3)
	then
	x1 := (a*3);
	if (b<=4)
	then
	x2 := (b*15);
	if (b>4)
	then 
	x2 := (b*12);
	if (c<=5)
	then 
	x3 := (c*10);
	if (c>5)
	then
	x3 := (c*8);

	soma := (x1 + x2 + x3);
	writeln (soma);
	end.
