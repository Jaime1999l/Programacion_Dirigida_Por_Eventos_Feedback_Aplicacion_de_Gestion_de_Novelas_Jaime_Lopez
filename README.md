https://github.com/Jaime1999l/Programacion_Dirigida_Por_Eventos_Feedback_Aplicacion_de_Gestion_de_Novelas_Jaime_Lopez.git

JAIME LÓPEZ DÍAZ

# Aplicación de Gestión de Novelas
## Descripción
La Aplicación de Gestión de Novelas es una herramienta que permite a los usuarios gestionar una colección de novelas. Los usuarios pueden agregar, editar, eliminar novelas, así como gestionar reseñas y marcar sus novelas favoritas. La aplicación también permite la subida de imágenes de portada para cada novela, mejorando la visualización de la colección.

## Funcionalidades
- Agregar Novela: Permite al usuario introducir el título, autor, año de publicación, sinopsis y una imagen opcional de portada.
- Editar Novela: Modificar los detalles de una novela existente.
- Eliminar Novela: Eliminar una novela de la colección.
- Ver Lista de Novelas: Visualizar todas las novelas agregadas.
- Ver Detalles de una Novela: Muestra información detallada sobre una novela, incluyendo su sinopsis y las reseñas asociadas.
- Marcar como Favorita: Permite al usuario marcar o desmarcar una novela como favorita.
- Ver Novelas Favoritas: Muestra solo las novelas que han sido marcadas como favoritas.
- Agregar Reseña: Añadir una reseña a una novela, con puntuación y comentario.
- Ver Reseñas: Muestra todas las reseñas asociadas a una novela específica.
- Subir Imagen de Portada: Permite al usuario subir una imagen desde su dispositivo como portada de la novela.
- 
## Estructura del Proyecto
Carpetas Principales:

1. data:

- model: Contiene las clases de modelo de datos (Novel y Review).
- dataBase: Incluye la base de datos (NovelDataBase) y el DAO (NovelDao).
- rep: Contiene el repositorio (NovelRepository) que actúa como intermediario entre la base de datos y el ViewModel.
- 
2. ui:

- addeditnovel: Contiene las clases para agregar y editar novelas (AddEditNovelActivity y AddEditNovelViewModel).
- favoritesNovel: Incluye las clases para gestionar y visualizar las novelas favoritas (FavoritesActivity y FavoritesAdapter).
- main: Contiene las clases principales para la gestión de la lista de novelas (MainActivity, NovelAdapter y NovelViewModel).
- review: Gestiona las reseñas asociadas a las novelas (ReviewActivity, ReviewAdapter y ReviewViewModel).
  
3. res:

- drawable: Contiene los recursos gráficos, como iconos e imágenes.
- layout: Archivos de diseño XML para las diferentes actividades y fragmentos.
- values: Archivos de valores como colors.xml, strings.xml y themes.xml.
4. manifests:

- AndroidManifest.xml: Archivo de configuración de la aplicación, incluyendo la declaración de actividades y permisos.
  
## Estructura de Clases

- Novel: Modelo de datos que representa una novela, con atributos como título, autor, año de publicación, sinopsis, favorito y URI de imagen.
- Review: Modelo de datos para las reseñas de las novelas, con atributos como id, novelId, reviewer, comment y rating.
- NovelDao: Interfaz DAO que define las operaciones de base de datos para las novelas y reseñas.
- NovelDataBase: Clase de base de datos que proporciona acceso al DAO.
- NovelRepository: Proporciona una interfaz de acceso a los datos para el ViewModel y actúa como fuente única de datos.
- NovelViewModel: Proporciona datos al UI y sobrevive a los cambios de configuración, como rotación de pantalla.
- AddEditNovelViewModel: Gestiona las operaciones de agregar y editar novelas.
- ReviewViewModel: Gestiona la lógica de negocio de las reseñas.
- NovelAdapter: Adaptador para mostrar la lista de novelas en un RecyclerView.
- ReviewAdapter: Adaptador para mostrar la lista de reseñas.
- FavoritesAdapter: Adaptador para gestionar la lista de novelas favoritas.
- MainActivity: Actividad principal de la aplicación, gestiona la visualización y las interacciones con la lista de novelas.
- AddEditNovelActivity: Actividad para agregar o editar novelas.
- ReviewActivity: Actividad para gestionar y visualizar reseñas de novelas.
- FavoritesActivity: Actividad para ver la lista de novelas marcadas como favoritas.
  
### Requisitos Previos

Android Studio Bumblebee o superior.
Dispositivo o emulador con Android 5.0 (Lollipop) o superior.
Permiso de acceso al almacenamiento para la carga de imágenes (opcional).

### Uso

Inicia la aplicación desde el dispositivo o emulador.
En la pantalla principal, puedes ver la lista de novelas.
Usa el botón "Agregar Novela" para añadir una nueva novela.
Para editar o eliminar una novela, toca la novela correspondiente en la lista.
Usa el botón de menú para acceder a las novelas favoritas.
En cada novela, puedes agregar reseñas o marcarla como favorita.

### Diagramas

- Diagrama de Clases
El diagrama de clases completo está disponible en la carpeta docs del proyecto. Incluye la estructura de todas las clases y sus relaciones, métodos y atributos.

- Diagrama de Casos de Uso
El diagrama de casos de uso está disponible en la carpeta docs y describe la interacción entre el usuario y las funcionalidades del sistema.

