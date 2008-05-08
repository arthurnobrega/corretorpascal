program questao2;
var
dia, desconto : integer;
valor : real;
total : real;

begin
   writeln ('dia');
   readln (dia);
   writeln ('valor');
   readln (valor);

   if dia <= 5
   then desconto:= 10
   else if dia <= 10
   then desconto:= 8
   else if dia <= 15
   then desconto:= 6
   else if dia <= 20
   then desconto:= 4
   else if dia <= 25
   then desconto:= 2
   else if dia <= 31
   then desconto:= 0;
total:= valor * (1 - desconto / 100);
writeln (total);
end.  
