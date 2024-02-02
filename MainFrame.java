import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.stream.IntStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textName;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	
		
		
	}
	
	
	
	//Объявление имени героя
 public static String InputName(String caption) {
	 String names = JOptionPane.showInputDialog("Введите имя героя:");
	 return names;
 }
	/**
	 // Генерация числа урона
	 */public static int randomDamage() {
		 int[] damage = IntStream.rangeClosed(2,  30).toArray();
		int rnd1 = new Random().nextInt(damage.length);
		return rnd1;
		 
	 }
	public MainFrame() {
		setTitle("Battle");
		String name1 = InputName("");
		String name2 = InputName("");
		String message;
		int a = 0;
		int b = 0;;
		//жизнь первого героя
		int fuel1[] = new int[11];
		fuel1[0] =100;
		//жизнь второго героя
		int fuel2[] = new int[11];
		fuel2[0] = 100;
		//урон
		int damages[] = new int[30];
		
		//Количество урона
		for(int i=0; i<30; i++) {
			damages[i]=randomDamage();
		}
		//нахождение количества здоровья первого героя
		for(int i=0;i<10;i++){
			fuel1[i+1]=fuel1[i]-randomDamage();
			if(fuel1[i+1]<=0)
			 a = i;
		}
		//нахождение количества здоровья второго героя
		for(int i = 0; i<10;i++) {
			fuel2[i+1] = fuel2[i] -randomDamage();
			if(fuel2[i+1]<=0) {
				b = i;
			}
		}
		//определение победителя
		if(a>b) {
			message = name2 + " на  " + a + " ударе" ;
		}
		else {
			message = name1 + " на " + b + " ударе";
		}
		//определение героя, который нанесет удар первый
		int arr[] = {1, 2};
		int rnd = new Random().nextInt(arr.length);
		if(rnd == 1) {
			JOptionPane.showMessageDialog(null, "Первый удар наносит герой с именем " +  name1);
		}
		else {
			JOptionPane.showMessageDialog(null, "Первый удар наносит герой с именем " +  name2);
		}
		
			
		


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u041D\u043E\u043C\u0435\u0440 \u0443\u0434\u0430\u0440\u0430:", "\u0425\u0440 1 \u0433\u0435\u0440\u043E\u044F:", "\u0425\u0440 2 \u0433\u0435\u0440\u043E\u044F:"},
				{"0", fuel1[0], fuel2[0]},
				{"1", fuel1[1],fuel2[1]},
				{"2", fuel1[2],fuel2[2]},
				{"3",  fuel1[3],fuel2[3]},
				{"4",  fuel1[4],fuel2[4]},
				{"5",  fuel1[5],fuel2[5]},
				{"6", fuel1[6],fuel2[6]},
				{"7", fuel1[7],fuel2[7]},
				{"8",  fuel1[8],fuel2[8]},
				{"9",  fuel1[9],fuel2[9]},
				{"10",  fuel1[10],fuel2[10]},
			},
			new String[] {
				"", "", ""
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(10, 150, 484, 202);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Battle");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(289, 11, 57, 30);
		contentPane.add(lblNewLabel);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u0413\u0435\u0440\u043E\u0439:", "\u0413\u0435\u0440\u043E\u0439 1:", "\u0413\u0435\u0440\u043E\u0439 2:"},
				{"\u0418\u043C\u044F \u0433\u0435\u0440\u043E\u044F:", name1, name2},
			},
			new String[] {
				"", "New column", "New column"
			}
		));
		table_1.setEnabled(false);
		table_1.setBounds(10, 22, 225, 32);
		contentPane.add(table_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(504, 11, 120, 439);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Победил герой с именем:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 381, 257, 19);
		contentPane.add(lblNewLabel_1);
		
		textName = new JTextField();
		textName.setEditable(false);
		textName.setBounds(189, 382, 137, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		textName.setText(message);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/4f51d4cfaf8279265ecbfc34117603d90efdf4a1_medium.jpg")));
		lblNewLabel_2.setBounds(388, 36, 88, 93);
		contentPane.add(lblNewLabel_2);
	}
}
