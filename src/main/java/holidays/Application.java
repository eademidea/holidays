package holidays;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import holidays.model.extraction.TypeExtraction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static holidays.model.UF.getFormatedUf;
import static holidays.model.UF.ufExists;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class Application {

    public static final String VERSION = "Holidays - 0.0.1";
    public static final String MESSAGE_OPTIONS = "Selecione uma das opções a seguir.";

    private static JRadioButton specific = new JRadioButton(TypeExtraction.SPECIFIC.getLabel(), false);
    private static JRadioButton national = new JRadioButton(TypeExtraction.NATIONAL.getLabel(), false);
    private static JRadioButton unity = new JRadioButton(TypeExtraction.UNITY.getLabel(), false);


    public static void main(String[] args) {

        actionToExtractUnity();

        actionToExtractSpecificUf();

        actionToExtractNational();

        initFrame();

    }

    private static void actionToExtractUnity() {
        unity.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        specific.setSelected(false);
                        national.setSelected(false);
                        File file = getFileChosed();
                        try {
                            Reader fileRead = Files.newBufferedReader(Paths.get(file.getPath()));
                            CSVReader csvReader = new CSVReaderBuilder(fileRead).build();
                            List<String[]> lines = csvReader.readAll();
                            TypeExtraction.UNITY.extract(lines);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(null, "Extração concluída...");
                        System.exit(0);
                    }

                    private File getFileChosed() {
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        fileChooser.showOpenDialog(null);
                        File file = fileChooser.getSelectedFile();
                        return file;
                    }
                }
        );
    }

    private static void actionToExtractNational() {
        national.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        specific.setSelected(false);
                        unity.setSelected(false);
                        var confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente extrair todos feriados nacionais?");
                        if (confirm == 0) {
                            TypeExtraction.NATIONAL.extract();
                            JOptionPane.showMessageDialog(null, "Extração concluída...");
                        }
                        System.exit(0);
                    }
                }
        );
    }

    private static void actionToExtractSpecificUf() {
        specific.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        national.setSelected(false);
                        unity.setSelected(false);
                        var uf = JOptionPane.showInputDialog("Informe o UF que deseja extrair (Exemplo: MG): ");
                        if (ufExists(uf)) {
                            TypeExtraction.SPECIFIC.extract(getFormatedUf(uf));
                            JOptionPane.showMessageDialog(null, "Extração concluída...");
                        } else {
                            JOptionPane.showMessageDialog(null, "UF Informada não existe...");
                        }
                        System.exit(0);
                    }
                }
        );
    }


    /**
     * Inicializa todos os componentes e comportamentos da tela...
     */
    private static void initFrame() {
        JFrame frame = new JFrame(VERSION);
        frame.setBounds(50, 50, 700, 150);
        frame.setResizable(false);
        frame.add(getPanelRadiosButton());
        frame.add(getJPanelLabelOptions());
        frame.setVisible(true);
    }

    private static JPanel getPanelRadiosButton() {
        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 600, 30);
        panel.add(specific);
        panel.add(national);
        panel.add(unity);
        return panel;
    }

    private static JPanel getJPanelLabelOptions() {
        JPanel panel = new JPanel();
        panel.setBounds(200, 30, 300, 30);
        panel.add(getjLabelOptions());
        return panel;
    }


    private static JLabel getjLabelOptions() {
        return new JLabel(MESSAGE_OPTIONS);
    }


}
