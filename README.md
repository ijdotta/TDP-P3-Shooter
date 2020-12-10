# _Pâtisserie Nightmare_ :joystick:

Juego del estilo "Vertical Shooter". 

*Un pastelero se encontraba probando una nueva receta para atraer más clientes, pero accidentalmente creó una
dona mutante que pronto contagió a los demás pasteles. Ahora debe lanzarles tenedores para salvarse.*

## Observaciones :eyes:

### Interacción del jugador
* Se utilizan las felchas de dirección (izquierda y derecha) del teclado para el movimiento del jugador.
* Los disparos se efectúan con la barra espaciadora.

### Niveles
* Cada nivel configura un escenario de juego:
- Determina la cantidad de infectados,
- Determina los tipos de infectados,
- Determina los tipos de premios,
- Otros aspectos, como el escenario.
* En la versión actual solo hay *dos* niveles - al completarlos, finaliza el juego.
* Se pasa de nivel automáticamente al finalizar el actual.

### Premios
* Dependen de cada nivel.
* Solo pueden aparecer luego de matar un infectado.
* Pueden no siempre aparecen: tienen una probabilidad determinada por el infectado que recibe el impacto - *en general, 33% de probabilidades de salir*.

### Infectados
* Los tipos y cantidad de infectados dependen del nivel.
* Solo hay 2 niveles, al derrotar la segunda tanda de este nivel, se gana el juego.
* Cuando alguno excede el límite inferior del área de juego vuelve a aparecer en la parte superior, en una
posición relativa a la del jugador.

## Autores :busts_in_silhouette:
* Agustín Emanuel Gonzalez Díaz
* Ignacio Joaquín Dotta
* Stefano Miguel Pitto
