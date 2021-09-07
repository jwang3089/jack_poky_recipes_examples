
#include <stdio.h>
#include "hello1.h"
#include <openssl/rsa.h>


struct rsa_meth_st *sample;

int main(int argc, char *argv[])
{
    printf("while (1) JACK!!!!!! Hello World!!\n");
    printf("This is a SYSTEMD example executable program run at boot up time\n");
    printf(" Argv = %s \n", argv[1]);
    printf("return (0) \n");

    return (0);
}
