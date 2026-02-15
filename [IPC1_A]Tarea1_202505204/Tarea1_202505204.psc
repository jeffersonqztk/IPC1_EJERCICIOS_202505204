Proceso PIRAMIDEASTERISCOS
	
    Definir n,i,j Como Entero
    Definir linea Como Cadena
	
    Escribir "Ingrese la cantidad de niveles:"
    Leer n
	
    Para i <- 1 Hasta n Hacer
		
        linea <- ""
		
        // agregar espacios
        Para j <- 1 Hasta n-i Hacer
            linea <- linea + " "
        FinPara
		
        // agregar asteriscos
        Para j <- 1 Hasta (2*i-1) Hacer
            linea <- linea + "*"
        FinPara
		
        Escribir linea
		
    FinPara
	
FinProceso
