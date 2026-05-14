# Herramienta de apoyo utilizada

- **Plataforma:** ChatGPT
- **Versión de acceso:** Plan gratuito (Free)

# 📝 Prompt utilizado 

```text
Estoy desarrollando un proyecto en Java para mi materia de Programación Avanzada. 
Necesito revisar y mejorar mi código de concurrencia con hilos.

Mi programa busca una palabra dentro de una matriz de Strings, donde cada hilo procesa una fila distinta de la matriz.

Requisitos del ejercicio:

1. Se permite usar Thread, Runnable o Lambdas.
2. El hilo principal debe esperar a que todos los hilos terminen usando sincronización.
3. Cada hilo debe recibir su fila y la palabra a buscar, realizar un conteo parcial y devolver el resultado.
4. El hilo principal debe consolidar todos los resultados.
5. Debe existir manejo adecuado de excepciones.
6. La salida del programa debe mostrar:
   - Inicio de búsqueda concurrente
   - Resultado individual de cada hilo
   - Resultado total final

Quiero que analices mi código actual, detectes mejoras y propongas cambios aplicando buenas prácticas de programación orientada a objetos, encapsulamiento, legibilidad y estructura profesional, manteniendo mi lógica original.
```

---


# Matriz utilizada en las pruebas

```java
String[][] matriz = {
    {"Java", "Python", "Java"},
    {"C++", "Java", "Go"},
    {"Java", "Rust", "Java"}
};
```

Palabra buscada:

```java
"Java"
```

---

# Cambios y mejoras realizadas

## 1️ Creación e identificación de hilos

En la versión inicial, los hilos se creaban sin nombre.

### Código original

```java
hilos[i] = new Thread(tareas[i]);
```

### Código mejorado

```java
hilos[i] = new Thread(tareas[i], "Hilo-" + i);
```

### Mejora realizada

Ahora cada hilo tiene un identificador único:

- Hilo-0
- Hilo-1
- Hilo-2

Esto permite:

- Identificar fácilmente qué hilo está trabajando.
- Facilitar pruebas y depuración.
- Mostrar una salida más profesional.

---

## 2️ Mejora del mensaje inicial

Se actualizó el mensaje mostrado al iniciar la ejecución.

### Código original

```java
System.out.println("Buscando la palabra: " + palabraBuscada);
```

### Código mejorado

```java
System.out.println(
    "Iniciando búsqueda concurrente del término: \"" 
    + palabraBuscada + "\""
);
```

### Mejora realizada

Se cumple exactamente con el formato solicitado en la evaluación.

---

## 3️ Sincronización entre hilos

Se implementó correctamente la espera del hilo principal usando `join()`.

### Implementación

```java
for (Thread hilo : hilos) {
    hilo.join();
}
```

### Mejora realizada

Garantiza que:

- Todos los hilos terminen su ejecución.
- Los resultados parciales estén completos.
- El resultado final sea correcto.

---

## 4️ Encapsulamiento de atributos

En la versión inicial, los atributos eran públicos.

### Código original

```java
public String[] fila;
public String palabra;
public int contador;
```

### Código mejorado

```java
private String[] fila;
private String palabra;
private int contador;
```

### Mejora realizada

Aplicación de buenas prácticas de Programación Orientada a Objetos:

- Protección de datos.
- Mayor seguridad.
- Mejor diseño del código.

---

## 5️ Comunicación entre hilos

Cada hilo devuelve su resultado parcial mediante un método getter.

### Implementación

```java
public int getContador() {
    return contador;
}
```

### ✅ Mejora realizada

El hilo principal puede obtener y consolidar todos los resultados.

---

## 6️ Consolidación del resultado global

Se suman los resultados parciales obtenidos por cada hilo.

### Implementación

```java
int total = 0;

for (BusquedaPalabra tarea : tareas) {
    total += tarea.getContador();
}
```

### Mejora realizada

Permite obtener el total exacto de coincidencias.

---

## 7️  Manejo de excepciones

Se mejoró la gestión de errores tanto en los hilos como en el proceso principal.

### En los hilos

```java
catch (Exception e) {
    System.out.println(
        "Error en "
        + Thread.currentThread().getName()
        + ": "
        + e.getMessage()
    );
}
```

### En el hilo principal

```java
catch (InterruptedException e) {
    System.out.println(
        "Error de sincronización: "
        + e.getMessage()
    );
}
```

### Mejora realizada

Permite:

- Evitar cierres inesperados.
- Detectar errores con mayor facilidad.
- Mejor estabilidad del programa.

---

## 8️  Formato de salida estandarizado

Se modificó la impresión para cumplir con el resultado solicitado.

### Salida del programa

```bash
Iniciando búsqueda concurrente del término: "Java"

Hilo-0 finalizado. Encontrados: 2
Hilo-1 finalizado. Encontrados: 1
Hilo-2 finalizado. Encontrados: 2

----------------------------------------------
Resultado Total: La palabra "Java" aparece 5 veces.
```

### Mejora realizada

La salida cumple exactamente con la rúbrica del examen.

---

# Tecnologías utilizadas

- :contentReference[oaicite:0]{index=0}
- Programación concurrente
- Clase `Thread`
- Interfaz `Runnable`
- Programación Orientada a Objetos

---

# Resultado obtenido

Después de implementar las mejoras:

✅ Cada hilo procesa una fila de forma independiente.  
✅ El hilo principal sincroniza la ejecución correctamente.  
✅ Se obtiene el resultado exacto.

## Resultado final:

**La palabra `"Java"` aparece un total de `5 veces`.**

---

