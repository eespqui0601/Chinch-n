## El proyecto
En este repositorio he subido el codigo de mi proyecto de programación en el que nos pedian programar un juego (Chinchón) donde se pudiese jugar de 1 a 5 jugadores y se pudiese jugar con bots dn caso de que asi lo escogiese el usuario.
Tambien incluye un UML donde se ven las distintas clases, metodos y atributos.

## El juego
El Chinchón es un juego de cartas en el la idea es ser la persona con menos puntos al final de la partida para ganar. Se juega por rondas, una ronda la gana el que menos puntos tiene y para cerrarla es necesario tener dos combinaciones o un Chinchón (que es una escalera de 7 cartas del mismo palo). Para hacer una combinacion es necesario tener combinadas al menos tres cartas y se pueden hacer trios (tres cartas del mismo numero) o escaleras (estas deben de ser del mismo palo para combinar). Pierde el juego el primer jugador que llega a cien puntos, una vez que alguien pierde se termina la partida y gana el que menos puntos tenga. Cuando en una ronda se hace Chinchón en se restan diez puntos al total y cuando se hacen combinaciones los puntos de estas no cuentan para el total, solo cuentan como puntos las cartas no combinadas. 

Se reparten primero 7 cartas por jugador y se coloca una carta boca arriba en la mesa, también al lado de esta carta se coloca el resto de la baraja. La carta que se ve es el mazo de descartes. Cuando hay muchos jugadores se recomienda jugar con dos barajas ya que si no se quedan sin cartas rapidamente. Para jugar vas combinando las cartas de tu mano de la forma que se ha mencionado antes. Un turno de un jugador se juega robando una carta de la baraja (donde no sabes que te va a tocar) o robando del mazo de descartes (donde ves que te toca y te puedes servir para alguna combinacion).

Chinchón/
│
└── src/
    └── game/
        ├── Main.java
        ├── Cliente.java
        └── Producto.java

Las clases, atrubutos y metodos estan documentados en el codigo con JavaDoc.

## Descripción breve de algunas de las clases
- Main: Se encarga de ejecutar las clases y los metodos para que el juego funcione.
  
- Game: Se encarga de mostrar los mensajes por consola. 
  
- GameManager: Se encarga de manejar cuando activar Game para que muestre los mensajes por consola y de permitir al jugador tomar ciertas decisiones.
  
- Player: Se encarga de guardar la información de los jugadores (nickname, status, points, etc), tambieén maneja las cartas y los puntos de los jugadores.
  
- PlayerManager: Se encarga de crear a los jugadores.
  
- PlayerState: Es un enum que contiene los distintos estados en los que pueden encontrarse los jugadores. 
  
- Human: Se encarga de guardar los datos de los jugadores que son humanos.
  
- Bot: Se encarga de guardar los datos de los jugadores que son Bots y de tomar las decisiones del bot. 
  
- Deck: Crea y guarda las barajas y mazos que seran utilizados durante la partida.
  
- Card: Guarda los datos de cada carta individualmente.
  
- Suit: Es un enum que contiene los distintos palos de los que pueden ser las cartas y los simbolos de estos palos.
  
- Values: Es un enum que contiene los distintos valores que pueden tomar las cartas y la cantidad de puntos a las que equivalen.

## Capturas del juego
Aquí hay algunas capturas de pantallas del juego por consola: 
- <img width="322" height="106" alt="image" src="https://github.com/user-attachments/assets/4f8878d2-1369-4054-868b-2b4a7816d4f8" />
- <img width="400" height="90" alt="image" src="https://github.com/user-attachments/assets/f7bfbb1a-8821-428e-80e2-878eca584b55" />
- <img width="490" height="169" alt="image" src="https://github.com/user-attachments/assets/2953bc4b-0388-47e0-937b-65e558879d21" />

## Pruebas unitarias
Las pruebas unitarias son comprobaciones de partes pequeñas de un programa, normalmente un método o un comportamiento muy concreto. 
Se preparan los datos, se ejecuta el método y se compara el resultado obtenido con el esperado, si coinciden la prueba pasa, si no coincide falla. 
No consiste en comprobarlo manualmente, consiste en que lo compruebe de forma automatica. 

Estan las pruebas de caja blanca y las pruebas de caja negra:
- Para las pruebas de caja blanca es necesario mirar el código y saber como funciona internamente, en estas pruebas comprobaremos que funcionan los bucles y que los metodos funcionan correctamente. 

- Para las pruebas de caja negra no es necesario conocer el código, se basan en comprobar que hagan lo que se supone que deberían de hacer las clases y metodos.

En el caso de mi código he comprobado con una prueba de caja blanca que funcione el reparto de las 7 cartas iniciales, para hacer esto se necesita conocer que hay un método que te permite robar las 7 primeras cartas y además se utiliza para `probarlo un bucle. También es necesario saber que clases son necesarios para que el método funcione. 

Después he hecho una prueba de caja negra que comprueba que al robar una carta de la baraja esta no sea nula. Para esto no es necesario conocer el código solo el método que vamos a probar que funcione como debería. 

Estas pruebas se realizan para ver que las distintas partes del programa funcionen incluso de forma aislada. 
