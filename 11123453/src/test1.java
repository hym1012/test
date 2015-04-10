import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class test1 extends Applet 
{
	//String info;
	JPanel pLeft=new JPanel(new GridLayout(5,0));
	MyPanel pRight=new MyPanel(new GridLayout(0,1));  
	int row=0,num=0,space=0;
	static double buttonNum=0;
	int red,yellow,blue;

	JButton b1=new JButton("1");
	JButton b3=new JButton("3");
	JButton b5=new JButton("5");
	JButton b7=new JButton("7");
	JButton b9=new JButton("9");
	public test1()
	{
		setLayout(new GridLayout(0,2));
		b1.addActionListener(new process());
		b3.addActionListener(new process());
		b5.addActionListener(new process());
		b7.addActionListener(new process());
		b9.addActionListener(new process());

		pLeft.add(b1);
		pLeft.add(b3);
		pLeft.add(b5);
		pLeft.add(b7);
		pLeft.add(b9);
		add(pLeft);
		add(pRight);
	}
	
	class MyPanel extends JPanel
	{	//自定义MyPanel继承JPanel
		MyPanel(LayoutManager layout)
		{
			super(layout);			//调用父类也就是JPanel类的构造函数进行构造，相当对不改变构造函数
		}

		@Override
		public void paint(Graphics g) 
		{		//重写paint()函数
			// TODO Auto-generated method stub
			super.paint(g);
			g.setFont(new Font("宋体",Font.BOLD,30));
			for(row=1;row<=buttonNum;row++)
			{
				if(row<=buttonNum/2+1)
				{
					for(space=1;space<=Math.ceil(buttonNum/2)-row;space++)
					{
						g.drawString(" ", space*12, space*12);
					}
					
					for(num=1;num<2*row;num++)
					{
						red=(int)Math.floor(Math.random()*256);
						yellow=(int)Math.floor(Math.random()*256);
						blue=(int)Math.floor(Math.random()*256);
						g.setColor(new Color(red,yellow,blue));
						g.drawString(Integer.toString(row), (space+num)*24, row*24);
					}
						
				}
				else
				{
					for(space=1;space<=row-Math.ceil(buttonNum/2);space++)
						g.drawString(" ", space*10, space*10);
					
					for(num=1;num<=2*(buttonNum-row)+1;num++)
					{
						red=(int)Math.floor(Math.random()*256);
						yellow=(int)Math.floor(Math.random()*256);
						blue=(int)Math.floor(Math.random()*256);
						g.setColor(new Color(red,yellow,blue));
						g.drawString(Integer.toString(row), (space+num)*24, row*24);
					}
				}
			}
		}
	}
	class process implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			pRight.updateUI();//点击按钮后，让右边的界面刷新
			if(e.getSource()==b1)
				buttonNum=1;
			if(e.getSource()==b3)
				buttonNum=3;
			if(e.getSource()==b5)
				buttonNum=5;
			if(e.getSource()==b7)
				buttonNum=7;
			if(e.getSource()==b9)
				buttonNum=9;
		}
	}
}
