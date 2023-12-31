# Documentación Proyecto JAVA

En la presente documentación, se describen los puntos a evaluar y los endpoints con la solución.

## [Tarea 1] Exponer CRUD para crear un driver
#### CREATE DRIVER
```
[POST] localhost:8090/api/v1/drivers
 
 Objeto de ejemplo:
 
 {
   "code": "999",
   "name": "999DRIVER999",
   "cellphone": "999999",
   "email": "driver@driverdeejemplo.com",
   "enabled": true
 }
```
#### READ DRIVERS
```
[GET] http://localhost:8090/api/v1/drivers
```
#### READ A DRIVER
```
[GET] http://localhost:8090/api/v1/drivers/{uuid}
```
#### UPDATE DRIVER
```
[PUT] http://localhost:8090/api/v1/drivers/{uuid}

 Objeto de ejemplo:
 
 {
   "code": "999UPDATED",
   "name": "999DRIVER999UPDATED",
   "cellphone": "999999UPDATED",
   "email": "driver@driverdeejemplo.com",
   "enabled": true
 }
```
#### DELETE DRIVER
```
[DELETE] http://localhost:8090/api/v1/drivers/{uuid}
```

## [Tarea 2] Exponer CRUD para crear un truck
#### CREATE TRUCK
```
[POST] localhost:8090/api/v1/trucks
 
 Objeto de ejemplo:
 
 {
   "code": "999TRUCK999",
   "enabled": true
 }
```
#### READ TRUCKS
```
[GET] http://localhost:8090/api/v1/trucks
```
#### READ A TRUCK
```
[GET] http://localhost:8090/api/v1/trucks/{uuid}
```
#### UPDATE TRUCK
```
[PUT] http://localhost:8090/api/v1/trucks/{uuid}

 Objeto de ejemplo:
 
 {
   "code": "999TRUCKUPDATED",
   "enabled": true
 }
```
#### DELETE TRUCK
```
[DELETE] http://localhost:8090/api/v1/trucks/{uuid}
```

## [Tarea 3] Exponer endpoint que permita registrar un paquetes con sus respectivos productos.
```
[POST]  localhost:8090/api/v1/packages

 Objeto de ejemplo:
 
 {
   "code": "111",
   "weight": 14.2,
   "schedule": "2023-09-06T03:51:56.975Z",
   "status": "LOADED",
   "products": [{
     "code": "PRODUCTO1",
     "weight": 11,
     "sku": "11",
     "quantity": 11,
     "is_deleted": false,
     "deleted_at": ""
   },
   {
     "code": "PRODUCTO2",
     "weight": 22,
     "sku": "22",
     "quantity": 22,
     "is_deleted": false,
     "deleted_at": ""
   }]
 }
```

## [Tarea 4] Exponer endpoint que permita eliminar productos de un paquete si y solo si el paquete se encuentre en estado LOADED.
```
[DELETE] localhost:8090/api/v1/packages-products/{uuid}
```

## [Tarea 5] Exponer endpoint que permita cambiar el estado de un paquete.
```
[PATCH] localhost:8090/api/v1/packages/{uuid}

 Objeto de ejemplo (aunque se le envíen mas parámetros, sólo actualizará el status):
 {
    "status": "CANCELED"
 }

```

## [Tarea 6] Adicionar Swagger a un controller.
```
  // Para evaluar, favor revisar API Trucks y Drivers, son las api mas completas. 
  http://localhost:8090/swagger-ui/
```

## [OPCIONALES 1] Exponer endpoint que dado un uuid del driver, evalue si tiene sus paquetes gestionados (es decir, todos los paquetes con estado DELIVERED o CANCELLED).
```
  // Este endpoint funciona pero no es eficiente.
  // Debido a que al tratar de acceder desde la relación se producia un StackOverflow.
  
  [GET] localhost:8090/api/v1/drivers/managed-packages/{uuid_driver}
```
## [OPCIONALES 2] ~~Adicionar pruebas unitarias a los componentes donde esté alojada la logica de negocio.~~

## [OPCIONALES 3]Adicionar seguridad.

## Base de datos H2
```
  http://localhost:8090/h2-console/
```
