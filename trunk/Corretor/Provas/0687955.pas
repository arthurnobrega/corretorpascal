Program Soma_Pares;
var
   superior, soma, num: integer;
begin
   soma:=0;
   write ('Entre com o limite superior');
   readln (superior);
   num:=2;
  
   Repeat
     soma:=soma+num;
     num:=num+2;
   until (num > superior);

   writeln('A soma dos n�meros pares de 2 at� ', superior, ' � ', soma);
end.