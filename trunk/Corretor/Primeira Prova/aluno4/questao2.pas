Program EncontraMaior;

Var
    nome:  array[1..3] of string[10];
    idade: array[1..3] of integer;
    maiorNome, menorNome: string[10];
    maiorIdade, menorIdade, i: integer;
Begin
    { Lê os dados da tela. }
    for i := 1 to 3 do
    begin
        write('Nome ', i, ': ');
        readln(nome[i]);
        write('Idade ', i, ': ');
        readln(idade[i]);
    end;
    writeln;
    
    { Encontra o maior e o menor. }
    maiorIdade := idade[1];
    menorIdade := idade[1];
    maiorNome := nome[1];
    menorNome := nome[1];
    for i := 2 to 3 do
    begin
        if (idade[i] > maiorIdade) then
        begin
            maiorIdade := idade[i];
            maiorNome := nome[i];
        end
        else if (idade[i] < menorIdade) then
        begin
            menorIdade := idade[i];
            menorNome := nome[i];
        end;
    end;
    
    { Escreve o resultado na tela. }
    writeln('A pessoa mais velha é ', maiorNome);
    writeln('. Sua idade é ', maiorIdade);
    writeln('A pessoa mais nova é ', menorNome);
    writeln('. Sua idade é ', menorIdade);
    writeln;
End.
