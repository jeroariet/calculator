# Aplicación calculator

Aplicación encargada de realizar operación suma de 2 numeros solo para usuarios registrados

## Instrucciones de uso

- Realizar un build de la aplicación calculator.

- Ejecutar comando docker-compose up -d permite levantar la aplicación

- Ingresar a la url http://localhost:8083/swagger-ui/index.html

### Registrar registrar usuarios mediante api
[/api/auth/signup](http://localhost:8083/swagger-ui/index.html#/user-rest-controller/registerUserUsingPOST)
Ingresando en el body
~~~~
{
  "email": "string",
  "name": "string",
  "password": "string",
  "username": "string"
}
~~~~

### Iniciar sesion del usuario registrado con la api
[/api/auth/signin](http://localhost:8083/swagger-ui/index.html#/user-rest-controller/authenticateUserUsingPOST)

Pasando usuario y contraseña con la que se registro el usuario
~~~~
{
  "password": "string",
  "userOrEmail": "string"
}
~~~~
Con el usuario logueado debe pasar el token a la api de calculo de suma.

### Api para realizar calculos
[/operation/sum](http://localhost:8083/swagger-ui/index.html#/operation-rest-controller/sumUsingGET)

Pasando los 2 valores a realizar la operación
Antes de ejecutar la api debe autenticarse ingresando al candado de la api
En donde debe completarse el token con los siguiente valores
~~~~
"Bearer (token devuelto por signin)"
~~~~
### [Para consultar el historial de las operaciones realizada]()

### Api historico operaciones
[/api/history](http://localhost:8083/swagger-ui/index.html#/history-api-rest-controller/getAllPostsUsingGET)

Esta api cuenta con 4 parametro los cuales le permite paginar el resultado y realizar un ordenamiento

**pageNo** = Permite ingresar el numero de pagina a consultar. (Opcional)

**pageSize** = Permite indicar el tamaño de la pagina. (Opcional)

**sortBy** = Permite ordenar por cualquiera de los campos resultantes. (Opcional)

**sortDir** = Permite indicar el orden descendente o ascendente. (Opcional)