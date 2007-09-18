program Teste;
uses crt; 

var a,b:integer;

begin
   clrscr;
   writeln ('Digite um número para A');
   readln (a);
   writeln ('Digite o número para B');
   readln (b);

   if (a > b) then     { Se A é maior que B então }
       writeln ('A é maior que B')
   else                { Senão... }
       if (a < b) then
           writeln ('B é maior que A')
       else
           writeln ('B é igual à A');
end.