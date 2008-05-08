program questao1;

var
	gc, car, cin : integer;
	total1, total2, total3, total4, total5, total6, total7, total8 : real;

begin
	{writeln ('por favor, escreva a quantidade de guarda-chuvas, carteiras e cintos');}
	readln (gc, car, cin);
	if (gc>3) and (car>4) and (cin>5) then
	begin
	total7 := (gc*3)+(car*12)+(cin*8);
	writeln (total7:2:2);
	end
	else if (gc>3) and (car>4) then
	begin
	total4 := (gc*3)+(car*12)+(cin*10);
	writeln (total4:2:2);
	end
	else if (gc>3) and (cin>5) then
	begin
	total5 := (gc*3)+(car*15)+(cin*8);
	writeln (total5:2:2);
	end
	else if (car>4) and (cin>5) then
	begin
	total6 := (gc*5)+(car*12)+(cin*8);
	writeln (total6:2:2);
	end
	else if (gc>3) then
	begin
	total1 := (gc*3)+(car*15)+(cin*10);
	writeln (total1:2:2);
	end
	else if (car>4) then
	begin
	total2 := (gc*5)+(car*12)+(cin*10);
	writeln (total2:2:2);
	end
	else if (cin>5) then
	begin
	total3 := (gc*5)+(car*15)+(cin*8);
	writeln (total3:2:2);
	end
	else if (gc<=3) and (car<=4) and (cin<=5) then
	begin
	total8 := (gc*5)+(car*15)+(cin*10);
	writeln (total8:2:2);
	end;
end.
