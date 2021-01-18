# The Movie Db API Test

Aplicación para navegar listas de peliculas, haciendo uso de la API pública de [TheMovieDB]

## Funcionalidades:
- Lista de peliculas por mejor valoradas: Muestra una cuadrícula de titulos de películas que es actualizada cada vez que se llega al tope de elementos almacenados en la base de datos local
### Detalles tecnicos de la aplicación:
#### Librerias:
- Kotlin como lenguaje de programación
- Kotlin Coroutines como solución para realizar peticiones en segundo plano y comunicación de flujos de eventos
- Hilt/Dagger 2 - Inyección de dependencias
- Room - ORM para SQLite como solución para almacenamiento de datos para uso Offline
- Glide - Para carga de imágenes desde URL
- Retrofit - Para peticiones hacia la API de [TheMovieDB]
- GSON - Para la deserialización de datos obtenidos de la API
#### Arquitectura:
- MVVM
- Repository

## TODO:
### Detalles Técnicos
- Implementar manejo de errores : Con un mejor manejo y conocimiento de la API, se podría usar un tipo de dato que englobe tanto errores, como datos obtenidos exitosamente y mostrar las interfaces de acuerdo a ello
- Pruebas unitarias
### Pantallas:
- Lista de películas por popularidad
- Lista de series por mejor valoradas
- Lista de series por popularidad
- Busqueda de peliculas/series
- Detalle de películas

Todas podrían ser implementada de manera similar a la pantalla de películas mejor valoradas.

[TheMovieDB]: (https://www.themoviedb.org/)