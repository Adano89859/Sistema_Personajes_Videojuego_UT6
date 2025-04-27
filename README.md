# ACTIVIDAD DE LA UT6 DE PROGRAMACIÓN: VIDEOJUEGO FANTÁSTICO

# INTRODUCCIÓN:
Esta actividad consiste en crear una simulación básica de un videojuego fantástico, donde los personajes que se ambientan son de tipo físico: (guerreros, arqueros y asesinos) y tipo mágicos como: (hechizeros y magos), todos con cada una de sus estadísticas únicas asociadas que combatirán entre sí, los enfrentamientos discurrirán entre personajes diferentes o del mismo tipo, teniendo en cuenta que si dos personajes son del mismo tipo ej: asesino vs asesino, se mirará que sean diferentes en todo momento independientemente de sus estadísticas para evitar errores.  


# PARTES DE LA APLICACIÓN (MODELO MVC):

# MODELO:
En esta parte, se recogen las interfaces y se desarrollan los personajes, cada uno con sus atributos, especificaciones y acciones, cada uno hedera de diferentes interfaces pero también heredan de un único objeto adaptado al tipo de personaje tipo (fisico o mágico), en cada clase de personaje hay métodos para distinguirlos si se da el enfrentamiento entre 2 personajes del mismo tipo y género Ej:(Asesino vs Asesino).

# CONTROLADOR:
Es en donde se recoge toda la lógica del sistema, se crea una clase juego donde se juntan todos los personajes, atributos y métodos a utilizar unos con otros, es el propio juego en sí, donde se recogen toda la funcionalidad y los sucesos. 

# APP (MAIN):
En la parte ejecutable de sistema, creamos ua lista (ArrayList) de los personajes y creamos los objetos personajes fisicos y personajes mágicos.

# CREADO POR: Adán Romero y Kevin Raseg ©2025. @1ºB-DAM