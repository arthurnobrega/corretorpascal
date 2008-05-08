Program questao002;
Var dia: integer;
valor1: real;
valor: real;

begin
writeln('dia');
readln(dia);
writeln('valor1');
readln(valor1);
valor:=0;
if dia <=6
then valor := valor1 * (90 / 100);
if dia  <=11 
then valor := valor1 * (92 / 100);
if dia <=16 
then valor := valor1 * (94 / 100);
if dia <=21 
then valor := valor1 * (96 / 100);
if dia <=26
then valor := valor1 * (98 / 100);
if dia >26
then valor := valor1;
writeln('valor r$ ',valor:6:2);
end.
