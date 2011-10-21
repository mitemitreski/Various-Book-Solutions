/*
 * =====================================================================================
 *
 *       Filename:  readtest.c
 *
 *    Description:
 *
 *       Version:  1.0
 *        Created:  04/09/2011 06:39:19 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (),
 *        Company:
 *
 * =====================================================================================
 */

#include	<stdlib.h>
#include    <unistd.h>
#include    <stdio.h>
#include    <errno.h>
#include    <unistd.h>
#include    <sys/types.h>
#include    <fcntl.h>
#include    <time.h>


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
  clock_t start=clock();

  int fd=open("test.txt", O_RDWR);
  int fw=open("testout.txt",O_CREAT|O_RDWR );


  ssize_t ret;
  ssize_t wret;


  char *buf=malloc(sizeof(char));
  while(((ret=read(fd, buf, sizeof(char)))!=0)){
    if(ret==-1){
        if(errno==EINTR) continue;
            perror("read");
            break;
        }
    wret=write(fw, buf, sizeof(char));
    printf("%s", buf);

  }
    close(fd);
    free(buf);
    printf("Full exec time is %f", (double)(clock()));
    return EXIT_SUCCESS;
}				/* ----------  end of function main  ---------- */
