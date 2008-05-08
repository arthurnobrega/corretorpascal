program questaodois;

var

	dia : integer;
	total, val : real;

begin
	readln (dia);
	readln (val);
	
	if (dia > 25) and (dia <= 31) then
	 begin
		total := val;
	 end;
	if (dia > 20) and (dia <= 25) then
	 begin
		total := val*0.98;
	 end;
	if (dia > 15) and (dia <= 20) then
	 begin
		total := val*0.96;
	 end;
	if (dia > 10) and (dia <= 15) then
	 begin
		total := val*0.94;
	 end;
	if (dia > 5) and (dia <= 10) then
	 begin
		total := val*0.92;
	 end;
	if (dia > 0) and (dia <= 5) then
	 begin
		total := val*0.90;
	 end;
	writeln (total);
end.
