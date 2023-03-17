# Laboratorio 6 de AREP

El taller consiste en la construcción de una aplicación con la arquitectura por la imagen de abajo y desplegarla en AWS usando EC2, ELB y autoescalado.

## Conceptos Básicos


### Docker


"*Docker es un proyecto de código abierto que automatiza el despliegue de aplicaciones dentro de contenedores de software, proporcionando una capa adicional de abstracción y automatización de virtualización de aplicaciones en múltiples sistemas operativos.*"


### Spark


"*Spark es un framework de computación en clúster open-source. Fue desarrollada originariamente en la Universidad de California, en el AMPLab de Berkeley.*"


### MongoDB
"*MongoDB es un sistema de base de datos NoSQL, orientado a documentos y de código abierto. En lugar de guardar los datos en tablas, tal y como se hace en las bases de datos relacionales, MongoDB guarda estructuras de datos BSON (una especificación similar a JSON) con un esquema dinámico, haciendo que la integración de los datos en ciertas aplicaciones sea más fácil y rápida.*"


### Round Robin
"*Round-robin es un método para seleccionar todos los abstractos en un grupo de manera equitativa y en un orden racional, normalmente comenzando por el primer elemento de la lista hasta llegar al último y empezando de nuevo desde el primer elemento.*"


### AWS(EC2)
*"Amazon Elastic Compute Cloud es una parte central de la plataforma de cómputo en la nube de la empresa Amazon.com denominada Amazon Web Services. EC2 permite a los usuarios alquilar computadores virtuales en los cuales pueden ejecutar sus propias aplicaciones."*

## Arquitectura

![image](https://user-images.githubusercontent.com/90571387/225793046-bef55cf8-e3af-4f76-a309-9dea436b7a73.jpg)

La solución de la arquitectura, está diseñada en dos partes, el frontend "LogService" y el backend "RoundRobinSpark"

## DESARROLLO

### Creación de las cinco instancias en AWS

![image](https://user-images.githubusercontent.com/90571387/225792798-6d43fe56-9a7d-4e99-a683-2a195c1d039f.jpg)

### Conexión del local con la instacia

Utilizamos el comando dado por aws para poder conectarnos a la maquina.

![image](https://user-images.githubusercontent.com/90571387/225793281-b577684d-04bb-4d8e-92cc-90266c8dd3e2.jpg)

### Mongo

Creamos un archivo con los datos dados en la guia de conexión a mongo y realizamos la instalación 

![image](https://user-images.githubusercontent.com/90571387/225793457-3d14841f-ab1b-4d12-b061-a3174c19c71d.jpg)

Verificamos que mongo este funcionando

![image](https://user-images.githubusercontent.com/90571387/225793504-40619a93-fb9f-404e-87dc-46c312347236.jpg)

En el archivo de mongo.conf cambiamos el bindIp a 0.0.0.0

![image](https://user-images.githubusercontent.com/90571387/225793584-5737c45e-fbd4-47ac-86ac-a4c8b76d5119.jpg)

### Configuración LogsServices

Para empezar, instalamos java 11 en cada uno de las instancias

![image](https://user-images.githubusercontent.com/90571387/225794159-dbcbdda5-1724-46a1-ad11-2bf540763e21.jpg)

Verificamos la versión de java 

![image](https://user-images.githubusercontent.com/90571387/225794290-8329d2a4-3d10-40a2-8702-08fcaf38d542.jpg)

Copiamos el archivo target generado por intellij y lo descomprimimos dentro la de maquina

![image](https://user-images.githubusercontent.com/90571387/225794495-d0749741-bc8e-4a03-ba48-1c19d80e1744.jpg)

Ejecutamos el target del proyecto

![image](https://user-images.githubusercontent.com/90571387/225794556-28e2c7b9-53dd-483a-ab4c-67de901e014a.jpg)

### RoundRobin

Creamos el metodo getURL, el cual se encarga de aleatoriamente ir enviando la ip de los log services.

![image](https://user-images.githubusercontent.com/90571387/225794819-0d4a59d7-8cf3-4860-aaaa-11b2bdb68ff0.jpg)

Copiamos nuevamente el target y lo ejecutamos de la misma manera que con los logservices

Copiamos la dirección ip de la instancia en aws junto con el puerto 27017 y verificamos que funcione

![image](https://user-images.githubusercontent.com/90571387/225795290-8e0a8089-a8d6-43e5-860c-1c86634f5adf.jpg)











