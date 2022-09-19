# Spotify API

## Descripción del Proyecto

Esta API está pensada enteramente, como una forma de entrenamiento para el desarrollo
de un proyecto Maven en Spring Boot, tomando el caso de uso de la tan conocida aplicación de **Spotify**.

## Persistencia de Datos

Usando como persistencia una base de datos relacional SQL,
para este caso se utilizará el gestor de MySQL y el driver que conectará la API con la BBDD.

Se pensó en este caso, desplegar la BBDD mediante el siguiente diagrama entidad-relación:

![Alt text](img/Spotify_DER.png?raw=true)

- **NT 1:** En la carpeta 'sql' del repositorio se encuentra el daigrama maquetado en MySQL Workbench
  y el script de la BBDD, **es necesario tener instalado MySQL 8.0 o superior en el equipo** y correr dicho
  script antes de iniciar el proyecto Spring Boot.


- **NT 2:** En este script ya se insertan ciertos datos en la BBDD para poder practicar
  CRUD de sobre estos mismos.
