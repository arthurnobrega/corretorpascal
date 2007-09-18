program Contar; (* nome do programa *)
 uses CRT; {Deve-se usar a declaração CRT para uso do readkey!}
var
   contador: integer; (* declaração de variáveis *)
begin // inicio do bloco
     writeln('Contando ate 100...'); (* escreve na tela *)
     for contador := 1 to 100 do // conta até 100
          writeln('Num: ', contador); (* imprime até 100 *)
     readkey; (* especta *)
end.