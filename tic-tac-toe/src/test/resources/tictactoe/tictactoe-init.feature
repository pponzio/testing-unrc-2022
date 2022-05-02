# language: es
Característica: El jugador actual hace su movimiento 


Escenario: El primer jugador realiza un movimiento poniendo una ficha en la casilla (2,2)
    Dado que la aplicación ha sido iniciada
    Y hay un juego en curso
    Y es el turno del jugador 1
    Y el jugador 1 juega con las X
    Y no hay ficha en la posición (2,2)
    Cuando el jugador 1 pone una ficha en la celda (2,2)
    Entonces el tablero tiene una X en la celda (2,2)