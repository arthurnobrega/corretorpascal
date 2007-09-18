program Hello; (* As mensagens entre parênteses e asterisco são apenas comentários *)

var {aqui começa o bloco de variaveis e termina antes de begin}

    mensagem : string; (* variavel tipo string pode ser definido com o tamanho que ela deve assumir. ex. string[50] *)

begin {aqui inicia o bloco principal do programa}

    mensagem := 'Hello World!'; (* atribui a string 'HELLO WORLD' á variável mensagem *)

    write(mensagem);(* aqui escreve no prompt *)

end.(* fim do bloco de informações finais *)