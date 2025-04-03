package khalilMatrixDemo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.View;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MatrixCode2 
{
	
	static private int[][] matrix = new int[10][10];
	private JFrame frame;
	private JLabel[][] label = new JLabel[10][10];
	JButton buttonStart;

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() 
		{
	public void run()
	{
		try
		{
			View window = new View();
			window.frame.setVisible(true);
		}
		catch
		(Exception e)
		{
		e.printStackTrace();
		}
	}
	
		});

	}
	
	public void runSim()
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				if (i == 9)
				{
					matrix[i][j] = matrix[i][j] + matrix[0][j];
				}else
				{
					matrix[i][j] = matrix[i][j] + matrix[i + 1][j];
				}
				if (matrix[i][j] > 99999)
				{
					matrix[i][j] = matrix[i][j] % 12060;
				}
			}
		}
		updateDisplay();
	}
	
	public void updateDisplay()
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				if (matrix[i][j] < 50000)
				{
					label[i][j].setForeground(Color.GREEN);
				}else if (matrix[i][j] < 80000)
				{
					label[i][j].setForeground(Color.ORANGE);
				}else
				{
					label[i][j].setForeground(Color.RED);
				}
				label[i][j].setText(String.valueOf(matrix[i][j]));
			}
		}
	}
	
	public View()
	{
		initialize();
	}
	
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.BLACK);
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				label[i][j] = new JLabel("0");
				label[i][j].setBounds((i * 60), (j * 20), 60, 20);
				frame.getContentPane().add(label[i][j]);
			}
		}
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				matrix[i][j] = (int) (Math.random() * 10);
			}
		}
		
		buttonStart = new JButton("start");
		
		buttonStart.addActionListener(new ActionListener()
				{
			public void actionPerformed (ActionEvent arg0) 
			{
				runSim();
			}
				});
		
		buttonStart.setBounds(50, 450, 117, 25);
		frame.getContentPane().add(buttonStart);
		
		updateDisplay();
	}

}
