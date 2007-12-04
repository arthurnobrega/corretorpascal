#ifndef COMPILAEEXECUTA_H_
#define COMPILAEEXECUTA_H_

char** criaPastas (int argc, char **argv);
char** criaListaArquivos (char **pastas, int argc, char **argv);
void compila (char **pastas, char **arquivos, int argc);
char** criaListaExecutaveis (char **pastas, char **arquivos, int argc);
char* intToString (int num);
void criaNomeArqGabarito (int numGabarito, char *destino);
void criaNomeArqSaida (int numArqResp, char *destino, char *pasta);
void criaNomeArqEntrada (int numArqEntrada, char *destino);
int contaGabaritos();
void rodaProgramas (char **pastas, char **executaveis, int argc);

#endif
