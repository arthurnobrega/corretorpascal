program questao1;

var

 gc,ca,ci:integer;
 p1,p2,p3,total:real;

begin

 {writeln ('entre os valores de gc, ca e ci');}
 readln (gc,ca,ci);
 {guarda chuvas}
 if (gc <= 3) then p1 := 5*gc;
 if (gc > 3) then p1 := 3*gc;

 {carteiras}
 if (ca <= 4) then p2 := 15*ca;
 if (ca > 4) then p2 := 12*ca;

 {cintos}
 if (ci <= 5) then p3 := 10*ci;
 if (ci > 5) then p3 := 8*ci;

 total := p1 + p2 + p3;

 writeln (total:2:2);

end.
