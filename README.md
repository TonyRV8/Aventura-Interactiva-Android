# 🎮 Aventura Interactiva - Android

Una aplicación Android de aventura interactiva donde el usuario puede explorar diferentes locaciones y entrar a otras dimensiones.

## 📋 Descripción

Esta aplicación es una aventura interactiva desarrollada en Android que permite al usuario sumergirse en un mundo cúbico. A través de múltiples pantallas y opciones, el jugador navega por diferentes escenarios.
**Cambio de tema Oscuro/Claro** Simplemente basta con activar el boton switch y se mantendrá guardado.

### Características principales:
- **Interfaz intuitiva**: Diseño limpio y fácil de navegar
- **Transiciones fluidas**: Animaciones suaves entre pantallas
- **Sistema de temas**: Modo claro y oscuro con persistencia
- **SharedPreferences**: Almacenamiento de preferencia de tema

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
   - **ThemeManager**: Singleton que maneja el estado global del tema
   - **SharedPreferences**: Persistencia local de preferencias
   - **Activity Lifecycle**: Los temas se aplican en onCreate() antes de setContentView()

4. **Interfaz de usuario**
   - Layouts responsivos usando `ConstraintLayout`
   - Botones estilizados con drawables personalizados
   - Diseño Material Design para consistencia visual


## 🔧 Retos y Soluciones

### Reto 1: Navegación de regreso desde el Nether y el End
**Problema**: Inicialmente, los usuarios podían viajar del Overworld al Nether y del Overworld al End, pero no había manera de regresar. Una vez que ingresaban a estas dimensiones, quedaban atrapados sin poder volver al Overworld, lo que rompía el flujo de la aventura y limitaba las opciones de exploración del jugador.

**Solución**: Se implementaron botones y opciones de navegación adicionales en las actividades del Nether y el End que permiten al usuario regresar al Overworld. Se configuraron los Intents correspondientes para que la transición de regreso fuera fluida y mantuviera la continuidad de la historia. Además, se agregó la lógica necesaria en el ciclo de vida de las actividades para garantizar que el estado del juego se preserve correctamente al regresar.

### Reto 2: Visualización y ajuste de tamaño de imágenes GIF
**Problema**: Al intentar mostrar imágenes GIF animadas en la aplicación, estas no se visualizaban correctamente o aparecían distorsionadas, sin respetar su tamaño original. Esto afectaba la experiencia visual y la inmersión del jugador en la aventura, ya que los GIFs son elementos importantes para dar vida a las diferentes dimensiones.

**Solución**: Se investigó sobre las bibliotecas disponibles para manejar GIFs en Android y se implementó Glide, una biblioteca de carga de imágenes optimizada. Se configuró Glide para cargar los GIFs de manera eficiente y se ajustaron los parámetros del ImageView en los layouts XML para que respetaran las dimensiones originales de las imágenes. También se utilizaron los atributos adecuados de escala (scaleType) para mantener la proporción correcta sin distorsión, logrando que los GIFs se vean nítidos y con el tamaño apropiado en diferentes tamaños de pantalla.


## 🛠️ Tecnologías utilizadas

- **Lenguaje**: Java
- **IDE**: Android Studio
- **Herramientas**: Git, Gradle

## 👨‍💻 Autor

**Tony RV** - [TonyRV8](https://github.com/TonyRV8)

---

## 🎬 Video Demostrativo

[![Ver Demo](https://img.shields.io/badge/▶️-Ver_Demo_en_YouTube-red?style=for-the-badge&logo=youtube)](https://youtube.com/shorts/lV8JLI6Z8EU)

## 📸 Capturas de pantalla

### Overworld
![Imagen de WhatsApp 2025-10-02 a las 14 24 26_38b35550](https://github.com/user-attachments/assets/218afa3e-cb7f-4db1-8043-68ca4bfdba2f)
![Imagen de WhatsApp 2025-10-02 a las 14 24 27_de35a10e](https://github.com/user-attachments/assets/405af2b8-2313-46de-a987-a4b5b4c9c17c)
![Imagen de WhatsApp 2025-10-02 a las 14 24 27_32a68012](https://github.com/user-attachments/assets/a14d9720-656a-4ef0-bf68-b8c68be30193)


### Nether
![Imagen de WhatsApp 2025-10-02 a las 14 24 27_5584a2a0](https://github.com/user-attachments/assets/4cb7df4e-23db-4a60-92e3-64418f575401)
![Imagen de WhatsApp 2025-10-02 a las 14 24 27_3fba0f52](https://github.com/user-attachments/assets/49548190-03f3-40bb-92c4-2106f58d8ca0)

### End
![Imagen de WhatsApp 2025-10-02 a las 14 24 27_412300d1](https://github.com/user-attachments/assets/b3729fac-9205-49ea-813d-26141d3d04f9)
![Imagen de WhatsApp 2025-10-02 a las 14 24 27_b4ffe054](https://github.com/user-attachments/assets/f4df35ad-9cee-4177-92a8-018904555090)


---





⭐ Si te gustó este proyecto, ¡dale una estrella en GitHub!
