package holidays;

import holidays.model.UF;
import holidays.model.extraction.TypeExtraction;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static holidays.model.UF.getFormatedUf;
import static holidays.model.UF.ufExists;
import static org.apache.commons.lang3.StringUtils.stripAccents;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class Application {

    public static final String VERSION = "Holidays - 0.0.1";
    public static final String WELLCOME_MESSAGE = "Bem vindo ao Holidays.";
    public static final String MESSAGE_OPTIONS = "Selecione uma das opções a seguir.";

    private static JRadioButton all = new JRadioButton(TypeExtraction.ALL.getLabel(), false);
    private static JRadioButton allUf = new JRadioButton(TypeExtraction.ALL_UF.getLabel(), false);
    private static JRadioButton especific = new JRadioButton(TypeExtraction.ESPECIFIC_UF.getLabel(), false);
    private static JRadioButton national = new JRadioButton(TypeExtraction.NATIONAL.getLabel(), false);


    public static void main(String[] args) {

        actionToExtractAll();

        actionToExtractAllUf();

        actionToExtractEspecific();

        actionToExtractNational();

        //Este método deve ser o último a ser chamado no main.
        initFrame();

    }

    private static void actionToExtractNational() {
        national.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        all.setSelected(false);
                        allUf.setSelected(false);
                        especific.setSelected(false);
                        var confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente extrair todos feriados nacionais?");
                        if (confirm == 0) {
                            TypeExtraction.NATIONAL.extract(null);
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
                        all.setSelected(false);
                        allUf.setSelected(false);
                        national.setSelected(false);
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
                        all.setSelected(false);
                        especific.setSelected(false);
                        national.setSelected(false);
                        var confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente extrair todos feriados municipais?");
                        if (confirm == 0) {
                            TypeExtraction.ALL_UF.extract(null);
                        }
                    }
                }
        );
    }

    private static void actionToExtractAll() {
        all.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        allUf.setSelected(false);
                        especific.setSelected(false);
                        national.setSelected(false);
                        var confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente extrair todos feriados nacionais e municipais?");
                        if (confirm == 0) {
                            TypeExtraction.ALL.extract(null);
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
        frame.add(getRadiosButton());
        frame.add(getJPanelLabelOptions());
        frame.add(getJPanelWellCome());
        frame.setVisible(true);
    }

    private static JPanel getRadiosButton() {
        JPanel panel4 = new JPanel();
        panel4.setBounds(100, 250, 500, 30);
        panel4.add(all);
        panel4.add(allUf);
        panel4.add(especific);
        panel4.add(national);
        return panel4;
    }

    private static JPanel getJPanelLabelOptions() {
        JPanel panel3 = new JPanel();
        panel3.setBounds(200, 100, 300, 30);
        panel3.add(getjLabelOptions());
        return panel3;
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
