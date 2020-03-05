# Escuela Colombiana de Ingenieria Julio Garavito

# Experimento de la Doble rendija
## Abstract
The goal of this experiment is to create an interference pattern using aluminum foil, a laser, some plastic cards and cutter. For achieving this, we made
some templates (squares of aluminum foil or plastic cards with an specific number of cuts in it), then we set up our laser and finally put all together.
Keywords: double-slit; quantum mechanics; quantum computing; interference.

## Descripcion del experimento
El experimento de la doble rendija evidencia como, contrario a lo que se creer´ıa,
cuando una onda pasa a traves de una ”pared” con divisiones esta sigue su rumbo ´
y al momento de medirla nos encontramos con que tiene ”vacios” a lo largo de su
extension. ´
La explicacion del por qu ´ e de estos vac ´ ´ıos ha sido materia de estudio de la fisica
desde hace mucho tiempo, hoy en d´ıa la mejor aproximacion que podemos encon- ´
trar esta en la fısica de ondas, que nos dice que por interferencia de las mismas hay
puntos en los cuales las ondas son iguales y contrarias, lo que hace que ´ estas se ´
”cancelen” mutuamente.
Ademas de esta teor ´ ´ıa, podemos encontrarnos tambien con la que trata de expli- ´
carlo a traves de la f ´ ´ısica cuantica; donde b ´ asicamente esos vac ´ ´ıos son una representacion´ en este universo de la interferencia entre las historias de dichas particulas
en otros universos.

![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/DosRendijas.PNG)

![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/TresRendijas.PNG)

![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/CuatroRendijas.PNG)

![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/CincoRendijas.PNG)



# Simulacion
Para el desarrollo de la simulación se usó esta librería de números complejos. El único experimento simulado resulta ser el de dos
rendijas, dado que las probabilidades eran claras, sin embargo el simulador funciona con cualquier *input* que el usuario 
ingrese, por supuesto, esto es asumiendo que el usuario ingresa una matriz con probabilidades correctas y un vector de estado inicial
correcto.

# Funciones
 ## La estructura basica de la simulacion es:
 En la que se ven 2 metodos simples para pedir informacion, un constructor basico que hace el experimento de 2 rendijas, un metodo privado para llenar la matriz y el vector default, y finalmente los metodos para hacer el click y para construir un sistema que hace el usuario
 
 ![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/EstructuraBasica.PNG) 
 
 ## Metodos de importancia
 los metodos mas importantes son el de clicks y el de build, los cuales permiten al sistema dar click y establecer un sistema definido por el usuario
 
 ![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/MetodosFinales.PNG) 
 
 el metodo click recibe un entero que sera el numero de click que se la va a dar al sistema, los demas metodos son configuraiones del sistema, build recibe una matriz de complejos que sera la matriz del sistema y un vector de complejos que sera el estado inicial del sistema.

### Informe de resultados
El informe de resultados se encuentra en Moodle y es un breve documento en LaTeX que resume algunas conclusiones del montaje y posterior prueba del experimento.

## Autores

* **Ernesto Camacho Arroyave** [Github](https://github.com/ErnestoCamachoA9805)
* **Juan David Murillo** [Github](https://github.com/juancho20sp) | [Twitter](https://twitter.com/juancho20sp)<br/>
Estudiantes en la [Escuela Colombiana de Ingeniería Julio Garavito](https://www.escuelaing.edu.co/es/) <br/>
2020 
