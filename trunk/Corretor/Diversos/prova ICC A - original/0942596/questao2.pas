program questao2;
var
	dia: integer;
	valor: real;

begin
	readln (dia);
	readln (valor);
	if (26 <= dia) and (dia <= 31)
	then valor := valor;
	if (21 <= dia) and (dia <= 25)
	then valor := valor - (valor * (2/100));	
	if (16 <= dia) and (dia <= 20)
	then valor := valor - (valor * (4/100));
        if (11 <= dia) and (dia <= 15)
	then valor := valor - (valor * (6/100));
	if (6 <= dia) and (dia <= 10)
	then valor := valor - (valor * (8/100));
	if (1 <= dia) and (dia <= 5)
	then valor := valor - (valor * (1/10));
	writeln ('valor: ', valor:5:2);
	if (dia <= 0)
	then writeln ('VERIFIQUE SE A DATA ESTA CORRETA');
	if (valor <= 0)
	then writeln ('VERIFIQUE SE O VALOR ESTA CORRETO');
end.
