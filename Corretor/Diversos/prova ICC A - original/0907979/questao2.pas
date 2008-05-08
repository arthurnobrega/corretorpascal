program questao02;
var
dia:integer;
valorf, desconto, x:real;
begin
readln(x);
readln(dia);
valorf:=0;
if dia<=5
then desconto:= 90
else 
if dia<=10
then desconto:= 92
else if dia<=15
then desconto:=94
else if dia<=20
then desconto:= 96
else if dia<=25
then desconto:=98
else desconto:=100;
valorf:= x * (desconto / 100);
writeln(valorf)
end.
