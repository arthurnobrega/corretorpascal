program questao2;

var
x : integer;
y ,p : real;

begin
readln (y,x);
      if (x <= 5)
        then p:= 0.9*y;
      if (x > 5) and (x <= 10)
        then p:= 0.92*y;
      if (x > 10) and (x <= 15)
        then p:= 0.94*y;
      if (x > 15) and (x <= 20)
        then p:= 0.96*y;
      if (x > 20) and (x <= 25)
        then p:= 0.98*y;
      if (x > 25) and (x <= 31)
        then P:=y;
writeln (p);
end.
