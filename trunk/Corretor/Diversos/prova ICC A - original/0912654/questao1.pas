program questao1;
var
  quantg, quantcar, quantc : integer;
  preco:real;

begin
  readln(quantg); 
  readln(quantcar);
  readln(quantc);
  preco := 0;
  if quantg <= 3 
    then preco :=  preco + 5 * quantg
    else preco :=  preco + 3 * quantg;
  if quantcar <= 4
    then preco := preco + 15 * quantcar
    else preco := preco + 12 * quantcar;
  if quantc <= 5
    then preco := preco + 10 * quantc
    else preco := preco + 8 * quantc;   
  writeln(preco);
end.
