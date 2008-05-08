program vend;

var 
a, b, c, precoa, precob, precoc, total: integer;

begin
writeln('entre com a quantidade de guarda-chuvas, carteiras e cintos');
readln(a, b, c);
if(a <= 3)
then precoa := 5 * a;
if(a > 3)
then precoa := 3 * a;

if(b <= 4)
then precob := b * 15;
if(b > 4 )
then precob := b * 12;

if(c <= 5)
then precoc := c * 10;
if( c > 5)
then precoc := c * 8;

total := precoa + precob + precoc;

writeln(precoa);
writeln(precob);
writeln(precoc);
writeln(total);

end.





