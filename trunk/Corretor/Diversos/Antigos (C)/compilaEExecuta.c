#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define TAMSTRING 100

//Retorna a última incidência de caractere em string, ou -1 caso não haja
int posCharString (char *string, char caractere) {
    unsigned int i, temp=-1;
    for (i=0; i<=strlen(string); i++) {
        if (string[i]==caractere)
            temp=i;
    }
    return(temp);
}

//Retorna quantos caracteres há na string a partir da posição dada, contando o '\0'
int quantosFaltam (char *posInicial) {
    int i=0;
    while (posInicial[i]!='\0')
        ++i;
    return(++i);
}

//Por enquanto, só quero que funcione... Depois enxugo a função
char** criaPastas (int argc, char **argv) {
    int i,tam,ponto;
    char temp[TAMSTRING], cmd[2*TAMSTRING+6], pasta[TAMSTRING], **retorno=(char**) malloc(argc*sizeof(char*));
    for (i=1; i<argc; i++) {
        //Fazendo o comando "mkdir <nomepasta>", onde <nomepasta> é o nome do arquivo sem o .pas
        strcpy(cmd,"mkdir ");
        tam=strlen(argv[i]);
        strcpy(temp,argv[i]);
        strcpy(pasta,argv[i]);
        pasta[ponto=posCharString(pasta,'.')]='\0';
        tam=strlen(pasta);
        retorno[i]=(char*) malloc((2+tam)*sizeof(char));
        strcpy(retorno[i],pasta);
        system(strcat(cmd,pasta));

        //Fazendo o comando "mv <arquivo.pas> <pastadoarquivo>
        retorno[i][tam=posCharString(retorno[i],'\0')]='/';
        retorno[i][tam+1]='\0';
        strcpy(cmd,"mv ");
        strcat(cmd,argv[i]);
        tam=strlen(cmd); cmd[tam]=' '; cmd[tam+1]='\0';
        system(strcat(cmd,pasta));
        argv[i][ponto]='.';
    }
    return(retorno);
}

//Como os arquivos foram movidos para novas pastas, preciso de uma nova lista de localizações dos arquivos... Aqui eu as gero
char** criaListaArquivos (char **pastas, int argc, char **argv) {
    int i,tam;
    char **retorno=(char**) malloc(argc*sizeof(char*));
    for (i=1; i<argc; i++) {
        tam=posCharString(pastas[i],'/');
        tam+=quantosFaltam(argv[i]+posCharString(argv[i],'/')+1);
        tam++;
        retorno[i]=(char*) malloc(tam*sizeof(char));
        strcpy(retorno[i],pastas[i]);
        strcat(retorno[i],&argv[i][posCharString(argv[i],'/')+1]);
    }
    return(retorno);
}

//Aqui são compilados todos os arquivos, e os que derem problema de compilação serão "marcados" com um arquivo "erros.txt" em sua pasta
void compila (char **pastas, char **arquivos, int argc) {
    int i,retorno;
    char cmd[TAMSTRING];
    for (i=1; i<argc; i++) {
        //Fazendo o comando "fpc <nomearquivo> > /dev/null" para que a tela não seja enchida de mensagens do fpc
        strcpy(cmd,"fpc ");
        strcat(cmd,arquivos[i]);
        strcat(cmd," > /dev/null");
        retorno=system(cmd);
        //Caso tenha dado problema (retorno não-nulo) é criado o arquivo erros.txt na pasta daquele aluno, e ele conterá o erro de compilação
        if (retorno) {
            strcpy(cmd,"echo \"Falha de compilação\" >> ");
            strcat(cmd,pastas[i]);
            strcat(cmd,"erros.txt");
            system(cmd);
        }
    }
}

//Aqui é criada a lista de todos os executáveis dos programas, e aqueles que não foram compilados recebem NULL
char** criaListaExecutaveis (char **pastas, char **arquivos, int argc) {
    int i,tam;
    FILE *testaErros=NULL;
    char **executaveis=(char**) malloc(argc*sizeof(char*)), temp[TAMSTRING];
    for (i=1; i<argc; i++) {
        //Aqui é testado se houve erro de compilação. Se houve, ao invés de apontar para o executável, o nó daquele trabalho apontará para NULL
        strcpy(temp,pastas[i]);
        strcat(temp,"erros.txt");
        testaErros=fopen(temp,"r");
        if (testaErros) {
            fclose(testaErros);
            executaveis[i]=NULL;
            continue;
        }

        //Aqui é criado o endereço do executável, pois se chegamos aqui, ele foi compilado com sucesso
        tam=strlen(arquivos[i]);
        executaveis[i]=(char*) malloc(tam*sizeof(char));
        strcpy(executaveis[i],arquivos[i]);
        executaveis[i][posCharString(executaveis[i],'.')]='\0';
    }
    return(executaveis);
}

//Só funciona para números maiores que zero
char* intToString (int num) {
    int temp=num, pos=0,i;
    char string1[TAMSTRING], string2[TAMSTRING], *retorno;
    while (temp) {
        string1[pos]=temp%10;
        string1[pos]+=48;
        temp/=10;
        pos++;
    }
    string1[pos]='\0';
    for (i=0; i<pos; i++)
        string2[pos-i-1]=string1[i];
    string2[pos]='\0';
    ++pos;
    retorno=(char*) malloc(pos*sizeof(char));
    strcpy(retorno,string2);
    return(retorno);
}

//Função para criar a string do nome de um arquivo no formato gabaritoX.txt, onde X é um inteiro
void criaNomeArqGabarito (int numGabarito, char *destino) {
    char nomeTemp[TAMSTRING], *num=intToString(numGabarito);
    strcpy(nomeTemp,"gabarito");
    strcat(nomeTemp,num);
    strcat(nomeTemp,".txt");
    free(num);
    strcpy(destino,nomeTemp);
}

//Função para criar a string do nome de um arquivo no formato saidaX.txt, onde X é um inteiro
void criaNomeArqSaida (int numArqResp, char *destino, char *pasta) {
    char nomeTemp[TAMSTRING], *num=intToString(numArqResp);
    strcpy(nomeTemp,pasta);
    strcat(nomeTemp,"saida");
    strcat(nomeTemp,num);
    strcat(nomeTemp,".txt");
    free(num);
    strcpy(destino,nomeTemp);
}

//Função para criar a string do nome de um arquivo no formato entradaX.txt, onde X é um inteiro
void criaNomeArqEntrada (int numArqEntrada, char *destino) {
    char nomeTemp[TAMSTRING], *num=intToString(numArqEntrada);
    strcpy(nomeTemp,"entrada");
    strcat(nomeTemp,num);
    strcat(nomeTemp,".txt");
    free(num);
    strcpy(destino,nomeTemp);
}

//Função para contar quantos gabaritos existem para um determinado trabalho
int contaGabaritos() {
    char nomeGabarito[TAMSTRING];
    int temp=0, numAtual=1;
    FILE *testeGabarito=NULL;
    while (1) {
        criaNomeArqGabarito(numAtual,nomeGabarito);
        numAtual++;
        testeGabarito=fopen(nomeGabarito,"r");
        if (testeGabarito==NULL)
            break;
        else {
            fclose(testeGabarito);
            temp++;
        }
    }
    return(temp);
}

//Função que roda os programas que foram executados com sucesso, jogando para eles as entradas devidas e criando os arquivos com as saídas
void rodaProgramas (char **pastas, char **executaveis, int argc) {
    int i,j,retorno,numGabaritos, pid;
    char cmd[TAMSTRING*2], **entradas, arqSaida[TAMSTRING], *temp, kill[TAMSTRING];
    numGabaritos=contaGabaritos();
    entradas=(char**) malloc((1+numGabaritos)*sizeof(char*));
    for (i=1; i<=numGabaritos; i++) {
        entradas[i]=(char*) malloc(TAMSTRING*sizeof(char));
        criaNomeArqEntrada(i,entradas[i]);
    }
    for (i=1; i<argc; i++) {
        if (executaveis[i]==NULL)
            continue;
        for (j=1; j<=numGabaritos; j++) {
            //Fazendo o comando "<programa> < entradaX.txt > <pasta>/saidaX.txt"
            criaNomeArqSaida(j,arqSaida,pastas[i]);
            strcpy(cmd,executaveis[i]);
            strcat(cmd," < ");
            strcat(cmd,entradas[j]);
            strcat(cmd," > ");
            strcat(cmd,arqSaida);
            strcpy(kill,"killall -q ");
            strcat(kill,executaveis[i]);

            //Se for o processo pai, esperar 1 segundo e matar o filho, para evitar congelamentos. Se for o filho, rodar o programa e sair
            if ((pid=fork())) {
                sleep(1);
                system(kill);
            }
            else {
                retorno=system(cmd);
                exit(0);
            }

            //Fazendo o comando "echo <codigoderetorno> >> <pasta>/erros.txt" para se ter controle dos códigos de saída dos trabalhos
            strcpy(cmd,"echo \"");
            temp=intToString(retorno);
            strcat(cmd,temp);
            free(temp);
            strcat(cmd,"\" >> ");
            strcat(cmd,pastas[i]);
            strcat(cmd,"erros.txt");
            system(cmd);
        }
    }
    for (i=1; i<=numGabaritos; i++)
        free(entradas[i]);
    free(entradas);
}
