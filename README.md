# Bienvenidos y bienvenidas a AprovechApp!

Se trata de una aplicación web que ofrece un servicio de gestión sustentable de descartes agrícolas para verdulerías en Mar del Plata (Argentina). Mediante este, los alimentos que, a criterio del administrador de la verdulería, no cumplan con las exigencias del mercado (por estética o por madurez), se realizan ofertas a muy bajo costo para que los clientes puedan comprarlo. 

La aplicación ha sido desarrollada como Trabajo Final de la Diplomatura en Desarrollo de Aplicaciones con Spring Boot JAVA en la UTN Universidad Tecnológica Nacional, Facultad Regional Mar del Plata.


## Características Principales
### - Registro de verdulerías
Cada administrador puede registrarse y loguearse. Para ello se utiliza Spring Security. Una vez logueado, puede registrar sus/s verdulería/s en **AprovechÁpp!** incluyendo información de interés como la dirección, el teléfono y el horario. 


### - Gestión de Ofertas:

Los verduleros pueden indicar qué productos ofrecen, en qué zona se encuentran y la duración de la oferta. Las ofertas se dan de baja automáticamente cuando expira el tiempo de disponibilidad.

### - Mapa de la ciudad

La aplicación inicia con un mapa de la ciudad en el que se presentan las ofertas vigentes en la ciudad. Este está gestionado mediante la integración de la API de Google Maps.

### - Baja automática de ofertas

Teniendo en cuenta de que se trata de productos perecederos, cada oferta debe tener una duración y, una vez que se excede este plazo la app automáticamente la da de baja.



## Tecnologías utilizadas

- **Spring Boot**: Es el Framework para el desarrollo de aplicaciones Java. Manejo de persistencia de datos con JPA.
- **Spring Security**: Gestión de la seguridad y autenticación en la aplicación. 
- **Lombok**: Para simplificar la creación de clases Java mediante anotaciones.
- **Thymeleaf**: Motor de plantillas utilizado para la capa de vista en el patrón MVC (Modelo-Vista-Controlador).


