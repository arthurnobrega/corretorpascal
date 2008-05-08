program questao1;
var
	gc, ca, ci, t, td, tt, total : real ;
begin
	readln (gc, ca, ci );
	if gc < 4 then
			t := (5*gc)
	else t:= (3*gc);
	if ca < 5 then
			td := (ca*15)
	else td:= (ca*12);
	if ci < 6 then
			tt := (ci*10)
	else tt:= (ci*8);
	total := (t + td + tt);
	writeln ('total : ',total:4:2);
end.
