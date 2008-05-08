program questao1;

var

gua, car, cin, qgua, qcar, qcin, total : real;

begin

	  readln
	  ( gua, car, cin) ;
	if ( gua > 0) then
	  begin
		if (gua <4 ) then
		
		 begin
			gua := car*5 ;
	  	 end
		else
	  	 begin
			qcar := car*3 ;
	  	end;
	end;
	if ( car > 0 ) then
	  begin
		if ( car < 5) then
		 begin
			qcin := car*12 ;
	  	end;
	end;
	if ( cin > 0 ) then
	  begin
		if ( cin < 5 ) then
			qcin := car*10 ;
		end
	       else
		begin
			qcin := cin*8 ;
		end;
	  total := qcin + qcar + qgua ;
	  writrln (total) ;
		end;
	end;
end.
