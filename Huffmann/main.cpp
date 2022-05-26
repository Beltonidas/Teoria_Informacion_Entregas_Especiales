#include <iostream>

using namespace std;
    struct Tupla {
        double dato;
        int pos[10];
    };

    struct SimpleCode {
        string name;
        string codeString;
        Tupla tupla;
    };

int main()
{

    cout << "Hello world!" << endl;
    Tupla tupla1 = {0.5, 0};
    Tupla tupla2= {0.2, 1};
    Tupla tupla3 = {0.1, 2};
    Tupla tupla4 = {0.1, 3};
    Tupla tupla5 = {0.1, 4};
    int Codigo_Simple[10];
    Tupla ListaTuplas[5];
    SimpleCode Simbo_code[5];

    SimpleCode code1 = {"Prueba 1", "0", tupla1};
    SimpleCode code2 = {"Prueba 2", "0", tupla2};
    SimpleCode code3 = {"Prueba 3", "0", tupla3};
    SimpleCode code4 = {"Prueba 4", "0", tupla4};
    SimpleCode code5 = {"Prueba 5", "0", tupla5};
    Simbo_code = {[code1,code2, code3,code4, code5]};
    cout << Simbo_code[10] << endl;


    return 0;
}
