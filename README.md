# 📝 SimpleNotesApp

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![ViewBinding](https://img.shields.io/badge/ViewBinding-4CAF50?style=for-the-badge&logo=android&logoColor=white)
![ViewModel](https://img.shields.io/badge/ViewModel-FF6F00?style=for-the-badge&logo=android&logoColor=white)
![SharedPreferences](https://img.shields.io/badge/SharedPreferences-9C27B0?style=for-the-badge&logo=android&logoColor=white)

Una aplicación Android sencilla pero completa para tomar, guardar y gestionar notas personales.

## 🎓 Información Académica

**Materia:** Tecnologías y Aplicaciones Móviles  
**Institución:** Facultad de Ingeniería Eléctrica y Electrónica  
**Universidad:** Universidad Veracruzana  

### 👨‍💻 Autores
- **Michell Alexis Policarpio Morán**
- **Luis Fernando Bravo Ibáñez**

---

## 📋 Descripción del Proyecto

Aplicación Android desarrollada como proyecto académico que permite a los usuarios crear, visualizar y eliminar notas de manera intuitiva. La app implementa las mejores prácticas de desarrollo Android moderno con persistencia de datos y adaptabilidad a diferentes orientaciones de pantalla.

## 🎯 Requerimientos de la Tarea

El profesor solicitó crear una Android App con las siguientes especificaciones:

### 📱 **Elementos de UI Requeridos (activity_main.xml):**
- ✅ **TextView** que muestre cuántas notas se tienen
- ✅ **EditText** donde el usuario capture la nota
- ✅ **Botón** para guardar la nota
- ✅ **TextView (multi línea)** que muestre un listado con las notas
- ✅ **Botón** para limpiar las notas

### 🛠️ **Requerimientos Técnicos:**
- ✅ **ViewBinding** para acceder a elementos de la vista (NO usar findViewById)
- ✅ **ViewModel** para persistir la lista de notas y el contador
- ✅ **SharedPreferences** para persistir datos antes del cierre de la app
- ✅ **Recuperación automática** de la lista de notas al abrir/cerrar la app
- ✅ **Adaptabilidad** a rotación de pantalla con persistencia de datos

### 💡 **Tips Implementados:**
- ✅ **Persistencia con separadores**: Notas guardadas como cadenas separadas por caracteres predefinidos (`###`)
- ✅ **Identificadores únicos**: Cada nota tiene un UUID para identificación
- ✅ **Procesamiento de cadenas**: Carga y parseo automático desde SharedPreferences al ViewModel

---

## ✨ Características Principales

### 🔧 **Funcionalidades Core**
- 📝 **Crear notas** con validación de entrada
- 💾 **Guardar automáticamente** en memoria persistente
- 📊 **Contador dinámico** de notas en tiempo real
- 🗑️ **Eliminar todas las notas** con confirmación visual
- 🔄 **Persistencia completa** durante rotaciones y cierre de app

### 🎨 **Diseño y UX**
- 📱 **Layout adaptativo** para orientación portrait y landscape
- 🌈 **Interfaz moderna** con elementos redondeados y elevaciones
- 📝 **Emojis descriptivos** para mejor experiencia visual
- ⚡ **Transiciones suaves** y feedback inmediato
- 🎯 **Accesibilidad** optimizada con textos claros

---

## 🛠️ Tecnologías Utilizadas

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84.svg?style=for-the-badge&logo=android-studio&logoColor=white)
![Java 11](https://img.shields.io/badge/Java%2011-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle%208.11.1-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)

### 📚 **Bibliotecas y Componentes**

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Android SDK** | API 36 | Plataforma base de desarrollo |
| **ViewBinding** | Nativo | Acceso type-safe a vistas |
| **ViewModel** | 2.7.0 | Persistencia durante rotaciones |
| **SharedPreferences** | Nativo | Almacenamiento persistente |
| **AppCompat** | 1.6.1 | Compatibilidad con versiones anteriores |
| **Material Design** | 1.10.0 | Componentes UI modernos |

### 🏗️ **Arquitectura**

```
app/
├── 📁 model/
│   └── Note.java              # Modelo de datos con UUID
├── 📁 vm/
│   └── NotesViewModel.java    # Lógica de negocio y estado
├── 📁 res/
│   ├── 📁 layout/
│   │   ├── activity_main.xml      # Layout principal
│   │   └── layout-land/           # Layout para landscape
│   └── 📁 drawable/               # Recursos gráficos redondeados
└── MainActivity.java              # Actividad principal con ViewBinding
```

---

## 🚀 Instalación y Ejecución

### 📋 **Prerrequisitos**
- Android Studio Hedgehog | 2023.1.1 o superior
- JDK 11 o superior
- Android SDK API 24+ (Android 7.0)

### 🔧 **Pasos de Instalación**

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/MichellPolicarpio/SimpleNotesApp.git
   cd SimpleNotesApp
   ```

2. **Abrir en Android Studio**
   - Abrir Android Studio
   - Seleccionar "Open an existing project"
   - Navegar y seleccionar la carpeta del proyecto

3. **Sincronizar dependencias**
   ```bash
   ./gradlew sync
   ```

4. **Compilar y ejecutar**
   ```bash
   ./gradlew build
   ./gradlew installDebug
   ```

---

## 📱 Uso de la Aplicación

### ✍️ **Crear una Nota**
1. Escribir el contenido en el campo de texto
2. Presionar el botón "💾 Guardar Nota"
3. La nota aparecerá automáticamente en la lista

### 📊 **Visualizar Notas**
- El contador muestra el número total de notas
- La lista muestra todas las notas numeradas con emojis

### 🗑️ **Eliminar Todas las Notas**
- Presionar "🗑️ Limpiar Todas las Notas"
- Las notas se eliminan instantáneamente

### 🔄 **Persistencia**
- Las notas se guardan automáticamente
- Se mantienen al rotar la pantalla
- Se recuperan al reiniciar la aplicación

---

## 🤝 Contribuciones

Este es un proyecto académico desarrollado para la materia de Tecnologías y Aplicaciones Móviles. Las contribuciones están limitadas a los autores del proyecto.

---

## 📄 Licencia

Este proyecto es desarrollado con fines académicos para la Universidad Veracruzana.

---

## 📧 Contacto

**Michell Alexis Policarpio Morán**  
**Luis Fernando Bravo Ibáñez**

*Facultad de Ingeniería Eléctrica y Electrónica*  
*Universidad Veracruzana*

---

⭐ **¡Gracias por revisar nuestro proyecto!** ⭐
