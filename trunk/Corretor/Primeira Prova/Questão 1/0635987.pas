program Contar; (* nome do programa *)
 uses CRT; {Deve-se usar a declara��o CRT para uso do readkey!}
var
   contador: integer; (* declara��o de vari�veis *)
begin // inicio do bloco
     writeln('Contando ate 100...'); (* escreve na tela *)
     for contador := 1 to 100 do // conta at� 100
          writeln('Num: ', contador); (* imprime at� 100 *)
     readkey; (* especta *)
end.