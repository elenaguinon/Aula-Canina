package com.aulacanina;

import com.aulacanina.dao.ClienteDAO;
import com.aulacanina.dao.PerroDAO;
import com.aulacanina.dao.ReservaDAO;
import com.aulacanina.dao.ServicioDAO;
import com.aulacanina.database.DBConnection;
import com.aulacanina.model.Cliente;
import com.aulacanina.model.Perro;
import com.aulacanina.model.Reserva;
import com.aulacanina.model.Servicio;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
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

    private final ReservaDAO reservaDAO = new ReservaDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final PerroDAO perroDAO = new PerroDAO();
    private final ServicioDAO servicioDAO = new ServicioDAO();

    private TableView<Reserva> tablaReservas;

    @Override
    public void start(Stage stage) {
        root = new BorderPane();

        MenuBar menuBar = crearMenu();
        root.setTop(menuBar);

        mostrarPantallaInicio();

        Scene scene = new Scene(root, 1000, 600);
        stage.setTitle("Aula Canina SL - Gestión de Reservas");
        stage.setScene(scene);
        stage.show();
    }

    private MenuBar crearMenu() {
        MenuBar menuBar = new MenuBar();

        Menu menuArchivo = new Menu("Archivo");

        MenuItem itemProbarConexion = new MenuItem("Probar conexión");
        itemProbarConexion.setOnAction(e -> probarConexion());

        MenuItem itemSalir = new MenuItem("Salir");
        itemSalir.setOnAction(e -> System.exit(0));

        menuArchivo.getItems().addAll(itemProbarConexion, new SeparatorMenuItem(), itemSalir);

        Menu menuGestion = new Menu("Gestión");

        MenuItem itemReservas = new MenuItem("Reservas");
        itemReservas.setOnAction(e -> mostrarVistaReservas());

        MenuItem itemClientes = new MenuItem("Clientes");
        itemClientes.setOnAction(e -> mostrarVistaClientes());

        MenuItem itemServicios = new MenuItem("Servicios");
        itemServicios.setOnAction(e -> mostrarVistaServicios());

        menuGestion.getItems().addAll(itemReservas, itemClientes, itemServicios);

        menuBar.getMenus().addAll(menuArchivo, menuGestion);

        return menuBar;
    }

    private void mostrarPantallaInicio() {
        VBox caja = new VBox(15);
        caja.setPadding(new Insets(30));

        Label titulo = new Label("Aula Canina SL");
        titulo.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        Label subtitulo = new Label("Herramienta de gestión de clientes y reservas");
        subtitulo.setStyle("-fx-font-size: 16px;");

        Label instrucciones = new Label("""
                Usa el menú superior para gestionar la aplicación.

                Primera versión:
                - Ver reservas
                - Crear reservas
                - Cancelar reservas
                - Eliminar reservas
                - Ver clientes
                - Ver servicios
                """);

        caja.getChildren().addAll(titulo, subtitulo, instrucciones);
        root.setCenter(caja);
    }

    private void probarConexion() {
        try (Connection conn = DBConnection.getConnection()) {
            mostrarAlerta("Conexión correcta", "La conexión con la base de datos funciona.");
        } catch (Exception e) {
            mostrarAlerta("Error de conexión", "No se ha podido conectar: " + e.getMessage());
        }
    }

    private void mostrarVistaReservas() {
        VBox contenedor = new VBox(15);
        contenedor.setPadding(new Insets(20));

        Label titulo = new Label("Gestión de reservas");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        tablaReservas = crearTablaReservas();
        cargarReservasEnTabla();

        TitledPane formulario = new TitledPane("Nueva reserva", crearFormularioReserva());
        formulario.setExpanded(false);

        HBox botones = new HBox(10);

        Button btnRefrescar = new Button("Refrescar");
        btnRefrescar.setOnAction(e -> cargarReservasEnTabla());

        Button btnCancelar = new Button("Cancelar reserva");
        btnCancelar.setOnAction(e -> cancelarReservaSeleccionada());

        Button btnEliminar = new Button("Eliminar reserva");
        btnEliminar.setOnAction(e -> eliminarReservaSeleccionada());

        botones.getChildren().addAll(btnRefrescar, btnCancelar, btnEliminar);

        contenedor.getChildren().addAll(titulo, formulario, tablaReservas, botones);
        root.setCenter(contenedor);
    }

    private TableView<Reserva> crearTablaReservas() {
        TableView<Reserva> tabla = new TableView<>();

        TableColumn<Reserva, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdReserva()));

        TableColumn<Reserva, LocalDate> colFechaServicio = new TableColumn<>("Fecha servicio");
        colFechaServicio.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getFechaServicio()));

        TableColumn<Reserva, LocalTime> colHora = new TableColumn<>("Hora");
        colHora.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getHoraServicio()));

        TableColumn<Reserva, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getEstado()));

        TableColumn<Reserva, Integer> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdCliente()));

        TableColumn<Reserva, Integer> colPerro = new TableColumn<>("Perro");
        colPerro.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdPerro()));

        TableColumn<Reserva, Integer> colEmpleado = new TableColumn<>("Empleado");
        colEmpleado.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdEmpleado()));

        TableColumn<Reserva, Integer> colServicio = new TableColumn<>("Servicio");
        colServicio.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdServicio()));

        tabla.getColumns().addAll(colId, colFechaServicio, colHora, colEstado, colCliente, colPerro, colEmpleado, colServicio);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        return tabla;
    }

    private VBox crearFormularioReserva() {
        VBox formulario = new VBox(10);
        formulario.setPadding(new Insets(15));

        ComboBox<Cliente> cbClientes = new ComboBox<>();
        cbClientes.setPromptText("Selecciona un cliente");

        ComboBox<Perro> cbPerros = new ComboBox<>();
        cbPerros.setPromptText("Selecciona un perro");

        ComboBox<Servicio> cbServicios = new ComboBox<>();
        cbServicios.setPromptText("Selecciona un servicio");

        DatePicker dpFechaServicio = new DatePicker();
        dpFechaServicio.setPromptText("Fecha del servicio");

        TextField txtHora = new TextField();
        txtHora.setPromptText("Hora, ejemplo: 10:30");

        TextField txtEmpleado = new TextField();
        txtEmpleado.setPromptText("ID empleado, ejemplo: 1");

        TextArea txtObservaciones = new TextArea();
        txtObservaciones.setPromptText("Observaciones");
        txtObservaciones.setPrefRowCount(3);

        Button btnGuardar = new Button("Guardar reserva");

        List<Cliente> clientes = clienteDAO.listarClientes();
        cbClientes.setItems(FXCollections.observableArrayList(clientes));

        List<Servicio> servicios = servicioDAO.listarServiciosActivos();
        cbServicios.setItems(FXCollections.observableArrayList(servicios));

        cbClientes.setOnAction(e -> {
            Cliente clienteSeleccionado = cbClientes.getValue();

            if (clienteSeleccionado != null) {
                List<Perro> perros = perroDAO.listarPerrosPorCliente(clienteSeleccionado.getIdCliente());
                cbPerros.setItems(FXCollections.observableArrayList(perros));
            }
        });

        btnGuardar.setOnAction(e -> {
            try {
                Cliente cliente = cbClientes.getValue();
                Perro perro = cbPerros.getValue();
                Servicio servicio = cbServicios.getValue();

                if (cliente == null || perro == null || servicio == null || dpFechaServicio.getValue() == null) {
                    mostrarAlerta("Datos incompletos", "Debes seleccionar cliente, perro, servicio y fecha.");
                    return;
                }

                String horaTexto = txtHora.getText().trim();

                if (horaTexto.isEmpty()) {
                    mostrarAlerta("Hora obligatoria", "Debes escribir una hora. Ejemplo: 10:30");
                    return;
                }

                int idEmpleado = Integer.parseInt(txtEmpleado.getText().trim());

                Reserva reserva = new Reserva();
                reserva.setFechaReserva(LocalDate.now());
                reserva.setFechaServicio(dpFechaServicio.getValue());
                reserva.setHoraServicio(LocalTime.parse(horaTexto));
                reserva.setEstado("Pendiente");
                reserva.setObservaciones(txtObservaciones.getText());
                reserva.setIdCliente(cliente.getIdCliente());
                reserva.setIdPerro(perro.getIdPerro());
                reserva.setIdEmpleado(idEmpleado);
                reserva.setIdServicio(servicio.getIdServicio());

                boolean insertado = reservaDAO.insertarReserva(reserva);

                if (insertado) {
                    mostrarAlerta("Reserva creada", "La reserva se ha guardado correctamente.");
                    cargarReservasEnTabla();

                    cbClientes.setValue(null);
                    cbPerros.setValue(null);
                    cbServicios.setValue(null);
                    dpFechaServicio.setValue(null);
                    txtHora.clear();
                    txtEmpleado.clear();
                    txtObservaciones.clear();
                } else {
                    mostrarAlerta("Error", "No se ha podido guardar la reserva.");
                }

            } catch (NumberFormatException ex) {
                mostrarAlerta("Error en empleado", "El ID del empleado debe ser un número.");
            } catch (Exception ex) {
                mostrarAlerta("Error", "Revisa los datos introducidos: " + ex.getMessage());
            }
        });

        formulario.getChildren().addAll(
                new Label("Cliente:"), cbClientes,
                new Label("Perro:"), cbPerros,
                new Label("Servicio:"), cbServicios,
                new Label("Fecha servicio:"), dpFechaServicio,
                new Label("Hora servicio:"), txtHora,
                new Label("ID empleado:"), txtEmpleado,
                new Label("Observaciones:"), txtObservaciones,
                btnGuardar
        );

        return formulario;
    }

    private void cargarReservasEnTabla() {
        List<Reserva> reservas = reservaDAO.listarReservas();
        tablaReservas.setItems(FXCollections.observableArrayList(reservas));
    }

    private void cancelarReservaSeleccionada() {
        Reserva reserva = tablaReservas.getSelectionModel().getSelectedItem();

        if (reserva == null) {
            mostrarAlerta("Sin selección", "Selecciona una reserva de la tabla.");
            return;
        }

        boolean cancelada = reservaDAO.cancelarReserva(reserva.getIdReserva());

        if (cancelada) {
            mostrarAlerta("Reserva cancelada", "La reserva se ha marcado como cancelada.");
            cargarReservasEnTabla();
        } else {
            mostrarAlerta("Error", "No se ha podido cancelar la reserva.");
        }
    }

    private void eliminarReservaSeleccionada() {
        Reserva reserva = tablaReservas.getSelectionModel().getSelectedItem();

        if (reserva == null) {
            mostrarAlerta("Sin selección", "Selecciona una reserva de la tabla.");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText("¿Seguro que quieres eliminar la reserva?");
        confirmacion.setContentText("Esta acción eliminará la reserva de la base de datos.");

        confirmacion.showAndWait().ifPresent(respuesta -> {
            if (respuesta == ButtonType.OK) {
                boolean eliminada = reservaDAO.eliminarReserva(reserva.getIdReserva());

                if (eliminada) {
                    mostrarAlerta("Reserva eliminada", "La reserva se ha eliminado correctamente.");
                    cargarReservasEnTabla();
                } else {
                    mostrarAlerta("Error", "No se ha podido eliminar la reserva.");
                }
            }
        });
    }

    private void mostrarVistaClientes() {
        VBox contenedor = new VBox(15);
        contenedor.setPadding(new Insets(20));

        Label titulo = new Label("Listado de clientes");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        ListView<Cliente> lista = new ListView<>();
        lista.setItems(FXCollections.observableArrayList(clienteDAO.listarClientes()));

        contenedor.getChildren().addAll(titulo, lista);
        root.setCenter(contenedor);
    }

    private void mostrarVistaServicios() {
        VBox contenedor = new VBox(15);
        contenedor.setPadding(new Insets(20));

        Label titulo = new Label("Servicios activos");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        ListView<Servicio> lista = new ListView<>();
        lista.setItems(FXCollections.observableArrayList(servicioDAO.listarServiciosActivos()));

        contenedor.getChildren().addAll(titulo, lista);
        root.setCenter(contenedor);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}