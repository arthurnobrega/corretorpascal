program teste1;
var
chuvasq,carteirasq,cintosq:integer; final:real;
begin
readln(chuvasq);  
readln(carteirasq);
readln(cintosq); final :=0;
if chuvasq <= 3 
then final := final + 5 * chuvasq
else final := final + 3 * chuvasq;
if  carteirasq <= 4
then final := final + 15 * carteirasq
else final := final + 12 * carteirasq; 
if cintosq <= 5
then final := final + 10 * cintosq
else final := final + 8 * cintosq;
end.	
