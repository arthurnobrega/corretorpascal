program questao2;

	var dia : integer; pg, valor : real;
	
begin
	
	readln(dia, valor);
	if
	((dia=1) or (dia=2) or (dia=3) or (dia=4) or (dia=5))
	then
	pg:=valor*9/10;
		
		if
		((dia=6) or (dia=7) or (dia=8) or (dia=9) or (dia =10))
		then
		pg:=valor*92/100;
	if
	((dia=11) or (dia=12) or (dia=13) or (dia=14) or (dia=15))
	then
	pg:=valor*94/100;
		if
		((dia=16) or (dia=17) or (dia=18) or (dia=19) or (dia=20))
		then
		pg:=valor*96/100;
	if
	((dia=21) or (dia=22) or (dia=23) or (dia=24) or (dia=25))
	then
	pg:=valor*98/100;
		if
		((dia=26) or (dia=27) or (dia=28) or (dia=29) or (dia=30) or (dia=31))
		then
		pg:=valor;
	if
	dia>31
	then
	begin
	end;
		if dia<1
		then
		begin
		end;	
		writeln(pg:6:2);
end.
