#include <stdio.h>
#include <stdlib.h>
#include "compilaEExecuta.h"
#include <string.h>
#include "compara.h"

#define TAMSTRING 100

//Struct usada para armazenar os gabaritos, para não ter de se jogar na memória cada gabarito a cada aluno que for ter seu trabalho corrigido
typedef struct gabaritos {
    int numGabaritos, *numResps;
    char ***vetGabaritos;
} gabaritos;

//Função que cria a struct gabaritos, contendo todas as substrings que precisam ser buscadas, o número de gabaritos e o número de respostas contidas em cada gabarito (útil para casos de números de respostas variáveis, como em trabalhos nos quais há de se armazenar um número indefinido de dados, quando os alunos trabalham com arquivos ou vetores)
gabaritos criaVetoresGabaritos() {
    gabaritos temp;
    int i, numResps;
    FILE *gabarito=NULL;
    char nomeArqGabarito[TAMSTRING], stringTemp[TAMSTRING];
    temp.numGabaritos=contaGabaritos();
    temp.numResps=(int*) malloc((1+temp.numGabaritos)*sizeof(int));
    temp.vetGabaritos=(char***) malloc((1+temp.numGabaritos)*sizeof(char**));
    for (i=1; i<=temp.numGabaritos; i++) {
        criaNomeArqGabarito(i,nomeArqGabarito);
        gabarito=fopen(nomeArqGabarito,"r");
        numResps=1;
        temp.vetGabaritos[i]=(char**) malloc(sizeof(char*));
        temp.vetGabaritos[i][0]=(char*) malloc(TAMSTRING*sizeof(char));
        fgets(stringTemp,TAMSTRING,gabarito);
        strncpy(temp.vetGabaritos[i][0],stringTemp,strlen(stringTemp)-1);
        while (fgets(stringTemp,TAMSTRING,gabarito)) {
            numResps++;
            temp.vetGabaritos[i]=(char**) realloc(temp.vetGabaritos[i], numResps*sizeof(char*));
            temp.vetGabaritos[i][numResps-1]=(char*) malloc(TAMSTRING*sizeof(char));
            strncpy(temp.vetGabaritos[i][numResps-1],stringTemp,strlen(stringTemp)-1);
        }
        temp.numResps[i]=numResps;
        fclose(gabarito);
    }
    return(temp);
}

//Função para liberar da memória a struct gabaritos, dado que ela é muito complexa para se exigir liberação manual por toda função que a utilizar
void liberaMemoGabaritos (gabaritos temp) {
    int i,j;
    for (i=1; i<=temp.numGabaritos; i++) {
        for (j=0; j<temp.numResps[i]; j++)
            free(temp.vetGabaritos[i][j]);
        free(temp.vetGabaritos[i]);
    }
    free(temp.vetGabaritos);
    free(temp.numResps);
}

//Aqui se faz toda a comparação dos gabaritos com os arquivos de saída, descartando newlines e espaços. Na verdade, é feita uma busca pelas respostas esperadas, na ordem esperada
void criaRelatorios (char **pastas, int argc) {
    char *num, respTrabalho[10*TAMSTRING], nomeArqResps[TAMSTRING], echo[2*TAMSTRING];
    FILE *respostasTrabAluno;
    int i, j, respAtual, estahCorreto;
    gabaritos Gabaritos=criaVetoresGabaritos();
    for (i=1; i<argc; i++) {
        for (j=1; j<=Gabaritos.numGabaritos; j++) {
            criaNomeArqSaida(j,nomeArqResps,pastas[i]);
            respostasTrabAluno=fopen(nomeArqResps,"r");
            if (respostasTrabAluno==NULL)
                continue;
            respAtual=0;

            //Fazendo as comparações com o gabarito
            while (fgets(respTrabalho,10*TAMSTRING,respostasTrabAluno)) {
                if (strcasestr(respTrabalho,Gabaritos.vetGabaritos[j][respAtual]))
                    respAtual++;
                if (respAtual>=Gabaritos.numResps[j]) {
                   estahCorreto=1;
                   break;
                }
            }
            if (respAtual<Gabaritos.numResps[j])
                estahCorreto=0;
            fclose(respostasTrabAluno);

            //Fazendo o comando na forma 'echo "Xº testcase: RESULTADO" >> <pastadoaluno>/erros.txt'
            num=intToString(j);
            strcpy(echo,"echo \"");
            strcat(echo,num);
            free(num);
            strcat(echo,"º testcase: ");
            if (estahCorreto)
                strcat(echo,"PASSOU");
            else
                strcat(echo,"FALHOU");
            strcat(echo,"\" >> ");
            strcat(echo,pastas[i]);
            strcat(echo,"erros.txt");
            system(echo);
        }
    }
    liberaMemoGabaritos(Gabaritos);
}
