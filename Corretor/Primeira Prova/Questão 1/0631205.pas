program Hello; (* As mensagens entre par�nteses e asterisco s�o apenas coment�rios *)

var {aqui come�a o bloco de variaveis e termina antes de begin}

    mensagem : string; (* variavel tipo string pode ser definido com o tamanho que ela deve assumir. ex. string[50] *)

begin {aqui inicia o bloco principal do programa}

    mensagem := 'Hello World!'; (* atribui a string 'HELLO WORLD' � vari�vel mensagem *)

    write(mensagem);(* aqui escreve no prompt *)

end.(* fim do bloco de informa��es finais *)