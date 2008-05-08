program loja;

var
d, v: integer; 
a: real;

begin
writeln('entre o dia do pagamento e valor do pagamento');
readln(d, v);
if(26 <= d) and (d <= 31)
then a := v; 
if(21 <= d) and (d <= 25)
then a := v - (2 / 100 * v);
if(16 <= d) and (d <= 20)
then a := v - (4 / 100 * v);
if(11 <= d) and (d <= 15)
then a := v - (6 / 100 * v);
if(6 <= d) and (d <= 10)
then a := v - (8 / 100 * v);
if(1 <= d) and (d <= 5)
then a := v - (10 / 100 * v);

writeln(a:5:2);

end.
