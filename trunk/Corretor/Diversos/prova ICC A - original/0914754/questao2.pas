program pagamento;

var 

d : integer;
p : real;

begin

readln(d,p);

If  (d >= 26) and (d <= 31) then p := p;
If  (d >= 21) and (d <= 25) then p:= (p * 0.98);
If  (d >= 16) and (d <= 20) then p:= (p * 0.96);
If  (d >= 11) and (d <= 15) then p:= (p * 0.94);
If  (d >= 6) and (d <= 10)  then p:= (p * 0.92);
If  (d >= 1) and (d <= 5)   then p:= (p * 0.9);

writeln (p);
end.
