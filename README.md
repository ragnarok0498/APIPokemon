![alt](./resources/images/banner.png)

# Demo 



Prueba técnica

Crear una aplicación Java, la cual:

\- Debe tener una arquitectura de tres niveles - Debe consumir el API RESTful https://pokeapi.co/api/v2/pokemon

\- Debe traer los resultados paginados

\- Debe exponer los resultados en un servicio SOAP y poderse consumir por SOAP UI

\- Debe aplicar dos patrones de diseño y sustentar su uso



## Informacion

Se crea un proyecto Java (Maven) con JDK 11



1. **Factory Method (Método de Fábrica)**: El método `getPokemons` podría considerarse como un tipo de Factory Method. Este método se encarga de crear instancias de objetos `Pokemon` a partir de la respuesta JSON obtenida del servicio REST.
2. **Data Transfer Object (DTO)**: En el código, el objeto `Pokemon` actúa como un Data Transfer Object (DTO) que se utiliza para representar los datos obtenidos de la respuesta JSON. Los DTOs se utilizan para transportar datos entre diferentes componentes de una aplicación.





__William Vasquez ® Developer's Guide.__

![footer](./resources/images/final.png)