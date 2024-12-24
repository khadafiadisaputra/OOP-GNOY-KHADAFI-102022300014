import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PenyimpananController {

    @FXML
    private TextField Namaartist;

    @FXML
    private TextField Judul;

    @FXML
    private TextField Rented;

    @FXML
    private TextField Total;

    @FXML
    private TableView<Album> tabel;

    private ObservableList<Album> albumList;

    @FXML
    public void initialize() {
        albumList = FXCollections.observableArrayList();

        TableColumn<Album, String> colJudul = new TableColumn<>("Album Name");
        colJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));

        TableColumn<Album, String> colArtis = new TableColumn<>("Artist");
        colArtis.setCellValueFactory(new PropertyValueFactory<>("namaartist"));

        TableColumn<Album, Integer> colRented = new TableColumn<>("Available");
        colRented.setCellValueFactory(new PropertyValueFactory<>("rented"));

        TableColumn<Album, Integer> colTotal = new TableColumn<>("Total");
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        tabel.getColumns().addAll(colArtis, colJudul, colRented, colTotal);
        tabel.setItems(albumList);
    }

    @FXML
    void Hapus(ActionEvent event) {
        Album selectedAlbum = tabel.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            albumList.remove(selectedAlbum);
        } else {
            showAlert("Kesalahan", "Tidak ada album yang dipilih", "Silakan pilih album yang ingin dihapus.");
        }
    }

    @FXML
    void Tambah(ActionEvent event) {
        try {
            String artist = Namaartist.getText().trim();
            String title = Judul.getText().trim();
            int rented = Integer.parseInt(Rented.getText().trim());
            int total = Integer.parseInt(Total.getText().trim());

            if (artist.isEmpty() || title.isEmpty()) {
                showAlert("Kesalahan", "Input tidak valid", "Nama artist dan judul tidak boleh kosong.");
                return;
            }

            if (rented > total) {
                showAlert("Kesalahan", "Input tidak valid", "Jumlah yang disewa tidak boleh lebih besar dari total.");
                return;
            }

            Album newAlbum = new Album(rented, total, artist, title);
            albumList.add(newAlbum);

            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Kesalahan", "Input tidak valid", "Pastikan semua data diisi dengan benar (angka untuk rented dan total).");
        }
    }

    @FXML
    void Update(ActionEvent event) {
        Album selectedAlbum = tabel.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            try {
                String artist = Namaartist.getText().trim();
                String title = Judul.getText().trim();
                int rented = Integer.parseInt(Rented.getText().trim());
                int total = Integer.parseInt(Total.getText().trim());

                if (artist.isEmpty() || title.isEmpty()) {
                    showAlert("Kesalahan", "Input tidak valid", "Nama artist dan judul tidak boleh kosong.");
                    return;
                }

                if (rented > total) {
                    showAlert("Kesalahan", "Input tidak valid", "Jumlah yang disewa tidak boleh lebih besar dari total.");
                    return;
                }

                selectedAlbum.setNamaartist(artist);
                selectedAlbum.setJudul(title);
                selectedAlbum.setRented(rented);
                selectedAlbum.setTotal(total);

                tabel.refresh();
                clearFields();
            } catch (NumberFormatException e) {
                showAlert("Kesalahan", "Input tidak valid", "Pastikan semua data diisi dengan benar (angka untuk rented dan total).");
            }
        } else {
            showAlert("Kesalahan", "Tidak ada album yang dipilih", "Silakan pilih album yang ingin diperbarui.");
        }
    }

    @FXML
    void Rent(ActionEvent event) {
        Album selectedAlbum = tabel.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            if (selectedAlbum.getRented() < selectedAlbum.getTotal()) {
                selectedAlbum.setRented(selectedAlbum.getRented() + 1);
                tabel.refresh();
            } else {
                showAlert("Kesalahan", "Album tidak tersedia", "Semua salinan album sedang disewa.");
            }
        } else {
            showAlert("Kesalahan", "Tidak ada album yang dipilih", "Silakan pilih album yang ingin disewa.");
        }
    }

    private void clearFields() {
        Namaartist.clear();
        Judul.clear();
        Rented.clear();
        Total.clear();
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
