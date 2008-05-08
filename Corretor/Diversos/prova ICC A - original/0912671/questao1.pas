program questao1pas;
var
    guardachuvas,carteiras,cintos,preco:real;    
begin    
    writeln('digite a quantidade dos produtos');
    readln(guardachuvas,carteiras,cintos);       
    if (guardachuvas<=3) and (carteiras<=4) and (cintos<=5) then          
begin    
    preco:=(guardachuvas*5+carteiras*15+cintos*10);
end;
    if (guardachuvas>3) and (carteiras<=4) and (cintos<=5) then
begin
    preco:=(guardachuvas*3+carteiras*15+cintos*10);
end;
    if (guardachuvas<=3) and (carteiras>4) and (cintos<=5) then
begin
    preco:=(guardachuvas*5+carteiras*12+cintos*10);
end;
    if (guardachuvas<=3) and (carteiras<=4) and (cintos>5) then
begin
    preco:=(guardachuvas*5+carteiras*15+cintos*8);
end;
    if (guardachuvas>3) and (carteiras>4) and (cintos<=5) then
begin    
    preco:=(guardachuvas*3+carteiras*12+cintos*10);
end;
    if (guardachuvas>3) and (carteiras<=4) and (cintos>5) then
begin
    preco:=(guardachuvas*3+carteiras*15+cintos*8);
end;
    if (guardachuvas<=3) and (carteiras>4) and (cintos>5) then
begin
    preco:=(guardachuvas*5+carteiras*12+cintos*8);
end;
    if (guardachuvas>3) and (carteiras>4) and (cintos>5) then
begin
    preco:=(guardachuvas*3+carteiras*12+cintos*8);
end;
begin
    writeln('preco: ',preco:5:2);   
end;
end.
