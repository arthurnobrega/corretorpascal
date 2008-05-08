program questao2;
var
    dia : integer;
    val, som : real;
begin
    readln ( dia, val);
    if (dia < 6) then tot := (0.9*val);
    if (dia > 5) and (dia < 11) then tot := (0.92*val);
    if (dia > 10) and (dia < 16) then tot := (0.94*val);
    if (dia > 15) and (dia < 21) then tot := (0.96*val);
    if (dia > 20) and (dia < 26) then tot := (0.98*val);
    if (dia > 25) and (dia < 32) then tot := (val);
    writeln ('som : ', tot:6:2);
end.
