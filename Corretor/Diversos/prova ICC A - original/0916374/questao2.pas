program teste2;
var
payday:integer; pagamento:real;
begin		
readln (payday);
readln (pagamento);
if payday > 31 
then;
if ((payday >=26) and  (payday <=31))
then pagamento:= pagamento;
if ((payday >=21) and (payday <=25))
then pagamento := pagamento - pagamento * 0.02;
if ((payday >=16) and (payday <=20))
then pagamento:= pagamento - pagamento * 0.04;
if ((payday >=11) and (payday <=15))
then pagamento:= pagamento - pagamento * 0.06;
if ((payday >=6) and (payday <=10))
then pagamento:= pagamento - pagamento * 0.08;
if ((payday >=1) and (payday <=5))
then pagamento:= pagamento - pagamento * 0.1;
writeln(pagamento:6:2);
end.

