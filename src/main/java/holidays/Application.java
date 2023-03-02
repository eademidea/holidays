package holidays;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import holidays.model.extraction.TypeExtraction;
import org.apache.commons.lang3.StringUtils;

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
    public static final String WELLCOME_MESSAGE = "Bem vindo ao Holidays.";
    public static final String MESSAGE_OPTIONS = "Selecione uma das opções a seguir.";
    private static JRadioButton allUf = new JRadioButton(TypeExtraction.ALL_UF.getLabel(), false);
    private static JRadioButton especific = new JRadioButton(TypeExtraction.ESPECIFIC_UF.getLabel(), false);
    private static JRadioButton national = new JRadioButton(TypeExtraction.NATIONAL.getLabel(), false);

    private static JRadioButton unity = new JRadioButton(TypeExtraction.UNITY.getLabel(), false);


    public static void main(String[] args) {
        actionToExtractUnity();

        actionToExtractAllUf();

        actionToExtractEspecific();

        actionToExtractNational();

        //Este método deve ser o último a ser chamado no main.
        initFrame();

    }

    private static void actionToExtractUnity() {
        unity.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        allUf.setSelected(false);
                        especific.setSelected(false);
                        national.setSelected(false);
                        File file = getFileChosed();
                        try {
                            Reader fileRead = Files.newBufferedReader(Paths.get(file.getPath()));
                            CSVReader csvReader = new CSVReaderBuilder(fileRead).build();
                            List<String[]> lines = csvReader.readAll();
                            TypeExtraction.ESPECIFIC_UF.extract(lines);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
//                        if (confirm == 0) {
//                            TypeExtraction.UNITY.extract(null);
//                        }
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
                        allUf.setSelected(false);
                        especific.setSelected(false);
                        unity.setSelected(false);
                        var confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente extrair todos feriados nacionais?");
                        if (confirm == 0) {
                            TypeExtraction.NATIONAL.extract();
                        }
                    }
                }
        );
    }

    private static void actionToExtractEspecific() {
        especific.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        allUf.setSelected(false);
                        national.setSelected(false);
                        unity.setSelected(false);
                        var uf = JOptionPane.showInputDialog("Informe o UF que deseja extrair (Exemplo: MG): ");
                        if (ufExists(uf)) {
                            TypeExtraction.ESPECIFIC_UF.extract(getFormatedUf(uf));
                        } else {
                            JOptionPane.showMessageDialog(null, "UF Informada não existe...");
                        }
                    }
                }
        );
    }


    private static void actionToExtractAllUf() {
        allUf.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        especific.setSelected(false);
                        national.setSelected(false);
                        unity.setSelected(false);
                        var confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente extrair todos feriados municipais?");
                        if (confirm == 0) {
                            TypeExtraction.ALL_UF.extract();
                        }
                    }
                }
        );
    }


    /**
     * Inicializa todos os componentes e comportamentos da tela...
     */
    private static void initFrame() {
        JFrame frame = new JFrame(VERSION);
        frame.setSize(700, 500);
        frame.setResizable(false);
        frame.add(getPanelRadiosButton());
        frame.add(getJPanelLabelOptions());
        frame.add(getJPanelWellCome());
        frame.setVisible(true);
    }

    private static JPanel getPanelRadiosButton() {
        JPanel panel = new JPanel();
        panel.setBounds(50, 250, 600, 30);
        panel.add(allUf);
        panel.add(especific);
        panel.add(national);
        panel.add(unity);
        return panel;
    }

    private static JPanel getJPanelLabelOptions() {
        JPanel panel = new JPanel();
        panel.setBounds(200, 100, 300, 30);
        panel.add(getjLabelOptions());
        return panel;
    }

    private static JPanel getJPanelWellCome() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 50, 500, 30);
        panel.add(getjLabelWellCome());
        return panel;
    }

    private static JLabel getjLabelOptions() {
        return new JLabel(MESSAGE_OPTIONS);
    }

    private static JLabel getjLabelWellCome() {
        var response = new JLabel(WELLCOME_MESSAGE);
        response.setBounds(0, 0, 200, 30);
        return response;
    }

}
