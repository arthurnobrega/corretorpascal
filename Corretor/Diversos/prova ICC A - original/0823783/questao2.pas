program questao2;

var

 dia:integer;
 nominal,total:real;

begin

 {writeln ('Entre o dia do pagamento e o valor nominal');}
 readln (dia,nominal);
 case dia of

 1..5 : total := 0.9*nominal; {desconto de 10%}
 6..10 : total := 0.92*nominal; {desconto de 8%}
 11..15 : total := 0.94*nominal; {desconto de 6%}
 16..20 : total := 0.96*nominal; {desconto de 4%}
 21..25 : total := 0.98*nominal; {desconto de 2%}
 26..31 : total := nominal; {sem desconto}
 end;

 writeln (total:2:2);

end.
