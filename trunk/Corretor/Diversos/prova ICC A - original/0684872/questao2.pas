program questao2;
var 
  x: integer;
  y: real;
begin
   readln (x);
   readln (y);
     if ((26<=x) and (x>=31))
       then y:= y
         else
            if ((21<=x) and (x<=25))
               then y:= y* 0.02  
        	  else
 		    if ((16<=x) and (x>=20))
		      then y:= y*0.04
			else
			   if ((11<=x) and (x>=15))
			      then y:= y*0.06
				else
				   if ((6<=x) and (x>=10))
				      then y:= y*0.08
					else
					   if ((1<=x) and (x>=5))
						then y:= y*0.1;
    writeln (y:4);
end.

	 
