Program Questao01;

Var
	g, c, s, vg, vc, vs, vt : integer;

begin
	writeln ('entre com as quantidades de guarda-chuva, carteira e cinto respectivamente');
	readln ( g, c, s );	

	if ( g <= 3 )
		then	vg := 5*g
		else	vg := 3*g;
	if ( c <= 4 )
		then	vc := 15*c
		else	vc := 12*c;
	if ( s <= 5 )
		then	vs := 10*s
		else	vs := 8*s;
	
	if ( g >= 0 ) and ( c >= 0 ) and ( s >= 0 )
		then
			begin
				vt := vg + vc + vs;
				writeln ( vt );
			end;
end.
