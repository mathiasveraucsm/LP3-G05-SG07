#include <iostream>
#include <vector>
using namespace std;

int sumar_arreglo(vector<int> arr) {
    int suma = 0;
    for (auto n : arr) {
        suma = suma + n;
    }
    return suma;
}

int main()
{
    vector<int> a1 = {1,2,3,4,5};
    vector<int> a2 = {10,20,30,40,50};
    cout << "La suma de elementos del Arreglo 1 es igual a: " << sumar_arreglo(a1) << endl;
    cout << "La suma de elementos del Arreglo 2 es igual a: " << sumar_arreglo(a2) << endl;
    return 0;
}
