program questao1;

	var gc, cart, cin, t1, t2, t3, total:real;
	
	begin
	
		readln(gc, cart, cin);
			if
			gc<4
			then
			t1:=(gc*5);
			if
			gc>4
			then
			t1:=(gc*3);
	if
	cart<5
	then
	t2:=(cart*15);
	if
	cart>5
	then
	t2:=(cart*12);

			if
			cin<6
			then
			t3:=(cin*10);
			if
			cin>6
			then
			t3:=(cin*8);
		

			
			total:=(t1+t2+t3);
			writeln(total:4:2);
	end.
