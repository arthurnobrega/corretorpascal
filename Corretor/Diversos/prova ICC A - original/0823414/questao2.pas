program loja


;var 
        x1 : integer ;
        a, b : real ;

Begin

        readln (x1, a);

        if (x1>=26) and (x1<=31)

then

      b := (a);

       if (x1>=21) and (x1<=25)

then

     b := (a*0.98);

      if (x1>=16)  and (x1<=20)

then
 
    b := (a*0.96);

    if (x1>=11)  and  (x1<=15)

then

   b := (a*0.94);

   if (x1>=6) and (x1<=10)

then

   b := (a*0.92);

   if (x1>=1) and (x1<=5)

then

   b := (a*0.9);

 if (x1>31) or (x1<1)

then

begin 

    b := (0); 

      
 
end;
     
     writeln (b);

   

end.

























