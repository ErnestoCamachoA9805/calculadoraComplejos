# Escuela Colombiana de Ingeniería Julio Garavito

# Experimento de la Doble rendija
## Abstract
The goal of this experiment is to create an interference pattern using aluminum foil, a laser, some plastic cards and cutter. For achieving this, we made
some templates (squares of aluminum foil or plastic cards with an specific number of cuts in it), then we set up our laser and finally put all together.
Keywords: *double-slit; quantum mechanics; quantum computing; interference*.

## ¿Qué es el experimento de young?
El experimento de Thomas Young, mejor conocido como el experimento de la doble rendija, fue originalmente concebido para probar la naturaleza ondulatoria de la luz, el montaje del experimento se explica en la siguiente entrada, uno de los resultados del experimento usando ondas, permitió notar la interferencia que hay entre ellas al pasar por las rendijas lo que hace que se cree un patron en las zonas de impacto de estas ondas, lo que se encontro fue que para particulas pequeñas, un electrón por ejemplo, el patrón era el mismo, lo interesante es que el electrón no tenia algún otro objeto con el cual interactuar entre el que le disparaba, la rendija y el sensor, y aún asi tras repetidas pruebas también se veía el patrón de interfercia, esto supone que el electrón interfiere con su historia y da la idea de la existencia de multiples universos. 

## Descripción del experimento
El experimento de la doble rendija evidencia como, contrario a lo que se creería,
cuando un electrón (o en este caso, un haz de luz) pasa a traves de una *pared* con divisiones esta sigue su rumbo y al momento de medirla nos encontramos con que tiene *vacios* (interferencias) a lo largo de su
extensión. 
La explicación del por qué de estos vacíos ha sido materia de estudio de la fisica
desde hace mucho tiempo, hoy en día una de las aproximaciones que podemos encontrar está en la física de ondas, que nos dice que por interferencia de las mismas hay puntos en los cuales las ondas son iguales y contrarias, lo que hace que estas se *cancelen* mutuamente.
Ademas de esta teoría, podemos encontrarnos también con la que trata de explicarlo a traves de la física cuántica; donde básicamente esos vacíos son una representación en este universo de la interferencia entre las historias de dichas particulas en otros universos.


![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/Cl%C3%A1sico.jpg)
<p align="center">Pensamiento clásico del experimento</p>
<div align"center">
<img src="https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/Cu%C3%A1ntico.jpg">
</div>
<p align="center">Pensamiento y respuesta cuántica del experimento</p>

## ¿Cómo se hizo el expermiento?
Para este experimento se hicieron varios montajes y se probó con varios modelos y materiales (rejillas de acetato, de aluminio y finalmente hilo dental). <br/> <br/>
**Materiales:**
* Láser con una longitud de onda de 532 nanómetros.
* Hilo dental

## Evidencia fotográfica
### Patrones de interferencia obtenidos:
![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/DosRendijas.PNG)

![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/TresRendijas.PNG)

![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/CuatroRendijas.PNG)

![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/CincoRendijas.PNG)


# Simulación
<div align="center">
<img src="https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/Esquema.jpg">
</div>
<p align="center">Gráfico del comportamiento del sistema a simular</p>
## Simulación Java
Para el desarrollo de la simulación se usó esta librería de números complejos. El único experimento simulado resulta ser el de dos
rendijas, dado que las probabilidades eran claras, sin embargo el simulador funciona con cualquier *input* que el usuario 
ingrese, por supuesto, esto es asumiendo que el usuario ingresa una matriz con probabilidades correctas y un vector de estado inicial
correcto.

### Funciones
 #### La estructura básica de la simulación es:
 En la que se ven 2 métodos simples para pedir información, un constructor básico que hace el experimento de 2 rendijas, un método privado para llenar la matriz y el vector default. Finalmente los métodos para hacer el click y para construir un sistema que hace el usuario.
 
 ![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/EstructuraBasica.PNG) 
 
 #### Métodos de importancia
 Los métodos más importantes son el de clicks y el de build, los cuales permiten al sistema dar click y establecer un sistema definido por el usuario.
 
 ![](https://github.com/ErnestoCamachoA9805/calculadoraComplejos/blob/master/Simulacion/Simulacion/imagenes/MetodosFinales.PNG) 
 
 El método click recibe un entero que será el número de clicks que se la va a dar al sistema, los demás métodos son configuraiones del sistema, build recibe una matriz de complejos que será la matriz del sistema y un vector de complejos que será el estado inicial del sistema.

## Simulación en Python!
Esta es una simulación del ejemplo planteado en el libro guía del curso. Cabe afirmar que en el programa no se tienen en cuenta todos los aspectos neesarios y que está netamente enfocado a graficar la interferencia (como barras de altura cero) en el diagrama de barras.
### Funciones
```python
simulation(matrix, state, clicks) # Recibe una matrix compleja, un vector de estados complejo y el npumero de clicks. Retorna el vector con el estado resultante luego de la medición.
```
### Funciones auxiliares
```python
lets_graph(vector) # Grafica el vector recibido en un diagrama de barras usando la librería matplotlib.
requirements(matrix) # Verifica que la matriz sea unitaria (si es compleja) o estocástica (si es real).
```

### Informe de resultados
El informe de resultados se encuentra en Moodle y es un breve documento en LaTeX que resume algunas conclusiones del montaje y posterior prueba del experimento.

## Autores

* **Ernesto Camacho Arroyave** [Github](https://github.com/ErnestoCamachoA9805)
* **Juan David Murillo** [Github](https://github.com/juancho20sp) | [Twitter](https://twitter.com/juancho20sp)<br/>
Estudiantes en la [Escuela Colombiana de Ingeniería Julio Garavito](https://www.escuelaing.edu.co/es/) <br/>
2020 
