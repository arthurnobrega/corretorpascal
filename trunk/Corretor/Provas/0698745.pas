Program pares;
var
   x,y : integer;
begin
   writeln('Digite os dois valores');
   readln(x,y);
If (x mod 2) <> 0
then x := x + 1;
While x <= y
Do Begin
         Writeln(x, ' - ');
         x := x + 2;
         End;
Writeln('Fim da Lista');
End.