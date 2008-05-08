Program Questao02;

Var
	d : integer;
	v : real;
	ds : integer;
	vt : real;

begin
	readln ( d, v);

	if ( d >= 1 ) and ( d <=5 )	then	ds := 10;
	if ( d >= 6 ) and ( d <= 10 ) 	then 	ds := 8; 
	if ( d >= 11 ) and ( d <= 15 ) 	then 	ds := 6;
	if ( d >= 16 ) and ( d <= 20 ) 	then 	ds := 4;
	if ( d >= 21 ) and ( d <= 25 ) 	then 	ds := 2;
	if ( d >= 26 ) and ( d <= 31 ) 	then 	ds := 0;

	if ( d >= 1 ) and ( d <=31 ) and ( v >= 0 )
		then
			begin
				vt := v - v*ds/100;
				writeln ( vt:6:2 );
			end;
end.

	
