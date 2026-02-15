Algoritmo NumeroPrimo
	
    Definir n, i Como Entero
    Definir esPrimo Como Logico
    
    Escribir "Ingrese un numero:"
    Leer n
    
    Si n <= 1 Entonces
        Escribir "El numero no es primo"
    Sino
        
        esPrimo <- Verdadero
        
        Para i <- 2 Hasta Trunc(RC(n)) Hacer
            
            Si esPrimo Entonces
                
                Si n MOD i = 0 Entonces
                    Escribir "El numero no es primo"
                    esPrimo <- Falso
                FinSi
                
            FinSi
            
        FinPara
        
        Si esPrimo Entonces
            Escribir "El numero es primo"
        FinSi
        
    FinSi
    
    Escribir "Presione ENTER para salir..."
    Leer i
	
FinAlgoritmo
