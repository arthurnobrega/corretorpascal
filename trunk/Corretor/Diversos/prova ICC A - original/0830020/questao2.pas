program questao2;
var
a := integer
b, y := real;
begin
readln (a, b);
if (a>=26) and (a<=31)
then
y := (b);
if (a>=21) and (a<=25)
then
y := (0.98 * b);
if (a>=16) and (a<=20)
then
y := (0.96 * b);
if (a>=11) and (a<=15)
then
y := (0.94 * b);
if (a>=6) and (a<=10)
then
y := (0.92 * b);
if (a>=1) and (a<=5)
then
y := (0.90 * b)
if (a<1) or (a>31)
then
begin

end;
write (y);
end.
