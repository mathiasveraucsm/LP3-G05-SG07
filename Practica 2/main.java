package lp3prac2;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static SistemaGestion sistema;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        inicializarSistema();
        mostrarMenuPrincipal();
    }
    
    private static void inicializarSistema() {
        Estudiante[] estudiantes = new Estudiante[0];
        Profesor[] profesores = new Profesor[0];
        Curso[] cursos = new Curso[0];
        
        sistema = new SistemaGestion(estudiantes, profesores, cursos, "Sistema de Gestión Académica");
    }
    
    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== " + sistema.getNombre() + " ===");
            System.out.println("1. Gestión de Estudiantes");
            System.out.println("2. Gestión de Profesores");
            System.out.println("3. Gestión de Cursos");
            System.out.println("4. Matricular Estudiante en Curso");
            System.out.println("5. Mostrar Información");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch(opcion) {
                case 1:
                    menuGestionEstudiantes();
                    break;
                case 2:
                    menuGestionProfesores();
                    break;
                case 3:
                    menuGestionCursos();
                    break;
                case 4:
                    matricularEstudianteEnCurso();
                    break;
                case 5:
                    menuMostrarInformacion();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while(opcion != 0);
    }
    
    private static void menuGestionEstudiantes() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE ESTUDIANTES ===");
            System.out.println("1. Crear Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    crearEstudiante();
                    break;
                case 2:
                    listarEstudiantes();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }
    
    private static void crearEstudiante() {
        System.out.println("\n--- CREAR NUEVO ESTUDIANTE ---");
        System.out.println("El código del estudiante se generará automáticamente: " + Estudiante.obtenerSiguienteCodigo());
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
       
        Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, edad, new ArrayList<>());
        
        agregarEstudianteAlSistema(nuevoEstudiante);
        
        System.out.println("Estudiante creado exitosamente con código: " + nuevoEstudiante.getCodigoEstudiante());
    }
    
    private static void agregarEstudianteAlSistema(Estudiante estudiante) {
        Estudiante[] estudiantesActuales = sistema.getListaEstudiantes();
        Estudiante[] nuevosEstudiantes = new Estudiante[estudiantesActuales.length + 1];
        
        System.arraycopy(estudiantesActuales, 0, nuevosEstudiantes, 0, estudiantesActuales.length);
        nuevosEstudiantes[estudiantesActuales.length] = estudiante;
        
        sistema.setListaEstudiantes(nuevosEstudiantes);
    }
    
    private static void listarEstudiantes() {
        Estudiante[] estudiantes = sistema.getListaEstudiantes();
        
        if (estudiantes.length == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        System.out.println("\n--- LISTA DE ESTUDIANTES ---");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println((i+1) + ". " + estudiantes[i].getNombre() + " " + 
                              estudiantes[i].getApellido() + " - Código: " + 
                              estudiantes[i].getCodigoEstudiante());
        }
    }
    
    private static void menuGestionProfesores() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE PROFESORES ===");
            System.out.println("1. Crear Profesor");
            System.out.println("2. Listar Profesores");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    crearProfesor();
                    break;
                case 2:
                    listarProfesores();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }
    
    private static void crearProfesor() {
        System.out.println("\n--- CREAR NUEVO PROFESOR ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        
        System.out.print("Sueldo: ");
        int sueldo = scanner.nextInt();
        scanner.nextLine();
        
        Profesor nuevoProfesor = new Profesor(nombre, apellido, edad, sueldo, new ArrayList<>());
        
        agregarProfesorAlSistema(nuevoProfesor);
        
        System.out.println("Profesor creado exitosamente.");
    }
    
    private static void agregarProfesorAlSistema(Profesor profesor) {
        Profesor[] profesoresActuales = sistema.getListaProfesores();
        Profesor[] nuevosProfesores = new Profesor[profesoresActuales.length + 1];
        
        System.arraycopy(profesoresActuales, 0, nuevosProfesores, 0, profesoresActuales.length);
        nuevosProfesores[profesoresActuales.length] = profesor;
        
        sistema.setListaProfesores(nuevosProfesores);
    }
    
    private static void listarProfesores() {
        Profesor[] profesores = sistema.getListaProfesores();
        
        if (profesores.length == 0) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        
        System.out.println("\n--- LISTA DE PROFESORES ---");
        for (int i = 0; i < profesores.length; i++) {
            System.out.println((i+1) + ". " + profesores[i].getNombre() + " " + 
                              profesores[i].getApellido() + " - Sueldo: $" + 
                              profesores[i].getSueldo());
        }
    }
    
    private static void menuGestionCursos() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CURSOS ===");
            System.out.println("1. Crear Curso");
            System.out.println("2. Listar Cursos");
            System.out.println("3. Asignar Profesor a Curso");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    crearCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 3:
                    asignarProfesorACurso();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }
    
    private static void crearCurso() {
        System.out.println("\n--- CREAR NUEVO CURSO ---");
        System.out.print("Nombre del curso: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Semestre: ");
        int semestre = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Código del curso: ");
        String codigo = scanner.nextLine();
        
        Curso nuevoCurso = new Curso(nombre, semestre, codigo, new ArrayList<>(), null);
        
        agregarCursoAlSistema(nuevoCurso);
        
        System.out.println("Curso creado exitosamente.");
    }
    
    private static void agregarCursoAlSistema(Curso curso) {
        Curso[] cursosActuales = sistema.getListaCursos();
        Curso[] nuevosCursos = new Curso[cursosActuales.length + 1];
        
        System.arraycopy(cursosActuales, 0, nuevosCursos, 0, cursosActuales.length);
        nuevosCursos[cursosActuales.length] = curso;
        
        sistema.setListaCursos(nuevosCursos);
    }
    
    private static void listarCursos() {
        Curso[] cursos = sistema.getListaCursos();
        
        if (cursos.length == 0) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        
        System.out.println("\n--- LISTA DE CURSOS ---");
        for (int i = 0; i < cursos.length; i++) {
            String profesorNombre = (cursos[i].getDocente() != null) ? 
                cursos[i].getDocente().getNombre() + " " + cursos[i].getDocente().getApellido() : 
                "Sin asignar";
                
            System.out.println((i+1) + ". " + cursos[i].getNombre() + 
                              " - Código: " + cursos[i].getCodigoCurso() +
                              " - Profesor: " + profesorNombre);
        }
    }
    
    private static void asignarProfesorACurso() {
        Profesor[] profesores = sistema.getListaProfesores();
        Curso[] cursos = sistema.getListaCursos();
        
        if (profesores.length == 0) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        
        if (cursos.length == 0) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        
        System.out.println("\n--- ASIGNAR PROFESOR A CURSO ---");
        
        System.out.println("Profesores disponibles:");
        for (int i = 0; i < profesores.length; i++) {
            System.out.println((i+1) + ". " + profesores[i].getNombre() + " " + profesores[i].getApellido());
        }
        
        System.out.print("Seleccione el número del profesor: ");
        int indiceProfesor = scanner.nextInt() - 1;
        
        if (indiceProfesor < 0 || indiceProfesor >= profesores.length) {
            System.out.println("Selección de profesor inválida.");
            return;
        }
        
        System.out.println("Cursos disponibles:");
        for (int i = 0; i < cursos.length; i++) {
            System.out.println((i+1) + ". " + cursos[i].getNombre());
        }
        
        System.out.print("Seleccione el número del curso: ");
        int indiceCurso = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (indiceCurso < 0 || indiceCurso >= cursos.length) {
            System.out.println("Selección de curso inválida.");
            return;
        }
        
        cursos[indiceCurso].setDocente(profesores[indiceProfesor]);
        
        ArrayList<Curso> cursosProfesor = profesores[indiceProfesor].getListaCursos();
        cursosProfesor.add(cursos[indiceCurso]);
        profesores[indiceProfesor].setListaCursos(cursosProfesor);
        
        System.out.println("Profesor asignado al curso exitosamente.");
    }
    
    private static void matricularEstudianteEnCurso() {
        Estudiante[] estudiantes = sistema.getListaEstudiantes();
        Curso[] cursos = sistema.getListaCursos();
        
        if (estudiantes.length == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        if (cursos.length == 0) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        
        System.out.println("\n--- MATRICULAR ESTUDIANTE EN CURSO ---");
        
        System.out.println("Estudiantes disponibles:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println((i+1) + ". " + estudiantes[i].getNombre() + " " + estudiantes[i].getApellido() +
                              " - Código: " + estudiantes[i].getCodigoEstudiante());
        }
        
        System.out.print("Seleccione el número del estudiante: ");
        int indiceEstudiante = scanner.nextInt() - 1;
        
        if (indiceEstudiante < 0 || indiceEstudiante >= estudiantes.length) {
            System.out.println("Selección de estudiante inválida.");
            return;
        }
        
        System.out.println("Cursos disponibles:");
        for (int i = 0; i < cursos.length; i++) {
            System.out.println((i+1) + ". " + cursos[i].getNombre());
        }
        
        System.out.print("Seleccione el número del curso: ");
        int indiceCurso = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (indiceCurso < 0 || indiceCurso >= cursos.length) {
            System.out.println("Selección de curso inválida.");
            return;
        }
        
        sistema.inscribirEstudiante(estudiantes[indiceEstudiante], cursos[indiceCurso]);
        
        ArrayList<Curso> cursosEstudiante = estudiantes[indiceEstudiante].getListaCursos();
        cursosEstudiante.add(cursos[indiceCurso]);
        estudiantes[indiceEstudiante].setListaCursos(cursosEstudiante);
    }
    
    private static void menuMostrarInformacion() {
        int opcion;
        do {
            System.out.println("\n=== MOSTRAR INFORMACIÓN ===");
            System.out.println("1. Mostrar información de Estudiante");
            System.out.println("2. Mostrar información de Profesor");
            System.out.println("3. Mostrar información de Curso");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    mostrarInfoEstudiante();
                    break;
                case 2:
                    mostrarInfoProfesor();
                    break;
                case 3:
                    mostrarInfoCurso();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }
    
    private static void mostrarInfoEstudiante() {
        Estudiante[] estudiantes = sistema.getListaEstudiantes();
        
        if (estudiantes.length == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        System.out.println("\nEstudiantes disponibles:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println((i+1) + ". " + estudiantes[i].getNombre() + " " + estudiantes[i].getApellido());
        }
        
        System.out.print("Seleccione el número del estudiante: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (indice < 0 || indice >= estudiantes.length) {
            System.out.println("Selección inválida.");
            return;
        }
        
        System.out.println("\n--- INFORMACIÓN DEL ESTUDIANTE ---");
        estudiantes[indice].mostrarInformacion();
    }
    
    private static void mostrarInfoProfesor() {
        Profesor[] profesores = sistema.getListaProfesores();
        
        if (profesores.length == 0) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        
        System.out.println("\nProfesores disponibles:");
        for (int i = 0; i < profesores.length; i++) {
            System.out.println((i+1) + ". " + profesores[i].getNombre() + " " + profesores[i].getApellido());
        }
        
        System.out.print("Seleccione el número del profesor: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (indice < 0 || indice >= profesores.length) {
            System.out.println("Selección inválida.");
            return;
        }
        
        System.out.println("\n--- INFORMACIÓN DEL PROFESOR ---");
        profesores[indice].mostrarInformacion();
    }
    
    private static void mostrarInfoCurso() {
        Curso[] cursos = sistema.getListaCursos();
        
        if (cursos.length == 0) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        
        System.out.println("\nCursos disponibles:");
        for (int i = 0; i < cursos.length; i++) {
            System.out.println((i+1) + ". " + cursos[i].getNombre());
        }
        
        System.out.print("Seleccione el número del curso: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (indice < 0 || indice >= cursos.length) {
            System.out.println("Selección inválida.");
            return;
        }
        
        System.out.println("\n--- INFORMACIÓN DEL CURSO ---");
        cursos[indice].mostrarInformacion();
    }
}