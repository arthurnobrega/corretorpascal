Program questao001;
Var x, y, z : integer;
preco : real;

begin
writeln('x');
readln(x);
writeln('y');
readln(y);
writeln('z');
readln(z);
preco :=0;
if x <=3
then preco := preco + x * 5
else preco := preco + x * 3;
if y <=4
then preco := preco + y * 15
else preco := preco + y * 12;
if z <= 5 
then preco := preco + z * 10
else preco := preco + z * 8;
writeln('total r$ ',preco:6:2);
end.
