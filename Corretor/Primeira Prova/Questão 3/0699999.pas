program Teste;
uses crt; 

var a,b:integer;

begin
   clrscr;
   writeln ('Digite um n�mero para A');
   readln (a);
   writeln ('Digite o n�mero para B');
   readln (b);

   if (a > b) then     { Se A � maior que B ent�o }
       writeln ('A � maior que B')
   else                { Sen�o... }
       if (a < b) then
           writeln ('B � maior que A')
       else
           writeln ('B � igual � A');
end.