program questaoum;

var

	gua, car, cin, qgua, qcar, qcin, total : real;

begin

	 readln (gua, car, cin);
	if (gua > 0) then
	 begin
		if (gua < 4) then
		 begin
			qgua := gua*5 ;
	 	 end
		else
	 	 begin
			qgua := gua*3 ;
	 	 end;
	 end;
	if (car > 0) then
	 begin
		if (car < 5) then
		 begin
			qcar := car*15 ;
	 	 end
		else
	 	 begin
			qcar := car*12 ;
	  	 end;
	 end;
	if (cin > 0) then
	 begin
		if  (cin < 6) then
		 begin
			qcin := cin*10 ;
		 end
		else
		 begin
			qcin := cin*8 ;
		 end;
	 end;
	total := qcin + qcar + qgua ;
	writeln (total);
end.
