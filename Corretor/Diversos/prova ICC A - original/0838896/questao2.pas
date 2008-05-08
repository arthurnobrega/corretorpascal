program questao2;
var

	a, b : integer;
	x3 : real;

 begin
  readln (a, b);
	if (26 <= a) and (a <= 31)
		then
		x3 := ( b );
	if (21 <= a) and (a <= 25)
		then
		x3 := (b*0.98);
	if (16 <= a) and (a <= 20)
		then
		x3 := (b*0.96);
	if (11 <= a) and (15 <= a)
		then
		x3 := (b*0.94);
	if (6 <= a) and (10 <= a)
		then
		x3 := (b*0.92);
	if (1 <= a) and (5 <= a)
		then
		x3 := (b*0.90);
 writeln (x3); 

end.
