#include <stdio.h>
#include <unistd.h>
#include <sys/types.h> 
#include <sys/stat.h> 
#include <fcntl.h>
#include <iostream>

using namespace std;

int main(int argc, char *argv[]){

    int x = 100;

    pid_t pid = fork();

    if (pid == 0){
        cout << "hello" << endl;
    }

    else if (pid > 0)
        cout << "goodbye" << endl;
    else printf("%s\n","Fork failed");

    cout << "\n";
    return 0;
}
