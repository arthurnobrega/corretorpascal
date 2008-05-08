program questao2;
var
a : integer;
b, x1 : real;

  begin

   readln (a, b);

     if (a>=26) and (a<=31)
       then
       x1 := ( b );
     if (a>=21) and (a<=25)
       then
       x1 := ( b * 0.98 );
     if (a>=16) and (a<=20)
       then
       x1 := ( b * 0.96 );
     if (a>=11) and (a<=15)
       then
       x1 := ( b * 0.94 );
     if (a>=6) and (a<=10)
       then
       x1 := ( b * 0.92 );
     if (a>=1) and (a<=5)
       then
       x1 := ( b * 0.90 );
     if (a<1) or (a>31)
       then
        begin

        end;
     writeln (x1);

end.
