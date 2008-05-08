program questao1;
var
qntguarda, qntcarteiras, qntcintos : integer;
preco : real;

begin
   writeln ('entre com a quantidade de guarda-chuvas');
   readln (qntguarda);
   writeln ('entre com a quantidade de carteiras');
   readln (qntcarteiras);
   writeln ('entre com a qntcintos'); 
   readln (qntcintos);

  preco:= 0;
   if qntguarda <= 3
   then preco:= qntguarda * 5.00
   else preco:= qntguarda * 3.00;

   if qntcarteiras <= 4
   then preco:= qntcarteiras * 15.00
   else preco:= qntcarteiras * 12.00;

   if qntcintos <= 5
   then preco:= qntcintos * 10.00
   else preco:= qntcintos * 8.00;

   writeln (preco);
end.

   
