# 🎮 Aventura Interactiva - Android

Una aplicación Android de aventura interactiva donde el usuario puede explorar diferentes locaciones y entrar a otras dimensiones.

## 📋 Descripción

Esta aplicación es una aventura interactiva desarrollada en Android que permite al usuario sumergirse en un mundo cúbico. A través de múltiples pantallas y opciones, el jugador navega por diferentes escenarios.

### Características principales:
- **Interfaz intuitiva**: Diseño limpio y fácil de navegar
- **Transiciones fluidas**: Animaciones suaves entre pantallas

## 🚀 Instrucciones para ejecutar el proyecto

### Requisitos previos:
- **Android Studio** (versión Arctic Fox o superior recomendada)
- **JDK** 8 o superior
- **Android SDK** con API level [XX] o superior
- Dispositivo Android o emulador con Android [versión mínima]

### Pasos para ejecutar:

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/TonyRV8/Aventura-Interactiva-Android.git
   ```

2. **Abrir el proyecto en Android Studio**
   - Abre Android Studio
   - Selecciona "Open an existing project"
   - Navega a la carpeta del proyecto clonado
   - Espera a que Gradle sincronice las dependencias

3. **Configurar el emulador o dispositivo físico**
   - Para emulador: Ve a `Tools > Device Manager` y crea un dispositivo virtual
   - Para dispositivo físico: Habilita las opciones de desarrollador y la depuración USB

4. **Ejecutar la aplicación**
   - Presiona el botón "Run" (▶️) o usa `Shift + F10`
   - Selecciona tu dispositivo o emulador
   - Espera a que la aplicación se instale y se ejecute

## 🎨 Decisiones de diseño

### Arquitectura de la aplicación:
- **Patrón de diseño**: [MVVM / MVC / otro]
- **Organización del código**: Separación clara entre actividades, recursos y lógica de negocio
- **Gestión de recursos**: Uso de strings.xml para textos y colors.xml para paleta de colores

### Mecanismos de transición:

1. **Navegación entre pantallas**
   - Uso de `Intents` explícitos para transiciones entre actividades
   - Implementación de `startActivity()` para cambiar de escena

2. **Animaciones**
   - Transiciones personalizadas entre actividades usando `overridePendingTransition()`
   - Animaciones de fade in/fade out para mejorar la experiencia visual
   - [Agregar otras animaciones específicas]

3. **Gestión del estado**
   - Uso de `Bundle` en `onSaveInstanceState()` para preservar el progreso
   - Variables globales o SharedPreferences para persistencia de datos [si aplica]

4. **Interfaz de usuario**
   - Layouts responsivos usando `ConstraintLayout`
   - Botones estilizados con drawables personalizados
   - Diseño Material Design para consistencia visual

### Paleta de colores:
- **Color primario**: [#XXXXXX] - Utilizado en la barra de acción y elementos principales
- **Color secundario**: [#XXXXXX] - Para botones y elementos de acción
- **Color de fondo**: [#XXXXXX] - Mantiene la legibilidad y atmósfera de la aventura

## 🔧 Retos y Soluciones

### Reto 1: Navegación de regreso desde el Nether y el End
**Problema**: Inicialmente, los usuarios podían viajar del Overworld al Nether y del Overworld al End, pero no había manera de regresar. Una vez que ingresaban a estas dimensiones, quedaban atrapados sin poder volver al Overworld, lo que rompía el flujo de la aventura y limitaba las opciones de exploración del jugador.

**Solución**: Se implementaron botones y opciones de navegación adicionales en las actividades del Nether y el End que permiten al usuario regresar al Overworld. Se configuraron los Intents correspondientes para que la transición de regreso fuera fluida y mantuviera la continuidad de la historia. Además, se agregó la lógica necesaria en el ciclo de vida de las actividades para garantizar que el estado del juego se preserve correctamente al regresar.

### Reto 2: Visualización y ajuste de tamaño de imágenes GIF
**Problema**: Al intentar mostrar imágenes GIF animadas en la aplicación, estas no se visualizaban correctamente o aparecían distorsionadas, sin respetar su tamaño original. Esto afectaba la experiencia visual y la inmersión del jugador en la aventura, ya que los GIFs son elementos importantes para dar vida a las diferentes dimensiones.

**Solución**: Se investigó sobre las bibliotecas disponibles para manejar GIFs en Android y se implementó Glide, una biblioteca de carga de imágenes optimizada. Se configuró Glide para cargar los GIFs de manera eficiente y se ajustaron los parámetros del ImageView en los layouts XML para que respetaran las dimensiones originales de las imágenes. También se utilizaron los atributos adecuados de escala (scaleType) para mantener la proporción correcta sin distorsión, logrando que los GIFs se vean nítidos y con el tamaño apropiado en diferentes tamaños de pantalla.

## 📱 Estructura del proyecto

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/[paquete]/
│   │   │   ├── MainActivity.java
│   │   │   ├── [OtrasActividades].java
│   │   │   └── ...
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   └── ...
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   ├── colors.xml
│   │   │   │   └── themes.xml
│   │   │   └── drawable/
│   │   └── AndroidManifest.xml
│   └── ...
└── build.gradle
```

## 🛠️ Tecnologías utilizadas

- **Lenguaje**: Java
- **IDE**: Android Studio
- **SDK mínimo**: Android [versión]
- **SDK objetivo**: Android [versión]
- **Herramientas**: Git, Gradle

## 👨‍💻 Autor

**Tony RV** - [TonyRV8](https://github.com/TonyRV8)

---

## 📸 Capturas de pantalla

### Overworld
![Imagen de WhatsApp 2025-10-01 a las 15 02 20_1f1a584a](https://github.com/user-attachments/assets/f7cac2ae-dc47-492c-9dfe-2fff40f6c27f)
![Imagen de WhatsApp 2025-10-01 a las 15 02 21_6e1dd2d3](https://github.com/user-attachments/assets/258bc3a5-44af-4b43-897f-e71124c95873)

![Imagen de WhatsApp 2025-10-01 a las 15 02 19_d0443e01](https://github.com/user-attachments/assets/188c55e5-6366-4233-8ab0-1132163afb66)

### Nether
![Imagen de WhatsApp 2025-10-01 a las 15 02 21_6b5db13b](https://github.com/user-attachments/assets/fda26492-cc79-440c-a5b2-044f7c73c939)
![Imagen de WhatsApp 2025-10-01 a las 15 02 22_f3b43e91](https://github.com/user-attachments/assets/f09a9953-85cc-4811-b3d2-9d53d93ee011)

### End
![Imagen de WhatsApp 2025-10-01 a las 15 02 21_1957324e](https://github.com/user-attachments/assets/fd56d062-1421-4f61-aced-74bc88050b98)
![Imagen de WhatsApp 2025-10-01 a las 15 02 22_cd2bea18](https://github.com/user-attachments/assets/8b753b7a-870d-470b-bcc9-892e3f92234b)


---

⭐ Si te gustó este proyecto, ¡dale una estrella en GitHub!
