program questao2;

var
d : integer;
v : real;
begin
readln(d, v);
	if (d >= 26) and (d <= 31)
	then v := v;
	if (d >= 21) and (d <= 25)
	then v := 98*v/100;
	if (d >= 16) and (d <= 20)
	then v := 96*v/100;
	if (d >= 11) and (d <= 15)
	then v := 94*v/100;
	if (d >= 6) and (d <= 10)
	then v := 92*v/100;
	if (d >= 1) and (d <= 5)
	then v := 90*v/100;
writeln (v);
end.
