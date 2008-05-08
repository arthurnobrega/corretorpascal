	program questao2;
	var
	a, b, w: real;
	begin	
	
	readln (a, b);
	if (a>=1) and (a<=5)
	then 
	w := (b*0.9);
	if (a>=6) and (a<=10)
	then
	w := (b*0.92);
	if (a>=11) and (a<=15)
	then
	w := (b*0.94);
	if (a>=16) and (a<=20)
	then
	w := (b*0.96);
	if (a>=21) and (a<=25)
	then
	w := (b*0.98);
	if (a>=26) and (a<=31)
	then
	w := (b);
	writeln (w);
	end.
