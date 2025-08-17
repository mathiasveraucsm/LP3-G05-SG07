def sumar_arreglo(arreglo):
    suma = 0;
    for n in arreglo:
        suma = suma + n
    return suma

a1 = {1,2,3,4,5}
a2 = {10,20,30,40,50}

print("La suma de los elementos del Arreglo 1 es igual a:", sumar_arreglo(a1))
print("La suma de los elementos del Arreglo 2 es igual a:", sumar_arreglo(a2))
