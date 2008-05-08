program questao1;

Var
gc , ca , ci ,a , b , c , e : real;

begin
writeln('entre com a quantidade de produtos comprados respectivamente: guarda-chuva, carteira e cinto.');
readln(gc, ca , ci);
     if ( gc<4)
        then a:= (gc * 5) 
        else a:= (gc * 3);
     if ( ca<5)
        then b:= (ca * 15)
        else b:= (ca * 12);
     if ( ci<6)
        then c:= (ci * 10)
        else c:= (ci * 8);
 
e := a + b + c;

writeln(e:5:2);
end.
