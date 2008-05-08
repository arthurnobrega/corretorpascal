program questao2pas;
var
    pagamento,dia:real;
begin
    writeln('digite o dia do mes e o valor do pagamento');
    readln(dia,pagamento);
    if (dia>=26) then
begin
    pagamento:=(pagamento)
end;
    if ((dia>=21) and (dia<=25)) then
begin
    pagamento:=((pagamento)*2/100)
end;
    if ((dia>=16) and (dia<=20)) then
begin
    pagamento:=((pagamento)*4/100)

 
