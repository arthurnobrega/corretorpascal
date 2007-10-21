Program EncontraMaior;

Var
    nome1, nome2, nome3: string[10];
    idade1, idade2, idade3: integer;
Begin
    writeln('Nome 1:');
    readln(nome1);
    writeln('Idade 1:');
    readln(idade1);
    writeln('Nome 2:');
    readln(nome2);
    writeln('Idade 2:');
    readln(idade2);;
    writeln('Nome 3:');
    readln(nome3);
    writeln('Idade 3:');
    readln(idade3);
    if(idade1>idade2)and(idade2>idade3)then
    begin
        writeln('Maior-> ');
        writeln('Nome: ',nome1);
        writeln(' Idade: ',idade1);
        writeln('Menor-> ');
        writeln('Nome: ',nome3);
        writeln(' Idade: ',idade3);
    end
    else
    begin
        if(idade1>idade3)and(idade3>idade2)then
        begin
            writeln('Maior-> ');
            writeln('Nome: ',nome1);
            writeln(' Idade: ',idade1);
            writeln('Menor-> ');
            writeln('Nome: ',nome2);
            writeln(' Idade: ',idade2);
        end
        else
        begin
            if(idade2>idade1)and(idade1>idade3)then
            begin
                writeln('Maior-> ');
                writeln('Nome: ',nome2);
                writeln(' Idade: ',idade2);
                writeln('Menor-> ');
                writeln('Nome: ',nome3);
                writeln(' Idade: ',idade3);
            end
            else
            begin
                if(idade2>idade3)and(idade3>idade1)then
                begin
                    writeln('Maior-> ');
                    writeln('Nome: ',nome2);
                    writeln(' Idade: ',idade2);
                    writeln('Menor-> ');
                    writeln('Nome: ',nome1);
                    writeln(' Idade: ',idade1);
                end
                else
                begin
                    if(idade3>idade1)and(idade3>idade2)then
                    begin
                        writeln('Maior-> ');
                        writeln('Nome: ',nome3);
                        writeln(' Idade: ',idade3);
                        writeln('Menor-> ');
                        writeln('Nome: ',nome2);
                        writeln(' Idade: ',idade2);
                    end
                    else
                    begin
                        writeln('Maior-> ');
                        writeln('Nome: ',nome3);
                        writeln(' Idade: ',idade3);
                        writeln('Menor-> ');
                        writeln('Nome: ',nome1);
                        writeln(' Idade: ',idade1);
                    end;
                end;
            end;
        end;
    end;
End.
