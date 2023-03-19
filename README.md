# Rutas en Camel

Creacion de rutas de camel basadas en payload del Consumer

## Flujo
```
                          .---> Factura valor Mayor a 100 -> ms-factura-flask
Factura --> camer-routes /
                         \
                          .-->  Factura valor Menor a 100 -> ms-factura-nestJs -> sqlite
```

## Servicio ms-factura-flask

Servicio en flask, para realizar pruebas en solitario se puede usar la colecion de
ThunderClient en:

```
 ms-factura-flask/thunder-collection_ms-factura-flask.json
```

### Iniciar servicio flask

``` 
    cd ms-factura-flask
    python3 -m venv .venv
    source .venv/bin/activate
    python3 -m pip install -r requirements.txt
    python3 main.py
```

## Servicio ms-factura-nestjs

Servicio en NestJs, para realizar pruebas en solitario se puede usar la colecion de
ThunderClient en:

```
 ms-factura-flask/thunder-collection_ms-factura-nestjs.json
```

la base de datos es: db.sqlite


### Iniciar servicio NestJs

``` 
    cd ms-factura-nestjs
    npm install
    npm run start:dev
```

# Servicio de  Ruta en Camel

Aplicativo de camel que ejecuta rutas en base al payload enviado
se puede usar la coleccion en ThuderClient para revisar el funcionamiento de la rutas en

````
 camel-rute/thunder-collection_camel-routes.json
````
### Iniciar Camel

``` 
    cd camel-rute
    ./mvnw clean package
    ./mvnw spring-boot:run
```

