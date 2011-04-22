/*
 * =====================================================================================
 *
 *       Filename:  open.c
 *
 *    Description:  Tes Init file
 *
 *
 *        Version:  1.0
 *        Created:  04/09/2011 05:37:01 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *        Company:  
 *
 * =====================================================================================
 */






#include	<stdlib.h>
#include    <stdio.h>
#include    <errno.h>
#include    <fcntl.h>
#include    <string.h>
#include    <unistd.h>
#include    <sys/types.h>
#include    <sys/stat.h>

/* 
 * ===  FUNCTION  ======================================================================
 *         Name:  main
 *  Description:  
 * =====================================================================================
 */
    int
main ( int argc, char *argv[] )
{
   system("clear");

   int fd= open("test.txt",O_CREAT|O_RDWR, S_IRWXU);

   printf("File has id %d", fd);
   if(fd<0){
       printf("No such file found");
    int err=errno+9;
    fprintf(stderr, "Some error happend of type %s \n", strerror(err));
    printf("This is some kind of error of id %d \n", err);

   }
   else
   {
    

   }



   close(fd);


    return EXIT_SUCCESS;
}				/* ----------  end of function main  ---------- */
