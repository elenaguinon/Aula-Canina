package com.aulacanina;

import com.aulacanina.dao.AdminDAO;
import com.aulacanina.dao.ClienteDAO;
import com.aulacanina.dao.PerroDAO;
import com.aulacanina.dao.ReservaDAO;
import com.aulacanina.dao.ServicioDAO;
import com.aulacanina.dao.TrabajadorDAO;
import com.aulacanina.database.DBConnection;
import com.aulacanina.model.Cliente;
import com.aulacanina.model.Perro;
import com.aulacanina.model.Reserva;
import com.aulacanina.model.Servicio;
import com.aulacanina.model.Trabajador;
import com.aulacanina.util.Estilos;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class App extends Application {

    private BorderPane root;

    private final AdminDAO adminDAO = new AdminDAO();
    private final ReservaDAO reservaDAO = new ReservaDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final PerroDAO perroDAO = new PerroDAO();
    private final ServicioDAO servicioDAO = new ServicioDAO();
    private final TrabajadorDAO trabajadorDAO = new TrabajadorDAO();

    private TableView<Reserva> tablaReservas;

    @Override
    public void start(Stage stage) {
        root = new BorderPane();
        root.setStyle(Estilos.ROOT);

        mostrarLogin(stage);

        Scene scene = new Scene(root, 1100, 680);
        stage.setTitle("Aula Canina SL - Administración");
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarLogin(Stage stage) {
        VBox contenedor = new VBox(18);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(40));
        contenedor.setStyle(Estilos.ROOT);

        VBox tarjeta = new VBox(16);
        tarjeta.setAlignment(Pos.CENTER);
        tarjeta.setMaxWidth(420);
        tarjeta.setPadding(new Insets(35));
        tarjeta.setStyle(Estilos.TARJETA);

        Label titulo = new Label("Aula Canina");
        titulo.setStyle(Estilos.TITULO);

        Label subtitulo = new Label("Administración");
        subtitulo.setStyle(Estilos.SUBTITULO);

        TextField campoUsuario = new TextField();
        campoUsuario.setPromptText("Usuario");
        campoUsuario.setStyle(Estilos.INPUT);

        PasswordField campoPassword = new PasswordField();
        campoPassword.setPromptText("Contraseña");
        campoPassword.setStyle(Estilos.INPUT);

        Button botonEntrar = new Button("Entrar al panel");
        botonEntrar.setStyle(Estilos.BOTON_PRINCIPAL);
        botonEntrar.setMaxWidth(Double.MAX_VALUE);

        Label mensaje = new Label();
        mensaje.setStyle("-fx-text-fill: #ef4444; -fx-font-weight: bold;");

        botonEntrar.setOnAction(e -> {
            String usuario = campoUsuario.getText();
            String password = campoPassword.getText();

            if (adminDAO.validarLogin(usuario, password)) {
                iniciarAplicacion();
            } else {
                mensaje.setText("Usuario o contraseña incorrectos");
            }
        });

        tarjeta.getChildren().addAll(
                titulo,
                subtitulo,
                campoUsuario,
                campoPassword,
                botonEntrar,
                mensaje
        );

        contenedor.getChildren().add(tarjeta);
        root.setCenter(contenedor);
    }

    private void iniciarAplicacion() {
        MenuBar menuBar = crearMenu();
        root.setTop(menuBar);
        mostrarPantallaInicio();
    }

    private MenuBar crearMenu() {
        MenuBar menuBar = new MenuBar();
        menuBar.setStyle("""
                -fx-background-color: #ffffff;
                -fx-border-color: #fff3c4;
                -fx-border-width: 0 0 2px 0;
                """);

        Menu menuArchivo = new Menu("Archivo");

        MenuItem itemInicio = new MenuItem("Inicio");
        itemInicio.setOnAction(e -> mostrarPantallaInicio());

        MenuItem itemProbarConexion = new MenuItem("Probar conexión");
        itemProbarConexion.setOnAction(e -> probarConexion());

        MenuItem itemSalir = new MenuItem("Salir");
        itemSalir.setOnAction(e -> System.exit(0));

        menuArchivo.getItems().addAll(
                itemInicio,
                itemProbarConexion,
                new SeparatorMenuItem(),
                itemSalir
        );

        Menu menuGestion = new Menu("Gestión");

        MenuItem itemReservas = new MenuItem("Reservas");
        itemReservas.setOnAction(e -> mostrarVistaReservas());

        MenuItem itemClientes = new MenuItem("Clientes");
        itemClientes.setOnAction(e -> mostrarVistaClientes());

        MenuItem itemPerros = new MenuItem("Perros");
        itemPerros.setOnAction(e -> mostrarVistaPerros());

        MenuItem itemTrabajadores = new MenuItem("Trabajadores");
        itemTrabajadores.setOnAction(e -> mostrarVistaTrabajadores());

        MenuItem itemServicios = new MenuItem("Servicios");
        itemServicios.setOnAction(e -> mostrarVistaServicios());

        menuGestion.getItems().addAll(
                itemReservas,
                itemClientes,
                itemPerros,
                itemTrabajadores,
                itemServicios
        );

        menuBar.getMenus().addAll(menuArchivo, menuGestion);

        return menuBar;
    }

    private void mostrarPantallaInicio() {
        VBox contenedor = new VBox(25);
        contenedor.setPadding(new Insets(40));
        contenedor.setStyle(Estilos.ROOT);

        Label titulo = new Label("Panel de Gestión de Aula Canina");
        titulo.setStyle(Estilos.TITULO);

        Label descripcion = new Label(
                "Gestiona reservas, clientes, perros, servicios y trabajadores de la empresa."
        );
        descripcion.setStyle(Estilos.SUBTITULO);
        descripcion.setWrapText(true);

        HBox tarjetas = new HBox(20);

        VBox cardReservas = crearTarjetaInicio("Reservas", "Consulta, crea y cancela reservas.");
        VBox cardClientes = crearTarjetaInicio("Clientes", "Consulta los clientes registrados.");
        VBox cardPerros = crearTarjetaInicio("Perros", "Registra y consulta los perros de los clientes.");
        VBox cardTrabajadores = crearTarjetaInicio("Trabajadores", "Gestiona el equipo de Aula Canina.");

        tarjetas.getChildren().addAll(cardReservas, cardClientes, cardPerros, cardTrabajadores);

        contenedor.getChildren().addAll(titulo, descripcion, tarjetas);
        root.setCenter(contenedor);
    }

    private VBox crearTarjetaInicio(String tituloTexto, String descripcionTexto) {
        VBox tarjeta = new VBox(10);
        tarjeta.setPadding(new Insets(24));
        tarjeta.setPrefWidth(245);
        tarjeta.setMinHeight(150);
        tarjeta.setStyle(Estilos.TARJETA);

        Label titulo = new Label(tituloTexto);
        titulo.setStyle("""
                -fx-font-size: 20px;
                -fx-font-weight: bold;
                -fx-text-fill: #1f2933;
                """);

        Label descripcion = new Label(descripcionTexto);
        descripcion.setWrapText(true);
        descripcion.setStyle("""
                -fx-font-size: 14px;
                -fx-text-fill: #627d98;
                """);

        tarjeta.getChildren().addAll(titulo, descripcion);

        return tarjeta;
    }

    private void probarConexion() {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                mostrarAlerta("Conexión correcta con la base de datos.");
            } else {
                mostrarAlerta("No se pudo conectar con la base de datos.");
            }
        } catch (Exception e) {
            mostrarAlerta("Error de conexión: " + e.getMessage());
        }
    }

    private void mostrarVistaReservas() {
        VBox contenedor = new VBox(18);
        contenedor.setPadding(new Insets(30));
        contenedor.setStyle(Estilos.ROOT);

        Label titulo = new Label("Gestión de reservas");
        titulo.setStyle(Estilos.TITULO);

        GridPane formulario = new GridPane();
        formulario.setHgap(12);
        formulario.setVgap(12);
        formulario.setPadding(new Insets(18));
        formulario.setStyle(Estilos.TARJETA);

        DatePicker fechaServicio = new DatePicker();
        fechaServicio.setPromptText("Fecha servicio");

        TextField campoHora = new TextField();
        campoHora.setPromptText("Hora HH:MM");

        TextField campoEstado = new TextField();
        campoEstado.setPromptText("Estado");

        TextField campoObservaciones = new TextField();
        campoObservaciones.setPromptText("Observaciones");

        TextField campoIdCliente = new TextField();
        campoIdCliente.setPromptText("ID Cliente");

        TextField campoIdPerro = new TextField();
        campoIdPerro.setPromptText("ID Perro");

        TextField campoIdEmpleado = new TextField();
        campoIdEmpleado.setPromptText("ID Empleado");

        TextField campoIdServicio = new TextField();
        campoIdServicio.setPromptText("ID Servicio");

        fechaServicio.setStyle(Estilos.INPUT);
        campoHora.setStyle(Estilos.INPUT);
        campoEstado.setStyle(Estilos.INPUT);
        campoObservaciones.setStyle(Estilos.INPUT);
        campoIdCliente.setStyle(Estilos.INPUT);
        campoIdPerro.setStyle(Estilos.INPUT);
        campoIdEmpleado.setStyle(Estilos.INPUT);
        campoIdServicio.setStyle(Estilos.INPUT);

        Button btnRegistrar = new Button("Registrar reserva");
        btnRegistrar.setStyle(Estilos.BOTON_PRINCIPAL);

        formulario.add(fechaServicio, 0, 0);
        formulario.add(campoHora, 1, 0);
        formulario.add(campoEstado, 2, 0);
        formulario.add(campoObservaciones, 0, 1);
        formulario.add(campoIdCliente, 1, 1);
        formulario.add(campoIdPerro, 2, 1);
        formulario.add(campoIdEmpleado, 0, 2);
        formulario.add(campoIdServicio, 1, 2);
        formulario.add(btnRegistrar, 2, 2);

        tablaReservas = new TableView<>();

        TableColumn<Reserva, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdReserva()));

        TableColumn<Reserva, LocalDate> colFechaReserva = new TableColumn<>("Fecha reserva");
        colFechaReserva.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getFechaReserva()));

        TableColumn<Reserva, LocalDate> colFechaServicio = new TableColumn<>("Fecha servicio");
        colFechaServicio.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getFechaServicio()));

        TableColumn<Reserva, LocalTime> colHora = new TableColumn<>("Hora");
        colHora.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getHoraServicio()));

        TableColumn<Reserva, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getEstado()));

        TableColumn<Reserva, String> colObservaciones = new TableColumn<>("Observaciones");
        colObservaciones.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getObservaciones()));

        TableColumn<Reserva, Integer> colCliente = new TableColumn<>("ID Cliente");
        colCliente.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdCliente()));

        TableColumn<Reserva, Integer> colPerro = new TableColumn<>("ID Perro");
        colPerro.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdPerro()));

        TableColumn<Reserva, Integer> colEmpleado = new TableColumn<>("ID Empleado");
        colEmpleado.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdEmpleado()));

        TableColumn<Reserva, Integer> colServicio = new TableColumn<>("ID Servicio");
        colServicio.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdServicio()));

        tablaReservas.getColumns().addAll(
                colId,
                colFechaReserva,
                colFechaServicio,
                colHora,
                colEstado,
                colObservaciones,
                colCliente,
                colPerro,
                colEmpleado,
                colServicio
        );

        cargarReservas();

        HBox botones = new HBox(12);

        Button btnCancelar = new Button("Cancelar reserva");
        btnCancelar.setStyle(Estilos.BOTON_SECUNDARIO);

        Button btnEliminar = new Button("Eliminar reserva");
        btnEliminar.setStyle(Estilos.BOTON_PELIGRO);

        botones.getChildren().addAll(btnCancelar, btnEliminar);

        btnRegistrar.setOnAction(e -> {
            try {
                LocalDate fechaReservaActual = LocalDate.now();
                LocalDate fechaServicioSeleccionada = fechaServicio.getValue();
                LocalTime hora = LocalTime.parse(campoHora.getText());

                String estado = campoEstado.getText().isBlank()
                        ? "Pendiente"
                        : campoEstado.getText();

                Reserva reserva = new Reserva(
                        0,
                        fechaReservaActual,
                        fechaServicioSeleccionada,
                        hora,
                        estado,
                        campoObservaciones.getText(),
                        Integer.parseInt(campoIdCliente.getText()),
                        Integer.parseInt(campoIdPerro.getText()),
                        Integer.parseInt(campoIdEmpleado.getText()),
                        Integer.parseInt(campoIdServicio.getText())
                );

                if (reservaDAO.insertarReserva(reserva)) {
                    mostrarAlerta("Reserva registrada correctamente.");
                    cargarReservas();

                    fechaServicio.setValue(null);
                    campoHora.clear();
                    campoEstado.clear();
                    campoObservaciones.clear();
                    campoIdCliente.clear();
                    campoIdPerro.clear();
                    campoIdEmpleado.clear();
                    campoIdServicio.clear();
                } else {
                    mostrarAlerta("No se pudo registrar la reserva.");
                }

            } catch (Exception ex) {
                mostrarAlerta("Revisa los datos de la reserva. La hora debe tener formato HH:MM.");
            }
        });

        btnCancelar.setOnAction(e -> {
            Reserva seleccionada = tablaReservas.getSelectionModel().getSelectedItem();

            if (seleccionada == null) {
                mostrarAlerta("Selecciona una reserva.");
                return;
            }

            if (reservaDAO.cancelarReserva(seleccionada.getIdReserva())) {
                mostrarAlerta("Reserva cancelada correctamente.");
                cargarReservas();
            } else {
                mostrarAlerta("No se pudo cancelar la reserva.");
            }
        });

        btnEliminar.setOnAction(e -> {
            Reserva seleccionada = tablaReservas.getSelectionModel().getSelectedItem();

            if (seleccionada == null) {
                mostrarAlerta("Selecciona una reserva.");
                return;
            }

            if (reservaDAO.eliminarReserva(seleccionada.getIdReserva())) {
                mostrarAlerta("Reserva eliminada correctamente.");
                cargarReservas();
            } else {
                mostrarAlerta("No se pudo eliminar la reserva.");
            }
        });

        contenedor.getChildren().addAll(titulo, formulario, tablaReservas, botones);
        root.setCenter(contenedor);
    }

    private void cargarReservas() {
        List<Reserva> reservas = reservaDAO.listarReservas();
        tablaReservas.setItems(FXCollections.observableArrayList(reservas));
    }

    private void mostrarVistaClientes() {
        VBox contenedor = new VBox(18);
        contenedor.setPadding(new Insets(30));
        contenedor.setStyle(Estilos.ROOT);

        Label titulo = new Label("Clientes registrados");
        titulo.setStyle(Estilos.TITULO);

        TableView<Cliente> tabla = new TableView<>();

        TableColumn<Cliente, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdCliente()));

        TableColumn<Cliente, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNombre()));

        TableColumn<Cliente, String> colApellidos = new TableColumn<>("Apellidos");
        colApellidos.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getApellidos()));

        TableColumn<Cliente, String> colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTelefono()));

        TableColumn<Cliente, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getEmail()));

        tabla.getColumns().addAll(colId, colNombre, colApellidos, colTelefono, colEmail);
        tabla.setItems(FXCollections.observableArrayList(clienteDAO.listarClientes()));

        contenedor.getChildren().addAll(titulo, tabla);
        root.setCenter(contenedor);
    }

    private void mostrarVistaPerros() {
        VBox contenedor = new VBox(18);
        contenedor.setPadding(new Insets(30));
        contenedor.setStyle(Estilos.ROOT);

        Label titulo = new Label("Gestión de perros");
        titulo.setStyle(Estilos.TITULO);

        HBox formulario = new HBox(12);
        formulario.setPadding(new Insets(18));
        formulario.setStyle(Estilos.TARJETA);

        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre del perro");
        campoNombre.setStyle(Estilos.INPUT);

        TextField campoRaza = new TextField();
        campoRaza.setPromptText("Raza");
        campoRaza.setStyle(Estilos.INPUT);

        TextField campoIdCliente = new TextField();
        campoIdCliente.setPromptText("ID Cliente");
        campoIdCliente.setStyle(Estilos.INPUT);

        Button btnGuardar = new Button("Registrar perro");
        btnGuardar.setStyle(Estilos.BOTON_PRINCIPAL);

        formulario.getChildren().addAll(campoNombre, campoRaza, campoIdCliente, btnGuardar);

        TextField campoBuscar = new TextField();
        campoBuscar.setPromptText("Buscar perro por nombre...");
        campoBuscar.setStyle(Estilos.INPUT);

        TableView<Perro> tabla = new TableView<>();

        TableColumn<Perro, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdPerro()));

        TableColumn<Perro, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNombre()));

        TableColumn<Perro, String> colRaza = new TableColumn<>("Raza");
        colRaza.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getRaza()));

        TableColumn<Perro, Integer> colCliente = new TableColumn<>("ID Cliente");
        colCliente.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdCliente()));

        tabla.getColumns().addAll(colId, colNombre, colRaza, colCliente);
        tabla.setItems(FXCollections.observableArrayList(perroDAO.listarPerros()));

        Button btnEliminar = new Button("Eliminar seleccionado");
        btnEliminar.setStyle(Estilos.BOTON_PELIGRO);

        btnGuardar.setOnAction(e -> {
            try {
                String nombre = campoNombre.getText();
                String raza = campoRaza.getText();
                int idCliente = Integer.parseInt(campoIdCliente.getText());

                if (nombre.isBlank() || raza.isBlank()) {
                    mostrarAlerta("El nombre y la raza son obligatorios.");
                    return;
                }

                Perro perro = new Perro(nombre, raza, idCliente);

                if (perroDAO.insertarPerro(perro)) {
                    mostrarAlerta("Perro registrado correctamente.");
                    tabla.setItems(FXCollections.observableArrayList(perroDAO.listarPerros()));

                    campoNombre.clear();
                    campoRaza.clear();
                    campoIdCliente.clear();
                } else {
                    mostrarAlerta("No se pudo registrar el perro.");
                }

            } catch (Exception ex) {
                mostrarAlerta("Revisa los datos introducidos.");
            }
        });

        campoBuscar.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == null || newValue.isBlank()) {
                tabla.setItems(FXCollections.observableArrayList(perroDAO.listarPerros()));
            } else {
                tabla.setItems(FXCollections.observableArrayList(perroDAO.buscarPerrosPorNombre(newValue)));
            }
        });

        btnEliminar.setOnAction(e -> {
            Perro seleccionado = tabla.getSelectionModel().getSelectedItem();

            if (seleccionado == null) {
                mostrarAlerta("Selecciona un perro para eliminar.");
                return;
            }

            if (perroDAO.eliminarPerro(seleccionado.getIdPerro())) {
                mostrarAlerta("Perro eliminado correctamente.");
                tabla.setItems(FXCollections.observableArrayList(perroDAO.listarPerros()));
            } else {
                mostrarAlerta("No se pudo eliminar el perro. Comprueba si tiene reservas asociadas.");
            }
        });

        contenedor.getChildren().addAll(titulo, formulario, campoBuscar, tabla, btnEliminar);
        root.setCenter(contenedor);
    }

    private void mostrarVistaTrabajadores() {
        VBox contenedor = new VBox(18);
        contenedor.setPadding(new Insets(30));
        contenedor.setStyle(Estilos.ROOT);

        Label titulo = new Label("Gestión de trabajadores");
        titulo.setStyle(Estilos.TITULO);

        GridPane formulario = new GridPane();
        formulario.setHgap(12);
        formulario.setVgap(12);
        formulario.setPadding(new Insets(18));
        formulario.setStyle(Estilos.TARJETA);

        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre");
        campoNombre.setStyle(Estilos.INPUT);

        TextField campoApellidos = new TextField();
        campoApellidos.setPromptText("Apellidos");
        campoApellidos.setStyle(Estilos.INPUT);

        TextField campoTelefono = new TextField();
        campoTelefono.setPromptText("Teléfono");
        campoTelefono.setStyle(Estilos.INPUT);

        TextField campoEmail = new TextField();
        campoEmail.setPromptText("Email");
        campoEmail.setStyle(Estilos.INPUT);

        Button btnGuardar = new Button("Registrar trabajador");
        btnGuardar.setStyle(Estilos.BOTON_PRINCIPAL);

        formulario.add(campoNombre, 0, 0);
        formulario.add(campoApellidos, 1, 0);
        formulario.add(campoTelefono, 0, 1);
        formulario.add(campoEmail, 1, 1);
        formulario.add(btnGuardar, 0, 2);

        TableView<Trabajador> tabla = new TableView<>();

        TableColumn<Trabajador, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdEmpleado()));

        TableColumn<Trabajador, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNombre()));

        TableColumn<Trabajador, String> colApellidos = new TableColumn<>("Apellidos");
        colApellidos.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getApellidos()));

        TableColumn<Trabajador, String> colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTelefono()));

        TableColumn<Trabajador, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getEmail()));

        tabla.getColumns().addAll(colId, colNombre, colApellidos, colTelefono, colEmail);
        tabla.setItems(FXCollections.observableArrayList(trabajadorDAO.listarTrabajadores()));

        btnGuardar.setOnAction(e -> {
            if (
                    campoNombre.getText().isBlank()
                            || campoApellidos.getText().isBlank()
            ) {
                mostrarAlerta("Nombre y apellidos son obligatorios.");
                return;
            }

            Trabajador trabajador = new Trabajador(
            );

            if (trabajadorDAO.insertarTrabajador(trabajador)) {
                mostrarAlerta("Trabajador registrado correctamente.");
                tabla.setItems(FXCollections.observableArrayList(trabajadorDAO.listarTrabajadores()));

                campoNombre.clear();
                campoApellidos.clear();
                campoTelefono.clear();
                campoEmail.clear();
            } else {
                mostrarAlerta("No se pudo registrar el trabajador.");
            }
        });

        contenedor.getChildren().addAll(titulo, formulario, tabla);
        root.setCenter(contenedor);
    }

    private void mostrarVistaServicios() {
        VBox contenedor = new VBox(18);
        contenedor.setPadding(new Insets(30));
        contenedor.setStyle(Estilos.ROOT);

        Label titulo = new Label("Servicios activos");
        titulo.setStyle(Estilos.TITULO);

        TableView<Servicio> tabla = new TableView<>();

        TableColumn<Servicio, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdServicio()));

        TableColumn<Servicio, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNombre()));

        TableColumn<Servicio, String> colDescripcion = new TableColumn<>("Descripción");
        colDescripcion.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDescripcion()));

        TableColumn<Servicio, Integer> colDuracion = new TableColumn<>("Duración");
        colDuracion.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDuracion()));

        TableColumn<Servicio, Object> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrecio()));

        TableColumn<Servicio, Boolean> colActivo = new TableColumn<>("Activo");
        colActivo.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().isActivo()));

        tabla.getColumns().addAll(colId, colNombre, colDescripcion, colDuracion, colPrecio, colActivo);
        tabla.setItems(FXCollections.observableArrayList(servicioDAO.listarServiciosActivos()));

        contenedor.getChildren().addAll(titulo, tabla);
        root.setCenter(contenedor);
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aula Canina");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}